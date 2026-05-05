/**
 * TYPEDEF ENUM TIPOS DE FINANCIAMENTOS
 */

package semana08arquivos.utils.typedef;

import java.util.Arrays;

public enum TypeZones {
    COMERCIAL, RESIDENCIAL;


    public static boolean isValid(String value) {
        try {
            valueOf(value);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public boolean notHas(String value) {
        String array = Arrays.toString(TypeZones.values());
        return !array.contains(value);
    }
}