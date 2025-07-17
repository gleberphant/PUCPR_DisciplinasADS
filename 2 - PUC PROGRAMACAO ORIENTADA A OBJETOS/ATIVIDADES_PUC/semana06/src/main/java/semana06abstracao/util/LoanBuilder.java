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

package semana06abstracao.util;


import semana06abstracao.model.Loan;


/**
 * Classe 'Builder'. Responsável pela construção dos financiamentos.
 *
 * @author HANDERSON GLEBER
 * @version 2.0
 */
public abstract class LoanBuilder {

    // atributos
    private static int count;

    private int term;
    private double price, fee;


    /**
     * Construtor
     */
    public LoanBuilder() {
        term = 0;
        count = 0;
        price = 0.0f;
        fee = 0.0f;
    }

    /**
     * "Método_Construtor" de atributo
     *
     * @return LoanBuilder
     */
    public LoanBuilder Term(int term) {

        this.term = term;
        return this;
    }

    /**
     * "Método_Construtor" de atributo
     *
     * @return LoanBuilder
     */
    public LoanBuilder Price(double price) {

        this.price = price;
        return this;
    }

    /**
     * "Método_Construtor" de atributo
     *
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
    public abstract Loan build();

    /**
     * méthod para criar o id do objeto a ser criado conforme o contador interno.
     *
     * @return Loan
     */
    public String getId() {
        return (String.valueOf(count));
    }

    /**
     * getters para as subclasses
     *
     * @return Loan
     */
    public int getTerm() {
        return term;
    }

    public double getPrice() {
        return price;
    }

    public double getFee() {
        return fee;
    }

    public static void nextCount() {
        count++;
    }
}
