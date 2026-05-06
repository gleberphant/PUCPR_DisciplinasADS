package Adaptadores.Repositorios.EmMemoria;

import java.util.Iterator;

import Aplicacao.Interfaces.IRepositorioLivros;
import Dominio.MinhasEstruturasDeDados.Arvores.ArvoreBinaria;

import Dominio.MinhasEstruturasDeDados.Listas.Lista;
import Dominio.Modelos.Livro;

// repositorio dos livros
// armazena os livros em uma arvore binária

public class RepositorioLivros implements IRepositorioLivros {

    private ArvoreBinaria<Livro> arvoreLivros;

    int contagem;

    public RepositorioLivros() {
        arvoreLivros = new ArvoreBinaria<Livro>();

    }

    public Livro InserirLivro(Livro livro) {

        contagem++;
        arvoreLivros.Inserir(livro);

        return livro;
    }

    public Lista<Livro> ListarLivros() {

        Lista<Livro> lista = new Lista<>();

        // transforma arvore em lista;
        for (var livro : arvoreLivros) {
            lista.Inserir(livro);
        }

        return lista;

    }

    public Livro EditarLivro(Livro novoLivro) {

        var livro = BuscarLivroPorID(novoLivro.ID);
        livro = novoLivro;

        return livro;

    }

    // comparableTo de Livro, compara apenas somente pelo ID
    public Livro BuscarLivroPorID(int ID) {

        return arvoreLivros.Buscar(new Livro(ID, null, null, null));

    }

    public Livro Topo() {

        return arvoreLivros.iterator().next();
    }

    public Livro BuscarLivroAleatorio() {

        /// percorre a arvore e com 20% de chance de retornar um valor
        for (var item : this) {
            if (Math.random() < 0.2) {
                return item;
            }

        }

        return arvoreLivros.iterator().next();

    }

    public void RemoverLivro(Livro livro) {

        arvoreLivros.Remover(livro);
    }

    public int QuantidadeLivros() {
        return arvoreLivros.Tamanho();
    }

    public int ContagemLivros() {
        return contagem;
    }

    public String toString() {
        return arvoreLivros.toString();
    }

    // percorre toda arvore
    @Override
    public Iterator<Livro> iterator() {
        // a iteração segue normal pq estou inserindo no fim da lista
        return arvoreLivros.iterator();
    }

}
