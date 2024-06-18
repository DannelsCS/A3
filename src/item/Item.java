package item;

public class Item {
    private int id;
    private String nome;
    private int durabilidade;
    private int quantidade;
    private String raridade;
    private float peso;

    public Item() {
        // Construtor padrão
    }

    public Item(String nome, int durabilidade, int quantidade, String raridade, float peso) {
        this.nome = nome;
        this.durabilidade = durabilidade;
        this.quantidade = quantidade;
        this.raridade = raridade;
        this.peso = peso;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Item:" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", durabilidade=" + durabilidade +
                ", quantidade=" + quantidade +
                ", raridade='" + raridade + '\'' +
                ", peso=" + peso;
    }
}
