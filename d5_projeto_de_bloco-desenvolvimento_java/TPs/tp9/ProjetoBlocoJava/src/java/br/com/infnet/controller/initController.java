package br.com.infnet.controller;

import br.com.infnet.controller.dao.UsuarioDAO;
import br.com.infnet.model.Usuario;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class initController {
    
    @RequestMapping("/")
    public String index(Model model, HttpSession session) {
        String title = "In.gresso";
        model.addAttribute("title", title);
        session.setAttribute("url", "index");
        return "index";
    }
    
    /*@RequestMapping("/login")
    public String login(Model model) {
        String title = "Login";
        model.addAttribute("title", title);
        return "login";
    }*/
    
    @RequestMapping("/cadastro")
    public String cadastro(Model model) {
        String title = "Cadastro";
        model.addAttribute("title", title);
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
    
}
