/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.DAOendereco;
import java.util.ArrayList;

/**
 *
 * @author Nando Luzy
 */
public class Endereco {
    
    private Cliente cliente;
    private Funcionario funcionario;
    private int id;
    private String cep;
    private String endereco;
    private String uf;
    private String completento;

    public Endereco(Cliente cliente, Funcionario funcionario, int id, String cep, String endereco, String uf, String completento) {
        this.id = id;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.cep = cep;
        this.endereco = endereco;
        this.uf = uf;
        this.completento = completento;
    }

    public Endereco(){
        
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCompletento() {
        return completento;
    }

    public void setCompletento(String completento) {
        this.completento = completento;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
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
        DAOendereco dao = new DAOendereco();
        dao.save(this);
    }
    //Read
    public ArrayList<Endereco> findAll() throws Exception{   
        DAOendereco dao = new DAOendereco();
        return dao.findAll();
    }
    public void findForID() throws Exception{
        DAOendereco dao = new DAOendereco();
        this.setCep(dao.findForID(this.getId()).getCep());
        this.setEndereco(dao.findForID(this.getId()).getEndereco());
        this.setUf(dao.findForID(this.getId()).getUf());
        this.setCompletento(dao.findForID(this.getId()).getCompletento());
    }
    //Update
    public void update() throws Exception{ 
        DAOendereco dao = new DAOendereco();
        dao.update(this);
    }
    //Delete
    public void delete() throws Exception{
        DAOendereco dao = new DAOendereco();
        dao.delete(this);
    }

    
}
