package DAO;

import model.ModelUsuarios;
import conexoes.ConexaoMySql;
import java.util.ArrayList;

/**
 *
 * @author Levi
 */
public class DAOUsuario extends ConexaoMySql {

    /**
     * grava Usuario
     *
     * @param pModelUsuario return int
     */
    public int salvarUsuarioDAO(ModelUsuarios pModelUsuario) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO tb_usuarios ("
                    + "usu_nome, "
                    + "usu_login, "
                    + "usu_senha"
                    + ") VALUES ("
                    + "'" + pModelUsuario.getUsuNome() + "', "
                    + "'" + pModelUsuario.getUsuLogin() + "', "
                    + "'" + pModelUsuario.getUsuSenha() + "'"
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
     * recupera Usuario
     *
     * @param pIdUsuario return ModelUsuario
     */
    public ModelUsuarios getUsuarioDAO(int pIdUsuario) {
        ModelUsuarios modelUsuario = new ModelUsuarios();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_id_usuario, "
                    + "usu_nome, "
                    + "usu_login, "
                    + "usu_senha"
                    + " FROM"
                    + " tb_usuarios"
                    + " WHERE"
                    + " pk_id_usuario = '" + pIdUsuario + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelUsuario.setIdUsuario(this.getResultSet().getInt(1));
                modelUsuario.setUsuNome(this.getResultSet().getString(2));
                modelUsuario.setUsuLogin(this.getResultSet().getString(3));
                modelUsuario.setUsuSenha(this.getResultSet().getString(4));
                //modelUsuario.setUsuEmail(this.getResultSet().getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelUsuario;
    }

    /**
     * recupera uma lista de Usuario return ArrayList
     */
    public ArrayList<ModelUsuarios> listarUsuarioDAO() {
        ArrayList<ModelUsuarios> listamodelUsuario = new ArrayList();
        ModelUsuarios modelUsuario = new ModelUsuarios();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_id_usuario, "
                    + "usu_nome, "
                    + "usu_login, "
                    + "usu_senha, "
                    + "usu_email"
                    + " FROM"
                    + " tb_usuarios"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelUsuario = new ModelUsuarios();
                modelUsuario.setIdUsuario(this.getResultSet().getInt(1));
                modelUsuario.setUsuNome(this.getResultSet().getString(2));
                modelUsuario.setUsuLogin(this.getResultSet().getString(3));
                modelUsuario.setUsuSenha(this.getResultSet().getString(4));
                modelUsuario.setUsuEmail(this.getResultSet().getString(5));
                listamodelUsuario.add(modelUsuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelUsuario;
    }

    /**
     * atualiza Usuario
     *
     * @param pModelUsuario return boolean
     */
    public boolean atualizarUsuarioDAO(ModelUsuarios pModelUsuario) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE tb_usuarios SET "
                    + "pk_id_usuario = '" + pModelUsuario.getIdUsuario() + "', "
                    + "usu_nome = '" + pModelUsuario.getUsuNome() + "', "
                    + "usu_login = '" + pModelUsuario.getUsuLogin() + "', "
                    + "usu_senha = '" + pModelUsuario.getUsuSenha() + "'"
                    + " WHERE "
                    + "pk_id_usuario = '" + pModelUsuario.getIdUsuario() + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * exclui Usuario
     *
     * @param pIdUsuario return boolean
     */
    public boolean excluirUsuarioDAO(int pIdUsuario) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM tb_usuarios"
                    + " WHERE "
                    + "pk_id_usuario = '" + pIdUsuario + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * VALIDAR LOGIN E SENHA NO BANCO
     * @param pModelUsuario
     * @return 
    */    
    public boolean getValidarUsuarioDAO(ModelUsuarios pModelUsuario) {
        
        try {
            this.conectar();
            
            this.executarSQL("SELECT "
            + "pk_id_usuario, "
            + "usu_nome, "
            + "usu_login, "
            + "usu_senha "
            + "FROM tb_usuarios "
            + "WHERE "
            + "usu_login = '" + pModelUsuario.getUsuLogin() + "' AND"+ " usu_senha = '" + pModelUsuario.getUsuSenha() + "';"
            );
            
            if(getResultSet().next()){
                return true;
            } else {
                return false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
        
    }
}
