/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.travelmate.ManagerBean;

import br.com.travelmate.facade.InteracaoFacade;
import br.com.travelmate.model.Chamado;
import br.com.travelmate.model.Interacao;
import br.com.travelmate.util.EnviarEmailBean;
import br.com.travelmate.util.Formatacao;
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

/**
 *
 * @author Greicieli
 * 
 */
@Named
@ViewScoped
public class CadInteracaoMB implements Serializable{
    
    
    @Inject
    private UsuarioLogadoMB usuarioLogadoMB;
     private Interacao interacao;
     private List<Interacao> listaInteracao;
    private Chamado chamado;
    
    public CadInteracaoMB() {
    FacesContext fc = FacesContext.getCurrentInstance();
    HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        chamado = (Chamado) session.getAttribute("chamado");
        interacao = (Interacao) session.getAttribute("interacao");
        session.removeAttribute("interacao");
        if (interacao==null){
            interacao = new Interacao();
            interacao.setChamado(chamado);
            session.removeAttribute("chamado");
        }
        if (interacao!=null){
            gerarListaInteracao();
        }else{
            listaInteracao = new ArrayList<Interacao>();
        }
    }

    public Interacao getInteracao() {
        return interacao;
    }

    public void setInteracao(Interacao interacao) {
        this.interacao = interacao;	
    }

    public Chamado getChamado() {
        return chamado;
    }

    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }
    public List<Interacao> getListaInteracao() {
        if(listaInteracao==null){
            gerarListaInteracao();
        }
        return listaInteracao;
    }

    public void setListaInteracao(List<Interacao> listaInteracao) {
        this.listaInteracao = listaInteracao;
    }

    public UsuarioLogadoMB getUsuarioLogadoMB() {
        return usuarioLogadoMB;
    }

    public void setUsuarioLogadoMB(UsuarioLogadoMB usuarioLogadoMB) {
        this.usuarioLogadoMB = usuarioLogadoMB;
    }
    
    
    
    public void salvar(Chamado chamados){
        InteracaoFacade interacaoFacede = new InteracaoFacade();  
        interacao.setUsuario(usuarioLogadoMB.getUsuario());
        interacao.setData(new Date());
        interacao.setHora(Formatacao.foramtarHoraString());
        interacao.setChamado(chamado);
        interacao = interacaoFacede.salvar(interacao);
         enviarEmail();
        chamados = interacao.getChamado();
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.setAttribute("chamado", chamados);
        RequestContext.getCurrentInstance().closeDialog(chamados);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Cadastrado com Sucesso", ""));
    }
    
    public void enviarEmail(){
        String destinatario;
        if (usuarioLogadoMB.getUsuario().getDepartamento().equalsIgnoreCase("TI")){
            destinatario = interacao.getChamado().getUsuarioabertura().getEmail();
        }else destinatario = interacao.getChamado().getUsuarioexecutor().getEmail();
        EnviarEmailBean enviarEmailBean = new EnviarEmailBean(interacao.getDescricao(), destinatario, "Nova Interação do Chamado No. " + interacao.getChamado().getIdchamado() );
        enviarEmailBean.enviarEmail();
    }
    
    public String cancelar(){
        return "consInteracao";
    }
    
    public void gerarListaInteracao() {
        String sql = "select i from Interacao i where i.chamado.idchamado=" + chamado.getIdchamado();
        InteracaoFacade interacaoFacade = new InteracaoFacade();
        listaInteracao = interacaoFacade.listar(sql);
        if (listaInteracao == null) {
            listaInteracao = new ArrayList<Interacao>();
        }
    }
}
    

