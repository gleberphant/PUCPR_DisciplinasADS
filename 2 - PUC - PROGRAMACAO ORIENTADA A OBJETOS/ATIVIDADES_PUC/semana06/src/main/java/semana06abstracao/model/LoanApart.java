/**
 * b. Apartamento:
 * i. De acordo com as regras do banco, todos os financiamentos de apartamentos deverão usar um sistema de amortização chamado PRICE. Este sistema já é usado por vários bancos.
 * <p>
 * <p>
 * b. Apartamento:
 * i. Incluir um atributo para o número de vagas da garagem, e outro atributo para o número do andar.
 */


package semana06abstracao.model;

import static java.lang.Math.pow;

public class LoanApart extends Loan {
    private final int floorNumber, garagesCount;

    /**
     * Construtor
     *
     * @param id    código de identificação
     * @param price O preço do bem a ser financiado.
     * @param term  O prazo do financiamento em meses.
     * @param fee   A taxa de juros do financiamento.
     * @throws IllegalArgumentException Se o preço, o prazo ou a taxa forem inválidos.
     */
    public LoanApart(String id, double price, int term, double fee, int floorNumber, int garagesCount ) throws IllegalArgumentException {

        super(id, price, term, fee);
        this.floorNumber = floorNumber;
        this.garagesCount = garagesCount;
        typeString = "APARTAMENTO";
    }

    @Override
    public double getPaymentValueMonthly() {
        double mensalFee = getFee() / 12;

        return (this.getPrice() * pow(1 + mensalFee, this.getTerm())) / pow(1 + mensalFee, this.getTerm() - 1);
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getGaragesCount() {
        return garagesCount;
    }


}
