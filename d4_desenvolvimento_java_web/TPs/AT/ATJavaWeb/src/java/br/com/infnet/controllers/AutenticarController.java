package br.com.infnet.controllers;

import br.com.infnet.dao.UsuarioDAO;
import br.com.infnet.model.Usuario;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AutenticarController {
    
    @Autowired
    private UsuarioDAO usuarioDao;
    
    @RequestMapping("/login")
    public String login(Model model) {
        String title = "Login";
        model.addAttribute("title", title);
        return "login";
    }
    
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public void autenticarLogin(@RequestParam String email, @RequestParam String senha, Model model, HttpSession session){
        
        //UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = new Usuario();
        
   
            usuario = usuarioDao.findUsuario(email); 
            // verifica se email existe ou se é válido
            if (email.equals(usuario.getEmail())) {
                // Usuario cadastrado
                if(senha.equals(usuario.getSenha())) { 
                   session.setAttribute("userId", usuario.getId());
                   session.setAttribute("userNome", usuario.getNome());
                   session.setAttribute("userEmail", usuario.getEmail());

                } else {
                    model.addAttribute("msg", "Senha incorreta. Tente novamente.");
                }    
            } else {
                model.addAttribute("msg", "O email "+ email +" é inválido ou não existe.");
            }

    }
    
    @RequestMapping("/encerrarsessao")
    public String encerrarsessao(HttpSession session) {
        session.removeAttribute("userId");
        session.removeAttribute("userNome");
        session.removeAttribute("userEmail");
        
        return "login";
    }
}
