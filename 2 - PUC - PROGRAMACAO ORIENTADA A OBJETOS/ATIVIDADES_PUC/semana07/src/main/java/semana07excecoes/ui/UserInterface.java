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

package semana07excecoes.ui;


import semana07excecoes.model.Loan;

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
     * Pergunta se é para encerrar aplicação.
     *
     * @return a resposta em boolean
     */
    public boolean promptExit() {

        return this.in().promptExit();
    }

    /**
     * @return controlador de entradas do usuário
     */
    public UserInput in() {

        return inputInstance;
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
    public void viewException(Exception e) {

        System.out.printf("""
                
                ╔══════════[ FINANCIAMENTO INVÁLIDO ]══════════╗
                ║                                              ║
                ║  >> %-40s ║
                ╚══════════════════════════════════════════════╝
                """, e.getMessage());

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
                ║  VERSÃO 7.0 - Exceptions                     ║
                ║  by: HANDERSON GLEBER (Gr4v4t1nh4)           ║
                ╚══════════════════════════════════════════════╝
                """);
        this.pressEnterToContinue();
    }

    /**
     * Encerra a interface da aplicação.
     */
    public void viewClosure() {

        System.out.println("""
                
                ╔═══════════[ Dúvidas e sugestões? ]═══════════╗
                ║  Email: handerson.gleber@gmail.com           ║
                ║  Instagram: @handersongleber                 ║
                ╚══════════════════════════════════════════════╝
                """);
        this.pressEnterToContinue();
    }

    public void pressEnterToContinue() {

        this.in().pressEnterToContinue();
    }

}

