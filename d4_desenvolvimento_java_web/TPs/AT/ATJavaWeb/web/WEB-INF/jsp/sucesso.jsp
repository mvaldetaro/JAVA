<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "../includes/head.jsp" />

<div class="container">
    <main class="col-md-6 offset-md-3">
        <div class="content box shadow text-color bg-box"> 
            <h1>Obrigado!</h1>
            <br> 
            <p><b>${nome}</b>, seu cadastro foi efetuado com sucesso!<br>Seu login é: <b>${email}</b></p>
            <p><a href="login" class="btn btn-primary">Realizar login</a></p>
        </div>
    </main>
</div>
<jsp:include page = "../includes/footer.jsp" /> 
