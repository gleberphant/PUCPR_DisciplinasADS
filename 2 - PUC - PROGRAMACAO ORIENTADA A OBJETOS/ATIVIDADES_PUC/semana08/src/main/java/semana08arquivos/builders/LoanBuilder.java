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

package semana08arquivos.builders;


import semana08arquivos.utils.exceptions.LoanException;
import semana08arquivos.model.Loan;

/**
 * Classe 'Builder'. Responsável pela construção dos financiamentos.
 *
 * @author HANDERSON GLEBER
 * @version 2.0
 */
public abstract class LoanBuilder {

    // atributos
    private int count;
    private int term;
    private double price, fee;

    /**
     * Construtor - reset todos atributos internos
     */
    public LoanBuilder() {
        price = 0.0f;
        term = 0;
        fee = 0.0f;
        count = 0;
    }


    /**
     * "Método_Builder" - Step price
     * @return LoanBuilder
     */
    public LoanBuilder Id(int id) {
        this.count = id;
        return this;
    }

    /**
     * "Método_Builder" - Step price
     * @return LoanBuilder
     */
    public LoanBuilder Price(double price) {
        this.price = price;
        return this;
    }

    /**
     * "Método_Builder" - Step term
     *
     * @return LoanBuilder
     */
    public LoanBuilder Term(int term) {
        this.term = term;
        return this;
    }

    /**
     * "Método_Builder" - Step Fee
     * @return LoanBuilder
     */
    public LoanBuilder Fee(double fee) {
        this.fee = fee;
        return this;
    }

    /**
     * Função abstrata que deve ser implementada pelas subclasses.
     *
     * @return Loan
     */
    public abstract Loan build() throws LoanException;

    /**
     * contador interno
     */
    protected void nextCount() {
        count++;
    }

    /**
     * getters para as subclasses
     * @return Loan
     */
    protected String getId() {
        return (String.valueOf(count));
    }

    /**
     * getter para as subclasses
     *
     * @return term
     */
    protected int getTerm() {
        return term;
    }

    /**
     * getter para as subclasses
     *
     * @return price
     */
    protected double getPrice() {
        return price;
    }

    /**
     * getter para as subclasses
     *
     * @return fee
     */
    protected double getFee() {
        return fee;
    }
}
