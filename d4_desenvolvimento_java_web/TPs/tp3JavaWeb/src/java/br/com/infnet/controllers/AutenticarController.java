package br.com.infnet.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;

@Controller
public class AutenticarController {
    public String realizarLogin(HttpSession session){
        //session.setAttribute("usuario", usuario);
        return "index";
    }
}
