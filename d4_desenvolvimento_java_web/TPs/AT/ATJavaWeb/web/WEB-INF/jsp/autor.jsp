<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "../includes/head.jsp" />
<div class="container">
    <main class="col-md-12">
        <div class="content box shadow text-color bg-box">
            <nav>
                <a href="admin">Voltar</a>
            </nav> 
            <hr>
            <c:choose>
                <c:when test="${not empty msg}">
                    <div class="alert alert-success" role="alert">${msg}</div>
                </c:when>
            </c:choose>
            <form action="cadastrar-autor" method="POST">
                <div class="form-group">
                    <label for="autor">Autor</label>
                    <input type="text" class="form-control" id="autor" name="autor" placeholder="Digite o nome do autor" required>
                </div>
                <input type="hidden" id="action" name="action" value="add">
                <button type="submit" class="btn btn-primary">Cadastrar</button>
            </form>

        </div>
    </main>
</div>
<jsp:include page = "../includes/footer.jsp" /> 