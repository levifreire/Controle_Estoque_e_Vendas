/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexoes.ConexaoMySql;
import java.util.ArrayList;
import model.ModelEstado;

/**
 *Recupera o Estado
 * @author levif
 */
public class DAOEstado extends ConexaoMySql {
    
    /**
     * Retornar a lista de estados que esta no banco
     * @param pIdEstado
     * @return ArrayList<ModelEstado>
     */
    public ArrayList<ModelEstado> retornarListaEstadosDAO(){
        
        ArrayList<ModelEstado> listaModelEstados = new ArrayList<>();
        ModelEstado modelEstado = new ModelEstado();
        
        try {
            this.conectar();
            this.executarSQL("SELECT "
            + "est_cod, "
            + "est_sgl, "
            + "est_nome "
            + "FROM tb_estado;"
            );
            
        while(this.getResultSet().next()){
            modelEstado = new ModelEstado();
            
            modelEstado.setIdEstado(this.getResultSet().getInt(1));
            modelEstado.setEstSigla(this.getResultSet().getString(2));
            modelEstado.setEstNome(this.getResultSet().getString(3));
            listaModelEstados.add(modelEstado);
            
        }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        
        return listaModelEstados;
    }
    
}
