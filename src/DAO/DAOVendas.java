package DAO;

import model.ModelVendas;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Levi Freire
*/
public class DAOVendas extends ConexaoMySql {

    /**
    * grava Vendas
    * @param pModelVendas
    * return int
    */
    public int salvarVendasDAO(ModelVendas pModelVendas){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO tb_vendas ("
                    + "fk_cliente,"
                    + "ven_data_venda,"
                    + "ven_valorLiquido,"
                    + "ven_valorBruto,"
                    + "ven_desconto"
                + ") VALUES ("
                    + "'" + pModelVendas.getCliente() + "', "
                    + "'" + pModelVendas.getVendaDataVenda() + "', "
                    + "'" + pModelVendas.getVendaValorLiquido() + "', "
                    + "'" + pModelVendas.getVendaValorBruto() + "', "
                    + "'" + pModelVendas.getVendaDesconto() + "'"
                + ");"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * recupera Vendas
    * @param pIdVenda
    * return ModelVendas
    */
    public ModelVendas getVendasDAO(int pIdVenda){
        ModelVendas modelVendas = new ModelVendas();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_id_vendas,"
                    + "fk_cliente,"
                    + "venda_data_venda,"
                    + "venda_valor_liquido,"
                    + "venda_valor_bruto,"
                    + "venda_desconto"
                 + " FROM"
                     + " tb_vendas"
                 + " WHERE"
                     + " pk_id_vendas = '" + pIdVenda + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelVendas.setIdVenda(this.getResultSet().getInt(1));
                modelVendas.setCliente(this.getResultSet().getInt(2));
                modelVendas.setVendaDataVenda(this.getResultSet().getDate(3));
                modelVendas.setVendaValorLiquido(this.getResultSet().getDouble(4));
                modelVendas.setVendaValorBruto(this.getResultSet().getDouble(5));
                modelVendas.setVendaDesconto(this.getResultSet().getDouble(6));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelVendas;
    }

    /**
    * recupera uma lista de Vendas
        * return ArrayList
    */
    public ArrayList<ModelVendas> getListaVendasDAO(){
        ArrayList<ModelVendas> listamodelVendas = new ArrayList();
        ModelVendas modelVendas = new ModelVendas();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_id_vendas,"
                    + "fk_cliente,"
                    + "venda_data_venda,"
                    + "venda_valor_liquido,"
                    + "venda_valor_bruto,"
                    + "venda_desconto"
                 + " FROM"
                     + " tb_vendas"
                + ";"
            );

            while(this.getResultSet().next()){
                modelVendas = new ModelVendas();
                modelVendas.setIdVenda(this.getResultSet().getInt(1));
                modelVendas.setCliente(this.getResultSet().getInt(2));
                modelVendas.setVendaDataVenda(this.getResultSet().getDate(3));
                modelVendas.setVendaValorLiquido(this.getResultSet().getDouble(4));
                modelVendas.setVendaValorBruto(this.getResultSet().getDouble(5));
                modelVendas.setVendaDesconto(this.getResultSet().getDouble(6));
                listamodelVendas.add(modelVendas);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelVendas;
    }

    /**
    * atualiza Vendas
    * @param pModelVendas
    * return boolean
    */
    public boolean atualizarVendasDAO(ModelVendas pModelVendas){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE tb_vendas SET "
                    + "pk_id_venda = '" + pModelVendas.getIdVenda() + "',"
                    + "fk_cliente = '" + pModelVendas.getCliente() + "',"
                    + "venda_data_venda = '" + pModelVendas.getVendaDataVenda() + "',"
                    + "venda_valor_liquido = '" + pModelVendas.getVendaValorLiquido() + "',"
                    + "venda_valor_bruto = '" + pModelVendas.getVendaValorBruto() + "',"
                    + "venda_desconto = '" + pModelVendas.getVendaDesconto() + "'"
                + " WHERE "
                    + "pk_id_vendas = '" + pModelVendas.getIdVenda() + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * exclui Vendas
    * @param pIdVenda
    * return boolean
    */
    public boolean excluirVendasDAO(int pIdVenda){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM tb_vendas "
                + " WHERE "
                    + "pk_id_vendas = '" + pIdVenda + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }
}