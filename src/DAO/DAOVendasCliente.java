/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexoes.ConexaoMySql;
import java.util.ArrayList;
import model.ModelClientes;
import model.ModelVendas;
import model.ModelVendasCliente;

/**
 *
 * @author levif
 */
public class DAOVendasCliente extends ConexaoMySql{
    
    
    public ArrayList<ModelVendasCliente> getListaVendasDAO(){
        
        ArrayList<ModelVendasCliente> listaModelVendasCliente = new ArrayList();
        ModelVendas modelVendas = new ModelVendas();
        ModelClientes modelCliente = new ModelClientes();
        ModelVendasCliente modelVendasCliente = new ModelVendasCliente(); 
        
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "tb_vendas.pk_id_vendas, "
                    + "tb_vendas.fk_cliente, "
                    + "tb_vendas.ven_data_venda, "
                    + "tb_vendas.ven_valorLiquido, "
                    + "tb_vendas.ven_valorBruto, "
                    + "tb_vendas.ven_desconto, "
                    + "tb_clientes.pk_id_cliente, "
                    + "tb_clientes.cli_nome, "
                    + "tb_clientes.cli_endereco, "
                    + "tb_clientes.cli_bairro, "
                    + "tb_clientes.cli_cidade, "
                    + "tb_clientes.cli_uf, "
                    + "tb_clientes.cli_cep, "
                    + "tb_clientes.cli_telefone, "
                    + "tb_clientes.cli_cpf "
                    + "FROM "
                    + "tb_vendas INNER JOIN tb_clientes "
                    + "ON tb_clientes.pk_id_cliente = tb_vendas.fk_cliente"
                    + ";"
            );

            while(this.getResultSet().next()){
                //ZERANDO AS INFORMAÇÕES
                modelVendas = new ModelVendas();
                modelCliente = new ModelClientes();
                modelVendasCliente = new ModelVendasCliente();
                
                //VENDA
                modelVendas.setIdVenda(this.getResultSet().getInt(1));
                modelVendas.setCliente(this.getResultSet().getInt(2));
                modelVendas.setVendaDataVenda(this.getResultSet().getDate(3));
                modelVendas.setVendaValorLiquido(this.getResultSet().getDouble(4));
                modelVendas.setVendaValorBruto(this.getResultSet().getDouble(5));
                modelVendas.setVendaDesconto(this.getResultSet().getDouble(6));
                
                //CLIENTE
                modelCliente.setIdCliente(this.getResultSet().getInt(1));
                modelCliente.setCliNome(this.getResultSet().getString(2));
                modelCliente.setCliEndereco(this.getResultSet().getString(3));
                modelCliente.setCliBairro(this.getResultSet().getString(4));
                modelCliente.setCliCidade(this.getResultSet().getString(5));
                modelCliente.setCliUf(this.getResultSet().getString(6));
                modelCliente.setCliCep(this.getResultSet().getString(7));
                modelCliente.setCliTelefone(this.getResultSet().getString(8));
                modelCliente.setCliCpfCnpj(this.getResultSet().getString(9));
                
                modelVendasCliente.setModelVendas(modelVendas);
                modelVendasCliente.setModelClientes(modelCliente);
                
                listaModelVendasCliente.add(modelVendasCliente);
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listaModelVendasCliente;
    }
    
}
