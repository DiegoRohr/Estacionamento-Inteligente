/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Vaga;
import Utils.HibernateUtil;
import java.util.LinkedList;
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
        Vaga vaga = new Vaga();
        try {
            vaga = (Vaga) session.load(Vaga.class, codVaga);
        } catch (HibernateException he) {
            System.out.println("Erro ao buscar a vaga: " + he);
            he.printStackTrace();
        } finally {
            if (session.isOpen()){
                session.close();
            }
        }
        return vaga;
        
    }
    
    public List<Vaga> list() {
               Session session;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        
        List<Vaga> lista = new LinkedList<>();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
        lista = session.createQuery("from Vaga").list();
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
        
        return lista;
    }
    
    public List<Vaga> listDisponiveis() {
               Session session;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        
        List<Vaga> lista = new LinkedList<>();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
        lista = session.createQuery("from Vaga where utilizada = 0").list();
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
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
        session.update(vaga);
        transaction.commit();
        } catch (HibernateException ex) {
            System.out.println("Erro ao atualizar: " + ex);
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
