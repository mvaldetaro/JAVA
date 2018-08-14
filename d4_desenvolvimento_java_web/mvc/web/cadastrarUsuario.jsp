<%-- 
    Document   : cadastrarUsuario
    Created on : 03/11/2016, 07:40:50
    Author     : Magno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="cadastrarUsuario" method="post">
        <h1>Cadastrar Usuários</h1>
        <table>
        <tr>
           <td>Nome:</td>
            <td><input name="nome"></td>
         </tr>
         <tr>
           <td>E-mail:</td>
          <td><input name="email"></td>
        </tr>
        <tr>
          <td>
             <input type="submit" value="Salvar">
           </td>
        </tr>
       </table>
    </form>
    </body>
</html>
