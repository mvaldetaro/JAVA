package br.com.infnet.controller;

import br.com.infnet.controller.dao.AssentoDAO;
import br.com.infnet.controller.dao.EventosDAO;
import br.com.infnet.controller.dao.LogDAO;
import br.com.infnet.controller.dao.SalaDAO;
import br.com.infnet.controller.dao.SessoesDAO;
import br.com.infnet.model.Log;
import br.com.infnet.model.Sala;
import br.com.infnet.model.StatusAssento;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EventosController {

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
    
    @RequestMapping("/sessoes")
    public String sessoes(@RequestParam("id") int idEvento, Model model, HttpSession session) {
        String title = "Sessões";
        String bodycss = "sessoes";
        model.addAttribute("title", title);
        model.addAttribute("bodycss", bodycss);
        model.addAttribute("idEvento", idEvento);
        
        EventosDAO evento = new EventosDAO();  
        SessoesDAO dao = new SessoesDAO();
        
        try{
            model.addAttribute("evento", evento.getEvento(idEvento));
            model.addAttribute("sessoesEvento", dao.listarSessoesEvento(idEvento));
            System.out.println(dao.listarSessoesEvento(idEvento));
        }catch(SQLException e){
            System.out.println(e);
        }
        
        session.setAttribute("url", "sessoes");
        
        return "sessoes";
    }
    
    @RequestMapping("/sala")
    public String sala(@RequestParam("id") int idSala, @RequestParam("sessao") int idSessao, @RequestParam("evento") int idEvento, Model model) {
        String title = "Sala";
        String bodycss = "sala";
        
        model.addAttribute("title", title);
        model.addAttribute("bodycss", bodycss);
        model.addAttribute("idEvento", idEvento);
        model.addAttribute("idSessao", idSessao);
        model.addAttribute("idSala", idSala);
        
        EventosDAO evento = new EventosDAO();  
        SessoesDAO sessoes = new SessoesDAO();
        SalaDAO sala = new SalaDAO();
        LogDAO logs = new LogDAO();
        
        StatusAssento status = new StatusAssento();
        
        try{
            model.addAttribute("sala", sala.getSala(idSala));
            
            int tamanhoSala = sala.getSala(idSala).size();
            int qtdRow = (int) Math.ceil(tamanhoSala/5);
            
            String[] fila = {"", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
            
            model.addAttribute("fila", fila);
            model.addAttribute("tamanhoSala", tamanhoSala);
            model.addAttribute("qtdRow", qtdRow);
            
            model.addAttribute("status", status.status(sala.getSala(idSala), logs.listLogsAssentosSala(idSala)));
            
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return "sala";
    }
      
    @RequestMapping("/comprar")
    public String comprar(@RequestParam("id") int idAssento, @RequestParam("sala") int idSala, @RequestParam("sessao") int idSessao, @RequestParam("evento") int idEvento, Model model) {
        String title = "Confirmar Compra";
        model.addAttribute("title", title);
        
        EventosDAO evento = new EventosDAO();  
        SessoesDAO sessoes = new SessoesDAO();
        SalaDAO sala = new SalaDAO();
        AssentoDAO assento =  new AssentoDAO();
        
        try{            
            model.addAttribute("sala", sala.getSalaAssento(idAssento));
            model.addAttribute("sessao", sessoes.getSessao(idSessao));
            model.addAttribute("evento", evento.getEvento(idEvento));
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return "comprar";
    }
    
    @RequestMapping("/confirmar")
    public String comprar(Model model, Log registro, @RequestParam("sessao") int idSessao, @RequestParam("sala") int idSala, @RequestParam("user") int idUsuario, @RequestParam("assento") int idAssento) {
        String title = "Confirmado";
        model.addAttribute("title", title);
        
        LogDAO log = new LogDAO();
  
        registro.setFk_idsessao(idSessao);
        registro.setFk_idusuario(idUsuario);
        registro.setFk_idassento(idAssento);
        registro.setFk_idsala(idSala);
        registro.setStatus("Comprado");
        
        try{            
            log.addRegistro(registro);
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return "confirmar";
    }
    
}
