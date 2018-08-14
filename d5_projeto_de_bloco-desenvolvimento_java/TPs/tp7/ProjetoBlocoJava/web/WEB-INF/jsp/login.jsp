    <jsp:include page = "../includes/head.jsp" />
    <jsp:include page = "../includes/header.jsp" />   
    <div class="container">
        <main class="col-md-4 col-md-offset-4">
            <div class="content box shadow text-color bg-box">    
                <form class="form-signin">
                    <div class="form-group">
                    <input type="email" id="inputEmail" class="form-control" placeholder="Email" required autofocus>
                    </div>
                    <div class="form-group">
                    <input type="password" id="inputPassword" class="form-control" placeholder="Senha" required>
                    </div>
                    <div id="remember" class="checkbox">
                        <label>
                            <input type="checkbox" value="Lembre-me"> Lembre-me
                        </label>
                    </div>
                    <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Entrar</button>
                </form>
            </div>
        </main>
    </div>
    <jsp:include page = "../includes/footer.jsp" />