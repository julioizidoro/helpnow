package br.com.travelmate.ManagerBean;

import br.com.travelmate.facade.ChamadoFacade;
import br.com.travelmate.model.Chamado;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;


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
            listaChamado = chamadoFacade.listar("select c from Chamado c where c.usuario.idusuario="+usuarioLogadoMB.getUsuario().getIdusuario());
        }
        if (listaChamado == null) {
            listaChamado = new ArrayList<Chamado>();
        }
    }
    
    public void novo(){
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("contentWidth", 525);
        RequestContext.getCurrentInstance().openDialog("cadastrochamado", options, null);
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
            context.addMessage(null, new FacesMessage("Atenção", "Este chamado não foi iniciado."));
        }
       
        return ""; 
    }
          
    public void abrirDialog(Chamado chamados) {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.setAttribute("chamado", chamados);
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("contentWidth", 430);
        RequestContext.getCurrentInstance().openDialog("executor", options, null);
    }

    
    public void finalizar(Chamado chamados, String linha){
        if(chamados.getSituacao().equalsIgnoreCase("Processo")){
            ChamadoFacade chamadoFacade = new ChamadoFacade();
            chamados.setSituacao("Finalizado");
            chamados = chamadoFacade.salvar(chamados);
            int numeroLinha = Integer.parseInt(linha);
            listaChamado.remove(numeroLinha);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Finalizado com Sucesso", ""));
        }else{
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Atenção", "Está chamada não foi iniciada."));
        }
    }
    
    public void retornoDialogNovo(SelectEvent event) {
        Chamado chamado = (Chamado) event.getObject();
        listaChamado.add(chamado);
    }
    
    public void retornoDialog(){
        gerarListaChamado();
    }
}
