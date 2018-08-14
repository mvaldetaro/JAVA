<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "../includes/head.jsp" />
<header>
    <div class="container">
        <h1 class="title">Login</h1>
    </div>
</header>
<div class="ribbon"></div>
<div class="container">
    <main class="col-md-6 offset-md-3">
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
                    <p><a href="/tp3JavaWeb2/">Ir apra página inicial</a></p>
                    <p><a href="encerrarsessao">Finalizar sessão</a></p>
                </c:when>
                <c:otherwise>
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
                    </form>
                    <br>        
                    <div class="text-lg-center"><a href="cadastro">Cadastre-se</a></div>
                </c:otherwise>
            </c:choose>

        </div>
    </main>
</div>
<jsp:include page = "../includes/footer.jsp" /> 
