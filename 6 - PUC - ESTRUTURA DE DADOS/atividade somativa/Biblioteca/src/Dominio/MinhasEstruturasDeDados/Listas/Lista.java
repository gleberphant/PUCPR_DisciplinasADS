package Dominio.MinhasEstruturasDeDados.Listas;

import java.util.Iterator;

// wrapper da lista encadeada para simplificar a interface
public class Lista<T> implements ILista<T> {

    protected final ListaEncadeada<T> lista;
    protected int contagem;

    public Lista() {
        lista = new ListaEncadeada<>();
    }

    public int Inserir(T dado) {
        if (dado == null)
            return -1;
        lista.InserirFim(dado);
        return contagem++;
    }

    // retira proximo item da fila
    public T Retirar() {
        T dado = Topo();
        Remover(0);
        contagem--;
        return dado;
    }

    // retira último item da fila
    public T Ultimo() {
        return lista.GetUltimo();
    }

    // visualiza proximo item sem remover
    public T Topo() {
        return lista.GetPrimeiro();
    }

    //
    public T Busca(int i) {
        return lista.Get(i);
    }
    // remove item por indice
    public void Remover(int indice) {
        lista.Remover(indice);
    }

    // remove proximo item
    public void Remover(T chave) {
        int posicao = 0;
        for (var item : lista) {
            if (item.equals(chave)) {
                lista.Remover(posicao);
                break;
            }
            posicao++;
        }
        return;
    }

    public int Tamanho() {
        return lista.Tamanho();
    }

    public int Contagem() {
        return contagem;
    }

    public boolean EstaVazia() {

        if (lista.Tamanho() < 1)
            return true;
        else
            return false;
    }

    public String toString() {
        return lista.toString();
    }

    // percorre a fila sem remover
    @Override
    public Iterator<T> iterator() {
        // a iteração segue normal pq estou inserindo no fim da lista
        return lista.iterator();
    }
}
