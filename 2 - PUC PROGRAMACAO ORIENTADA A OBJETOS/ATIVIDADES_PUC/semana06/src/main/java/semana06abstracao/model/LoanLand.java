/**
 * c. Terreno:
 * i. Financiar terrenos possui um risco de inadimplência maior por parte dos compradores.
 * ii. Por isso, cada parcela precisa ter um acréscimo de 2% sobre o seu valor com os juros já incluídos previamente.
 * c. Terreno:
 * i. Incluir um atributo para o tipo de zona (exemplo: residencial ou comercial).
 */

package semana06abstracao.model;

public class LoanLand extends Loan {

    private final String zone;

    /**
     * Construtor
     *
     * @param id código de identificação
     * @param price O preço do bem a ser financiado.
     * @param term  O prazo do financiamento em meses.
     * @param fee   A taxa de juros do financiamento.
     * @throws IllegalArgumentException Se o preço, o prazo ou a taxa forem inválidos.
     */
    public LoanLand(String id, double price, int term, double fee, String zone) throws IllegalArgumentException {

        super(id, price, term, fee);
        this.zone = zone;
        typeString = "TERRENO";
    }

    @Override
    public double getPaymentValueMonthly() {
        return super.getPaymentValueMonthly() * 1.02;
    }

    public String getZone() {
        return zone;
    }
}
