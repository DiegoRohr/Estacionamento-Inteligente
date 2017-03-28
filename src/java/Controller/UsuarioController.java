/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.UsuarioDao;
import Dao.UsuarioDaoImp;
import Model.Usuario;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author thayseonofrio
 */
@ManagedBean
@SessionScoped
public class UsuarioController {

    private Usuario usuario;
    private DataModel listaUsuarios;

    public DataModel getListarUsuarios() {
        List<Usuario> lista = new UsuarioDaoImp().list();
        listaUsuarios = new ListDataModel(lista);
        return listaUsuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String prepararAdicionarUsuario() {
        usuario = new Usuario();
        return "gerenciarUsuario";
    }

    public String prepararAlterarUsuario() {
        usuario = (Usuario) (listaUsuarios.getRowData());
        return "gerenciarUsuario";
    }

    public String excluirUsuario() {
        Usuario usuarioTemp = (Usuario) (listaUsuarios.getRowData());
        UsuarioDao dao = new UsuarioDaoImp();
        dao.remove(usuarioTemp);
        return "index";
    }

    public String adicionarUsuario() {
        UsuarioDao dao = new UsuarioDaoImp();
        dao.save(usuario);
        return "index";
    }

    public String alterarUsuario() {
        UsuarioDao dao = new UsuarioDaoImp();
        dao.update(usuario);
        return "index";
    }
}
