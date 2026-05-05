package EstruturasNaoLineares;

import java.util.ArrayList;

import MinhasInterfaces.InterfaceGrafo;
import Nos.NoGrafo;
import Nos.Aresta;

public class GrafoLista implements InterfaceGrafo {

    ArrayList<NoGrafo> ListaNos;
    ArrayList<Aresta> ListaArestas;

    public GrafoLista() {
        ListaNos = new ArrayList<>();
        ListaArestas = new ArrayList<>();
    }

    public void InserirNo(int valor) {
        for (int i = 0; i < ListaNos.size(); i++) {
            if (ListaNos.get(i).data == valor)
                return;
        }

        ListaNos.add(new NoGrafo(valor));
    }

    public void InserirConexao(int valor1, int valor2) {
        NoGrafo no1 = null, no2 = null;
        int[] valores = { valor1, valor2 };

        // se ambos nos forem iguais retorna
        if (valor1 == valor2)
            return;

        // verifica se os dois nos existem
        for (int i = 0; i < ListaNos.size(); i++) {
            if (ListaNos.get(i).data == valor1) {
                no1 = ListaNos.get(i);
            }

            if (ListaNos.get(i).data == valor2) {
                no2 = ListaNos.get(i);
            }

            if (no1 != null && no2 != null)
                break;
        }

        if (no1 == null || no2 == null)
            return;

        // procura se a aresta  existe , 
        for (int i = 0; i < ListaArestas.size(); i++) {
            
            Aresta temp = ListaArestas.get(i);

            // se encontrar a areas entao aumenta o peso e retorna
            if (temp.No1 == no1 && temp.No2 == no2) {
                temp.Peso++;
                return;
            }
        }

        // se não encontrar a areas cria a aresta
        ListaArestas.add(new Aresta(no1, no2));

        return;
    }


    public String toString(){

        StringBuilder mensagem = new StringBuilder();

            mensagem.append("Nós {");

            for (int i = 0; i < ListaNos.size(); i++) {
            mensagem.append(" " + ListaNos.get(i).data);
            if (i < ListaNos.size() - 1)
                mensagem.append(",");
        }

        mensagem.append(" }\n");
        mensagem.append("Vértices \n");

        for (int i = 0; i < ListaArestas.size(); i++) {
            Aresta temp = ListaArestas.get(i);
            mensagem.append("   (" + temp.No1.data + " -- " + temp.No2.data + ")" + " Peso:" + temp.Peso+"\n");

        }

        return mensagem.toString();
    }
    public void Imprimir() {
        System.out.print(this.toString());
        
    }
}
