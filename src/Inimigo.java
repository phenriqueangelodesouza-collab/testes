public abstract class Inimigo extends Jogador{
    //CONSTRUTOR
    public Inimigo(String nome, int hpMax, int hpNow, int mp, int atak, int def, int mpMax, Inventario inventario) {
        super(nome,hpMax, hpNow, mp, atak, def, mpMax, inventario);
    }

    @Override
    public abstract void atacar(Jogador enemy);

    @Override
    public abstract void habilidade(Jogador enemy);

    @Override
    public void usarItem(int indice, Jogador jogador) {
        super.usarItem(indice, jogador);
    }

}
