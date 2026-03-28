""" Sistema de gestão academica - pucpr VS6"""
# ┌─────────────────────────────────────────────────────────────┐
# │         ╔════╗           ╔═════     ╔════╗  ╔═══╗           │
# │         ║    ║  ║    ║   ║          ║    ║  ║   ║           │
# │         ╠════╝  ║    ║   ║          ╠════╝  ╠═══╩╗          │
# │         ║       ╚════╝   ╚═════     ║       ║    ║          │
# └─────────────────────────────────────────────────────────────┘
# ┌─────────────────────────────────────────────────────────────┐
# │  CURSO: Análise e Desenvolvimento de Sistemas               │
# │  DISCIPLINA: Raciocínio Computacional (11100010563_20242_02)│
# │  ALUNO: HANDERSON GLEBER DE LIMA CAVALCANTI (Gr4v4t1nh4)    │
# │  MATRÍCULA: 1112024201103                                   │
# └─────────────────────────────────────────────────────────────┘
# ┌─────────────────────────────────────────────────────────────┐
# │   Atividade FORMATIVA 5 - semana 7                          │
# └─────────────────────────────────────────────────────────────┘
# CRITÉRIOS
# -O que devo desenvolver?
# - Implementar todas as funcionalidades já desenvolvidas (ex.: incluir e listar) para os demais módulos do sistema.
# Veja os dados necessários para cada um dos grupos abaixo:
#
# Alunos
# - Código do aluno (Número inteiro)
# - Nome do aluno (String)
# - CPF do aluno (String)
#
# Professores
# - Código do professor (Número inteiro)
# - Nome do professor (String)
# - CPF do professor (String)
#
# Disciplinas
# - Código da disciplina (Número inteiro)
# - Nome da disciplina (String)
#
# Turmas
# - Código da turma (Número inteiro)
# - Código do professor (Número inteiro)
# - Código da disciplina (Número inteiro)
#
# Matrículas
# - Código matricula (Número inteiro)
# - Código da turma (Número inteiro)
# - Código do estudante (Número inteiro)
#
# Validação de dados na manipulação de turmas e matrículas (verificar se um código já existe antes de incluir uma
# nova turma/matrícula com o mesmo código).
# - O que meu sistema deve ter no final? (checklist)
# - As quatro operações básicas (incluir/listar/atualizar/excluir) para todos os módulos
# (estudantes/professores/disciplinas/turmas/matrículas) do sistema.
# - Utilização de estruturas condicionais (if/elif/else) no código.
# - Utilização de estruturas de repetição (for ou while) para navegação dos menus
# - Utilização de estruturas de dados compostas (listas, dicionários, e/ou tuplas) para organização dos dados.
# - Utilização de arquivos para a persistência dos dados cadastrados.
# - Utilização de funções para modularizar as principais funcionalidades da aplicação.
# -o As funções devem ser utilizadas seguindo boas práticas de programação.
# -o Se possível, reaproveitar funções para diferentes módulos do sistema
# (ex.: uma única função para incluir registro de estudantes, professores, disciplinas, turmas e matrículas).
# - Validações de dados e controle de possíveis exceções/erros de execução (try/except).

# IMPORTAÇÕES DE BIBLIOTECAS UTILIZADAS
import json
import os
import argparse
from typing import Final


# ESTRUTURA/CLASS COM AS CONFIGURAÇÕES DA APLICAÇÃO
class SETTINGS:
    debug_mode: bool = False

    KEYSET = {
        "alunos": ("codigo", "nome", "cpf"),
        "professores": ("codigo", "nome", "cpf"),
        "disciplinas": ("codigo", "nome"),
        "turmas": ("codigo", "professor_id", "disciplina_id"),
        "matriculas": ("codigo", "turma_id", "aluno_id")
    }

    FILEFORMAT = ".json"
    FILEPREFIX = "jayzon_"
    FILEPATH = "datafiles"


# ESTRUTURA/CLASS COM AS CONSTANTES UTILIZADAS NA APLICAÇÃO
class CONSTS:
    OPT_ALUNOS:         Final = '1'
    OPT_PROFESSORES:    Final = '2'
    OPT_DISCIPLINAS:    Final = '3'
    OPT_TURMAS:         Final = '4'
    OPT_MATRICULAS:     Final = '5'

    OPT_CREATE: Final = '1'
    OPT_READ:   Final = '2'
    OPT_UPDATE: Final = '3'
    OPT_DELETE: Final = '4'


# FUNÇÕES PARA EXIBIÇÃO DE MENSAGENS PADRONIZADAS
def clean_screen() -> None:
    """
    Apaga toda a tela para novos desenhos.
    Não recebe parametros
    Sem retorno
    """
    if not SETTINGS.debug_mode:
        if os.name == 'nt':
            os.system('cls')
        else:
            os.system('clear')

    return None


#  Desenha o menu principal da aplicação. Coloquei em uma função para não poluir o código principal
def show_menu_main() -> None:
    """
    Desenha o menu principal
    não recebe parametros
    sem retorno
    """
    clean_screen()

    print("")
    print("┌───────────────[ MENU PRINCIPAL ]──────────────┐")
    print("│                                               │")
    print("│ (1) Gerenciar Estudantes.                     │")
    print("│ (2) Gerenciar Professores.                    │")
    print("│ (3) Gerenciar Disciplinas.                    │")
    print("│ (4) Gerenciar Turmas.                         │")
    print("│ (5) Gerenciar Matrícula.                      │")
    print("│                                               │")
    print("│ (9) Sair.                                     │")
    print("│                                               │")
    print("└───────────────────────────────────────────────┘")

    return None


def show_menu_crud(opcao_principal="OPERAÇÕES") -> None:
    """
    Desenha o menu secundário
    não recebe parametros
    sem retorno
    """
    clean_screen()
    print("")
    print(f"┌────────────[{opcao_principal:^18}]───────────────┐")
    print("│                                               │")
    print("│ (1) Incluir.                                  │")
    print("│ (2) Listar.                                   │")
    print("│ (3) Editar.                                   │")
    print("│ (4) Excluir.                                  │")
    print("│                                               │")
    print("│ (9) Voltar                                    │")
    print("│                                               │")
    print("└───────────────────────────────────────────────┘")
    return None


def msg_opcao_invalida() -> None:
    """
    Desenha a mensagem de opção inválida
    não recebe parametros
    sem retorno
    """
    print("\t╔════════════════════╗")
    print("\t║   OPÇÃO INVÁLIDA   ║")
    print("\t╚════════════════════╝")
    return None


def msg_saida() -> None:
    """
    Mensagem de saida do programa.
    Se ativado o modo debug nao apaga tela para manter os registros de erro
    não recebe parametros
    sem retorno
    """

    clean_screen()

    print("")
    print(" ╔════════════════════════════════════════════╗")
    print(" ║      Dúvidas e sugestões?                  ║")
    print(" ║      Entre em contato por                  ║")
    print(" ║      handerson.gleber@gmail.com            ║")
    print(" ╚════════════════════════════════════════════╝")
    return None


def msg_abertura() -> None:
    """
    Mensagem de abertura do programa
    Se ativado o modo debug nao apaga tela para manter os registros de erro
    não recebe parametros
    sem retorno
    """

    clean_screen()

    print("")
    print(" ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░")
    print(" ░░░░░░░░░░SISTEMA DE GESTÃO ACADÊMICA░░░░░░░░")
    print(" ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░")
    print(" ░░░░ por: HANDERSON GLEBER (gravatinha) ░░░░░")
    print(" ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░")
    print("")
    msg_enter_continua()
    return None


def msg_item_atualizado() -> None:
    """
    Desenha a mensagem de item atualizado
    não recebe parametros
    sem retorno
    """

    print("\t╔═══════════════════════════════════════════╗")
    print("\t║         ITEM ATUALIZADO COM SUCESSO       ║")
    print("\t╚═══════════════════════════════════════════╝")


def msg_item_nao_encontrado() -> None:
    """
    Desenha a mensagem de item não encontrado
    não recebe parametros
    sem retorno
    """
    print("\t╔══════════════════════════╗")
    print("\t║   Item não encontrado    ║")
    print("\t╚══════════════════════════╝")
    print("")
    msg_enter_continua()

    return None


def msg_em_desenvolvimento() -> None:
    """
    Desenha a mensagem em desenvolvimento
    não recebe parametros
    sem retorno
    """
    print("")
    print(" ╔════════════════════════════════════════════╗")
    print(" ║            EM DESENVOLVIMENTO              ║")
    print(" ╚════════════════════════════════════════════╝")
    print("")
    msg_enter_continua()


def msg_enter_continua() -> None:
    """
    Padroniza a mensagem "pressione ENTER para continuar".
    Não recebe parametros
    sem retorno
    """
    input("\t Pressione <ENTER> para continuar ...")

    return None


# DEFINIÇÃO DAS FUNÇÕES
def validade_pathfile(pathfile_param):
    valid_pathfile = pathfile_param + "/"

    if not os.path.exists(pathfile_param):
        print(f"Criando diretorio de arquivos...", end="")
        try:
            os.makedirs(pathfile_param)
            print("diretorio criado com sucesso.")
        except Exception as erro:
            print(f" {type(erro).__name__} [ Utilizando Diretorio-padrão ]")
            valid_pathfile = ""

    return valid_pathfile


def save_tbl_to_file(tbl_param: dict) -> bool:
    """
    Função para salvar os dados em um arquivo JSON
    Recebe o dicionário com a tabela com os dados.
    Retorna true se tudo certo.
    """

    filepath = validade_pathfile(SETTINGS.FILEPATH)

    tbl_name = tbl_param["name"] or "itens"

    filename = filepath + SETTINGS.FILEPREFIX + tbl_name + SETTINGS.FILEFORMAT

    # verifica se o diretório existe, se não cria para não haver erros

    dataset = tbl_param["data"]

    print(f"\t Salvando os dados de {filename:.<15}", end=' ')

    try:
        with open(filename, "w", encoding='utf8') as file_opened:
            json.dump(dataset, file_opened, indent=4, ensure_ascii=False)
            print("[Dados salvo com sucesso] ")

    except Exception as erro:
        print(f"*** {type(erro).__name__} ***   ")
        print(f"*** os dados não foram salvos !! ***  ")
        print("")
        return False

    return True


def load_tbl_from_file(tblname_param="itens", keyset_param=("codigo", "nome", "cpf")) -> dict:
    """
    Função para abrir arquivo json
    Recebe o nome do arquivo com os dados
    Retorna dicionario com os dados
    """

    # verifica se o diretório existe, se não cria para não haver erros
    filepath = validade_pathfile(SETTINGS.FILEPATH)

    filename = filepath + SETTINGS.FILEPREFIX + tblname_param + SETTINGS.FILEFORMAT

    print(f"\t Carregando a base de dados {tblname_param:.<15}", end=' ')

    # tenta abrir o arquivo de base de dados
    try:
        with open(filename, "r", encoding='utf8') as file_opened:
            dataset = json.load(file_opened)
            print("[Dados carregados] ")

    # em caso de erro cria um dicionário com dados de teste
    except Exception as erro:
        print(f"{type(erro).__name__} : [ Carregando dados de teste ] ")
        dataset = get_default_dataset(tblname_param, keyset_param)

    tbl_return = {
        "name": tblname_param,
        "keys": keyset_param,
        "data": dataset
    }

    return tbl_return


def get_default_dataset(itemname_param="item", default_keys=("codigo", "nome", "cpf")) -> dict:
    """
    Função para debug do sistema. Cria um dicionário com dados de teste
    Não recebe parametros
    Retorna dicionario com dados de teste
    """

    default_dataset = dict()

    for i in ('0', '1', '2'):
        default_dataset[i] = dict()
        for key in default_keys:
            if key == "codigo":
                default_dataset[i]["codigo"] = i
            elif key == "nome":
                default_dataset[i][key] = itemname_param + "_" + str(i)
            else:
                default_dataset[i][key] = i

    return default_dataset


def save_database(database_param: dict) -> bool:
    """
    Salvar a database em um arquivo pemanente
    recebe a database que será salva
    retorna True se ocorreu com sucesso e false se ocorreu falha
    """
    print("──────────────────────────────────────────────────")
    print(f"{'Salvando database':.<50}")

    for tbl in database_param.values():
        try:
            save_tbl_to_file(tbl)
        except Exception as erro:
            print(f"não foi possível salvar {erro}")

    print("──────────────────────────────────────────────────")
    return True


def input_codigo() -> str:
    """
    Solicita e valida a entrada de um código numérico.
    Recebe: Nenhum parâmetro, solicita o código via input do usuário.
    Retorna: str - O código numérico inserido pelo usuário, após validação.
    """

    while True:
        codigo = input("\n Digite o Codigo do item buscado: ")

        if codigo.isdigit():
            break
        else:
            print("*** Código inválido. **** ")
            print("*** Digite um código númérico. **** ")
        # end else
    # end while

    return codigo


def valid_id(id_param: str, dataset: dict, name_para: str) -> bool:
    """
    Valida se o _id existe no dataset.
    Recebe: Dataset com itens e o ID a ser validado
    Retorna: bool - true se o ID existir no dataset, false se não existir.
    """

    if not has_item_in_dataset(id_param, dataset):
        print("\t╔═════════════════════════════════════════════╗")
        print(f"\t║{name_para.upper()+" INEXISTENTE ":^45}║")
        print("\t╚═════════════════════════════════════════════╝")
        return False
    return True


def is_aluno_in_turma(matricula_nova, dataset_matricula):
    """
    Verifica se o aluno já está matriculado na turma.
    Recebe: matricula_nova (dict), dataset_matricula (dict)
    Retorna: bool (True se o aluno já estiver matriculado na turma, False caso contrário)
    """

    for matricula in dataset_matricula.values():

        if (matricula["aluno_id"] == matricula_nova["aluno_id"] and
                matricula["turma_id"] == matricula_nova["turma_id"]):
            print("\t╔══════════════════════════════════════════════════════╗")
            print("\t║         ALUNO(A) JA MATRÍCULADO NA TURMA             ║")
            print("\t╚══════════════════════════════════════════════════════╝")
            return True
        # end if
    # end for
    return False


def validate_matricula(nova_matricula: dict, database: dict) -> bool:
    """
    Valida uma nova matrícula verificando a existência do aluno e da turma,
    Recebe: Dicionário contendo os dados da nova matrícula (aluno_id e turma_id) e
            Dicionário contendo as tabelas 'tbl_turmas', 'tbl_alunos' e 'tbl_matriculas' com seus dados.
    Retorna: bool - True se a matrícula for válida, False se algum critério de validação falhar.
    """
    if not valid_id(nova_matricula["turma_id"], database["tbl_turmas"]["data"], "turma"):
        return False

    if not valid_id(nova_matricula["aluno_id"], database["tbl_alunos"]["data"], "aluno"):
        return False

    if is_aluno_in_turma(nova_matricula, database["tbl_matriculas"]["data"]):
        return False

    return True


def validate_turma(nova_turma: dict, database: dict) -> bool:
    """
    Valida uma nova turma verificando a existência do professor e da disciplina
    Recebe: Dicionário contendo os dados da nova turma e Dicionário contendo a database.
    Retorna: bool - True se a matrícula for válida, false se algum critério de validação falhar.
    """
    if not valid_id(nova_turma["professor_id"], database["tbl_professores"]["data"], "professor"):
        return False

    if not valid_id(nova_turma["disciplina_id"], database["tbl_disciplinas"]["data"], "disciplina"):
        return False

    return True


def valid_item(item: dict, database: dict) -> bool:
    """
    Chama o validador correspondente ao item a ser validado.
    Recebe o item a ser validado e dataset que contém os registros existentes.
    Retorna True se a validação passar e False se a validação falhar
    """

    # se possuir as chaves "turma_id" e "aluno_id" o item é uma matrícula
    if "professor_id" in item and "disciplina_id" in item:
        return validate_turma(item, database)

    if "turma_id" in item and "aluno_id" in item:
        return validate_matricula(item, database)

    return True


def get_last_key(dataset) -> str:
    """
    Retorna a última chave do dataset.
    Recebe: dataset_param (dict)
    Retorno: str (última chave como string)
    """

    last_id = next(reversed(dataset.keys()))
    return last_id


def get_next_key(dataset) -> str:
    """
    Retorna a próxima chave disponível no dataset.
    Recebe: dataset_param (dict)
    Retorno: str (próxima chave como string)
    """
    return str(int(get_last_key(dataset)) + 1) if len(dataset) > 0 else '0'


def get_new_item(keyset: tuple, id_param: str) -> dict:
    """
    Cria um novo item com base nas chaves fornecidas e solicita os valores via input.
    Recebe: tupla contendo as chaves a serem usadas no item.
    Retorna: novo item criado com as chaves e valores inseridos
    """
    new_item = dict()
    for key in keyset:
        # tratamento dos inputs
        if key == "codigo":
            new_item["codigo"] = id_param
        else:
            new_item[key] = input(f"\t Informe o {key} a ser inserido ")

    return new_item


def has_item_in_dataset(codigo_param, data_param) -> bool:
    return True if codigo_param in data_param else False


def insert_item(item, database, name_param):
    """
    Valida o novo item e tenta inseri-lo no dataset com o código fornecido.
    Recebe: new_item (dict), dataset (dict), codigo (str)
    Retorna: bool (True se o item for inserido com sucesso, False em caso de erro)
    """

    dataset = database["tbl_" + name_param]["data"]
    id_param = item["codigo"]
    if not valid_item(item, database):
        return False

    try:
        dataset[id_param] = item
        msg_item_atualizado()
        return True

    except Exception as erro:
        print(f"{erro}")
        return False


def create_item(database_param: dict, name_param: str) -> bool:
    """
    Insere um item em uma tabela de dados
    Recebe: a tabela em que o item deve ser inserido
    retorna True se funcionou False de falhou
    """
    tbl_param = database_param["tbl_"+name_param]

    new_id = get_next_key(tbl_param["data"])
    new_item = get_new_item(tbl_param["keys"], new_id)

    return insert_item(new_item, database_param, name_param)


def update_item(database_param: dict, name_param: str) -> bool:
    """
    Editar o item de uma base dados
    recebe a base de dados
    retorna True se funcionou False de falhou
    """
    dataset = database_param["tbl_"+name_param]["data"]

    codigo = input_codigo()

    if has_item_in_dataset(codigo, dataset):
        new_item = get_new_item(dataset[codigo].keys(), codigo)
        return insert_item(new_item, database_param, name_param)

    else:
        msg_item_nao_encontrado()

    return False


def delete_item(dataset_param) -> bool:
    """
    Remover um item de uma base dados
    recebe a base de dados
    retorna True se funcionou False de falhou
    """

    codigo_item = input_codigo()

    # verifica se existe item com o código informado
    if has_item_in_dataset(codigo_item, dataset_param):

        print("\t╔════════════════════════════════════════════════════════════╗")
        print(f"\t║{"Tem certeza que deseja excluir o item " + dataset_param[codigo_item]['codigo'] + "?":^60}║")
        print("\t╚════════════════════════════════════════════════════════════╝")

        # loop para confirmar exclusão
        while True:

            confirm_flag = input("\t Digite [S] para SIM  ou [N] para NÃO ").upper()

            # Resposta SIM - deletar o aluno
            if confirm_flag == "S":
                try:
                    del dataset_param[codigo_item]

                # se falhar mostra o erro
                except Exception as erro:
                    print("*** Falha inesperada na exclusao do item: ", erro)
                    return False

                # se funciona exibe mensagem de sucesso
                else:
                    print("\t╔═══════════════════════════════════════════╗")
                    print("\t║         ITEM EXCLUIDO COM SUCESSO         ║")
                    print("\t╚═══════════════════════════════════════════╝")
                    return True
                # em qualquer caso quebra o loop while de confirmação da exclusão
                finally:
                    break

            # resposta NÃO - cancelar exclusão
            elif confirm_flag == "N":
                print("\t╔════════════════════════╗")
                print("\t║   EXCLUSÃO CANCELADA   ║")
                print("\t╚════════════════════════╝")
                break  # quebra o laço while de confirmação da exclusão

            # resposta inválida - nao quebra o loop de confirmação
            else:
                msg_opcao_invalida()
    else:
        msg_item_nao_encontrado()

    return False


def list_itens(tbl_param: dict) -> bool:
    """
    Desenha a lista de itens de uma base de dados
    recebe dicionario com os dados e o nome da base
    retorna True se funcionou False de falhou
    """
    clean_screen()
    print("")
    dataset = tbl_param["data"]
    name = tbl_param["name"]

    if len(dataset) > 0:
        # k = list(dados_param[min(dados_param)].keys())
        title = "LISTA DE " + name.upper()
        itens_keys = [key for key in dataset[next(iter(dataset))].keys()]

        if len(itens_keys) == 3:

            # desenha cabeçalho da tabela com 2 colunas
            print("┌─────────────────────────────────────────────────────┐")
            print(f"│{title:^53}│")
            print("├──────────┬─────────────────────────┬────────────────┤")

            # desenha o titulo das 3 colunas
            print(f"│ {itens_keys[0].upper():^8} │ {itens_keys[1].upper():^23} │ {itens_keys[2].upper():^15}│")

            # desenha as linhas da tabela com 3 colunas
            for item in dataset.values():
                print("├──────────┼─────────────────────────┼────────────────┤")
                print(f"│ {item[itens_keys[0]]:^8} │ {item[itens_keys[1]]:<23} │ {item[itens_keys[2]]:<15}│")

            # desenha rodapé da tabela com 3 colunas
            print("└──────────┴─────────────────────────┴────────────────┘")
            print("")

        else:
            # cabeçalho da tabela com 2 colunas
            print("┌────────────────────────────────────┐")
            print(f"│{title:^36}│")
            print("├──────────┬─────────────────────────┤")

            #  titulo das 2 colunas
            print(
                f"│ {itens_keys[0].upper():^8} │ {itens_keys[1].upper():^23} │")  # desenha o cabeçalho (keys) da tabela

            #  linhas da tabela com 3 colunas
            for item in dataset.values():  # desenha cada linha da tabela
                print("├──────────┼─────────────────────────┤")
                print(f"│ {item[itens_keys[0]]:^8} │ {item[itens_keys[1]]:<23} │")

            #  rodapé da tabela com 3 colunas
            print("└──────────┴─────────────────────────┘")
            print("")
    else:
        print("┌───────────────────────────────────────────────┐")
        print("│                                               │")
        print("│        *** Não há item cadastrado ***         │")
        print("│                                               │")
        print("└───────────────────────────────────────────────┘")

    return True


# FUNÇÃO PRINCIPAL
def main(debug_mode=False) -> int:
    """
    Função principal
    sem parametros
    retorno o estado final
    """

    # configurando aplicação e definindo variáveis
    print("──────────────────────────────────────────────────")
    print(f"{'Definindo variáveis do ambiente':.<50}")

    # ativar o modo de depuração
    if debug_mode:
        print("Modo de depuração ativado")
        print("Neste modo a tela não é limpa a cada ação e as mensagems do sistema permanecem")
        SETTINGS.debug_mode = True

    running: bool = True

    target_tbl: dict = dict()

    # carrega base de dados da aplicação
    print(f"{'Carregando arquivos':.<50}")
    database = {
        "tbl_alunos": load_tbl_from_file("alunos", SETTINGS.KEYSET["alunos"]),
        "tbl_professores": load_tbl_from_file("professores", SETTINGS.KEYSET["professores"]),
        "tbl_disciplinas": load_tbl_from_file("disciplinas", SETTINGS.KEYSET["disciplinas"]),
        "tbl_turmas": load_tbl_from_file("turmas", SETTINGS.KEYSET["turmas"]),
        "tbl_matriculas": load_tbl_from_file("matriculas", SETTINGS.KEYSET["matriculas"])
    }

    print(f"{'Carregamento finalizado ':.<50}")
    print("───────────────────────────────────────────────")

    # mensagem de abertura da aplicação
    msg_abertura()

    # Loop principal da aplicação. Roda enquanto não receber um BREAK
    while running:  # main app loop

        # loop do menu primário
        while running:

            #  desenha o menu principal
            show_menu_main()

            #  aguarda seleção da opção
            option_menu_main = input("\t Informe o numero da opção desejada:  ")

            match option_menu_main:
                # OPÇÃO alunos
                case CONSTS.OPT_ALUNOS:
                    target_tbl = database["tbl_alunos"]
                    break

                # OPÇÃO professores
                case CONSTS.OPT_PROFESSORES:
                    target_tbl = database["tbl_professores"]
                    break

                # OPÇÃO disciplinas
                case CONSTS.OPT_DISCIPLINAS:
                    target_tbl = database["tbl_disciplinas"]
                    break

                # OPÇÃO turmas
                case CONSTS.OPT_TURMAS:
                    target_tbl = database["tbl_turmas"]
                    break

                # OPÇÃO matriculas
                case CONSTS.OPT_MATRICULAS:
                    target_tbl = database["tbl_matriculas"]
                    break

                # CASO O USUÁRIO DIGITE OPÇÃO SAIR
                case '9' | 'q' | 'Q':
                    running = False
                    break

                # CASO O USUÁRIO DIGITE OPÇÃO INVALIDA
                case _:
                    msg_opcao_invalida()

            #  fim match case  menu

        #  fim while menu principal

        #  Loop no menu secundário.
        while running:

            sucess_flag = False

            target_name = target_tbl["name"]
            target_dataset = target_tbl["data"]

            show_menu_crud(target_name.upper())

            option_menu_crud = input("\t Informe o número da opção desejada: ")

            match option_menu_crud:
                case CONSTS.OPT_CREATE:  # Opção de INCLUIR
                    sucess_flag = create_item(database, target_name)

                case CONSTS.OPT_READ:  # Opção de LISTAR
                    list_itens(target_tbl)

                case CONSTS.OPT_UPDATE:  # Opção de EDITAR
                    sucess_flag = update_item(database, target_name)

                case CONSTS.OPT_DELETE:  # Opção de EXCLUIR
                    sucess_flag = delete_item(target_dataset)

                case '9' | 'q' | 'Q':  # Opção de SAIR
                    print("Voltando ao menu principal")
                    break

                case _:  # CASO O USUÁRIO DIGITE OPÇÃO INVALIDA
                    msg_opcao_invalida()

            #  fim match case submenu
            if sucess_flag:
                save_tbl_to_file(target_tbl)

            msg_enter_continua()

        #  fim while submenu

    # fim while aplicação

    # procedimentos para encerramento da aplicação

    # salvar database em arquivos
    save_database(database)

    # exibir a mensagem final
    msg_saida()

    return 0


# INICIO DO PROGRAMA
if __name__ == "__main__":

    print("Iniciando aplicação... ")
    # descrição da linha de comando da aplicação
    parse = argparse.ArgumentParser(description="no modo depuração a tela não é limpa e todas mensagems permanecem")

    # adicionar possíveis argumentos
    parse.add_argument('-d', "--debug", action="store_true", help="Ativa o modo de debug")
    args = parse.parse_args()

    final_status = main(args.debug)

    print("Encerrando aplicação... ")

    exit(final_status)
