import java.util.ArrayList;

public class Globlin extends Inimigo {
    //CONSTRUTOR
    public Globlin(String nome, int hpMax, int hpNow, int mp, int atak, int def, int mpMax, Inventario inventario) {
        super(nome,hpMax, hpNow, mp, atak, def, mpMax, inventario);
    }

    @Override
    public void atacar(Jogador enemy) {
        int dano = super.getAtak() - enemy.getDef();
        if (dano<1){
            dano = 1;
        }

        enemy.setHpNow(enemy.getHpNow() - dano);
        System.out.println(
                "-------------- ATAQUE do GLOBLIN --------------" + "\n"+
                "Dano aplicado: "+ dano+ "\n" +
                "Vida do "+ enemy.getNome() + " : "+ enemy.getHpNow() );

    }

    @Override
    public void habilidade(Jogador enemy) {
        int dano = super.getAtak(); //coloquei que ignora a defesa
        if (dano<1){
            dano = 1;
        }

        enemy.setHpNow(enemy.getHpNow() - dano);
        System.out.println(
                "-------------- ESPECIAL do GLOBLIN --------------" + "\n"+
                "Dano aplicado: "+ dano+ "\n" +
                "Vida do "+ enemy.getNome() + " : "+ enemy.getHpNow() );
    }

    @Override
    public void usarItem(int indice, Jogador jogador) {
        super.usarItem(indice, jogador);
    }
}
