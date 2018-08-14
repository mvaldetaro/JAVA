package br.com.controle;

import java.util.Scanner;

public class MainMenu {
    
    private static int posicao;
    private static String opcao;
    private static String input;
    
    public static void showMenu(){
        
	do {
            Scanner scanner = new Scanner(System.in);
		System.out.println(
                    "Selecione uma da opções do menu abaixo, digitando um valor de 1 a 4:\n"
                    + "\n"
                    + "[1] Cadastrar professor.\n"
                    + "[2] Cadastrar aluno.\n"
                    + "[3] Consultar situação de um docente/discente.\n"
                    + "[4] Sair.\n"
                    );
                    
                    try {
                        input = scanner.nextLine();
                        int in = Integer.parseInt(input);
                        if(in <= 0 || in > 4){
                            throw new MenuSelectException("Este item de menu não existe.");
                        } else {
                            opcao = input;
                            switch(opcao){
                                case "1":
                                    Professor.novoProfessor();
                                break;
                                case "2":
                                    Aluno.novoAluno();
                                break;
                                case "3":
                                    Cadastros.consultar();
                                break;
                                case "4":
                                    MainMenu.sair();
                                break;
                                default:
                                    System.out.println("Opção Inválida.");
                            }
                        }
                    } catch(MenuSelectException e){
                        System.err.println(e.getMessage());
                    } 
          
            } while(opcao != null);
    }
    
    public static String sair(){
	System.out.println("Saindo do sistema...");
	opcao = null;
	return opcao;
    }
    

    
}
