/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Bilhete;
import Utils.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author thayseonofrio
 */
public class BilheteDaoImp implements BilheteDao {

    @Override
    public void save(Bilhete bilhete) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(bilhete);
        t.commit();
    }

    @Override
    public Bilhete getBilhete(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Bilhete) session.load(Bilhete.class, id);
    }

    @Override
    public List<Bilhete> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Bilhete").list();
        t.commit();
        return lista;
    }

    @Override
    public void remove(Bilhete bilhete) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(bilhete);
        t.commit();
    }

    @Override
    public void update(Bilhete bilhete) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(bilhete);
        t.commit();
    }
    
}
