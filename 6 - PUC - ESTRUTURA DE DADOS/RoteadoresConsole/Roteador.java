package Infraestrutura.RoteadoresConsole;

import Aplicacao.Interfaces.IComando;
import java.util.LinkedHashMap;
import java.util.Map;

public class Roteador implements IComando {

    private final String titulo;
    private final Map<Integer, String> descricoes;
    private final Map<Integer, Runnable> acoes;
    private final Map<Integer, IComando> subRoteadores;

    public Roteador(String titulo) {
        this.titulo = titulo;
        this.descricoes = new LinkedHashMap<>();
        this.acoes = new LinkedHashMap<>();
        this.subRoteadores = new LinkedHashMap<>();
    }

    // injeta acao de controlador
    public void adicionarOpcao(int chave, String texto, Runnable acao) {
        // Verifica se é um sub-menu (navegação)
        if (subRoteadores.containsKey(chave)) {
            return;
        }
        descricoes.put(chave, texto);
        acoes.put(chave, acao);
    }

    // injeta subRoteador
    public void adicionarSubMenu(int chave, String texto, IComando proximoRoteador) {
        descricoes.put(chave, texto);
        subRoteadores.put(chave, proximoRoteador);
    }

    @Override
    public IComando Roteamento(int opcao) {
        if (opcao == 0) return null; // Padrão para voltar

        // Verifica se é um sub-menu (navegação)
        if (subRoteadores.containsKey(opcao)) {
            return subRoteadores.get(opcao);
        }

        // Verifica se é uma ação (execução)
        if (acoes.containsKey(opcao)) {
            acoes.get(opcao).run();
            return this; // Mantém na mesma tela após executar
        }

        System.out.println("Opção inválida!");
        return this;
    }

    @Override
    public Map<Integer, String> GetMenu() {
        return descricoes;
    }

    @Override
    public String GetTitulo() {
        return titulo;
    }
}