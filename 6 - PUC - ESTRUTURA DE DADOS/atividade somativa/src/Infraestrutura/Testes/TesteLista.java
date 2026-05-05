// DEMONSTRAÇÃO DE LISTA ENCADEADA
// 

package Infraestrutura.Testes;

import Infraestrutura.EstruturasDeDados.Listas.ListaEncadeada;

public class TesteLista {

    public static void main(String[] args) {

        ListaEncadeada<Integer> myList = new ListaEncadeada<>();

        myList.InserirInicio(5);
        myList.InserirInicio(2);
        myList.InserirInicio(3);
        myList.InserirInicio(4);

        // percorre toda a lista
        while (true) {
            
            System.out.println("::" + myList.GetDadoAtual());
            if (!myList.MoverPonteiro())
                break;
        }

    }
}