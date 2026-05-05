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
 * @version af_semana_006
 * <p>
 * REQUISITOS
 * O que devo desenvolver?
 * 1. Todos os requisitos das semanas anteriores.
 * 2. Converter a classe financiamento para uma classe abstrata.
 * a. Mover todos os métodos comuns para essa classe.
 * b. Fazer com que as subclasses concretas (casa, apartamento e terreno) implementem os métodos definidos por essa classe.
 * 3. Para as três subclasses de financiamento incluir novos atributos específicos a cada uma das subclasses:
 * a. Casa:
 * i. Incluir um atributo para o tamanho da área construída, e outro atributo para o tamanho do terreno.
 * b. Apartamento:
 * i. Incluir um atributo para o número de vagas da garagem, e outro atributo para o número do andar.
 * c. Terreno:
 * i. Incluir um atributo para o tipo de zona (exemplo: residencial ou comercial).
 * 4. Modificar o main() para que você consiga cadastrar os diferentes financiamentos considerando esses novos atributos.
 */

package semana06abstracao.main;


import semana06abstracao.model.Loan;
import semana06abstracao.util.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;


/**
 * Classe PRINCIPAL.
 * Contêm o loop central da aplicação.
 * @author HANDERSON GLEBER
 */
public class Main {

    public static void main(String[] args) {
        // Declaração e inicialização das variáveis.
        char loanType;
        boolean running = true;
        double totalPriceProperty, totalPriceLoan;

        // Declaração e inicialização de array de financiamentos
        List<Loan> listLoans = new ArrayList<>();

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

                    default -> throw new InputMismatchException("Valor inválido. Digite um número decimal.");

                };

                // Conclui a criação do financiamento e adiciona na lista.
                listLoans.add(loanBuilder
                        .Price(appInterface.in().promptPrice())
                        .Term(appInterface.in().promptTerm())
                        .Fee(appInterface.in().promptFee())
                        .build());

            } catch (InputMismatchException | IllegalArgumentException | IllegalStateException e) {
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


