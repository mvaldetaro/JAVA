package controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;

@WebServlet("/cadastrarUsuario")
public class CadastrarUsuarioControle extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        Usuario usuario = new Usuario(nome, email);
        //Com o suaurio, persistir em banco, etc.
        RequestDispatcher rd = request.getRequestDispatcher("/cadastroSucesso.jsp");
        rd.forward(request, response);
    }
   

}
