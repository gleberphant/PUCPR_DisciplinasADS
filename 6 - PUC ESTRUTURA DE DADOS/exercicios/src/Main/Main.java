// demonstração de estruturas de dados
package Main;

import MinhasInterfaces.*;
import EstruturasLineares.*;
import EstruturasNaoLineares.GrafoHash;
import EstruturasNaoLineares.GrafoLista;
import EstruturasNaoLineares.GrafoMatriz;;

public class Main {

    public static void main(String[] args) {
        ImprimirEstruturasLineares();
        ImprimirGrafos();
    }

    public static void ImprimirEstruturasLineares() {
        InterfaceEstruturasLineares listas[] = {
                new ListaEncadeada(),
                new Fila(),
                new Pilha()
        };

        int itens[] = { 1, 2, 3, 4, 5 };

        for (int i = 0; i < listas.length; i++) {

            InterfaceEstruturasLineares l = listas[i];

            for (int item : itens)
                l.InserirNo(item);

            System.out.println("\nImprimindo estrutura " + l.ToString());

            while (l.GetAtual() != null) {
                System.out.print("::" + l.GetAtual().GetData());
                l.MoverPonteiro();
            }
        }

    }

    public static void ImprimirGrafos(){
        InterfaceGrafo grafos[] = {
                new GrafoHash(),
                new GrafoLista(),
                new GrafoMatriz()
        };

        int itens[] = { 1, 2, 3, 4, 5, 6, 7 };

        for (int i = 0; i < grafos.length; i++) {
            InterfaceGrafo g = grafos[i];

            System.out.println("\n Imprimindo Grafo do tipo: " + g.getClass()+" \n");

            for (int item : itens)
                g.InserirNo(item);

            g.InserirConexao(1, 3);
            g.InserirConexao(1, 2);

            g.InserirConexao(2, 3);
            g.InserirConexao(2, 5);
            g.InserirConexao(2, 4);

            g.InserirConexao(7, 4);
            g.InserirConexao(7, 4);
            g.InserirConexao(7, 4);
            g.Imprimir();
        }
    }


}
