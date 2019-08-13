package com.fincatto.documentofiscal.nfe310.classes.cadastro;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.time.ZonedDateTime;
import java.util.List;

public class NFRetornoConsultaCadastroDados extends DFBase {
    
    private static final long serialVersionUID = -7130690235919558202L;
    
    @Element(name = "verAplic")
    private String versaoAplicacao;
    
    @Element(name = "cStat")
    private String statusResposta;
    
    @Element(name = "xMotivo")
    private String motivo;
    
    @Element(name = "UF", required = false)
    private DFUnidadeFederativa uf;
    
    @Element(name = "IE", required = false)
    private String inscricaoEstadual;
    
    @Element(name = "CNPJ", required = false)
    private String cnpj;
    
    @Element(name = "CPF", required = false)
    private String cpf;
    
    @Element(name = "dhCons", required = false)
    private ZonedDateTime dataHoraProcessamento;
    
    @Element(name = "cUF")
    private DFUnidadeFederativa ufAutorizadora;
    
    @ElementList(inline = true, entry = "infCad", required = false)
    private List<NFRetornoConsultaCadastroSituacaoCadastral> situacaoCadastral;
    
    public String getVersaoAplicacao() {
        return this.versaoAplicacao;
    }
    
    public void setVersaoAplicacao(final String versaoAplicacao) {
        this.versaoAplicacao = versaoAplicacao;
    }
    
    public String getStatusResposta() {
        return this.statusResposta;
    }
    
    public void setStatusResposta(final String statusResposta) {
        this.statusResposta = statusResposta;
    }
    
    public String getMotivo() {
        return this.motivo;
    }
    
    public void setMotivo(final String motivo) {
        this.motivo = motivo;
    }
    
    public DFUnidadeFederativa getUf() {
        return this.uf;
    }
    
    public void setUf(final DFUnidadeFederativa uf) {
        this.uf = uf;
    }
    
    public String getInscricaoEstadual() {
        return this.inscricaoEstadual;
    }
    
    public void setInscricaoEstadual(final String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }
    
    public String getCnpj() {
        return this.cnpj;
    }
    
    public void setCnpj(final String cnpj) {
        this.cnpj = cnpj;
    }
    
    public String getCpf() {
        return this.cpf;
    }
    
    public void setCpf(final String cpf) {
        this.cpf = cpf;
    }
    
    public ZonedDateTime getDataHoraProcessamento() {
        return this.dataHoraProcessamento;
    }
    
    public void setDataHoraProcessamento(final ZonedDateTime dataHoraProcessamento) {
        this.dataHoraProcessamento = dataHoraProcessamento;
    }
    
    public DFUnidadeFederativa getUfAutorizadora() {
        return this.ufAutorizadora;
    }
    
    public void setUfAutorizadora(final DFUnidadeFederativa ufAutorizadora) {
        this.ufAutorizadora = ufAutorizadora;
    }
    
    public List<NFRetornoConsultaCadastroSituacaoCadastral> getSituacaoCadastral() {
        return this.situacaoCadastral;
    }
    
    public void setSituacaoCadastral(final List<NFRetornoConsultaCadastroSituacaoCadastral> situacaoCadastral) {
        this.situacaoCadastral = situacaoCadastral;
    }
}