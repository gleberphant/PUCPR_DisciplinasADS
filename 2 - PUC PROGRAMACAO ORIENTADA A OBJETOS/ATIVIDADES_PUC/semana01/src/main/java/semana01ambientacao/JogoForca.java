/**
 * ┌────────────────────────────────────────────────────────────────────────┐
 * │            ╔════╗           ╔═════        ╔════╗  ╔═══╗                │
 * │            ╠════╝  ║    ║   ║             ╠════╝  ╠═══╩╗               │
 * │            ║       ╚════╝   ╚═════        ║       ║    ║               │
 * └────────────────────────────────────────────────────────────────────────┘
 * ┌────────────────────────────────────────────────────────────────────────┐
 * │ Análise e Desenvolvimento de Sistemas                                  │
 * │ Fundamentos da Programação Orientada a Objetos (11100010550_20242_20)  │
 * └────────────────────────────────────────────────────────────────────────┘
 *
 * @author HANDERSON GLEBER DE LIMA CAVALCANTI (1112024201103)
 * @version af_semana_001
 * <p>
 * jogo da forca para introdução da sintaxe da linguagem JAVA
 */


package semana01ambientacao;

import java.util.Random;


public class JogoForca {
    public static void main(String[] args) {


        String[] banco_de_palavras = {"casa", "cachorro", "computador", "computador", "televisao", "programador", "fada", "sapo", "rato", "telescopio"};

        int indice_palavra = new Random().nextInt(banco_de_palavras.length);

        String palavra = banco_de_palavras[indice_palavra];

        int tamanho_palavra = palavra.length();

        int contador_erros = 0;
        int contador_acertos = 0;

        final short MAX_TENTATIVAS = 5;

        char[] letras_certas = new char[tamanho_palavra];

        for (int i = 0; i < tamanho_palavra; i++) {
            letras_certas[i] = '_';
        }

        char letra_selecionada;

        //loop principal
        System.out.println("""
                ----------------------------------------
                |       INICIANDO JOGO DA FORCA        |
                ----------------------------------------
                """);

        while (true) {


            System.out.println("\n Você tem " + (MAX_TENTATIVAS - contador_erros) + " tentativas para acertar");

            letra_selecionada = System.console().readLine("\n Digite uma letra (digite 0 PARA SAIR): ").charAt(0);

            //verifica se apertou para sair
            if (letra_selecionada != '0') {
                //verifica se a palavra contem a letra
                if (palavra.contains(String.valueOf(letra_selecionada))) {
                    for (int i = 0; i < tamanho_palavra; i++) {
                        if (palavra.charAt(i) == letra_selecionada) {
                            letras_certas[i] = letra_selecionada;
                        }
                        //conta o numero de letras certas
                        if (letras_certas[i] != '_') {
                            contador_acertos++;
                        }
                    }
                } else {
                    contador_erros++;
                }

                System.out.printf(""" 
                        ---------------------------
                        |  %24s |
                        ---------------------------
                        """, String.valueOf(letras_certas));

                //verifica condição de vítoria senão reseta o contador
                if (contador_acertos >= tamanho_palavra) {

                    System.out.println(
                            """ 
                                    ---------------------------
                                    |       VOCÊ VENCEU !     |
                                    ---------------------------
                                    """);


                    System.console().readLine("\n aperte ENTER para sair");
                    break;
                } else {
                    if (contador_erros > MAX_TENTATIVAS) {
                        System.out.println(
                                """ 
                                        ---------------------------
                                        |       VOCÊ PERDEU !     |
                                        ---------------------------
                                        """);

                        break;

                    } else {

                        contador_acertos = 0;
                    }
                }
            } else // se apertou 0 para sair
            {
                break;
            }

        }

        System.out.println(
                """
                        --------------------------------
                        |   finalizando.......         |
                        |     feito por Gr4v4t1nh4.    |
                        --------------------------------
                        """);

        System.exit(0);
    }


}
