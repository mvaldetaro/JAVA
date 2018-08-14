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
            <form action="sucesso" method="POST">
                <div class="form-group">
                    <label for="nome">Nome</label>
                    <input type="text" class="form-control" id="nome" name="nome" placeholder="Digite seu nome" required>
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="Digite seu email" required>
                </div>
                <div class="form-group">
                    <label for="senha">Senha</label>
                    <input type="password" class="form-control" id="senha" name="senha" placeholder="Digite sua senha" required>
                </div>
                <button type="submit" class="btn btn-primary btn-block">Cadastrar</button>
            </form>
        </div>
    </main>
</div>
<jsp:include page = "../includes/footer.jsp" /> 
