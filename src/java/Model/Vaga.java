/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.Type;

/**
 *
 * @author thayseonofrio
 */
@Entity
public class Vaga implements Serializable {
    @Id
    private String codVaga;
    @Column(columnDefinition = "TINYINT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean utilizada;

    public Vaga() {
    }

    public Vaga(String codVaga) {
        this.codVaga = codVaga;
        this.utilizada = utilizada;
    }

    public String getCodVaga() {
        return codVaga;
    }

    public void setCodVaga(String codVaga) {
        this.codVaga = codVaga;
    }

    public boolean isUtilizada() {
        return utilizada;
    }

    public void setUtilizada(boolean utilizada) {
        this.utilizada = utilizada;
    }
    
    
    
    
}