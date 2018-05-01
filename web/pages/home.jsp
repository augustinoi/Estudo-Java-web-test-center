<%-- 
    Document   : home
    Created on : 13/04/2018, 10:55:38
    Author     : Nando Luz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="4I">
    <title>Home - Gente Telecom</title>
    <!-- Bootstrap core CSS-->
    <link href="../resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom fonts for this template-->
    <link href="../resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <!-- Page level plugin CSS-->
    <link href="../resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="../resources/css/sb-admin.css" rel="stylesheet">
    <!--icon-->
    <link rel="shortcut icon" href="../img/favicon/favicon.ico" type="image/x-icon" />
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
  <!-- Navigation-->
  <%@include file="menu/menu.jsp" %>
  <div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item active">Home</li>
      </ol>
      <!-- Icon Cards-->
      <div class="row">
        <!--          1-->
        <div class="col-xl-3 col-sm-6 mb-3">
          <div class="card text-white bg-primary o-hidden h-100">
            <div class="card-body">
              <div class="card-body-icon">
                <i class="fa fa-fw fa-users"></i>
              </div>
              <div class="mr-5"> Cliente </div>
            </div>
              <a class="card-footer text-white clearfix small z-1" href="cliente.jsp">
              <span class="float-left">Ver Detalhes</span>
              <span class="float-right">
                <i class="fa fa-angle-right"></i>
              </span>
            </a>
          </div>
        </div>
          
        <!--          2-->
        <div class="col-xl-3 col-sm-6 mb-3">
          <div class="card text-white bg-warning o-hidden h-100">
            <div class="card-body">
              <div class="card-body-icon">
                <i class="fa fa-fw fa-id-badge"></i>
              </div>
              <div class="mr-5"> Funcionário </div>
            </div>
              <a class="card-footer text-white clearfix small z-1" href="funcionario.jsp">
              <span class="float-left">Ver Detalhes</span>
              <span class="float-right">
                <i class="fa fa-angle-right"></i>
              </span>
            </a>
          </div>
        </div>
        <!--          3-->
        <div class="col-xl-3 col-sm-6 mb-3">
          <div class="card text-white bg-success o-hidden h-100">
            <div class="card-body">
              <div class="card-body-icon">
                <i class="fa fa-fw fa-shopping-cart"></i>
              </div>
              <div class="mr-5"> Estoque </div>
            </div>
              <a class="card-footer text-white clearfix small z-1" href="estoque.jsp">
              <span class="float-left">Ver Detalhes</span>
              <span class="float-right">
                <i class="fa fa-angle-right"></i>
              </span>
            </a>
          </div>
        </div>
        <!--          4-->
        <div class="col-xl-3 col-sm-6 mb-3">
          <div class="card text-white bg-danger o-hidden h-100">
            <div class="card-body">
              <div class="card-body-icon">
                <i class="fa fa-fw fa-wrench"></i>
              </div>
              <div class="mr-5"> Instalação </div>
            </div>
              <a class="card-footer text-white clearfix small z-1" href="instalacao.jsp">
              <span class="float-left">Ver Detalhes</span>
              <span class="float-right">
                <i class="fa fa-angle-right"></i>
              </span>
            </a>
          </div>
        </div>
      </div>
      
      
      <div class="row">
          <!-- Carousel -->
          <div class="col-sm-6">
                <div class="card mb-3">
                    <div class="card-header">
                        <i class="fa fa-image"></i>
                        Galeria
                    </div>
                    <div class="card-body">
                        <div id="carouselSlide" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="carouselSlide" data-slide="0" class="active"></li>
                                <li data-target="carouselSlide" data-slide="1"></li>
                                <li data-target="carouselSlide" data-slide="2"></li>
                            </ol>
                            
                            <div class="carousel-inner">
                                <div class="carousel-item active">
                                    <img src="../img/carousel/parede.png" class="img-fluid d-block">
                                </div>
                                <div class="carousel-item">
                                    <img src="../img/carousel/couro.png" class="img-fluid d-block">
                                </div>
                                <div class="carousel-item">
                                    <img src="../img/carousel/satelite_antena.png" class="img-fluid d-block">
                                </div>
                            </div>
                            
                            <a class="carousel-control-prev" href="#carouselSlide" role="bottom" data-slide="prev">
                                <span class="fa fa-chevron-left"></span>
                            </a>
                            <a class="carousel-control-next" href="#carouselSlide" role="bottom" data-slide="next">
                                <span class="fa fa-chevron-right"></span>
                            </a>
                            
                        </div>
                    </div>
                </div>
          </div>
          <div class="col-sm-6">
              <!--notepad-->
              <div class="card mb-3">
                  <div class="card-header">
                      <i class="fa fa-pencil"></i>
                      Agendar
                  </div>                  
                  <div class="card-body">
                      <div>
                          <form class="form-check">
                            <textarea class="col-sm-12" style="height: 249px;" type="text" placeholder="Digite aqui..."></textarea>                            
                            <center><input class="btn btn-primary" type="submit" value="Agendar"></center>
                          </form>
                      </div>
                  </div>
              </div>
          </div>
      </div>
        
    </div>
            <!-- /.container-fluid-->
            <!-- /.content-wrapper-->
            <footer class="sticky-footer">
              <div class="container">
                <div class="text-center">
                  <small>Gente Telecom do Brasil © 2018 Todos os Direitos Reservados</small>
                </div>
              </div>
            </footer>
            <!-- Scroll to Top Button-->
            <a class="scroll-to-top rounded" href="#page-top">
              <i class="fa fa-angle-up"></i>
            </a>

            <!-- Logout Modal-->
            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
              <div class="modal-dialog" role="document">
                <div class="modal-content">
                  <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Pronto para partir?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">×</span>
                    </button>
                  </div>
                  <div class="modal-body">Selecione "Sair" abaixo, se você estiver pronto para encerrar sua sessão atual.</div>
                  <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
                    <a class="btn btn-primary" href="login.jsp">Sair</a>
                  </div>
                </div>
              </div>
            </div>
            <!-- Bootstrap core JavaScript-->
            <script src="../resources/vendor/jquery/jquery.min.js"></script>
            <script src="../resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
            <!-- Core plugin JavaScript-->
            <script src="../resources/vendor/jquery-easing/jquery.easing.min.js"></script>
            <!-- Page level plugin JavaScript-->
            <script src="../resources/vendor/chart.js/Chart.min.js"></script>
            <script src="../resources/vendor/datatables/jquery.dataTables.js"></script>
            <script src="../resources/vendor/datatables/dataTables.bootstrap4.js"></script>
            <!-- Custom scripts for all pages-->
            <script src="../resources/js/sb-admin.min.js"></script>
            <!-- Custom scripts for this page-->
            <script src="../resources/js/sb-admin-datatables.min.js"></script>
            <script src="../resources/js/sb-admin-charts.min.js"></script>
    </div>
</body>
</html>
