package ui;

import appExceptions.MenuSelectException;
import bussinesRules.Channel;
import java.util.Scanner;


public class MenuCrudCanais {
    private static String opcao;
    private static String input;
    
    public MenuCrudCanais() {
    }
    
    public static void showMenu() throws Exception{
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println(
                "\nSelecione uma da opções do menu abaixo:\n"
                + "\n"
                + "[1] Consultar informações de um canal.\n"
                + "[2] Cadastrar novo canal.\n"
                + "[3] Remover canal.\n"
                + "[4] Atualizar informações de um canal.\n"
                + "[5] Listar canais cadastrados.\n"
            );

            try {
                input = scanner.nextLine();
                int in = Integer.parseInt(input);
                if(in <= 0 || in > 5){
                    throw new MenuSelectException("Este item de menu não existe.");
                } else {
                    opcao = input;
                    switch(opcao){
                        case "1":
                            Channel.consultarCanal();
                        break;
                        case "2":
                            Channel.inserirCanal();
                        break;
                        case "3":
                            Channel.excluirCanal();
                        break;
                        case "4":
                            Channel.atualizarCanal();
                        break;
                        case "5":
                            Channel.listarCanais();
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
}
