/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import Controller.VagaController;
import Dao.VagaDao;
import Dao.VagaDaoImp;
import Model.Vaga;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.convert.FacesConverter;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.component.UIComponent;

/**
 *
 * @author Eduardo
 */

@FacesConverter("vagaConverter")
public class VagaConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String CodVaga) {
        try {       
        VagaController vagaController = new VagaController();
        return vagaController.getVagaPorCodigo(CodVaga);
        } catch (Exception e)  {
            return null;
        }
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
            return (String) value;           
        } catch (Exception e)  {
            return ((Vaga) value).getCodVaga();
        }

    }

}
