package br.com.infnet.dao;

import br.com.infnet.conex.Conexao;
import br.com.infnet.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {
    public void addUsuario(Usuario usuario) throws SQLException {
        Conexao conn = new Conexao();
        String sql = "insert into usuario (nome, email, senha) values (?,?,?)";
        PreparedStatement ps = conn.getConexao().prepareStatement(sql);
        
        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getEmail());
        ps.setString(3, usuario.getSenha());
        
        ps.execute();
        
    }
}
