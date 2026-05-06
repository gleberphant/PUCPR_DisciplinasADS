package Testes;

import java.util.HashMap;
import java.util.Map;

import Dominio.MinhasEstruturasDeDados.Listas.Fila;
import Dominio.MinhasEstruturasDeDados.Listas.ILista;
import Dominio.MinhasEstruturasDeDados.Listas.Lista;
import Dominio.MinhasEstruturasDeDados.Listas.Pilha;

public class TestadorListas<T> {

    public static void main(String[] args) {
        TestadorListas<Integer> testador = new TestadorListas<>();
        testador.Executar();
    }

    @SuppressWarnings("unchecked")
    public void Executar() {

        Map<String, ILista<Integer>> listas = new HashMap<>();

        listas.put("FILA - FIFO", new Fila<>());
        listas.put("PILHA - LIFO", new Pilha<>());
        listas.put("LISTA", new Lista<>());

        System.out.println("\n" + "-".repeat(21) + " Iniciando Testes " + "-".repeat(31));

        for (var item : listas.entrySet()) {

            ILista<T> lista = (ILista<T>) item.getValue();
            var rotulo = item.getKey();

            System.out.printf("\n" + "-".repeat(21) + " Testar %-15s " + "-".repeat(25), rotulo);
            System.out.print("\n--- Mockando itens  : ");
            lista = MockarLista(lista);
            ImprimirLista(lista);

            System.out.println("-".repeat(70));
        }

    }

    public void ImprimirLista(ILista<T> lista) {
        System.out.print("\n--- Lista.toString : " + lista.toString() + " ");

        int totalItens = lista.Tamanho();
        System.out.print("\n--- Retirando " + totalItens + " itens da lista:  ");

        // Requer que sua ILista/Lista implemente Iterable<T>

        for (int i = 0; i < totalItens; i++) {
            System.out.print("{" + lista.Retirar() + "} ");
        }
        System.out.println(" ");

    }

    // Para mockar dados numéricos
    public ILista<T> MockarLista(ILista<T> lista) {
        int numItems = 5 + (int) (Math.random() * 20);
        return MockarLista(lista, numItems);
    }

    @SuppressWarnings("unchecked")
    public static <T> ILista<T> MockarLista(ILista<T> lista, int numItens) {

        for (int i = 0; i < numItens; i++) {
            // Gera o valor e converte para T
            Integer valor = (int) (Math.random() * 100);
            lista.Inserir((T) valor);
            System.out.print(valor + " ");
        }
        System.out.print(" > " + numItens + " itens gerados.");
        return lista;
    }
}