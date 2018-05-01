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
import model.Funcionario;

/**
 *
 * @author Nando Luzy
 */
public class DAOfuncionario {
    private final Connection con;
    private PreparedStatement pstm = null;
    
    public DAOfuncionario(){
        con = ConnectionDB.openConnection();
    }
       
    //Create (Salvar)
    public boolean save(Funcionario funcionario){
        
        String sql = "INSERT INTO funcionario (cpf, nome, rg, sexo, cargo, telefone, email) VALUES (?,?,?,?,?,?,?);";
        
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, funcionario.getCpf());
            pstm.setString(2, funcionario.getNome());
            pstm.setString(3, funcionario.getRg());
            //pstm.setString(4, funcionario.getDataDeNascimento());
            pstm.setString(4, funcionario.getSexo());
            pstm.setString(5, funcionario.getCargo());
            pstm.setString(6, funcionario.getTelefone());
            pstm.setString(7, funcionario.getEmail());
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
    public ArrayList<Funcionario> findAll(){
        
        ArrayList<Funcionario> listaDeFuncionario = new ArrayList();
        
        String sql = "SELECT * FROM Funcionario;";
        
        try {
            pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                Funcionario funcionario = new Funcionario();
                
                funcionario.setId(rs.getInt("idFuncionario"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setRg(rs.getString("rg"));
                //funcionario.setDataDeNascimento(rs.getDate(null, "data_de_nascimento"));
                funcionario.setSexo(rs.getString("sexo"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setEmail(rs.getString("email"));
                
                listaDeFuncionario.add(funcionario);
            }
            ConnectionDB.closeConnection(con, pstm, rs);//fecha conexões
        } catch (SQLException ex) {
            System.err.println("Erro ao buscar: " + ex);
        }
        
        return listaDeFuncionario;
    }
    
    public Funcionario findForID(int id){
        Funcionario funcionario = new Funcionario();
        String sql = "SELECT * FROM funcionario WHERE idFuncionario = ?;";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                funcionario.setId(rs.getInt("idFuncionario"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setRg(rs.getString("rg"));
    //            funcionario.setDataDeNascimento(rs.getString("data_de_nascimento"));
                funcionario.setSexo(rs.getString("sexo"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setEmail(rs.getString("email"));
            }
            ConnectionDB.closeConnection(con, pstm, rs);//fecha conexões
            
        } catch (SQLException ex) {
            System.err.println("Erro ao buscar: " + ex);
        }
        
        return funcionario;
    }
    
    //Update (Alterar)
    public boolean update(Funcionario funcinario){
        String sql = "UPDATE funcionario SET"
                + "cpf = ?,"
                + "nome = ?,"
                + "rg = ?,"
                + "sexo = ?,"
                + "cargo = ?,"
                + "telefone = ?,"
                + "email = ?"
                + "WHERE idUSUARIO = ?;";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, funcinario.getCpf());
            pstm.setString(2, funcinario.getNome());
            pstm.setString(3, funcinario.getRg());
//            pstm.setString(4, funcinario.getDataDeNascimento());
            pstm.setString(4, funcinario.getSexo());
            pstm.setString(5, funcinario.getCargo());
            pstm.setString(6, funcinario.getTelefone());
            pstm.setString(7, funcinario.getEmail());
            pstm.setInt(8, funcinario.getId());
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
    public boolean delete(Funcionario funcionario){
        String sql = "DELETE FROM Funcionario WHERE idFuncionario = ?;";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, funcionario.getId());
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
