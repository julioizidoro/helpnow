package br.com.travelmate.ManagerBean;


import br.com.travelmate.facade.AreaFacade;
import br.com.travelmate.facade.ChamadoFacade;
import br.com.travelmate.facade.UsuarioFacade;
import br.com.travelmate.model.Area;
import br.com.travelmate.model.Chamado;
import br.com.travelmate.model.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

@Named
@ViewScoped
public class CadChamadoMB implements Serializable{
    
    @Inject
    private UsuarioLogadoMB usuarioLogadoMB;
    private Chamado chamado;
    private List<Area> listaArea;
    private Area area;

    public CadChamadoMB() {
        gerarListaArea();
        this.chamado = new Chamado();
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
    
    public void gerarListaArea(){
        AreaFacade areaFacade = new AreaFacade();
        listaArea = areaFacade.listar("select a from Area a order by a.descricao");
        if (listaArea == null) {
            listaArea = new ArrayList<Area>();
        }
        
    }
    
    public void salvar() {
        chamado.setSituacao("Aguardo");
        chamado.setDataabertura(new Date());
        chamado.setUsuarioabertura(usuarioLogadoMB.getUsuario());
        chamado.setArea(area);
        chamado.setPrioridade("definir");
        UsuarioFacade usuarioFacade = new UsuarioFacade();
        Usuario usuario = usuarioFacade.consultar(1);
        chamado.setUsuarioexecutor(usuario);
        ChamadoFacade chamadoFacade = new ChamadoFacade();
        chamado = chamadoFacade.salvar(chamado);RequestContext.getCurrentInstance().closeDialog(chamado);
    }
    
    public void cancelar() {
        RequestContext.getCurrentInstance().closeDialog(null);
    }
    
}
