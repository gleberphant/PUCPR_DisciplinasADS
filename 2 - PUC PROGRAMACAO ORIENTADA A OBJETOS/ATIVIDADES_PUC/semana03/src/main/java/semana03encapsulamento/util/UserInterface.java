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

package semana03encapsulamento.util;


import semana03encapsulamento.model.Loan;


/**
 * Classe responsável pela interface do usuário. Gerencia a entrada e saída de dados do sistema.
 * Segue padrão singleton para evitar múltiplas instâncias
 * @author HANDERSON GLEBER
 */
public class UserInterface {

    private static UserInterface instance;
    private InputController inputInstance;

    /**
     * Construtor private para atender o padrão singleton e evitar duas interfaces simultaneamente
     */
    private UserInterface() {}

    /**
     * Criação da instância única da classe e do controlador de entrada
     * (será que isso viola o Princípio da Responsabilidade Única?)
     * @return UserInterface
     */
    public static UserInterface getInstance()
    {

        if(instance == null)
            instance = new UserInterface();

        return instance;
    }

    /**
     * Inicializa a interface da aplicação
     */
    public UserInterface initialize() {

        inputInstance = InputController.getInstance().initialize();

        return this;
    }

    /**
     * Encerra a interface da aplicação
     */
    public void closure() {

        System.out.println("""
        
        ╔══════════════════════════════════════════════╗
        ║      Dúvidas e sugestões?                    ║
        ║      handerson.gleber@gmail.com              ║
        ╚══════════════════════════════════════════════╝
        
        """);
        this.getInput().waitEnterToContinue();
    }

    /**
     * @return controlador de entradas do usuário
     */
    public InputController getInput() {

        return inputInstance;
    }

    /**
     * Exibe os dados do o financiamento
     */
    public void viewLoan(Loan targetLoan){

        System.out.printf("""
        ┌──────────────────────────────────────────────┐
        │                FINANCIAMENTO                 │
        │  Prazo: %33d    │
        │  Valor do Financiamento: R$%14.2f    │
        │  Taxa Juros Ano: %24.4f    │
        │                                              │
        │  PAGAMENTO TOTAL: R$%21.2f    │
        └──────────────────────────────────────────────┘
        
        """, targetLoan.getTerm(), targetLoan.getPrice(), targetLoan.getFee(), targetLoan.getTotalPayment());
        this.getInput().waitEnterToContinue();
    }

    /**
     * Exibe os dados de um erro
     */
    public void viewException(Exception e) {

        System.out.printf("""
        
        ╔══════════════════════════════════════════════╗
        ║  FINANCIAMENTO INVÁLIDO                      ║
        ║  >> %-40s ║
        ╚══════════════════════════════════════════════╝
        
        """, e.getMessage());

        this.getInput().waitEnterToContinue(); // Aguardando o usuário pressionar Enter
    }


    /**
     * Exibe menu da interface
     */
    public void viewMenu() {

        System.out.println("""
        
        ╔══════════════════════════════════════════════╗
        ║         SISTEMA DE FINANCIAMENTO POO         ║
        ║      por: HANDERSON GLEBER (gravatinha)      ║
        ╚══════════════════════════════════════════════╝
        
        """);
        this.getInput().waitEnterToContinue();
    }

}

