""" Sistema de gestão academica - pucpr S4"""
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
# │   Atividade Somativa 1 - semana 4                           │
# └─────────────────────────────────────────────────────────────┘

# O que devo desenvolver?
# - Desenvolva as funcionalidades de incluir e listar estudantes
# - Apenas o nome do estudante deve ser perguntado ao usuário
# - Os nomes dos estudantes devem ser armazenados em uma lista.
# - Para a funcionalidade de listar, deve ser utilizada uma estrutura de repetição para percorrer a lista
# - e mostrar os nomes cadastrados – ver Figura 1.
# - Caso a lista de estudantes esteja vazia quando a opção de listar for acionada, deve-se mostrar uma mensagem
# - “Não há estudantes cadastrados”.
# - Caso o usuário selecione as opções professores, disciplinas, turmas ou matrículas no menu principal,
# - o sistema deve mostrar a mensagem “EM DESENVOLVIMENTO”, e mostrar novamente o menu principal.
# - Caso o usuário selecione as opções atualizar ou excluir no menu de operações do estudante,
# - o sistema deve mostrar a mensagem “EM DESENVOLVIMENTO”, e mostrar novamente o menu de operações.


if __name__ == "__main__":

    # inicia a base de dados de  alunos
    lista_alunos = []
    gerador_codigo = 0

    # código para popular o banco com dados de teste
    # for i in range(5):
    #     lista_alunos.append((str(gerador_codigo), "Aluno_" + str(i)))
    #     gerador_codigo += 1

    print("")
    print(" ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░")
    print(" ░░░░░░░░░░SISTEMA DE GESTÃO ACADÊMICA░░░░░░░░")
    print(" ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░")
    print(" ░░░░ por: HANDERSON GLEBER (gravatinha) ░░░░░")
    print(" ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░")
    print("")

    while True:  # Loop principal da aplicação. Deve rodar enquanto não receber um BREAK

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

        opcao_menu_principal = input(" Informe o número da opção desejada: ")

        if opcao_menu_principal == '1':  # ENTRA NO MENU DE ESTUDANTE

            while True:  # Loop no menu secundário. Roda enquanto não receber um BREAK

                print("┌──────────────[ MENU OPERAÇÕES ]───────────────┐")
                print("│                                               │")
                print("│ (1) Incluir.                                  │")
                print("│ (2) Listar.                                   │")
                print("│ (3) Editar.                                   │")
                print("│ (4) Excluir.                                  │")
                print("│                                               │")
                print("│ (9) Voltar.                                   │")
                print("│                                               │")
                print("└───────────────────────────────────────────────┘")

                opcao_submenu = input(" Informe o número da opção desejada: ")

                match opcao_submenu:
                    case '1':  # Opção de incluir
                        novo_aluno = input("\t Informe o NOME do aluno a ser inserido:  ")
                        lista_alunos.append((str(gerador_codigo), novo_aluno))
                        gerador_codigo += 1

                    case '2':  # Opção de listar
                        print("")
                        print("┌───────────────────────────────────────────────┐")
                        print("│        RELAÇÃO DOS ALUNOS CADASTRADOS         │")
                        print("│                                               │")

                        if len(lista_alunos) > 0:
                            print("├────────┬──────────────────────────────────────┤")
                            print("│ Código │ Nome                                 │")
                            for aluno in lista_alunos:
                                print("├────────┼──────────────────────────────────────┤")
                                print(f"│ {aluno[0]:^6} │ {aluno[1]:<36} │")

                            print("└────────┴──────────────────────────────────────┘")
                        else:
                            print("│                                               │")
                            print("│       *** Não há aluno cadastrado ***         │")
                            print("│                                               │")
                            print("└───────────────────────────────────────────────┘")

                        input("\t pressione <ENTER> para continuar")

                    case '3':  # Opção de EDITAR
                        # inicia as variáveis de controle
                        codigo_editar = ' '
                        aluno_encontrado = False

                        # filtro de entrada - laço obriga usuário digitar um número
                        while True:
                            codigo_editar = input("\n Digite o código do aluno que deseja editar : ")
                            if codigo_editar.isdigit():
                                break
                            else:
                                print("*** código inválido. **** ")
                                print("*** digite um código númérico. **** ")

                        # laço para procurar o aluno informado
                        for i, aluno in enumerate(lista_alunos):

                            # aluno encontrado
                            if aluno[0] == codigo_editar:

                                aluno_encontrado = True
                                novo_nome = input("\n\t Digite o novo nome do aluno: ")

                                try:  # tenta atualizar o aluno
                                    lista_alunos[i] = (codigo_editar, novo_nome)
                                except Exception as erro:  # se ocorrer um erro
                                    print(" *** ocorreu um erro quando estava atualizando o aluno **** \n Erro = ", erro)
                                else:  # se funcionar
                                    print("\t╔═══════════════════════════════════════════╗")
                                    print(f"\t║ *** ALUNO {codigo_editar:<4} ATUALIZADO COM SUCESSO *** ║")
                                    print("\t╚═══════════════════════════════════════════╝")
                                finally:  # em qualquer caso quebra o laço de busca
                                    break

                        # caso o aluno não seja encontrado
                        if not aluno_encontrado:
                            print("\t╔══════════════════════════╗")
                            print("\t║   aluno não encontrado   ║")
                            print("\t╚══════════════════════════╝")

                        # final da opção
                        input("\t pressione <ENTER> para continuar")

                    case '4':  # Opção de EXCLUIR
                        # inicia as variáveis de controle locais
                        codigo_remover = ' '
                        aluno_encontrado = False

                        # filtro de entrada - laço obriga usuário digitar um número
                        while True:
                            codigo_remover = input("\n Digite o Codigo do aluno para remover: ")

                            if codigo_remover.isdigit():
                                break
                            else:
                                print("*** código inválido. **** ")
                                print("*** Digite um código númérico. **** ")

                        # laço para procurar o aluno informado
                        for i, aluno in enumerate(lista_alunos):

                            # aluno encontrado
                            if aluno[0] == codigo_remover:

                                aluno_encontrado = True

                                # loop de confirmação de exclusão
                                while True:
                                    print("\t╔════════════════════════════════════════════════════════════╗")
                                    print(f"\t║    tem certeza que deseja excluir {aluno[1]:^20} ?   ║")
                                    print("\t╚════════════════════════════════════════════════════════════╝")
                                    confirmacao = input("\t Digite [S] para SIM  ou [N] para NÃO ").upper()

                                    # Resposta SIM - deletar o aluno
                                    if confirmacao == "S":
                                        try:
                                            del lista_alunos[i]
                                        except Exception as erro:
                                            print("*** falha na exclusao *** \n Erro :", erro)
                                        else:
                                            print("\t╔═══════════════════════════════════════════╗")
                                            print(f"\t║ **** ALUNO {codigo_remover:<4} EXCLUIDO COM SUCESSO **** ║")
                                            print("\t╚═══════════════════════════════════════════╝")

                                        finally:
                                            break  # quebra o laço while de confirmação da exclusão

                                    # resposta NÃO - cancelar exclusão
                                    elif confirmacao == "N":
                                        print("\t╔════════════════════════╗")
                                        print("\t║   EXCLUSÃO CANCELADA   ║")
                                        print("\t╚════════════════════════╝")
                                        break  # quebra o laço while de confirmação da exclusão

                                    # resposta inválida
                                    else:
                                        print("\t╔════════════════════╗")
                                        print("\t║   OPÇÃO INVÁLIDA   ║")
                                        print("\t╚════════════════════╝")

                                break  # quebra o laço for de busca do aluno

                            # caso o aluno nao tenha sido encontrado
                            else:
                                aluno_encontrado = False

                        if not aluno_encontrado:
                            print("\t╔══════════════════════════╗")
                            print("\t║   Aluno não encontrado   ║")
                            print("\t╚══════════════════════════╝")

                            input(" pressione <ENTER> para continuar")

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
            print("\n \t Opção inválida \n ")

    exit()
