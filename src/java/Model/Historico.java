/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author thayseonofrio
 */
@Entity
public class Historico implements Serializable{
    @OneToOne
    @JoinColumn(name = "idBilhete")
    private Bilhete bilhete;
    
    @OneToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
    @Id
    private int id;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
