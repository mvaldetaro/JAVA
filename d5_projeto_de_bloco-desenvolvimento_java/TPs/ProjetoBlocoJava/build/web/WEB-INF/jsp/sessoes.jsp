<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page = "../includes/head.jsp" />
<jsp:include page = "../includes/header.jsp" />  
<div class="container">


    <main class="col-md-12">
        <div class="jumbotron">
            <c:forEach items="${evento}" var="attr">
                <h1>${attr.titulo}</h1>
                <p>${attr.descricao} </p>
                <p><b>Classificação:</b> <span class="label label-warning">${attr.faixa_etaria}</span> <b>Duração:</b> ${attr.duracao}min </p>
                <c:set var="idevent" value="${attr.idevento}"></c:set>
            </c:forEach>
        </div>
        <div class="content box shadow text-color bg-box">

            <p><a href="javascript:history.go(-1)"><i class="material-icons" style="vertical-align: middle;">keyboard_arrow_left</i> Voltar</a></p>
            <hr>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Data</th>
                        <th>Horario</th>
                        <th>Preço</th>
                        <th>Sala</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${sessoesEvento}" var="attr">
                        <tr>
                            <td><fmt:formatDate type="date" dateStyle="long" value="${attr.data}" /></td>
                            <td><fmt:formatDate type="time" timeStyle="short" value="${attr.horario}" /></td>
                            <td>
                                <fmt:setLocale value="pt_BR"/>
                                <fmt:formatNumber value="${attr.preco}" type="currency"/>    
                            </td>
                            <td>${attr.nome}</td>
                            <th><a href="sala?id=${attr.idsala}&sessao=${attr.idsessao}&evento=${idevent}" class="btn btn-primary btn-sm">Comprar Ingresso</a></th>
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
