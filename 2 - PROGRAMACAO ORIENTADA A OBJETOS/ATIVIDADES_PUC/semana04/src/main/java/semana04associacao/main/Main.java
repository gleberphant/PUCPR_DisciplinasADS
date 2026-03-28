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
 * @version atividade_somativa_1 - semana_004
 * REQUISITOS
 * 1. Todos os requisitos das semanas anteriores.
 * 2. No main(), adicione quatro financiamentos em um ArrayList. Cada financiamento será um objeto instanciado da classe financiamento.
 * 3. Após adicionar todos os financiamentos, mostre na tela o valor total de todos os imóveis e o valor total de todos os financiamentos.
 */

package semana04associacao.main;


import semana04associacao.model.Loan;
import semana04associacao.util.LoanBuilder;
import semana04associacao.util.UserInterface;

import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;


/**
 * Classe PRINCIPAL.
 * Contêm o loop central da aplicação.
 * @author HANDERSON GLEBER
 */
public class Main {

    public static void main(String[] args) {

        // Declaração e inicialização das variáveis.
        double propertyPrice;
        int loanTerm;
        double loanFee;
        boolean running = true;
        double totalPriceProperty = 0f, totalPriceLoan = 0f;

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
                propertyPrice = appInterface.Input().price();
                loanTerm = appInterface.Input().term();
                loanFee = appInterface.Input().fee();

                // Cria objeto financiamento e adiciona a lista.
                listLoans.add(
                        loanBuilder
                                .Price(propertyPrice)
                                .Term(loanTerm)
                                .Fee(loanFee)
                                .build()
                );
            }
            catch (InputMismatchException | IllegalArgumentException e) {
                appInterface.viewException(e);  // Exibe Exception.
                continue;  // Reinicia o loop.
            }

            // Percorre a lista com todos os financiamentos
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


