package br.com.travelmate.ManagerBean;


import br.com.travelmate.facade.AreaFacade;
import br.com.travelmate.facade.ChamadoFacade;
import br.com.travelmate.model.Area;
import br.com.travelmate.model.Chamado;
import br.com.travelmate.model.Interacao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

@Named
@ViewScoped
public class CadChamadoMB implements Serializable{
    
    @Inject
    private UsuarioLogadoMB usuarioLogadoMB;
    private Chamado chamado;
    private List<Area> listaArea;
    private Area area;
    private List<Chamado> listaChamado;
    
    public CadChamadoMB() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        chamado = (Chamado) session.getAttribute("chamado");
        session.removeAttribute("chamado");
        gerarListaArea();
        if (chamado==null){
            chamado = new Chamado();
        }
    }

    public Chamado getChamado() {
        return chamado;
    }

    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }

    public List<Area> getListaArea() {
        return listaArea;
    }

    public void setListaArea(List<Area> listaArea) {
        this.listaArea = listaArea;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public UsuarioLogadoMB getUsuarioLogadoMB() {
        return usuarioLogadoMB;
    }

    public void setUsuarioLogadoMB(UsuarioLogadoMB usuarioLogadoMB) {
        this.usuarioLogadoMB = usuarioLogadoMB;
    }

    public List<Chamado> getListaChamado() {
        return listaChamado;
    }

    public void setListaChamado(List<Chamado> listaChamado) {
        this.listaChamado = listaChamado;
    }
    
    
    
    public void gerarListaArea(){
        AreaFacade areaFacade = new AreaFacade();
        listaArea = areaFacade.listar("select a from Area a order by a.descricao");
        if (listaArea == null) {
            listaArea = new ArrayList<Area>();
        }
        
    }
    public void gerarListaChamado() {
        ChamadoFacade chamadoFacade = new ChamadoFacade();
        listaChamado = chamadoFacade.listar("");
        if (listaChamado == null) {
            listaChamado = new ArrayList<Chamado>();
        }
    }
    
    public String salvar() {
        chamado.setSituacao("Aguardo");
        chamado.setDataabertura(new Date());
        chamado.setUsuario(usuarioLogadoMB.getUsuario());
        chamado.setArea(area);
        ChamadoFacade chamadoFacade = new ChamadoFacade();
        chamadoFacade.salvar(chamado);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Cadastrado com Sucesso", ""));
        chamado = new Chamado();
        RequestContext.getCurrentInstance().closeDialog(null);
        if (chamado!=null){
            gerarListaChamado();
        }else{
            listaChamado = new ArrayList<Chamado>();
        }
        return "consProjeto";
    }
    
    public String cancelar() {
        RequestContext.getCurrentInstance().closeDialog(null);
        return "";
    }
    
}
