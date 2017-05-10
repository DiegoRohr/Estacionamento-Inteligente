/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.BilheteDao;
import Dao.BilheteDaoImp;
import Dao.VagaDao;
import Dao.VagaDaoImp;
import Model.Bilhete;
import Model.Vaga;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.persistence.EntityManager;
import javax.faces.model.ListDataModel;
import javax.faces.context.FacesContext;
import Controller.VagaController;
import Dao.VagaDao;
import Dao.VagaDaoImp;
import Utils.HibernateUtil;
import java.util.Date;


/**
 *
 * @author thayseonofrio
 */

//TO DO: Ao ser criado, o bilhete tem que ser adicionado à tabela Histórico, contendo a id do usuario e a id do bilhete
//Depois da pra consultar pelo usuario os bilhetes que já teve, pra gerar relatórios 
@ManagedBean
@SessionScoped
public class BilheteController{
    private Bilhete bilhete;
    private DataModel listaBilhetes;
    private EntityManager entityManager;

    public BilheteController() {
        if (this.bilhete == null) {
            this.bilhete = new Bilhete();
        }
    }
    
    

    public DataModel getListarUsuarios() {
        List<Bilhete> lista = new BilheteDaoImp().list();
        listaBilhetes = new ListDataModel(lista);
        return listaBilhetes;
    }

    public Bilhete getBilhete() {
        return bilhete;
    }

    public void setBilhete(Bilhete bilhete) {
        this.bilhete = bilhete;
    }

    public String prepararAdicionarBilhete() {
        bilhete = new Bilhete();
        BilheteDao dao = new BilheteDaoImp();
        dao.save(bilhete);
        return "vagas";
    }

    public String prepararAlterarUsuario() {
        bilhete = (Bilhete) (listaBilhetes.getRowData());
        return "gerenciarBilhete";
    }

    public String excluirUsuario() {
        Bilhete bilheteTemp = (Bilhete) (listaBilhetes.getRowData());
        BilheteDao dao = new BilheteDaoImp();
        dao.remove(bilheteTemp);
        return "index";
    }

    public String adicionarBilhete() {
        BilheteDao dao = new BilheteDaoImp();
        //bilhete.setDataHoraEmissao(new Date());
        dao.save(bilhete);       
        VagaDao vagaDao = new VagaDaoImp();
        Vaga vaga = bilhete.getVaga();
        vaga.setUtilizada(true);
        vagaDao.update(vaga);

        return "bilheteGerado";
    }

    public String alterarBilhete() {
        BilheteDao dao = new BilheteDaoImp();
        dao.update(bilhete);
        return "index";
    }
    
    public String finalizarBilhete() {
        BilheteDao dao = new BilheteDaoImp();
        bilhete.setDataHoraBaixa(new Date());
        //calcular depois com base no horário
        bilhete.setValorTotal(10.0);
        dao.update(bilhete);
        //libera a vaga
        VagaDao vagaDao = new VagaDaoImp();
        Vaga vaga = bilhete.getVaga();
        vaga.setUtilizada(false);
        vagaDao.update(vaga);
        return "index";
    } 
    
}
