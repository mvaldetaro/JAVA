    <jsp:include page = "../includes/head.jsp" />
    <jsp:include page = "../includes/header.jsp" />    
    <div class="container">
        <main class="col-md-6 col-md-offset-3">
            <div class="content box shadow text-color bg-box"> 
            <h1>Obrigado!</h1>
            <br> 
            <p><b>${nome}</b>, seu cadastro foi efetuado com sucesso!<br>Seu login é: <b>${email}</b></p>
            <p><a href="login" class="btn btn-primary">Realizar login</a></p>
        </div>
        </main>
    </div>
    <jsp:include page = "../includes/footer.jsp" />