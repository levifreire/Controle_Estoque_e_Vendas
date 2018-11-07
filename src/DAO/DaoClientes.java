/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.ModelClientes;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
import model.ModelCidade;


/**
 * private String cliNome; private String cliEndereco; private String cliBairro;
 * private String cliCidade; private String cliUf; private String cliCep;
 * private String cliTelefone; private String cliCpfCnpj;
 *
 * @author LEVIOLIVEIRADEMENDON
 */
public class DaoClientes extends ConexaoMySql {

    /**
     * Cadastrar um cliente no banco
     *
     * @param pModelClientes
     * @param pModelCidade
     * @param pModelEstado
     * @return
     */
    public int salvarClientesDAO(ModelClientes pModelClientes) {

        try {

            this.conectar();

            return this.insertSQL("INSERT INTO tb_clientes ("
                    + "cli_nome,"
                    + "cli_endereco,"
                    + "cli_bairro,"
                    + "cli_cidade,"
                    + "cli_uf,"
                    + "cli_cep,"
                    + "cli_telefone,"
                    + "cli_cpf"                   
                    + ") VALUES ("
                    + "'" + pModelClientes.getCliNome() + "', "
                    + "'" + pModelClientes.getCliEndereco() + "', "
                    + "'" + pModelClientes.getCliBairro() + "', "
                    + "'" + pModelClientes.getCliCidade() + "', "
                    + "'" + pModelClientes.getCliUf() + "', "
                    + "'" + pModelClientes.getCliCep() + "', "
                    + "'" + pModelClientes.getCliTelefone() + "', "
                    + "'" + pModelClientes.getCliCpfCnpj() + "'"
                    + ");");

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * Excluir dados do cliente
     *
     * @param pIdProduto
     * @return
     */
    public boolean excluirClienteDAO(int pIdProduto) {

        try {

            this.conectar();

            return this.executarUpdateDeleteSQL("DELETE FROM tb_clientes WHERE pk_id_cliente = '" + pIdProduto + "'");

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }

    }

    /**
     * Alterar um cliente do banco
     *
     * @param pModelCliente
     * @return
     */
    public boolean alterarClienteDAO(ModelClientes pModelCliente) {

        try {
            this.conectar();

            return this.executarUpdateDeleteSQL("UPDATE tb_clientes set " + "cli_nome = '" + pModelCliente.getCliNome() + "', "
                    + "cli_endereco = '" + pModelCliente.getCliEndereco() + "', "
                    + "cli_bairro = '" + pModelCliente.getCliBairro() + "', "
                    + "cli_cidade = '" + pModelCliente.getCliCidade() + "', "
                    + "cli_uf = '" + pModelCliente.getCliUf() + "', "
                    + "cli_cep = '" + pModelCliente.getCliCep() + "', "
                    + "cli_telefone = '" + pModelCliente.getCliTelefone() + "', "
                    + "cli_cpf = '" + pModelCliente.getCliCpfCnpj() + "' "
                    + "WHERE pk_id_cliente = '" + pModelCliente.getIdCliente() + "'");

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }

    }

    /**
     * retornar um cliente pelo codigo
     *
     * @param pIdCliente
     * @return
     */
    public ModelClientes retornarClienteDAO(int pIdCliente) {

        ModelClientes modelCliente = new ModelClientes();

        try {

            this.conectar();

            this.executarSQL("SELECT "
                    + "pk_id_cliente, "
                    + "cli_nome, "
                    + "cli_endereco, "
                    + "cli_bairro, "
                    + "cli_cidade, "
                    + "cli_uf, "
                    + "cli_cep, "
                    + "cli_telefone, "
                    + "cli_cpf "
                    + "FROM tb_clientes WHERE pk_id_cliente = '"
                    + pIdCliente + "'");

            while (this.getResultSet().next()) {
                modelCliente.setIdCliente(this.getResultSet().getInt(1));
                modelCliente.setCliNome(this.getResultSet().getString(2));
                modelCliente.setCliEndereco(this.getResultSet().getString(3));
                modelCliente.setCliBairro(this.getResultSet().getString(4));
                modelCliente.setCliCidade(this.getResultSet().getString(5));
                modelCliente.setCliUf(this.getResultSet().getString(6));
                modelCliente.setCliCep(this.getResultSet().getString(7));
                modelCliente.setCliTelefone(this.getResultSet().getString(8));
                modelCliente.setCliCpfCnpj(this.getResultSet().getString(9));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelCliente;
    }
    /**
     * retornar um cliente pelo codigo
     *
     * @param pNomeCliente
     * @return
     */
    public ModelClientes retornarClienteDAO(String pNomeCliente) {

        ModelClientes modelCliente = new ModelClientes();

        try {

            this.conectar();

            this.executarSQL("SELECT "
                    + "pk_id_cliente, "
                    + "cli_nome, "
                    + "cli_endereco, "
                    + "cli_bairro, "
                    + "cli_cidade, "
                    + "cli_uf, "
                    + "cli_cep, "
                    + "cli_telefone, "
                    + "cli_cpf "
                    + "FROM tb_clientes WHERE cli_nome = '"
                    + pNomeCliente + "'");

            while (this.getResultSet().next()) {
                modelCliente.setIdCliente(this.getResultSet().getInt(1));
                modelCliente.setCliNome(this.getResultSet().getString(2));
                modelCliente.setCliEndereco(this.getResultSet().getString(3));
                modelCliente.setCliBairro(this.getResultSet().getString(4));
                modelCliente.setCliCidade(this.getResultSet().getString(5));
                modelCliente.setCliUf(this.getResultSet().getString(6));
                modelCliente.setCliCep(this.getResultSet().getString(7));
                modelCliente.setCliTelefone(this.getResultSet().getString(8));
                modelCliente.setCliCpfCnpj(this.getResultSet().getString(9));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelCliente;
    }

    /**
     * LISTAR CLIENTES DO BANCO
     *
     * @return
     */
    public ArrayList<ModelClientes> listarClientesDAO() {

        ArrayList<ModelClientes> listaModelClientes = new ArrayList<>();
        ModelClientes modelCliente = new ModelClientes();

        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "pk_id_cliente, "
                    + "cli_nome, "
                    + "cli_endereco, "
                    + "cli_bairro, "
                    + "cli_cidade, "
                    + "cli_uf, "
                    + "cli_cep, "
                    + "cli_telefone, "
                    + "cli_cpf "
                    + "FROM tb_clientes;");

            while (this.getResultSet().next()) {
                modelCliente = new ModelClientes();
                modelCliente.setIdCliente(this.getResultSet().getInt(1));
                modelCliente.setCliNome(this.getResultSet().getString(2));
                modelCliente.setCliEndereco(this.getResultSet().getString(3));
                modelCliente.setCliBairro(this.getResultSet().getString(4));
                modelCliente.setCliCidade(this.getResultSet().getString(5));
                modelCliente.setCliUf(this.getResultSet().getString(6));
                modelCliente.setCliCep(this.getResultSet().getString(7));
                modelCliente.setCliTelefone(this.getResultSet().getString(8));
                modelCliente.setCliCpfCnpj(this.getResultSet().getString(9));
                listaModelClientes.add(modelCliente);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }

        return listaModelClientes;
    }

}
