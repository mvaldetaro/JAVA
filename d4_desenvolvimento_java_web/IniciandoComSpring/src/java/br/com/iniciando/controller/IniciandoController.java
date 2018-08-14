package br.com.iniciando.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IniciandoController {
    
    @RequestMapping("/")
    public String login(){
        return "login";
    }
    
    @RequestMapping("/olaMundo")
    public String iniciando(){
        return "index";
    }
    
    @RequestMapping("/cadastro")
    public String cadastro(){
        return "cadastro";
    }
    
}
