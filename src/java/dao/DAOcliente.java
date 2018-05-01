/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cliente;

/**
 *
 * @author Nando Luzy
 */
public class DAOcliente {
    private final Connection con;
    private PreparedStatement pstm = null;

    public DAOcliente(){
        con = ConnectionDB.openConnection();
    }
       
    //Create (Salvar)
    public boolean save(Cliente cliente){
        
        String sql = "INSERT INTO cliente (nome_fantasia, cnpj, servico_contratado, telefone, endereco, email, descricao) VALUES (?,?,?,?,?,?,?);";
        
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, cliente.getNomeFantasia());
            pstm.setString(2, cliente.getCnpj());
            pstm.setString(3, cliente.getServicoContratado());
            pstm.setString(4, cliente.getTelefone());
            pstm.setString(5, cliente.getEndereco());
            pstm.setString(6, cliente.getEmail());
            pstm.setString(7, cliente.getDescricao());
            pstm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao salvar: " + ex);
            return false;
        } finally{
            ConnectionDB.closeConnection(con, pstm);
        }
    }
    
    //Read (Ler)
    public ArrayList<Cliente> findAll(){
        
        ArrayList<Cliente> listaDeFuncionario = new ArrayList();
        
        String sql = "SELECT * FROM cliente;";
        
        try {
            pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                Cliente funcionario = new Cliente();
                
                funcionario.setId(rs.getInt("idCLIENTE"));
                funcionario.setNomeFantasia(rs.getString("NOME_FANTASIA"));
                funcionario.setCnpj(rs.getString("CNPJ"));
                funcionario.setServicoContratado(rs.getString("SERVICO_CONTRATADO"));
                funcionario.setTelefone(rs.getString("TELEFONE"));
                //funcionario.setEndereco(rs.getString("ENDERECO"));
                funcionario.setEmail(rs.getString("EMAIL"));
                funcionario.setDescricao(rs.getString("DESCRICAO"));
                
                listaDeFuncionario.add(funcionario);
            }
            ConnectionDB.closeConnection(con, pstm, rs);//fecha conexões
        } catch (SQLException ex) {
            System.err.println("Erro ao buscar: " + ex);
        }
        
        return listaDeFuncionario;
    }
    
    public Cliente findForID(int id){
        
        String sql = "SELECT * FROM cliente WHERE idCLIENTE = ?;";
        Cliente cliente = new Cliente();
        
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);            
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                
                cliente.setId(rs.getInt("idCLIENTE"));
                cliente.setNomeFantasia(rs.getString("NOME_FANTASIA"));
                cliente.setCnpj(rs.getString("CNPJ"));
                cliente.setServicoContratado(rs.getString("SERVICO_CONTRATADO"));
                cliente.setTelefone(rs.getString("TELEFONE"));
                //cliente.setEndereco(rs.getString("endereco"));
                cliente.setEmail(rs.getString("EMAIL"));
                cliente.setDescricao(rs.getString("DESCRICAO"));
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao buscar: " + ex);
        }finally{
            ConnectionDB.closeConnection(con, pstm);
        }
        
        return cliente;
    }
    
    //Update (Alterar)
    public boolean update(Cliente cliente){
        String sql = "UPDATE cliente SET "
                + "nome_fantasia = ?,"
                + "cnpj = ?,"
                + "servico_contratado = ?,"
                + "telefone = ?,"
                + "endereco = ?,"
                + "email = ?,"
                + "descricao = ?"
                + "WHERE idcliente = ?;";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, cliente.getNomeFantasia());
            pstm.setString(2, cliente.getCnpj());
            pstm.setString(3, cliente.getServicoContratado());
            pstm.setString(4, cliente.getTelefone());
            pstm.setString(5, cliente.getEndereco());
            pstm.setString(6, cliente.getEmail());
            pstm.setString(7, cliente.getDescricao());
            pstm.setInt(8, cliente.getId());
            pstm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao alterar: " + ex);
            return false;
        }finally{
            ConnectionDB.closeConnection(con, pstm);
        }
    }
    
    //Delete (Apagar)
    public boolean delete(Cliente cliente){
        String sql = "DELETE FROM cliente WHERE idCLIENTE = ?;";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, cliente.getId());
            pstm.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao deletar: " + ex);
            return false;
        }finally{
            ConnectionDB.closeConnection(con, pstm);
        }
        
    }
}
