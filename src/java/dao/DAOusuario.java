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
import model.Usuario;

/**
 * CRUD
 * @author Nando Luzy
 */
public class DAOusuario {    
    private final Connection con;
    private PreparedStatement pstm = null;
    
    public DAOusuario(){
        con = ConnectionDB.openConnection();
    }
       
    //Create (Salvar)
    public boolean save(Usuario usuario){
        
        String sql = "INSERT INTO usuario (username, senha) VALUES (?,?);";
        
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, usuario.getUsername());
            pstm.setString(2, usuario.getSenha());
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
    public ArrayList<Usuario> findAll(){
        
        ArrayList<Usuario> listaDeUsuarios = new ArrayList();
        
        String sql = "SELECT * FROM usuario;";
        
        try {
            pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                Usuario usuario = new Usuario();
                
                usuario.setId(rs.getInt("idUsuario"));
                usuario.setUsername(rs.getString("username"));
                usuario.setSenha(rs.getString("senha"));
                listaDeUsuarios.add(usuario);
            }
            
            ConnectionDB.closeConnection(con, pstm, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao buscar: " + ex);
        }
        
        return listaDeUsuarios;
    }
    
    public Usuario findForID(int id){
        Usuario usuario = new Usuario();
        String sql = "SELECT * FROM usuario WHERE idUsuario = ?;";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            
            ResultSet rs = pstm.executeQuery();
            
            usuario.setId(rs.getInt("idUsuario"));
            usuario.setUsername(rs.getString("username"));
            usuario.setSenha(rs.getString("senha"));
            
            ConnectionDB.closeConnection(con, pstm, rs); //fecha
            
        } catch (SQLException ex) {
            System.err.println("Erro ao buscar: " + ex);
        }
        return usuario;
    }
    
    //Update (Alterar)
    public boolean update(Usuario usuario){
        String sql = "UPDATE usuario SET USERNAME = ?, SENHA = ? WHERE idUSUARIO = ?;";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, usuario.getUsername());
            pstm.setString(2, usuario.getSenha());
            pstm.setInt(3, usuario.getId());
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
    public boolean delete(Usuario usuario){
        String sql = "DELETE FROM usuario WHERE idUSUARIO = ?;";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, usuario.getId());
            pstm.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao deletar: " + ex);
            return false;
        }finally{
            ConnectionDB.closeConnection(con, pstm);
        }
        
    }
    
    public boolean validar(String username, String senha){
        
        String sql = "SELECT * FROM USUARIO WHERE USERNAME = ? AND SENHA = ?;";
        Usuario usuario = new Usuario();
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, username);
            pstm.setString(2, senha);
            
            ResultSet rs = pstm.executeQuery();
            
            usuario.setId(rs.getInt("id"));
            usuario.setUsername(rs.getString("username"));
            usuario.setSenha(rs.getString("senha"));
            ConnectionDB.closeConnection(con, pstm, rs); //fecha
            return true;           
        } catch (SQLException ex) {
            System.err.println("Erro ao tentar buscar" + ex);
            return false;
        }
        
    }
}
