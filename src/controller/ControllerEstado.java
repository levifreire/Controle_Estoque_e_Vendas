/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOEstado;
import java.util.ArrayList;
import model.ModelEstado;

/**
 *
 * @author levif
 */
public class ControllerEstado {
    
    private DAOEstado daoEstado = new DAOEstado();
    
    public ArrayList<ModelEstado> retornarListaEstadosController(){
        return this.daoEstado.retornarListaEstadosDAO();
    }
    
}
