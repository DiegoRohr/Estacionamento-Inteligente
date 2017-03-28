/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Model.Bilhete;
import Model.Historico;
import Model.Usuario;
import Model.Vaga;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 *
 * @author thayseonofrio
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private HibernateUtil() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {

                AnnotationConfiguration ac = new AnnotationConfiguration();
                ac.addAnnotatedClass(Usuario.class);
                ac.addAnnotatedClass(Vaga.class);
                ac.addAnnotatedClass(Bilhete.class);
                ac.addAnnotatedClass(Historico.class);
                sessionFactory = ac.configure().buildSessionFactory();
            } catch (Throwable ex) {

                System.err.println("Erro na criação do SessionFactory" + ex);
                throw new ExceptionInInitializerError(ex);
            }
            return sessionFactory;
        } else {
            return sessionFactory;
        }
    }
}