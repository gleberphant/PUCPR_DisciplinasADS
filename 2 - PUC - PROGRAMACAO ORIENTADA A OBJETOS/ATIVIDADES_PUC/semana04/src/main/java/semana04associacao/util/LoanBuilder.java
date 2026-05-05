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
 */

package semana04associacao.util;


import semana04associacao.model.Loan;

/**
 * Classe 'Builder'. Responsável pela construção dos financiamentos.
 *
 * @author HANDERSON GLEBER
 */
public class LoanBuilder {
    // atributos
    private int term, count;
    private double price, fee;
    private String id;

    /**
     * Construtor
     */
    public LoanBuilder() {
        id = "1";
        term = 0;
        count = 0;
        price = 0.0f;
        fee = 0.0f;
    }

    /**
     * "Método_Construtor" de atributo
     * @return LoanBuilder
     */
    public LoanBuilder Term(int term) {

        this.term = term;
        return this;
    }

    /**
     * "Método_Construtor" de atributo
     * @return LoanBuilder
     */
    public LoanBuilder Price(double price) {

        this.price = price;
        return this;
    }

    /**
     * "Método_Construtor" de atributo
     * @return LoanBuilder
     */
    public LoanBuilder Fee(double fee) {

        this.fee = fee;
        return this;
    }

    /**
     * Instancia o objeto Loan
     * @return Loan
     */
    public Loan build() throws IllegalArgumentException {

        // define o id do novo objeto
        this.id = String.valueOf(this.count + 1);

        // Cria o novo objeto
        Loan newLoan = new Loan(this.id, this.price, this.term, this.fee);

        // incrementar o contador de criação
        this.count++;

        // Retorna objeto criado
        return newLoan;
    }

}
