package ConexaoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {
    public static String status = "Não Conectado";

    public ConexaoMySQL() {
    }
    
    public static java.sql.Connection getConexaoMySQL(){
        Connection connection = null;

        try{
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);

            String serverName = "localhost";
            String mydatabase = "bd_tv";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = "root"; 
            String password = "pwd3c8n2p4";
            
            connection = DriverManager.getConnection(url, username, password);
            
            if(connection != null){
                status = ("STATUS ---> CONECTADO AO BD COM SUCESSO!\n");
            } else {
                status = ("STATUS ---> NÃO FOI POSSIVEL CONECTAR\n");
            }
            
            return connection;
            
        } catch(ClassNotFoundException ex){
            System.out.println("O driver especificado não foi encontrado");
            return null;
        } catch(SQLException ex) {
            System.out.println("Não foi possivel conectar ao Banco de Dados");
            return null;
        }
    }
    
    public static String statusConnection(){
        return status;
    }
    
    public static boolean FecharConexao(){
        try {
            ConexaoMySQL.getConexaoMySQL().close();
            return true;
        } catch(SQLException ex){
            return false;
        }
    }
    
    public static java.sql.Connection ReiniciarConexao(){
        FecharConexao();
        return ConexaoMySQL.getConexaoMySQL();
    }
    
}
