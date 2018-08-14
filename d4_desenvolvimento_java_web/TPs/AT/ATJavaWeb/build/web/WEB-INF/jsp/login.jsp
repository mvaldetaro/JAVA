<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "../includes/head.jsp" />
<div class="container">
    <main class="col-md-12">

        <div class="col-md-6">

            <div class="content box shadow text-color bg-box">
                <c:choose>
                    <c:when test="${not empty msg}">
                        <div class="alert alert-warning" role="alert">${msg}</div>
                    </c:when>
                </c:choose>

                <c:choose>
                    <c:when test="${not empty userId}">
                        <h1>Autenticado!</h1>
                        <p>Olá <b>${userNome}</b>, seja bem vindo!</p>
                        <p><a href="/ATJavaWeb/">Ir para página inicial</a></p>
                        <p><a href="encerrarsessao">Finalizar sessão</a></p>
                    </c:when>
                    <c:otherwise>
                        <h2>Já tenho cadastro</h2>
                        <form action="login" method="POST">
                            <div class="form-group">
                                <label for="email">Login</label>
                                <input type="email" class="form-control" id="email" name="email" placeholder="Digite seu email" required>
                            </div>
                            <div class="form-group">
                                <label for="senha">Senha</label>
                                <input type="password" class="form-control" id="senha" name="senha" placeholder="Digite sua senha" required>
                            </div>
                            <button type="submit" class="btn btn-primary btn-block">Realizar Login</button>
                            <br>
                            <p><a href="/ATJavaWeb/">Voltar para página inicial</a></p>
                        </form>
                        <br>        
                        
                    </c:otherwise>
                </c:choose>
            </div>

        </div>
        <div class="col-md-5 offset-md-1">
            <div class="content box shadow text-color bg-box">
            <h2>Não tenho cadastro</h2>
            <p>Criar cadastro</p>
            <div class="text-lg-center"><a class="btn btn-block btn-primary btn-lg" href="cadastro">Criar cadastro</a></div>
            </div>
        </div>


    </main>
</div>
<jsp:include page = "../includes/footer.jsp" /> 
