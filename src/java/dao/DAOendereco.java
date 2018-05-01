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
import model.Endereco;

/**
 *
 * @author Nando Luzy
 */
public class DAOendereco {
    private final Connection con;
        private PreparedStatement pstm = null;
    
    public DAOendereco(){
        con = ConnectionDB.openConnection();
    }
       
    //Create (Salvar)
    public boolean save(Endereco endereco){
        
        String sql = "INSERT INTO cliente (cep, endereco, uf, complemento) VALUES (?,?,?,?);";
        
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, endereco.getCep());
            pstm.setString(2, endereco.getEndereco());
            pstm.setString(4, endereco.getUf());
            pstm.setString(3, endereco.getCompletento());
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
    public ArrayList<Endereco> findAll(){
        
        ArrayList<Endereco> listaDeEndereco = new ArrayList();
        
        String sql = "SELECT * FROM cliente;";
        
        try {
            pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                
                Endereco endereco = new Endereco();
                endereco.setId(rs.getInt("idEndereco"));
                endereco.setCep(rs.getString("cep"));
                endereco.setEndereco(rs.getString("endereco"));
                endereco.setUf(rs.getString("uf"));
                endereco.setCompletento(rs.getString("complemento"));
                
                listaDeEndereco.add(endereco);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao buscar: " + ex);
        }
        ConnectionDB.closeConnection(con);
        return listaDeEndereco;
    }
    
    public Endereco findForID(int id){
        Endereco endereco = new Endereco();
        String sql = "SELECT * FROM endereco WHERE idEndereco = ?;";
        try {
            pstm = con.prepareStatement(sql);
            
            pstm.setInt(1, id);
            
            ResultSet rs = pstm.executeQuery();  
            endereco.setId(rs.getInt("idEndereco"));
            endereco.setCep(rs.getString("cep"));
            endereco.setEndereco(rs.getString("endereco"));
            endereco.setUf(rs.getString("uf"));
            endereco.setCompletento(rs.getString("complemento"));
                
            
        } catch (SQLException ex) {
            System.err.println("Erro ao buscar: " + ex);
        }finally{
            ConnectionDB.closeConnection(con, pstm);
        }
        
        return endereco;
    }
    
    //Update (Alterar)
    public boolean update(Endereco endereco){
        String sql = "UPDATE endereco SET "
                + "cep = ?,"
                + "endereco = ?,"
                + "uf = ?,"
                + "complemento = ?"
                + "WHERE idEndereco = ?;";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, endereco.getCep());
            pstm.setString(2, endereco.getEndereco());
            pstm.setString(3, endereco.getUf());
            pstm.setString(4, endereco.getCompletento());
            pstm.setInt(5, endereco.getId());
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
    public boolean delete(Endereco endereco){
        String sql = "DELETE FROM endereco WHERE idEndereco = ?;";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, endereco.getId());
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
