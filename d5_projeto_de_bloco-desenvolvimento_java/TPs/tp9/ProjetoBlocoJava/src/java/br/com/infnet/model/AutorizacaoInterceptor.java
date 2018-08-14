package br.com.infnet.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizacaoInterceptor extends HandlerInterceptorAdapter {
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) throws Exception {
        
        if(request.getRequestURI().endsWith("sala") && null == request.getSession().getAttribute("userId")) { // se for a tela de login e usuario estiver autenticado
           response.sendRedirect("login");
           return false;
        } else if(request.getRequestURI().endsWith("sala") && null != request.getSession().getAttribute("userId")) { // se for a tela de login e usuario não estiver autenticado
           return true;
        } else {
            return true;
        }
    }
    
}