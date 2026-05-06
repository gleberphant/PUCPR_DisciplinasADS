package Adaptadores.ControladoresConsole;

import java.util.Scanner;

import Adaptadores.ExibicaoConsole.ExibicaoConsole;
import Dominio.Modelos.Usuario;
import Aplicacao.Servicos.ServicoUsuarios;

public class ControleUsuario {
    private final ServicoUsuarios servicoUsuarios;
    private final Scanner scanner;
    private final ExibicaoConsole exibe;

    public ControleUsuario(ServicoUsuarios servicoUsuarios, Scanner scanner, ExibicaoConsole exibe) {
        this.scanner = scanner;
        this.servicoUsuarios = servicoUsuarios;
        this.exibe = exibe;
    }

    public void Adicionar() {

        servicoUsuarios.Adicionar(setUsuario(0));

    }

    public void Editar() {

        Usuario usuario = BuscarUsuarioID();

        if (usuario == null)
            return;

        servicoUsuarios.Editar(setUsuario(usuario.ID));

    }

    public void Visualizar() {

        Usuario usuario = BuscarUsuarioID();

        if (usuario == null)
            return;

        System.out.println(exibe.exibeUsuario(usuario));

    }

    public void Listar() {

        System.out.println("Listando todos os usuarios");

        for (Usuario usuario : servicoUsuarios.Listar()) {
            System.out.println(exibe.exibeUsuario(usuario));
        }

    }

    public void Remover() {

        System.out.println("Informe o ID do usuario para remover");

        try {
            servicoUsuarios.Remover(scanner.nextLine());
        } catch (Exception e) {
            System.out.printf("Algo deu errado  : %s", e.getMessage());
            return;
        }

        System.out.println("Usuario removido com sucesso.");

    }

    public void FazerLogin() {

        System.out.printf("\nInforme o login");
        String login = scanner.nextLine();

        System.out.printf("\nInforme a senha");
        String senha = scanner.nextLine();

        try {
            servicoUsuarios.Login(login, senha);
        } catch (Exception e) {
            System.out.printf("Algo deu errado  : $s", e.getMessage());
            return;
        }

        System.out.printf("\nUsuario Logado: %s", servicoUsuarios.GetUsuarioLogado());

    }

    public void VisualizarHistorico() {
        Usuario usuario = servicoUsuarios.GetUsuarioLogado();

        if (usuario == null)
            return;

        System.out.println(exibe.exibirHistorico(usuario));

    }

    // metodo static para outros controladores
    public static Usuario BuscarUsuarioID(ServicoUsuarios usuarios, Scanner scanner) {
        System.out.println("Informe o ID do usuario para pesquisar");

        try {
            Usuario usuario = usuarios.Visualizar(scanner.nextLine());
            System.out.println("Usuario Encontrado");
            return usuario;

        } catch (Exception e) {
            System.out.println("Algo não deu certo: " + e.getMessage());
            return null;
        }

    }

    private Usuario BuscarUsuarioID() {
        return BuscarUsuarioID(this.servicoUsuarios, this.scanner);
    }

    private Usuario setUsuario(int id) {

        System.out.println("Informe os dados do usuario");
        System.out.print("Nome : ");
        String nome = scanner.nextLine();// ler titulo
        System.out.print("CPF : ");
        String cpf = scanner.nextLine();
        System.out.print("Senha : ");
        String senha = scanner.nextLine();

        return new Usuario(id, nome, cpf, senha);
    }

 
}