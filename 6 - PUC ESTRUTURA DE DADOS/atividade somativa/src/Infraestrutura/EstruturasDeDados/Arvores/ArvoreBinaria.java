package Infraestrutura.EstruturasDeDados.Arvores;
class NoArvore {

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



public class ArvoreBinaria {
    NoArvore head;
    NoArvore current;

    public boolean AddNode(NoArvore newNode) {
        // tenta balancear arvore para verificar onde deve adicionar o novo no

        // primeiro verifica se o cabecalho é nullo
        if (head == null) {
            head = newNode;
            current = head;
            return true;
        }

        // começa no inicio da arvore
        current = head;

        while (true) {

            // é menor menor que valor atual ? então vai adicionar no lado esquerdo
            if (newNode.GetData() < current.GetData()) {

                // esquerdo esta vazio? então adiciona nele
                if (current.GetEsquerdo() == null) {
                    current.SetEsquerdo(newNode);
                    break;
                }


                // senao. se é maior que o esquerdo então move para esquerda. recomeça o loop
                MoveEsquerda();
                continue;

            }

            else {
                // se direito estiver vazio, ocupa o direito do atual
                if (current.GetDireito() == null) {
                    current.SetDireito(newNode);
                    break;
                }

                // senao. se é menor que o direito então move para direita e recomeça o loop
                MoveDireita();
                continue;

            }

        }

        current = head;
        return true;
    }

    public void Reset() {
        current = head;
    }

    public NoArvore GetCurrent() {
        return current;
    }

    public boolean MoveEsquerda() {
        current = current.GetEsquerdo();
        return true;
    }

    public boolean MoveDireita() {
        current = current.GetDireito();
        return true;
    }

}