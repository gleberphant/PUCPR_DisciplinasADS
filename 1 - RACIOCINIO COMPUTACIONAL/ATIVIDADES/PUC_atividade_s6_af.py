""" sitema de gestão academica - pucpr VS6"""
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
# │   Atividade FORMATIVA 4 - semana 6                          │
# └─────────────────────────────────────────────────────────────┘
# CRITÉRIOS
# -	Você deve obrigatoriamente modularizar (colocar dentro de funções) as seguintes funcionalidades:
# -	Apresentação do Menu Principal
# -	Apresentação do Menu de Operações
# -	Inclusão de estudante
# -	Listagem de estudantes
# - Edição de estudante
# -	Exclusão de estudante


#  Esta funcao desenha o menu principal da aplicação. Coloquei em uma função para não poluir o código principal
def mostra_menu_principal():
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
def mostra_submenu():
    print("┌──────────────[ MENU OPERAÇÕES ]───────────────┐")
    print("│                                               │")
    print("│ (1) Incluir.                                  │")
    print("│ (2) Listar.                                   │")
    print("│ (3) Atualizar.                                │")
    print("│ (4) Excluir.                                  │")
    print("│                                               │")
    print("│ (9) Voltar                                    │")
    print("│                                               │")
    print("└───────────────────────────────────────────────┘")
    return None


# Esta funcao desenha a mensagem de opção inválida. Coloquei em uma função para não poluir o código principal
def msg_opcao_invalida():
    print("\t╔════════════════════╗")
    print("\t║   OPÇÃO INVÁLIDA   ║")
    print("\t╚════════════════════╝")
    return None


# Esta funcao desenha a mensagem de saida da aplicação. Coloquei em uma função para não poluir o código principal
def msg_saida():
    print(" ╔════════════════════════════════════════════╗")
    print(" ║      Dúvidas e sugestões?                  ║")
    print(" ║      Entre em contato por                  ║")
    print(" ║      handerson.gleber@gmail.com            ║")
    print(" ╚════════════════════════════════════════════╝")
    return None


# Esta funcao desenha a mensagem de abertura da aplicação. Coloquei em uma função para não poluir o código principal
def msg_abertura():
    print("")
    print(" ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░")
    print(" ░░░░░░░░░░SISTEMA DE GESTÃO ACADÊMICA░░░░░░░░")
    print(" ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░")
    print(" ░░░░ por: HANDERSON GLEBER (gravatinha) ░░░░░")
    print(" ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░")
    print("")
    return None


def msg_enter_continua():
    input("\t Pressione <ENTER> para continuar ...")
    return None


def popula_dados_teste():
    lista = []
    for i in range(5):
        lista.append({"codigo": 1 * i, "nome": "aluno_" + str(i), "cpf": str(i) * 6})
    return lista


def inserir_item(novo_item, lista_param):

    lista_param.append(novo_item)
    print(f"\t Item inserido com sucesso: \n \t {1} ", novo_item)

    return lista_param


def listar_itens(lista_param, nome="ITENS"):
    print("")
    print("┌───────────────────────────────────────────────┐")
    print("│            LISTAR {0:<11}                 │".format(nome))
    print("│                                               │")
    if len(lista_param) > 0:
        k = list(lista_param[0].keys())

        print("├────────┬─────────────────────────┬────────────┤")
        print(f"│ {k[0]:<6} │ {k[1]:<23} │ {k[2]:<11}│")  # desenha o keys da tabela

        for item in lista_param:  # desenha cada linha da tabela
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


def buscar_item(lista_param):
    codigo_busca = input("Digite o Código do Item : ")
    if codigo_busca.isnumeric() is True:
        for item in lista_param:
            if int(codigo_busca) == item["codigo"]:
                return item
    return False


def remover_item(lista_param):
    item_encontrado = buscar_item(lista_param)

    if item_encontrado is not False:
        if input("\t Voce tem certeza que deseja excluir ? ").upper() == "S":

            lista_param.remove(item_encontrado)

            print("\t Código  excluido com sucesso")

    else:
        print("\t Nenhum item foi encontrado com ese codigo")

    return lista_param


def editar_item(lista_param):

    item_encontrado = buscar_item(lista_param)

    if item_encontrado is not False:
        item_encontrado["nome"] = input("\n Digite o novo nome: ")
        item_encontrado["cpf"] = input("\n Digite o novo CPF: ")
        print("item atualizado com sucesso")
    else:
        print("O item nao foi encontrado")

    return lista_param


def main():

    msg_abertura()  # chama mensagem de abertura da aplicação

    # modelo de dicionario de aluno = {'código':'','nome':'','cpf':''}
    lista_alunos = popula_dados_teste()  # popula o banco para teste

    while True:  # Loop principal da aplicação. Roda enquanto não receber um BREAK

        mostra_menu_principal()  # chama o desenho do menu principal

        opcao_menu_principal = input("\t Informe o numero da opção desejada:  ")[0]

        if opcao_menu_principal == "1":  # ENTRA NO MENU DE ESTUDANTE

            while True:  # Loop no menu secundário. Roda enquanto não receber um BREAK

                mostra_submenu()

                opcao_submenu1 = input("\t Informe o número da opção desejada: ")

                match opcao_submenu1:
                    case "1":  # Opção de incluir

                        novo_item = {"codigo": len(lista_alunos), "nome": input("\t Informe o NOME a ser inserido:  "),
                                     "cpf": input("\t Informe o CPF a ser inserido:  ")}

                        lista_alunos = inserir_item(novo_item, lista_alunos)

                        msg_enter_continua()

                    case "2":  # Opção de listar
                        print("\t RELAÇÃO DOS ALUNOS CADASTRADOS")

                        listar_itens(lista_alunos)

                        msg_enter_continua()

                    case "3":  # Opção de EDITAR

                        lista_alunos = editar_item(lista_alunos)

                        msg_enter_continua()

                    case "4":  # Opção de EXCLUIR

                        lista_alunos = remover_item(lista_alunos)

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

            print("\t *** EM DESENVOLVIMENTO **** ")
            msg_enter_continua()

        elif opcao_menu_principal == "9" or opcao_menu_principal == "q":  # OPÇÃO SAIR DO MENU PRINCIPAL
            msg_saida()
            exit(0)

        else:  # CASO O USUÁRIO DIGITE OPÇÃO INVALIDA
            msg_opcao_invalida()


if __name__ == "__main__":
    main()
