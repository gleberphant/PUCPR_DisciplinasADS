package Dominio.MinhasEstruturasDeDados.Grafos;


import java.util.HashMap;

import java.util.Map;


import Dominio.MeusAlgoritmos.BuscaEmGrafos;

import java.util.Iterator;
import java.util.LinkedHashMap;


public class GrafoHash<T extends Comparable<T>> implements IGrafo<T> {

    // mapa de adjacências

    // { no_origem1 :{ no_destino1: peso , no_destino2: peso, .... }, ... }

    public Map<T, Map<T, Integer>> mapaAdjacencias;

    public GrafoHash() {
        this.mapaAdjacencias = new LinkedHashMap<>();

    }

    public T InserirItem(T item) {

        this.mapaAdjacencias.putIfAbsent(item, new HashMap<>());

        return item;

    }

    public Map<T, Integer> InserirConexao(T chave1, T chave2) {
        // impede relações recursivas.
        if (chave1.equals(chave2))
            return null;

        // checar se os dois objetos existem. senão cria o inexistente
        if (!mapaAdjacencias.containsKey(chave1))
            mapaAdjacencias.putIfAbsent(chave1, new HashMap<>());

        if (!mapaAdjacencias.containsKey(chave2))
            mapaAdjacencias.putIfAbsent(chave2, new HashMap<>());

        // Se a conexão já existe, incrementa o peso
        if (mapaAdjacencias.get(chave1).containsKey(chave2)) {
            int pesoAtual = mapaAdjacencias.get(chave1).get(chave2);
            mapaAdjacencias.get(chave1).put(chave2, pesoAtual + 1);
        }
        // Se não existe, cria a conexão com peso inicial (ex: 1)
        else {
            mapaAdjacencias.get(chave1).put(chave2, 1);
        }

        return mapaAdjacencias.get(chave1);

    }

    public Map<T, Integer> MapaDeConexoes(T chave) {

        return mapaAdjacencias.get(chave);

    }

    // busca o menor caminho usando o dijkstra.
    public Map<T, T> BuscarCaminho(T inicio, T fim) {
        return new BuscaEmGrafos<T>().BuscaDijkstra(mapaAdjacencias, inicio, fim);
    }

    public void RemoverItem(T chave) {
        mapaAdjacencias.remove(chave);
    }

    // retorna o tamanho atual do mapa
    public int Tamanho() {
        return mapaAdjacencias.size();
    }

    public T GetPrimeiro() {
        if (mapaAdjacencias.isEmpty())
            return null;

        return mapaAdjacencias.keySet().iterator().next();
    }

    public T GetUltimo() {

        T ultimo = null;

        for (var item : mapaAdjacencias.keySet()) {
            ultimo = item;
        }

        return ultimo;

    }

    public T GetAleatorio() {

        /// percorre o grafo com 20% de chance de retornar um valor
        for (var item : this) {
            if (Math.random() < 0.2) {
                return item;
            }

        }

        return this.iterator().next();

    }

    // toString coloquei para retornar formato JASON
    @Override
    public String toString() {
        if (mapaAdjacencias.isEmpty())
            return "{}";

        var sj = new StringBuilder();

        sj.append(String.format("{\n"));
        for (var item : mapaAdjacencias.entrySet()) {

            sj.append(String.format("'%2s': {", item.getKey().toString()));

            for (var destino : item.getValue().entrySet()) {
                sj.append(String.format("'%s': %s, ", destino.getKey(), destino.getValue()));
            }

            sj.append(String.format("},\n", item.getKey()));
        }

        sj.append(String.format("}"));
        return sj.toString();
    }

    
    @Override
    public Iterator<T> iterator() {
        return mapaAdjacencias.keySet().iterator();
    }

}