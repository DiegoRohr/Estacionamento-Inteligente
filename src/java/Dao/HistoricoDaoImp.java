/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Historico;
import Utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author thayseonofrio
 */
public class HistoricoDaoImp implements HistoricoDao {

    @Override
    public void save(Historico historico) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(historico);
        t.commit();
    }
    
}
