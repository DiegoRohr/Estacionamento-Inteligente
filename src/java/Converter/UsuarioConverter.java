///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Converter;
//
//import Controller.UsuarioController;
//import Dao.UsuarioDao;
//import Dao.UsuarioDaoImp;
//import Model.Usuario;
//import java.lang.annotation.Annotation;
//import javax.faces.convert.FacesConverter;
//import javax.faces.context.FacesContext;
//import javax.persistence.Converter;
//import javax.faces.component.UIComponent;
//
///**
// *
// * @author Eduardo
// */
//@FacesConverter("usuarioConverter")
//public class UsuarioConverter implements Converter{
//
//    public Object getAsObject(FacesContext context, UIComponent component, String CodVaga) {
//        VagaController vagaController = new VagaController();       
//        return vagaController.getVagaPorCodigo(CodVaga);
//       
//    }
//
//    public long getAsString(FacesContext context, UIComponent component, Object usuario) {
//        return ((Usuario)usuario).getId();        
//    }
//
//    @Override
//    public boolean autoApply() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public Class<? extends Annotation> annotationType() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//}
