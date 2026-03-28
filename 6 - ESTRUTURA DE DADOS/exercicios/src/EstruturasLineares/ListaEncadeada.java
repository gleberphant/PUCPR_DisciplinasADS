package EstruturasLineares;

import MinhasInterfaces.InterfaceEstruturasLineares;
import Nos.NoLinear;

public class ListaEncadeada implements InterfaceEstruturasLineares {
    public NoLinear head;
    private NoLinear current;

    public ListaEncadeada() {
        this.current = this.head;
    }

    public String ToString() {
        return "LISTA ENCADEADA";
    }

    public boolean InserirNo(int value) {
        this.InserirInicio(value);
        return true;
    }

    // inserir no inicio da lista
    public void InserirInicio(int value) {

        NoLinear novoNo = new NoLinear(value);

        novoNo.SetNext(this.head);

        this.head = novoNo;

        this.current = this.head;

    }

    // inserir no meio da lista
    public void InserirMeio(int temp) {
        NoLinear novoNo = new NoLinear(temp);

        novoNo.SetNext(this.current.GetNext());
        this.current.SetNext(novoNo);
    }

    // inserir no final da lista
    public boolean InserirFim(int value) {

        NoLinear novoNo = new NoLinear(value);

        if (this.head == null) {
            this.head = novoNo;
            this.current = this.head;
            return true;
        }

        NoLinear temp = this.head;

        while (temp != null && temp.GetNext() != null) {
            temp = temp.GetNext();
        }

        temp.SetNext(novoNo);

        return true;
    }

    public boolean MoverPonteiro() {

        if (this.current == null)
            return false;

        this.current = this.current.GetNext();

        if (this.current == null)
            return false;

        return true;
    }

    public boolean ReiniciarPonteiro() {
        this.current = this.head;
        return true;

    }

    public NoLinear GetInicio() {
        return this.head;
    }

    public NoLinear GetAtual() {
        return this.current;
    }

}
