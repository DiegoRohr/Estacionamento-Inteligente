/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Bilhete;
import java.util.List;

/**
 *
 * @author thayseonofrio
 */
public interface BilheteDao {

    public void save(Bilhete bilhete);

    public Bilhete getBilhete(long id);

    public List<Bilhete> list();

    public void remove(Bilhete bilhete);

    public void update(Bilhete bilhete);

}