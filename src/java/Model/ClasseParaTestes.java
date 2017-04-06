/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.*;
import Dao.*;
import Controller.*;
import static com.mchange.v2.log.MLog.config;
import javax.faces.model.DataModel;
import org.hibernate.cfg.AnnotationConfiguration;
import Model.Bilhete;
import Utils.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Eduardo
 */
public class ClasseParaTestes {
    
    

    public static void main(String[] args) {
        
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    Bilhete bilhete = new Bilhete();
    Vaga vaga = new Vaga();
    Usuario usuario = new Usuario();
    
    
    bilhete.setVaga(vaga);
    bilhete.setUsuario(usuario);
    

    vaga.setCodVaga("C10");;


    usuario.setId(8);
    
    session.save(bilhete);
    session.getTransaction().commit();


}
}
