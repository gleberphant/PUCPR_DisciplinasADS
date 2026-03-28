// DEMONSTRAÇÃO DE PILHAS/STACK 
// LIFO = LAST IN FIRST OUT

package Testes;

import EstruturasLineares.*;

public class TestePilha {
    public static void main(String[] args) {

        Pilha s = new Pilha();

        s.InserirNo(1);
        s.InserirNo(2);
        s.InserirNo(3);
        s.InserirNo(4);
        s.InserirNo(5);
        s.InserirNo(6);

        System.out.println("Imprimindo pilha");

        while (s.GetAtual() != null) {
            System.out.println(">>>" + s.GetAtual().GetData());
            s.MoverPonteiro();
        }
    }
}