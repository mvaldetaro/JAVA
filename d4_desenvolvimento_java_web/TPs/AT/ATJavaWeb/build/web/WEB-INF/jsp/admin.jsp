<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "../includes/head.jsp" />

<div class="container">
    <main class="col-md-12">
        <div class="content box shadow text-color bg-box">
            <c:choose>
                <c:when test="${not empty msg}">
                    <div class="alert alert-success" role="alert">${msg}</div>
                </c:when>
            </c:choose>
            <nav>
            <a href="cadastrar/livro" class=" btn btn-primary">Cadastrar um novo livro</a>
            <a href="cadastrar/autor" class=" btn btn-primary">Cadastrar Autor</a>
            <a href="cadastrar/editora" class=" btn btn-primary">Cadastrar Editora</a>
            </nav>
            <hr>
            <table class="table table-striped table-hover">
                <tr>
                    <th></th>
                    <th>Título</th>
                    <th>Autor</th>
                    <th>Editora</th>
                    <th>Ano</th>
                    <th>Ações</th>
                </tr>
                <c:forEach items="${lista}" var="attr">
                <tr>
                    <td>${attr.id}</td>
                    <td>${attr.titulo}</td>
                    <td>
                        <c:forEach items="${autores}" var="autor">
                            <c:if test="${attr.id_autor == autor.id}">
                            ${autor.autor}
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${editoras}" var="editora">
                            <c:if test="${attr.id_editora == editora.id}">
                            ${editora.editora}
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>${attr.ano}</td>
                    <td>
                        <a href="livro/editar/${attr.id}" class=" btn btn-primary btn-sm">Alterar</a>
                        <a href="livro/excluir/${attr.id}" class="btn btn-danger btn-sm">Excluir</a>
                    </td>
                </tr>
                </c:forEach>
                
            </table>

        </div>
    </main>
</div>
<jsp:include page = "../includes/footer.jsp" /> 