package Testes;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

import Dominio.MeusAlgoritmos.OrdenacaoLista;
import Dominio.MinhasEstruturasDeDados.Listas.ILista;
import Dominio.MinhasEstruturasDeDados.Listas.Lista;

public class TestadorOrdenacao<T extends Comparable<T>> {

    public static void main(String[] args) {

        TestadorOrdenacao<Integer> testeOrdenacao = new TestadorOrdenacao<>();
        testeOrdenacao.Executar();

    }

    public void Executar() {

        OrdenacaoLista<T> algoritimos = new OrdenacaoLista<>();

        System.out.print("\nCriando Mapa de algoritmos de ordenação\n ");
        Map<String, Function<ILista<T>, ILista<T>>> ordenadores = new LinkedHashMap<>();
        ordenadores.put("BubbleSort", algoritimos::BubbleSort);
        ordenadores.put("MergeSort", algoritimos::MergeSort);
        ordenadores.put("QuickSort", algoritimos::QuickSort);

        System.out.print("\nMockando Lista desordenada\n ");
        TestadorListas<T> testadorLista = new TestadorListas<>();
        ILista<T> listaDesordenada = testadorLista.MockarLista(new Lista<>());

        System.out.print("\nExecutando algoritmos \n");
        for (var item : ordenadores.entrySet()) {
            // marca tempo inicial
            long tempoInicial = System.nanoTime();

            var rotulo = item.getKey();
            var algoritmo = item.getValue();

            System.out.printf("\n" + "-".repeat(30) + " %-12s " + "-".repeat(listaDesordenada.Tamanho() * 3), rotulo);

            // exibe lista desordenada
            // System.out.printf("\n Lista Desordenada: " + listaDesordenada.toString() +
            // "");

            // ordena
            ILista<T> listaOrdenada = algoritmo.apply(listaDesordenada);

            // exibe lista ordenada
            System.out.printf("\n Lista Ordenada: " + listaOrdenada.toString() + "");

            // marca tempo final
            long tempoFinal = System.nanoTime();

            // exibe tempo de eexecução
            System.out.printf("\n Tempo de Execução: %.5f ms ", (float) (tempoFinal - tempoInicial) / 1000000);

            System.out.printf("\n" + "-".repeat(44 + (listaDesordenada.Tamanho() * 3)) + "\n");
        }

    }

}
