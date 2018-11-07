/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOCidade;
import java.util.ArrayList;
import javax.swing.JComboBox;
import model.ModelCidade;
import model.ModelEstado;

/**
 *
 * @author levif
 */
public class ControllerCidade {
    
    DAOCidade daoCidade = new DAOCidade();
    
    public ArrayList<ModelCidade> retornarListaCidadeController(){
        return this.daoCidade.retornarListaModelCidade();
    }
    
    
}
