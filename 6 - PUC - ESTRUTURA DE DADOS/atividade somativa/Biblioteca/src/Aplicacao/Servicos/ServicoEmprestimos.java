package Aplicacao.Servicos;


import Aplicacao.Interfaces.IRepositorioLivros;
import Dominio.Modelos.Livro;
import Dominio.Modelos.Usuario;

public class ServicoEmprestimos {
    public IRepositorioLivros repositorioLivros;

    public ServicoEmprestimos(IRepositorioLivros repositorio) {
        repositorioLivros = repositorio;

    }

     // emprestimos
    public int Emprestar(Livro livro, Usuario locador) {
        // se o livro não estiver com ninguem, empresa pra locador, se o locador for o
        // proximo da fila então o livro é empresato para ele. senão adiciona o locador
        // na fila de espera. se o locador ja estiver na fila de esperra não adiciona

        int posicao = 0;
        // se livro nao tem locador então adiciona
        if (livro.Locador == null) {
            livro.Locador = locador;
            return posicao;
        }

        // se livro emprestado e fila de espera vazia, insere na fila
        if (livro.FilaEspera.Topo() == null) {
            livro.FilaEspera.Inserir(locador);
            return posicao;
        }

        // se livro emprestado e e fila não vazia
        // locador é o proximo da fila?
        if (livro.FilaEspera.Topo().ID == locador.ID) {
            livro.Locador = livro.FilaEspera.Retirar();
            return posicao;
        }

        // procura se locador ja existe na fila.

        for (var usuario : livro.FilaEspera) {
            // se locador ja esta na fila não modifica
            if (usuario.ID == locador.ID)
                return posicao;
            posicao++;
        }

        // se locador não está na fila, então adiciona.
        livro.FilaEspera.Inserir(locador);
        return posicao;

    }

    public void Devolver(Livro livro) {

        livro.Locador = null;
        PassarParaProximo(livro);

    }

    public void PassarParaProximo(Livro livro) {

        if (livro.FilaEspera.Tamanho() > 0) {
            livro.Locador = livro.FilaEspera.Retirar();
        }

    }


}
