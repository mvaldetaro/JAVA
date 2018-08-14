package br.com.infnet.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizacaoInterceptor extends HandlerInterceptorAdapter {
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) throws Exception {
        
        if(!request.getRequestURI().endsWith("login") && null != request.getSession().getAttribute("userId")) { // se não for a tela de login e usuario estiver autenticado
            return true; 
       } else if(request.getRequestURI().endsWith("login") && null != request.getSession().getAttribute("userId")) { // se for a tela de login e usuario estiver autenticado
           return true;
       } else if(request.getRequestURI().endsWith("login") && null == request.getSession().getAttribute("userId")) { // se for a tela de login e usuario não estiver autenticado
           return true;
       } else {
            response.sendRedirect("login");
            return false;
       }
    }
    
}
