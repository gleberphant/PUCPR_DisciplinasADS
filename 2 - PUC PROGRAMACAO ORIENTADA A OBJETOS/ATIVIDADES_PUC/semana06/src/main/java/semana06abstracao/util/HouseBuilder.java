package semana06abstracao.util;

import semana06abstracao.model.Loan;
import semana06abstracao.model.LoanHouse;


public class HouseBuilder extends LoanBuilder{
    private double buildArea, landArea;

    public HouseBuilder BuildArea(double buildArea){
        this.buildArea = buildArea;
        return this;
    }

    public HouseBuilder LandArea(double landArea){
        this.landArea = landArea;
        return this;
    }

    @Override
    public Loan build() throws IllegalArgumentException {

        // Cria o novo objeto
        Loan newLoan = new LoanHouse(getId(), getPrice(), getTerm(), getFee(), this.buildArea, this.landArea );

        // incrementar o contador de criação
        nextCount();

        // Retorna objeto criado
        return newLoan;
    }


}
