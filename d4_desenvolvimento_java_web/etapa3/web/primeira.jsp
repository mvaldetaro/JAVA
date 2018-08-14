<%-- 
    Document   : primeira
    Created on : 02/11/2016, 21:28:38
    Author     : Magno
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <div>
            <% String msg = "Primeira página JSP"; %>
            <% out.println(msg); %>
            <%= new SimpleDateFormat("dd/MM/yyyy").format(new Date()) %>
        </div>
        
        <p>Expression Language</p>
        <p> o valor é ${10+20}</p>
    </body>
</html>
