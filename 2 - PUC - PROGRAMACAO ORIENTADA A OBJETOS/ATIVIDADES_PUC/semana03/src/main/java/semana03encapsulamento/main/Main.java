/**
 * ┌────────────────────────────────────────────────────────────────────────┐
 * │            ╔════╗           ╔═════        ╔════╗  ╔═══╗                │
 * │            ╠════╝  ║    ║   ║             ╠════╝  ╠═══╩╗               │
 * │            ║       ╚════╝   ╚═════        ║       ║    ║               │
 * └────────────────────────────────────────────────────────────────────────┘
 * ┌────────────────────────────────────────────────────────────────────────┐
 * │ Análise e Desenvolvimento de Sistemas                                  │
 * │ Fundamentos da Programação Orientada a Objetos (11100010550_20242_20)  │
 * └────────────────────────────────────────────────────────────────────────┘
 *
 * @author HANDERSON GLEBER DE LIMA CAVALCANTI (1112024201103)
 * @version af_semana_003
 *
 * REQUISITOS

 * 1 Reorganize as classes em pacotes:
 *     i. Model 1. Classe: a. Financiamento
 *     ii. Util 1. Classe: a. InterfaceUsuário
 *     iii. Main 1. Classe: a. Main
 * 2 Classe Financiamento (no pacote modelo):
 *     i. Todos os atributos devem ser privados.
 *     ii. Todos os métodos devem ser públicos.
 *     iii. Inclua um getter para cada um dos atributos privados.
 * 3 Classe InterfaceUsuário (no pacote ui):
 *     i. Ajuste os métodos de entrada de dados (valor do imóvel, prazo de financiamento e taxa de juros) para usarem estruturas condicionais (como if/else ou switch) dentro dos seus métodos para verificar se as entradas fornecidas pelo usuário são válidas.
 *     ii. Aceite somente valores positivos para o valor do imóvel, prazo do financiamento e taxa de juros anual.
 *     iii. Use estruturas de repetição (como do, do-while ou for). Se algum dos valores for inválido, o programa deve informar ao usuário sobre o erro e solicitar que ele insira novamente os dados.
 * 4 Mostrar na tela uma mensagem contendo os dados do financiamento
 * 5 Testar valores inválidos:
 *     i. Valor do imóvel negativo,
 *     ii. Taxa de juros muito alta (como 100.000.000% por ano)
 *     iii. Prazo de financiamento negativo?
 */

package semana03encapsulamento.main;


import semana03encapsulamento.model.Loan;
import semana03encapsulamento.model.LoanBuilder;
import semana03encapsulamento.util.UserInterface;

import java.util.InputMismatchException;


/**
 * Classe PRINCIPAL. Contem o loop central da aplicação.
 * @author HANDERSON GLEBER
 */
public class Main {

    public static void main(String[] args) {

        // instancia e inicializa a interface
        UserInterface appInterface = UserInterface.getInstance().initialize();

        // instancia as variáveis
        double propertyPrice ;
        int loanTerm ;
        double loanFee ;
        boolean running = true;

        appInterface.viewMenu();
        Loan myLoan;

        // Loop principal da aplicação. termina somente quando usuário pede para sair
        do {



            // leitura dos dados do financiamento
            try {

                propertyPrice = appInterface.getInput().price();
                loanTerm = appInterface.getInput().term();
                loanFee = appInterface.getInput().fee();

            }catch(InputMismatchException e){

                appInterface.viewException(e);
                continue;
            }

            // criar objeto financiamento e mostra seus dados
            try {
                myLoan = new LoanBuilder()
                        .Price(propertyPrice)
                        .Term(loanTerm)
                        .Fee(loanFee)
                        .build();

                appInterface.viewLoan(myLoan);

            } catch (IllegalArgumentException e) {
                appInterface.viewException(e);
            }

            running = appInterface.getInput().closeApp();

        }while(running);

        // encerramento da aplicação
        appInterface.closure();

    }
}


