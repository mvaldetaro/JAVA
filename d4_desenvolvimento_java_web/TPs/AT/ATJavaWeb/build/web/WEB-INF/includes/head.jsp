<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="req" value="${pageContext.request}" />
<c:set var="url">${req.requestURL}</c:set>
<c:set var="uri" value="${req.requestURI}" />
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Assessment Java Web</title>
    <base href="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/">
    <link href="<c:url value="assets/css/bootstrap-reboot.min.css" />" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="assets/css/bootstrap-grid.min.css" />" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="assets/css/bootstrap.min.css" />" rel="stylesheet" type="text/css"/>
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="<c:url value="assets/css/style.css" />" rel="stylesheet" type="text/css"/>
</head>
<body>

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
    