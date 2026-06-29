public abstract class Item {
    //ATRIBUTOS
    private String nome;
    //CONSTRUTOR
    public Item(String nome) {
        this.nome = nome;
    }
    //GET
    public String getNome() {
        return nome;
    }
    public abstract void usar(Jogador jogador); // cada um usa diferente
}
