<%-- 
    Document   : listarFuncionarios
    Created on : 04/04/2018, 20:48:05
    Author     : Administrador
--%>

<%@page import="model.Funcionario"%>
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
                ArrayList<Funcionario> lista = new ArrayList();
                    try{
                        Funcionario funcionario = new Funcionario();                    
                        lista = funcionario.findAll();
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
                        for(Funcionario funcionario2:lista){
                            if(funcionario2.getId() == (Integer.parseInt(id))){
                            %>
                            <tr>
                                <th> Nome: </th><td><%= funcionario2.getNome()%></td>
                            </tr>
                            <tr>
                                <th> CPF: </th><td><%= funcionario2.getCpf()%></td>
                            </tr>
                            <tr>
                                <th> RG: </th><td><%= funcionario2.getRg()%></td>
                            </tr>
                            <tr>
                                <th> Cargo: </th><td><%= funcionario2.getCargo()%></td>
                            </tr>
                            <tr>
                                <th> Sexo: </th><td><%= funcionario2.getSexo()%></td>
                            </tr>
                            <tr>
                                <th> Telefone: </th><td><%= funcionario2.getTelefone()%></td>
                            </tr>
                            <tr>
                                <th> E-mail: </th><td><%= funcionario2.getEmail()%></td>
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
