package Aplicacao.Interfaces;

import Aplicacao.Modelos.Livro;

public interface ICasoDeUsoLivro {
       public Livro Executar(String stringID, IRepositorioLivro repositorioLivros);
}
