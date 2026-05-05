package Infraestrutura.Testes;

import EstruturasNaoLineares.*;
import MinhasInterfaces.InterfaceGrafo;

public class TesteGrafosLista {
    public static void main(String[] args) {

        int itens[] = { 1, 2, 3, 4, 5, 6, 7 };

        IGrafo g = new GrafoLista();

        System.out.println("\n Grafo do tipo: " + g.getClass());

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