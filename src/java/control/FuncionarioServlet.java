/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Funcionario;

/**
 *
 * @author Nando Luz
 */
@WebServlet(name = "NewServlet", urlPatterns = {"/NewServlet"})
public class FuncionarioServlet extends HttpServlet {

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
            out.println("<title>Servlet FuncionarioServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            //declaração de variaveis que recebem por parametro os valores.
            String option = request.getParameter("option");
            String id = request.getParameter("id");
            String cpf = request.getParameter("cpf");
            String nome = request.getParameter("nome");
            String rg = request.getParameter("rg");
            String data_de_nascimento = request.getParameter("data_de_nascimento");
            String sexo = request.getParameter("sexo");
            String cargo = request.getParameter("cargo");
            String telefone = request.getParameter("telefone");
            String email = request.getParameter("email");
            
            Funcionario funcionario = new Funcionario();
            
            funcionario.setCpf(cpf);
            funcionario.setNome(nome);
            funcionario.setRg(rg);
            //funcionario.setDataDeNascimento(dataDeNascimento);
            funcionario.setSexo(sexo);
            funcionario.setCargo(cargo);
            funcionario.setTelefone(telefone);
            funcionario.setEmail(email);
            
            //Decisão de qual metodo CRUD usar.
            switch(option){
                case "insert":{
                    funcionario.insert();
                    response.sendRedirect("funcionario.jsp");
                }
                break;
                
                
                case "update":{
                    funcionario.setId(Integer.parseInt(id));
                    funcionario.update();
                    response.sendRedirect("funcionario.jsp");
                }
                break;
                
                
                case "delete":{
                    funcionario.setId(Integer.parseInt(id));
                    funcionario.delete();
                    response.sendRedirect("funcionario.jsp");
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
            Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
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
