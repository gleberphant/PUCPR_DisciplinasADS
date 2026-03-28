package Nos;



public class NoArvore {

    int data;
    NoArvore nextEsquerdo;
    NoArvore nextDireito;

    public NoArvore(int value){
        data= value;
    }


    public int GetData() {
        return data;
    }


    public NoArvore GetDireito(){
        return nextDireito;
    }


    public NoArvore GetEsquerdo(){
        return nextEsquerdo;
    }


    public void SetDireito(NoArvore newNode){
        nextDireito = newNode;
    }


    public void SetEsquerdo(NoArvore newNode){
        nextEsquerdo = newNode;
    }

}