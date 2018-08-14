package bussinesRules;

import ConexaoBD.ConexaoMySQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Channel {
    
    private String nome;
    private int numero;
    private int codigo;
    private String categoria;
    
    public Channel() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public static void listarCanais() throws Exception {
        String query = "SELECT * FROM canal";
        PreparedStatement pesquisa = ConexaoMySQL.getConexaoMySQL().prepareStatement(query);
        ResultSet rs = pesquisa.executeQuery();

        System.out.println("======================================================");
        System.out.println("LISTA DE CANAIS");
        System.out.println("======================================================");
        while(rs.next()){
            Channel c = new Channel();
            c.setNome(rs.getString("nome"));
            c.setNumero(rs.getInt("numero"));
            
            System.out.println("Código: " + rs.getString("idCanal") + "\nCanal: " + c.getNome() + " | [" + c.getNumero() +"]");
            System.out.println("------------------------------------------------------");
        } 
    }
    
    public static void consultarCanal() throws Exception {
        
        String input;
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o código do CANAL que deseja consultar:");
        input = scanner.nextLine();
        int in = Integer.parseInt(input);
        
        String query = "SELECT * FROM bd_tv.canal WHERE idCanal = " + in + ";";
        PreparedStatement pesquisa = ConexaoMySQL.getConexaoMySQL().prepareStatement(query);
        ResultSet rs = pesquisa.executeQuery();

        System.out.println("======================================================");
        System.out.println("INFORMAÇÕES DO CANAL");
        System.out.println("======================================================");
        while(rs.next()){
            Channel c = new Channel();
            c.setNome(rs.getString("nome"));
            c.setNumero(rs.getInt("numero"));
            
            System.out.println("Nome: " + c.getNome() + "\nNúmero: [" + c.getNumero() +"]");
            System.out.println("------------------------------------------------------");
        } 
    }
    
    public static void inserirCanal() throws Exception {
        
        String input;
        Scanner scanner = new Scanner(System.in);
        Channel c = new Channel();
        
        System.out.print("Digite o NOME do novo canal:");
        input = scanner.nextLine();
        c.setNome(input);
        
        System.out.print("Digite o NÚMERO do novo canal:");
        input = scanner.nextLine();
        int in = Integer.parseInt(input);
        c.setNumero(in);
        
        String query = "INSERT INTO bd_tv.canal(nome, numero) values('" + c.getNome() + "'," + c.getNumero() +");";
        PreparedStatement inserir = ConexaoMySQL.getConexaoMySQL().prepareStatement(query);
        inserir.executeUpdate();

        System.out.println("Novo canal CADASTRADO com sucesso!");
        
    }
    
    public static void atualizarCanal() throws Exception {
        
        String input;
        Scanner scanner = new Scanner(System.in);
        Channel c = new Channel();
        
        System.out.print("Digite o CÓDIGO do canal:");
        input = scanner.nextLine();
        int id = Integer.parseInt(input);
        
        System.out.print("Digite o NOME do novo canal:");
        input = scanner.nextLine();
        c.setNome(input);
        
        System.out.print("Digite o NÚMERO do novo canal:");
        input = scanner.nextLine();
        int in = Integer.parseInt(input);
        c.setNumero(in);
        
        String query = "UPDATE bd_tv.canal SET nome = '" + c.getNome() + "', numero = " + c.getNumero() + " WHERE idCanal = " + id + ";";
        
        PreparedStatement inserir = ConexaoMySQL.getConexaoMySQL().prepareStatement(query);
        inserir.executeUpdate();

        System.out.println("Canal ATUALIZADO com sucesso!");
        
    }
    
    public static void excluirCanal() throws Exception {
        
        String input;
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o CÓDIGO do canal:");
        input = scanner.nextLine();
        int id = Integer.parseInt(input);
        
        String query = "DELETE FROM bd_tv.canal WHERE idCanal = " + id + ";";
        
        PreparedStatement inserir = ConexaoMySQL.getConexaoMySQL().prepareStatement(query);
        inserir.executeUpdate();

        System.out.println("Canal REMOVIDO com sucesso!");
        
    }
    
    public static List canais() throws Exception {
        String query = "SELECT * FROM canal";
        PreparedStatement pesquisa = ConexaoMySQL.getConexaoMySQL().prepareStatement(query);
        ResultSet rs = pesquisa.executeQuery();
        
        List<Channel> canais = new ArrayList();
        
        while(rs.next()){
            Channel c = new Channel();
            c.setCodigo(Integer.parseInt(rs.getString("idCanal")));
            c.setNome(rs.getString("nome"));
            canais.add(c);
        }
        
        return canais;
    }
    
    public static ArrayList<String> canaisSerealizados() throws Exception {
        String query = "SELECT nome FROM canal";
        PreparedStatement pesquisa = ConexaoMySQL.getConexaoMySQL().prepareStatement(query);
        ResultSet rs = pesquisa.executeQuery();
        
        ArrayList<String> canais = new ArrayList();
        
        while(rs.next()){
            canais.add(rs.getString("nome"));
        }
        
        return canais;
    }
    
    public Channel getCanal(int codigo) throws Exception {
        
        String query = "select canal.idCanal, canal.nome, canal.numero, categoria.nome from canal inner join canal_categoria inner join categoria on canal.idCanal = Canal_idCanall and idCategoria = Categoria_idCategoria where idCanal = " + codigo + ";";
        PreparedStatement pesquisa = ConexaoMySQL.getConexaoMySQL().prepareStatement(query);
        ResultSet rs = pesquisa.executeQuery();

        Channel c = new Channel();
        rs.next();
        c.setCodigo(Integer.parseInt(rs.getString("canal.idCanal")));
        c.setNome(rs.getString("canal.nome"));
        c.setNumero(rs.getInt("canal.numero"));
        c.setCategoria(rs.getString("categoria.nome"));
        
        return c;
    }
    
    public static List canaisCategoria(int codigo) throws Exception {
        
        String query = "select canal.idCanal, canal.nome from categoria inner join canal_categoria inner join canal on idCategoria = Categoria_idCategoria and Canal_idCanall = idCanal where idCategoria = " + codigo +";";
        PreparedStatement pesquisa = ConexaoMySQL.getConexaoMySQL().prepareStatement(query);
        ResultSet rs = pesquisa.executeQuery();

        List<Channel> canaisCategoria = new ArrayList();
        
        
        while(rs.next()){
            Channel cs = new Channel();
            cs.setCodigo(Integer.parseInt(rs.getString("canal.idCanal")));
            cs.setNome(rs.getString("canal.nome"));
            canaisCategoria.add(cs);
        }
        
        return canaisCategoria;
    }
    
}
