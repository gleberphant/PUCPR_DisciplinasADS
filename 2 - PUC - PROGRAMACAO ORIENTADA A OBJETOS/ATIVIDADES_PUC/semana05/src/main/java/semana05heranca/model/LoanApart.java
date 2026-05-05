/**
 * b. Apartamento:
 * i. De acordo com as regras do banco, todos os financiamentos de apartamentos deverão usar um sistema de amortização chamado PRICE. Este sistema já é usado por vários bancos.
 */


package semana05heranca.model;

import static java.lang.Math.pow;

public class LoanApart extends Loan {


    /**
     * Construtor
     *
     * @param id    código de identificação
     * @param price O preço do bem a ser financiado.
     * @param term  O prazo do financiamento em meses.
     * @param fee   A taxa de juros do financiamento.
     * @throws IllegalArgumentException Se o preço, o prazo ou a taxa forem inválidos.
     */
    public LoanApart(String id, double price, int term, double fee) throws IllegalArgumentException {

        super(id, price, term, fee);
        type = "APARTAMENTO";
    }

    @Override
    public double getPaymentValueMonthly() {
        double mensalFee = getFee() / 12;

        return (this.getPrice() * pow(1 + mensalFee, this.getTerm())) / pow(1 + mensalFee, this.getTerm() - 1);
    }
}
