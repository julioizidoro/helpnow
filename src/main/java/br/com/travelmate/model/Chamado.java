/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.travelmate.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "chamado")
public class Chamado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idchamado")
    private Integer idchamado;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "problema")
    private String problema;
    @Column(name = "dataabertura")
    @Temporal(TemporalType.DATE)
    private Date dataabertura;
    @Size(max = 30)
    @Column(name = "situacao")
    private String situacao;
    @Size(max = 30)
    @Column(name = "prioridade")
    private String prioridade;
    @Size(max = 3)
    @Column(name = "executornotificado")
    private String executornotificado;
    @Column(name = "idprioridade")
    private int idprioridade;
    @JoinColumn(name = "area_idarea", referencedColumnName = "idarea")
    @ManyToOne(optional = false)
    private Area area;
    @JoinColumn(name = "usuarioabertura", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario usuarioabertura;
    @JoinColumn(name = "usuarioexecutor", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario usuarioexecutor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chamado")
    private List<Interacao> interacaoList;

    public Chamado() {
    }

    public Chamado(Integer idchamado) {
        this.idchamado = idchamado;
    }

    public Integer getIdchamado() {
        return idchamado;
    }

    public void setIdchamado(Integer idchamado) {
        this.idchamado = idchamado;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public Date getDataabertura() {
        return dataabertura;
    }

    public void setDataabertura(Date dataabertura) {
        this.dataabertura = dataabertura;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getExecutornotificado() {
        return executornotificado;
    }

    public void setExecutornotificado(String executornotificado) {
        this.executornotificado = executornotificado;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Usuario getUsuarioabertura() {
        return usuarioabertura;
    }

    public void setUsuarioabertura(Usuario usuarioabertura) {
        this.usuarioabertura = usuarioabertura;
    }

    public Usuario getUsuarioexecutor() {
        return usuarioexecutor;
    }

    public void setUsuarioexecutor(Usuario usuarioexecutor) {
        this.usuarioexecutor = usuarioexecutor;
    }

    public int getIdprioridade() {
        return idprioridade;
    }

    public void setIdprioridade(int idprioridade) {
        this.idprioridade = idprioridade;
    }

    

    public List<Interacao> getInteracaoList() {
        return interacaoList;
    }

    public void setInteracaoList(List<Interacao> interacaoList) {
        this.interacaoList = interacaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idchamado != null ? idchamado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chamado)) {
            return false;
        }
        Chamado other = (Chamado) object;
        if ((this.idchamado == null && other.idchamado != null) || (this.idchamado != null && !this.idchamado.equals(other.idchamado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.travelmate.model.Chamado[ idchamado=" + idchamado + " ]";
    }
    
}
