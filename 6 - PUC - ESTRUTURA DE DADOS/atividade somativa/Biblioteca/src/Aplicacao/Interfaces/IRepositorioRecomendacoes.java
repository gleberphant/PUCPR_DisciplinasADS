package Aplicacao.Interfaces;

import Dominio.Modelos.Livro;
import Dominio.MinhasEstruturasDeDados.Grafos.GrafoHash;
import Dominio.MinhasEstruturasDeDados.Listas.Lista;

public interface IRepositorioRecomendacoes extends Iterable<Livro> {

    // inserir um item
    public Livro InserirLivro(Livro livro);

    // recomendacao
    public GrafoHash<Livro> GetGrafo();

    // Inserir uma Conexao
    public void InserirRecomendacao(Livro t1, Livro t2);

    // Lista de recomendacoes
    public Lista<Livro> ListarRecomendacoes(Livro livro);

    // remoção
    public void RemoverLivro(Livro livro) ;


}
