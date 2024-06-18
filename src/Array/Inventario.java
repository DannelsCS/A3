package Array;

import item.Item;

import java.util.Arrays;

public class Inventario {

    private Item[] lista = new Item[3];
    private static int contador = 1; // Iniciar IDs a partir de 1

    public void adicionar(Item item) {
        if (contador - 1 == lista.length) {
            lista = listaMaior();
        }
        item.setId(contador++);
        lista[contador - 2] = item; // Usar o índice apropriado no array
    }

    private Item[] listaMaior() {
        Item[] novo = new Item[lista.length * 2]; // Dobrar o tamanho do array
        System.arraycopy(lista, 0, novo, 0, lista.length);
        return novo;
    }

    public int pesquisar(int id) {
        for (int i = 0; i < contador - 1; i++) {
            if (id == lista[i].getId()) {
                return i;
            }
        }
        return -1;
    }

    public Item[] getLista2() {
        Item[] result = new Item[contador - 1];
        System.arraycopy(lista, 0, result, 0, contador - 1);
        return result;
    }

    public Item[] getLista() {
        Item[] result = new Item[contador - 1];
        System.arraycopy(lista, 0, result, 0, contador - 1);
        return result;
    }

    // Método para remover um item pelo ID
    public void removerItem(int id) {
        int index = pesquisar(id);
        if (index != -1) {
            for (int j = index; j < contador - 2; j++) {
                lista[j] = lista[j + 1];
            }
            lista[--contador - 1] = null;
        }
    }

    public static int getContador() {
        return contador;
    }
}
