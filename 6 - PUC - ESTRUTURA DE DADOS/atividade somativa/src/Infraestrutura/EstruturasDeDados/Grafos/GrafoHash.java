package Infraestrutura.EstruturasDeDados.Grafos;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class GrafoHash<T>{

    // hash table do grafo
    // { no_origem :[ no_destino1, no_destino2 ..... ] }

    HashMap<Integer, T> Repositorio;
    HashMap<Integer, Set<Integer>> TabelaRelacoes;

    public GrafoHash() {
        this.TabelaRelacoes = new HashMap<>();
        this.Repositorio = new HashMap<>();
    }

    public void InserirNo(int id) {

        this.Repositorio.putIfAbsent(id, null);
        this.TabelaRelacoes.putIfAbsent(id, new HashSet<>());
    }

    public void InserirConexao(int id1, int id2) {

        if (id1 == id2)
            return;

        Set<Integer> conexoes = TabelaRelacoes.get(id1);

        this.InserirNo(id2);

        conexoes.add(id2);

    }

    @Override
    public String toString() {

        StringBuilder mensagem = new StringBuilder();

        mensagem.append("Lista de Nós {");

        for (int id : this.Repositorio.keySet()) {
            mensagem.append("("+id+")");
        }
        mensagem.append("}\n");
        mensagem.append(" Tabela de Nós { \n");
        
        for (Map.Entry<Integer, Set<Integer>> entry : this.TabelaRelacoes.entrySet()) {

            mensagem.append("No ("+entry.getKey()+") Conexoes->"+entry.getValue()+"\n");
        }
        mensagem.append("}");
        return mensagem.toString();
    }

    public void Imprimir() {
        System.out.println(this.toString());
    }

}