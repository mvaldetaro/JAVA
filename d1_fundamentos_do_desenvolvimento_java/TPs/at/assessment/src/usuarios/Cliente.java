package usuarios;

import ConexaoBD.ConexaoMySQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Cliente {
    protected String nome;
    protected String email;
    protected String cpf;
    
    public Cliente(String nome, String email, String cpf){
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public void dadosCliente() {
        System.out.println(getNome());
        System.out.println(getEmail());
        System.out.println(getCpf());
    }
    
    public static void consultarCliente() throws SQLException {
        String input;
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o código do CLIENTE que deseja consultar:");
        input = scanner.nextLine();
        int in = Integer.parseInt(input);
        
        String query = "SELECT * FROM bd_tv.usuario WHERE idUsuario = " + in + ";";
        PreparedStatement pesquisa = ConexaoMySQL.getConexaoMySQL().prepareStatement(query);
        ResultSet rs = pesquisa.executeQuery();

        while(rs.next()){
            
            if(rs.getInt("idTitular") == 0) {
                Cliente c = new Titular(rs.getString("nome"), rs.getString("email"), rs.getString("cpf"), rs.getInt("idUsuario"));
                c.dadosCliente();
            } else {
                Cliente c = new Dependente(rs.getString("nome"), rs.getString("email"), rs.getString("cpf"), rs.getInt("idUsuario"), rs.getInt("idTitular"));
                c.dadosCliente();
            }
     
        }
    }
    
}
