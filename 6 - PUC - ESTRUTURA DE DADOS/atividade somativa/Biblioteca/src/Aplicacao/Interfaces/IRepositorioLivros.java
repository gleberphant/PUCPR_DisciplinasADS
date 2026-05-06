package Aplicacao.Interfaces;

import Dominio.Modelos.Livro;

import Dominio.MinhasEstruturasDeDados.Listas.Lista;

public interface IRepositorioLivros extends Iterable<Livro> {

    // inserir um item
    public Livro InserirLivro(Livro livro);

    // Lista de livros
    public Lista<Livro> ListarLivros();

    // Editar um livro
    public Livro EditarLivro(Livro novoLivro);

    // Buscar um livro por ID
    Livro BuscarLivroPorID(int ID);

    // pegar um livro aleatorio
    Livro BuscarLivroAleatorio();

    // remove proximo item
    public void RemoverLivro(Livro chave);

    // quantidade de itens no repositorio
    public int ContagemLivros();

    // quantidade de itens no repositorio
    public int QuantidadeLivros();

}
