// DEMONSTRAÇÃO DE LISTA ENCADEADA
// 

package Testes;

import EstruturasLineares.*;

public class TesteLista {

    public static void main(String[] args) {

        ListaEncadeada myList = new ListaEncadeada();

        myList.InserirInicio(1);
        myList.InserirInicio(1);
        myList.InserirInicio(3);
        myList.InserirInicio(4);

        // percorre toda a lista
        while (true) {
            System.out.println("::" + myList.GetAtual().GetData());
            if (!myList.MoverPonteiro())
                break;
        }

    }
}