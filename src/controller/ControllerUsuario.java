package controller;

import model.ModelUsuarios;
import DAO.DAOUsuario;
import java.util.ArrayList;

/**
*
* @author Levi
*/
public class ControllerUsuario {

    private DAOUsuario daoUsuario = new DAOUsuario();

    /**
    * grava Usuario
    * @param pModelUsuario
    * return int
    */
    public int salvarUsuarioController(ModelUsuarios pModelUsuario){
        return this.daoUsuario.salvarUsuarioDAO(pModelUsuario);
    }

    /**
    * recupera Usuario
    * @param pIdUsuario
    * return ModelUsuario
    */
    public ModelUsuarios getUsuarioController(int pIdUsuario){
        return this.daoUsuario.getUsuarioDAO(pIdUsuario);
    }

    /**
    * recupera uma lista deUsuario
    * @param pIdUsuario
    * return ArrayList
    */
    public ArrayList<ModelUsuarios> listarUsuariosController(){
        return this.daoUsuario.listarUsuarioDAO();
    }

    /**
    * atualiza Usuario
    * @param pModelUsuario
    * return boolean
    */
    public boolean atualizarUsuarioController(ModelUsuarios pModelUsuario){
        return this.daoUsuario.atualizarUsuarioDAO(pModelUsuario);
    }

    /**
    * exclui Usuario
    * @param pIdUsuario
    * return boolean
    */
    public boolean excluirUsuarioController(int pIdUsuario){
        return this.daoUsuario.excluirUsuarioDAO(pIdUsuario);
    }

    /**
     * VALIDAR LOGIN E SENHA DO USUARIO
     * @param pModelUsuario 
     */
    public boolean getValidarUsuarioController(ModelUsuarios pModelUsuario) {
        return this.daoUsuario.getValidarUsuarioDAO(pModelUsuario);
    }
}