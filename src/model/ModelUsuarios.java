package model;
/**
*
* @author Levi
*/
public class ModelUsuarios {

    private int idUsuario;
    private String usuNome;
    private String usuLogin;
    private String usuSenha;
    private String usuEmail;

    /**
    * Construtor
    */
    public ModelUsuarios(){}

    /**
    * seta o valor de idUsuario
    * @param pIdUsuario
    */
    public void setIdUsuario(int pIdUsuario){
        this.idUsuario = pIdUsuario;
    }
    /**
    * return pk_idUsuario
    */
    public int getIdUsuario(){
        return this.idUsuario;
    }

    /**
    * seta o valor de usuNome
    * @param pUsuNome
    */
    public void setUsuNome(String pUsuNome){
        this.usuNome = pUsuNome;
    }
    /**
    * return usuNome
    */
    public String getUsuNome(){
        return this.usuNome;
    }

    /**
    * seta o valor de usuLogin
    * @param pUsuLogin
    */
    public void setUsuLogin(String pUsuLogin){
        this.usuLogin = pUsuLogin;
    }
    /**
    * return usuLogin
    */
    public String getUsuLogin(){
        return this.usuLogin;
    }

    /**
    * seta o valor de usuSenha
    * @param pUsuSenha
    */
    public void setUsuSenha(String pUsuSenha){
        this.usuSenha = pUsuSenha;
    }
    /**
    * return usuSenha
    */
    public String getUsuSenha(){
        return this.usuSenha;
    }

    /**
    * seta o valor de usuEmail
    * @param pUsuEmail
    */
    public void setUsuEmail(String pUsuEmail){
        this.usuEmail = pUsuEmail;
    }
    /**
    * return usuEmail
    */
    public String getUsuEmail(){
        return this.usuEmail;
    }

    @Override
    public String toString(){
        return "ModelUsuario {" + "::idUsuario = " + this.idUsuario + "::usuNome = " + this.usuNome + "::usuLogin = " + this.usuLogin + "::usuSenha = " + this.usuSenha + "::usuEmail = " + this.usuEmail +  "}";
    }
}