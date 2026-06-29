import java.util.ArrayList;

public class Mago extends Jogador{
    //CONSTRUTOR
    public Mago(String nome, int hpMax, int hpNow, int mp, int atak, int def, int mpMax, Inventario inventario) {
        super(nome,hpMax, hpNow, mp, atak, def, mpMax, inventario);
    }

    @Override
    public void atacar(Jogador enemy) {
        int dano = super.getAtak() - enemy.getDef();
        if (dano<1){
            dano = 1;
        }
        enemy.setHpNow(enemy.getHpNow() -dano);
        System.out.println(
                "-------------- ATAQUE do MAGO --------------" + "\n"+
                "Dano aplicado: "+ dano+ "\n" +
                "Vida do "+ enemy.getNome() + " : "+ enemy.getHpNow() );

    }

    @Override
    public void habilidade(Jogador enemy) {
        int dano = super.getAtak(); //MAGO SEMPRE IGNORA A DEFESA DO INIMIGO e PRECISA DE 10 DE MP
        if (dano<1 || super.getMp()<10){
            dano = 1;
        }

        enemy.setHpNow(enemy.getHpNow() - dano);
        super.setMp(super.getMp() - 10);
        System.out.println(
                "-------------- ESPECIAL do MAGO --------------" + "\n"+
                "Dano aplicado: "+ dano+ "\n" +
                "Vida do "+ enemy.getNome() + " : "+ enemy.getHpNow() );
    }

    @Override
    public void usarItem(int indice, Jogador jogador) {
        super.usarItem(indice, jogador);
    }
}
