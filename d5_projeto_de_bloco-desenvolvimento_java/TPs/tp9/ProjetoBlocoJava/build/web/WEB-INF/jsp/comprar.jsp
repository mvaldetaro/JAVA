<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page = "../includes/head.jsp" />
<jsp:include page = "../includes/header.jsp" />  
<div class="container">
        <main class="col-md-8 col-md-offset-2">
            <div class="content box shadow text-color bg-box"> 
                <p><a href="javascript:history.go(-1)"><i class="material-icons" style="vertical-align: middle;">keyboard_arrow_left</i> Voltar</a></p>
                <hr>
                <p><span class="label label-info">Evento</</p>
                <c:forEach items="${evento}" var="attr">
                <h1>${attr.titulo}</h1>
                <p><b>Classificação:</b> <span class="label label-warning">${attr.faixa_etaria}</span> <b>Duração:</b> ${attr.duracao}min </p>
                </c:forEach>
                <c:forEach items="${sala}" var="attr">
                    <c:set var="idAssento" value="${attr.idassentos}"></c:set>
                    <c:set var="idSala" value="${attr.idsala}"></c:set>
                    <p><b>${attr.nome} - Assento: <span class="fila-assento">${attr.fila}${attr.assento}</span></b></p>
                </c:forEach>
                
                <c:forEach items="${sessao}" var="attr">
                    <c:set var="idSessao" value="${attr.idsessao}"></c:set>
                <p>Horário: <fmt:formatDate type="time" timeStyle="short" value="${attr.horario}" /> | <fmt:formatDate type="date" dateStyle="short" value="${attr.data}" /></p>
                <fmt:setLocale value="pt_BR"/>
                <p><fmt:formatNumber value="${attr.preco}" type="currency"/></p>
                </c:forEach>
                <hr>
                
                <p><b>Informações pessoais:</b></p>
                <p><b>Nome:</b> ${userNome}</p>
                <p><b>Email:</b> ${userEmail}</p>
                
                <hr>
                
                <a href="confirmar?sessao=${idSessao}&sala=${idSala}&user=${userId}&assento=${idAssento}" class="btn btn-lg btn-block btn-primary">Confirmar Compra</a>
                <br>
                <p><a href="/ProjetoBlocoJava/">Voltar para página inicial</a></p>
            </div>
        </main>
    </div>
<jsp:include page = "../includes/footer.jsp" /> 
