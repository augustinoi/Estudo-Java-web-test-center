<%-- 
    Document   : listarUsuario
    Created on : 04/04/2018, 20:46:35
    Author     : Administrador
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="dao.DAOusuario"%>
<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript">
            function excluir(nome,id){
                var url = "gerenciar_usuario.do?option=delete&id="+id;
                    if(confirm("Tem certeza que deseja excluir o perfil: "+nome+"?")){
                        window.open(url,"_self");
                }
            }
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--Stylo da pagina-->
        <link rel="stylesheet" href="../resources/bootstrap/css/bootstrap.css">
        <link rel="shortcut icon" href="../imagens/favicon/favicon.ico" type="image/x-icon" />
        <title>Lista de Usuarios</title>
    </head>
    <body>
        <h1 class="navbar navbar-text ">Usuarios</h1><br>
        
        <% 
            ArrayList<Usuario> lista = new ArrayList();
                try{
                    Usuario usuario = new Usuario();                    
                    lista = usuario.findAll();
                }catch(Exception e){
                    out.print("Erro:"+e);
                }
        %>
        <a class="btn btn-dark" href="home.jsp"> &lt; Voltar</a>
        <a class="btn btn-success" href="cadastrarUsuario.jsp">+Novo</a>
        <br><br>
        <table class="text-center table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <tr >
                        <th> Username</th>
                        <th> Opção   </th>
                    </tr>
            <%
                for(Usuario usuario1:lista){
                    %>
                    <tr>
                        <td>
                            <%=usuario1.getUsername() %>
                            <input type="hidden" value="<%= usuario1.getSenha() %>">
                        </td>
                        
                        <td>
                            <%
                                if(usuario1.getId() != 1 ){
                            %>
                                    <a class="btn btn-primary " href="alterarUsuario.jsp?id=<%=usuario1.getId()%>" >  Alterar  </a>
                                    <a class="btn btn-danger " href="#" onclick="excluir('<%= usuario1.getUsername()%>', <%= usuario1.getId() %>)">  Excluir  </a>
                                <%
                                }
                                %>
                        </td>
                    </tr>  
            <%
                }
            %>
        </table>
        <!-- Bootstrap JavaScript-->
        <script src="resources/jquery/jquery.js"></script>
        <script src="resources/bootstrap/js/bootstrap.bundle.js"></script>
        <!-- JavaScript-->
        <script src="resources/jquery-easing/jquery.easing.js"></script>
    </body>
</html>
