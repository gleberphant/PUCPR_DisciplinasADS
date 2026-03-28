// DEMONSTRAÇÃO DE FILA/QUEUE 
// FIFO = FIRST IN FIRST OUT


package Testes;


import EstruturasLineares.*;

public class TesteFila {
    public static void main(String[] args) {

        Fila q = new Fila();

        q.InserirNo(1);
        q.InserirNo(2);
        q.InserirNo(3);

        System.out.println("Imprimindo fila");

        while (q.GetAtual() != null) {
            System.out.println(">>>" + q.GetAtual().GetData());
            q.MoverPonteiro();
        }
    }
}
