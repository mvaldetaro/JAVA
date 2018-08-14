package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(name = "Formulario", urlPatterns = {"/formulario"})

public class Formulario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Cadastro Efetuado</title>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<link rel='stylesheet' href='style.css' type='text/css'/>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<header><h1>Cadastro Efetuado com sucesso!</h1></header>");
            out.println("<main>");
            out.println("<div class='row'>");
            out.println("<div class='col-100'><p><b>Nome:</b> " + nome + " </p></div>");
            out.println("</div>");
            out.println("<div class='row'>");
            out.println("<div class='col-100'><p><b>Email:</b> " + email + " </p></div>");
            out.println("</div>");
            out.println("</main>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
        
    }

}
