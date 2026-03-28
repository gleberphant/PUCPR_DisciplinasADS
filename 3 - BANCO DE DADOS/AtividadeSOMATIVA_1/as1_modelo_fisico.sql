-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema PUC_SOMATIVA1
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `PUC_SOMATIVA1` ;

-- -----------------------------------------------------
-- Schema PUC_SOMATIVA1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `PUC_SOMATIVA1` DEFAULT CHARACTER SET utf8mb3 ;
USE `PUC_SOMATIVA1` ;

-- -----------------------------------------------------
-- Table `PUC_SOMATIVA1`.`estados`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PUC_SOMATIVA1`.`estados` ;

CREATE TABLE IF NOT EXISTS `PUC_SOMATIVA1`.`estados` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `sigla` VARCHAR(3) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PUC_SOMATIVA1`.`cidades`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PUC_SOMATIVA1`.`cidades` ;

CREATE TABLE IF NOT EXISTS `PUC_SOMATIVA1`.`cidades` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  `estado_id` INT UNSIGNED NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_cidades_estados`
    FOREIGN KEY (`estado_id`)
    REFERENCES `PUC_SOMATIVA1`.`estados` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

CREATE INDEX `fk_estado_id_idx` ON `PUC_SOMATIVA1`.`cidades` (`estado_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `PUC_SOMATIVA1`.`bairros`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PUC_SOMATIVA1`.`bairros` ;

CREATE TABLE IF NOT EXISTS `PUC_SOMATIVA1`.`bairros` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `cidade_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_bairros_cidades`
    FOREIGN KEY (`cidade_id`)
    REFERENCES `PUC_SOMATIVA1`.`cidades` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_bairros_cidades_idx` ON `PUC_SOMATIVA1`.`bairros` (`cidade_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `PUC_SOMATIVA1`.`ruas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PUC_SOMATIVA1`.`ruas` ;

CREATE TABLE IF NOT EXISTS `PUC_SOMATIVA1`.`ruas` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  `bairro_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_ruas_bairros`
    FOREIGN KEY (`bairro_id`)
    REFERENCES `PUC_SOMATIVA1`.`bairros` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

CREATE INDEX `fk_ruas_bairros_idx` ON `PUC_SOMATIVA1`.`ruas` (`bairro_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `PUC_SOMATIVA1`.`enderecos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PUC_SOMATIVA1`.`enderecos` ;

CREATE TABLE IF NOT EXISTS `PUC_SOMATIVA1`.`enderecos` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `rua_id` INT UNSIGNED NOT NULL,
  `cep` VARCHAR(10) NOT NULL DEFAULT '00000000',
  `numero` VARCHAR(10) NOT NULL DEFAULT 'Sem Numero',
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_enderecos_ruas`
    FOREIGN KEY (`rua_id`)
    REFERENCES `PUC_SOMATIVA1`.`ruas` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

CREATE INDEX `rua_id_idx` ON `PUC_SOMATIVA1`.`enderecos` (`rua_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `PUC_SOMATIVA1`.`pessoas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PUC_SOMATIVA1`.`pessoas` ;

CREATE TABLE IF NOT EXISTS `PUC_SOMATIVA1`.`pessoas` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  `telefone` VARCHAR(45) NULL DEFAULT NULL,
  `endereco_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_pessoas_enderecos`
    FOREIGN KEY (`endereco_id`)
    REFERENCES `PUC_SOMATIVA1`.`enderecos` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

CREATE INDEX `endereco_id_idx` ON `PUC_SOMATIVA1`.`pessoas` (`endereco_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `PUC_SOMATIVA1`.`clientes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PUC_SOMATIVA1`.`clientes` ;

CREATE TABLE IF NOT EXISTS `PUC_SOMATIVA1`.`clientes` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `pessoa_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`, `pessoa_id`),
  CONSTRAINT `fk_clientes_pessoas`
    FOREIGN KEY (`pessoa_id`)
    REFERENCES `PUC_SOMATIVA1`.`pessoas` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

CREATE INDEX `pessoa_id_idx` ON `PUC_SOMATIVA1`.`clientes` (`pessoa_id` ASC) VISIBLE;

CREATE UNIQUE INDEX `pessoa_id_UNIQUE` ON `PUC_SOMATIVA1`.`clientes` (`pessoa_id` ASC) VISIBLE;

CREATE UNIQUE INDEX `id_UNIQUE` ON `PUC_SOMATIVA1`.`clientes` (`id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `PUC_SOMATIVA1`.`funcionarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PUC_SOMATIVA1`.`funcionarios` ;

CREATE TABLE IF NOT EXISTS `PUC_SOMATIVA1`.`funcionarios` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `pessoa_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_funcionarios_pessoas`
    FOREIGN KEY (`pessoa_id`)
    REFERENCES `PUC_SOMATIVA1`.`pessoas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'funcionários da empresa.\num funcionario pode exercer uma ou mais cargos.\n';

CREATE INDEX `fk_pessoa_id_idx` ON `PUC_SOMATIVA1`.`funcionarios` (`pessoa_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `PUC_SOMATIVA1`.`entregadores`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PUC_SOMATIVA1`.`entregadores` ;

CREATE TABLE IF NOT EXISTS `PUC_SOMATIVA1`.`entregadores` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `funcionario_id` INT UNSIGNED NOT NULL COMMENT 'cargos de entregadores.\ncada linha corresponde a um cargo de entregador ocupado por um funcionario\num mesmo funcionario nao pode exercer dois cargos iguais\nchave estrangeira é chave primária de valor único.',
  PRIMARY KEY (`id`, `funcionario_id`),
  CONSTRAINT `fk_entregadores_funcionarios`
    FOREIGN KEY (`funcionario_id`)
    REFERENCES `PUC_SOMATIVA1`.`funcionarios` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3
COMMENT = 'funcionários que ocupam o cargo de entregador\num cargo so pode ser exercido por um funcionário\n';

CREATE INDEX `fk_entregadores_funcionarios_idx` ON `PUC_SOMATIVA1`.`entregadores` (`funcionario_id` ASC) VISIBLE;

CREATE UNIQUE INDEX `funcionario_id_UNIQUE` ON `PUC_SOMATIVA1`.`entregadores` (`funcionario_id` ASC) VISIBLE;

CREATE UNIQUE INDEX `id_UNIQUE` ON `PUC_SOMATIVA1`.`entregadores` (`id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `PUC_SOMATIVA1`.`ingredientes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PUC_SOMATIVA1`.`ingredientes` ;

CREATE TABLE IF NOT EXISTS `PUC_SOMATIVA1`.`ingredientes` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `tipo` ENUM('vegetal', 'animal', 'tempero', 'outro') NOT NULL,
  `estoque` INT NOT NULL DEFAULT '0' COMMENT 'estoque se refere a quantidade de porcoes do ingrediente\\n',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `PUC_SOMATIVA1`.`pedidos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PUC_SOMATIVA1`.`pedidos` ;

CREATE TABLE IF NOT EXISTS `PUC_SOMATIVA1`.`pedidos` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `cliente_id` INT UNSIGNED NOT NULL,
  `entregador_id` INT UNSIGNED NOT NULL,
  `endereco_id` INT UNSIGNED NOT NULL,
  `data_pedido` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `instrucoes` TEXT NULL DEFAULT NULL COMMENT 'observações gerais do pedido, tais como instrução de entrega. ',
  `status` ENUM('aberto', 'preparo', 'deslocamento', 'entregue', 'cancelado') NOT NULL DEFAULT 'aberto' COMMENT 'flag do status do pedido\\n1 - aberto: produto iniciado\\n2 - producao: quando iniciar a producao\\n3 - deslocamento: quando sair para entrega\\n4 - entregue: quando o cliente receber\\n5 - cancelado: quando for cancelado por algum motivo',
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_pedidos_clientes`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `PUC_SOMATIVA1`.`clientes` (`id`),
  CONSTRAINT `fk_pedidos_enderecos`
    FOREIGN KEY (`endereco_id`)
    REFERENCES `PUC_SOMATIVA1`.`enderecos` (`id`),
  CONSTRAINT `fk_pedidos_entregadores`
    FOREIGN KEY (`entregador_id`)
    REFERENCES `PUC_SOMATIVA1`.`entregadores` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

CREATE INDEX `cliente_id_idx` ON `PUC_SOMATIVA1`.`pedidos` (`cliente_id` ASC) VISIBLE;

CREATE INDEX `entregador_id_idx` ON `PUC_SOMATIVA1`.`pedidos` (`entregador_id` ASC) VISIBLE;

CREATE INDEX `endereco_id_idx` ON `PUC_SOMATIVA1`.`pedidos` (`endereco_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `PUC_SOMATIVA1`.`categorias_de_produto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PUC_SOMATIVA1`.`categorias_de_produto` ;

CREATE TABLE IF NOT EXISTS `PUC_SOMATIVA1`.`categorias_de_produto` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `descricao` TINYTEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `nome_UNIQUE` ON `PUC_SOMATIVA1`.`categorias_de_produto` (`nome` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `PUC_SOMATIVA1`.`produtos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PUC_SOMATIVA1`.`produtos` ;

CREATE TABLE IF NOT EXISTS `PUC_SOMATIVA1`.`produtos` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  `preco` DECIMAL(6,2) NULL DEFAULT NULL,
  `descricao` TINYTEXT NULL DEFAULT NULL,
  `disponivel` TINYINT NULL DEFAULT '1' COMMENT 'variavel booleana para definir se um produto esta disponível para venda.',
  `categoria_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_produtos_categorias`
    FOREIGN KEY (`categoria_id`)
    REFERENCES `PUC_SOMATIVA1`.`categorias_de_produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

CREATE INDEX `fk_categoria_produto_idx` ON `PUC_SOMATIVA1`.`produtos` (`categoria_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `PUC_SOMATIVA1`.`preparadores`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PUC_SOMATIVA1`.`preparadores` ;

CREATE TABLE IF NOT EXISTS `PUC_SOMATIVA1`.`preparadores` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `funcionario_id` INT UNSIGNED NOT NULL COMMENT 'cargos de preparadores\ncada linha corresponde a um cargo de preparadorocupado por um funcionario\num mesmo funcionario nao pode exercer dois cargos iguais\nchave estrangeira é chave primária de valor único.',
  PRIMARY KEY (`id`, `funcionario_id`),
  CONSTRAINT `fk_preparadores_funcionarios`
    FOREIGN KEY (`funcionario_id`)
    REFERENCES `PUC_SOMATIVA1`.`funcionarios` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3
COMMENT = 'funcionários que ocupam o cargo de preparador\num cargo so pode ser exercido por um funcionário\n';

CREATE INDEX `fk_preparadores_funcionarios_idx` ON `PUC_SOMATIVA1`.`preparadores` (`funcionario_id` ASC) VISIBLE;

CREATE UNIQUE INDEX `funcionario_id_UNIQUE` ON `PUC_SOMATIVA1`.`preparadores` (`funcionario_id` ASC) VISIBLE;

CREATE UNIQUE INDEX `id_UNIQUE` ON `PUC_SOMATIVA1`.`preparadores` (`id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `PUC_SOMATIVA1`.`pedido_produto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PUC_SOMATIVA1`.`pedido_produto` ;

CREATE TABLE IF NOT EXISTS `PUC_SOMATIVA1`.`pedido_produto` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `pedido_id` INT UNSIGNED NOT NULL,
  `produto_id` INT UNSIGNED NOT NULL,
  `preparador_id` INT UNSIGNED NOT NULL COMMENT 'cada item do pedido pode ser preparado por um funcionário diferente.',
  `observacoes` TINYTEXT NULL COMMENT 'cada item do pedido pode ter suas respectivas observações. Exemplo : \"carne bem passada\" ou \"sem molho\" etc\n',
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_pedidos_produtos`
    FOREIGN KEY (`pedido_id`)
    REFERENCES `PUC_SOMATIVA1`.`pedidos` (`id`),
  CONSTRAINT `fk_produtos_pedidos`
    FOREIGN KEY (`produto_id`)
    REFERENCES `PUC_SOMATIVA1`.`produtos` (`id`),
  CONSTRAINT `fk_produtos_preparadores`
    FOREIGN KEY (`preparador_id`)
    REFERENCES `PUC_SOMATIVA1`.`preparadores` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3
COMMENT = 'itens do pedido\ncada linha corresponde a um item de um pedido\n\n\n';

CREATE INDEX `fk_pedidos_produtos_idx` ON `PUC_SOMATIVA1`.`pedido_produto` (`pedido_id` ASC) VISIBLE;

CREATE INDEX `fk_produtos_pedidos_idx` ON `PUC_SOMATIVA1`.`pedido_produto` (`produto_id` ASC) VISIBLE;

CREATE INDEX `fk_produtos_preparadores_idx` ON `PUC_SOMATIVA1`.`pedido_produto` (`preparador_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `PUC_SOMATIVA1`.`produto_ingrediente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PUC_SOMATIVA1`.`produto_ingrediente` ;

CREATE TABLE IF NOT EXISTS `PUC_SOMATIVA1`.`produto_ingrediente` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `produto_id` INT UNSIGNED NOT NULL,
  `ingrediente_id` INT UNSIGNED NOT NULL,
  `quantidade_ingrediente` FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_ingredientes_produtos`
    FOREIGN KEY (`ingrediente_id`)
    REFERENCES `PUC_SOMATIVA1`.`ingredientes` (`id`),
  CONSTRAINT `fk_produtos_ingredientes`
    FOREIGN KEY (`produto_id`)
    REFERENCES `PUC_SOMATIVA1`.`produtos` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3
COMMENT = ' receita dos produtos\n';

CREATE INDEX `produto_id_idx` ON `PUC_SOMATIVA1`.`produto_ingrediente` (`produto_id` ASC) VISIBLE;

CREATE INDEX `ingrediente_id_idx` ON `PUC_SOMATIVA1`.`produto_ingrediente` (`ingrediente_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `PUC_SOMATIVA1`.`entregador_bairro`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PUC_SOMATIVA1`.`entregador_bairro` ;

CREATE TABLE IF NOT EXISTS `PUC_SOMATIVA1`.`entregador_bairro` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `entregador_id` INT UNSIGNED NOT NULL,
  `bairro_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_entregadores_bairros`
    FOREIGN KEY (`entregador_id`)
    REFERENCES `PUC_SOMATIVA1`.`entregadores` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_bairros_entregadores`
    FOREIGN KEY (`bairro_id`)
    REFERENCES `PUC_SOMATIVA1`.`bairros` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'região de entrega de um entregador\nbairros em que um entregador trabalha';

CREATE INDEX `fk_bairros_entregadores_idx` ON `PUC_SOMATIVA1`.`entregador_bairro` (`bairro_id` ASC) VISIBLE;

CREATE INDEX `fk_entregadores_bairros_idx` ON `PUC_SOMATIVA1`.`entregador_bairro` (`entregador_id` ASC) VISIBLE;

USE `PUC_SOMATIVA1` ;

-- -----------------------------------------------------
-- Placeholder table for view `PUC_SOMATIVA1`.`historico_pedidos_por_cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PUC_SOMATIVA1`.`historico_pedidos_por_cliente` (`id` INT, `data_pedido` INT, `instrucoes` INT, `status` INT);

-- -----------------------------------------------------
-- Placeholder table for view `PUC_SOMATIVA1`.`lista_de_produtos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PUC_SOMATIVA1`.`lista_de_produtos` (`id` INT, `data_pedido` INT, `instrucoes` INT, `status` INT, `nome` INT, `preco` INT);

-- -----------------------------------------------------
-- View `PUC_SOMATIVA1`.`historico_pedidos_por_cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PUC_SOMATIVA1`.`historico_pedidos_por_cliente`;
DROP VIEW IF EXISTS `PUC_SOMATIVA1`.`historico_pedidos_por_cliente` ;
USE `PUC_SOMATIVA1`;
CREATE  OR REPLACE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`%` 
    SQL SECURITY DEFINER
VIEW `PUC_SOMATIVA1`.`historico_pedidos_por_cliente` AS
    SELECT 
        `PUC_SOMATIVA1`.`pedidos`.`id` AS `id`,
        `PUC_SOMATIVA1`.`pedidos`.`data_pedido` AS `data_pedido`,
        `PUC_SOMATIVA1`.`pedidos`.`instrucoes` AS `instrucoes`,
        `PUC_SOMATIVA1`.`pedidos`.`status` AS `status`
    FROM
        `PUC_SOMATIVA1`.`pedidos`
    ORDER BY `PUC_SOMATIVA1`.`pedidos`.`cliente_id`;

-- -----------------------------------------------------
-- View `PUC_SOMATIVA1`.`lista_de_produtos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PUC_SOMATIVA1`.`lista_de_produtos`;
DROP VIEW IF EXISTS `PUC_SOMATIVA1`.`lista_de_produtos` ;
USE `PUC_SOMATIVA1`;
CREATE  OR REPLACE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`%` 
    SQL SECURITY DEFINER
VIEW `PUC_SOMATIVA1`.`lista_de_produtos` AS
    SELECT 
        `PUC_SOMATIVA1`.`pedidos`.`id` AS `id`,
        `PUC_SOMATIVA1`.`pedidos`.`data_pedido` AS `data_pedido`,
        `PUC_SOMATIVA1`.`pedidos`.`instrucoes` AS `instrucoes`,
        `PUC_SOMATIVA1`.`pedidos`.`status` AS `status`,
        `PUC_SOMATIVA1`.`produtos`.`nome` AS `nome`,
        `PUC_SOMATIVA1`.`produtos`.`preco` AS `preco`
    FROM
        ((`PUC_SOMATIVA1`.`produtos`
        JOIN `PUC_SOMATIVA1`.`pedido_produto` ON ((`PUC_SOMATIVA1`.`pedido_produto`.`produto_id` = `PUC_SOMATIVA1`.`produtos`.`id`)))
        JOIN `PUC_SOMATIVA1`.`pedidos` ON ((`PUC_SOMATIVA1`.`pedido_produto`.`pedido_id` = `PUC_SOMATIVA1`.`pedidos`.`id`)));

-- -----------------------------------------------------
-- Data for table `PUC_SOMATIVA1`.`estados`
-- -----------------------------------------------------
START TRANSACTION;
USE `PUC_SOMATIVA1`;
INSERT INTO `PUC_SOMATIVA1`.`estados` (`id`, `nome`, `sigla`) VALUES (DEFAULT, 'paraiba', 'pb');

COMMIT;


-- -----------------------------------------------------
-- Data for table `PUC_SOMATIVA1`.`cidades`
-- -----------------------------------------------------
START TRANSACTION;
USE `PUC_SOMATIVA1`;
INSERT INTO `PUC_SOMATIVA1`.`cidades` (`id`, `nome`, `estado_id`) VALUES (DEFAULT, 'jão pessoa', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `PUC_SOMATIVA1`.`bairros`
-- -----------------------------------------------------
START TRANSACTION;
USE `PUC_SOMATIVA1`;
INSERT INTO `PUC_SOMATIVA1`.`bairros` (`id`, `nome`, `cidade_id`) VALUES (1, 'miramar', 1);
INSERT INTO `PUC_SOMATIVA1`.`bairros` (`id`, `nome`, `cidade_id`) VALUES (2, 'tambau', 1);
INSERT INTO `PUC_SOMATIVA1`.`bairros` (`id`, `nome`, `cidade_id`) VALUES (3, 'cabo branco', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `PUC_SOMATIVA1`.`ruas`
-- -----------------------------------------------------
START TRANSACTION;
USE `PUC_SOMATIVA1`;
INSERT INTO `PUC_SOMATIVA1`.`ruas` (`id`, `nome`, `bairro_id`) VALUES (DEFAULT, 'rua dom pedro 1', 1);
INSERT INTO `PUC_SOMATIVA1`.`ruas` (`id`, `nome`, `bairro_id`) VALUES (DEFAULT, 'rua dom pedro 2', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `PUC_SOMATIVA1`.`enderecos`
-- -----------------------------------------------------
START TRANSACTION;
USE `PUC_SOMATIVA1`;
INSERT INTO `PUC_SOMATIVA1`.`enderecos` (`id`, `rua_id`, `cep`, `numero`) VALUES (DEFAULT, 1, '1231212', '111');
INSERT INTO `PUC_SOMATIVA1`.`enderecos` (`id`, `rua_id`, `cep`, `numero`) VALUES (DEFAULT, 1, '1231212', '123');
INSERT INTO `PUC_SOMATIVA1`.`enderecos` (`id`, `rua_id`, `cep`, `numero`) VALUES (DEFAULT, 2, '1231212', '124');

COMMIT;


-- -----------------------------------------------------
-- Data for table `PUC_SOMATIVA1`.`pessoas`
-- -----------------------------------------------------
START TRANSACTION;
USE `PUC_SOMATIVA1`;
INSERT INTO `PUC_SOMATIVA1`.`pessoas` (`id`, `nome`, `telefone`, `endereco_id`) VALUES (DEFAULT, 'joão', '83 99999999', 1);
INSERT INTO `PUC_SOMATIVA1`.`pessoas` (`id`, `nome`, `telefone`, `endereco_id`) VALUES (DEFAULT, 'carlos', '83 99999999', 2);
INSERT INTO `PUC_SOMATIVA1`.`pessoas` (`id`, `nome`, `telefone`, `endereco_id`) VALUES (DEFAULT, 'maria', '83 99999999', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `PUC_SOMATIVA1`.`clientes`
-- -----------------------------------------------------
START TRANSACTION;
USE `PUC_SOMATIVA1`;
INSERT INTO `PUC_SOMATIVA1`.`clientes` (`id`, `pessoa_id`) VALUES (1, 1);
INSERT INTO `PUC_SOMATIVA1`.`clientes` (`id`, `pessoa_id`) VALUES (2, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `PUC_SOMATIVA1`.`funcionarios`
-- -----------------------------------------------------
START TRANSACTION;
USE `PUC_SOMATIVA1`;
INSERT INTO `PUC_SOMATIVA1`.`funcionarios` (`id`, `pessoa_id`) VALUES (1, 2);
INSERT INTO `PUC_SOMATIVA1`.`funcionarios` (`id`, `pessoa_id`) VALUES (2, 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `PUC_SOMATIVA1`.`entregadores`
-- -----------------------------------------------------
START TRANSACTION;
USE `PUC_SOMATIVA1`;
INSERT INTO `PUC_SOMATIVA1`.`entregadores` (`id`, `funcionario_id`) VALUES (1, 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `PUC_SOMATIVA1`.`ingredientes`
-- -----------------------------------------------------
START TRANSACTION;
USE `PUC_SOMATIVA1`;
INSERT INTO `PUC_SOMATIVA1`.`ingredientes` (`id`, `nome`, `tipo`, `estoque`) VALUES (DEFAULT, 'queijo prato', 'animal', 1000);
INSERT INTO `PUC_SOMATIVA1`.`ingredientes` (`id`, `nome`, `tipo`, `estoque`) VALUES (DEFAULT, 'queijo mussarela', 'animal', 1000);
INSERT INTO `PUC_SOMATIVA1`.`ingredientes` (`id`, `nome`, `tipo`, `estoque`) VALUES (DEFAULT, 'pão de forma', 'outro', 10);

COMMIT;


-- -----------------------------------------------------
-- Data for table `PUC_SOMATIVA1`.`pedidos`
-- -----------------------------------------------------
START TRANSACTION;
USE `PUC_SOMATIVA1`;
INSERT INTO `PUC_SOMATIVA1`.`pedidos` (`id`, `cliente_id`, `entregador_id`, `endereco_id`, `data_pedido`, `instrucoes`, `status`) VALUES (DEFAULT, 1, 1, 1, NULL, 'entrega na rua da igreja', 'aberto');
INSERT INTO `PUC_SOMATIVA1`.`pedidos` (`id`, `cliente_id`, `entregador_id`, `endereco_id`, `data_pedido`, `instrucoes`, `status`) VALUES (DEFAULT, 1, 1, 2, NULL, 'entrega proxima ao colegio', 'preparo');

COMMIT;


-- -----------------------------------------------------
-- Data for table `PUC_SOMATIVA1`.`categorias_de_produto`
-- -----------------------------------------------------
START TRANSACTION;
USE `PUC_SOMATIVA1`;
INSERT INTO `PUC_SOMATIVA1`.`categorias_de_produto` (`id`, `nome`, `descricao`) VALUES (DEFAULT, 'sanduiche queijo', 'sanduiche feito apenas com queijo');
INSERT INTO `PUC_SOMATIVA1`.`categorias_de_produto` (`id`, `nome`, `descricao`) VALUES (DEFAULT, 'sanduiche vegano', 'sanduiches feitos sem ingrediente animal');
INSERT INTO `PUC_SOMATIVA1`.`categorias_de_produto` (`id`, `nome`, `descricao`) VALUES (DEFAULT, 'sanduiche frango', 'sanduiches feitos com frango');

COMMIT;


-- -----------------------------------------------------
-- Data for table `PUC_SOMATIVA1`.`produtos`
-- -----------------------------------------------------
START TRANSACTION;
USE `PUC_SOMATIVA1`;
INSERT INTO `PUC_SOMATIVA1`.`produtos` (`id`, `nome`, `preco`, `descricao`, `disponivel`, `categoria_id`) VALUES (DEFAULT, 'super misto quente', 5.00, 'delicioso sanduiche de queijo', true, 1);
INSERT INTO `PUC_SOMATIVA1`.`produtos` (`id`, `nome`, `preco`, `descricao`, `disponivel`, `categoria_id`) VALUES (DEFAULT, 'misto quente duplo', 10.00, 'delicioso sanduiche dublo com queijo prato e mussarela', true, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `PUC_SOMATIVA1`.`preparadores`
-- -----------------------------------------------------
START TRANSACTION;
USE `PUC_SOMATIVA1`;
INSERT INTO `PUC_SOMATIVA1`.`preparadores` (`id`, `funcionario_id`) VALUES (DEFAULT, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `PUC_SOMATIVA1`.`pedido_produto`
-- -----------------------------------------------------
START TRANSACTION;
USE `PUC_SOMATIVA1`;
INSERT INTO `PUC_SOMATIVA1`.`pedido_produto` (`id`, `pedido_id`, `produto_id`, `preparador_id`, `observacoes`) VALUES (DEFAULT, 1, 1, 1, 'meu sanduiche com  dobro de queijo');

COMMIT;


-- -----------------------------------------------------
-- Data for table `PUC_SOMATIVA1`.`produto_ingrediente`
-- -----------------------------------------------------
START TRANSACTION;
USE `PUC_SOMATIVA1`;
INSERT INTO `PUC_SOMATIVA1`.`produto_ingrediente` (`id`, `produto_id`, `ingrediente_id`, `quantidade_ingrediente`) VALUES (DEFAULT, 1, 1, 200);
INSERT INTO `PUC_SOMATIVA1`.`produto_ingrediente` (`id`, `produto_id`, `ingrediente_id`, `quantidade_ingrediente`) VALUES (DEFAULT, 1, 3, 200);
INSERT INTO `PUC_SOMATIVA1`.`produto_ingrediente` (`id`, `produto_id`, `ingrediente_id`, `quantidade_ingrediente`) VALUES (DEFAULT, 2, 2, 100);
INSERT INTO `PUC_SOMATIVA1`.`produto_ingrediente` (`id`, `produto_id`, `ingrediente_id`, `quantidade_ingrediente`) VALUES (DEFAULT, 2, 3, 100);

COMMIT;


-- -----------------------------------------------------
-- Data for table `PUC_SOMATIVA1`.`entregador_bairro`
-- -----------------------------------------------------
START TRANSACTION;
USE `PUC_SOMATIVA1`;
INSERT INTO `PUC_SOMATIVA1`.`entregador_bairro` (`id`, `entregador_id`, `bairro_id`) VALUES (1, 1, 1);
INSERT INTO `PUC_SOMATIVA1`.`entregador_bairro` (`id`, `entregador_id`, `bairro_id`) VALUES (2, 1, 2);
INSERT INTO `PUC_SOMATIVA1`.`entregador_bairro` (`id`, `entregador_id`, `bairro_id`) VALUES (3, 1, 3);

COMMIT;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
