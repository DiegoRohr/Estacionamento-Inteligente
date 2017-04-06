/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author thayseonofrio
 */
@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private String cpf;
    private String email;
    private Date dataNasc;
    private String senha;

    public Usuario() {

    }

    public Usuario(long id, String nome, String cpf, String email, Date dataNasc, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataNasc = dataNasc;
        this.senha = senha;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        System.out.println(dataNasc);
        this.dataNasc = dataNasc;
    }

    public String getSenha() throws UnsupportedEncodingException {
        senha = Desencripta(senha);
        return senha;
    }

    public void setSenha(String senha) throws UnsupportedEncodingException {
        senha = Encripta(senha);
        this.senha = senha;
    }

    public String Encripta(String senha) throws UnsupportedEncodingException {
        String asB64 = Base64.getEncoder().encodeToString(senha.getBytes("utf-8"));
        return asB64;
    }

    public String Desencripta(String codigo) throws UnsupportedEncodingException {
        byte[] asBytes = Base64.getDecoder().decode(codigo);
        String pass = new String(asBytes, "utf-8");
        return pass;
    }
}
