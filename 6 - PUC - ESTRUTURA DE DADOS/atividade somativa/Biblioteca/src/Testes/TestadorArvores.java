package Testes;

import Dominio.MinhasEstruturasDeDados.Arvores.ArvoreBinaria;

public class TestadorArvores<T extends Comparable<T>> {
    int TotalItens, TotalConexoes;

    public static void main(String[] args) {
        new TestadorArvores<>().Executar();
    }

    public void Executar() {
        var arvore = MockarArvore(new ArvoreBinaria<>());

        System.out.println("\n EXIBINDO arvore");
        System.out.println(arvore.toStringArvore());
    }

    public ArvoreBinaria<T> MockarArvore(ArvoreBinaria<T> arvore) {
        int numItems = 10 + (int) (Math.random() * 30);
        return MockarArvore(arvore, numItems);
    }

    @SuppressWarnings("unchecked")
    public ArvoreBinaria<T> MockarArvore(ArvoreBinaria<T> arvore, int numItens) {

        TotalItens = numItens;
        for (int i = 0; i < TotalItens; i++) {
            // Gera o valor e converte para T
            Integer valor = (int) (Math.random() * 100);
            arvore.Inserir((T) valor);
            // System.out.print("{" + valor + "} ");
        }

        return arvore;
    }

}
