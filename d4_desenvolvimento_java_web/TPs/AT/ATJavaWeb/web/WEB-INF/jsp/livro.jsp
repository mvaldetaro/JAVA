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
            <form action="cadastrar-livro" method="POST">
                <div class="form-group">
                    <label for="nome">Titulo</label>
                    <input type="text" class="form-control" id="titulo" name="titulo" placeholder="Digite o titulo do livro" required>
                </div>
                <div class="row">
                <div class="form-group col-md-4">
                    <label for="autor">Autor</label>
                    <select class="form-control" name="autor" id="autor">
                        <option value="">Selecione o Autor</option>
                        <c:forEach items="${autores}" var="attr">
                        <option value="${attr.id}">${attr.autor}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group col-md-4">
                    <label for="editora">Editora</label>
                    <select class="form-control" name="editora" id="editora">
                        <option value="">Selecione a Editora</option>
                        <c:forEach items="${editoras}" var="attr">
                        <option value="${attr.id}">${attr.editora}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group col-md-4">
                    <label for="ano">Ano</label>
                    <input type="number" class="form-control" id="ano" name="ano" placeholder="Digite o ano da edição (ex.: 2016)" required>
                </div>
                </div>
                <input type="hidden" id="action" name="action" value="add">
                <button type="submit" class="btn btn-primary">Cadastrar</button>
            </form>

        </div>
    </main>
</div>
<jsp:include page = "../includes/footer.jsp" /> 