/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DaoClientes;
import java.util.ArrayList;
import model.ModelClientes;

/**
 *
 * @author LEVIOLIVEIRADEMENDON
 */
public class ControllerClientes {
    
    private DaoClientes daoClientes = new DaoClientes();
    
    /**
     * Salvar clientes controller
     * @param pModelClientes
     * @return 
     */
    public int salvarClienteController(ModelClientes pModelClientes){
        return this.daoClientes.salvarClientesDAO(pModelClientes);
    }
    
    /**
     * Excluir clientes Controller
     * @param pIdCliente
     * @return 
     */
    public boolean excluirClienteController(int pIdCliente){
        return this.daoClientes.excluirClienteDAO(pIdCliente);
    }
    
    /**
     * Alterar clientes Controller
     * @param pModelClientes
     * @return 
     */
    public boolean alterarCLienteController(ModelClientes pModelClientes){
        return this.daoClientes.alterarClienteDAO(pModelClientes);
    }
    
    /**
     * Retornar um cliente
     * @param pIdCliente
     * @return 
     */
    public ModelClientes retornarClienteController(int pIdCliente){
        return this.daoClientes.retornarClienteDAO(pIdCliente);
    }
    
    /**
     * Retornar um cliente
     * @param pNomeCliente
     * @return 
     */
    public ModelClientes retornarClienteController(String pNomeCliente){
        return this.daoClientes.retornarClienteDAO(pNomeCliente);
    }
    
    /**
     * Retornar uma lista de clientes
     * @return 
     */
    public ArrayList<ModelClientes> listarClienteController(){
        return this.daoClientes.listarClientesDAO();
    }
    
}
