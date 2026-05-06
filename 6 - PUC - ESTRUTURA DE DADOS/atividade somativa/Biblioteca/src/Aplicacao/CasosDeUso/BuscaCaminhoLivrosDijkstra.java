package Aplicacao.CasosDeUso;

import Dominio.Modelos.Livro;

import Aplicacao.Interfaces.IRepositorioRecomendacoes;

import Dominio.MinhasEstruturasDeDados.Listas.ILista;
import Dominio.MeusAlgoritmos.BuscaEmGrafos;


public class BuscaCaminhoLivrosDijkstra {

    public ILista<Livro> execute(Livro livro1, IRepositorioRecomendacoes repositorio) {
        var grafo = repositorio.GetGrafo().mapaAdjacencias;
        var livro2 = repositorio.GetGrafo().GetAleatorio();

        BuscaEmGrafos<Livro> buscador = new BuscaEmGrafos<>();
        var caminho = buscador.BuscaDijkstra(grafo, livro1, livro2);

        return buscador.ConverterParaLista(caminho, livro1, livro2);
    }
}
