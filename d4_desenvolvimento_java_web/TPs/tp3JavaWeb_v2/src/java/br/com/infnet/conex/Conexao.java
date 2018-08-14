package br.com.infnet.conex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

public class Conexao {
    private Connection conn;
    
    private void conectar(){
        System.out.println("Conectando ao banco...");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/java_web", "root", "pwd3c8n2p4");
            System.out.println("Conectado");
        }catch(ClassNotFoundException e){
            System.out.println("Classe não encontrada");
            java.util.logging.Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, e);
        }catch(SQLException e){    
            System.out.println(e);
        }
    }

    public Connection getConexao(){
        conectar();
        return conn;
    }
}
