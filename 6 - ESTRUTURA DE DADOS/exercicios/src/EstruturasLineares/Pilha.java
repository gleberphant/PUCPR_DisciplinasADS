package EstruturasLineares;

import MinhasInterfaces.InterfaceEstruturasLineares;
import Nos.NoLinear;

public class Pilha implements InterfaceEstruturasLineares {

    NoLinear inicio;
    NoLinear atual;

    public Pilha() {
        atual = inicio;
    }

    public String ToString(){
        return "PILHA";
    }

    public boolean InserirNo(int value) {

        NoLinear novoNo = new NoLinear(value);

        if (inicio == null) {
            inicio = novoNo;
            atual = inicio;
            return true;
        }

        novoNo.SetNext(inicio);
        inicio = novoNo;
        atual = inicio;

        return true;
    }

    public NoLinear GetAtual() {
        return atual;
    }

    public boolean MoverPonteiro() {
        if (this.atual == null)
            return false;
        else
            this.atual = this.atual.GetNext();
        return true;
    }

    public boolean ReiniciarPonteiro() {
        return false;
    }

    public NoLinear GetInicio() {
        return inicio;
    }
}
