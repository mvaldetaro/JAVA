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
                        <p class="text-md-center"><i class="material-icons">verified_user</i></p>
                        
                        <hr>
                    </div>
                </c:when>
            </c:choose>

        </div>
    </main>
</div>
<jsp:include page = "../includes/footer.jsp" /> 