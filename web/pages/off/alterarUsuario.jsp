<%-- 
    Document   : alterarUsuario
    Created on : 04/04/2018, 21:06:03
    Author     : Administrador
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Usuario"%>
<%
    String id = request.getParameter("id");
%>
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
        <title>Alterar Usuario</title>
    </head>
    <body>
        <h1 class="navbar navbar-text ">Alterar Usuario</h1>
        <br>
        <a class="btn btn-dark" href="listarUsuarios.jsp"> &lt; Voltar</a>
        <br>
        <br>
        <form class="navbar nav-tabs" method="post" action="gerenciar_usuario.do">
            <%
               ArrayList<Usuario> lista = new ArrayList();      

                try{
                    Usuario usuario = new Usuario();
                    lista = usuario.findAll();
                }catch(Exception e){
                    out.print("Erro:"+e);
                }

                for(Usuario usuario2:lista){
                    if(usuario2.getId() == Integer.parseInt(id)){
            %>
                        <table class="text-center ">                            
                            <tr>Username: <input type="text" name="username" size="50" placeholder="Username" value="<%= usuario2.getUsername() %>"></tr>
                           
                            <tr>Senha: <input type="password" name="pass" size="50" placeholder="Senha" value="<%= usuario2.getSenha() %>"></tr>
                            <br>
                            <tr>
                                <input type="hidden" name="option" value="update">
                                <input type="hidden" name="id" value="<%=usuario2.getId()%>">
                                <input type="submit" class="btn btn-success" value="Alterar Perfil">
                            </tr>                            
                        </table>
            <%
                    }
                }
            %>
        </form>
        
        <!-- Bootstrap JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
    </body>
</html>
