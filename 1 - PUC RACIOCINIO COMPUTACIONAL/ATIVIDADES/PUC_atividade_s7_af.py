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
# -	Função para salvar lista de estudantes em um arquivo JSON.
# -	Função para recuperar lista de estudantes de um arquivo JSON e armazenar em uma variável em memória.
# -	Adaptação das funções de incluir, listar, excluir e editar estudantes para que acessem as duas funções acima sempre
# que necessário.

# importações de bibliotecas utilizadas
import json
import os


# Função para salvar dados em um arquivo json

def salvar_em_arquivo(dados_param, nome_arquivo_destino_param="itens") -> bool:
    """
    Recebe o dicionário com os dados e um nome da base destino.
    Retorna true se tudo certo.
    """
    print("salvando dados de ", nome_arquivo_destino_param, " ... ", end=' ')

    try:
        with open("jayzon_" + nome_arquivo_destino_param + ".json", "w", encoding='utf8') as arquivo_escrita:
            json.dump(dados_param, arquivo_escrita, ensure_ascii=False)
            print("Dados salvo com sucesso ")

    except Exception as erro:
        print(f"***** Erro inesperado  :{erro} **** \n  ")
        print(f"***** os dados não foram salvos **** \n  ")
        return False

    return True


# função para abrir arquivo json

def abrir_arquivo(nome_base_destino_param="itens") -> dict:
    """
    Recebe o nome do arquivo contendo o dicionário com os dados
    Retorna dicionario com os dados
    """

    print(" [ Abrindo arquivo : ", nome_base_destino_param, " ... ] ", end='\n')

    # tenta abrir o arquivo de base de dados
    try:
        with open("jayzon_" + nome_base_destino_param + ".json", "r", encoding='utf8') as arquivo_leitura:
            data_return = json.load(arquivo_leitura)

    # em caso de erro cria um dicionário com dados de teste
    except Exception as erro:
        print(f"***** Erro inesperado  :{erro} **** \n  ")
        print("[ Carregando dados de teste .... ]")

        data_return = popula_dados_teste()
        salvar_em_arquivo(data_return)

    return data_return


def popula_dados_teste() -> dict:
    """
    Cria um dicionário com dados de teste
    Retorna dicionario de dados
    """
    dados_teste = {}

    for i in range(8):
        dados_teste[str(i)] = {"codigo": str(i), "nome": "aluno_" + str(i), "cpf": str(i) * 6}

    return dados_teste


def limpar_tela() -> None:
    if os.name == 'nt':
        os.system('cls')
    else:
        os.system('clear')
    return None


#  Desenha o menu principal da aplicação. Coloquei em uma função para não poluir o código principal
def mostra_menu_principal() -> None:

    limpar_tela()

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


# Esta funcao desenha o menu secundário da aplicação. Coloquei em uma função para não poluir o código principal
# ela recebe como parametro o menu secundário que é para ser desenhado. Tendo como valor padrão o menu ESTUDANTE
def mostra_submenu() -> None:
    limpar_tela()
    print("")
    print("┌──────────────[ MENU OPERAÇÕES ]───────────────┐")
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


# Esta funcao desenha a mensagem de opção inválida. Coloquei em uma função para não poluir o código principal
def msg_opcao_invalida() -> None:
    print("\t╔════════════════════╗")
    print("\t║   OPÇÃO INVÁLIDA   ║")
    print("\t╚════════════════════╝")
    return None


# Esta funcao desenha a mensagem de saida da aplicação. Coloquei em uma função para não poluir o código principal
def msg_saida() -> None:
    limpar_tela()
    print("")
    print(" ╔════════════════════════════════════════════╗")
    print(" ║      Dúvidas e sugestões?                  ║")
    print(" ║      Entre em contato por                  ║")
    print(" ║      handerson.gleber@gmail.com            ║")
    print(" ╚════════════════════════════════════════════╝")
    return None


# Esta funcao desenha a mensagem de abertura da aplicação. Coloquei em uma função para não poluir o código principal
def msg_abertura() -> None:
    limpar_tela()
    print("")
    print(" ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░")
    print(" ░░░░░░░░░░SISTEMA DE GESTÃO ACADÊMICA░░░░░░░░")
    print(" ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░")
    print(" ░░░░ por: HANDERSON GLEBER (gravatinha) ░░░░░")
    print(" ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░")
    print("")
    msg_enter_continua()
    return None


def msg_item_nao_encontrado() -> None:
    print("\t╔══════════════════════════╗")
    print("\t║   Item não encontrado    ║")
    print("\t╚══════════════════════════╝")
    input(" pressione <ENTER> para continuar")
    return None


def msg_enter_continua() -> None:
    input("\t Pressione <ENTER> para continuar ...")
    return None


def inserir_item(novo_item, dados_param) -> dict:
    novo_id = int(next(reversed(dados_param.keys()))) + 1
    novo_item['codigo'] = novo_id

    dados_param[str(novo_id)] = novo_item

    # lista_param.append(novo_item)
    print(f"\t Item inserido com sucesso: \n \t {1} ", novo_item['nome'])

    salvar_em_arquivo(dados_param)

    return dados_param


def listar_itens(dados_param, nome="itens") -> None:
    limpar_tela()
    print("")
    print("┌───────────────────────────────────────────────┐")
    print("│            LISTAR {0:<11}                 │".format(nome.upper()))
    print("│                                               │")
    if len(dados_param) > 0:
        k = list(dados_param[next(iter(dados_param))].keys())

        print("├────────┬─────────────────────────┬────────────┤")
        print(f"│ {k[0]:<6} │ {k[1]:<23} │ {k[2]:<11}│")  # desenha o cabeçalho (keys) da tabela

        for item in dados_param.values():  # desenha cada linha da tabela
            print("├────────┼─────────────────────────┼────────────┤")
            print(f"│ {item[k[0]]:<6} │ {item[k[1]]:<23} │ {item[k[2]]:<11}│")
        print("└────────┴─────────────────────────┴────────────┘")
        print("")
    else:
        print("│                                               │")
        print("│        *** Não há item cadastrado ***         │")
        print("│                                               │")
        print("└───────────────────────────────────────────────┘")
    return None


def input_codigo() -> str:

    # filtro de entrada - laço obriga usuário digitar um número
    while True:
        codigo_busca = input("\n Digite o Codigo do item buscado: ")

        if codigo_busca.isdigit():
            break
        else:
            print("*** Código inválido. **** ")
            print("*** Digite um código númérico. **** ")

    return codigo_busca


def editar_item(dados_param) -> dict:

    codigo_item = input_codigo()

    # verifica se existe  o item com código informado
    if codigo_item in dados_param:

        # recebe os dados do novo item
        novo_item = {'codigo': codigo_item,
                     'nome': input("\n Digite o novo nome: "),
                     'cpf': input("\n Digite o novo CPF: ")}

        # tenta atualizar o aluno
        try:
            dados_param[codigo_item] = novo_item
            salvar_em_arquivo(dados_param)

        # se falhar mostra o erro
        except Exception as erro:
            print(" *** ocorreu um erro quando estava atualizando o aluno **** \n Erro = ", erro)

        # se funcionar exibe mensagem de sucesso
        else:
            print("\t╔═══════════════════════════════════════════╗")
            print(f"\t║ *** ALUNO {novo_item['codigo']:<4} ATUALIZADO COM SUCESSO *** ║")
            print("\t╚═══════════════════════════════════════════╝")
    else:
        msg_item_nao_encontrado()

    return dados_param


def remover_item(dados_param) -> dict:
    codigo_item = input_codigo()

    # verifica se existe item com o código informado
    if codigo_item in dados_param:
        # pede confirmação da exclusão

        print("\t╔════════════════════════════════════════════════════════════╗")
        print(f"\t║    tem certeza que deseja excluir {dados_param[codigo_item]['nome']:^20} ?   ║")
        print("\t╚════════════════════════════════════════════════════════════╝")

        # loop para confirmar exclusão
        while True:

            confirmacao = input("\t Digite [S] para SIM  ou [N] para NÃO ").upper()

            # Resposta SIM - deletar o aluno
            if confirmacao == "S":
                try:
                    del dados_param[codigo_item]
                    salvar_em_arquivo(dados_param)

                # se falhar mostra o erro
                except Exception as erro:
                    print("*** falha na exclusao *** \n Erro :", erro)

                # se funciona exibe mensagem de sucesso
                else:
                    print("\t╔═══════════════════════════════════════════╗")
                    print("\t║   ****  ITEM EXCLUIDO COM SUCESSO  ****   ║")
                    print("\t╚═══════════════════════════════════════════╝")

                # em qualquer caso quebra o loop while de confirmação da exclusão
                finally:
                    break

            # resposta NÃO - cancelar exclusão
            elif confirmacao == "N":
                print("\t╔════════════════════════╗")
                print("\t║   EXCLUSÃO CANCELADA   ║")
                print("\t╚════════════════════════╝")
                break  # quebra o laço while de confirmação da exclusão

            # resposta inválida - nao quebra o loop de confirmação
            else:
                msg_opcao_invalida()

    return dados_param


def main() -> int:

    db_alunos = abrir_arquivo()

    msg_abertura()  # chama mensagem de abertura da aplicação

    while True:  # Loop principal da aplicação. Roda enquanto não receber um BREAK

        mostra_menu_principal()  # chama o desenho do menu principal

        opcao_menu_principal = input("\t Informe o numero da opção desejada:  ")[0]

        if opcao_menu_principal == "1":  # ENTRA NO MENU DE ESTUDANTE

            while True:  # Loop no menu secundário. Roda enquanto não receber um BREAK

                mostra_submenu()

                opcao_submenu1 = input("\t Informe o número da opção desejada: ")

                match opcao_submenu1:
                    case "1":  # Opção de INCLUIR

                        novo_item = {"codigo": '',
                                     "nome": input("\t Informe o NOME a ser inserido:  "),
                                     "cpf": input("\t Informe o CPF a ser inserido:  ")}

                        db_alunos = inserir_item(novo_item, db_alunos)

                        msg_enter_continua()

                    case "2":  # Opção de LISTAR
                        print("\t RELAÇÃO DOS ALUNOS CADASTRADOS")

                        listar_itens(db_alunos)

                        msg_enter_continua()

                    case "3":  # Opção de EDITAR

                        db_alunos = editar_item(db_alunos)

                        msg_enter_continua()

                    case "4":  # Opção de EXCLUIR

                        db_alunos = remover_item(db_alunos)

                        msg_enter_continua()

                    case "9" | "q":  # Opção de SAIR
                        print("Voltando ao menu principal")
                        break

                    case _:  # CASO O USUÁRIO DIGITE OPÇÃO INVALIDA
                        msg_opcao_invalida()

        elif (opcao_menu_principal == "2"
              or opcao_menu_principal == "3"
              or opcao_menu_principal == "4"
              or opcao_menu_principal == "5"):  # OUTROS MODULOS DO MENU PRINCIPAL

            print("")
            print(" ╔════════════════════════════════════════════╗")
            print(" ║            EM DESENVOLVIMENTO              ║")
            print(" ╚════════════════════════════════════════════╝")
            print("")
            msg_enter_continua()

        elif opcao_menu_principal == "9" or opcao_menu_principal == "q":  # OPÇÃO SAIR DO MENU PRINCIPAL
            msg_saida()
            salvar_em_arquivo(db_alunos)
            return None
        else:  # CASO O USUÁRIO DIGITE OPÇÃO INVALIDA
            msg_opcao_invalida()


if __name__ == "__main__":

    print("Iniciando o programa... ")
    main()
    print("Programa finalizado... ")
    exit(0)
