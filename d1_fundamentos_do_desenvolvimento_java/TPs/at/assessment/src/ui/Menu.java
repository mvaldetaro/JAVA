package ui;

import bussinesRules.Categoria;
import appExceptions.MenuSelectException;
import bussinesRules.Plano;
import bussinesRules.Programa;
import java.util.Scanner;
import usuarios.Cliente;

public class Menu {
    
private static String opcao;
private static String input;
    
     public static void showMenu() throws Exception{
        
	do {
            Scanner scanner = new Scanner(System.in);
		System.out.println(
                    "\nSelecione uma da opções do menu abaixo, digitando um valor de 1 a 5:\n"
                    + "\n"
                    + "[1] Consultar dados de cliente.\n"
                    + "[2] Consultar canais no plano.\n"
                    + "[3] Consultar programas de um canal\n"
                    + "[4] Adquirir canal.\n"
                    + "[5] CRUD CANAIS\n"        
                    + "[6] Sair.\n"
                    );
                    
                    try {
                        input = scanner.nextLine();
                        int in = Integer.parseInt(input);
                        if(in <= 0 || in > 6){
                            throw new MenuSelectException("Este item de menu não existe.");
                        } else {
                            opcao = input;
                            switch(opcao){
                                case "1":
                                    Cliente.consultarCliente();
                                break;
                                case "2":
                                    Plano.consultarCanaisPlano();
                                break;
                                case "3":
                                    Programa.consultarProgramas();
                                break;
                                case "4":
                                    Categoria.menuCategorias();
                                break;
                                case "5":
                                    MenuCrudCanais.showMenu();
                                break;
                                case "6":
                                    Menu.sair();
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
        System.out.println("Sistema encerrado.");
	opcao = null;
	return opcao;
    }
    
    
}
