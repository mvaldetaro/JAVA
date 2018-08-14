package br.com.infnet.controllers;

import br.com.infnet.dao.UsuarioDAO;
import br.com.infnet.model.Usuario;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class initController {
    
    @RequestMapping("/")
    public String index() {
        return "index";
    }
    
    @RequestMapping("/cadastro")
    public String cadastro() {
        return "cadastro";
    }
    
    @RequestMapping("/sucesso")
    public String sucesso(Model model, Usuario usuario ) {
        UsuarioDAO dao = new UsuarioDAO();
        try {
            dao.addUsuario(usuario);
            model.addAttribute("nome", usuario.getNome());
            model.addAttribute("email", usuario.getEmail());
        }catch(SQLException e){
            System.out.println(e);
        }
        return "sucesso";
    }
    
    @RequestMapping("/restrito")
    public String restrito() {
        return "restrito";
    }
    
}
