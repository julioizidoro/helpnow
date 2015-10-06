/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.travelmate.ManagerBean;

import br.com.travelmate.facade.InteracaoFacade;
import br.com.travelmate.model.Chamado;
import br.com.travelmate.model.Interacao;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Greicieli
 * 
 */
@Named
@ViewScoped
public class CadInteracaoMB implements Serializable{
    
     private Interacao interacao;
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

    
    
    
    public String salvar(Chamado chamado){
        InteracaoFacade interacaoFacede = new InteracaoFacade();  
        interacaoFacede.salvar(interacao);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Cadastrado com Sucesso", ""));
        chamado = interacao.getChamado();
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.setAttribute("chamados", chamado);
        return "consInteracao";
    }
    
    public String cancelar(){
        return "consInteracao";
    }
}
    

