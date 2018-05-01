/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Servico;

/**
 *
 * @author Nando Luz
 */
public class DAOservico {
     private final Connection con;
        private PreparedStatement pstm = null;
    
    public DAOservico(){
        con = ConnectionDB.openConnection();
    }
       
    //Create (Salvar)
    public boolean save(Servico servico){
        
        String sql = "INSERT INTO servico (tipo, valor, data_inicial, data_final) VALUES (?,?,?,?);";
        
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, servico.getTipo());
            pstm.setDouble(2, servico.getValor());
            pstm.setDate(3, (Date) servico.getData_inicial());
            pstm.setDate(4, (Date) servico.getData_final());
           
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
    public ArrayList<Servico> findAll(){
        
        ArrayList<Servico> listaDeClientes = new ArrayList();
        
        String sql = "SELECT * FROM servico;";
        
        try {
            pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                Servico servico = new Servico();
                servico.setId(rs.getInt("idServico"));
                servico.setTipo(rs.getString("tipo"));
                servico.setValor(rs.getDouble("valor"));
                servico.setData_inicial(rs.getDate("data_inicial"));
                servico.setData_final(rs.getDate("data_final"));
                
                listaDeClientes.add(servico);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao buscar: " + ex);
        }
        ConnectionDB.closeConnection(con);
        return listaDeClientes;
    }
    
    public Servico findForID(int id){
        Servico servico = new Servico();
        String sql = "SELECT * FROM servico WHERE idServico = ?;";
        try {
            pstm = con.prepareStatement(sql);
            
            pstm.setInt(1, id);
            
            ResultSet rs = pstm.executeQuery();            
                servico.setId(rs.getInt("idServico"));
                servico.setTipo(rs.getString("tipo"));
                servico.setValor(rs.getDouble("valor"));
                servico.setData_inicial(rs.getDate("data_inicial"));
                servico.setData_final(rs.getDate("data_final"));
            
        } catch (SQLException ex) {
            System.err.println("Erro ao buscar: " + ex);
        }finally{
            ConnectionDB.closeConnection(con, pstm);
        }
        
        return servico;
    }
    
    //Update (Alterar)
    public boolean update(Servico servico){
        String sql = "UPDATE servico SET "
                + "tipo = ?,"
                + "valor = ?,"
                + "data_inicial = ?,"
                + "data_final = ?,"
                + "email = ?,"
                + "descricao = ?"
                + "WHERE idcliente = ?;";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, servico.getTipo());
            pstm.setDouble(2, servico.getValor());
            pstm.setDate(3, (Date) servico.getData_inicial());
            pstm.setDate(4, (Date) servico.getData_final());
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
    public boolean delete(Servico servico){
        String sql = "DELETE FROM servico WHERE idServico = ?;";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, servico.getId());
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
