package Dominio.MeusAlgoritmos;

import Aplicacao.Interfaces.IEncriptador;

public class CifraDeCesar implements IEncriptador {
    private int cifra = 7;

    private String encriptar(String texto, int chave) {
        StringBuilder resultado = new StringBuilder();
        for (char caractere : texto.toCharArray()) {
            // verifica se é uma letra
            if (Character.isLetter(caractere)) {
                // ajusta para ficar no intervalo do alfabeto
                char base = Character.isLowerCase(caractere) ? 'a' : 'A';
                // aplica a cifra de cesar
                caractere = (char) ((caractere - base + chave) % 26 + base);
            }
            resultado.append(caractere);
        }
        return resultado.toString();
    }

    public String Encriptar(String texto) {
        return encriptar(texto, cifra);
    }

    public String Desencriptar(String texto) {
        return encriptar(texto, -cifra);
    }

}
