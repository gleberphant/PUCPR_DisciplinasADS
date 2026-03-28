package Aplicacao.CasosDeUso;

import Aplicacao.Interfaces.*;
import Dominio.Modelos.Livro;
import Dominio.Entidades.*;

public class ServicoBiblioteca implements ICasodeUso {

    IRepositorio repositorio;
    ListaDeLivros listaLivros;

    public ServicoBiblioteca(IRepositorio repositorio) {
        this.Config(repositorio);
    }

    public void Config(IRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Boolean AdicionarLivro(Livro novo) {
        listaLivros.AdicionarLivro(novo);
        return true;
    }

    public Livro VisualizarLivro(int id) {
        return listaLivros.VisualizarLivro(id);
    }

    public Livro[] ListarLivros() {
        return listaLivros.ListarLivros();
    }

    public Boolean EditarLivro(Livro novo) {
        return listaLivros.EditarLivro(novo);
    }

    public Boolean RemoverLivro(int id) {
        return listaLivros.RemoverLivro(id);
    }
}