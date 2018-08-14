package br.com.infnet.controllers;

import br.com.infnet.dao.UsuarioDAO;
import br.com.infnet.model.Usuario;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class initController {
    
    @Autowired
    private UsuarioDAO usuarioDao;
    
    @RequestMapping("/")
    public String index(Model model) {
        String title = "AT - Java Web";
        model.addAttribute("title", title);
        return "index";
    }
    
    @RequestMapping("/cadastro")
    public String cadastro(Model model) {
        String title = "Cadastro";
        model.addAttribute("title", title);
        return "cadastro";
    }
    
    @RequestMapping(value="/sucesso", method = RequestMethod.POST)
    public String sucesso(Model model, @RequestParam("email") String email, @RequestParam("nome") String nome, @RequestParam("senha") String senha) throws SQLException {
        Usuario usuario = new  Usuario();

            usuario.setNome(nome);
            usuario.setEmail(email);   
            usuario.setSenha(senha);
            
            usuarioDao.addUsuario(usuario);
            
            model.addAttribute("nome", usuario.getNome());
            model.addAttribute("email", usuario.getEmail());
            
            System.out.println(nome);
            System.out.println(email);
            System.out.println(senha);  

        return "sucesso";
    }
    
}
