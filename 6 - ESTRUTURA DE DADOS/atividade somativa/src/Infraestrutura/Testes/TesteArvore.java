package Infraestrutura.Testes;
import EstruturasNaoLineares.*;
import Nos.NoArvore;
public class TesteArvore {
    public static void main(String[] args) {
    
        ArvoreBinaria tree = new ArvoreBinaria();

        tree.AddNode(new NoArvore(1));
        tree.AddNode(new NoArvore(4));
        tree.AddNode(new NoArvore(10));
        tree.AddNode(new NoArvore(5));
        tree.AddNode(new NoArvore(2));
        tree.AddNode(new NoArvore(9));
        tree.AddNode(new NoArvore(7));
        tree.AddNode(new NoArvore(8));
        tree.Reset();
       
       imprime(tree.GetCurrent());
    }

    public static void imprime(NoArvore current){

        if (current == null){
            System.out.println("Vazio");
            return;}

        System.out.println(" "+current.GetData());

        System.out.print("Direita: ");
        imprime(current.GetDireito());

        System.out.print("Esquerda: ");
        imprime(current.GetEsquerdo());


        
    }
}
