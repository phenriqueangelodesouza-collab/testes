public class PocaoMana extends Item{
    //CONSTRUTOR
    public PocaoMana(String nome) {
        super(nome);
    }
    //metodos
    @Override
    public void usar(Jogador jogador) { // usa a funcionalidade da mana
        if ((jogador.getMp()+20)>jogador.getMpMax()){
            jogador.setMp(jogador.getMpMax());
            System.out.println(" Mana recuperado");
            System.out.println("Mana: "+ jogador.getMp());

        }
        else {
            jogador.setMp(jogador.getMp() + 20); //todos que usam pm recebem 20
            System.out.println(" Mana recuperado");
            System.out.println("Mana: "+ jogador.getMp());

        }
    }
}


