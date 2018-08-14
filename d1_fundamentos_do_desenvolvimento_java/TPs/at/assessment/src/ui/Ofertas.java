package ui;

import bussinesRules.Channel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Ofertas {
    
    public static void armazenaCanaisOfertas() throws FileNotFoundException, IOException, Exception{
        
        FileOutputStream arquivo = new FileOutputStream("..\\src\\assets\\canais.txt");
        
        try {
            ObjectOutputStream canaisOfertados = new ObjectOutputStream(arquivo);
            canaisOfertados.writeObject(Channel.canaisSerealizados());
            canaisOfertados.close();
        } catch(Exception erro) {
            System.out.println(erro);
        }       
    
    }
    
    public static ArrayList<String> recuperarCanaisOfertados() throws FileNotFoundException, IOException, ClassNotFoundException {
        
       FileInputStream canais = new FileInputStream("..\\build\\classes\\assets\\canais.txt");
       ObjectInputStream canaisOf = new ObjectInputStream(canais); 

       return (ArrayList<String>) canaisOf.readObject();
    }
    
    
    
    public static void gravarOfertas(){
        
        String str = "Oferta Canais Esporte R$39,90 - Promoção Exclusiva Combo Multi Flex Plus‎\nOferta Cinema Total  R$39,90 - Promoção Exclusiva Combo Hyper Screen X‎";
        Path source = Paths.get("..\\src\\assets\\ofertas.txt");
        byte[] texto = str.getBytes();
        try {
            Files.write(source, texto);
        } catch(Exception erro) {
            
        }      
    }
    
     public static void lerOfertas() {
        File arquivo = new File("..\\build\\classes\\assets\\ofertas.txt");
        FileInputStream ofertas = null;
        
        try {
            ofertas = new FileInputStream(arquivo);
            System.out.println("Tamanho " + ofertas.available() + " bytes\n");
            
            StringBuilder conteudo = new StringBuilder();
            int caracteres;
            
            while((caracteres = ofertas.read()) != -1) {    
                conteudo.append((char)caracteres);
            }
            
            String[] itens = conteudo.toString().split(";");
            
            System.out.println("Confira nossas ofertas de planos:");
            
            for(String item : itens){
                System.out.println("Oferta: " + item);
            }
            
        } catch(Exception e){
            
        }
    }
}
