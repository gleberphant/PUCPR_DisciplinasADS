package Aplicacao.Interfaces;

import Adaptadores.Repositorios.IRepositorio;
import Dominio.Modelos.Livro;


public interface ICasodeUso{

    public void Config(IRepositorio repositorio);

    public Boolean AdicionarLivro(Livro novo);

    public Livro VisualizarLivro(int id);

    public Livro[] ListarLivros();

    public Boolean EditarLivro(Livro novo);

    public Boolean RemoverLivro(int id);
}