<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="resources/css/bootstrap-reboot.min.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="resources/css/bootstrap-grid.min.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="resources/css/bootstrap.min.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="resources/css/style.css" />" rel="stylesheet" type="text/css"/>
        <title>Cadastro</title>
    </head>
    <body>
        

        <div class="container">
            <div class="col-xs-3"></div>
            <div class="col-xs-6">
            <h1>Cadastro</h1>
            <form>
                <div class="form-group row">
                    <label for="nome" class="col-xs-2 col-form-label">Nome</label>
                    <div class="col-xs-10">
                        <input class="form-control" type="text" id="nome" name="nome" required>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="endereco" class="col-xs-2 col-form-label">Endereço</label>
                    <div class="col-xs-10">
                        <input class="form-control" type="text" id="endereco" name="endereco" required>
                    </div>
                </div>    
                <div class="form-group row">
                    <label for="telefone" class="col-xs-2 col-form-label">Telefone</label>
                    <div class="col-xs-10">
                        <input class="form-control" type="tel" id="telefone" name="telefone" required>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="email" class="col-xs-2 col-form-label">Email</label>
                    <div class="col-xs-10">
                        <input class="form-control" type="email" id="email" name="email" required>
                    </div>
                </div>
                
                <div class="form-group row">
                    <div class="col-xs-12">
                        <input class="btn btn-primary" type="submit" id="submit" value="Cadastrar">
                    </div>
                </div>

            </form>
            </div>
            <div class="col-xs-3"></div>
        </div>
    </body>
</html>
