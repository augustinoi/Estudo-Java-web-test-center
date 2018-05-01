/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nando Luz
 */
public class ConnectionDB {
    private static final String DRIVE = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/db_over_system";//ATENÇÃO! A PORTA PODE ALTERAR!
    private static final String USER = "root";
    private static final String PASS = "";
    
    
    //abre conexão com o banco.
    public static Connection openConnection(){
        try {
            Class.forName(DRIVE);
            return DriverManager.getConnection(URL, USER, PASS);
            
                    } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão!", ex);
        }
    }
    
    //fecha conexão com o banco - Sobrecarga.
    public static void closeConnection(Connection con){
        if (con != null){
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println("Erro ao fechar a conexão: "+ ex);
            }
        }
    }
    public static void closeConnection(Connection con, PreparedStatement pstm){
        if (pstm != null){
            try {
                pstm.close();
            } catch (SQLException ex) {
                System.err.println("Erro ao fechar a conexão: "+ ex);
            }
        }
        closeConnection(con);
    }
    public static void closeConnection(Connection con, PreparedStatement pstm, ResultSet rs){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException ex) {
                System.err.println("Erro ao fechar a conexão: "+ ex);
            }
        }
        closeConnection(con, pstm);
        
    }
}
