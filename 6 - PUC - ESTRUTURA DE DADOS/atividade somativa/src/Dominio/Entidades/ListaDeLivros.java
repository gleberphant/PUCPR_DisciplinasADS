package Dominio.Entidades;

import Dominio.Modelos.Livro;
import Infraestrutura.EstruturasDeDados.Listas.ListaEncadeada;

public class ListaDeLivros {

    ListaEncadeada<Livro> ListaLivros;

    public ListaDeLivros() {
        ListaLivros = new ListaEncadeada<Livro>();
        this.Config();
    }

    public void Config() {

    }

    public Boolean AdicionarLivro(Livro novo) {

        novo.id = ListaLivros.Tamanho() == 0 ? 0 : ListaLivros.GetUltimoDado().id + 1;
        ListaLivros.Inserir(novo);
        return true;
    }

    public Livro VisualizarLivro(int id) {

        Livro livro;

        for (int i = 0; i < ListaLivros.Tamanho(); i++) {
            livro = ListaLivros.Get(i);
            if (livro.id == id) {
                return livro;
            }
        }

        return null;
    }

    public Livro[] ListarLivros() {

        Livro[] livros = new Livro[ListaLivros.Tamanho()];

        for (int i = 0; i < ListaLivros.Tamanho(); i++) {
            livros[i] = ListaLivros.Get(i);
        }

        return livros;
    }

    public Boolean EditarLivro(Livro novo) {
        Livro livro;

        for (int i = 0; i < ListaLivros.Tamanho(); i++) {

            livro = ListaLivros.Get(i);

            if (livro.id == novo.id) {
                ListaLivros.Set(i, livro);
                return true;
            }
        }

        return false;

    }

    public Boolean RemoverLivro(int id) {
        Livro livro;

        for (int i = 0; i < ListaLivros.Tamanho(); i++) {

            livro = ListaLivros.Get(i);

            if (livro.id == id) {
                ListaLivros.RemoverNo(i);
                return true;
            }

        }

        return false;
    }

}