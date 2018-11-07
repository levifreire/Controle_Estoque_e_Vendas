/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author levif
 */
public class ModelVendasCliente {
    
    private ModelVendas modelVendas;
    private ModelClientes modelClientes;
    private ArrayList<ModelVendasCliente> listaModelVendasCLiente;

    /**
     * @return the modelVendas
     */
    public ModelVendas getModelVendas() {
        return modelVendas;
    }

    /**
     * @param modelVendas the modelVendas to set
     */
    public void setModelVendas(ModelVendas modelVendas) {
        this.modelVendas = modelVendas;
    }

    /**
     * @return the modelClientes
     */
    public ModelClientes getModelClientes() {
        return modelClientes;
    }

    /**
     * @param modelClientes the modelClientes to set
     */
    public void setModelClientes(ModelClientes modelClientes) {
        this.modelClientes = modelClientes;
    }

    /**
     * @return the listaModelVendasCLiente
     */
    public ArrayList<ModelVendasCliente> getListaModelVendasCLiente() {
        return listaModelVendasCLiente;
    }

    /**
     * @param listaModelVendasCLiente the listaModelVendasCLiente to set
     */
    public void setListaModelVendasCLiente(ArrayList<ModelVendasCliente> listaModelVendasCLiente) {
        this.listaModelVendasCLiente = listaModelVendasCLiente;
    }
    
    
    
    
}
