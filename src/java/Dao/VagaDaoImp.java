/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Vaga;
import Utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author thayseonofrio
 */
public class VagaDaoImp implements VagaDao {

    
    public Vaga getVaga(String codVaga) {
               Session session;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        return (Vaga) session.load(Vaga.class, codVaga);
    }
    
    public List<Vaga> list() {
               Session session;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Vaga").list();
        t.commit();
        return lista;
    }

    
    @Override
    public void update(Vaga vaga) {
               Session session;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        Transaction t = session.beginTransaction();
        session.update(vaga);
        t.commit();
        
    }
    
}
