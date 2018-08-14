package br.com.infnet.controller;

import br.com.infnet.controller.dao.LogDAO;
import br.com.infnet.controller.dao.UsuarioDAO;
import br.com.infnet.model.Registro;
import br.com.infnet.model.Usuario;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogController {
    
    @RequestMapping("/historico")
    public String index(Model model, HttpSession session) {
        String title = "Historico de Compras";
        model.addAttribute("title", title);
        LogDAO logs = new LogDAO();
        int user = (int) session.getAttribute("userId");
        try {
            model.addAttribute("logs", logs.listLogsUser(user));
        }catch(SQLException e){
            System.out.println(e);
        } 
        return "logs";
    }
    
    /*@RequestMapping("/sucesso")
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
    }*/
    
}
