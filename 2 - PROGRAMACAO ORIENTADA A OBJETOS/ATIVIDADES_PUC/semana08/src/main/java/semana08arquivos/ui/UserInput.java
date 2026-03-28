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

package semana08arquivos.ui;

import semana08arquivos.utils.exceptions.InvalidInputException;

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
     * Controle do menu principal da aplicação.
     * @throws InvalidInputException se valor inválido
     * @return opção do menu
     */
    public char promptMenu() {
        if (this.inputScanner.hasNextInt()) {

            return (char) (this.inputScanner.nextInt() + '0');
        } else {

            this.inputScanner.next();
            throw new InvalidInputException("Opção Inválida");
        }
    }

    /**
     * Solicita ao usuário o tipo de financiamento.
     * @throws InvalidInputException se valor inválido
     * @return Valor do imóvel.
     */
    public char promptType() {

        if (this.inputScanner.hasNextInt()) {

            return (char) (this.inputScanner.nextInt() + '0');
        } else {

            this.inputScanner.next();
            throw new InvalidInputException("Opção Inválida");
        }
    }

    /**
     * Solicita ao usuário o valor do imóvel a ser financiado.
     * @throws InvalidInputException se valor inválido
     * @return Valor do imóvel.
     */
    public double promptPrice() {

        if (this.inputScanner.hasNextDouble()) {

            return this.inputScanner.nextDouble();
        } else {

            this.inputScanner.next();
            throw new InvalidInputException("Preço inválido. Digite um número decimal.");
        }

    }

    /**
     * Solicita ao usuário o prazo do financiamento em meses.
     * @throws InvalidInputException se valor inválido
     * @return Prazo do financiamento em meses.
     */
    public int promptTerm() {

        if (this.inputScanner.hasNextInt()) {

            return this.inputScanner.nextInt();
        } else {

            this.inputScanner.next();
            throw new InvalidInputException("Prazo inválido. Digite um número inteiro.");
        }
    }

    /**
     * Solicita ao usuário a taxa de juros anual do financiamento.
     * @throws InvalidInputException se valor inválido
     * @return Taxa de juros anual.
     */
    public double promptFee() {

        if (this.inputScanner.hasNextDouble()) {

            return this.inputScanner.nextDouble();
        } else {

            this.inputScanner.next();
            throw new InvalidInputException("Taxa inválida. Digite um número decimal.");
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
            System.out.println("Pressione [S] CONTINUAR ou [N] SAIR ");

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

        this.inputScanner.nextLine();

    }

    /**
     * Prompt de atributo de financiamento.
     * @throws InvalidInputException se valor inválido
     */
    public double promptLandArea() {

        if (this.inputScanner.hasNextDouble()) {

            return this.inputScanner.nextDouble();
        } else {

            this.inputScanner.next();
            throw new InvalidInputException("Valor inválido. Digite um número decimal.");
        }
    }

    /**
     * Prompt de atributo de financiamento.
     * @throws InvalidInputException se valor inválido
     * @return  valor da área construída.
     */
    public double promptBuildArea() {

        if (this.inputScanner.hasNextDouble()) {

            return this.inputScanner.nextDouble();
        } else {

            this.inputScanner.next();
            throw new InvalidInputException("Valor inválido. Digite um número decimal.");
        }
    }

    /**
     * Prompt de atributo de financiamento.
     * @throws InvalidInputException se valor inválido
     * @return  numero do andar
     */
    public int promptFloor() {


        if (this.inputScanner.hasNextInt()) {

            return this.inputScanner.nextInt();
        } else {

            this.inputScanner.next();
            throw new InvalidInputException("VALOR INVÁLIDO. Digite um número inteiro.");
        }
    }

    /**
     * Prompt de atributo de financiamento.
     * @throws InvalidInputException se valor inválido
     * @return total de garagens
     */
    public int promptGarages() {

        if (this.inputScanner.hasNextInt()) {

            return this.inputScanner.nextInt();
        } else {

            this.inputScanner.next();
            throw new InvalidInputException("VALOR INVÁLIDO. Digite um número inteiro.");
        }
    }

    /**
     * Prompt de atributo de financiamento.
     * @throws InvalidInputException se valor inválido
     * @return  tipo da zona
     */
    public String promptZone() {

        if (this.inputScanner.hasNextInt()) {

            return switch (this.inputScanner.nextInt()) {
                case 1 -> "COMERCIAL";
                case 2 -> "RESIDENCIAL";
                default -> throw new InvalidInputException("Opção inexistente.");
            };
        } else {

            this.inputScanner.next();
            throw new InvalidInputException("Valor inválido. Digite o número correspondente a zona.");
        }

    }


}
