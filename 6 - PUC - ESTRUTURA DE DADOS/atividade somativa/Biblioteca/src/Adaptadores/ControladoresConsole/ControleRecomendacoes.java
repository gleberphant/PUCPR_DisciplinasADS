package Adaptadores.ControladoresConsole;

import java.util.Scanner;

import Adaptadores.ExibicaoConsole.ExibicaoConsole;
import Aplicacao.CasosDeUso.BuscaCaminhoLivrosDijkstra;
import Dominio.Modelos.Livro;
import Aplicacao.Servicos.ServicoLivros;
import Aplicacao.Servicos.ServicoUsuarios;

public class ControleRecomendacoes {

    private final ServicoLivros servicoLivros;
    private final ExibicaoConsole exibe;

    private final Scanner scanner;

    public ControleRecomendacoes(ServicoLivros servicoLivros, ServicoUsuarios servicoUsuarios, Scanner scanner,
            ExibicaoConsole exibe) {
        this.scanner = scanner;
        this.servicoLivros = servicoLivros;
        this.exibe = exibe;
    }

    public void ListarRecomendacoes() {

        var listaDeLivros = servicoLivros.ListarLivros();
        for (var livro : listaDeLivros) {

            var listaDeRecomendacoes = servicoLivros.ListarRecomendacoes(livro.ID + "");
            if (listaDeRecomendacoes.Tamanho() > 0)
                System.out.println(exibe.exibeRecomendacoes(livro, listaDeRecomendacoes));
        }

    }

    public void VisualizarRecomendacoes() {
        Livro livro = ControleLivro.BuscarLivro(servicoLivros, scanner);

        System.out.println(exibe.exibeRecomendacoes(livro, servicoLivros.ListarRecomendacoes(livro.ID + "")));

    }

    public void BuscarCaminho() {
        Livro livro1 = ControleLivro.BuscarLivro(servicoLivros, scanner);

        System.out.println("procurando conexoes");
        var caminho = new BuscaCaminhoLivrosDijkstra().execute(livro1, servicoLivros.respositorioRecomendacoes);

        System.out.println(exibe.exibeRecomendacoes(livro1, caminho));

    }

}
