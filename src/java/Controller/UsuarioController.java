/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.UsuarioDao;
import Dao.UsuarioDaoImp;
import Model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.context.FacesContext;

//import org.apache.commons.codec.digest.DigestUtils;
/**
 *
 * @author thayseonofrio
 */
@ManagedBean
@SessionScoped
public class UsuarioController {

    private Usuario usuario;
    private DataModel listaUsuarios;

    public UsuarioController() {
        if (this.usuario == null) {
            this.usuario = new Usuario();
        }
    }

    public DataModel getListarUsuarios() {
        List<Usuario> lista = new UsuarioDaoImp().list();
        listaUsuarios = new ListDataModel(lista);
        return listaUsuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Usuario getUsuarioPorId(String id) {
        UsuarioDao usuario = new UsuarioDaoImp();
        long idLong = Long.parseLong(id);
        return usuario.getUsuario(idLong);
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

    public boolean verificarSessao() {
        boolean estado;

        if (FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap().get("usuario") == null) {
            estado = false;
        } else {
            estado = true;
        }

        return estado;
    }

    public String terminarSessao() {
        FacesContext.getCurrentInstance().getExternalContext()
                .invalidateSession();
        return "login";
    }

    public String verificarDados() throws Exception {
        UsuarioDaoImp usuDAO = new UsuarioDaoImp();
        Usuario us;
        String resultado;
        try {
            us = usuDAO.verificarDados(this.usuario);
            if (us != null) {

                FacesContext.getCurrentInstance().getExternalContext()
                        .getSessionMap().put("usuario", us);

                resultado = "index";
            } else {
                resultado = "login?faces-redirect=true&erro=true";
            }
        } catch (Exception e) {
            throw e;
        }

        return resultado;
    }

}
