package Infraestrutura.EstruturasDeDados.Grafos;

import java.util.ArrayList;
import java.util.Arrays;



public class GrafoMatriz<T> {
    // matriz de adjacencias

    // lista de nos
    ArrayList<T> ListaNos;
    // matriz de vertices
    int[][] matriz;

    public GrafoMatriz() {
        this.ListaNos = new ArrayList<>();
        this.matriz = null;
    }

    public void InserirNo(T valor) {

        ListaNos.add(valor);



        int novoTamanho = ListaNos.size();


        int[][] temp = new int[novoTamanho][novoTamanho];

        for (int i = 0; i <novoTamanho-1; i++) {
            temp[i] = Arrays.copyOf(matriz[i], novoTamanho);
        }

        matriz = temp;
    }

    public void InserirConexao(T valor1, T valor2) {
        int indice1=-1, indice2=-1 ;
        
        // se ambos nos forem iguais retorna
        if (valor1 == valor2)
            return;

        // verifica se os dois nos existem
        for (int i = 0; i < ListaNos.size(); i++) {
            if (ListaNos.get(i) == valor1) {
                indice1 = i;
            }

            if (ListaNos.get(i) == valor2) {
                indice2 = i;
            }

            if (indice1 != -1 && indice2 != -1)
                break;
        }

        // aumenta peso
        matriz[indice1][indice2]++;
        return;
    }

    public void Imprimir() {
 
        System.out.println("\n Matriz Adjacencias \n");
        
        //imprimir cabeçalho
         System.out.print("NOS ");
        for (int i = 0; i < ListaNos.size(); i++) {
            System.out.print(" " + ListaNos.get(i)+" ");
        }

        for (int i = 0; i < matriz.length; i++) {
            System.out.print("\n"+ ListaNos.get(i)+ " | ");
            for (int j = 0; j < matriz.length; j++) {
                int peso = matriz[i][j];
                System.out.print(" " + peso + " ");
            }


        }
         System.out.print("\n ");
    }
}
