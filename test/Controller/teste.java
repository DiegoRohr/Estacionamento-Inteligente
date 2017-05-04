/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Usuario;
import Model.Vaga;

/**
 *
 * @author thayseonofrio
 */
public class teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        VagaController vagaController = new VagaController();
        Vaga vaga = vagaController.getVagaPorCodigo("A01");
        vaga.toString();
        vaga.getCodVaga();
        
    }
    
}
