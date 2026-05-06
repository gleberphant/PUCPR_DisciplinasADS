package Dominio.MinhasEstruturasDeDados.Listas;

public class Pilha<T> extends Lista<T> {

    public Pilha() {
        super();
    }

    // LIFO - inserir no inicio da lista, para sempre retirar o ultimo que entrou
    @Override
    public int Inserir(T dado) {
        lista.InserirInicio(dado);
        return contagem++;
    }

}
