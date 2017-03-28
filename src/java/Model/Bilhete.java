/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;

/**
 *
 * @author thayseonofrio
 */
@Entity
public class Bilhete implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    @OneToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
    private Date dataHoraEmissao;
    private Date dataHoraBaixa;
    private double valorTotal;
    @OneToOne
    @JoinColumn(name = "vagaUtilizada")
    private Vaga vaga;

    public Bilhete() {

    }

    public Bilhete(long id, Usuario usuario, Date dataHoraEmissao, Date dataHoraBaixa, double valorTotal, Vaga vaga) {
        this.id = id;
        this.usuario = usuario;
        this.dataHoraEmissao = dataHoraEmissao;
        this.dataHoraBaixa = dataHoraBaixa;
        this.valorTotal = valorTotal;
        this.vaga = vaga;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDataHoraEmissao() {
        return dataHoraEmissao;
    }

    public void setDataHoraEmissao(Date dataHoraEmissao) {
        this.dataHoraEmissao = dataHoraEmissao;
    }

    public Date getDataHoraBaixa() {
        return dataHoraBaixa;
    }

    public void setDataHoraBaixa(Date dataHoraBaixa) {
        this.dataHoraBaixa = dataHoraBaixa;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }
    

}
    
    
