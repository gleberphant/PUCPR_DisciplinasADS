package Infraestrutura.ConsoleUI;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;

import Dominio.Modelos.Usuario;

// Mapeia os controladores e as acoes no menu do console
public class ConsoleRoteador {

    private String titulo;

    private final Map<Integer, String> descricoes;
    private final Map<Integer, Runnable> acoes;
    private final Map<Integer, ConsoleRoteador> subRoteadores;
    private Scanner scanner;
    private Supplier<Usuario> login;

    public ConsoleRoteador(String titulo) {
        this.titulo = titulo;
        this.descricoes = new LinkedHashMap<>();
        this.acoes = new LinkedHashMap<>();
        this.subRoteadores = new LinkedHashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public void SetLogin(Supplier<Usuario> supplier) {
        this.login = supplier;
    }

    public Usuario GetLogin() {

        return login != null ? login.get() : null;
    }

    // Injeta Acao de Controlador e segue um padrão Builder
    public ConsoleRoteador adicionarRota(int chave, String texto, Runnable acao) {
        // Verifica se é um sub-menu (navegação)
        if (subRoteadores.containsKey(chave)) {
            return this;
        }

        descricoes.put(chave, texto);
        acoes.put(chave, acao);

        return this;
    }

    // injeta subRoteador
    public ConsoleRoteador adicionarSubRoteador(int chave, String texto, ConsoleRoteador proximoRoteador) {
        descricoes.put(chave, texto);
        subRoteadores.put(chave, proximoRoteador);
        return this;
    }

    public ConsoleRoteador SetScanner(Scanner in) {
        this.scanner = in;
        return this;
    }

    public ConsoleRoteador Roteamento(int opcao) {
        // if (opcao == 0) return null; // Padrão para voltar

        // Verifica se é um sub-menu (navegação)
        if (subRoteadores.containsKey(opcao)) {
            return subRoteadores.get(opcao);
        }

        // Verifica se é uma ação (execução)
        if (acoes.containsKey(opcao)) {
            if (acoes.get(opcao) == null)
                return null;
            else {
                acoes.get(opcao).run();
                System.out.println("pressione qualquer tecla para prosseguir ...");
                scanner.nextLine();
            }
            return this; // Mantém na mesma tela após executar
        }

        System.out.println("Opção inválida!");
        return this;
    }

    public Map<Integer, String> GetMenu() {
        return descricoes;
    }

    public Scanner GetScanner() {
        return scanner;
    }

    public String GetTitulo() {
        return titulo;
    }

    public void SetTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void Voltar() {
        return;
    }
}