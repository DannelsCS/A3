package Array;

import item.Item;

public class Inventario {
    private Item[] lista = new Item[3];
    private static int contador = 1;

    public void adicionar(Item item) {
        if (contador - 1 == lista.length) {
            lista = listaMaior();
        }
        item.setId(contador);
        lista[contador - 1] = item;
        contador++;
    }

    private Item[] listaMaior() {
        Item[] novo = new Item[lista.length * 2];
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

    public Item pesquisarItem(int id) {
        int index = pesquisar(id);
        if (index != -1) {
            return lista[index];
        }
        return null;
    }

    public Item[] getLista() {
        Item[] result = new Item[contador - 1];
        System.arraycopy(lista, 0, result, 0, contador - 1);
        return result;
    }

    public void removerItem(int id) {
        int index = pesquisar(id);
        if (index != -1) {
            for (int j = index; j < contador - 2; j++) {
                lista[j] = lista[j + 1];
            }
            lista[--contador - 1] = null;
        }
    }

    public void atualizarItem(int id, String nome, int durabilidade, int quantidade, String raridade, float peso) {
        int index = pesquisar(id);
        if (index != -1) {
            Item item = lista[index];
            item.setNome(nome);
            item.setDurabilidade(durabilidade);
            item.setQuantidade(quantidade);
            item.setRaridade(raridade);
            item.setPeso(peso);
        }
    }

    public static int getContador() {
        return contador;
    }
}
