<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exibe Detalhes do Cliente</title>
    </head>
    <body>
        <h1>Detalhes do Cliente Cadastrado</h1>

        <table>
            <tr>
                <td>Nome:</td>
                <td>${nome}</td>
            </tr>
            <tr>
                <td>CPF:</td>
                <td>${cpf}</td>
            </tr>
            <tr>
                <td>RG:</td>
                <td>${rg}</td>
            </tr>
            <tr>
                <td>Telefone:</td>
                <td>${telefone}</td>
            </tr>
            <tr>
                <td>Endereco:</td>
                <td>${endereco}</td>
            </tr>
            <tr>
                <td>Data de Nascimento:</td>
                <td>${dataNascimento}</td>
            </tr>
        </table>   
        <a href="/cliente/cliente">Cadastro</a> <br>
        <a href="/cliente/listaClientes">Lista</a>
    </body>
</html>
