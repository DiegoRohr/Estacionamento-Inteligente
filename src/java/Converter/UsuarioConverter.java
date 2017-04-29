/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import Controller.UsuarioController;
import Dao.UsuarioDao;
import Dao.UsuarioDaoImp;
import Model.Usuario;
import javax.faces.convert.FacesConverter;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.component.UIComponent;

/**
 *
 * @author Eduardo
 */
@FacesConverter("usuarioConverter")
public class UsuarioConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String id) {
        UsuarioController usuarioController = new UsuarioController();
        Usuario user = new Usuario();
        user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        return user;
    }

    /**
     *
     * @param context
     * @param component
     * @param value
     * @param vaga 
     * @return
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        try {
            String s = String.valueOf(value);
            return (String) s;
           
        } catch (Exception e)  {
            String strLong = Long.toString(((Usuario) value).getId());
            return strLong;
        }

    }

}
