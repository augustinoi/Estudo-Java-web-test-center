<%-- 
    Document   : cadastrarUsuario
    Created on : 08/04/2018, 14:52:59
    Author     : Nando Luzy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <!--Stylo da pagina-->
        <link rel="stylesheet" href="../resources/bootstrap/css/bootstrap.css">
        <link rel="shortcut icon" href="../imagens/favicon/favicon.ico" type="image/x-icon" />
        <!-- Bootstrap core CSS-->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom fonts for this template-->
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <title>Cadastrar Novo Usuário</title>
    </head>
    <body>
        <h1 class="navbar navbar-text ">Novo Usuário</h1>
        <br>
        <a class="btn btn-dark" href="listarUsuarios.jsp"> &lt; Voltar</a>
        <br>
        <br>
        <form class="navbar nav-tabs" method="post" action="gerenciar_usuario.do">
            <table class="text-center">
                <tr>Username: <input type="text" size="50" name="username"placeholder="username"></tr>
                <tr>Senha: <input type="password" size="50" name="pass" placeholder="********"></tr>
                <br>
                <tr>
                    <input type="hidden" name="option" value="insert">
                    <input class="btn btn-success" type="submit" id="button" value="Cadastrar Usuário">
                </tr>
            </table>
        </form>
        
        <!-- Bootstrap JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
    </body>
</html>
