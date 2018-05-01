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
import model.SaidaProduto;
import model.Produto;

/**
 *
 * @author Nando Luzy
 */
public class DAOsaidaProduto {
private final Connection con;
    private PreparedStatement pstm = null;
    
    public DAOsaidaProduto(){
        con = ConnectionDB.openConnection();
    }

    //Create (Salvar)
    public boolean save(SaidaProduto saidadaproduto) {
        String sql = "INSERT INTO SAIDA_PRODUTO (QUANT,VALOR_UNIT,DATA_SAIDA) VALUES (?,?,?);";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, saidadaproduto.getQuantidade());
            pstm.setDouble(2, saidadaproduto.getValorUnitario());
            pstm.setDate(3, saidadaproduto.getDataSaida());
            pstm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao salvar: " + ex);
            return false;
        } finally {
            ConnectionDB.closeConnection(con, pstm);
        }
    }

    //Read (Ler)
    public ArrayList<Produto> findAll() {

        ArrayList<Produto> listaDeProdutos = new ArrayList();

        String sql = "SELECT * FROM SAIDA_PRODUTO;";

        try {
            pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Produto saidadaproduto = new Produto();

                saidadaproduto.setId(rs.getInt("idSAIDA_PRODUTO"));
                saidadaproduto.setNome(rs.getString("QUANT"));
                saidadaproduto.setStatus(rs.getString("VALOR_UNIT"));
                saidadaproduto.setCategoria(rs.getString("DATA_ENTRADA"));

                listaDeProdutos.add(saidadaproduto);
            }

            ConnectionDB.closeConnection(con, pstm, rs); //close conections
        } catch (SQLException ex) {
            System.err.println("Erro ao buscar: " + ex);
        }

        return listaDeProdutos;
    }

    public Produto findForID(int id) {

        Produto saidadaproduto = new Produto();
        String sql = "SELECT * FROM SAIDA_PRODUTO WHERE idSAIDA_PRODUTO = ?;";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);

            ResultSet rs = pstm.executeQuery();

            saidadaproduto.setId(rs.getInt("idSAIDA_PRODUTO"));
            saidadaproduto.setNome(rs.getString("QUANT"));
            saidadaproduto.setStatus(rs.getString("VALOR_UNIT"));
            saidadaproduto.setCategoria(rs.getString("DATA_ENTRADA"));
            ConnectionDB.closeConnection(con, pstm, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao buscar: " + ex);
        }

        return saidadaproduto;
    }

    //Update (Alterar)
    public boolean update(Produto saidadaproduto) {
        String sql = "UPDATE cliente SET "
                + "QUANT = ?,"
                + "VALOR_UNIT = ?,"
                + "DATA_ENTRADA = ?"
                + "WHERE idSAIDA_PRODUTO = ?;";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, saidadaproduto.getNome());
            pstm.setString(2, saidadaproduto.getStatus());
            pstm.setString(3, saidadaproduto.getCategoria());
            pstm.setInt(4, saidadaproduto.getId());
            pstm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao alterar: " + ex);
            return false;
        } finally {
            ConnectionDB.closeConnection(con, pstm);
        }
    }

    //Delete (Apagar)
    public boolean delete(Produto saidadaproduto) {
        String sql = "DELETE FROM SAIDA_PRODUTO WHERE idSAIDA_PRODUTO = ?;";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, saidadaproduto.getId());
            pstm.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao deletar: " + ex);
            return false;
        } finally {
            ConnectionDB.closeConnection(con, pstm);
        }

    }
}
