/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Bilhete;
import Utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author thayseonofrio
 */
public class BilheteDaoImp implements BilheteDao {

    @Override
    public void save(Bilhete bilhete) {
        
       Session session;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(bilhete);
            transaction.commit();
        } catch (HibernateException ex) {
            System.out.println("Erro ao inserir: " + ex);
            if(transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session.isOpen()){
                session.close();
            }
        }
        
        
        
    }

    @Override
    public Bilhete getBilhete(long id) {
               Session session;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        Bilhete bilhete = new Bilhete();
        try {
            bilhete = (Bilhete) session.load(Bilhete.class, id);
        } catch (HibernateException he) {
            System.out.println("Erro ao buscar o bilhete: " + he);
            he.printStackTrace();
        } finally {
            if (session.isOpen()){
                session.close();
            }
        }
        return bilhete;

    }

    @Override
    public List<Bilhete> list() {
               Session session;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            List lista = session.createQuery("from Bilhete").list();
            transaction.commit();
            return lista;
        } catch (HibernateException ex) {
            System.out.println("Erro ao listar: " + ex);
            if(transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session.isOpen()){
                session.close();
            }
        }
        return null;
        
    }

    @Override
    public void remove(Bilhete bilhete) {
               Session session;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        
        
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
        session.delete(bilhete);
        transaction.commit();
        } catch (HibernateException ex) {
            System.out.println("Erro ao listar: " + ex);
            if(transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session.isOpen()){
                session.close();
            }
        }
        
        
    }

    @Override
    public void update(Bilhete bilhete) {
               Session session;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
        session.update(bilhete);
        transaction.commit();
        } catch (HibernateException ex) {
            System.out.println("Erro ao listar: " + ex);
            if(transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session.isOpen()){
                session.close();
            }
        }
    }
    
}
