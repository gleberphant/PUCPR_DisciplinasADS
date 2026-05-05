package semana06abstracao.util;

import semana06abstracao.model.Loan;
import semana06abstracao.model.LoanLand;

public class LandBuilder extends LoanBuilder{
    private String zone;

    public LandBuilder Zone(String zone) {
        this.zone = zone;
        return this;
    }

    @Override
    public Loan build() throws IllegalArgumentException {

        // Cria o novo objeto
        Loan newLoan = new LoanLand(getId(), getPrice(), getTerm(), getFee(), this.zone);

        // incrementar o contador de criação
        nextCount();

        // Retorna objeto criado
        return newLoan;
    }
}
