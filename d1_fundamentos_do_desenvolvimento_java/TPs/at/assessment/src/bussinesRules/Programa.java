package bussinesRules;

import ConexaoBD.ConexaoMySQL;
import appExceptions.MenuSelectException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Programa {
    private String titulo;
    private String descricao;
    private String clsssificacao;
    private Date horarioInicial;
    private Date horarioFinal;
    
    public Programa(){
    
    }

    public Programa(String titulo, String descricao, String clsssificacao, Date horarioInicial, Date horarioFinal) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.clsssificacao = clsssificacao;
        this.horarioInicial = horarioInicial;
        this.horarioFinal = horarioFinal;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getClsssificacao() {
        return clsssificacao;
    }

    public void setClsssificacao(String clsssificacao) {
        this.clsssificacao = clsssificacao;
    }

    public Date getHorarioInicial() {
        return horarioInicial;
    }

    public void setHorarioInicial(Date horarioInicial) {
        this.horarioInicial = horarioInicial;
    }

    public Date getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(Date horarioFinal) {
        this.horarioFinal = horarioFinal;
    }
    
    public static void consultarProgramas() throws Exception {
    
        showMenu();
    
    }
    
    public static void showMenu() throws Exception{
        
        Scanner scanner = new Scanner(System.in);
        String input = null;
        String opcao = input;
        List<Channel> canais = Channel.canais();
        
        do {
            System.out.println("\nSelecione um dos CANAIS abaixo:\n");
            
            for(Channel canal : canais){
                System.out.println("[" + canal.getCodigo() + "]" + " " + canal.getNome() );
            }
            
            input = scanner.nextLine();
            int codigo = Integer.parseInt(input);
            
            Channel canal = new Channel();
            canal = canal.getCanal(codigo);
            
            try {
                System.out.println("======================================================");
                System.out.println("PROGRAMAS DO CANAL " + canal.getNome().toUpperCase());
                System.out.println("Número: " + canal.getNumero() + " | " + "Categoria: " + canal.getCategoria());
                System.out.println("======================================================");
                
                List<Programa> programas = Programa.programas(codigo);
                
                
                for(Programa programa : programas){
                    System.out.println(programa.getTitulo());
                    System.out.println(programa.getDescricao());
                    System.out.println(programa.getClsssificacao());
                    System.out.println("-----------------------------------------");
                }
                
                
            } catch(MenuSelectException e){
                System.err.println(e.getMessage());
            } 

        } while(opcao != null);
    }
    
    
    public static List programas(int canal) throws Exception {
        String query = "select canal.idCanal, canal.nome, canal.numero, categoria.nome, programa.titulo, programa.descricao, programa.data, programa.classificacao from canal inner join canal_programa inner join programa inner join categoria inner join canal_categoria on canal_idCanal = idCanal and programa_idPrograma = idPrograma and idCanal_Categoria = idCanal and idCanal_Categoria = idCategoria  where idCanal =" + canal + ";";
        PreparedStatement pesquisa = ConexaoMySQL.getConexaoMySQL().prepareStatement(query);
        ResultSet rs = pesquisa.executeQuery();
        
        List<Programa> programas = new ArrayList();
        
        while(rs.next()){
            Programa p = new Programa();
            p.setTitulo(rs.getString("programa.titulo"));
            p.setDescricao(rs.getString("programa.descricao"));
            p.setClsssificacao(rs.getString("programa.classificacao"));
            
            programas.add(p);
        }
        
        return programas;
    }
    
}
