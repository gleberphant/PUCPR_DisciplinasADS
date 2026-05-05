package semana08arquivos.utils.constants;

/**
 * Constantes para validação dos dados de financiamento.
 */
public abstract class LoanConstants {

    /**
     * Expressão regular para validar IDs.
     */
    public static final String ID_PATTERN = "^[0-9]\\d*$";

    /**
     * Valor mínimo para o preço.
     */
    public static final float MIN_PRICE = 0.0f;

    /**
     * Valor máximo para a taxa.
     */
    public static final float MAX_FEE = 200f;

    /**
     * Valor mínimo para a taxa.
     */
    public static final float MIN_FEE = 0.0f;

    /**
     * Valor máximo para o prazo.
     */
    public static final int MAX_TERM = 600;

    /**
     * Valor mínimo para o prazo.
     */
    public static final int MIN_TERM = 0;

    /**
     * Valor mínimo para o seguro.
     */
    public static final double MIN_INSURANCE = 0.0f;

    /**
     * Valor mínimo para o area construída.
     */
    public static final double MIN_BUILD_AREA = 0.0f;

    /**
     * Valor mínimo para tamanho do terreno.
     */
    public static final double MIN_LAND_AREA = 0.0f;

    /**
     * Valor mínimo para quantidade de garagens.
     */
    public static final int MIN_GARAGES = 0;

    /**
     * Valor mínimo para andar mínimo. Considerar possibilidade de subsolo.
     */
    public static final int MIN_FLOOR = -30;

    /**
     * Valor da taxa em razão do risco de inadimplência de terreno.
     */
    public static final double LAND_RISK_INCRISE = 1.02f;

}
