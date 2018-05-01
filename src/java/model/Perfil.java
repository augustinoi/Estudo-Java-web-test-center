/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.DAOperfil;
import java.util.ArrayList;

/**
 *
 * @author Nando Luzy
 */
public class Perfil {
    private int id;
    private String perfil;

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    /**
     * 
     * CHAMADA DA DAO
     * 
     * @throws Exception 
     */
    
    
    //Create
    public void insert() throws Exception{
        DAOperfil dao = new DAOperfil();
        dao.save(this);
    }
    //Read
    public ArrayList<Perfil> findAll() throws Exception{   
        DAOperfil dao = new DAOperfil();
        return dao.findAll();
    }
    
    public Perfil findForID(int id) throws Exception{
        DAOperfil dao = new DAOperfil();
        return dao.findForID(id);
    }
    //Update
    public void update() throws Exception{ 
        DAOperfil dao = new DAOperfil();
        dao.update(this);
    }
    //Delete
    public void delete() throws Exception{
        DAOperfil dao = new DAOperfil();
        dao.delete(this);
    }
}
