/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.DAOtipoProduto;
import java.util.ArrayList;

/**
 *
 * @author Nando Luzy
 */
public class TipoProduto {
    
    private int id;
    private String categoria;

    public TipoProduto(int id, String categoria) {
        this.id = id;
        this.categoria = categoria;
    }

    public TipoProduto(){
        
    }
    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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
        DAOtipoProduto dao = new DAOtipoProduto();
        dao.save(this);
    }
    //Read
    public ArrayList<TipoProduto> findAll() throws Exception{   
        DAOtipoProduto dao = new DAOtipoProduto();
        return dao.findAll();
    }
    
    public void findForID() throws Exception{
        DAOtipoProduto dao = new DAOtipoProduto();
        this.setId(dao.findForID(this.id).getId());
        this.setCategoria(dao.findForID(this.id).getCategoria());
    }
    //Update
    public void update() throws Exception{ 
        DAOtipoProduto dao = new DAOtipoProduto();
        dao.update(this);
    }
    //Delete
    public void delete() throws Exception{
        DAOtipoProduto dao = new DAOtipoProduto();
        dao.delete(this);
    }
    
}
