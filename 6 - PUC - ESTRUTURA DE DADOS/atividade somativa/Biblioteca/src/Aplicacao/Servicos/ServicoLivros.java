package Aplicacao.Servicos;

import java.util.NoSuchElementException;

import Aplicacao.Interfaces.*;
import Dominio.Modelos.Livro;
import Dominio.Modelos.Usuario;


import Dominio.MinhasEstruturasDeDados.Listas.Lista;

public class ServicoLivros {

    public IRepositorioLivros repositorioLivros;
    public IRepositorioRecomendacoes respositorioRecomendacoes;

    public ServicoLivros(IRepositorioLivros repositorioLivros, IRepositorioRecomendacoes respositorioRecomendacoes) {
        this.repositorioLivros = repositorioLivros;
        this.respositorioRecomendacoes = respositorioRecomendacoes;

    }

    // RETORNA O ID DO NOVO LIVRO
    public int AdicionarLivro(Livro livro) {

        repositorioLivros.InserirLivro(livro);
        respositorioRecomendacoes.InserirLivro(livro);

        return livro.ID;
    }

    public Livro VisualizarLivro(Usuario usuarioLogado, String livroID) {

        if (usuarioLogado == null)
            throw new NoSuchElementException("usuarioLogado inválido");

        Livro livro1 = BuscarLivroPorID(validaId(livroID));

        for (var livro2 : usuarioLogado.historicoNavegacao) {
            // inserir recomendacao
            respositorioRecomendacoes.InserirRecomendacao(livro1, livro2);

        }

        usuarioLogado.historicoNavegacao.Inserir(livro1);

        return livro1;
    }

    public Lista<Livro> ListarLivros() {

        Lista<Livro> lista = repositorioLivros.ListarLivros();

        return lista;
    }

    public Livro EditarLivro(Livro novoLivro) {

        repositorioLivros.EditarLivro(novoLivro);

        return novoLivro;

    }

    public void RemoverLivro(Livro livro) {

        for (var item : repositorioLivros) {

            if (item.ID == livro.ID) {
                repositorioLivros.RemoverLivro(item);
                respositorioRecomendacoes.RemoverLivro(item);
                return;
            }
        }

        throw new NoSuchElementException("Livro não encontrado");
    }

    public Livro BuscarLivroPorID(int ID) {

        Livro livro = repositorioLivros.BuscarLivroPorID(ID);

        if (livro == null)
            throw new NoSuchElementException("Livro não encontrado");

        return livro;

    }


    private int validaId(String stringID) {
        int id;
        try {
            id = Integer.parseInt(stringID);
        } catch (Exception e) {
            throw new NoSuchElementException("Digite um ID válido");
        }

        return id;
    }

    public Lista<Livro> ListarRecomendacoes(String livroID) {

        Livro livro = BuscarLivroPorID(validaId(livroID));

        return respositorioRecomendacoes.ListarRecomendacoes(livro);

    }

}