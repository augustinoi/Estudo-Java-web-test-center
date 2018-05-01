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
import model.EntradaProduto;
import model.Produto;

/**
 *
 * @author Nando Luzy
 */
public class DAOentradaProduto {
     private final Connection con;
    private PreparedStatement pstm = null;
    
    public DAOentradaProduto(){
        con = ConnectionDB.openConnection();
    }
       
    //Create (Salvar)
    public boolean save(EntradaProduto entradaproduto){
          String sql = "INSERT INTO ENTRADA_PRODUTO (QUANT,VALOR_UNIT,DATA_SAIDA) VALUES (?,?,?);";
         try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, entradaproduto.getQuantidade());
            pstm.setDouble(2, entradaproduto.getValorUnitario());
            pstm.setDate(3, entradaproduto.getDataEntrada());
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
    public ArrayList<Produto> findAll(){
        
        ArrayList<Produto> listaDeProdutos = new ArrayList();
        
        String sql = "SELECT * FROM ENTRADA_PRODUTO;";
        
        try {
            pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
              Produto entradaproduto = new Produto();
                
                entradaproduto.setId(rs.getInt("idENTRADA_PRODUTO"));
                entradaproduto.setNome(rs.getString("QUANT"));
                entradaproduto.setStatus(rs.getString("VALOR_UNIT"));
                entradaproduto.setCategoria(rs.getString("DATA_ENTRADA"));
              
                listaDeProdutos.add(entradaproduto);
            }
            
            ConnectionDB.closeConnection(con, pstm, rs); //close conections
        } catch (SQLException ex) {
            System.err.println("Erro ao buscar: " + ex);
        }
        
        return listaDeProdutos;
    }
    
    public Produto findForID(int id){
        
        Produto entradaproduto = new Produto();
        String sql = "SELECT * FROM ENTRADA_PRODUTO WHERE idENTRADA_PRODUTO = ?;";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            
            ResultSet rs = pstm.executeQuery();
            
           entradaproduto.setId(rs.getInt("idENTRADA_PRODUTO"));
                entradaproduto.setNome(rs.getString("QUANT"));
                entradaproduto.setStatus(rs.getString("VALOR_UNIT"));
                entradaproduto.setCategoria(rs.getString("DATA_ENTRADA"));
            ConnectionDB.closeConnection(con, pstm, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao buscar: " + ex);
        }
        
        return entradaproduto;
    }
    
    //Update (Alterar)
    public boolean update(Produto entradaproduto){
        String sql = "UPDATE cliente SET "
                + "QUANT = ?,"
                + "VALOR_UNIT = ?,"
                + "DATA_ENTRADA = ?"
                + "WHERE idENTRADA_PRODUTO = ?;";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, entradaproduto.getNome());
            pstm.setString(2, entradaproduto.getStatus());
            pstm.setString(3, entradaproduto.getCategoria());
              pstm.setInt(4, entradaproduto.getId());
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
    public boolean delete(Produto entradaproduto){
        String sql = "DELETE FROM ENTRADA_PRODUTO WHERE idENTRADA_PRODUTO = ?;";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, entradaproduto.getId());
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
