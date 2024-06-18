package Array;

import exemplo.Paciente;
import item.Item;

import java.util.Arrays;

public class Inventario {


    private Item[] lista = new Item[3];
    private static int contador = 0;


    public void adicionar(Item item) {

        if (contador == lista.length) {
            lista = listaMaior();

        }
        lista[contador++] = item;
    }

    private Item[] listaMaior() {
        Item[] novo = new Item[lista.length * 2]; // Dobrar o tamanho do array
        System.arraycopy(lista, 0, novo, 0, lista.length);
        return novo;
    }


    public int pesquisar(int id) {
        for (int i = 0; i < contador; i++) {
            if (id == lista[i].getId()) {
                return i;
            }
        }
        return -1;
    }

    public Item[] getLista2() {
        Item[] result = new Item[contador];
        System.arraycopy(lista, 0, result, 0, contador);
        return result;
    }

    public Item[] getLista() {
        Item[] result = new Item[contador];
        System.arraycopy(lista, 0, result, 0, contador);
        return result;
    }

    // Método para remover um item pelo ID
    public void removerItem(int id) {
        int index = pesquisar(id);
        if (index != -1) {
            for (int j = index; j < contador - 1; j++) {
                lista[j] = lista[j + 1];
            }
            lista[--contador] = null;
        }



    }
}
