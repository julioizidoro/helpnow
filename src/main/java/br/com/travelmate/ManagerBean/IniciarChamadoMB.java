package br.com.travelmate.ManagerBean;

import br.com.travelmate.facade.ChamadoFacade;
import br.com.travelmate.model.Chamado;
import br.com.travelmate.model.Usuario;
import br.com.travelmate.util.EnviarEmailBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

@Named
@ViewScoped
public class IniciarChamadoMB implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario UsuarioExecutor;
    private List<Usuario> listaExecutor;
    private Chamado chamado;
    
    @PostConstruct
    public void init(){
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        chamado = (Chamado) session.getAttribute("chamado");
        session.removeAttribute("chamado");
    }
    
     public Usuario getUsuarioExecutor() {
        return UsuarioExecutor;
    }

    public void setUsuarioExecutor(Usuario UsuarioExecutor) {
        this.UsuarioExecutor = UsuarioExecutor;
    }

    public List<Usuario> getListaExecutor() {
        if(listaExecutor==null){
            gerarListaExecutor();
        }
        return listaExecutor;
    }

    public void setListaExecutor(List<Usuario> listaExecutor) {
        this.listaExecutor = listaExecutor;
    }
    public Chamado getChamado() {
        return chamado;
    }

    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }
    
    
    public void gerarListaExecutor() {
        ChamadoFacade chamadoFacade = new ChamadoFacade();
        listaExecutor = chamadoFacade.listarUsuario("select u from Usuario u where u.departamento='TI'");
        if (listaExecutor == null) {
            listaExecutor = new ArrayList<Usuario>();
        }
    }
    
    public void iniciar(){
        ChamadoFacade chamadoFacade = new ChamadoFacade();
        chamado.setSituacao("Em Análise");
        chamado.setUsuarioexecutor(UsuarioExecutor);
        if (chamado.getPrioridade().equalsIgnoreCase("Normal")){
            chamado.setIdprioridade(3);
        }else if (chamado.getPrioridade().equalsIgnoreCase("Alta")){
            chamado.setIdprioridade(2);
        }else chamado.setIdprioridade(1);
        chamado = chamadoFacade.salvar(chamado);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Chamada Iniciada ", "Sucesso"));
        enviarEmail();
        RequestContext.getCurrentInstance().closeDialog(chamado);
    }
    
    public void enviarEmail(){
        EnviarEmailBean enviarEmailBean = new EnviarEmailBean(chamado.getProblema(), chamado.getUsuarioexecutor().getEmail(), "Chamado Iniciado No. "  + chamado.getIdchamado());
        enviarEmailBean.enviarEmail();
    }
    
}
