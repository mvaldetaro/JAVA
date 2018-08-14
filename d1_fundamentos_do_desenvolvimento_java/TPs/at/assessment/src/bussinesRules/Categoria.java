package bussinesRules;

import appExceptions.MenuSelectException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class Categoria {
    private int codigo;
    private String nome;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public static void gravarCategorias(){
        File arquivo = new File("..\\assessment\\src\\assets\\categorias.txt");
        String[] categorias = {"Abertos", "Filmes", "Séries", "Esportes", "Infantis", "Cultura", "Notícias", "Variedades"};
        Formatter input = null;
        
        try { 
            input = new Formatter(arquivo);
            for (int i = 0; i < categorias.length; i++) {
               input.format("%d %s \n", i+1, categorias[i]); 
            }
            input.close();
        } catch(FileNotFoundException eb){
            System.err.println("Erro ao acessar arquivo");
        }        
    } 
    
    public static void menuCategorias() throws Exception{ 
        File arquivo = new File("..\\assessment\\build\\classes\\assets\\categorias.txt");
        Scanner output = null;
        String opcao = null;
        
        boolean read = arquivo.canRead();
        
        try{
            output = new Scanner(arquivo);
        } catch(FileNotFoundException e){
            System.err.println("Erro ao acessar arquivo");
        }
        
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Selecione uma das categorias no menu abaixo:\n");
            int l = 0;
            while(output.hasNext()) {
                Categoria c = new Categoria();
                c.setCodigo(output.nextInt());
                c.setNome(output.next());
                System.out.println("[" + c.getCodigo() + "]" + " " + c.getNome());
                l++; 
            }
            
            try {
                String scan = scanner.nextLine();
                int in = Integer.parseInt(scan);
                List<Channel> canais = Channel.canaisCategoria(in);
                
                System.out.println("\nSelecione um dos CANAIS abaixo:\n");
                
                for(Channel canal : canais){
                    System.out.println(canal.getCodigo() + " " +canal.getNome());
                    System.out.println("-----------------------------------------");
                }

                scan = scanner.nextLine();
                in = Integer.parseInt(scan);
                
                Channel canal = new Channel(); 
                canal = canal.getCanal(in);
                
                System.out.println("Canal " + canal.getNome() + " adquirido com sucesso!:\n");
                
            } catch(MenuSelectException e){
                System.err.println(e.getMessage());
            } 
        
        } while(opcao != null);
    }
}
