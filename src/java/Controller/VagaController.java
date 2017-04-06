/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Dao.VagaDao;
import Dao.VagaDaoImp;
import Model.Vaga;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.context.FacesContext;

/**
 *
 * @author thayseonofrio
 */

//Na verdade a vaga só vai ser alterada no Bilhete, porque quando setar a hora de entrada do carro na vaga, ela se torna ocupada; 
//quando setar a hora de saída, ela fica desocupada

@ManagedBean
@SessionScoped
public class VagaController{
    private Vaga vaga;
    private DataModel listaVagas;
    
    public DataModel getListarVagas() {
        List<Vaga> lista = new VagaDaoImp().list();
        listaVagas = new ListDataModel(lista);
        return listaVagas;
    }

    public Vaga getVaga() {
        return vaga;
    }
    
    public Vaga getVagaPorCodigo(String cod) {
        VagaDao vaga = new VagaDaoImp();
        return vaga.getVaga(cod);
    }
            

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }
    
    public String vagaOcupada() {
        VagaDao dao = new VagaDaoImp();
        vaga.setUtilizada(true);
        dao.update(vaga);
        return "vagas";
    }
    
    public Vaga vagaDesocupada() {
        VagaDao dao = new VagaDaoImp();
        vaga.setUtilizada(false);
        dao.update(vaga);
        return vaga;
    }
   
}
