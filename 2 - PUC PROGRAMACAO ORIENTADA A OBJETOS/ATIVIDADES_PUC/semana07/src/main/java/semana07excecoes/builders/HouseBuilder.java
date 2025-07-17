package semana07excecoes.builders;

import semana07excecoes.utils.exceptions.LoanException;
import semana07excecoes.model.HouseLoan;


public class HouseBuilder extends LoanBuilder {
    private double buildArea, landArea;

    public HouseBuilder BuildArea(double buildArea) {
        this.buildArea = buildArea;
        return this;
    }

    public HouseBuilder LandArea(double landArea) {
        this.landArea = landArea;
        return this;
    }

    @Override
    public HouseLoan build() throws LoanException {

        // Cria o novo objeto
        HouseLoan newLoan = new HouseLoan(getId(), getPrice(), getTerm(), getFee(), this.buildArea, this.landArea);

        // incrementar o contador de criação
        nextCount();

        // Retorna objeto criado
        return newLoan;
    }


}
