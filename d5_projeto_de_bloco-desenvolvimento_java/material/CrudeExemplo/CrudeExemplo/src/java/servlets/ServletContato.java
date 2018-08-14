/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Contato;
import modelo.ContatoFacade;


/**
 *
 * @author md20
 */
@WebServlet(name = "ServletContato", urlPatterns = {"/ServletContato"})
public class ServletContato extends HttpServlet {

    @EJB
    private ContatoFacade cf;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter(); 
                      
            Contato c=new Contato();
            c.setEmail(request.getParameter("email"));
            c.setNome(request.getParameter("name"));
            c.setTel(request.getParameter("phone"));
            c.setMensagem(request.getParameter("message"));
            
            String comando=request.getParameter("comando");
            switch(comando)
            { 
                case "cadastrar":cf.create(c);break;
                case "remover" :cf.remove(c);break;
                case "alterar" :cf.edit(c);break;
                case "consultar": 
                     Contato cbusca=cf.find(c.getEmail());
                     out.println("{\"email\":\""+ cbusca.getEmail()+"\",\"name\":\""+cbusca.getNome()+"\",\"phone\":\""+cbusca.getTel()+"\",\"message\":\""+cbusca.getMensagem()+"\"}");
                       
            }
                           //cf.create(c) salva no banco
                          //cf.remove(c) exclui
                          //cf.find(c)   consulta
                          //cf.edit(c)   altera
            
        }
  

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
