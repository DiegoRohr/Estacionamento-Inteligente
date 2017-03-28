/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author thayseonofrio
 */
public class Historico {
    @OneToOne
    @JoinColumn(name = "idBilhete")
    private Bilhete bilhete;
    
    @OneToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Historico(Bilhete bilhete, Usuario usuario) {
        this.bilhete = bilhete;
        this.usuario = usuario;
    }
    
    public Historico() {
        
    }

    public Bilhete getBilhete() {
        return bilhete;
    }

    public void setBilhete(Bilhete bilhete) {
        this.bilhete = bilhete;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
