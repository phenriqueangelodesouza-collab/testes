public class Guerreiro extends Jogador{
    //CONSTRUTOR
    public Guerreiro(String nome, int hpMax, int hpNow, int mp, int atak, int def, int mpMax, Inventario inventario) {
        super(nome, hpMax, hpNow, mp, atak, def, mpMax, inventario);
    }
    //metodos
    @Override
    public void atacar(Jogador enemy) {
        int dano = super.getAtak() - enemy.getDef();
        if (dano<1){
            dano = 1;
        }
        enemy.setHpNow(enemy.getHpNow() -dano);
        System.out.println(
                "-------------- ATAQUE do GUERREIRO --------------" + "\n"+
                "Dano aplicado: "+ dano+ "\n" +
                "Vida do "+ enemy.getNome() + " : "+ enemy.getHpNow() );
    }

    @Override
    public void habilidade(Jogador enemy) {
        int dano = (int)(super.getAtak() * 1.5) - enemy.getDef(); //tive que converter para int o set não pode receber double, também pq eu tinha declarado hpnow como int
        if (dano<1){
            dano = 1;
        }
        enemy.setHpNow(enemy.getHpNow() - dano); //aplicando no inimiog
        super.setHpNow((int)(super.getHpNow() * 0.95)); //contabilizando no HP
        System.out.println(
                "-------------- ESPECIAL do GUERREIRO --------------" + "\n"+
                "Dano aplicado: "+ dano+ "\n" +
                "Vida do "+ enemy.getNome() + " : "+ enemy.getHpNow() );
    }

    @Override
    public void usarItem(int indice, Jogador jogador) {
        super.usarItem(indice, jogador);
    }
}
