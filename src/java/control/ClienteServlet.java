/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;

/**
 *
 * @author Nando Luzy
 */
@WebServlet(name = "NewServlet", urlPatterns = {"/NewServlet"})
public class ClienteServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Usuario</title>");            
            out.println("</head>");
            out.println("<body>");            
            //declaração de variaveis que recebem por parametro os valores.
            String option = request.getParameter("option");
            
            String nome_fatasia = request.getParameter("nome_fantasia");
            String cnpj = request.getParameter("cnpj");
            String servico_contratado = request.getParameter("servico_contratado");
            String endereco = request.getParameter("endereco");
            String telefone = request.getParameter("telefone");
            String email = request.getParameter("email");
            String descricao = request.getParameter("descricao");
            
            String id = request.getParameter("id");
            
            Cliente cliente = new Cliente();
            
            cliente.setNomeFantasia(nome_fatasia);
            cliente.setCnpj(cnpj);
            cliente.setServicoContratado(servico_contratado);
            cliente.setEndereco(endereco);
            cliente.setTelefone(telefone);
            cliente.setEmail(email);
            cliente.setDescricao(descricao);
            
            //Decisão de qual metodo CRUD usar.
            switch(option){
                case "insert":{
                    cliente.insert();
                    response.sendRedirect("cliente.jsp");
                }
                break;
                
                
                case "update":{
                    cliente.setId(Integer.parseInt(id));
                    cliente.update();
                    response.sendRedirect("cliente.jsp");
                }
                break;
                
                
                case "delete":{
                    cliente.setId(Integer.parseInt(id));
                    cliente.delete();
                    response.sendRedirect("cliente.jsp");
                }
                break;
                        
            }
            
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            System.err.println("Servlet erro: " + ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            System.err.println("Servlet erro: " + ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
