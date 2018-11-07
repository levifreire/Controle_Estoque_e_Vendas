/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author levif
 */
public class Formatador {
    
    /**
     * Converter a virgula de valor para um ponto
     * @param pString
     * @return double
     */
    public double converterVirgulaParaPonto(String pString){
        
        String retorno = new String();
        int tamanho = pString.length();
        
        for (int i = 0; i < tamanho; i++) {
            if(pString.charAt(i) == ','){
                retorno += '.';
            } else {
                retorno += pString.charAt(i);
            }
        }
        
        return Double.parseDouble(retorno);
    }
    
}
