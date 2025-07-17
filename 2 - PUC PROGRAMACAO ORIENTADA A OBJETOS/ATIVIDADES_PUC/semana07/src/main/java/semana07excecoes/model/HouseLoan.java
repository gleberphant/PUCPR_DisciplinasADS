/**
 * a. Casa:
 * i. O banco inclui um valor do seguro obrigatório do financiamento para cada casa financiada. Portanto, inclua um valor adicional de R$ 80 para cada parcela.
 * ii. Este valor de R$ 80 deve ser adicionado depois de ter calculado o valor de cada parcela com os juros.
 * a. Casa:
 * i. Incluir um atributo para o tamanho da área construída, e outro atributo para o tamanho do terreno.
 */
package semana07excecoes.model;

import semana07excecoes.utils.exceptions.InsuranceGreaterThanMonthlyFee;
import semana07excecoes.utils.exceptions.InvalidAreaException;
import semana07excecoes.utils.exceptions.InvalidInsuranceException;
import semana07excecoes.utils.exceptions.LoanException;
import semana07excecoes.utils.typedef.TypeLoans;

import static semana07excecoes.utils.constants.LoanConstants.*;

public class HouseLoan extends Loan {

    private double insurance;
    private double buildArea;
    private double landArea;

    /**
     * Construtor
     *
     * @param id    código de identificação
     * @param price O preço do bem a ser financiado.
     * @param term  O prazo do financiamento em meses.
     * @param fee   A taxa de juros do financiamento.
     * @throws LoanException Se o preço, o prazo ou a taxa forem inválidos.
     */
    public HouseLoan(String id, double price, int term, double fee, double buildArea, double landArea) throws LoanException {

        super(id, price, term, fee);
        setBuildArea(buildArea);
        setInsurance(80);
        setLandArea(landArea);
    }

    @Override
    protected TypeLoans type() {
        return TypeLoans.HOUSE;
    }

    public void setInsurance(double insuranceVALUE) throws LoanException {
        if (insuranceVALUE < MIN_INSURANCE) {
            throw new InvalidInsuranceException("Seguro não pode ser um número negativo. ");
        }

        if (insuranceVALUE > (this.getPrice() / this.getTerm()) * ((this.getFee() / 12))) {
            throw new InsuranceGreaterThanMonthlyFee("O valor do Seguro não pode ser maior que o valor mensal dos juros . ");
        }
        this.insurance = insuranceVALUE;
    }

    public void setBuildArea(double buildArea) throws LoanException {

        if (buildArea < MIN_BUILD_AREA) {
            throw new InvalidAreaException("Área construída não pode se um valor negativo.");
        }

        if (buildArea < this.landArea) {
            throw new InvalidAreaException("Área construída não pode se maior que o tamanho do terreno.");
        }

        this.buildArea = buildArea;
    }

    public void setLandArea(double landArea) throws LoanException {
        if (landArea < MIN_LAND_AREA) {
            throw new InvalidAreaException("Área do terreno não pode ser um valor negativo.");
        }
        this.landArea = landArea;
    }

    @Override
    public double getPaymentValueMonthly() {
        return super.getPaymentValueMonthly() + insurance;
    }

    public double getInsurance() {
        return insurance;
    }

    public double getBuildArea() {
        return buildArea;
    }

    public double getLandArea() {
        return landArea;
    }
}
