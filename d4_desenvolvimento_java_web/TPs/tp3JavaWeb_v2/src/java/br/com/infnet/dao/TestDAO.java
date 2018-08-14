
package br.com.infnet.dao;

import br.com.infnet.model.Usuario;
import java.sql.SQLException;


public class TestDAO {

    public static void main(String[] args) {
        Usuario usuario = new Usuario();
        UsuarioDAO dao = new UsuarioDAO();
        
        usuario.setNome("Fulano");
        usuario.setEmail("Fulano@mail.com");
        usuario.setSenha("123456");
        
        try {
            dao.addUsuario(usuario);
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
}
