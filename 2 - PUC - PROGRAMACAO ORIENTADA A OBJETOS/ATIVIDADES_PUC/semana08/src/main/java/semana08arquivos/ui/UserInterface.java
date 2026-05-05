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

import semana08arquivos.model.Loan;
import semana08arquivos.utils.exceptions.InvalidInputException;

/**
 * Classe responsável pela interface do usuário. Gerencia a entrada e saída de dados do sistema.
 * Segue padrão singleton para evitar múltiplas instâncias.
 *
 * @author HANDERSON GLEBER
 */
public class UserInterface {

    private static UserInterface instance;
    private UserInput inputInstance;

    /**
     * Construtor private para atender o padrão singleton e evitar duas interfaces simultaneamente.
     */
    private UserInterface() {
    }

    /**
     * Criação da instância única da classe e do controlador de entrada.
     *
     * @return UserInterface
     */
    public static UserInterface getInstance() {

        if (instance == null)
            instance = new UserInterface();

        return instance;
    }

    /**
     * Inicializa a interface da aplicação.
     *
     * @return inputInstance
     */
    public UserInterface initialize() {

        inputInstance = UserInput.getInstance().initialize();

        return this;
    }

    /**
     * Solicita ao usuário o valor do imóvel a ser financiado.
     *
     * @return Valor do imóvel.
     */
    public double promptPrice() {

        System.out.print(" < Digite o VALOR do financiamento >  ");

        return inputInstance.promptPrice();

    }

    /**
     * Solicita ao usuário o prazo do financiamento em meses.
     *
     * @return Prazo do financiamento em meses.
     */
    public int promptTerm() {

        System.out.print(" < Digite o PRAZO do financiamento > ");

        return inputInstance.promptTerm();
    }

    /**
     * Solicita ao usuário a taxa de juros anual do financiamento.
     *
     * @return Taxa de juros anual.
     */
    public double promptFee() {


        System.out.print(" < Digite o valor da TAXA DE JUROS ANUAL > ");

        return inputInstance.promptFee();

    }

    /**
     * Pergunta se é para encerrar aplicação.
     *
     * @return a resposta em boolean
     */
    public boolean promptExit() {

        return inputInstance.promptExit();
    }

    /**
     * Pergunta pela opção do menu.
     *
     * @return a resposta em boolean
     */
    public char promptMenu(){
        System.out.println("""                
                ╔══════════════════════════════════════════════╗
                ║              MENU DE OPÇÕES                  ║
                ║                                              ║
                ║  (1) NOVO FINANCIAMENTO                      ║
                ║  (2) LISTAR TODOS FINANCIAMENTOS             ║
                ║  (3) SAIR                                    ║
                ║                                              ║
                ║  (4) Log do Sistema                          ║
                ╚══════════════════════════════════════════════╝
                """);

        return this.inputInstance.promptMenu();
    }


    /**
     * Pergunta pelo tipo de financiamento.
     * @return a resposta em char
     */
    public char promptType(){
        System.out.println("""                
                
                INFORME O TIPO DE FINANCIAMENTO: (1) CASA (2)APARTAMENTO (3) TERRENO      ║
                
                """);

        return this.inputInstance.promptType();
    }

    /**
     * Exibe os dados do financiamento
     */
    public void viewLoan(Loan targetLoan) {

        System.out.printf("""
                ┌──────────────────────────────────────────────┐
                │  FINANCIAMENTO nº%3s  - %20s │
                ├──────────────────────────────────────────────┤
                │  Prazo: %-5d      Tx Juros: %5.2f /ano      │
                │  Valor do Imóvel: R$%-23.2f  │
                │  Valor do Financiamento: R$%-16.2f  │
                └──────────────────────────────────────────────┘
                """, targetLoan.getId(), targetLoan.getTypeString(), targetLoan.getTerm(), targetLoan.getFee(), targetLoan.getPrice(), targetLoan.getPaymentValueTotal());

    }

    /**
     * Exibe um erro.
     */
    public void viewException(String error) {

        System.out.printf("""    
                ╔══════════════════[ FALHA ]═════════════════════════╗
                ║ %-50s ║
                ╚════════════════════════════════════════════════════╝
                """, error);

        this.pressEnterToContinue();
    }

    /**
     * Exibe valor total dos financiamentos.
     */
    public void viewTotals(double totalProperty, double totalLoan) {

        System.out.printf("""
                
                ╔═════════════════[ TOTAIS ]═══════════════════╗
                ║ Total imóveis: R$%-26.2f  ║
                ║ Total financiamentos: R$%-19.2f  ║
                ╚══════════════════════════════════════════════╝
                """, totalProperty, totalLoan);
    }

    /**
     * Exibe mensagem abertura
     */
    public void viewOpening() {

        System.out.println("""
                
                ╔══════════════════════════════════════════════╗
                ║  PUCPR - PROGRAMAÇÃO ORIENTADA A OBJETOS     ║
                ╠══════════════════════════════════════════════╣
                ║  SISTEMA SIMULAÇÃO DE FINANCIAMENTO          ║
                ║  VERSÃO 8.0 - IO                             ║
                ║  by: HANDERSON GLEBER (Gr4v4t1nh4)           ║
                ╚══════════════════════════════════════════════╝
                """);
        this.pressEnterToContinue();
    }

    /**
     * Encerra a interface da aplicação.
     */
    public void viewCloseMsg() {

        System.out.println("""
                
                ╔═══════════[ Dúvidas e sugestões? ]═══════════╗
                ║  Email: handerson.gleber@gmail.com           ║
                ║  Instagram: @handersongleber                 ║
                ╚══════════════════════════════════════════════╝
                """);

    }
    /**
     * aguarda tecla enter
     */
    public void pressEnterToContinue() {

        System.out.println("[ Pressione <ENTER> para continuar... ]");
        this.inputInstance.pressEnterToContinue();
    }

    /**
     * Pede dado ao usuário
     */
    public double promptLandArea() {
        System.out.print(" < Digite o tamanho do TERRENO > ");
        return this.inputInstance.promptLandArea();
    }

    /**
     * Pede dado ao usuário
     */
    public double promptBuildArea() {
        System.out.print(" < Digite o tamanho da AREA CONSTRUÍDA > ");
        return this.inputInstance.promptBuildArea();
    }

    /**
     * Pede dado ao usuário
     */
    public int promptFloor() {
        System.out.print(" < Digite o ANDAR do apartamento  > ");
        return this.inputInstance.promptFloor();
    }

    /**
     * Pede dado ao usuário
     */
    public int promptGarages() {
        System.out.print(" < Digite a quantidade de GARAGENS no imóvel > ");
        return this.inputInstance.promptGarages();
    }

    /**
     * Pede dado ao usuário
     */
    public String promptZone() throws InvalidInputException {

        System.out.print(" < Digite o tipo de zona [1] comercial ou [2] residencial  > ");
        return this.inputInstance.promptZone();

    }
}

