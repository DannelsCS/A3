package item;

import Array.Inventario;

public class Item {
    Inventario inventario = new Inventario();
    private int id = 2;
    private String nome;
    private int durabilidade;
    private int quantidade;
    private String raridade;
    private float peso;
    private static int contador = 0;

    public Item(String nome, int durabilidade, int quantidade, String raridade, float peso) {
        this.nome = nome;
        this.durabilidade = durabilidade;
        this.quantidade = quantidade;
        this.raridade = raridade;
        this.peso = peso;
        id = contador++;
    }

    public Item() {
        id = contador++;
    }

    public Item(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDurabilidade() {
        return durabilidade;
    }

    public void setDurabilidade(int durabilidade) {
        this.durabilidade = durabilidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getRaridade() {
        return raridade;
    }

    public void setRaridade(String raridade) {
        this.raridade = raridade;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Item.contador = contador;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Durabilidade: " + durabilidade + ", Quantidade: " + quantidade +
                ", Peso: " + peso + ", Raridade: " + raridade;
    }
    // Método para atualizar um item pelo ID
    public boolean atualizarItem() {
        int index = inventario.pesquisar(id);
        if (index != -1) {
            Item item = inventario.getLista()[index];
            item.setNome(nome);
            item.setDurabilidade(durabilidade);
            item.setQuantidade(quantidade);
            item.setPeso(peso);
            item.setRaridade(raridade);
            return true;
        }
        return false;
    }
}
