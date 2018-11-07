package model;

import java.sql.Date;
import java.sql.Timestamp;

/**
*
* @author Levi Freire
*/
public class ModelVendas {

    private int idVenda;
    private int cliente;
    private Date vendaDataVenda;
    private double vendaValorLiquido;
    private double vendaValorBruto;
    private double vendaDesconto;
    private String nomeCliente;

    /**
    * Construtor
    */
    public ModelVendas(){}

    /**
    * seta o valor de idVenda
    * @param pIdVenda
    */
    public void setIdVenda(int pIdVenda){
        this.idVenda = pIdVenda;
    }
    /**
    * return pk_idVenda
    */
    public int getIdVenda(){
        return this.idVenda;
    }

    /**
    * seta o valor de cliente
    * @param pCliente
    */
    public void setCliente(int pCliente){
        this.cliente = pCliente;
    }
    /**
    * return fk_cliente
    */
    public int getCliente(){
        return this.cliente;
    }

    public Date getVendaDataVenda() {
        return vendaDataVenda;
    }

    public void setVendaDataVenda(Date vendaDataVenda) {
        this.vendaDataVenda = vendaDataVenda;
    }

    

    /**
     * seta o valor de vendaValorLiquido
     * @param pVendaValorLiquido
     */
    public void setVendaValorLiquido(double pVendaValorLiquido) {
        this.vendaValorLiquido = pVendaValorLiquido;
    }
    /**
    * return vendaValorLiquido
    */
    public double getVendaValorLiquido(){
        return this.vendaValorLiquido;
    }

    /**
    * seta o valor de vendaValorBruto
    * @param pVendaValorBruto
    */
    public void setVendaValorBruto(double pVendaValorBruto){
        this.vendaValorBruto = pVendaValorBruto;
    }
    /**
    * return vendaValorBruto
    */
    public double getVendaValorBruto(){
        return this.vendaValorBruto;
    }

    /**
    * seta o valor de vendaDesconto
    * @param pVendaDesconto
    */
    public void setVendaDesconto(double pVendaDesconto){
        this.vendaDesconto = pVendaDesconto;
    }
    /**
    * return vendaDesconto
    */
    public double getVendaDesconto(){
        return this.vendaDesconto;
    }

    @Override
    public String toString(){
        return "ModelVendas {" + "::idVenda = " + this.idVenda + "::cliente = " + this.cliente + "::vendaDataVenda = " + this.vendaDataVenda + "::vendaValorLiquido = " + this.vendaValorLiquido + "::vendaValorBruto = " + this.vendaValorBruto + "::vendaDesconto = " + this.vendaDesconto +  "}";
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    
    
}