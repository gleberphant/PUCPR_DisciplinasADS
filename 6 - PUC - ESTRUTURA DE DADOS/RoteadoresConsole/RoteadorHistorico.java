package Infraestrutura.RoteadoresConsole;

import Aplicacao.Interfaces.IRoteador;
import Aplicacao.Interfaces.IServico;

import java.util.Map;

import Adaptadores.ControladoresConsole.ControladorUsuario;

public class RoteadorHistorico extends RoteadorMain {

    ControladorUsuario controladorUsuario;

    public RoteadorHistorico(IServico servico) {
        this.servico = servico;
        this.Titulo = "Livro";
        this.menu = Map.of(
            1, " 1-> Adicionar USUÁRIO ",
            2, " 2-> Visualizar USUÁRIO ",
            3, " 3-> Editar USUÁRIO",
            0, " 0-> Sair");
        this.controladorUsuario = new ControladorUsuario(this.servico);
    }

    @Override
    public IRoteador Roteamento(int select) {
        switch (select) {
            case 1 -> controladorUsuario.Adicionar();
            case 2 -> controladorUsuario.Visualizar();
            case 3 -> controladorUsuario.Editar();
            case 4 -> controladorUsuario.Listar();
            case 5 -> controladorUsuario.Remover();
            case 0 -> {
                return null;
            }
            default -> System.out.println("Opção inválida. Tente novamente.");
        }

        return this;
    }

}