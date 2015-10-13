/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.travelmate.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Kamila
 */
@Entity
@Table(name = "executor")
public class Executor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idexecutor")
    private Integer idexecutor;
    @Column(name = "notificado")
    private String notificado;
    @JoinColumn(name = "chamado_idchamado", referencedColumnName = "idchamado")
    @ManyToOne(optional = false)
    private Chamado chamado;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Executor() {
    }

    public Integer getIdexecutor() {
        return idexecutor;
    }

    public void setIdexecutor(Integer idexecutor) {
        this.idexecutor = idexecutor;
    }

    public String getNotificado() {
        return notificado;
    }

    public void setNotificado(String notificado) {
        this.notificado = notificado;
    }

    

 
    public Chamado getChamado() {
        return chamado;
    }

    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.idexecutor);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Executor other = (Executor) obj;
        if (!Objects.equals(this.idexecutor, other.idexecutor)) {
            return false;
        }
        return true;
    }

    
    

    @Override
    public String toString() {
        return String.valueOf(idexecutor);
    }
    
}
