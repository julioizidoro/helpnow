/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.travelmate.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Kamila
 */
@Entity
@Table(name = "acesso")
@NamedQueries({
    @NamedQuery(name = "Acesso.findAll", query = "SELECT a FROM Acesso a")})
public class Acesso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idacesso")
    private Integer idacesso;
    @Column(name = "financeirocambio")
    private Integer financeirocambio;
    @Column(name = "financeirocambiovalor")
    private Integer financeirocambiovalor;
    @Column(name = "segurancausuario")
    private Integer segurancausuario;
    @Column(name = "cadastroUnidade")
    private Integer cadastroUnidade;
    @Column(name = "cadastroConsultor")
    private Integer cadastroConsultor;
    @Column(name = "cadastroCliente")
    private Integer cadastroCliente;
    @Column(name = "cadastroFornecedor")
    private Integer cadastroFornecedor;
    @Column(name = "cadastroClienteAdicionar")
    private Integer cadastroClienteAdicionar;
    @Column(name = "cadastroClienteEditar")
    private Integer cadastroClienteEditar;
    @Column(name = "cursos")
    private Integer cursos;
    @Column(name = "cursosAdicionar")
    private Integer cursosAdicionar;
    @Column(name = "cursosEditar")
    private Integer cursosEditar;
    @Column(name = "cursosExcluir")
    private Integer cursosExcluir;
    @Column(name = "emissaoCambio")
    private Integer emissaoCambio;
    @Column(name = "highSchool")
    private Integer highSchool;
    @Column(name = "highSchoolAdicionar")
    private Integer highSchoolAdicionar;
    @Column(name = "highSchoolEditar")
    private Integer highSchoolEditar;
    @Column(name = "highSchoolExcluir")
    private Integer highSchoolExcluir;
    @Column(name = "programasTeens")
    private Integer programasTeens;
    @Column(name = "programasTeensAdicionar")
    private Integer programasTeensAdicionar;
    @Column(name = "programasTeensEditar")
    private Integer programasTeensEditar;
    @Column(name = "programasTeensExcluir")
    private Integer programasTeensExcluir;
    @Column(name = "fornecedor")
    private Integer fornecedor;
    @Column(name = "fornecedorAdicionar")
    private Integer fornecedorAdicionar;
    @Column(name = "fornecedorEditar")
    private Integer fornecedorEditar;
    @Column(name = "pacote")
    private Integer pacote;
    @Column(name = "pacoteAdicionar")
    private Integer pacoteAdicionar;
    @Column(name = "pacoteExcluir")
    private Integer pacoteExcluir;
    @Column(name = "pacoteEditar")
    private Integer pacoteEditar;
    @Column(name = "Seguro")
    private Integer seguro;
    @Column(name = "SeguroAdicionar")
    private Integer seguroAdicionar;
    @Column(name = "SeguroEditar")
    private Integer seguroEditar;
    @Column(name = "SeguroExcluir")
    private Integer seguroExcluir;
    @Column(name = "passagem")
    private Integer passagem;
    @Column(name = "passagemAdicionar")
    private Integer passagemAdicionar;
    @Column(name = "passagemEditar")
    private Integer passagemEditar;
    @Column(name = "passagemExcluir")
    private Integer passagemExcluir;
    @Column(name = "visto")
    private Integer visto;
    @Column(name = "vistoAdicionar")
    private Integer vistoAdicionar;
    @Column(name = "vistoEditar")
    private Integer vistoEditar;
    @Column(name = "vistoExcluir")
    private Integer vistoExcluir;
    @Column(name = "produtoOrcamento")
    private Integer produtoOrcamento;
    @Column(name = "produtoOrcamentoAdicionar")
    private Integer produtoOrcamentoAdicionar;
    @Column(name = "produtoOrcamentoEditar")
    private Integer produtoOrcamentoEditar;
    @Column(name = "produto")
    private Integer produto;
    @Column(name = "produtoAdicionar")
    private Integer produtoAdicionar;
    @Column(name = "produtoEditar")
    private Integer produtoEditar;
    @Column(name = "produtoUsuario")
    private Integer produtoUsuario;
    @Column(name = "ladies")
    private Integer ladies;
    @Column(name = "ladiesAdicionar")
    private Integer ladiesAdicionar;
    @Column(name = "ladiesEditar")
    private Integer ladiesEditar;
    @Column(name = "ladiesExcluir")
    private Integer ladiesExcluir;
    @Column(name = "aupair")
    private Integer aupair;
    @Column(name = "aupairAdicionar")
    private Integer aupairAdicionar;
    @Column(name = "aupairEditar")
    private Integer aupairEditar;
    @Column(name = "aupairExcluir")
    private Integer aupairExcluir;
    @Column(name = "work")
    private Integer work;
    @Column(name = "workAdicionar")
    private Integer workAdicionar;
    @Column(name = "workEditar")
    private Integer workEditar;
    @Column(name = "workExcluir")
    private Integer workExcluir;
    @Column(name = "agenda")
    private Integer agenda;
    @Column(name = "fallowup")
    private Integer fallowup;
    @Column(name = "pcwt")
    private Integer pcwt;
    @Column(name = "pcwtatualizar")
    private Integer pcwtatualizar;
    @Column(name = "pcwtfinalizar")
    private Integer pcwtfinalizar;
    @Column(name = "pca")
    private Integer pca;
    @Column(name = "pcaatualizar")
    private Integer pcaatualizar;
    @Column(name = "pcafinalizar")
    private Integer pcafinalizar;
    @Column(name = "pcc")
    private Integer pcc;
    @Column(name = "pccatualizar")
    private Integer pccatualizar;
    @Column(name = "pccfinalizar")
    private Integer pccfinalizar;
    @Column(name = "pchs")
    private Integer pchs;
    @Column(name = "pchsatualizar")
    private Integer pchsatualizar;
    @Column(name = "pchsfinalizar")
    private Integer pchsfinalizar;
    @Column(name = "pcct")
    private Integer pcct;
    @Column(name = "pcctatualizar")
    private Integer pcctatualizar;
    @Column(name = "pcctfinalizar")
    private Integer pcctfinalizar;
    @Column(name = "pcl")
    private Integer pcl;
    @Column(name = "pclatualizar")
    private Integer pclatualizar;
    @Column(name = "pclfinalizar")
    private Integer pclfinalizar;
    @Column(name = "pcp")
    private Integer pcp;
    @Column(name = "pcpatualizar")
    private Integer pcpatualizar;
    @Column(name = "pcpfinalizar")
    private Integer pcpfinalizar;
    @Column(name = "pcs")
    private Integer pcs;
    @Column(name = "pcsatualziar")
    private Integer pcsatualziar;
    @Column(name = "pcsfinalizar")
    private Integer pcsfinalizar;
    @Column(name = "pcv")
    private Integer pcv;
    @Column(name = "pcvatualizar")
    private Integer pcvatualizar;
    @Column(name = "pcvfinalizar")
    private Integer pcvfinalizar;
    @Column(name = "coeficiente")
    private Integer coeficiente;
    @Column(name = "coeficienteIncluir")
    private Integer coeficienteIncluir;
    @Column(name = "coeficienteEditar")
    private Integer coeficienteEditar;
    @Column(name = "uploadArquivo")
    private Integer uploadArquivo;
    @Column(name = "uploadArquivoIncluir")
    private Integer uploadArquivoIncluir;
    @Column(name = "uploadArquivoExcluir")
    private Integer uploadArquivoExcluir;
    @Column(name = "uploadArquivoExportar")
    private Integer uploadArquivoExportar;
    @Column(name = "tipoArquivo")
    private Integer tipoArquivo;
    @Column(name = "tipoArquivoIncluir")
    private Integer tipoArquivoIncluir;
    @Column(name = "tipoArquivoEditar")
    private Integer tipoArquivoEditar;
    @Column(name = "invoiceConsultar")
    private Integer invoiceConsultar;
    @Column(name = "invoicePagar")
    private Integer invoicePagar;
    @Column(name = "invoiceLancar")
    private Integer invoiceLancar;
    @Column(name = "valorHighSchool")
    private Integer valorHighSchool;
    @Column(name = "valorHighSchoolAdicionar")
    private Integer valorHighSchoolAdicionar;
    @Column(name = "valorHighSchoolEditar")
    private Integer valorHighSchoolEditar;
    @Column(name = "valorHighSchoolSituacao")
    private Integer valorHighSchoolSituacao;
    @Column(name = "cursoalterarescola")
    private Integer cursoalterarescola;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "acesso")
    private List<Grupoacesso> grupoacessoList;

    public Acesso() {
    }

    public Acesso(Integer idacesso) {
        this.idacesso = idacesso;
    }

    public Integer getIdacesso() {
        return idacesso;
    }

    public void setIdacesso(Integer idacesso) {
        this.idacesso = idacesso;
    }

    public Integer getFinanceirocambio() {
        return financeirocambio;
    }

    public void setFinanceirocambio(Integer financeirocambio) {
        this.financeirocambio = financeirocambio;
    }

    public Integer getFinanceirocambiovalor() {
        return financeirocambiovalor;
    }

    public void setFinanceirocambiovalor(Integer financeirocambiovalor) {
        this.financeirocambiovalor = financeirocambiovalor;
    }

    public Integer getSegurancausuario() {
        return segurancausuario;
    }

    public void setSegurancausuario(Integer segurancausuario) {
        this.segurancausuario = segurancausuario;
    }

    public Integer getCadastroUnidade() {
        return cadastroUnidade;
    }

    public void setCadastroUnidade(Integer cadastroUnidade) {
        this.cadastroUnidade = cadastroUnidade;
    }

    public Integer getCadastroConsultor() {
        return cadastroConsultor;
    }

    public void setCadastroConsultor(Integer cadastroConsultor) {
        this.cadastroConsultor = cadastroConsultor;
    }

    public Integer getCadastroCliente() {
        return cadastroCliente;
    }

    public void setCadastroCliente(Integer cadastroCliente) {
        this.cadastroCliente = cadastroCliente;
    }

    public Integer getCadastroFornecedor() {
        return cadastroFornecedor;
    }

    public void setCadastroFornecedor(Integer cadastroFornecedor) {
        this.cadastroFornecedor = cadastroFornecedor;
    }

    public Integer getCadastroClienteAdicionar() {
        return cadastroClienteAdicionar;
    }

    public void setCadastroClienteAdicionar(Integer cadastroClienteAdicionar) {
        this.cadastroClienteAdicionar = cadastroClienteAdicionar;
    }

    public Integer getCadastroClienteEditar() {
        return cadastroClienteEditar;
    }

    public void setCadastroClienteEditar(Integer cadastroClienteEditar) {
        this.cadastroClienteEditar = cadastroClienteEditar;
    }

    public Integer getCursos() {
        return cursos;
    }

    public void setCursos(Integer cursos) {
        this.cursos = cursos;
    }

    public Integer getCursosAdicionar() {
        return cursosAdicionar;
    }

    public void setCursosAdicionar(Integer cursosAdicionar) {
        this.cursosAdicionar = cursosAdicionar;
    }

    public Integer getCursosEditar() {
        return cursosEditar;
    }

    public void setCursosEditar(Integer cursosEditar) {
        this.cursosEditar = cursosEditar;
    }

    public Integer getCursosExcluir() {
        return cursosExcluir;
    }

    public void setCursosExcluir(Integer cursosExcluir) {
        this.cursosExcluir = cursosExcluir;
    }

    public Integer getEmissaoCambio() {
        return emissaoCambio;
    }

    public void setEmissaoCambio(Integer emissaoCambio) {
        this.emissaoCambio = emissaoCambio;
    }

    public Integer getHighSchool() {
        return highSchool;
    }

    public void setHighSchool(Integer highSchool) {
        this.highSchool = highSchool;
    }

    public Integer getHighSchoolAdicionar() {
        return highSchoolAdicionar;
    }

    public void setHighSchoolAdicionar(Integer highSchoolAdicionar) {
        this.highSchoolAdicionar = highSchoolAdicionar;
    }

    public Integer getHighSchoolEditar() {
        return highSchoolEditar;
    }

    public void setHighSchoolEditar(Integer highSchoolEditar) {
        this.highSchoolEditar = highSchoolEditar;
    }

    public Integer getHighSchoolExcluir() {
        return highSchoolExcluir;
    }

    public void setHighSchoolExcluir(Integer highSchoolExcluir) {
        this.highSchoolExcluir = highSchoolExcluir;
    }

    public Integer getProgramasTeens() {
        return programasTeens;
    }

    public void setProgramasTeens(Integer programasTeens) {
        this.programasTeens = programasTeens;
    }

    public Integer getProgramasTeensAdicionar() {
        return programasTeensAdicionar;
    }

    public void setProgramasTeensAdicionar(Integer programasTeensAdicionar) {
        this.programasTeensAdicionar = programasTeensAdicionar;
    }

    public Integer getProgramasTeensEditar() {
        return programasTeensEditar;
    }

    public void setProgramasTeensEditar(Integer programasTeensEditar) {
        this.programasTeensEditar = programasTeensEditar;
    }

    public Integer getProgramasTeensExcluir() {
        return programasTeensExcluir;
    }

    public void setProgramasTeensExcluir(Integer programasTeensExcluir) {
        this.programasTeensExcluir = programasTeensExcluir;
    }

    public Integer getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Integer fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Integer getFornecedorAdicionar() {
        return fornecedorAdicionar;
    }

    public void setFornecedorAdicionar(Integer fornecedorAdicionar) {
        this.fornecedorAdicionar = fornecedorAdicionar;
    }

    public Integer getFornecedorEditar() {
        return fornecedorEditar;
    }

    public void setFornecedorEditar(Integer fornecedorEditar) {
        this.fornecedorEditar = fornecedorEditar;
    }

    public Integer getPacote() {
        return pacote;
    }

    public void setPacote(Integer pacote) {
        this.pacote = pacote;
    }

    public Integer getPacoteAdicionar() {
        return pacoteAdicionar;
    }

    public void setPacoteAdicionar(Integer pacoteAdicionar) {
        this.pacoteAdicionar = pacoteAdicionar;
    }

    public Integer getPacoteExcluir() {
        return pacoteExcluir;
    }

    public void setPacoteExcluir(Integer pacoteExcluir) {
        this.pacoteExcluir = pacoteExcluir;
    }

    public Integer getPacoteEditar() {
        return pacoteEditar;
    }

    public void setPacoteEditar(Integer pacoteEditar) {
        this.pacoteEditar = pacoteEditar;
    }

    public Integer getSeguro() {
        return seguro;
    }

    public void setSeguro(Integer seguro) {
        this.seguro = seguro;
    }

    public Integer getSeguroAdicionar() {
        return seguroAdicionar;
    }

    public void setSeguroAdicionar(Integer seguroAdicionar) {
        this.seguroAdicionar = seguroAdicionar;
    }

    public Integer getSeguroEditar() {
        return seguroEditar;
    }

    public void setSeguroEditar(Integer seguroEditar) {
        this.seguroEditar = seguroEditar;
    }

    public Integer getSeguroExcluir() {
        return seguroExcluir;
    }

    public void setSeguroExcluir(Integer seguroExcluir) {
        this.seguroExcluir = seguroExcluir;
    }

    public Integer getPassagem() {
        return passagem;
    }

    public void setPassagem(Integer passagem) {
        this.passagem = passagem;
    }

    public Integer getPassagemAdicionar() {
        return passagemAdicionar;
    }

    public void setPassagemAdicionar(Integer passagemAdicionar) {
        this.passagemAdicionar = passagemAdicionar;
    }

    public Integer getPassagemEditar() {
        return passagemEditar;
    }

    public void setPassagemEditar(Integer passagemEditar) {
        this.passagemEditar = passagemEditar;
    }

    public Integer getPassagemExcluir() {
        return passagemExcluir;
    }

    public void setPassagemExcluir(Integer passagemExcluir) {
        this.passagemExcluir = passagemExcluir;
    }

    public Integer getVisto() {
        return visto;
    }

    public void setVisto(Integer visto) {
        this.visto = visto;
    }

    public Integer getVistoAdicionar() {
        return vistoAdicionar;
    }

    public void setVistoAdicionar(Integer vistoAdicionar) {
        this.vistoAdicionar = vistoAdicionar;
    }

    public Integer getVistoEditar() {
        return vistoEditar;
    }

    public void setVistoEditar(Integer vistoEditar) {
        this.vistoEditar = vistoEditar;
    }

    public Integer getVistoExcluir() {
        return vistoExcluir;
    }

    public void setVistoExcluir(Integer vistoExcluir) {
        this.vistoExcluir = vistoExcluir;
    }

    public Integer getProdutoOrcamento() {
        return produtoOrcamento;
    }

    public void setProdutoOrcamento(Integer produtoOrcamento) {
        this.produtoOrcamento = produtoOrcamento;
    }

    public Integer getProdutoOrcamentoAdicionar() {
        return produtoOrcamentoAdicionar;
    }

    public void setProdutoOrcamentoAdicionar(Integer produtoOrcamentoAdicionar) {
        this.produtoOrcamentoAdicionar = produtoOrcamentoAdicionar;
    }

    public Integer getProdutoOrcamentoEditar() {
        return produtoOrcamentoEditar;
    }

    public void setProdutoOrcamentoEditar(Integer produtoOrcamentoEditar) {
        this.produtoOrcamentoEditar = produtoOrcamentoEditar;
    }

    public Integer getProduto() {
        return produto;
    }

    public void setProduto(Integer produto) {
        this.produto = produto;
    }

    public Integer getProdutoAdicionar() {
        return produtoAdicionar;
    }

    public void setProdutoAdicionar(Integer produtoAdicionar) {
        this.produtoAdicionar = produtoAdicionar;
    }

    public Integer getProdutoEditar() {
        return produtoEditar;
    }

    public void setProdutoEditar(Integer produtoEditar) {
        this.produtoEditar = produtoEditar;
    }

    public Integer getProdutoUsuario() {
        return produtoUsuario;
    }

    public void setProdutoUsuario(Integer produtoUsuario) {
        this.produtoUsuario = produtoUsuario;
    }

    public Integer getLadies() {
        return ladies;
    }

    public void setLadies(Integer ladies) {
        this.ladies = ladies;
    }

    public Integer getLadiesAdicionar() {
        return ladiesAdicionar;
    }

    public void setLadiesAdicionar(Integer ladiesAdicionar) {
        this.ladiesAdicionar = ladiesAdicionar;
    }

    public Integer getLadiesEditar() {
        return ladiesEditar;
    }

    public void setLadiesEditar(Integer ladiesEditar) {
        this.ladiesEditar = ladiesEditar;
    }

    public Integer getLadiesExcluir() {
        return ladiesExcluir;
    }

    public void setLadiesExcluir(Integer ladiesExcluir) {
        this.ladiesExcluir = ladiesExcluir;
    }

    public Integer getAupair() {
        return aupair;
    }

    public void setAupair(Integer aupair) {
        this.aupair = aupair;
    }

    public Integer getAupairAdicionar() {
        return aupairAdicionar;
    }

    public void setAupairAdicionar(Integer aupairAdicionar) {
        this.aupairAdicionar = aupairAdicionar;
    }

    public Integer getAupairEditar() {
        return aupairEditar;
    }

    public void setAupairEditar(Integer aupairEditar) {
        this.aupairEditar = aupairEditar;
    }

    public Integer getAupairExcluir() {
        return aupairExcluir;
    }

    public void setAupairExcluir(Integer aupairExcluir) {
        this.aupairExcluir = aupairExcluir;
    }

    public Integer getWork() {
        return work;
    }

    public void setWork(Integer work) {
        this.work = work;
    }

    public Integer getWorkAdicionar() {
        return workAdicionar;
    }

    public void setWorkAdicionar(Integer workAdicionar) {
        this.workAdicionar = workAdicionar;
    }

    public Integer getWorkEditar() {
        return workEditar;
    }

    public void setWorkEditar(Integer workEditar) {
        this.workEditar = workEditar;
    }

    public Integer getWorkExcluir() {
        return workExcluir;
    }

    public void setWorkExcluir(Integer workExcluir) {
        this.workExcluir = workExcluir;
    }

    public Integer getAgenda() {
        return agenda;
    }

    public void setAgenda(Integer agenda) {
        this.agenda = agenda;
    }

    public Integer getFallowup() {
        return fallowup;
    }

    public void setFallowup(Integer fallowup) {
        this.fallowup = fallowup;
    }

    public Integer getPcwt() {
        return pcwt;
    }

    public void setPcwt(Integer pcwt) {
        this.pcwt = pcwt;
    }

    public Integer getPcwtatualizar() {
        return pcwtatualizar;
    }

    public void setPcwtatualizar(Integer pcwtatualizar) {
        this.pcwtatualizar = pcwtatualizar;
    }

    public Integer getPcwtfinalizar() {
        return pcwtfinalizar;
    }

    public void setPcwtfinalizar(Integer pcwtfinalizar) {
        this.pcwtfinalizar = pcwtfinalizar;
    }

    public Integer getPca() {
        return pca;
    }

    public void setPca(Integer pca) {
        this.pca = pca;
    }

    public Integer getPcaatualizar() {
        return pcaatualizar;
    }

    public void setPcaatualizar(Integer pcaatualizar) {
        this.pcaatualizar = pcaatualizar;
    }

    public Integer getPcafinalizar() {
        return pcafinalizar;
    }

    public void setPcafinalizar(Integer pcafinalizar) {
        this.pcafinalizar = pcafinalizar;
    }

    public Integer getPcc() {
        return pcc;
    }

    public void setPcc(Integer pcc) {
        this.pcc = pcc;
    }

    public Integer getPccatualizar() {
        return pccatualizar;
    }

    public void setPccatualizar(Integer pccatualizar) {
        this.pccatualizar = pccatualizar;
    }

    public Integer getPccfinalizar() {
        return pccfinalizar;
    }

    public void setPccfinalizar(Integer pccfinalizar) {
        this.pccfinalizar = pccfinalizar;
    }

    public Integer getPchs() {
        return pchs;
    }

    public void setPchs(Integer pchs) {
        this.pchs = pchs;
    }

    public Integer getPchsatualizar() {
        return pchsatualizar;
    }

    public void setPchsatualizar(Integer pchsatualizar) {
        this.pchsatualizar = pchsatualizar;
    }

    public Integer getPchsfinalizar() {
        return pchsfinalizar;
    }

    public void setPchsfinalizar(Integer pchsfinalizar) {
        this.pchsfinalizar = pchsfinalizar;
    }

    public Integer getPcct() {
        return pcct;
    }

    public void setPcct(Integer pcct) {
        this.pcct = pcct;
    }

    public Integer getPcctatualizar() {
        return pcctatualizar;
    }

    public void setPcctatualizar(Integer pcctatualizar) {
        this.pcctatualizar = pcctatualizar;
    }

    public Integer getPcctfinalizar() {
        return pcctfinalizar;
    }

    public void setPcctfinalizar(Integer pcctfinalizar) {
        this.pcctfinalizar = pcctfinalizar;
    }

    public Integer getPcl() {
        return pcl;
    }

    public void setPcl(Integer pcl) {
        this.pcl = pcl;
    }

    public Integer getPclatualizar() {
        return pclatualizar;
    }

    public void setPclatualizar(Integer pclatualizar) {
        this.pclatualizar = pclatualizar;
    }

    public Integer getPclfinalizar() {
        return pclfinalizar;
    }

    public void setPclfinalizar(Integer pclfinalizar) {
        this.pclfinalizar = pclfinalizar;
    }

    public Integer getPcp() {
        return pcp;
    }

    public void setPcp(Integer pcp) {
        this.pcp = pcp;
    }

    public Integer getPcpatualizar() {
        return pcpatualizar;
    }

    public void setPcpatualizar(Integer pcpatualizar) {
        this.pcpatualizar = pcpatualizar;
    }

    public Integer getPcpfinalizar() {
        return pcpfinalizar;
    }

    public void setPcpfinalizar(Integer pcpfinalizar) {
        this.pcpfinalizar = pcpfinalizar;
    }

    public Integer getPcs() {
        return pcs;
    }

    public void setPcs(Integer pcs) {
        this.pcs = pcs;
    }

    public Integer getPcsatualziar() {
        return pcsatualziar;
    }

    public void setPcsatualziar(Integer pcsatualziar) {
        this.pcsatualziar = pcsatualziar;
    }

    public Integer getPcsfinalizar() {
        return pcsfinalizar;
    }

    public void setPcsfinalizar(Integer pcsfinalizar) {
        this.pcsfinalizar = pcsfinalizar;
    }

    public Integer getPcv() {
        return pcv;
    }

    public void setPcv(Integer pcv) {
        this.pcv = pcv;
    }

    public Integer getPcvatualizar() {
        return pcvatualizar;
    }

    public void setPcvatualizar(Integer pcvatualizar) {
        this.pcvatualizar = pcvatualizar;
    }

    public Integer getPcvfinalizar() {
        return pcvfinalizar;
    }

    public void setPcvfinalizar(Integer pcvfinalizar) {
        this.pcvfinalizar = pcvfinalizar;
    }

    public Integer getCoeficiente() {
        return coeficiente;
    }

    public void setCoeficiente(Integer coeficiente) {
        this.coeficiente = coeficiente;
    }

    public Integer getCoeficienteIncluir() {
        return coeficienteIncluir;
    }

    public void setCoeficienteIncluir(Integer coeficienteIncluir) {
        this.coeficienteIncluir = coeficienteIncluir;
    }

    public Integer getCoeficienteEditar() {
        return coeficienteEditar;
    }

    public void setCoeficienteEditar(Integer coeficienteEditar) {
        this.coeficienteEditar = coeficienteEditar;
    }

    public Integer getUploadArquivo() {
        return uploadArquivo;
    }

    public void setUploadArquivo(Integer uploadArquivo) {
        this.uploadArquivo = uploadArquivo;
    }

    public Integer getUploadArquivoIncluir() {
        return uploadArquivoIncluir;
    }

    public void setUploadArquivoIncluir(Integer uploadArquivoIncluir) {
        this.uploadArquivoIncluir = uploadArquivoIncluir;
    }

    public Integer getUploadArquivoExcluir() {
        return uploadArquivoExcluir;
    }

    public void setUploadArquivoExcluir(Integer uploadArquivoExcluir) {
        this.uploadArquivoExcluir = uploadArquivoExcluir;
    }

    public Integer getUploadArquivoExportar() {
        return uploadArquivoExportar;
    }

    public void setUploadArquivoExportar(Integer uploadArquivoExportar) {
        this.uploadArquivoExportar = uploadArquivoExportar;
    }

    public Integer getTipoArquivo() {
        return tipoArquivo;
    }

    public void setTipoArquivo(Integer tipoArquivo) {
        this.tipoArquivo = tipoArquivo;
    }

    public Integer getTipoArquivoIncluir() {
        return tipoArquivoIncluir;
    }

    public void setTipoArquivoIncluir(Integer tipoArquivoIncluir) {
        this.tipoArquivoIncluir = tipoArquivoIncluir;
    }

    public Integer getTipoArquivoEditar() {
        return tipoArquivoEditar;
    }

    public void setTipoArquivoEditar(Integer tipoArquivoEditar) {
        this.tipoArquivoEditar = tipoArquivoEditar;
    }

    public Integer getInvoiceConsultar() {
        return invoiceConsultar;
    }

    public void setInvoiceConsultar(Integer invoiceConsultar) {
        this.invoiceConsultar = invoiceConsultar;
    }

    public Integer getInvoicePagar() {
        return invoicePagar;
    }

    public void setInvoicePagar(Integer invoicePagar) {
        this.invoicePagar = invoicePagar;
    }

    public Integer getInvoiceLancar() {
        return invoiceLancar;
    }

    public void setInvoiceLancar(Integer invoiceLancar) {
        this.invoiceLancar = invoiceLancar;
    }

    public Integer getValorHighSchool() {
        return valorHighSchool;
    }

    public void setValorHighSchool(Integer valorHighSchool) {
        this.valorHighSchool = valorHighSchool;
    }

    public Integer getValorHighSchoolAdicionar() {
        return valorHighSchoolAdicionar;
    }

    public void setValorHighSchoolAdicionar(Integer valorHighSchoolAdicionar) {
        this.valorHighSchoolAdicionar = valorHighSchoolAdicionar;
    }

    public Integer getValorHighSchoolEditar() {
        return valorHighSchoolEditar;
    }

    public void setValorHighSchoolEditar(Integer valorHighSchoolEditar) {
        this.valorHighSchoolEditar = valorHighSchoolEditar;
    }

    public Integer getValorHighSchoolSituacao() {
        return valorHighSchoolSituacao;
    }

    public void setValorHighSchoolSituacao(Integer valorHighSchoolSituacao) {
        this.valorHighSchoolSituacao = valorHighSchoolSituacao;
    }

    public Integer getCursoalterarescola() {
        return cursoalterarescola;
    }

    public void setCursoalterarescola(Integer cursoalterarescola) {
        this.cursoalterarescola = cursoalterarescola;
    }

    public List<Grupoacesso> getGrupoacessoList() {
        return grupoacessoList;
    }

    public void setGrupoacessoList(List<Grupoacesso> grupoacessoList) {
        this.grupoacessoList = grupoacessoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idacesso != null ? idacesso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acesso)) {
            return false;
        }
        Acesso other = (Acesso) object;
        if ((this.idacesso == null && other.idacesso != null) || (this.idacesso != null && !this.idacesso.equals(other.idacesso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.travelmate.model.Acesso[ idacesso=" + idacesso + " ]";
    }
    
}
