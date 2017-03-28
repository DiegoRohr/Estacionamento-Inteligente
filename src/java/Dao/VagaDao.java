/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Vaga;
import java.util.List;

/**
 *
 * @author thayseonofrio
 */
public interface VagaDao {

    public Vaga getVaga(String codVaga);

    public List<Vaga> list();

    public void update(Vaga vaga);

    
}