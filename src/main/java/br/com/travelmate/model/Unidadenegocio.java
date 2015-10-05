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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Kamila
 */
@Entity
@Table(name = "unidadenegocio")
@NamedQueries({
    @NamedQuery(name = "Unidadenegocio.findAll", query = "SELECT u FROM Unidadenegocio u")})
public class Unidadenegocio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idunidadeNegocio")
    private Integer idunidadeNegocio;
    @Size(max = 100)
    @Column(name = "razaoSocial")
    private String razaoSocial;
    @Size(max = 100)
    @Column(name = "nomeFantasia")
    private String nomeFantasia;
    @Size(max = 10)
    @Column(name = "tipoLogradouro")
    private String tipoLogradouro;
    @Size(max = 100)
    @Column(name = "logradouro")
    private String logradouro;
    @Size(max = 10)
    @Column(name = "numero")
    private String numero;
    @Size(max = 50)
    @Column(name = "complemento")
    private String complemento;
    @Size(max = 50)
    @Column(name = "bairro")
    private String bairro;
    @Size(max = 100)
    @Column(name = "cidade")
    private String cidade;
    @Size(max = 2)
    @Column(name = "estado")
    private String estado;
    @Size(max = 9)
    @Column(name = "cep")
    private String cep;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Size(max = 14)
    @Column(name = "fone")
    private String fone;
    @Size(max = 18)
    @Column(name = "cnpj")
    private String cnpj;
    @Size(max = 7)
    @Column(name = "versao")
    private String versao;
    @Column(name = "digitosTelefone")
    private Integer digitosTelefone;
    @Column(name = "dataembarcadocurso")
    @Temporal(TemporalType.DATE)
    private Date dataembarcadocurso;
    @Size(max = 50)
    @Column(name = "tipo")
    private String tipo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "perconsultor")
    private Double perconsultor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadenegocio")
    private List<Usuario> usuarioList;
    @JoinColumn(name = "banco_idbanco", referencedColumnName = "idbanco")
    @ManyToOne(optional = false)
    private Banco banco;

    public Unidadenegocio() {
    }

    public Unidadenegocio(Integer idunidadeNegocio) {
        this.idunidadeNegocio = idunidadeNegocio;
    }

    public Integer getIdunidadeNegocio() {
        return idunidadeNegocio;
    }

    public void setIdunidadeNegocio(Integer idunidadeNegocio) {
        this.idunidadeNegocio = idunidadeNegocio;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public Integer getDigitosTelefone() {
        return digitosTelefone;
    }

    public void setDigitosTelefone(Integer digitosTelefone) {
        this.digitosTelefone = digitosTelefone;
    }

    public Date getDataembarcadocurso() {
        return dataembarcadocurso;
    }

    public void setDataembarcadocurso(Date dataembarcadocurso) {
        this.dataembarcadocurso = dataembarcadocurso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPerconsultor() {
        return perconsultor;
    }

    public void setPerconsultor(Double perconsultor) {
        this.perconsultor = perconsultor;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idunidadeNegocio != null ? idunidadeNegocio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidadenegocio)) {
            return false;
        }
        Unidadenegocio other = (Unidadenegocio) object;
        if ((this.idunidadeNegocio == null && other.idunidadeNegocio != null) || (this.idunidadeNegocio != null && !this.idunidadeNegocio.equals(other.idunidadeNegocio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.travelmate.model.Unidadenegocio[ idunidadeNegocio=" + idunidadeNegocio + " ]";
    }
    
}
