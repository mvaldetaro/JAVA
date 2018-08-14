<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "../includes/head.jsp" />
<header>
    <div class="container">
        <h1 class="title">Home</h1>
    </div>
</header>
<div class="ribbon"></div>
<div class="container">
    <main class="col-md-6 offset-md-3">
        <div class="content box shadow text-color bg-box">
            <c:choose>
                <c:when test="${not empty userId}">
                    <div>
                        <p><i class="material-icons">verified_user</i> <b>${userNome}</b></p>
                        <hr>
                    </div>
                </c:when>
            </c:choose>
            <nav>
                    <ul class="menu-list">
                        <li class="menu-list-item">
                            <a href="login" class="menu-list-item-content"><i class="material-icons icon">account_circle</i>Login</a>
                        </li>
                        <li class="menu-list-item">
                            <a href="cadastro" class="menu-list-item-content"><i class="material-icons icon">add_circle</i>Cadastrar</a>
                        </li>
                        <li class="menu-list-item">
                            <a href="restrito" class="menu-list-item-content"><i class="material-icons icon">security</i>Área restrita</a>
                        </li>
                    </ul>
                </nav>
        </div>
    </main>
</div>
<jsp:include page = "../includes/footer.jsp" /> 