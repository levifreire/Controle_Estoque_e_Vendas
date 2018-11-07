/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOprodutos;
import java.util.ArrayList;
import model.ModelProdutos;

/**
 *
 * @author levif
 */
public class ControllerProdutos {
    
    private DAOprodutos daoProdutos = new DAOprodutos();
    
    /**
     * Salvar um produto
     * @param pModelProdutos
     * @return int
     */
    public int salvarProdutoController(ModelProdutos pModelProdutos){
        return this.daoProdutos.salvarProdutosDAO(pModelProdutos);
        
    }
    
    /**
     * Excluir um produto
     * @param pIdProduto
     * @return boolean
     */
    public boolean excluirProdutoController(int pIdProduto){
        return this.daoProdutos.excluirProdutoDAO(pIdProduto);
    }
    
    /**
     * Alterar produto
     * @param pModelProduto
     * @return boolean
     */
    public boolean alterarProdutoController(ModelProdutos pModelProduto){
        return this.daoProdutos.alterarProdutoDAO(pModelProduto);
    }
    
    /**
     * Retornar um produto
     * @param pIdProduto
     * @return ModelProduto
     */
    public ModelProdutos retornarProdutoController(int pIdProduto){
        return this.daoProdutos.retornarProdutoDAO(pIdProduto);
    }
    
    public ModelProdutos retornarProdutoController(String pNomeProduto){
        return this.daoProdutos.retornarProdutoDAO(pNomeProduto);
    }
    
    /**
     * retornar um ArrayList de produto
     * @return 
     */
    public ArrayList<ModelProdutos> retornarListaProdutoController(){
        return this.daoProdutos.retornarListaProdutoDAO();
    }

    /**
     * ALTERAR LISTA DE PRODUTOS NO BANCO
     * @param plistaModelProduto
     * @return 
     */
    public boolean alterarEstoqueProdutosController(ArrayList<ModelProdutos> plistaModelProduto) {
        return this.daoProdutos.alterarEstoqueProdutosDAO(plistaModelProduto);
    }
    
}
