<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Clientes Cadastrados</title>
    </head>
    <body>
        <h2>Lista de Clientes Cadastrados</h2>
        
        <c:if test="${not empty clientes}">
            <table>
                <tr>
                    <td>Nome</td>
                    <td>CPF</td>
                    <td>Telefone</td>
                    <td>Endereço</td>
                    <td>RG</td>
                    <td>Data de Nascimento</td>
                </tr>
                
                <c:forEach>
                    <tr>
                        <td>${listValue.nome}</td>
                        <td>${listValue.cpf}</td>
                        <td>${listValue.telefone}</td>
                        <td>${listValue.endereco}</td>
                        <td>${listValue.rg}</td>
                        <td><fmt:formatDate pattern="dd/MM/yyyy" value="${listValue.dataNascimento}" /></td>
                    </tr>
                </c:forEach>
                
            </table>
            
        </c:if>
        
        <a href="/cliente/cliente">Cadastro</a>
    </body>
</html>
