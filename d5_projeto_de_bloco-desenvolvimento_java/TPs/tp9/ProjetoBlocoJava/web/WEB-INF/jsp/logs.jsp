<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page = "../includes/head.jsp" />
<jsp:include page = "../includes/header.jsp" />  
<div class="container">
        <main class="col-md-12">
            <div class="content box shadow text-color bg-box">
                <p><a href="javascript:history.go(-1)"><i class="material-icons" style="vertical-align: middle;">keyboard_arrow_left</i> Voltar</a></p>
                
                <table class="table table-hover">
                    <thead>
                      <tr>
                        <th>Evento</th>
                        <th>Preço</th>
                        <th>Data</th>
                        <!--<th></th>-->
                      </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${logs}" var="attr">
                        <tr>
                          <td>${attr.titulo}</td>
                          <td>
                              <fmt:setLocale value="pt_BR"/>
                              <fmt:formatNumber value="${attr.preco}" type="currency"/>
                          </td>
                          <td><fmt:formatDate type="date" dateStyle="short" value="${attr.data}" /></td>
                          <!--<td><a href="detalhes?id=1" class="btn btn-primary btn-sm">Ver Detalhes</a></td>-->
                        </tr>
                        </c:forEach>
                    </tbody>
                  </table>
                <hr>
                <p><a href="javascript:history.go(-1)"><i class="material-icons" style="vertical-align: middle;">keyboard_arrow_left</i> Voltar</a></p>
                
            </div>
        </main>
    </div>
<jsp:include page = "../includes/footer.jsp" /> 
