package jokenpo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

class Jokenpo extends Jogador {
        public static void main (String args []) throws IOException{
		
		Scanner sc = new Scanner(System.in);
                Random aleatorio = new Random();               
		int v1,v2,gamemode,resultado;
                int sair;
                Jogador player = new Jogador();

                 
                menu();

                gamemode = sc.nextInt();
               
                switch(gamemode){
                    
                    case 1:
                            
                        do{
                            do{
                                menuJogo();
                            
                                System.out.println("\nSua jogada:");
                                v1 = sc.nextInt();
                                if(v1 != 1 && v1 != 2 && v1 != 3){
                                    System.out.println("\nJogada Invalida...");
                                }

                            }while(v1 != 1 && v1 != 2 && v1 != 3);

                            v2 = aleatorio.nextInt(3)+1;
                            resultado = jogo(v1,v2);
                            if(resultado == 1){
                                player.Empate();
                            }
                            if(resultado == 2){
                                player.Derrota();
                            }
                            if(resultado == 3){
                                player.Vitoria();
                            }
                            player.res();
                            menuSair();

                            sair= sc.nextInt();
                        }while(sair!=1);
                            break;

                    case 2:
                            System.out.println("1 - Criar sua sala");
                            System.out.println("2 - Entrar em uma sala");

                            gamemode = sc.nextInt();
                            
                            switch(gamemode){
                                case 1:
                                    try{
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
                                            player.Empate();
                                        }
                                        if(resultado == 2){
                                            player.Derrota();
                                        }
                                        if(resultado == 3){
                                            player.Vitoria();
                                        }
                                        
                                        player.res();                                            
                                        menuSair();
                                        
                                        sair = sc.nextInt();
                                        
                                    }while(sair!=1);

                                    server.close();
                                    
                                    break;

                                }catch(Exception e){
                                    System.out.println(e);
                                    break;
                                }

                                case 2:
                                    try{
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
                                            player.Empate();
                                        }
                                        if(resultado == 2){
                                            player.Derrota();
                                        }
                                        if(resultado == 3){
                                            player.Vitoria();
                                        }
                                        player.res();
                                        menuSair();
                                        
                                        sair = sc.nextInt();

                                    }while(sair!=1);
                                 
                                    conexao.close();
            
                                        }catch(Exception e){
                                            System.out.println(e);
                                            break;
                                        }
        }
                                        
     sc.close();
                                    
                                    
            }
        }        
	}
