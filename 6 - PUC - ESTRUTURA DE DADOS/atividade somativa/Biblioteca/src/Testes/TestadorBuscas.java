package Testes;

import java.util.LinkedHashMap;
import java.util.Map;

import Dominio.MeusAlgoritmos.BuscaEmGrafos;
import Dominio.MinhasEstruturasDeDados.Grafos.GrafoHash;

@FunctionalInterface
interface IAlgoritmosBuscas<T extends Comparable<T>> {
    public Map<T, T> buscar(Map<T, Map<T, Integer>> grafo, T inicio, T fim);
}

public class TestadorBuscas<T extends Comparable<T>> {
    public static void main(String[] args) {
        new TestadorBuscas<>().Executar();
    }

    public void Executar() {

        System.out.print("\n ------------ Mockando o Grafo -------------------------- ");
        GrafoHash<T> grafo = new TestadorGrafos<T>().MockarGrafo(new GrafoHash<>());
        System.out.print("\n" + grafo.toString());

        T inicio = grafo.GetAleatorio();
        T fim = grafo.GetAleatorio();
        // se forem iguais re rola ate fica diferente
        while ((inicio == null || fim == null) || (inicio.compareTo(fim) == 0)) {
            inicio = grafo.GetAleatorio();
            fim = grafo.GetAleatorio();
        }

        //System.out.print("\n" + "-".repeat(24) + " Configurar Algoritmos "+ "-".repeat(24));
        BuscaEmGrafos<T> algoritimos = new BuscaEmGrafos<>();
        Map<String, IAlgoritmosBuscas<T>> buscadores = new LinkedHashMap<>();

        buscadores.put("DFS - Busca Em Largura - Rota mais curta", algoritimos::BuscaEmLargura);
        buscadores.put("BFS - Busca Em Produnfidade - Menor tempod e busca", algoritimos::BuscaEmProfundidade);
        buscadores.put("Busca Dijkstra - Rota mais 'barata' ", algoritimos::BuscaDijkstra);

        System.out.print("\n" + "-".repeat(22) + " Testar Algoritmos "+ "-".repeat(26));
        System.out.print("\n    "+ "-".repeat(60)+"");
        System.out.print("\n    Buscar entre: [" + inicio + "] e [" + fim + "]");
        System.out.print("\n    "+ "-".repeat(60));
        for (var item : buscadores.entrySet()) {
            long tempoInicial = System.nanoTime();
            String rotulo = item.getKey();
            var buscador = item.getValue();
            System.out.print("\n    Algoritmo        : " + rotulo);

            var caminho = buscador.buscar(grafo.mapaAdjacencias, inicio, fim);
            System.out.print("\n    Rota encontrada  : ");
            System.out.print(algoritimos.CaminhoToString(caminho, inicio, fim));
            // marca tempo final
            long tempoFinal = System.nanoTime();

            // exibe tempo de eexecução
            System.out.printf("\n    Tempo de Execução: %.5f ms ", (float) (tempoFinal - tempoInicial) / 1000000);
            System.out.print("\n    "+ "-".repeat(60));

        }
        System.out.print("\n"+ "-".repeat(66));
    }

}
