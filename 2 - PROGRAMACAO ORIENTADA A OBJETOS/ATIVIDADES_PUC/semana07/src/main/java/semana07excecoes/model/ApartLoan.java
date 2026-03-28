/**
 * b. Apartamento:
 * i. De acordo com as regras do banco, todos os financiamentos de apartamentos deverão usar um sistema de amortização chamado PRICE. Este sistema já é usado por vários bancos.
 * <p>
 * <p>
 * b. Apartamento:
 * i. Incluir um atributo para o número de vagas da garagem, e outro atributo para o número do andar.
 */


package semana07excecoes.model;

import semana07excecoes.utils.exceptions.InvalidFloorException;
import semana07excecoes.utils.exceptions.InvalidGarageException;
import semana07excecoes.utils.exceptions.LoanException;
import semana07excecoes.utils.typedef.TypeLoans;

import static semana07excecoes.utils.constants.LoanConstants.*;

import static java.lang.Math.pow;

public class ApartLoan extends Loan {


    // atributos exclusivos da classe filha
    private int floorNumber, garagesCount;

    /**
     * Construtor
     *
     * @param id    código de identificação
     * @param price O preço do bem a ser financiado.
     * @param term  O prazo do financiamento em meses.
     * @param fee   A taxa de juros do financiamento.
     * @throws LoanException Se o preço, o prazo ou a taxa forem inválidos.
     */
    public ApartLoan(String id, double price, int term, double fee, int floorNumber, int garagesCount) throws LoanException {
        super(id, price, term, fee);
        setFloorNumber(floorNumber);
        setGaragesCount(garagesCount);
    }

    @Override
    protected TypeLoans type() {
        return TypeLoans.APARTMENT;
    }

    @Override
    public double getPaymentValueMonthly() {
        double mensalFee = getFee() / 12;

        return (this.getPrice() * pow(1 + mensalFee, this.getTerm())) / pow(1 + mensalFee, this.getTerm() - 1);
    }

    public void setGaragesCount(int garagesCount) throws LoanException {
        if (garagesCount < MIN_GARAGES) {
            throw new InvalidGarageException("Garagem precisa ser um número positivo válido.");
        }

        this.garagesCount = garagesCount;
    }

    public void setFloorNumber(int floorNumber) throws LoanException {
        if (floorNumber < MIN_FLOOR) {
            throw new InvalidFloorException("Numero do andar precisa ser um número inteiro positivo.");
        }

        this.floorNumber = floorNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getGaragesCount() {
        return garagesCount;
    }

}
