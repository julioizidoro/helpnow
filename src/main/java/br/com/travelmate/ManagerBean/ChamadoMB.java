package br.com.travelmate.ManagerBean;

import br.com.travelmate.facade.ChamadoFacade;
import br.com.travelmate.model.Area;
import br.com.travelmate.model.Chamado;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;


@Named
@ViewScoped
public class ChamadoMB implements Serializable{
    
    @Inject
    private UsuarioLogadoMB usuarioLogadoMB;
    private Chamado chamado;
    private List<Chamado> listaChamado;
    private List<Chamado> listaChamadoUsuario;
    
    
   public ChamadoMB() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        chamado = (Chamado) session.getAttribute("chamado");
        session.removeAttribute("chamado");
        gerarListaChamado();
        chamado = new Chamado();
        
    }

    public Chamado getChamado() {
        return chamado;
    }

    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }

    public List<Chamado> getListaChamado() {
        if(listaChamado==null){
            gerarListaChamado();
        }
        return listaChamado;
    }

    public void setListaChamado(List<Chamado> listaChamado) {
        this.listaChamado = listaChamado;
    }

    public UsuarioLogadoMB getUsuarioLogadoMB() {
        return usuarioLogadoMB;
    }

    public void setUsuarioLogadoMB(UsuarioLogadoMB usuarioLogadoMB) {
        this.usuarioLogadoMB = usuarioLogadoMB;
    }

    public List<Chamado> getListaChamadoUsuario() {
        if(listaChamadoUsuario==null){
            gerarListaChamadoUsuario();
        }
        return listaChamadoUsuario;
    }

    public void setListaChamadoUsuario(List<Chamado> listaChamadoUsuario) {
        this.listaChamadoUsuario = listaChamadoUsuario;
    }

    
    
    
    public void gerarListaChamado() {
        ChamadoFacade chamadoFacade = new ChamadoFacade();
        listaChamado = chamadoFacade.listar("");
        if (listaChamado == null) {
            listaChamado = new ArrayList<Chamado>();
        }
    }
    
    public void gerarListaChamadoUsuario() {
        ChamadoFacade chamadoFacade = new ChamadoFacade();
        listaChamadoUsuario = chamadoFacade.listarUsuario("select c from Chamado c where c.usuario.idusuario="+usuarioLogadoMB.getUsuario().getIdusuario());
        if (listaChamadoUsuario == null) {
            listaChamadoUsuario = new ArrayList<Chamado>();
        }
    }
    
    public String novo(){
        chamado = new Chamado();
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("contentWidth", 430);
        RequestContext.getCurrentInstance().openDialog("cadastrochamado", options, null);
        return "";
    }
    
    
    public String voltar(){
        return "consChamada";
    }
    
    public String interacao(Chamado chamados){
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.setAttribute("chamado", chamados);
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("contentWidth", 500);
        RequestContext.getCurrentInstance().openDialog("interacao", options, null);
        return "";
    }
    
    public String iniciar(Chamado chamados){
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.setAttribute("chamado", chamados);
        ChamadoFacade chamadoFacade = new ChamadoFacade();
        chamado.setSituacao("Processo");
        chamadoFacade.salvar(chamado);
        return "consSupChamado";
    }
    
    public String finalizar(Chamado chamado){
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.setAttribute("chamado", chamado);
        ChamadoFacade chamadoFacade = new ChamadoFacade();
        chamado.setSituacao("Finalizado");
        chamadoFacade.salvar(chamado);
       return "consSupChamado"; 
    }
}
