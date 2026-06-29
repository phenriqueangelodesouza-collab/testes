import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        // VARIÁVEIS GERAIS
        int opc;
        int personagem;
        int vilao;
        Jogador jogador;
        Inimigo inimigo;
        ArrayList<Item> itens = new ArrayList<>();
        Inventario inventario = new Inventario(itens);
        //variáveis para inserção de dados do objeto
        String nome;
        int hp;
        int hpNow;
        int pMan;
        int mpMax;
        int atak;
        int def;
        // BIBLIOTECAS
        Scanner input = new Scanner(System.in);
        Random rad = new Random();

        //ESCOLHA DO PERSONAGEM
        System.out.println("""
                ------- ESCOLHA SEU PERSONAGEM -------
                1 - Guerreiro
                2 - Mago
                3 - Descricao dos personagens
                ---------------------------------------""");
        personagem = input.nextInt();


        //CONSTRUINDO MEUS PERSONAGENS - aplicando a regra do kevin jun pai escoteiro
        do{
        switch (personagem){

            case 1:
                // INSERÇÃO DOS DADOS
                System.out.println("***DÊ VIDA AO GUERREIRO***");
                System.out.println("Digite o nome do seu Guerreiro: ");
                nome = input.next();

                System.out.printf("Digite o HP maximo de %s", nome);
                System.out.println();
                hp = input.nextInt();

                System.out.println("Digite seu HP de agora: ");
                hpNow = input.nextInt();

                System.out.println("Digite o limite do ponto de mana: ");
                mpMax = input.nextInt();

                System.out.println("Insira seus pontos de mana: ");
                pMan = input.nextInt();

                System.out.printf("Digite o dano de %s: ", nome);
                System.out.println();
                atak = input.nextInt();

                System.out.printf("Digite a defesa de %s: ", nome);
                System.out.println();
                def = input.nextInt();

                //MONTANDO A MOCHILA
                System.out.println("MONTANDO SUA MOCHILA");
                System.out.println("""
                            1 - Poção de Mana -> para usar o especial
                            2 - Poção de Cura -> para subir o HP
                            """);
                for (int i = 0; i < 5; i++) {
                    int esc = input.nextInt(); //pegar a poção
                    switch (esc){
                        case 1:
                            inventario.adicionar(new PocaoMana("Mana"));
                            break;
                        case 2:
                            inventario.adicionar(new PocaoCura("Cura"));
                            break;
                            default:
                                System.out.println("Essa poção não existe");
                                i--; // a repetição não pode valer

                    }
                }
                //INSTANCIA
                jogador = new Guerreiro(nome,hp, hpNow, pMan, atak, def, mpMax, inventario);
                System.out.println("++++SEU GUERREIRO FOI CRIADO++++");
                break;

            case 2:
                // INSERÇÃO DOS DADOS
                System.out.println("***DÊ VIDA AO MAGO***");
                System.out.println("Digite o nome do seu Mago: ");
                nome = input.next();

                System.out.printf("Digite o HP maximo de %s", nome);
                System.out.println();
                hp = input.nextInt();

                System.out.println("Digite seu HP de agora: ");
                hpNow = input.nextInt();

                System.out.println("Insira seus pontos de mana: ");
                pMan = input.nextInt();

                System.out.println("Digite o limite do ponto de mana: ");
                mpMax = input.nextInt();

                System.out.printf("Digite o dano de %s: ", nome);
                System.out.println();
                atak = input.nextInt();

                System.out.printf("Digite a defesa de %s: ", nome);
                System.out.println();
                def = input.nextInt();

                //MONTANDO OS ITENS
                System.out.println("MONTANDO SUA MOCHILA");
                for (int i = 0; i < 5; i++) {
                    System.out.println("""
                            1 - Poção de Mana -> para usar o especial
                            2 - Poção de Cura -> para subir o HP
                            """);
                    int esc = input.nextInt(); //pegar a poção
                    switch (esc){
                        case 1:
                            inventario.adicionar(new PocaoMana("Mana"));
                            break;
                        case 2:
                            inventario.adicionar(new PocaoCura("Cura"));
                            break;
                        default:
                            System.out.println("Essa poção não existe");
                            i--; // a repetição não pode valer
                    }
                }//INSTANCIA
                jogador = new Mago(nome,hp, hpNow, pMan, atak, def, mpMax, inventario);
                System.out.println("+++++ SEU MAGO FOI CRIADO +++++");
                break;

            case 3:
                System.out.println("""
                        ------------ DESCRIÇÃO ----------------
                        GUERREIRO -> Golpe Pesado: Causa 150%
                                     do dano de ATK físico. Não
                                     custa MP, mas o Guerreiro
                                     perde 5% do seu próprio
                                     HP atual por conta do
                                     esforço físico
                        ----------------------------------------
                        MAGO -> Bola de Fogo: Causa um
                                dano fixo alto que ignora a
                                DEF do inimigo. Custa 10
                                MP. Se não houver MP
                                suficiente, o ataque falha.
                        ----------------------------------------
                        """);
                return;

            default:
                System.out.println("Essa opção não existe");
                return;

            }
        }while (personagem!=1 && personagem != 2);

        //ESCOLHA DO INIMIGO
        do {
        System.out.println("""
                COM QUEM VOCÊ QUER LUTAR?
                1 - GLOBLIN
                2 - TROLL
                3 - DESCRIÇÃO
                """);
        vilao = input.nextInt();

        switch (vilao){

            case 1: //INSTANCIA
                inimigo = new Globlin("Globlin",100, 100, 30, 15, 30, 30, inventario);
                System.out.println("+++SEU INIMIGO FOI CRIADO muhahahha+++");
                System.out.println(inimigo.toString());
                break;

            case 2://INSTANCIA
                inimigo = new Troll("Troll", 200, 200, 100, 45, 70, 100, inventario);
                System.out.println("+++SEU INIMIGO FOI CRIADO muhahahha+++");
                System.out.println(inimigo.toString());
                break;

            case 3:
                System.out.println("""
                        --------------------- DESCRIÇÃO --------------------------------------------
                        GLOBLIN -> Tem status baixos. No turno dele, ele tem 100%
                                   de chance de usar o ataque básico.
                        ------------------------------------------------------------------------------
                        TROLL ->  Tem HP muito alto e DEF alta. No turno dele, se o HP dele
                                 estiver abaixo de 30%, ele usará uma habilidade de "Regeneração" para
                                 recuperar vida em vez de atacar
                        -------------------------------------------------------------------------------   
                      
                        """);
                return;

            default:
                System.out.println("Essa opção não existe");
                return;//eles não podem sair daqui com o objeto vazio

            }
        }while (vilao!=1 && vilao !=2);

        System.out.println("INICIANDO BATALHA muhahha");
        //SISTEMA DAS RODADAS
        do {
            System.out.println("""
                    --- COMANDOS ---
                    1 - Atacar
                    2 - Habilidade
                    3 - Usar item
                    4 - Fugir
                    ----------------
                    """);
            opc = input.nextInt();

            //APLICANDO OS MÉTODOS
            switch (opc){

                case 1:
                    jogador.atacar(inimigo);// vez do jogador
                    //vez do inimigo
                    if (inimigo.getHpNow()<(inimigo.getHpMax()*0.3) && inimigo.getNome().equals("Troll")){
                        inimigo.setHpNow(inimigo.getHpMax());
                    }else if(inimigo.getHpNow()>0){
                        inimigo.atacar(jogador);
                    }
                    break;

                case 2:
                    jogador.habilidade(inimigo);//vez do jogador
                    if (jogador.getHpNow()>0) {
                        inimigo.habilidade(jogador); // vez do inimigo
                    }
                    break;

                case 3:
                    //vez do personagem
                    jogador.getInventario().listarItens();
                    System.out.println("Escolha a poção: ");
                    int indice = input.nextInt();
                    System.out.println("Mana do "+ jogador.getNome());
                    jogador.usarItem(indice, jogador);

                    //vez do inimigo
                    int cont = 5;
                    if (inimigo.getHpNow()>0){
                        System.out.println("Mana do "+ inimigo.getNome());
                        inimigo.usarItem(rad.nextInt(0,cont),inimigo); // sem o count pode gerar o erro de posição inexistente
                        cont--;
                    }
                    break;

                case 4:
                    jogador.fugir();
                    System.out.println("ficou com medo muhahha");
                    break;

                default:
                    System.out.println("Habilidade não desbloqueada ainda");
                    return;
            }
        }while(opc!=4 && jogador.getHpNow()>0 && inimigo.getHpNow()>0);

        System.out.println("********* GAME OVER *********");
        //TIPO UM PLACAR SÓ PARA FINS AMOSTRAIS
        System.out.println(jogador.toString());
        System.out.println(inimigo.toString());
    }
}

