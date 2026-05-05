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
 * @version af_semana_002
 */

package semana02introducao;


import java.util.Scanner;


/**
 * Clase PRINCIPAL que executa o programa.
 */

public class Main {


    public static void main(String[] args) {

        InterfaceUsuario controlador = new InterfaceUsuario();

        // abertura da aplicação
        controlador.abertura();

        // receber dados do financiamento
        final double valor = controlador.inputValorImovel();
        final int prazo = controlador.inputPrazoFinanciamento();
        final double juros = controlador.inputTaxaJuros();

        // criar objeto financiamento com os dados recebidos
        final Financiamento modelo = new Financiamento(valor, prazo, juros);

        // exibe os dados do objeto financiamento
        System.out.println(modelo.getString());

        // encerramento da aplicação
        controlador.encerramento();

    }
}


/**
 * Classe 'CONTROLER'
 * responsável pela interface do usuário.
 * Gerencia a entrada e saída de dados do sistema.
 *
 * @author HANDERSON GLEBER
 * @version 1.0
 */
class InterfaceUsuario {

    final private Scanner input;

    /**
     * Construtor da classe InterfaceUsuario.
     * Inicializa o objeto Scanner para entrada de dados.
     */
    public InterfaceUsuario() {
        input = new Scanner(System.in);

    }

    /**
     * Exibe a mensagem de abertura do sistema.
     */
    public void abertura() {

        System.out.println(getStringAbertura());

    }

    /**
     * Exibe a mensagem de encerramento do sistema.
     */
    public void encerramento() {
        System.out.println(this.getStringEncerramento());
    }

    /**
     * Retorna a string de abertura do sistema.
     *
     * @return String de abertura.
     */
    public String getStringAbertura() {
        return
        """                
        ╔══════════════════════════════════════════════╗
        ║         SISTEMA DE FINANCIAMENTO POO         ║
        ║      por: HANDERSON GLEBER (gravatinha)      ║
        ╚══════════════════════════════════════════════╝
        """;
    }

    /**
     * Retorna a string de encerramento do sistema.
     *
     * @return String de encerramento.
     */
    public String getStringEncerramento() {
        return
        """                
        ╔══════════════════════════════════════════════╗
        ║      Dúvidas e sugestões?                    ║
        ║      handerson.gleber@gmail.com              ║
        ╚══════════════════════════════════════════════╝
        """;
    }

    /**
     * Solicita ao usuário o valor do imóvel a ser financiado.
     *
     * @return Valor do imóvel.
     */
    public double inputValorImovel() {
        System.out.print("\n > Digite o VALOR do financiamento: ");
        return this.input.nextDouble();
    }

    /**
     * Solicita ao usuário o prazo do financiamento em meses.
     *
     * @return Prazo do financiamento em meses.
     */
    public int inputPrazoFinanciamento() {
        System.out.print("\n > Digite o PRAZO do financiamento: ");
        return this.input.nextInt();
    }

    /**
     * Solicita ao usuário a taxa de juros anual do financiamento.
     *
     * @return Taxa de juros anual.
     */
    public double inputTaxaJuros() {
        System.out.print("\n > Digite o valor da TAXA DE JUROS ANUAL: ");
        return this.input.nextDouble();
    }

}

/**
 * Classe que representa um financiamento.
 *
 * @author HANDERSON GLEBER
 * @version 1.0
 */
class Financiamento {

    private int prazoMeses;
    private double valorImovel;
    private double taxaJurosAno;

    /**
     * Construtor da classe Financiamento.
     * Inicializa um novo financiamento com os dados fornecidos.
     *
     * @param valorImovel Valor do imóvel a ser financiado.
     * @param prazoMeses Prazo do financiamento em meses.
     * @param taxaJurosAno Taxa de juros anual do financiamento.
     */
    public Financiamento(final double valorImovel, final int prazoMeses, final double taxaJurosAno) {
        setFinanciamento(valorImovel, prazoMeses, taxaJurosAno);
    }

    /**
     * Define os dados do financiamento.
     *
     * @param valorImovel Valor do imóvel a ser financiado.
     * @param prazoMeses Prazo do financiamento em meses.
     * @param taxaJurosAno Taxa de juros anual do financiamento.
     */
    public void setFinanciamento(final double valorImovel, final int prazoMeses, final double taxaJurosAno) {
        this.prazoMeses = prazoMeses;
        this.valorImovel = valorImovel;
        this.taxaJurosAno = taxaJurosAno;
    }

    /**
     * Retorna o prazo do financiamento em anos.
     *
     * @return Prazo do financiamento em anos.
     */
    private int getPrazoAnos() {
        return this.prazoMeses / 12;
    }

    /**
     * Calcula e retorna o valor da parcela mensal do financiamento.
     *
     * @return Valor da parcela mensal.
     */
    public double getParcelaMensal() {
        return (this.valorImovel / (this.getPrazoAnos() * 12)) * (1 + (this.taxaJurosAno / 12));
    }

    /**
     * Calcula e retorna o valor total a ser pago no financiamento.
     *
     * @return Valor total do pagamento.
     */
    public double getPagamentoTotal() {
        return this.getParcelaMensal() * this.getPrazoAnos() * 12;
    }

    /**
     * Retorna uma string com os dados do financiamento formatados.
     *
     * @return String com os dados do financiamento.
     */
    public String getString() {
        return String.format(
        """
        ┌──────────────────────────────────────────────┐
        │                FINANCIAMENTO                 │
        │  Prazo: %33d    │
        │  Valor do Financiamento: R$%14.2f    │
        │  Taxa Juros Ano: %24.4f    │
        │                                              │
        │  PAGAMENTO TOTAL: R$%21.2f    │
        └──────────────────────────────────────────────┘
        """, this.prazoMeses, this.valorImovel, this.taxaJurosAno, this.getPagamentoTotal());
    }
}

