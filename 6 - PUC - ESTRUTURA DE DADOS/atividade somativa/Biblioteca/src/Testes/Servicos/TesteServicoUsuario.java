package Testes;

import java.util.Scanner;

import Adaptadores.ControladoresConsole.*;
import Adaptadores.Repositorios.EmMemoria.RepositorioUsuarios;
import Dominio.Modelos.Livro;
import Dominio.Modelos.Usuario;
import Aplicacao.Servicos.ServicoUsuarios;

public class TesteServicoUsuario {

    public static void main(String[] args) {

        System.out.println("REALIZANDO TESTES DO SERVICO USUARIO");
        // configura aplicação

        // var servicoLivros = new ServicoLivros(new RepositorioLivros());
        var servicoUsuarios = new ServicoUsuarios(new RepositorioUsuarios());

        int numItens = 5;

        // mocar dados em massa
        System.out.println("\nMockando Usuarios");
        for (int i = 0; i < numItens; i++) {
            System.out.println("ID" + i + "Nome " + i);
            servicoUsuarios.Adicionar(new Usuario(i, "Nome" + i, "cpf" + i, "senha" + i));
        }

        // visualizar
        System.out.println("\nVisualizando Usuarios");
        for (int i = 0; i < numItens; i++) {

            System.out.printf("\nLogin com usuario:%s", "Nome" + i);
            servicoUsuarios.Login("Nome" + i, "senha" + i);
            System.out.printf("\nRegistrar no historico");
            servicoUsuarios.RegistrarHistórico(new Livro());
            servicoUsuarios.RegistrarHistórico(new Livro());
            System.out.printf("\n%s", servicoUsuarios.Visualizar("" + i));
        }

        // remover
        System.out.println("\nRemovendo Dados");
        for (int i = 0; i < numItens - 2; i++) {
            System.out.println("\nRemovendo item " + i);
            servicoUsuarios.Remover(i + "");
        }

        // listar

        ControleUsuario app = new ControleUsuario(
                servicoUsuarios,
                new Scanner(System.in));

        System.out.println("\nListar Dados");
        app.Listar();

    }

}
