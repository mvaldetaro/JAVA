<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "../includes/head.jsp" />
<header>
    <div class="container">
        <h1 class="title">Cadastro</h1>
    </div>
</header>
<div class="ribbon"></div>
<div class="container">
    <main class="col-md-6 offset-md-3">
        <div class="content box shadow text-color bg-box"> 
            <h1>Obrigado!</h1>
            <br> 
            <p><b>${nome}</b>, seu cadastro foi efetuado com sucesso!<br>Seu login é: <b>${email}</b></p>
        </div>
    </main>
</div>
<jsp:include page = "../includes/footer.jsp" /> 
