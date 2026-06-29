public class Troll extends Inimigo{
    //CONSTRUTOR
    public Troll(String nome,int hpMax, int hpNow, int mp, int atak, int def, int mpMax, Inventario inventario) {
        super(nome, hpMax, hpNow, mp, atak, def, mpMax, inventario);
    }
    //MÉTODOS
    public void regeneracao(){
        super.setHpNow(super.getHpMax());
    }

    @Override
    public void atacar(Jogador enemy) {
        int dano = super.getAtak() - enemy.getDef();
        if (dano<1){
            dano = 1;
        }

        enemy.setHpNow(enemy.getHpNow() -dano);
        System.out.println(
                "-------------- ATAQUE do TROLL --------------" + "\n"+
                "Dano aplicado: "+ dano+ "\n" +
                "Vida do "+ enemy.getNome() + " : "+ enemy.getHpNow() );

    }

    @Override
    public void habilidade(Jogador enemy) {
        if (super.getMp() == super.getMpMax() && super.getHpNow()<10){
            enemy.setHpNow(0); //coloquei que acaba com o inimigo
            System.out.println(
                    "-------------- ESPECIAL do TROLL --------------" + "\n"+
                    "Dano aplicado: infinito"+ "\n" +
                    "Vida do "+ enemy.getNome() + " : "+ enemy.getHpNow() );
        }
    }

    @Override
    public void usarItem(int indice, Jogador jogador) {
        super.usarItem(indice, jogador);
    }
}
