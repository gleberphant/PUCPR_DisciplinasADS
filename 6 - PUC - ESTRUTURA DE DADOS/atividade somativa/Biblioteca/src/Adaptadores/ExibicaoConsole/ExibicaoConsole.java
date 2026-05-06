package Adaptadores.ExibicaoConsole;

import Dominio.Modelos.Livro;
import Dominio.Modelos.Usuario;

import Dominio.MinhasEstruturasDeDados.Listas.ILista;

public class ExibicaoConsole {
    // usuario
    public String exibirHistorico(Usuario usuario) {

        StringBuilder sb = new StringBuilder();

        sb.append("\n ----------------- Histórico de visualizações --------------- \n");
        sb.append(String.format("\n| Usuario: %-50s| \n", usuario.Nome));
        sb.append("\n ------------------------------------------------------------ \n");
        for (var livro : usuario.historicoNavegacao) {
            sb.append(
                    String.format("|Título: %-22s Autor: %22s|\n",
                            livro.Titulo,
                            livro.Autor));
        }
        sb.append("\n ------------------------------------------------------------ \n");
        return sb.toString();
    }

    public String exibeUsuario(Usuario usuario) {

        return String.format(
                """
                         ------------------------------------------------------------
                        | ID         : %-45s |
                        | Nome       : %-45s |
                        | CPF        : %-45s |
                        | Senha      : %-45s |
                         ------------------------------------------------------------
                        """,
                usuario.ID,
                usuario.Nome,
                usuario.CPF,
                usuario.Senha);
    }

    // livros
    public String exibeFilaEspera(Livro livro) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("\n Livro %s / Emprestado para : %s ", livro.Titulo, livro.Locador));
        sb.append("\n Usuarios na Fila de Espera do livro :");
        for (var usuario : livro.FilaEspera) {
            sb.append(String.format(" [%s], ", usuario.Nome));
        }

        return sb.toString();
    }

    public String exibeLivro(Livro livro) {

        int largura = 55;

        StringBuilder sb = new StringBuilder();

        for (var usuario : livro.FilaEspera) {

            sb.append(usuario.Nome);
        }

        return String.format(
                """
                         %s
                        | ID         : %-40s |
                        | Titulo     : %-40s |
                        | Autor      : %-40s |
                        | Ano        : %-40s |
                        | Locado Para: %-40s |
                        | Fila Espera: %-40s |
                         %s
                        """,
                "-".repeat(largura),
                livro.ID,
                livro.Titulo,
                livro.Autor,
                livro.Ano,
                (livro.Locador != null ? livro.Locador.Nome : "Ninguém"),
                (livro.FilaEspera.Tamanho() > 0 ? sb.toString() : "Sem espera"),
                "-".repeat(largura));

    }

    // recomedacoes
    public String exibeRecomendacoes(Livro livro, ILista<Livro> lista) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\n Recomendacoes para o Livro : %s", livro.Titulo));
        for (Livro recomendacao : lista) {
            sb.append(String.format("\n >> Livro: '%s' Autor: '%s'", recomendacao.Titulo, recomendacao.Autor));
        }

        return sb.toString();
    }
}
