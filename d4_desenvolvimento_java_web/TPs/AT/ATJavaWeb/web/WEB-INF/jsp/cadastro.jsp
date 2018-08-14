<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "../includes/head.jsp" />
<div class="container">
    <main class="col-md-6 offset-md-3">
        <div class="content box shadow text-color bg-box">
            <p>Preencha os campos a seguir para realizar o cadastro no sistema.</p>
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
            <br>
            <p><a href="/ATJavaWeb/">Voltar para página inicial</a></p>
        </div>
    </main>
</div>
<jsp:include page = "../includes/footer.jsp" /> 
