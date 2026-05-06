package Adaptadores.Repositorios.EmMemoria;

import java.util.Iterator;

import Aplicacao.Interfaces.IRepositorioRecomendacoes;

import Dominio.MinhasEstruturasDeDados.Grafos.GrafoHash;
import Dominio.MinhasEstruturasDeDados.Listas.Lista;
import Dominio.Modelos.Livro;

// repositorio dosrecomendacoes
// armazena as recomendações em um grafo

public class RepositorioRecomendacoes implements IRepositorioRecomendacoes {

    private GrafoHash<Livro> grafoRecomendacoes;

    int contagem;

    public RepositorioRecomendacoes() {
        grafoRecomendacoes = new GrafoHash<Livro>();

    }

    public GrafoHash<Livro> GetGrafo() {
        return grafoRecomendacoes;
    }

    public Livro InserirLivro(Livro livro) {

        contagem++;
        grafoRecomendacoes.InserirItem(livro);

        return livro;
    }

    public void RemoverLivro(Livro livro) {

        grafoRecomendacoes.RemoverItem(livro);

    }

    public void InserirRecomendacao(Livro livro1, Livro livro2) {
        grafoRecomendacoes.InserirConexao(livro1, livro2);
    }

    public Lista<Livro> ListarRecomendacoes(Livro livro) {

        Lista<Livro> lista = new Lista<>();

        var livroMapaConexoes = grafoRecomendacoes.mapaAdjacencias.get(livro);
        if (livroMapaConexoes == null)
            return lista;

        for (var item : livroMapaConexoes.keySet()) {
            lista.Inserir(item);
        }
        return lista;
    }

    public String toString() {
        return grafoRecomendacoes.toString();
    }

    // percorre toda arvore
    @Override
    public Iterator<Livro> iterator() {
        // a iteração segue normal pq estou inserindo no fim da lista
        return grafoRecomendacoes.iterator();
    }

}