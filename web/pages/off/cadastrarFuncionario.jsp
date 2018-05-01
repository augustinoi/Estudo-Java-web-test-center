<%-- 
    Document   : cadastrarFuncionario
    Created on : 11/04/2018, 12:08:46
    Author     : Nando Luz
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
        <title>Cadastrar Novo Funcionario</title>
    </head>
    <body>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--Stylo da pagina-->
        <link rel="stylesheet" href="../resources/bootstrap/css/bootstrap.css">
        <link rel="shortcut icon" href="../imagens/favicon/favicon.ico" type="image/x-icon" />
        <!-- Bootstrap core CSS-->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom fonts for this template-->
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <title>Cadastrar Novo Funcionario</title>
    </head>
    <body>
        <h1 class="navbar navbar-text col-md-12">Novo Funcionario</h1>
        <br>
        <a class="btn btn-dark" href="listarFuncionarios.jsp"> &lt; Voltar</a>
        <br>
        <br>
        <!--<div class="nav navbar col-md-10">-->
            <form class="navbar col-xs-10 col-xs-offset-3" method="post" action="gerenciar_funcionario.do">
                <div class="col-xs-5">
                    <h1>Funcionario</h1><br>
                    <label>NOME COMPLETO</label><br>
                    <input type="text" size="50" name="username" placeholder="Nome completo" autofocus ><br>

                    <label>CPF</label><br>
                    <input type="text" size="50" name="pass" placeholder="000.000.000-00"><br>

                    <label>RG</label><br>
                    <input type="text" size="50" name="pass" placeholder="0.000.000"><br>

                    <label>SEXO</label><br>
                    <input type="text" size="50" name="pass" placeholder="000.000.000-00"><br>

                    <label>CARGO</label><br>
                    <input type="text" size="50" name="pass" placeholder="Função"><br>

                    <label>TELEFONE</label><br>
                    <input type="text" size="50" name="pass" placeholder="(00) 00000-0000"><br>

                    <label>EMAIL</label><br>
                    <input type="text" size="50" name="pass" placeholder="exemplo@email.com"><br>
                </div>
                
                <div class="col-xs-5 col-xscol-xs-offset-1">
                    <h1>Endereço</h1><br>
                    
                    <label>ENDEREÇO</label><br>
                    <input type="text" size="25" name="pass" placeholder="Username"><br>

                    <label>CEP</label><br>
                    <input type="password" size="25" name="pass" placeholder="*****"><br>
                    
                    <label>UF</label><br>
                    <input type="password" size="25" name="pass" placeholder="*****"><br>
                    
                    <label>COMPLEMENTO</label><br>
                    <input type="password" size="25" name="pass" placeholder="*****"><br>
                </div>
                <div class="col-xs-5 col-xscol-xs-offset-1">
                    <h1>Usuario</h1><br>
                    
                    <label>LOGIN</label><br>
                    <input type="text" size="25" name="pass" placeholder="Username"><br>

                    <label>SENHA</label><br>
                    <input type="password" size="25" name="pass" placeholder="*****"><br>
                </div>
                <div class="col-md-12"
                    <br>
                    <center>
                        <input type="hidden" name="option" value="insert">
                        <input class="btn btn-success" type="submit" id="button" value="Cadastrar Funcionario">
                    </center>
                </div>
            </form>
        <!--</div>-->
        
        <!-- Bootstrap JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
    </body>
</html>
