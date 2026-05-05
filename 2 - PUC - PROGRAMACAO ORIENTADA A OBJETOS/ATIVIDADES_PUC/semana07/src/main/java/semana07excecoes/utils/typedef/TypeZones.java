/**
 * TYPEDEF ENUM TIPOS DE FINANCIAMENTOS
 */

package semana07excecoes.utils.typedef;

import java.util.Arrays;

public enum TypeZones {
    COMERCIAL, RESIDENCIAL;


    static boolean isValid(String value) {
        try {
            valueOf(value);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public boolean has(String value) {
        String array = Arrays.toString(TypeZones.values());
        return array.contains(value);
    }
}