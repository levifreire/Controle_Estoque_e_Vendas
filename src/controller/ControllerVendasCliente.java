/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOVendasCliente;
import java.util.ArrayList;
import model.ModelVendasCliente;

/**
 *
 * @author levif
 */
public class ControllerVendasCliente {
    
    DAOVendasCliente daoVendasCliente = new DAOVendasCliente();
    
    /**
     * Retornar uma lista de VendasCliente
     * @return 
     */
    public ArrayList<ModelVendasCliente> retornarModelVendasCliente(){
        
        return this.daoVendasCliente.getListaVendasDAO();
        
    }
    
}
