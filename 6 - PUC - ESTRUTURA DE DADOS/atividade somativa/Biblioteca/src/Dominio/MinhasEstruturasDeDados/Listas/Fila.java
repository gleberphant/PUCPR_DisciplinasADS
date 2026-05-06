package Dominio.MinhasEstruturasDeDados.Listas;

public class Fila<T> extends Lista<T> {

    public Fila() {
        super();
    }

    // LIFO - inserir no inicio da lista, para sempre retirar o ultimo que entrou
    @Override
    public int Inserir(T dado) {
        if (dado == null)
            return -1;
        lista.InserirFim(dado);
        return contagem++;
    }

}
