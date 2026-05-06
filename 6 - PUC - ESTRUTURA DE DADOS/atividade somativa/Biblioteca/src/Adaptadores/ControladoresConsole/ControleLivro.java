package Adaptadores.ControladoresConsole;

import java.util.Scanner;

import Adaptadores.ExibicaoConsole.ExibicaoConsole;
import Dominio.Modelos.Livro;
import Aplicacao.CasosDeUso.BuscaLivroPorID;
import Aplicacao.Servicos.ServicoLivros;
import Aplicacao.Servicos.ServicoUsuarios;

public class ControleLivro {
    private final ServicoLivros servicoLivros;
    private final ServicoUsuarios servicoUsuarios;
    private final ExibicaoConsole exibe;
    

    private final Scanner scanner;

    public ControleLivro(ServicoLivros servicoLivros, ServicoUsuarios servicoUsuarios, Scanner scanner,ExibicaoConsole exibe) {
        this.scanner = scanner;
        this.servicoLivros = servicoLivros;
        // this.repositorioLivros = servicoLivros.repositorioLivros;
        this.servicoUsuarios = servicoUsuarios;
        this.exibe = exibe;
    }

    public void AdicionarLivro() {

        var novoLivro = formularioNovoLivro();

        servicoLivros.AdicionarLivro(novoLivro);

    }

    public void EditarLivro() {

        Livro livro = buscarLivro();

        if (livro == null)
            return;

        var novoLivro = formularioNovoLivro();

        novoLivro.ID = livro.ID;

        servicoLivros.EditarLivro(novoLivro);

    }

    public void VisualizarLivro() {

        System.out.println("Informe o ID do livro procurado");
        try {

            Livro livro = servicoLivros.VisualizarLivro(servicoUsuarios.GetUsuarioLogado(), scanner.nextLine());
            // servicoUsuarios.RegistrarHistórico(livro);
            System.out.println(exibe.exibeLivro(livro));

        } catch (Exception e) {
            System.err.printf("Algo deu errado %s", e.getMessage());

        }

    }

    public void ListarLivros() {

        System.out.println("Listando todos os livros");

        for (Livro livro : servicoLivros.ListarLivros()) {
            System.out.println(exibe.exibeLivro(livro));
        }

    }

    public void RemoverLivro() {

        Livro livro = buscarLivro();

        if (livro == null)
            return;

        servicoLivros.RemoverLivro(livro);

        System.out.println("Removendo o livro ");

    }

    private Livro formularioNovoLivro() {
        System.out.println("Informe os dados do livro");

        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();// ler titulo
        System.out.print("Autor : ");
        String autor = scanner.nextLine();
        System.out.print("Ano : ");
        String ano = scanner.nextLine();

        return new Livro("0", titulo, autor, ano);

    }

    private Livro buscarLivro() {
        return BuscarLivro(this.servicoLivros, this.scanner);
    }

    public static Livro BuscarLivro(ServicoLivros servicoLivros, Scanner scanner) {
        System.out.println("Informe o ID do livro para pesquisar");

        try {
            Livro livro = new BuscaLivroPorID().Executar(scanner.nextLine(), servicoLivros.repositorioLivros);
            System.out.println("Livro Encontrado");
            return livro;

        } catch (Exception e) {
            System.out.println("Algo não deu certo: " + e.getMessage());
            return null;
        }

    }


}