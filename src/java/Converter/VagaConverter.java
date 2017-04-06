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
import javax.faces.convert.FacesConverter;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.component.UIComponent;

/**
 *
 * @author Eduardo
 */
@FacesConverter("vagaConverter")
public class VagaConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String CodVaga) {
        VagaController vagaController = new VagaController();       
        return vagaController.getVagaPorCodigo(CodVaga);
       
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
        //há erros nesse metodo, não consegui arrumar
        try {
            return ((Vaga) value).getCodVaga();
        } catch (Exception e) {
            System.out.println("----"+value+" "+value.getClass().getName()+e);
            return null;
        }
        
         
    }







}
