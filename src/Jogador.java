import java.util.ArrayList;

public abstract class Jogador {
    //ATRIBUTOS
    private String nome;
    private int hpMax;
    private int hpNow;
    private int mp; // mp e o custo ds feiticos ou poderes
    private int atak;
    private int def;
    private int mpMax;
    private Inventario inventario;
    //CONSTRUTOR
    public Jogador(String nome,int hpMax, int hpNow, int mp, int atak, int def, int mpMax, Inventario inventario) {
        //VALIDAÇÕES
        if (hpNow>hpMax){
            hpNow = hpMax;
        }
        if (mp>mpMax){
            mp = mpMax;
        }
        this.nome = nome;
        this.hpMax = hpMax;
        this.hpNow = hpNow;
        this.mp = mp;
        this.atak = atak;
        this.def = def;
        this.mpMax = mpMax;
        this.inventario = inventario;
    }
    //MÉTODOS
    public abstract void atacar(Jogador enemy);// ataca o inimigo
    public abstract void habilidade(Jogador enemy);// metodo de ataque especial
    public void usarItem(int indice, Jogador jogador){ //  abre o inventario, a lista de suprimentos, mesma forma para  todos eu acho
        this.inventario.usarItem(indice, jogador);
    }
    public void fugir() {// encerra o combate, perde tudo, mas salva a vida
        setAtak(0);
        setMp(0);
        setNome("Fracassado");
        setDef(0);
        setMpMax(0);
    }

    public String toString(){
        return "---------------- JOGADOR ------------"+ "\n"+
                "Nome: "+ this.nome+"\n"+
                "HP: "+ this.hpNow+"\n"+
                "HP maximo: "+ this.hpMax+"\n"+
                "Pontos de Mana: "+ this.mp+"\n"+
                "Pontos maximos de Mana: "+ this.mpMax +"\n"+
                "Ataque: "+ this.atak+ "\n"+
                "Defesa: "+ this.def +"\n"+
                "-------------------------------------";
    }
    // GETs
    public int getHpMax() {
        return hpMax;
    }

    public int getHpNow() {
        return hpNow;
    }

    public int getMp() {
        return mp;
    }

    public int getAtak() {
        return atak;
    }

    public int getDef() {
        return def;
    }

    public int getMpMax() {
        return mpMax;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public String getNome() {
        return nome;
    }

    //SETs
    public void setHpNow(int hpNow) {
        this.hpNow = hpNow;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setAtak(int atak) {
        this.atak = atak;
    }

    public void setMpMax(int mpMax) {
        this.mpMax = mpMax;
    }

}
