/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author levif
 */
public class ModelCidade {
    
    private int idCidade;
    private String cidNome;
    private ModelEstado codEstadoCidade;

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public String getCidNome() {
        return cidNome;
    }

    public void setCidNome(String cidNome) {
        this.cidNome = cidNome;
    }

    public ModelEstado getCodEstadoCidade() {
        return codEstadoCidade;
    }

    public void setCodEstadoCidade(ModelEstado codEstadoCidade) {
        this.codEstadoCidade = codEstadoCidade;
    }
    
    
    
}
