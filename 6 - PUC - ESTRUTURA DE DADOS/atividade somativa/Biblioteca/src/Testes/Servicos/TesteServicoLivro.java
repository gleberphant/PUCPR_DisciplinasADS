package Testes;

import java.util.Scanner;

import Adaptadores.ControladoresConsole.*;
import Adaptadores.Repositorios.EmMemoria.RepositorioLivros;
import Adaptadores.Repositorios.EmMemoria.RepositorioUsuarios;
import Dominio.Modelos.Livro;
import Dominio.Modelos.Usuario;
import Aplicacao.Servicos.ServicoLivros;
import Aplicacao.Servicos.ServicoUsuarios;

public class TesteServicoLivro {

    public static void main(String[] args) {

        System.out.println("REALIZANDO TESTES DO SERVICO LIVRO");
        // configura aplicação

        var servicoLivros = new ServicoLivros(new RepositorioLivros());
        var servicoUsuarios = new ServicoUsuarios(new RepositorioUsuarios());
        servicoUsuarios.Adicionar(new Usuario(0, "root","","senha"));
        var root = servicoUsuarios.Login("root", "senha");

        int numItens = 20;

        // mocar dados em massa
        System.out.println("\n Mockando Dados");
        for (int i = 0; i < numItens; i++) {
            System.out.println("Livro " + i + "Autor " + i);
            servicoLivros.AdicionarLivro(new Livro(i, "Livro " + i, "Autor " + i, ""));
        }

        // visualizar
        System.out.println("\nVisualizando Dados");
        for (int i = 0; i < numItens; i++) {
            System.out.println(servicoLivros.VisualizarLivro(root, i+""));
        }

        // remover
        System.out.println("\nRemovendo Dados");
        for (int i = 0; i < numItens-4 ; i++) {

            servicoLivros.RemoverLivro(servicoLivros.BuscarLivroPorID(i+""));
        }

        // listar
        ControleLivro app = new ControleLivro(
                servicoLivros,
                servicoUsuarios,
                new Scanner(System.in));

        System.out.println("\nListar Dados");
        app.ListarLivros();

    }

}
