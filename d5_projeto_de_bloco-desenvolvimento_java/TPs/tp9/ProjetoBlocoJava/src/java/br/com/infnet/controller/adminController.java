
package br.com.infnet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class adminController {
    @RequestMapping("/admin/evento")
    public String cadastroEvento(Model model) {
        String title = "Cadastro Evento";
        model.addAttribute("title", title);
        return "admin/evento";
    }
    
    @RequestMapping("/admin/login")
    public String adminLogin(Model model) {
        String title = "Admin Login";
        model.addAttribute("title", title);
        return "admin/login";
    }
}
