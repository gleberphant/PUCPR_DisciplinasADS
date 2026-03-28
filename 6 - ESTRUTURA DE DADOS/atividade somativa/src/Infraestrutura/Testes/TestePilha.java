// DEMONSTRAÇÃO DE PILHAS/STACK 
// LIFO = LAST IN FIRST OUT

package Infraestrutura.Testes;

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

        while (s.GetDadoAtual() != null) {
            System.out.println(">>>" + s.GetDadoAtual().GetData());
            s.MoverPonteiro();
        }
    }
}