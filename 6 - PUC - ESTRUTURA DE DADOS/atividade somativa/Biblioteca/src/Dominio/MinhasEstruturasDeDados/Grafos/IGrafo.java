package Dominio.MinhasEstruturasDeDados.Grafos;

import java.util.Map;

public interface IGrafo<T> extends Iterable<T> {

    public T InserirItem(T valor);

    public void RemoverItem(T chave);

    public Map<T, Integer> InserirConexao(T chave1, T chave2);

    public Map<T, Integer> MapaDeConexoes(T chave);

    public Map<T, T> BuscarCaminho(T inicio, T fim);

}