<%-- 
    Document   : index2
    Created on : 28/03/2018, 14:41:31
    Author     : Nando Luz
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="pt-br">
    <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=devicre-width, initial-scale=1">
            <link rel="shortcut icon" href="img/favicon/favicon.ico" type="image/x-icon" />
            <!-- Bootstrap core CSS-->
            <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
            <!-- Custom fonts for this template-->
            <link href="resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
            <!-- Page level plugin CSS-->
            <link href="resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
            <!-- Custom styles for this template-->
            <link href="resources/css/sb-admin.css" rel="stylesheet">
            <!--icon-->
            <link rel="shortcut icon" href="img/favicon/favicon.ico" type="image/x-icon" />
            <!--titulo da pagina-->
            <title>Gente Telecom</title>
            </head>
            
            
    <body class="home blog geral">     
        <div class="nav navbar bg-dark" style="top: -8px">
            
            
            <h1 class="nav navbar-text"><img src="img/logotipo.png"></h1>
        </div>
        <div class="container-fluid col-md-4" style="margin-top: 5%;">
            
            <div class="card text-white mb-3">
                <div class="card-header bg-dark text-white form-inline">
                    <div class="form-inline my-2 my-lg-0 mr-lg-2">
                        <i class="fa fa-user-o" style="margin-right: 10px"></i>
                        LOGIN
                        <div class="navbar-nav ml-auto" style="width: 40px; height: 40px;">                                
                        </div>
                    </div>                
                </div> 
                <div class="card-body" >
                    <form style="color: black">
                        <div class="form-group">
                            <i class="fa fa-fw fa-user"></i>
                            <label for="InputUsername" style="margin: 0px"></label>
                            <input type="text" class="form-control" id="InputUsername" aria-describedby="emailHelp" placeholder="Username">
                            <small id="emailHelp" class="form-text text-muted">Não compartilhe seus dados de acesso.</small>
                        </div>
                        <div class="form-group">
                            <i class="fa fa-fw fa-lock"></i>
                            <label for="InputSenha" style="margin: 0px">SENHA</label>
                            <input type="password" class="form-control" id="InputSenha" placeholder="*****">
                        </div>
                        <div class="form-group form-check">
                          <input type="checkbox" class="form-check-input" id="Check">
                          <label class="form-check-label" for="Check">Lembre-se</label>
                        </div>
                        <center><button type="submit" class="btn btn-primary"><a href="pages/home.jsp">Entrar</a></button></center>
                    </form>
                </div>
                
            </div>
        </div>
      
        <!-- Bootstrap core JavaScript-->
        <script src="resources/vendor/jquery/jquery.min.js"></script>
        <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- Core plugin JavaScript-->
        <script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>
    </body>
</html>
