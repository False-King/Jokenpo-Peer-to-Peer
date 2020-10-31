package jokenpo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

class Jokenpo {
        public static void main (String args []) throws IOException{
		
		Scanner sc = new Scanner(System.in);
                Random aleatorio = new Random();               
		int v1,v2,gamemode=0,resultado;
                int sair,vit=0,der=0,emp=0;
                

                 
                System.out.println("Qual o modo de jogo que o senhor deseja:");
                System.out.println("1 - Player vs CPU");
                System.out.println("2 - Player vs Player");
                gamemode = sc.nextInt();
                   System.out.println(gamemode);
               
                switch(gamemode){
                    
                    case 1:
                            
                        do{
                            menuJogo();
                            System.out.println("Sua jogada:");
                            v1 = sc.nextInt();
                            System.out.println("Jogada do outro: ");
                            v2 = aleatorio.nextInt(3)+1;
                            resultado = jogo(v1,v2);
                            if(resultado == 1){
                                emp++;
                            }
                            if(resultado == 2){
                                der++;
                            }
                            if(resultado == 3){
                                vit++;
                            }
                            System.out.println("Vitórias: " + vit + "\nDerrotas: "+ der + "\nEmpates: "+ emp);
                            System.out.println("deseja sair?");
                            System.out.println("1-sim 2-não");
                            sair= sc.nextInt();
                        }while(sair!=1);
                            break;

                    case 2:
                            System.out.println("1 - Criar sua sala");
                            System.out.println("2 - Entrar em uma sala");

                            gamemode = sc.nextInt();
                            
                            switch(gamemode){
                                case 1:
                                    ServerSocket server = new ServerSocket(2323);
                                    System.out.println("Seu IP é:"+ InetAddress.getLocalHost().getHostAddress());
                                    System.out.println("Aguardando outro jogador.");
                                    
                                    Socket cliente = server.accept();
                                    
                                    DataOutputStream saida = new DataOutputStream(cliente.getOutputStream());
                                    DataInputStream entrada = new DataInputStream(cliente.getInputStream());
                                    
                                    System.out.println("Jogador Conectado");
                                    
                                    int joserver, joclient;

                                    do{

                                        System.out.println("faça sua jogada");
                                        do{
                                            menuJogo();
                                           joserver = sc.nextInt();
                                           
                                        if(joserver != 1 && joserver != 2 && joserver != 3){

                                                   System.out.println("Jogada Invalida... \nTente Novamente");

                                               }
                                    }while(joserver != 1 && joserver != 2 && joserver != 3);
                                        saida.flush();
                                        saida.write(joserver);
                                        
                                        
                                        System.out.println("Esperando jogada do oponente...");
                                        joclient = (int)entrada.read();
                                        resultado = jogo(joserver,joclient);
                                        if(resultado == 1){
                                            emp++;
                                        }
                                        if(resultado == 2){
                                            der++;
                                        }
                                        if(resultado == 3){
                                            vit++;
                                        }
                                        
                                        System.out.println("Vitórias: " + vit + "\nDerrotas: "+ der + "\nEmpates: "+ emp);                                             
                                        System.out.println("deseja sair?");
                                        System.out.println("1-sim 2-não");
                                        
                                        sair = sc.nextInt();
                                        
                                    }while(sair!=1);
                                    server.close();
                                    break;
                            
                                case 2:

                                    int jogada1,jogada2;
                                    String IP;
                                    System.out.println("Digite o IP da sala:");
                                    IP = sc.next();
                                    
                                    Socket conexao = new Socket(IP,2323);
                                    DataOutputStream out = new DataOutputStream(conexao.getOutputStream());
                                    DataInputStream in = new DataInputStream(conexao.getInputStream());
                                    System.out.println("Partida encontrada");
                                    do{
                                    
                                    System.out.println("Digite sua jogada...");
                                    
                                    do{
                                    menuJogo();
                                    jogada1 = sc.nextInt();   
                                    if(jogada1 != 1 && jogada1 != 2 && jogada1 != 3){
                                               
                                               System.out.println("Jogada Invalida... \nTente Novamente");
                                               
                                           }
                                    }while(jogada1 != 1 && jogada1 != 2 && jogada1 != 3);
                                    
                                    out.write(jogada1);
                                    jogada2 = (int)in.read();
                                    
                                    resultado = jogo(jogada1,jogada2);
                                    if(resultado == 1){
                                        emp++;
                                    }
                                    if(resultado == 2){
                                        der++;
                                    }
                                    if(resultado == 3){
                                        vit++;
                                    }
                                    System.out.println("Vitórias: " + vit + "\nDerrotas: "+ der + "\nEmpates: "+ emp);
                                    
                                    System.out.println("deseja sair?");
                                    System.out.println("1-sim 2-não");
                                    
                                    sair = sc.nextInt();
                                    }while(sair!=1);
                                 
                                    conexao.close();
            
                                        }
     sc.close();
                                    
                                    
                                }
                                                                }
                       
		
		
        
        
        
        
        public static void menuJogo(){
        	System.out.println("Escolha entre 1, 2 e 3 , sendo : ");
		System.out.println("Pedra = 1 ");
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
						System.out.println("Empate");
                                                return 1;
					case 2:
                                                System.out.println("O oponente escolheu Papel");
						System.out.println("O Outro ganhou");
                                                return 2;
					case 3:
                                                System.out.println("O oponente escolheu Tesoura");
						System.out.println("Você ganhou");
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
						System.out.println("Você ganhou");
						return 3;
					case 2:
                                                System.out.println("O oponente escolheu Papel");
						System.out.println(" Empatou");
                                                return 1;
					case 3:
                                                System.out.println("O oponente escolheu Tesoura");
						System.out.println("O Outro ganhou");
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
							System.out.println("O Outro ganhou");
                                                        return 2;
						case 2:
                                                        System.out.println("O oponente escolheu Papel");
							System.out.println("Você ganhou");
                                                        return 3;
						case 3:
                                                        System.out.println("O oponente escolheu Tesoura");
							System.out.println("Empate");
                                                        return 1;
						default: 
							System.out.println ("Opção invalida do oponente");
                                                         return 0;
				}
			default: 
				System.out.println ("Opção invalida");
                                return 0;
}}
	}
