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
 */

package semana05heranca.util;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Classe responsável pela entrada de dados fornecidos pelo usuário.
 * Realiza validação quanto ao tipo de dado apenas.
 *
 * @author HANDERSON GLEBER
 */
public class UserInput {

    private static UserInput instance;
    private Scanner inputScanner;

    /**
     * Construtor encapsulado como private para atender padrão singleton.
     */
    private UserInput() {
    }


    /**
     * Inicializa a instância única da classe.
     *
     * @return InputController
     */
    protected static UserInput getInstance() {

        if (instance == null) {
            instance = new UserInput();
        }
        return instance;
    }

    /**
     * inicializa a instancia do objeto Scanner.
     *
     * @return InputController
     */
    public UserInput initialize() {

        if (this.inputScanner == null)
            this.inputScanner = new Scanner(System.in);

        return this;
    }

    /**
     * Solicita ao usuário o tipo de financiamento.
     *
     * @return Valor do imóvel.
     */
    public char promptType() {

        System.out.println(" < Selecione o TIPO de financiamento > ");
        System.out.println(" [1]Casa [2]Apartamento [3]Terreno ");

        if (this.inputScanner.hasNextInt()) {

            return (char) (this.inputScanner.nextInt() + '0');
        } else {

            this.inputScanner.next();
            throw new InputMismatchException("Tipo de financiamento inválido");
        }
    }

    /**
     * Solicita ao usuário o valor do imóvel a ser financiado.
     *
     * @return Valor do imóvel.
     */
    public double promptPrice() {

        System.out.print(" < Digite o VALOR do financiamento >  ");

        if (this.inputScanner.hasNextDouble()) {

            return this.inputScanner.nextDouble();
        } else {

            this.inputScanner.next();
            throw new InputMismatchException("Preço inválido. Digite um número decimal.");
        }
    }

    /**
     * Solicita ao usuário o prazo do financiamento em meses.
     *
     * @return Prazo do financiamento em meses.
     */
    public int promptTerm() {

        System.out.print(" < Digite o PRAZO do financiamento > ");

        if (this.inputScanner.hasNextInt()) {

            return this.inputScanner.nextInt();
        } else {

            this.inputScanner.next();
            throw new InputMismatchException("Prazo inválido. Digite um número inteiro.");
        }
    }

    /**
     * Solicita ao usuário a taxa de juros anual do financiamento.
     *
     * @return Taxa de juros anual.
     */
    public double promptFee() {

        System.out.print(" < Digite o valor da TAXA DE JUROS ANUAL > ");

        if (this.inputScanner.hasNextDouble()) {

            return this.inputScanner.nextDouble();
        } else {

            this.inputScanner.next();
            throw new InputMismatchException("Taxa inválida. Digite um número decimal.");
        }
    }


    /**
     * Pergunta ao usuário se ele quer fechar a aplicação.
     *
     * @return boolean
     */
    public boolean promptExit() {

        String choice;

        do {

            System.out.println("Deseja realizar um novo financiamento?");
            System.out.println("Pressione [S] para continuar ou [N] para sair ");

            choice = this.inputScanner.next().trim().toUpperCase();

            if (choice.equals("S") || choice.equals("1")) {
                return true;
            } else if (choice.equals("N") || choice.equals("2")) {
                return false;
            }

        } while (true);
    }

    /**
     * Aguardar usuário pressionar tecla Enter.
     */
    public void pressEnterToContinue() {

        System.out.println("[ Pressione <ENTER> para continuar... ]");
        this.inputScanner.nextLine();

    }
}
