/**
 * a. Casa:
 * i. O banco inclui um valor do seguro obrigatório do financiamento para cada casa financiada. Portanto, inclua um valor adicional de R$ 80 para cada parcela.
 * ii. Este valor de R$ 80 deve ser adicionado depois de ter calculado o valor de cada parcela com os juros.
 * a. Casa:
 * i. Incluir um atributo para o tamanho da área construída, e outro atributo para o tamanho do terreno.
 */
package semana06abstracao.model;

public class LoanHouse extends Loan {

    private final double insuranceVALUE;
    private final double buildArea;
    private final double landArea;

    /**
     * Construtor
     *
     * @param id        código de identificação
     * @param price     O preço do bem a ser financiado.
     * @param term      O prazo do financiamento em meses.
     * @param fee       A taxa de juros do financiamento.
     *
     * @throws IllegalArgumentException Se o preço, o prazo ou a taxa forem inválidos.
     */
    public LoanHouse(String id, double price, int term, double fee, double buildArea, double landArea) throws IllegalArgumentException {

        super(id, price, term, fee);
        this.buildArea = buildArea;
        this.landArea = landArea;
        this.insuranceVALUE = 80;
        typeString = "CASA";


    }

    @Override
    public double getPaymentValueMonthly() {

        return super.getPaymentValueMonthly() + insuranceVALUE;
    }

    public double getInsuranceVALUE() {
        return insuranceVALUE;
    }

    public double getBuildArea() {
        return buildArea;
    }

    public double getLandArea() {
        return landArea;
    }
}
