package com.fincatto.documentofiscal.nfe400.classes.cadastro;

import java.time.LocalDate;
import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;

public class NFRetornoConsultaCadastroSituacaoCadastral extends DFBase {
    private static final long serialVersionUID = 7375181464271665520L;

    @Element(name = "IE", required = true)
    private String inscricaoEstadual;

    @Element(name = "CNPJ", required = false)
    private String cnpj;

    @Element(name = "CPF", required = false)
    private String cpf;

    @Element(name = "UF", required = true)
    private DFUnidadeFederativa uf;

    @Element(name = "cSit", required = true)
    private NFSituacaoContribuinte situacaoContribuinte;

    @Element(name = "indCredNFe", required = false)
    private NFIndicadorContribuinteNFe indicadorContribuinteNFe;

    @Element(name = "indCredCTe", required = false)
    private NFIndicadorContribuinteCTe indicaodrContribuinteCTe;

    @Element(name = "xNome", required = true)
    private String razaoSocial;

    @Element(name = "xFant", required = false)
    private String nomeFantasia;

    @Element(name = "xRegApur", required = false)
    private String regimeApuracaoICMSContribuinte;

    @Element(name = "CNAE", required = false)
    private String cnaePrincipalContribuinte;

    @Element(name = "dIniAtiv", required = false)
    private LocalDate dataInicioAtividade;

    @Element(name = "dUltSit", required = false)
    private LocalDate dataUltimaModificacaoSituacaoCadastral;

    @Element(name = "dBaixa", required = false)
    private LocalDate dataOcorrenciaBaixa;

    @Element(name = "IEUnica", required = false)
    private String inscricaoEstadualUnica;

    @Element(name = "IEAtual", required = false)
    private String inscricaoEstadualAtual;

    @Element(name = "ender", required = false)
    private NFRetornoConsultaCadastroEndereco endereco;

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

    public DFUnidadeFederativa getUf() {
        return this.uf;
    }

    public void setUf(final DFUnidadeFederativa uf) {
        this.uf = uf;
    }

    public NFSituacaoContribuinte getSituacaoContribuinte() {
        return this.situacaoContribuinte;
    }

    public void setSituacaoContribuinte(final NFSituacaoContribuinte situacaoContribuinte) {
        this.situacaoContribuinte = situacaoContribuinte;
    }

    public NFIndicadorContribuinteNFe getIndicadorContribuinteNFe() {
        return this.indicadorContribuinteNFe;
    }

    public void setIndicadorContribuinteNFe(final NFIndicadorContribuinteNFe indicadorContribuinteNFe) {
        this.indicadorContribuinteNFe = indicadorContribuinteNFe;
    }

    public NFIndicadorContribuinteCTe getIndicaodrContribuinteCTe() {
        return this.indicaodrContribuinteCTe;
    }

    public void setIndicaodrContribuinteCTe(final NFIndicadorContribuinteCTe indicaodrContribuinteCTe) {
        this.indicaodrContribuinteCTe = indicaodrContribuinteCTe;
    }

    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    public void setRazaoSocial(final String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return this.nomeFantasia;
    }

    public void setNomeFantasia(final String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRegimeApuracaoICMSContribuinte() {
        return this.regimeApuracaoICMSContribuinte;
    }

    public void setRegimeApuracaoICMSContribuinte(final String regimeApuracaoICMSContribuinte) {
        this.regimeApuracaoICMSContribuinte = regimeApuracaoICMSContribuinte;
    }

    public String getCnaePrincipalContribuinte() {
        return this.cnaePrincipalContribuinte;
    }

    public void setCnaePrincipalContribuinte(final String cnaePrincipalContribuinte) {
        this.cnaePrincipalContribuinte = cnaePrincipalContribuinte;
    }

    public LocalDate getDataInicioAtividade() {
        return this.dataInicioAtividade;
    }

    public void setDataInicioAtividade(final LocalDate dataInicioAtividade) {
        this.dataInicioAtividade = dataInicioAtividade;
    }

    public LocalDate getDataUltimaModificacaoSituacaoCadastral() {
        return this.dataUltimaModificacaoSituacaoCadastral;
    }

    public void setDataUltimaModificacaoSituacaoCadastral(final LocalDate dataUltimaModificacaoSituacaoCadastral) {
        this.dataUltimaModificacaoSituacaoCadastral = dataUltimaModificacaoSituacaoCadastral;
    }

    public LocalDate getDataOcorrenciaBaixa() {
        return this.dataOcorrenciaBaixa;
    }

    public void setDataOcorrenciaBaixa(final LocalDate dataOcorrenciaBaixa) {
        this.dataOcorrenciaBaixa = dataOcorrenciaBaixa;
    }

    public String getInscricaoEstadualUnica() {
        return this.inscricaoEstadualUnica;
    }

    public void setInscricaoEstadualUnica(final String inscricaoEstadualUnica) {
        this.inscricaoEstadualUnica = inscricaoEstadualUnica;
    }

    public String getInscricaoEstadualAtual() {
        return this.inscricaoEstadualAtual;
    }

    public void setInscricaoEstadualAtual(final String inscricaoEstadualAtual) {
        this.inscricaoEstadualAtual = inscricaoEstadualAtual;
    }

    public NFRetornoConsultaCadastroEndereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(final NFRetornoConsultaCadastroEndereco endereco) {
        this.endereco = endereco;
    }
}