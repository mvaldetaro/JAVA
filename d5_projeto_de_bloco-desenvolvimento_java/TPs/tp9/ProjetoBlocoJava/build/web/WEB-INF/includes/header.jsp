<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<header>
    <div class="container headerbar">
        <h1 class="title">${title}</h1>
        <div class="user">
        <c:choose>
            <c:when test="${not empty userId}">
                <p><i class="material-icons" style="vertical-align: sub;">verified_user</i> ${userNome} <a href="encerrarsessao" class="btn btn-primary btn-sm">Sair</a></p>
            </c:when>
        </c:choose>
        </div>
    </div>
    
</header>
<div class="ribbon"></div>
