package bussinesRules;

import ConexaoBD.ConexaoMySQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Plano {
    private int codigo;
    private String titulo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }       
    
    public static void consultarCanaisPlano() throws SQLException{
        String input;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Planos:");
        System.out.println("[1]Megaboga Plus ++\n[2]Mediocre +-\n[3]Xepa --");

        System.out.print("Digite o código do PLANO que deseja consultar:");
        input = scanner.nextLine();
        int in = Integer.parseInt(input);
        
        String query = "select * from plano inner join plano_canal inner join canal on Plano_idPlano = idPlano and Canal_idCanal = idCanal where idPlano = " + in + ";";
        PreparedStatement pesquisa = ConexaoMySQL.getConexaoMySQL().prepareStatement(query);
        ResultSet rs = pesquisa.executeQuery();
        
        Plano p = new Plano();
        rs.next();
        p.setTitulo(rs.getString("titulo"));
        System.out.println("======================================================");
        System.out.println("CANAIS DO PLANO " + p.getTitulo().toUpperCase());
        System.out.println("======================================================");
        
        
        while(rs.next()){
            Channel c = new Channel();
            p.setTitulo(rs.getString("titulo"));
            c.setNome(rs.getString("nome"));
            c.setNumero(rs.getInt("numero"));
            System.out.println("Nome: " + c.getNome() + "\nNúmero: [" + c.getNumero() +"]");
            System.out.println("------------------------------------------------------");
        }  
    }  
}
