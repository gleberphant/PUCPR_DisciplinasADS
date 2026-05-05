""" sitema de gestão academica - pucpr VS5"""
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
# │   Atividade FORMATIVA 3 - semana 5                          │
# └─────────────────────────────────────────────────────────────┘
#
# O que devo desenvolver?
# - Ao incluir, listar ou editar um estudante, as seguintes informações devem ser utilizadas:
# - ódigo do estudante (Número inteiro).
# - Nome do estudante (String).
# - CPF do estudante (String).
# - Os dados do estudante devem ser armazenados em um dicionário ou tupla, que por sua vez, devem ser adicionados à uma lista.
# - Desenvolver a funcionalidade de excluir um estudante, onde deve ser perguntado ao usuário qual o código do estudante que ele deseja excluir, para então remover o estudante correspondente da lista. Lembre-se que você deve percorrer a lista e encontrar uma tupla ou dicionário que contenha o código igual ao informado, e então excluir esta estrutura da lista.
# - Desenvolver a funcionalidade de editar um estudante, onde deve ser perguntado ao usuário o código do estudante que se deseja editar, e então realizar a entrada dos dados correspondentes a todos dados do estudante (código, nome e cpf). Após isso, estes dados devem ser atualizados no dicionário ou tupla correspondente dentro da lista de estudantes.

if __name__ == "__main__":
    # modelo de dicionario de aluno = {'código':'','nome':'','cpf':''}
    lista_alunos = []  # popula o banco com dados de teste

    for i in range(5):
        lista_alunos.append({"codigo": 11 * i, "nome": "teste_" + str(i), "cpf": str(i) * 6})

    print("")
    print(" ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░")
    print(" ░░░░░░░░░░SISTEMA DE GESTÃO ACADÊMICA░░░░░░░░")
    print(" ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░")
    print(" ░░░░ por: HANDERSON GLEBER (gravatinha) ░░░░░")
    print(" ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░")
    print("")

    while True:  # Loop principal da aplicação. Roda enquanto não receber um BREAK

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

        opcao_menu_principal = input("\t Informe o numero da opção desejada:  ")[0]

        if opcao_menu_principal == '1':  # ENTRA NO MENU DE ESTUDANTE

            while True:  # Loop no menu secundário. Roda enquanto não receber um BREAK

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

                opcao_submenu1 = input("\t Informe o número da opção desejada: ")

                match opcao_submenu1:
                    case '1':  # Opção de incluir
                        novo_aluno = {"codigo": len(lista_alunos), "nome": input("\t Informe o NOME a ser inserido:  "),
                                      "cpf": input("\t Informe o CPF a ser inserido:  ")}

                        lista_alunos.append(novo_aluno)

                    case '2':  # Opção de listar
                        print("")
                        print("┌───────────────────────────────────────────────┐")
                        print("│           LISTAR ALUNOS CADASTRADOS           │")
                        print("│                                               │")

                        if len(lista_alunos) > 0:
                            print("├────────┬─────────────────────────┬────────────┤")
                            print("│ COD    │ NOME                    │ CPF        │")
                            for aluno in lista_alunos:
                                print("├────────┼─────────────────────────┼────────────┤")
                                print(f"│ {aluno['codigo']:<6} │ {aluno['nome']:<23} │ {aluno['cpf']:<11}│")
                            print("└────────┴─────────────────────────┴────────────┘")
                        else:
                            print("│                                               │")
                            print("│       *** Não há aluno cadastrado ***         │")
                            print("│                                               │")
                            print("└───────────────────────────────────────────────┘")

                        input("\t pressione <ENTER> para continuar")

                    case '3':  # Opção de ATUALIZAR
                        codigo_atualizar = input("\n \t Digite o Codigo do aluno que deseja atualizar: ")

                        item_encontrado = False

                        if codigo_atualizar.isnumeric() is True:
                            for item in lista_alunos:
                                if int(codigo_atualizar) == item["codigo"]:
                                    item_encontrado = True
                                    item["nome"] = input("\n Digite o novo nome: ").upper()
                                    item["cpf"] = input("\n Digite o novo CPF: ").upper()
                                    print("\t item atualizado com sucesso")

                            if not item_encontrado:
                                print("\t aluno nao foi encontrado")
                        else:
                            print("\t╔════════════════════╗")
                            print("\t║   OPÇÃO INVÁLIDA   ║")
                            print("\t╚════════════════════╝")

                        input("\t pressione <ENTER> para continuar")

                    case '4':  # Opção de EXCLUIR

                        codigo_remover = input("\n \t Digite o Codigo do aluno para remover: ")
                        item_encontrado = False

                        if codigo_remover.isnumeric() is True:
                            for item in lista_alunos:
                                if codigo_remover == str(item["codigo"]):
                                    item_encontrado = True
                                    print(f"\t Voce tem certeza que deseja excluir ? Codigo {1} - Nome {2}: ",
                                          item["codigo"], item["nome"])

                                    if input("S ou N").upper() == "S":
                                        lista_alunos.remove(item)
                                        print(f"\t Código {1} excluido com sucesso ", codigo_remover)

                            if not item_encontrado:
                                print("Nenhum item foi encontrado com esse codigo")
                        else:
                            print("\t╔════════════════════╗")
                            print("\t║   OPÇÃO INVÁLIDA   ║")
                            print("\t╚════════════════════╝")

                        input("\t pressione <ENTER> para continuar")

                    case '9':  # Opção de SAIR
                        break

                    case _:  # CASO O USUÁRIO DIGITE OPÇÃO INVALIDA
                        print("\t╔════════════════════╗")
                        print("\t║   OPÇÃO INVÁLIDA   ║")
                        print("\t╚════════════════════╝")

        elif (opcao_menu_principal == '2'
              or opcao_menu_principal == '3'
              or opcao_menu_principal == '4'
              or opcao_menu_principal == '5'):  # OUTROS MODULOS DO MENU PRINCIPAL

            print("")
            print(" ╔════════════════════════════════════════════╗")
            print(" ║            EM DESENVOLVIMENTO              ║")
            print(" ╚════════════════════════════════════════════╝")
            print("")
            input(" pressione ENTER para continuar")

        elif opcao_menu_principal == '9' or opcao_menu_principal == 'q':  # OPÇÃO SAIR DO MENU PRINCIPAL
            print(" ╔════════════════════════════════════════════╗")
            print(" ║      Dúvidas e sugestões?                  ║")
            print(" ║      Entre em contato por                  ║")
            print(" ║      handerson.gleber@gmail.com            ║")
            print(" ╚════════════════════════════════════════════╝")
            break

        else:  # CASO O USUÁRIO DIGITE OPÇÃO INVALIDA
            print("\t╔════════════════════╗")
            print("\t║   OPÇÃO INVÁLIDA   ║")
            print("\t╚════════════════════╝")

    exit(0)
