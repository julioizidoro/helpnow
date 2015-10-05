package br.com.travelmate.ManagerBean;

import br.com.travelmate.facade.ChamadoFacade;
import br.com.travelmate.model.Chamado;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;


@Named
@ViewScoped
public class ChamadoMB implements Serializable{
    
    private Chamado chamado;
    private List<Chamado> listaChamado;
    
    
    @PostConstruct
    public void init(){
        if (chamado!=null){
            getListaChamado();
        }else{
            listaChamado = new ArrayList<Chamado>();
        }
    }

    public Chamado getChamado() {
        return chamado;
    }

    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }

    public List<Chamado> getListaChamado() {
        return listaChamado;
    }

    public void setListaChamado(List<Chamado> listaChamado) {
        this.listaChamado = listaChamado;
    }
    
    
    
    public void gerarListaProjeto() {
        String sql = "Select c from Chamado c order by c.dataabertura";
        ChamadoFacade chamadoFacade = new ChamadoFacade();
        listaChamado = chamadoFacade.listar(sql);
        if (listaChamado == null) {
            listaChamado = new ArrayList<Chamado>();
        }
    }
    
    public String novo(){
        return "cadastrochamado";
    }
    
    
    public String voltar(){
        return "consChamada";
    }
    
    public String area(){
        return "consultaarea";
    }
}
