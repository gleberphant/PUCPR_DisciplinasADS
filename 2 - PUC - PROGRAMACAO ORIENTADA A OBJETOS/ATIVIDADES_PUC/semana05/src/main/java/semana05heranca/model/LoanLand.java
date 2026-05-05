/**
 * c. Terreno:
 * i. Financiar terrenos possui um risco de inadimplência maior por parte dos compradores.
 * ii. Por isso, cada parcela precisa ter um acréscimo de 2% sobre o seu valor com os juros já incluídos previamente.
 */

package semana05heranca.model;

public class LoanLand extends Loan {
    /**
     * Construtor
     *
     * @param id código de identificação
     * @param price O preço do bem a ser financiado.
     * @param term  O prazo do financiamento em meses.
     * @param fee   A taxa de juros do financiamento.
     * @throws IllegalArgumentException Se o preço, o prazo ou a taxa forem inválidos.
     */
    public LoanLand(String id, double price, int term, double fee) throws IllegalArgumentException {

        super(id, price, term, fee);
        type = "TERRENO";
    }

    @Override
    public double getPaymentValueMonthly() {
        return super.getPaymentValueMonthly() * 1.02;
    }

}
