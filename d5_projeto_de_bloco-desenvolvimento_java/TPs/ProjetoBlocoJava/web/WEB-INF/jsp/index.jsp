<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<jsp:include page = "../includes/head.jsp" />
<jsp:include page = "../includes/header.jsp" />

<div class="container">
    <main class="col-md-6 col-md-offset-3">
        <div class="content box shadow text-color bg-box">
            <!-- <div>
                <form class="form-inline">
                    <div class="form-group">
                        <label for="search">Buscar</label>
                        <input type="text" class="form-control" id="search" placeholder="Ex.: Senhor do Aneis">
                    </div>
                    <button type="submit" class="btn btn-primary">Buscar</button>
                </form>
            </div> 
            <hr>-->
            <nav>
                <ul class="menu-list"> 
                    <li class="menu-list-item">
                        <a href="eventos" class="menu-list-item-content"><i class="material-icons icon">event</i>Eventos</a>
                    </li>
                    <c:choose>
                        <c:when test="${not empty userId}">
                            <!--<li class="menu-list-item">
                                <a href="perfil" class="menu-list-item-content"><i class="material-icons icon">account_box</i>Perfil</a>
                            </li>-->
                            <li class="menu-list-item">
                                <a href="historico" class="menu-list-item-content"><i class="material-icons icon">event</i>Histórico de Compras</a>
                            </li>
                        </c:when>
                    </c:choose>
                </ul>      
            </nav>
            <hr>
            <nav>
                <a href="login">Login</a> | 
                <a href="cadastro">Cadastre-se</a>
            </nav>
        </div>
    </main>
</div>
<jsp:include page = "../includes/footer.jsp" /> 

