<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Cliente</title>
    </head>

    <h2>Formulario de Caastro de Cliente</h2>

    <form:form method="POST" action="/cliente/addCliente">
        <table>
            <tr>
                <td><form:label path="nome">Nome:</form:label></td>
                <td><form:input path="nome" /></td>
            </tr>
            <tr>
                <td><form:label path="cpf">Cpf:</form:label></td>
                <td><form:input path="cpf" type="text" /></td>
            </tr>
            <tr>
                <td><form:label path="rg">RG:</form:label></td>
                <td><form:input path="rg" /></td>
            </tr>
            <tr>
                <td><form:label path="telefone">Telefone:</form:label></td>
                <td><form:input path="teledone" type="text" /></td>
            </tr>
            <tr>
                <td><form:label path="endereco">Endereço</form:label></td>
                <td><form:input path="endereco" type="text" /></td>
            </tr>
            <tr>
                <td><form:label path="dataNascimento">Data de Nascimento</form:label></td>
                <td><form:input path="dataNascimento" type="text" /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Enviar" />
                </td>
            </tr>
        </table>
    </form:form>
    <a href="/cliente/listaClientes">Lista</a>
</html>
