/**
 * a. Casa:
 * i. O banco inclui um valor do seguro obrigatório do financiamento para cada casa financiada. Portanto, inclua um valor adicional de R$ 80 para cada parcela.
 * ii. Este valor de R$ 80 deve ser adicionado depois de ter calculado o valor de cada parcela com os juros.
 */
package semana05heranca.model;

public class LoanHouse extends Loan {
    private final double INSURANCE_VALUE;
    /**
     * Construtor
     *
     * @param id código de identificação
     * @param price O preço do bem a ser financiado.
     * @param term  O prazo do financiamento em meses.
     * @param fee   A taxa de juros do financiamento.
     * @throws IllegalArgumentException Se o preço, o prazo ou a taxa forem inválidos.
     */
    public LoanHouse(String id, double price, int term, double fee) throws IllegalArgumentException {

        super(id, price, term, fee);
        type = "CASA";
        INSURANCE_VALUE = 80;
    }

    @Override
    public double getPaymentValueMonthly() {

        return super.getPaymentValueMonthly() + INSURANCE_VALUE;
    }
}
