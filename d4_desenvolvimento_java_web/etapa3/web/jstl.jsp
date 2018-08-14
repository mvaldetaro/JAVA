<%-- 
    Document   : jstl
    Created on : 02/11/2016, 21:44:04
    Author     : Magno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iteração com JSTL</title>
    </head>
    <body>
        <c:forEach var="i" begin="1" end="10" step="1">
            <c:out value="${i}" />
            <br>
        </c:forEach>
    </body>
</html>
