package EstruturasNaoLineares;

import java.util.ArrayList;
import java.util.Arrays;

import Nos.NoGrafo;
import Nos.Aresta;
import MinhasInterfaces.InterfaceGrafo;

public class GrafoMatriz implements InterfaceGrafo {
    // matriz de adjacencias

    // lista de nos
    ArrayList<NoGrafo> ListaNos;
    // matriz de vertices
    int[][] matriz;

    public GrafoMatriz() {
        this.ListaNos = new ArrayList<>();
        this.matriz = null;
    }

    public void InserirNo(int valor) {

        ListaNos.add(new NoGrafo(valor));



        int novoTamanho = ListaNos.size();


        int[][] temp = new int[novoTamanho][novoTamanho];

        for (int i = 0; i <novoTamanho-1; i++) {
            temp[i] = Arrays.copyOf(matriz[i], novoTamanho);
        }

        matriz = temp;
    }

    public void InserirConexao(int valor1, int valor2) {
        int[] indices = { -1, -1 };
        int[] valores = { valor1, valor2 };

        // se ambos nos forem iguais retorna
        if (valor1 == valor2)
            return;
        // procura indice do no
        for (int i = 0; i < valores.length; i++) {
            for (int j = 0; j < ListaNos.size(); j++) {
                if (ListaNos.get(j).data == valores[i]) {
                    // se encontrou o no atribui o indice
                    indices[i] = j;
                    break;
                }
            }
            // se não encontrou o no retorna
            if (indices[i] == -1)
                return;
        }

        // aumenta peso

        matriz[indices[0]][indices[1]]++;
        return;
    }

    public void Imprimir() {
 
        System.out.println("\n Matriz Adjacencias \n");
        
        //imprimir cabeçalho
         System.out.print("NOS ");
        for (int i = 0; i < ListaNos.size(); i++) {
            System.out.print(" " + ListaNos.get(i).data+" ");
        }

        for (int i = 0; i < matriz.length; i++) {
            System.out.print("\n"+ ListaNos.get(i).data+ " | ");
            for (int j = 0; j < matriz.length; j++) {
                int peso = matriz[i][j];
                System.out.print(" " + peso + " ");
            }


        }
         System.out.print("\n ");
    }
}
