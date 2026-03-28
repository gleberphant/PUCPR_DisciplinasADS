/**
 * c. Terreno:
 * i. Financiar terrenos possui um risco de inadimplência maior por parte dos compradores.
 * ii. Por isso, cada parcela precisa ter um acréscimo de 2% sobre o seu valor com os juros já incluídos previamente.
 * c. Terreno:
 * i. Incluir um atributo para o tipo de zona (exemplo: residencial ou comercial).
 */

package semana08arquivos.model;

import semana08arquivos.utils.exceptions.InvalidInsuranceException;
import semana08arquivos.utils.exceptions.InvalidZoneException;
import semana08arquivos.utils.exceptions.LoanException;
import semana08arquivos.utils.typedef.TypeLoans;
import semana08arquivos.utils.typedef.TypeZones;

import static semana08arquivos.utils.constants.LoanConstants.*;

public class LandLoan extends Loan {

    private TypeZones zone;

    /**
     * Construtor
     *
     * @param id    código de identificação
     * @param price O preço do bem a ser financiado.
     * @param term  O prazo do financiamento em meses.
     * @param fee   A taxa de juros do financiamento.
     * @throws LoanException Se o preço, o prazo ou a taxa forem inválidos.
     */
    public LandLoan(String id, double price, int term, double fee, String zone) throws LoanException {

        super(id, price, term, fee);
        setZone(zone);

    }

    /**
     * Setter atributo
     *
     * @throws InvalidZoneException se inferior à quantidade mínima.
     */
    public void setZone(String value) throws LoanException {
        if (value.isEmpty() || !TypeZones.isValid(value)) {
            throw new InvalidZoneException("Tipo de zona precisa ser definido em COMERCIAL ou RESIDENCIAL");
        }
        this.zone = TypeZones.valueOf(value);
    }

    /**
     * Getter atributo
     */
    @Override
    public double getPaymentValueMonthly() {
        return super.getPaymentValueMonthly() * LAND_RISK_INCRISE;
    }

    /**
     * Getter atributo
     */
    public String getZone() {
        return this.zone.toString();
    }

    /**
     * Define o tipo interno
     */
    @Override
    protected TypeLoans type() {
        return TypeLoans.LAND;
    }

}
