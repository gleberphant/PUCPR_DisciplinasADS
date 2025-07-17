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
 * @version af_semana_005
 *
 * REQUISITOS
 * 1. Todos os requisitos das semanas anteriores.
 * 2. Crie três subclasses para Financiamento:
 * a. Casa:
 * i. O banco inclui um valor do seguro obrigatório do financiamento para cada casa financiada. Portanto, inclua um valor adicional de R$ 80 para cada parcela.
 * ii. Este valor de R$ 80 deve ser adicionado depois de ter calculado o valor de cada parcela com os juros.
 * b. Apartamento:
 * i. De acordo com as regras do banco, todos os financiamentos de apartamentos deverão usar um sistema de amortização chamado PRICE. Este sistema já é usado por vários bancos.
 * c. Terreno:
 * i. Financiar terrenos possui um risco de inadimplência maior por parte dos compradores.
 * ii. Por isso, cada parcela precisa ter um acréscimo de 2% sobre o seu valor com os juros já incluídos previamente.
 * 3. No main() substitua os quatro financiamentos de financiamento por dois financiamentos de casa, dois financiamentos de apartamento e um de terreno.
 * a. Todos os financiamentos deverão permanecer num único ArrayList.
 * b. Digitar todas as informações a cada teste é chato. Somente peça os dados do usuário para um financiamento.
 * c. Para os demais financiamentos você poderá informar os dados diretamente no código dentro do seu main().
 * d. Mantenha ainda o texto que mostra a soma dos valores dos imóveis e a soma dos valores dos financiamentos.
 */

package semana05heranca.main;


import semana05heranca.model.Loan;
import semana05heranca.util.LoanBuilder;
import semana05heranca.util.UserInterface;

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

        LoanBuilder loanBuilder = new LoanBuilder();

        // Mensagem de abertura
        appInterface.viewOpening();

        // Loop principal da aplicação. termina somente quando usuário pedir para sair
        do {


            // Bloco try para captar exceções de tipo entrada inválida ou de valor inválido.
            try {
                // Leitura dos dados do financiamento.
                loanType = appInterface.in().promptType();

                // Cria objeto financiamento e adiciona na lista.
                listLoans.add(
                        loanBuilder
                                .Type(loanType)
                                .Price(appInterface.in().promptPrice())
                                .Term(appInterface.in().promptTerm())
                                .Fee(appInterface.in().promptFee())
                                .build()
                );
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


