package semana06abstracao.util;

import semana06abstracao.model.Loan;
import semana06abstracao.model.LoanApart;

public class ApartBuilder extends LoanBuilder{
    private int floorNumber, garagesCount;

    public ApartBuilder FloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
        return this;
    }

    public ApartBuilder GaragesCount(int garagesCount) {
        this.garagesCount = garagesCount;
        return this;
    }


    @Override
    public Loan build() throws IllegalArgumentException {

        // Cria o novo objeto
        Loan newLoan = new LoanApart(getId(), getPrice(), getTerm(), getFee(), this.floorNumber, this.garagesCount );

        // incrementar o contador de criação
        nextCount();

        // Retorna objeto criado
        return newLoan;
    }
}
