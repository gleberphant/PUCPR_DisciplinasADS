package Infraestrutura.RoteadoresConsole;

import Aplicacao.Interfaces.IRoteador;
import Aplicacao.Interfaces.IServico;

import java.util.Map;

import Adaptadores.ControladoresConsole.ControladorLivro;

public class RoteadorLivro extends RoteadorMain {

    ControladorLivro controladorLivro;

    public RoteadorLivro(IServico servico) {
        this.servico = servico;
        this.Titulo = "Livro";
        this.menu = Map.of(
                1, " 1 - Adicionar um livro ",
                2, " 2 - Visualizar um  livro ",
                3, " 3 - Editar um  livro",
                4, " 4 - Listar todos livros ",
                5, " 5 - Listar todas categorias",
                0, " 0 - VOLTAR");
        this.controladorLivro = new ControladorLivro(this.servico);
    }

    @Override
    public IRoteador Roteamento(int select) {
        switch (select) {
            case 1 -> controladorLivro.Adicionar();
            case 2 -> controladorLivro.Visualizar();
            case 3 -> controladorLivro.Editar();
            case 4 -> controladorLivro.Listar();
            case 5 -> controladorLivro.Remover();
            case 0 -> {
                return null;
            }
            default -> System.out.println("Opção inválida. Tente novamente.");
        }

        return this;
    }

}