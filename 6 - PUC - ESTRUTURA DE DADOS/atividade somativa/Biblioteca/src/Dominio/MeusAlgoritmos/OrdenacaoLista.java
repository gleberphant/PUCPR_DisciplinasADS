package Dominio.MeusAlgoritmos;

import java.util.ArrayList;

import Dominio.MinhasEstruturasDeDados.Listas.*;

public class OrdenacaoLista<T extends Comparable<T>> {

    public ILista<T> MergeSort(ILista<T> lista) {
        if (lista.Tamanho() > 1) {
            ArrayList<T> array = ConverteListaParaArray(lista);
            array = mergeSortRecursivo(array);
            return ConverteArrayParaLista(array);
        } else
            return lista;

    }

    private ArrayList<T> mergeSortRecursivo(ArrayList<T> array) {
        int tamanho = array.size();
        // caso base

        if (tamanho <= 1)
            return array;

        int meio = tamanho / 2;

        // Divide o array no meio
        ArrayList<T> arrayEsquerda = new ArrayList<T>(array.subList(0, meio));
        ArrayList<T> arrayDireita = new ArrayList<T>(array.subList(meio, tamanho));

        // Chamada Recursiva para cada lado
        arrayEsquerda = mergeSortRecursivo(arrayEsquerda);
        arrayDireita = mergeSortRecursivo(arrayDireita);

        // Comparar e junta cada lado em um novo array ordenado
        var arrayResultado = new ArrayList<T>(tamanho);
        int tamanhoEsquerda = arrayEsquerda.size(), tamanhoDireita = arrayDireita.size();
        int i = 0, j = 0;

        while (i < tamanhoEsquerda && j < tamanhoDireita) {
            T itemEsquerdo = arrayEsquerda.get(i);
            T itemDireito = arrayDireita.get(j);

            if (itemEsquerdo.compareTo(itemDireito) <= 0) {
                arrayResultado.add(itemEsquerdo);
                i++;
            } else {
                arrayResultado.add(itemDireito);
                j++;
            }
        }

        // Adiciona os elementos restantes, se houver
        while (i < tamanhoEsquerda) {
            arrayResultado.add(arrayEsquerda.get(i));
            i++;
        }
        while (j < tamanhoDireita) {
            arrayResultado.add(arrayDireita.get(j));
            j++;
        }

        return arrayResultado;

    }

    public ILista<T> QuickSort(ILista<T> lista) {
        if (lista.Tamanho() > 1) {
            ArrayList<T> array = ConverteListaParaArray(lista);

            quickSortRecursivo(array, 0, array.size() - 1);

            return ConverteArrayParaLista(array);
        } else
            return lista;
    }

    private void quickSortRecursivo(ArrayList<T> array, int inicio, int fim) {
        if (inicio < fim) {
            // --- Início do Bloco de Particionamento ---
            T pivo = array.get(fim);
            int i = (inicio - 1);

            for (int j = inicio; j < fim; j++) {
                if (array.get(j).compareTo(pivo) <= 0) {
                    i++;
                    // Swap direto no array original
                    T temp = array.get(i);
                    array.set(i, array.get(j));
                    array.set(j, temp);
                }
            }

            // Posiciona o pivô no local correto
            int indicePivo = i + 1;
            T tempPivo = array.get(indicePivo);
            array.set(indicePivo, array.get(fim));
            array.set(fim, tempPivo);
            // --- Fim do Bloco de Particionamento ---

            // Chamadas recursivas usando o índice calculado
            quickSortRecursivo(array, inicio, indicePivo - 1);
            quickSortRecursivo(array, indicePivo + 1, fim);
        }
    }

    public ILista<T> BubbleSort(ILista<T> lista) {

        ArrayList<T> array = ConverteListaParaArray(lista);

        if(array == null) return lista;

        int desordenados = array.size();
        boolean ordenado = false;

        while (!ordenado) {
            ordenado = true;
            for (int i = 0; i < desordenados - 1; i++) {

                T atual = array.get(i);
                T proximo = array.get(i + 1);

                if (atual.compareTo(proximo) > 0) {

                    array.set(i, proximo);
                    array.set(i + 1, atual);

                    ordenado = false;
                }
            }
            desordenados--;
        }
        lista = ConverteArrayParaLista(array);

        return lista;
    }

    public ILista<T> ConverteArrayParaLista(ArrayList<T> array) {
        if (array == null) {
            return null;
        }

        // precisa converter para array primeiro, pq senao o buuble sort fica o(n³)
        Lista<T> lista = new Lista<T>();

        for (int i = 0; i < array.size(); i++)
            lista.Inserir(array.get(i));

        return lista;
    }

    public ArrayList<T> ConverteListaParaArray(ILista<T> lista) {
        int tamanho = lista.Tamanho();
        if (lista == null || tamanho <= 1) {
            return null;
        }

        // precisa converter para array primeiro, pq senao o buuble sort fica o(n³)
        ArrayList<T> array = new ArrayList<>(tamanho);

        for (int i = 0; i < tamanho; i++)
            array.add(lista.Busca(i));

        return array;
    }
}