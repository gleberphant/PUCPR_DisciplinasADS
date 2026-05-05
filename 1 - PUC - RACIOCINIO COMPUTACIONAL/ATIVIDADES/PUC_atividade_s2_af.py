""" Sitema de gestão academica - PUCPR VS2"""
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
# │   Atividade FORMATIVA 1 - semana 2                          │
# └─────────────────────────────────────────────────────────────┘

if __name__ == "__main__":

    # Mensagem de boas vindas
    print("")
    print(" ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░")
    print(" ░░░░░░░░░░SISTEMA DE GESTÃO ACADÊMICA░░░░░░░░")
    print(" ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░")
    print(" ░░░░ por: HANDERSON GLEBER (gravatinha) ░░░░░")
    print(" ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░")
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

    opcao_menu_principal = input("\t Informe o numero da opção desejada:  ")

    if opcao_menu_principal == "1" or opcao_menu_principal == "2" or opcao_menu_principal == "3" or opcao_menu_principal == "4" or opcao_menu_principal == "5":
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

        if opcao_submenu1 == "1" or opcao_submenu1 == "2" or opcao_submenu1 == "3" or opcao_submenu1 == "4" or opcao_submenu1 == "9":
            print("")
            print(" ╔════════════════════════════════════════════╗")
            print(" ║            EM DESENVOLVIMENTO              ║")
            print(" ╚════════════════════════════════════════════╝")
            print("")
        else:
            print("\t ---  OPÇÃO INVÁLIDA  --- \n")
            input("\t\t pressione <ENTER> para continua")
            exit(0)

    elif opcao_menu_principal == "9":
        print(" ╔════════════════════════════════════════════╗")
        print(" ║      Dúvidas e sugestões?                  ║")
        print(" ║      Entre em contato por                  ║")
        print(" ║      handerson.gleber@gmail.com            ║")
        print(" ╚════════════════════════════════════════════╝")
        exit(0)
    else:
        print("\t ---  OPÇÃO INVÁLIDA  --- \n")
        input("\t\t pressione <ENTER> para continua")
        exit(0)
