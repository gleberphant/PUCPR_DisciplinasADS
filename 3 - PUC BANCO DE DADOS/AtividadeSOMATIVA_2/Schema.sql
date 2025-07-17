-- PUC PR - ANALISE E DESENVOLVIMENTO DE SISTEMAS
-- ATIVIDADE SOMATIVA 2
-- POR HANDERSON GLEBER DE LIMA CAVALCANTI


-- 1. faça o modelo fisico do projeto


-- CREATE Schema PUC_SOMATIVA2
DROP SCHEMA IF EXISTS `PUC_SOMATIVA2` ;
CREATE SCHEMA IF NOT EXISTS `PUC_SOMATIVA2`;


-- seleciona o schema
USE `PUC_SOMATIVA2`;

-- criação das tabelas
-- - regiao: 

DROP TABLE IF EXISTS `Regiao`;

CREATE TABLE IF NOT EXISTS `Regiao`(
    `codRegiao` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `nomeRegiao` VARCHAR(100) DEFAULT 'norte',
    `descricaoRegiao` TEXT,
    PRIMARY kEY(`codRegiao`)  
);


-- - vinicola:  VINICULA POSSUI REGIAO
DROP TABLE IF EXISTS `Vinicola`;
CREATE TABLE IF NOT EXISTS `Vinicola` (
    `codVinicola` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `nomeVinicola` VARCHAR(100),
    `descricaoVinicola` TEXT,
    `foneVinicola` VARCHAR(15),
    `emailVinicola` VARCHAR(30),
    `codRegiao` INT UNSIGNED NOT NULL,
    PRIMARY KEY(`codVinicola`),
    CONSTRAINT `fkVinicolaRegiao`
        FOREIGN KEY (`codRegiao`) REFERENCES `Regiao`(`codRegiao`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);

-- - tabela tipo_vinho: VINHO POSSUI TIPO
DROP TABLE IF EXISTS `TipoVinho`;
CREATE TABLE IF NOT EXISTS `TipoVinho`(
    `codTipo` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `nomeTipo` VARCHAR(30),
    PRIMARY KEY(`codTipo`)
);

-- - tabela vinho : VINHO PERTENCE A VINICULA
DROP TABLE IF EXISTS `Vinho`;
CREATE TABLE IF NOT EXISTS `Vinho`(
    `codVinho` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `nomeVinho` VARCHAR(50),
    `codTipo` INT UNSIGNED NOT NULL,
    `anoVinho` YEAR DEFAULT (YEAR(CURDATE())),
    `descricaoVinho` TEXT,
    `codVinicola` INT UNSIGNED NOT NULL,
    PRIMARY kEY(`codVinho`),
    CONSTRAINT `fkVinhoVinicola`
        FOREIGN KEY (`codVinicola`) REFERENCES `Vinicola`(`codVinicola`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
    CONSTRAINT `fkVinhoTipo`
        FOREIGN KEY (`codTipo`) REFERENCES `TipoVinho`(`codTipo`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);



-- inserção de dados
-- - 2. inserir pelo menos 5 registros em cada tabela 



-- INSERÇÃO REGIAO

START TRANSACTION;

    USE `PUC_SOMATIVA2` ;
    
    INSERT INTO `Regiao` (`nomeRegiao`, `descricaoRegiao`) VALUES
        ('norte','descricao regiao norte'),
        ('sul','descricao regiao sul'),
        ('sudeste','descricao regiao sudeste'),
        ('nordeste','descricao regiao nordeste'),
        ('centro-oeste','descricao regiao central'); 

COMMIT;

-- INSERÇÃO VINICOLAS

START TRANSACTION;

    USE `PUC_SOMATIVA2` ;
    
    INSERT INTO `Vinicola` (`nomeVinicola` , `descricaoVinicola`, `foneVinicola`, `emailVinicola` , `codRegiao`)  VALUES
        ('Casa Perini', 'descricao da vinicola casa perini', '+558388887897', 'vinicola_casaperini@gmail.com', '1'),   
        ('Durigan', 'descricao da vinicola Durigan', '+558388887897', 'vinicola_durigan@gmail.com', '2'),
        ('Santa Helena', 'descricao da vinicola santa helana', '+558388887897', 'santa_helena@gmail.com', '3'),
        ('João Bosco', 'descricao da vinicola joao bosco', '+558388887897', 'joao_bosco@gmail.com', '4'),
        ('Garcia', 'descricao da vinicola portuguesa Garcia', '+558388887897', 'vinhos_garcia@gmail.com', '5'); 
    

COMMIT;


-- INSERÇÃO DOS TIPOS DE VINHO

START TRANSACTION;
    USE `PUC_SOMATIVA2`;

    INSERT INTO `TipoVinho`(`codTipo`, `nomeTipo`) VALUES
        (1, 'branco'),
        (2, 'verde'),
        (3, 'rose'),
        (4, 'tinto'),
        (5, 'bordo'),
        (6, 'moscatel');

COMMIT;

-- INSERÇÃO VINHOS

START TRANSACTION;

    USE `PUC_SOMATIVA2`;

    INSERT INTO `Vinho`(`nomeVinho`, `codTipo`, `anoVinho`, `descricaoVinho`, `codVinicola`) VALUES
        ('Perini Rose', 3, 2010, 'descricao do vinho rose da casa perini', 1),
        ('Moscatel Premium', 6, 2022, 'descricao espumante moscatel da durigan', 2),
        ('Vinho Branco Santa Helena', 1, 2021, 'descricao do vinho branco da casa santa helena', 3),
        ('Vinho Tinto Joao Bosco', 4, 2024, 'descricao do vinho tinto joao bosco', 4),
        ('Casal Garcia', 2, 2020, 'descricao do vinho verde garcia', 5);

COMMIT;


-- Faça uma consulta que liste o nome e ano dos vinhos, incluindo o nome da vinícula e onome da região que ela pertence.
USE PUC_SOMATIVA2;
DROP VIEW IF EXISTS `lista_vinhos`;
CREATE VIEW IF NOT EXISTS `lista_vinhos` AS
SELECT 
    `Vinho`.`nomeVinho` AS 'Nome', 
    `TipoVinho`.`nomeTipo` AS 'Tipo', 
    `Vinho`.`anoVinho` AS 'Ano', 
    `Vinicola`.`nomeVinicola` AS 'Vinicola', 
    `Regiao`.`nomeRegiao` AS 'Regiao'
FROM 
    `Vinho`
    JOIN `TipoVinho` ON `TipoVinho`.`codTipo` = `Vinho`.`codTipo`
    JOIN `Vinicola` ON `Vinicola`.`codVinicola` = `Vinho`.`codVinicola`
    JOIN `Regiao` ON `Regiao`.`codRegiao` = `Vinicola`.`codRegiao`
ORDER BY `Vinho`.`anoVinho`;


-- Crie um usuário Somellier, 
-- que deve ter acesso pelo localhost ao:
-- -- Select da tabela Vinho e ao 
-- -- Select do campo codVinicula e nomeVinicula da tabela Vinicula. 
-- -- Além disto, ele somente pode realizar 40 consultas por hora.

-- CRIAÇÃO USUARIO SOMELLIER PARA ACESSO LOCALHOST
CREATE USER IF NOT EXISTS 'somellier'@'localhost' IDENTIFIED BY 'senha' WITH MAX_QUERIES_PER_HOUR 40;

-- CONFIGURAÇÃO PRIVILEGIO: SELECT NA TABELA VINHO
GRANT SELECT ON `PUC_SOMATIVA2`.`Vinho` TO 'somellier'@'localhost';

-- CONFIGURAÇÃO PRIVILEGIO: SELECT NAS COLUNAS id E nome DA TABELA VINICOLA
GRANT SELECT (`codVinicola`, `nomeVinicola`) ON `PUC_SOMATIVA2`.`Vinicola` TO 'somellier'@'localhost';

-- RECARREGAR PRIVILÉGIOS
FLUSH PRIVILEGES;


-- SELECT PARA VERIFICAR FUNCIONAMENTO
SELECT * FROM lista_vinhos;

