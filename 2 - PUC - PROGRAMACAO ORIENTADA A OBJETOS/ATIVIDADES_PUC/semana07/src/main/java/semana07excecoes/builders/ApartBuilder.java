package semana07excecoes.builders;

import semana07excecoes.utils.exceptions.LoanException;
import semana07excecoes.model.ApartLoan;

public class ApartBuilder extends LoanBuilder {
    private int floorNumber, garagesCount;

    public ApartBuilder() {
        super();
        floorNumber = 0;
        garagesCount = 0;
    }

    public ApartBuilder FloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
        return this;
    }

    public ApartBuilder GaragesCount(int garagesCount) {
        this.garagesCount = garagesCount;
        return this;
    }

    @Override
    public ApartLoan build() throws LoanException {

        // Cria o novo objeto
        ApartLoan newLoan = new ApartLoan(getId(), getPrice(), getTerm(), getFee(), this.floorNumber, this.garagesCount);

        // incrementar o contador de criação
        nextCount();

        // Retorna objeto criado
        return newLoan;
    }
}
