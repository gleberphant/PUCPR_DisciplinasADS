/**
 * TYPEDEF ENUM TIPOS DE FINANCIAMENTOS
 */

package semana08arquivos.utils.typedef;

import java.util.Arrays;

public enum TypeLoans {
    APARTMENT, HOUSE, LAND, LOAN;


    static boolean isValid(String value) {
        try {
            valueOf(value);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public boolean has(String value) {
        String array = Arrays.toString(TypeLoans.values());
        return array.contains(value);
    }
}
