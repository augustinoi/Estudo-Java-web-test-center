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
import model.Perfil;

/**
 *
 * @author Nando Luzy
 */
public class DAOperfil {
    private final Connection con;
    private PreparedStatement pstm = null;
    
    public DAOperfil(){
        con = ConnectionDB.openConnection();
    }
       
    //Create (Salvar)
    public boolean save(Perfil perfil){
        
        String sql = "INSERT INTO perfil (perfil) VALUES (?);";
        
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, perfil.getPerfil());
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
    public ArrayList<Perfil> findAll(){
        
        ArrayList<Perfil> listaDePerfil = new ArrayList();
        
        String sql = "SELECT * FROM usuario;";
        
        try {
            pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                Perfil perfil = new Perfil();
                
                perfil.setId(rs.getInt("idPerfil"));
                perfil.setPerfil(rs.getString("PERFIL"));
                listaDePerfil.add(perfil);
            }
            
            ConnectionDB.closeConnection(con, pstm, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao buscar: " + ex);
        }
        
        return listaDePerfil;
    }
    
    public Perfil findForID(int id){
        Perfil perfil = new Perfil();
        String sql = "SELECT * FROM perfil WHERE idPERFIL = ?;";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            
            ResultSet rs = pstm.executeQuery();
            
            perfil.setId(rs.getInt("idPerfil"));
            perfil.setPerfil(rs.getString("PERFIL"));
            
            ConnectionDB.closeConnection(con, pstm, rs); //fecha
            
        } catch (SQLException ex) {
            System.err.println("Erro ao buscar: " + ex);
        }
        return perfil;
    }
    
    //Update (Alterar)
    public boolean update(Perfil perfil){
        String sql = "UPDATE perfil SET PERFIL = ? WHERE idPERFIL = ?;";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, perfil.getPerfil());
            pstm.setInt(2, perfil.getId());
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
    public boolean delete(Perfil perfil){
        String sql = "DELETE FROM perfil WHERE idPERFIL = ?;";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, perfil.getId());
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
