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
import model.TipoProduto;

/**
 *
 * @author Nando Luzy
 */
public class DAOtipoProduto {
    private final Connection con;
    private PreparedStatement pstm = null;
    
    public DAOtipoProduto(){
        con = ConnectionDB.openConnection();
    }
       
    //Create (Salvar)
    public boolean save(TipoProduto tipoproduto){
        
        String sql = "INSERT INTO tipoProduto (categoria) VALUES (?);";
        
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, tipoproduto.getCategoria());
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
    public ArrayList<TipoProduto> findAll(){
        
        ArrayList<TipoProduto> listaDeProdutos = new ArrayList();
        
        String sql = "SELECT * FROM tipoProduto;";
        
        try {
            pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                TipoProduto tipoproduto = new TipoProduto();
                tipoproduto.setId(rs.getInt("idTipoProduto"));
                tipoproduto.setCategoria(rs.getString("categoria"));
                listaDeProdutos.add(tipoproduto);
            }
            
            ConnectionDB.closeConnection(con, pstm, rs); //close conections
        } catch (SQLException ex) {
            System.err.println("Erro ao buscar: " + ex);
        }
        
        return listaDeProdutos;
    }
    
    public TipoProduto findForID(int id){
        
        TipoProduto tipoproduto = new TipoProduto();
        String sql = "SELECT * FROM tipoProduto WHERE idTipoProduto = ?;";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            
            ResultSet rs = pstm.executeQuery();
            
            tipoproduto.setId(rs.getInt("idTipoProduto"));
            tipoproduto.setCategoria(rs.getString("categoria"));
            ConnectionDB.closeConnection(con, pstm, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao buscar: " + ex);
        }
        
        return tipoproduto;
    }
    
    //Update (Alterar)
    public boolean update(TipoProduto tipoproduto){
        String sql = "UPDATE tipoproduto SET categoria = ? WHERE idTipoPorduto = ?;";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, tipoproduto.getCategoria());
            pstm.setInt(2, tipoproduto.getId());
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
    public boolean delete(TipoProduto tipoproduto){
        String sql = "DELETE FROM tipoProduto WHERE idTipoProduto = ?;";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, tipoproduto.getId());
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
