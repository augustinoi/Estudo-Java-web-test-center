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
import model.Menu;

/**
 *
 * @author Nando Luzy
 */
public class DAOmenu {
    private final Connection con;
    private PreparedStatement pstm = null;
    
    public DAOmenu(){
        con = ConnectionDB.openConnection();
    }
       
    //Create (Salvar)
    public boolean save(Menu menu){
        
        String sql = "INSERT INTO menu (menu, link, status, icon) VALUES (?,?,?,?);";
        
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, menu.getMenu());
            pstm.setString(2, menu.getLink());
            pstm.setString(3, menu.getStatus());
            pstm.setString(4, menu.getIcon());
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
    public ArrayList<Menu> findAll(){
        
        ArrayList<Menu> listaDeMenu = new ArrayList();
        
        String sql = "SELECT * FROM menu;";
        
        try {
            pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                Menu menu = new Menu();
                
                menu.setId(rs.getInt("idMENU"));
                menu.setMenu(rs.getString("MENU"));
                menu.setLink(rs.getString("LINK"));
                menu.setStatus(rs.getString("STATUS"));
                menu.setIcon(rs.getString("ICON"));
            }
            
            ConnectionDB.closeConnection(con, pstm, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao buscar: " + ex);
        }
        
        return listaDeMenu;
    }
    
    public Menu findForID(int id){
        Menu menu = new Menu();
        String sql = "SELECT * FROM menu WHERE idMENU = ?;";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                menu.setId(rs.getInt("idMENU"));
                menu.setMenu(rs.getString("MENU"));
                menu.setLink(rs.getString("LINK"));
                menu.setStatus(rs.getString("STATUS"));
                menu.setIcon(rs.getString("ICON"));
            }
            
            ConnectionDB.closeConnection(con, pstm, rs); //fecha
            
        } catch (SQLException ex) {
            System.err.println("Erro ao buscar: " + ex);
        }
        return menu;
    }
    
    //Update (Alterar)
    public boolean update(Menu menu){
        String sql = "UPDATE menu SET MENU = ?, LINK = ?, STATUS = ?, ICON = ? WHERE idMENU = ?;";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, menu.getMenu());
            pstm.setString(2, menu.getLink());
            pstm.setString(3, menu.getStatus());
            pstm.setString(4, menu.getIcon());
            pstm.setInt(5, menu.getId());
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
    public boolean delete(Menu menu){
        String sql = "DELETE FROM menu WHERE idMENU = ?;";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, menu.getId());
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
