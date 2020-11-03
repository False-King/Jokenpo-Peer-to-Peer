package jokenpo;

public class Jogador {
    int vit = 0;
    int der = 0;
    int emp = 0;
    
    public int Vitoria(){
        return vit++;
    }
    public int Derrota(){
        return der++;
    }
    public int Empate(){
        return emp++;
    }

    public static void menu(){
        System.out.println("Qual o modo de jogo que o senhor deseja:");
        System.out.println("\n1 - Player vs CPU");
        System.out.println("2 - Player vs Player");
    }

    public static void menuJogo(){
        System.out.println("Escolha entre 1, 2 e 3 , sendo : ");
    System.out.println("\nPedra = 1 ");
    System.out.println("Papel = 2  ");
    System.out.println("Tesoura = 3");
    }
    
    public static int jogo(int v1,int v2){
    switch (v1){
        case 1:
            System.out.println("Você escolheu pedra");

            switch (v2){

                case 1:
                    System.out.println("O oponente escolheu Pedra");
                    System.out.println("\nEmpate");
                    return 1;
                case 2:
                    System.out.println("O oponente escolheu Papel");
                    System.out.println("\nO oponente ganhou");
                    return 2;
                case 3:
                    System.out.println("O oponente escolheu Tesoura");
                    System.out.println("\nVocê ganhou");
                    return 3;
                default: 
                    System.out.println ("Opção invalida do oponente");
                    return 0;
            } 
        case 2:

            System.out.println("Você escolheu Papel");

            switch(v2) {
                case 1: 
                    System.out.println("O oponente escolheu Pedra");
                    System.out.println("\nVocê ganhou");
                    return 3;
                case 2:
                    System.out.println("O oponente escolheu Papel");
                    System.out.println("\nEmpatou");
                    return 1;
                case 3:
                    System.out.println("O oponente escolheu Tesoura");
                    System.out.println("\nO oponente ganhou");
                    return 2;
                default: 
                        System.out.println ("Opção invalida do oponente");
                        return 0;
            } 
        case 3:
                        System.out.println("Você escolheu Tesoura");
            switch(v2) {
                    case 1:
                        System.out.println("O oponente escolheu Pedra");
                        System.out.println("\nO oponente ganhou");
                        return 2;
                    case 2:
                        System.out.println("O oponente escolheu Papel");
                        System.out.println("\nVocê ganhou");
                        return 3;
                    case 3:
                        System.out.println("O oponente escolheu Tesoura");
                        System.out.println("\nEmpate");
                        return 1;
                    default: 
                        System.out.println ("Opção invalida do oponente");
                                                     return 0;
            }
        default: 
            System.out.println ("Opção invalida");
                            return 0;
}}
    public static void menuSair(){

    System.out.println("\nDigite 1 para sair...");
    }
    public void res(){
        System.out.println("Vitórias: " + vit + "\nDerrotas: "+ der + "\nEmpates: "+ emp);
    }
}
