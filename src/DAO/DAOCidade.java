/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexoes.ConexaoMySql;
import java.util.ArrayList;
import javax.swing.JComboBox;
import model.ModelCidade;
import model.ModelEstado;

/**
 *
 * @author levif
 */
public class DAOCidade extends ConexaoMySql{
    
    ModelCidade modelCidade = new ModelCidade();
    
    /**
     * Retonar a lista de cidades cadastradas no banco
     * @return ArrayLista<ModelCidade>
     */
    public ArrayList<ModelCidade> retornarListaModelCidade(){
        
        ArrayList<ModelCidade> listaModelCidade = new ArrayList<>();
        ModelCidade modelCidade = new ModelCidade();
        
        try {
            this.conectar();
            this.executarSQL("SELECT "
            + "cid_cod, "
            + "cid_nome "
            + "FROM tb_cidade"
            + ";"
            );
            
        while(this.getResultSet().next()){
            modelCidade = new ModelCidade();
            
            modelCidade.setIdCidade(this.getResultSet().getInt(1));
            modelCidade.setCidNome(this.getResultSet().getString(2));           
            listaModelCidade.add(modelCidade);
            
        }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaModelCidade;
    }
    
}
