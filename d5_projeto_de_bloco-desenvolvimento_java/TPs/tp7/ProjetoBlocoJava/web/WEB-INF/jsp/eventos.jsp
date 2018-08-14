<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page = "../includes/head.jsp" />
<jsp:include page = "../includes/header.jsp" />  
<div class="container">
        <main class="col-md-12">
            <div class="content box shadow text-color bg-box"> 
                <p><b>Categorias:</b></p>
                <nav class="nav-filtros">    
                    <c:forEach items="${tipos}" var="attr">
                        <a class="btn btn-primary btn-sm" href="eventos/${fn:toLowerCase(attr.titulo)}?id=${attr.idtipo_evento}">${attr.titulo}</a>
                    </c:forEach>
                </nav>
                <table class="table table-hover">
                    <thead>
                      <tr>
                        <th>Titulo</th>
                        <th>Faixa Et�ria</th>
                        <th>Dura��o</th>
                        <th></th>
                      </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${lista}" var="attr">
                        <tr>
                          <td>${attr.titulo}</td>
                          <td>${attr.faixa_etaria}</td>
                          <td>${attr.duracao}</td>
                          <th><a href="#" class="btn btn-primary btn-sm">Sess�es</a></th>
                        </tr>
                        </c:forEach>    
                    </tbody>
                  </table>
                
            </div>
        </main>
    </div>
<jsp:include page = "../includes/footer.jsp" /> 
