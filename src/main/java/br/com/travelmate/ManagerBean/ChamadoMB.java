package br.com.travelmate.ManagerBean;

import br.com.travelmate.facade.ChamadoFacade;
import br.com.travelmate.model.Chamado;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
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
    private List<Chamado> listaChamado;
    
    
   @PostConstruct
    public void init(){
        getUsuarioLogadoMB();
        gerarListaChamado();
        refresh();
        
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
    
    public void gerarListaChamado() {
        ChamadoFacade chamadoFacade = new ChamadoFacade();
        if (usuarioLogadoMB.getUsuario().getDepartamento().equalsIgnoreCase("TI")){
            listaChamado = chamadoFacade.listar("select c from Chamado c where c.situacao='Aguardo' or c.situacao='Processo'");
        }else {
            listaChamado = chamadoFacade.listarUsuario("select c from Chamado c where c.usuario.idusuario="+usuarioLogadoMB.getUsuario().getIdusuario());
        }
        if (listaChamado == null) {
            listaChamado = new ArrayList<Chamado>();
        }
    }
    
    
    
    public String novo(){
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("contentWidth", 525);
        RequestContext.getCurrentInstance().openDialog("cadastrochamado", options, null);
        return "";
    }
    
    public String interacao(Chamado chamados){  
        if(chamados.getSituacao().equalsIgnoreCase("Processo")){
          FacesContext fc = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
            session.setAttribute("chamado", chamados);
            Map<String,Object> options = new HashMap<String, Object>();
            options.put("contentWidth", 500);
            RequestContext.getCurrentInstance().openDialog("interacao", options, null);
        }else{
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Atenção", "Está chamada não foi iniciada."));
        }
       
        return ""; 
    }
          
        
    
    public String iniciar(Chamado chamados){
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.setAttribute("chamado", chamados);
        ChamadoFacade chamadoFacade = new ChamadoFacade();
        chamados.setSituacao("Processo");
        chamadoFacade.salvar(chamados);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Chamada Iniciada ", "Sucesso"));
        return "consSupChamado";
    }
    
    public String finalizar(Chamado chamados){
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.setAttribute("chamado", chamados);
        ChamadoFacade chamadoFacade = new ChamadoFacade();
        if(chamados.getSituacao().equalsIgnoreCase("Processo")){
            chamados.setSituacao("Finalizado");
            chamadoFacade.salvar(chamados);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Finalizado com Sucesso", ""));
        }else{
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Atenção", "Está chamada não foi iniciada."));
        }
       return "consSupChamado"; 
    }
    
    public String concluir(Chamado chamado){
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.setAttribute("chamado", chamado);
        if(chamado.getSituacao().equalsIgnoreCase("Finalizado")){
            ChamadoFacade chamadoFacade = new ChamadoFacade();
            chamadoFacade.excluir(chamado.getIdchamado());
            gerarListaChamado();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Chamada Concluída", ""));
        }else{
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Aguarde!", "Chamada não Finalizada"));
        }
        return "consChamado";
    }
    
    public void refresh() {  
        FacesContext context = FacesContext.getCurrentInstance();  
        Application application = context.getApplication();  
        ViewHandler viewHandler = application.getViewHandler();  
        UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());  
        context.setViewRoot(viewRoot);  
        context.renderResponse();  
    }
}
