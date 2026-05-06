package Adaptadores.ControladoresConsole;

import java.util.Scanner;

import Adaptadores.ExibicaoConsole.ExibicaoConsole;
import Dominio.Modelos.Livro;
import Dominio.Modelos.Usuario;
import Aplicacao.Servicos.ServicoEmprestimos;
import Aplicacao.Servicos.ServicoLivros;
import Aplicacao.Servicos.ServicoUsuarios;

public class ControleEmprestimos {
    private final ServicoLivros servicoLivros;
    private final ServicoUsuarios servicoUsuarios;
    private final ServicoEmprestimos servicoEmprestimos;
    private final ExibicaoConsole exibe;

    private final Scanner scanner;

    public ControleEmprestimos(ServicoLivros servicoLivros, ServicoUsuarios servicoUsuarios,
            ServicoEmprestimos servicoEmprestimos, Scanner scanner, ExibicaoConsole exibe) {
        this.scanner = scanner;
        this.servicoLivros = servicoLivros;
        this.servicoUsuarios = servicoUsuarios;
        this.servicoEmprestimos = servicoEmprestimos;
        this.exibe = exibe;
    }

    // EMPRESTIMOS
    public void Emprestar() {

        // procurar o Livro
        Livro livro = ControleLivro.BuscarLivro(servicoLivros, scanner);

        if (livro == null)
            return;

        System.out.println(livro.toString());

        // procurar o usuario
        Usuario usuario = ControleUsuario.BuscarUsuarioID(servicoUsuarios, scanner);

        if (usuario == null) {
            return;
        }

        System.out.println(usuario.toString());

        try {
            // Realizar o empréstimo
            int posicao = servicoEmprestimos.Emprestar(livro, usuario);

            if (posicao == 0) {
                // se posicao for zero
                System.out.println("Livro emprestado para: " + livro.Locador.Nome);

                // se retorno da posicao for maior que zero
            } else {
                System.out.printf("\n O livro encontra-se emprestado para %s ", livro.Locador.Nome);
                System.out.printf("\n O usuario %s foi inserido na lista de espera na posição %d",
                        livro.FilaEspera.Topo().Nome, posicao);
            }

        } catch (Exception e) {
            System.out.println("Algo não deu certo: " + e.getMessage());
            return;
        }

    }

    // Devolver empréstimo
    public void Devolver() {

        Livro livro = ControleLivro.BuscarLivro(servicoLivros, scanner);

        if (livro == null) {
            return;
        }

        System.out.println(exibe.exibeLivro(livro));

        servicoEmprestimos.Devolver(livro);
        System.out.printf("\n Livro devolvido para biblioteca");
        System.out.printf("\n Próximo Usuário na fila de espera do livro", livro.FilaEspera.Topo());

    }

    public void VisualizarEmprestimos() {
        System.out.println("Informe o ID do LIVRO para procurar");

        Livro livro = ControleLivro.BuscarLivro(servicoLivros, scanner);

        System.out.println("Exibindo emprestivos no livro \n");
        System.out.println(exibe.exibeFilaEspera(livro));

    }

    public void ListarEmprestimos() {

        System.out.println("Listando todos empréstimos de livros : \n");
        for (var livro : servicoLivros.ListarLivros()) {

            System.out.println(exibe.exibeFilaEspera(livro));

        }

    }

}
