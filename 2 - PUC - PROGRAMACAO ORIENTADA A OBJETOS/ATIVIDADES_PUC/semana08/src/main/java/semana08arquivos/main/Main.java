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
 * @version af_semana_008
 * <p>
 * REQUISITOS
O que devo desenvolver?

1) Todos os requisitos das semanas anteriores.
2) Salvar num arquivo de texto os dados de cada financiamento.
Cada linha do arquivo deve conter o valor do imóvel, o valor do financiamento, a taxa de juros, o prazo de financiamento
e os atributos específicos da classe especializada (exemplo: o andar do apartamento, caso seja um financiamento
de apartamento, ou a área construída para uma casa). Depois, leia novamente esses mesmos dados para comprovar que
foram salvos corretamente.

3) Salve um arquivo contendo os dados serializados dos financiamentos. Isto é, salve um arquivo contendo o ArrayList de
financiamentos que você criou no mé_todo main(). Depois, leia novamente esses mesmos dados para comprovar que fora.
 */

package semana08arquivos.main;
/**
 * Classe PRINCIPAL.
 * Contêm o loop central da aplicação.
 *
 * @author HANDERSON GLEBER
 */
public class Main {

    /**
     * Main da aplicação
     * */
    public static void main(String[] args){

        App app = new App();

        // inicializa as variáveis do sistema.
        app.init();

        // carrega a base de dados salva em arquivo.
        app.loadDatabase();

        // loop principal da aplicação.
        app.run();

        // salvar os financiamentos em arquivo.
        app.saveDatabase();

        // encerramento da aplicação
        app.closeApp();

    }

}


