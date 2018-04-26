package com.fincatto.documentofiscal.nfe310.classes.evento.inutilizacao;

import java.time.LocalDateTime;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;

public class NFRetornoEventoInutilizacaoDados extends DFBase {
    private static final long serialVersionUID = -6732103693589079116L;

    @Attribute(name = "Id", required = false)
    private String identificador;

    @Element(name = "tpAmb", required = true)
    private DFAmbiente ambiente;

    @Element(name = "verAplic", required = true)
    private String versaoAplicacao;

    @Element(name = "cStat", required = true)
    private String status;

    @Element(name = "xMotivo", required = true)
    private String motivo;

    @Element(name = "cUF", required = true)
    private DFUnidadeFederativa uf;

    @Element(name = "ano", required = false)
    private Integer ano;

    @Element(name = "CNPJ", required = false)
    private String cnpj;

    @Element(name = "mod", required = false)
    private String modeloNotaFiscal;

    @Element(name = "serie", required = false)
    private String serie;

    @Element(name = "nNFIni", required = false)
    private String numeroNFInicial;

    @Element(name = "nNFFin", required = false)
    private String numeroNFFinal;

    @Element(name = "dhRecbto", required = false)
    private LocalDateTime datahoraRecebimento;

    @Element(name = "nProt", required = false)
    private String numeroProtocolo;

    public String getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(final String identificador) {
        this.identificador = identificador;
    }

    public DFAmbiente getAmbiente() {
        return this.ambiente;
    }

    public void setAmbiente(final DFAmbiente ambiente) {
        this.ambiente = ambiente;
    }

    public String getVersaoAplicacao() {
        return this.versaoAplicacao;
    }

    public void setVersaoAplicacao(final String versaoAplicacao) {
        this.versaoAplicacao = versaoAplicacao;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(final String status) {
        this.status = status;
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

    public Integer getAno() {
        return this.ano;
    }

    public void setAno(final Integer ano) {
        this.ano = ano;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(final String cnpj) {
        this.cnpj = cnpj;
    }

    public String getModeloNotaFiscal() {
        return this.modeloNotaFiscal;
    }

    public void setModeloNotaFiscal(final String modeloNotaFiscal) {
        this.modeloNotaFiscal = modeloNotaFiscal;
    }

    public String getSerie() {
        return this.serie;
    }

    public void setSerie(final String serie) {
        this.serie = serie;
    }

    public String getNumeroNFInicial() {
        return this.numeroNFInicial;
    }

    public void setNumeroNFInicial(final String numeroNFInicial) {
        this.numeroNFInicial = numeroNFInicial;
    }

    public String getNumeroNFFinal() {
        return this.numeroNFFinal;
    }

    public void setNumeroNFFinal(final String numeroNFFinal) {
        this.numeroNFFinal = numeroNFFinal;
    }

    public LocalDateTime getDatahoraRecebimento() {
        return this.datahoraRecebimento;
    }

    public void setDatahoraRecebimento(final LocalDateTime datahoraRecebimento) {
        this.datahoraRecebimento = datahoraRecebimento;
    }

    public String getNumeroProtocolo() {
        return this.numeroProtocolo;
    }

    public void setNumeroProtocolo(final String numeroProtocolo) {
        this.numeroProtocolo = numeroProtocolo;
    }
}