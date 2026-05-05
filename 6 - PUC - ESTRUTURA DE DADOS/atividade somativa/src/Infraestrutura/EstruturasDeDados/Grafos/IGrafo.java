package Infraestrutura.EstruturasDeDados.Grafos;

public interface IGrafo<T>{

    public void InserirNo(T valor);
    public void InserirConexao(T valor1, T valor2);
    public void Imprimir();

}