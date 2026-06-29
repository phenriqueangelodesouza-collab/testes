public class PocaoCura extends Item{
    //CONSTRUTOR
    public PocaoCura(String nome) {
        super(nome);
    }
    //POLI
    @Override
    public void usar(Jogador jogador) {
        if ((jogador.getHpNow()+30)> jogador.getHpMax())   {
            jogador.setHpNow(jogador.getHpMax()); //todos que usam pc recebem 30

            System.out.println("Vida: "+ jogador.getHpNow());
        }
        else {
            jogador.setHpNow(jogador.getHpNow()+20);

            System.out.println("Vida: "+ jogador.getHpNow());

        }
    }

}
