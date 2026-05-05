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
 * @version af_semana_007
 * <p>
 * REQUISITOS
O que devo desenvolver?

1. Todos os requisitos das semanas anteriores.

2. Na classe InterfaceUsuário, modifique os métodos que criou para que tenham tratamento de exceções para lidar com situações como, por exemplo, entrada de dados inválidos.

a. Isso significa que os seus métodos deverão ter try/catch, ou try/catch/finally.

3. Na classe Casa, crie uma exceção do tipo AumentoMaiorDoQueJurosException quando o valor do acréscimo de R$ 80 for maior do que o valor dos juros da mensalidade.

a. Isso significa que esta classe deverá usar o throw. Também, você terá de criar o AumentoMaiorDoQueJurosException, segundo os exemplos da semana.
 */

package semana07excecoes.main;


import semana07excecoes.builders.*;
import semana07excecoes.utils.exceptions.InterfaceException;
import semana07excecoes.utils.exceptions.LoanException;
import semana07excecoes.model.Loan;
import semana07excecoes.ui.*;

import java.util.InputMismatchException;
import java.util.LinkedList;


/**
 * Classe PRINCIPAL.
 * Contêm o loop central da aplicação.
 *
 * @author HANDERSON GLEBER
 */
public class Main {

    public static void main(String[] args) {
        // Declaração e inicialização das variáveis.
        char loanType;
        boolean running = true;
        double totalPriceProperty, totalPriceLoan;

        // Declaração e inicialização de array de financiamentos
        LinkedList<Loan> listLoans = new LinkedList<>();

        // Declaração e inicialização da interface
        UserInterface appInterface = UserInterface.getInstance().initialize();

        LoanBuilder loanBuilder;

        // Mensagem de abertura
        appInterface.viewOpening();

        // Loop principal da aplicação. termina somente quando usuário pedir para sair
        do {

            // Bloco try para captar exceções de tipo entrada inválida ou de valor inválido.
            try {
                // Leitura dos dados do financiamento.
                loanType = appInterface.in().promptType();

                // define o item de financiamento
                loanBuilder = switch (loanType) {

                    case '1' -> new HouseBuilder()
                            .LandArea(appInterface.in().promptLandArea())
                            .BuildArea(appInterface.in().promptBuildArea());

                    case '2' -> new ApartBuilder()
                            .FloorNumber(appInterface.in().promptFloor())
                            .GaragesCount(appInterface.in().promptGarages());

                    case '3' -> new LandBuilder()
                            .Zone(appInterface.in().promptZone());

                    default -> throw new InterfaceException("Valor inválido. Digite um número decimal.");

                };

                // Conclui a criação do financiamento e adiciona na lista.
                listLoans.add(loanBuilder
                        .Price(appInterface.in().promptPrice())
                        .Term(appInterface.in().promptTerm())
                        .Fee(appInterface.in().promptFee())
                        .build());

            } catch (LoanException | InterfaceException | InputMismatchException | IllegalArgumentException e) {
                appInterface.viewException(e);  // Exibe Exception.
                continue;  // Reinicia o loop.
            }

            // Percorre a lista com todos os financiamentos
            totalPriceProperty = 0f;
            totalPriceLoan = 0f;

            for (Loan item : listLoans) {
                // Exibe o financiamento
                appInterface.viewLoan(item);

                //  Soma os valores totais do financiamento.
                totalPriceLoan += item.getPaymentValueTotal();
                totalPriceProperty += item.getPrice();
            }

            // Exibe o total de todos financiamentos
            appInterface.viewTotals(totalPriceProperty, totalPriceLoan);

            // Pergunta se o usuário deseja sair ou inserir outro financiamento.
            running = appInterface.promptExit();

        } while (running);

        // encerramento da aplicação
        appInterface.viewClosure();

    }
}


