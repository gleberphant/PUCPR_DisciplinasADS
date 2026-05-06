package Aplicacao.Interfaces;

import Dominio.Modelos.Usuario;
import Dominio.MinhasEstruturasDeDados.Listas.Lista;

public interface IRepositorioUsuarios extends Iterable<Usuario> {

    // pegar o grafo de livro para processamentos
    public Lista<Usuario> GetLista();

    // inserir um item
    public int Inserir(Usuario dado);

    public Usuario BuscarUsuarioPorID(int ID);

    public Usuario BuscarNome(String nome);

    public Lista<Usuario> Listar();

    // remove item de indice
    public boolean Remover(int ID);

    public int Contagem();

    // quantidade de itens no repositorio
    public int Tamanho();

    // converter os dados do repositorio para uma string
    public String toString();


}
