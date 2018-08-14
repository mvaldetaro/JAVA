package br.com.infnet.controller;

import br.com.infnet.controller.dao.EventosDAO;
import br.com.infnet.dao.UsuarioDAO;
import br.com.infnet.model.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class initController {
    
    @RequestMapping("/")
    public String index(Model model) {
        String title = "In.gresso";
        model.addAttribute("title", title);
        return "index";
    }
    
    @RequestMapping("/login")
    public String login(Model model) {
        String title = "Login";
        model.addAttribute("title", title);
        return "login";
    }
    
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
    
    @RequestMapping("/eventos")
    public String eventos(Model model) {
        String title = "Eventos";
        model.addAttribute("title", title);
        EventosDAO dao = new EventosDAO();
        try{
            model.addAttribute("lista", dao.listAll());
            model.addAttribute("tipos", dao.tiposEventos());
        }catch(Exception e){
            System.out.println(e);
        }
        return "eventos";
    }
    
    @RequestMapping("/eventos/cinema")
    public String cinema(@RequestParam("id") int idTipoEvento, Model model ) {
        String title = "Cinema";
        model.addAttribute("title", title);
        model.addAttribute("idTipoEvento", idTipoEvento);
        EventosDAO dao = new EventosDAO();
        
        try{
            model.addAttribute("tipos", dao.tiposEventos());
            model.addAttribute("eventos", dao.filtroEventos(idTipoEvento));
        }catch(Exception e){
            System.out.println(e);
        }   
        return "tipo_eventos";
    }
    
    
    @RequestMapping("/eventos/teatro")
    public String teatro(@RequestParam("id") int idTipoEvento, Model model) {
        String title = "Teatro";
        model.addAttribute("title", title);
        model.addAttribute("idTipoEvento", idTipoEvento);
        EventosDAO dao = new EventosDAO();  
        try{
            model.addAttribute("tipos", dao.tiposEventos());
            model.addAttribute("eventos", dao.filtroEventos(idTipoEvento));
        }catch(Exception e){
            System.out.println(e);
        }
        return "tipo_eventos";
    }
    
    @RequestMapping("/eventos/shows")
    public String show(@RequestParam("id") int idTipoEvento, Model model) {
        String title = "Shows";
        model.addAttribute("title", title);
        model.addAttribute("idTipoEvento", idTipoEvento);
        EventosDAO dao = new EventosDAO();  
        try{
            model.addAttribute("tipos", dao.tiposEventos());
            model.addAttribute("eventos", dao.filtroEventos(idTipoEvento));
        }catch(Exception e){
            System.out.println(e);
        }
        return "tipo_eventos";
    }
}
