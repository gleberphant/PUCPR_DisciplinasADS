package EstruturasLineares;

import MinhasInterfaces.InterfaceEstruturasLineares;
import Nos.NoLinear;

public class Fila implements InterfaceEstruturasLineares {

    NoLinear inicio;
    NoLinear atual;

    public Fila() {
        atual = inicio;
    }

    public String ToString(){
        return "FILA";
    }

    public boolean InserirNo(int value) {

        if (inicio == null) {
            inicio = new NoLinear(value);
            atual = inicio;
            return true;
        }

        NoLinear temp = inicio;

        while (temp != null && temp.GetNext() != null) {
            temp = temp.GetNext();
        }

        NoLinear newNode = new NoLinear(value);

        temp.SetNext(newNode);

        return true;
    }

    public NoLinear GetAtual() {
        return atual;
    }

    public NoLinear GetProximo() {
        if (atual == null)
            return null;
        else
            return atual.GetNext();
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
