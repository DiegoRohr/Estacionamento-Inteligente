/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.BilheteDao;
import Dao.BilheteDaoImp;
import Model.Bilhete;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author thayseonofrio
 */

//TO DO: Ao ser criado, o bilhete tem que ser adicionado à tabela Histórico, contendo a id do usuario e a id do bilhete
//Depois da pra consultar pelo usuario os bilhetes que já teve, pra gerar relatórios 

public class BilheteController {
    private Bilhete bilhete;
    private DataModel listaBilhetes;

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
        //no momento ta retornando para uma página com esse nome, tem que arrumar depois
        return "gerenciarBilhete";
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

    public String adicionarUsuario() {
        BilheteDao dao = new BilheteDaoImp();
        dao.save(bilhete);
        return "index";
    }

    public String alterarBilhete() {
        BilheteDao dao = new BilheteDaoImp();
        dao.update(bilhete);
        return "index";
    }
}
