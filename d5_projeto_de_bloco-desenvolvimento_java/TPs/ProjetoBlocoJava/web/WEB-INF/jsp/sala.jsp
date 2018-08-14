<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page = "../includes/head.jsp" />
<jsp:include page = "../includes/header.jsp" />  
<div class="container">
    <main class="col-md-12">
        <div class="content box shadow text-color bg-box">
            <h1>Sala 01</h1>
            <p>Selecione o assento:</p>   
            <table class="table table-hover table-sala">
                <thead>
                    <tr>
                        <th></th>  
                        <th>1</th>
                        <th>2</th>
                        <th>3</th>
                        <th>4</th>
                        <th>5</th>
                    </tr>
                </thead>
                <c:set var="count" value="0" scope="page"></c:set>
                <c:set var="i" value="0" scope="page"></c:set>
                <c:forEach var="row" begin="1" end="${qtdRow}">
                    <tr>
                        <td><b>${fila[row]}</b></td>
                        <c:forEach items="${sala}" var="attr" begin="${i}" end="${i+4}">
                            <c:if test="${count <= 4}">    
                                <td>
                                    <c:if test="${status[attr.idassentos -1] == 'indisponivel'}">
                                        <span class="assento ${status[attr.idassentos -1]}">
                                            <i class="material-icons">weekend</i>
                                        </span>
                                    </c:if>
                                    
                                    <c:if test="${status[attr.idassentos -1] != 'indisponivel'}">    
                                    <button id="${attr.idassentos}" class="assento ${status[attr.idassentos -1]}" onclick="window.location.href = 'comprar?id=${attr.idassentos}&sala=${attr.idsala}&sessao=${idSessao}&evento=${idEvento}'; return true;">
                                        <i class="material-icons">weekend</i>
                                    </button>
                                    </c:if>    
                                </td>
                            </c:if>
                            <c:set var="i" value="${i +1}" scope="page"></c:set>
                            <c:set var="count" value="${count +1}" scope="page"></c:set>

                        </c:forEach>
                        <c:set var="count" value="0" scope="page"></c:set>
                        </tr>

                </c:forEach>    
            </table>
            <hr>
            <p><a href="javascript:history.go(-1)"><i class="material-icons" style="vertical-align: middle;">keyboard_arrow_left</i> Voltar</a></p>
        </div>
    </main>
</div>
<jsp:include page = "../includes/footer.jsp" /> 
