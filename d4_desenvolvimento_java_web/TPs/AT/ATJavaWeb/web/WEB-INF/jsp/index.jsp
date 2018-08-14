<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "../includes/head.jsp" />
<div class="container">
    <main class="col-md-6 offset-md-3">
        <div class="content box shadow text-color bg-box">
            <nav>
                <ul class="menu-list">
                    <c:choose>
                        <c:when test="${not empty userId}">
                            <li class="menu-list-item">
                                <a href="admin" class="menu-list-item-content"><i class="material-icons icon">book</i>Gerenciar Livros</a>
                            </li>
                        </c:when>
                    </c:choose>
                    <li class="menu-list-item">
                        <a href="login" class="menu-list-item-content"><i class="material-icons icon">account_circle</i>Login</a>
                    </li>
                    <li class="menu-list-item">
                        <a href="cadastro" class="menu-list-item-content"><i class="material-icons icon">add_circle</i>Cadastrar</a>
                    </li>
                </ul>
            </nav>
        </div>
    </main>
</div>
<jsp:include page = "../includes/footer.jsp" /> 