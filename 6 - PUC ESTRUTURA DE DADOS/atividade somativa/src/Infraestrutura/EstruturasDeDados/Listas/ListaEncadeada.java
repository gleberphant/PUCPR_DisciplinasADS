package Infraestrutura.EstruturasDeDados.Listas;

class NoLista<T> {
    public T dado;
    public NoLista<T> proximo;

    NoLista(T dado) {
        this.dado = dado;

    }
}

public class ListaEncadeada<T> implements IListas<T> {

    private NoLista<T> primeiroNo;
    private NoLista<T> noAtual;
    private int tamanho;

    public ListaEncadeada() {
        this.primeiroNo = null;
        this.noAtual = this.primeiroNo;
        this.tamanho = 0;
    }

    public boolean Inserir(T dado) {
        this.InserirFim(dado);
        tamanho++;
        return true;

    }

    public boolean InserirInicio(T dado) {
        NoLista<T> novo = new NoLista<>(dado);

        if (this.primeiroNo == null) {
            this.primeiroNo = novo;
            return true;
        }

        novo.proximo = this.primeiroNo;
        this.primeiroNo = novo;

        this.noAtual = this.primeiroNo;

        return true;

    }

    // inserir no meio da lista
    public boolean InserirMeio(T dado) {

        NoLista<T> novo = new NoLista<>(dado);

        if (this.noAtual == null)
            this.noAtual = novo;
        else {
            novo.proximo = this.noAtual.proximo;
            this.noAtual.proximo = novo;
        }

        return true;
    }

    // inserir no final da lista
    public boolean InserirFim(T dado) {
        NoLista<T> novo = new NoLista<>(dado);

        if (this.primeiroNo == null) {
            this.primeiroNo = novo;
            return true;
        }

        System.out.println("Inserindo item " + dado.toString());
        this.noAtual = GetUltimoNo();

        if (this.noAtual != null)
            this.noAtual.proximo = novo;

        return true;
    }

    public NoLista<T> GetPrimeiroNo() {

        return this.primeiroNo;

    }

    public NoLista<T> GetProximoNo() {

        if (this.noAtual == null || this.noAtual.proximo == null)
            return null;
        else
            this.noAtual = this.noAtual.proximo;

        return this.noAtual;

    }

    public NoLista<T> BuscarNo(int i) {

        if (this.primeiroNo == null) {
            return null;
        }

        NoLista<T> ponteiro = this.primeiroNo;
        int count = 0;

        while (count < i && ponteiro != null) {
            ponteiro = ponteiro.proximo;
            count++;
        }

        return ponteiro;

    }

    public NoLista<T> GetUltimoNo() {

        if (this.primeiroNo == null) {
            return null;
        }

        NoLista<T> ponteiro = this.primeiroNo;

        while (ponteiro.proximo != null) {
            ponteiro = ponteiro.proximo;
        }

        return ponteiro;

    }

    public boolean MoverPonteiro() {

        if (this.noAtual == null || this.noAtual.proximo == null)
            return false;
        else
            this.noAtual = this.noAtual.proximo;

        return true;

    }

    public boolean ReiniciarPonteiro() {
        this.noAtual = this.primeiroNo;
        return true;

    }

    public T GetPrimeiroDado() {
        if (this.primeiroNo == null)
            return null;
        else
            return this.primeiroNo.dado;
    }

    public T GetDadoAtual() {
        if (this.noAtual == null)
            return null;
        else
            return this.noAtual.dado;
    }


    public T GetUltimoDado() {
        NoLista<T> ultimo = GetUltimoNo();

        return ultimo.dado;
    }

    public void Set(int i, T dado) {

        NoLista<T> busca = BuscarNo(i);

        if (busca != null)
            busca.dado = dado;

    }

    public T Get(int i) {
        NoLista<T> busca = BuscarNo(i);

        if (busca == null)
            return null;
        else
            return busca.dado;
    }

    public int Tamanho() {
        return tamanho;
    }

    public void RemoverNo(int indice) {
        tamanho--;
        if (indice == 0) {
            this.primeiroNo = this.primeiroNo.proximo;

            return;
        }

        NoLista<T> anterior = BuscarNo(indice - 1);

        if (anterior == null || anterior.proximo == null)
            return;
        else
            anterior.proximo = anterior.proximo.proximo;

    }

    public String toString() {
        return "LISTA ENCADEADA";
    }

}
