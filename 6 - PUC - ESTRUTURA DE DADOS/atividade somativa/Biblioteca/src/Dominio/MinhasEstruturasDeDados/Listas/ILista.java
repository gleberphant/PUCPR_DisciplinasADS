package Dominio.MinhasEstruturasDeDados.Listas;

public interface ILista<T> extends Iterable<T> {

    public int Inserir(T dado);

    // retira proximo item da fila
    public T Retirar();

    // retira último item da fila
    public T Ultimo();

    // visualiza proximo item sem remover
    public T Topo();

    // busca por indice
    public T Busca(int i);

    // informa se vazia
    public boolean EstaVazia();

    // remove proximo item
    public void Remover(T chave);

    // remove item por indice
    public void Remover(int indice);

    public int Tamanho();
}
