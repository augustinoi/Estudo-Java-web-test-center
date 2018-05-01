<%-- 
    Document   : home
    Created on : 04/04/2018, 20:31:16
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="../imagens/favicon/favicon.ico" type="image/x-icon" />
        <!--Stylo da pagina-->
        <link rel="stylesheet" href="../resources/bootstrap/css/bootstrap.css">
        
        <title>Home - Over System</title>
    </head>
    <body>
        <div class="nav navbar">
            <h1 class="nav navbar-text"><img src="../imagens/logotipo.png"></h1>
        </div>
        <hr>
        <br>
        
        <center>
            <table class="table col-md-8">
                <tr>
                    <a class="btn btn-primary col-md-2" href="listarClientes.jsp">Clientes</a>
                </tr>
                <tr>
                    <a class="btn btn-primary col-md-2" href="listarFuncionarios.jsp">Funcionarios</a>
                </tr>
                <tr>
                    <a class="btn btn-primary col-md-2" href="listarUsuarios.jsp">Usuario</a>
                </tr>
                <tr>
                    <a class="btn btn-primary col-md-2" href="listarProdutos.jsp">Estoque</a>
                </tr>
            </table>
        </center>
    </body>
</html>
