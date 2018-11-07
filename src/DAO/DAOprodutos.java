/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexoes.ConexaoMySql;
import java.util.ArrayList;
import model.ModelProdutos;

/**
 *
 * @author levif
 */
public class DAOprodutos extends ConexaoMySql{
    
    /**
     * Cadastrar um produto do banco
     * @param pModelProdutos
     * @return int
     */
    public int salvarProdutosDAO(ModelProdutos pModelProdutos){
        
        try {
            this.conectar();
            
            return this.insertSQL("INSERT INTO tb_produto ("
                    + "pro_nome, "
                    + "pro_valor, "
                    + "pro_estoque"
                    + ") VALUES ("
                    + "'" + pModelProdutos.getProNome() + "', "
                    + "'" + pModelProdutos.getProValor() + "', "
                    + "'" + pModelProdutos.getProEstoque() + "'"
                    + ");"            
            );
            
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
            
        } finally {
            this.fecharConexao();
        }
        
    }
    
    /**
     * Excluir um produto do banco
     * @param pIdProduto
     * @return int
     */
    public boolean excluirProdutoDAO(int pIdProduto){
        
        try {
            this.conectar();
            
            return this.executarUpdateDeleteSQL("DELETE FROM tb_produto where pk_id_produto = '"
            + pIdProduto +"';");
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
            
        } finally {
            this.fecharConexao();
        }
        
    }
    
    /**
     * Alterar dados do produto no banco
     * @param pModelProduto
     * @return boolean
     */
    public boolean alterarProdutoDAO(ModelProdutos pModelProduto){
        
        try {
            this.conectar();
            
            return this.executarUpdateDeleteSQL("UPDATE tb_produto SET "
            + "pro_nome = '" + pModelProduto.getProNome() + "', "
            + "pro_valor = '" + pModelProduto.getProValor() + "', "
            + "pro_estoque = '" + pModelProduto.getProEstoque() + "'"
            + " WHERE pk_id_produto = '" + pModelProduto.getIdProduto() + "';"
            );
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
            
        } finally {
            this.fecharConexao();
        }
    }
    
    /**
     * Retornar um produto do banco pelo Id
     * @param pIdProduto
     * @return ModelProdutos
     */
    public ModelProdutos retornarProdutoDAO(int pIdProduto){
            
        ModelProdutos modelProdutos = new ModelProdutos();
            
        try {
            this.conectar();
                
            this.executarSQL("SELECT pk_id_produto, "
                    + "pro_nome, "
                    + "pro_valor, "
                    + "pro_estoque "
                    + "FROM tb_produto WHERE pk_id_produto = '"
                    + pIdProduto + "';");
            
            while(this.getResultSet().next()){
                modelProdutos.setIdProduto(this.getResultSet().getInt(1));
                modelProdutos.setProNome(this.getResultSet().getString(2));
                modelProdutos.setProValor(this.getResultSet().getDouble(3));
                modelProdutos.setProEstoque(this.getResultSet().getInt(4));
            }
                
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelProdutos;
    }
    
    /**
     * Retornar um produto do banco pelo nome
     * @param pNomeProduto
     * @return ModelProdutos
     */
    public ModelProdutos retornarProdutoDAO(String pNomeProduto){
            
        ModelProdutos modelProdutos = new ModelProdutos();
            
        try {
            this.conectar();
                
            this.executarSQL("SELECT pk_id_produto, "
                    + "pro_nome, "
                    + "pro_valor, "
                    + "pro_estoque "
                    + "FROM tb_produto WHERE pro_nome = '"
                    + pNomeProduto + "';");
            
            while(this.getResultSet().next()){
                modelProdutos.setIdProduto(this.getResultSet().getInt(1));
                modelProdutos.setProNome(this.getResultSet().getString(2));
                modelProdutos.setProValor(this.getResultSet().getDouble(3));
                modelProdutos.setProEstoque(this.getResultSet().getInt(4));
            }
                
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelProdutos;
    }
    
    /**
     * Retornar uma lista completa de produtos do banco
     * @return listaModelProdutos
     */
    public ArrayList<ModelProdutos> retornarListaProdutoDAO(){
        ArrayList<ModelProdutos> listaModelProduto = new ArrayList<>();
        ModelProdutos modelProdutos = new ModelProdutos();
        
        try {
            this.conectar();
            
            this.executarSQL("SELECT pk_id_produto, "
            + " pro_nome, "
            + "pro_valor, "
            + "pro_estoque FROM tb_produto");
            
            while(this.getResultSet().next()){
                
                modelProdutos = new ModelProdutos();
                modelProdutos.setIdProduto(this.getResultSet().getInt(1));
                modelProdutos.setProNome(this.getResultSet().getString(2));
                modelProdutos.setProValor(this.getResultSet().getDouble(3));
                modelProdutos.setProEstoque(this.getResultSet().getInt(4));
                listaModelProduto.add(modelProdutos);               
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            this.fecharConexao();
        }
        return listaModelProduto;
    }

        /**
         * ALterar Estoque de produtos no banco
         * @param pListaModelProduto
         * @return 
         */
    public boolean alterarEstoqueProdutosDAO(ArrayList<ModelProdutos> pListaModelProduto){
        
        try {
            this.conectar();
            
            for (int i = 0; i < pListaModelProduto.size(); i++) {

                return this.executarUpdateDeleteSQL("UPDATE tb_produto SET "
                + "pro_estoque = '" + pListaModelProduto.get(i).getProEstoque() + "'"
                + " WHERE pk_id_produto = '" + pListaModelProduto.get(i).getIdProduto() + "';"
                );
            
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
            
        } finally {
            this.fecharConexao();
        }
        
    }
    
}
