<%-- 
    Document   : clienteFullView
    Created on : 11/04/2018, 16:43:55
    Author     : Nando Luz
--%>

<%@page import="model.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String id = request.getParameter("id");
    String nome = request.getParameter("nome");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--Stylo da pagina-->
        <link rel="stylesheet" href="../resources/bootstrap/css/bootstrap.css">
        <link rel="shortcut icon" href="../imagens/favicon/favicon.ico" type="image/x-icon" />
        <script type="text/javascript">
            function excluir(fnome,fid){
                var url = "gerenciar_funcionario.do?option=delete&id="+fid;
                    if(confirm("Tem certeza que deseja excluir o perfil: "+fnome+"?")){
                        window.open(url,"_self");
                }
            }
        </script>
        <title>Visualização Completa</title>
    </head>
    <body>
       <% 
                ArrayList<Cliente> lista = new ArrayList();
                    try{
                        Cliente cliente = new Cliente();                    
                        lista = cliente.findAll();
                    }catch(Exception e){
                        out.print("Erro:"+e);
                    }
            %>
            <h1 class="nav navbar-text"> <%= nome %></h1>
            <br>
            <a class="btn btn-dark" href="listarFuncionarios.jsp"> &lt; Voltar</a>
            <br><br>
        <div class="nav navbar">
            <div class="col-12">
                <table class="text-center table table-bordered col-md-6" id="dataTable">

                    <%
                        for(Cliente cliente2:lista){
                            if(cliente2.getId() == (Integer.parseInt(id))){
                            %>
                            <tr>
                                <th> Nome Fantasia: </th><td><%= cliente2.getNomeFantasia()%></td>
                            </tr>
                            <tr>
                                <th> CNPJ: </th><td><%= cliente2.getCnpj()%></td>
                            </tr>
                            <tr>
                                <th> Serviço Contratado: </th><td><%= cliente2.getServicoContratado()%></td>
                            </tr>
                            <tr>
                                <th> Telefone: </th><td><%= cliente2.getTelefone()%></td>
                            </tr>
                            <tr>
                                <th> E-mail: </th><td><%= cliente2.getEmail()%></td>
                            </tr><tr>
                                <th> Descrição: </th><td><%= cliente2.getDescricao()%></td>
                            </tr>
                    <%
                            }
                        }
                    %>
                </table>
            </div>
            
                <div class="col-12">
                    <center>
                    <a class="btn btn-primary " href="alterarFuncionario.jsp?id=<%=id%>" >  Alterar  </a>
                    <a class="btn btn-primary " href="#" onclick="excluir('<%= nome %>', <%= id %>)">  Excluir  </a>
                    </center>
                </div>
        </div>
        <!-- Bootstrap JavaScript-->
        <script src="resources/jquery/jquery.js"></script>
        <script src="resources/bootstrap/js/bootstrap.bundle.js"></script>
        <!-- JavaScript-->
        <script src="resources/jquery-easing/jquery.easing.js"></script>
    </body>
</html>
