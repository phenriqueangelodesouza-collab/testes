import java.util.ArrayList;

public class Inventario {
    //ATRIBUTOS
    private ArrayList<Item> itens = new ArrayList<>();
    //CONSTRUTOR
    public Inventario(ArrayList<Item> itens) {
        this.itens = itens;
    }

    //EXCEÇÃO DO INVENTÁRIO
    public void adicionar(Item item){
        if(itens.size() >= 5){//pego o tamanho "size" para validar o erro
            throw new IllegalStateException("Inventário cheio ");// indica que esse metodo foi chamado inapropriadamente
        }
        itens.add(item);
    }
    // usa a funcionalidade de acordo com a poção e o jogaodr
    public void usarItem(int indice, Jogador jogador){
        Item item = itens.get(indice); //pgo o item na posição passada
        item.usar(jogador); // passo o caba para aplicar no caba certo
        itens.remove(indice); //quando uso removo
    }
    // lista os itens da lista
    public void listarItens(){
        System.out.println("-------- ITENS ---------");
        for (int i = 0; i < this.itens.size(); i++) {
            System.out.println(i + " - "+ this.itens.get(i).getNome());
        }
    }
    //GETs
    public ArrayList<Item> getItens() {
        return itens;
    }


}
