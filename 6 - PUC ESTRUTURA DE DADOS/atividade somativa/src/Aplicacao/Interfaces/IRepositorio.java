package Aplicacao.Interfaces;
import Dominio.Modelos.Livro;

public interface IRepositorio{


    public void Config();
    public Boolean AdicionarLivro(Livro novo);

    public Livro VisualizarLivro(int id);

    public Livro[] ListarLivros();

    public Boolean EditarLivro(Livro novo);

    public Boolean RemoverLivro(int id);
}