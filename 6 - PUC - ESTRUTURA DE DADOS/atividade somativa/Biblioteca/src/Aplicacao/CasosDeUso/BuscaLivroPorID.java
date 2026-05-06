package Aplicacao.CasosDeUso;

import java.util.NoSuchElementException;

import Dominio.Modelos.Livro;
import Aplicacao.Interfaces.IRepositorioLivros;

public class BuscaLivroPorID {

    public Livro Executar(String stringID, IRepositorioLivros repositorioLivros) {

        var ID = Integer.parseInt(stringID);
        Livro livro = repositorioLivros.BuscarLivroPorID(ID);
        if (livro == null)
            throw new NoSuchElementException("Livro não encontrado");

        return livro;

    }

}
