package com.fincatto.documentofiscal.cte300.classes.evento.inutilizacao;

import java.time.ZonedDateTime;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;

public class CTeRetornoEventoInutilizacaoDados extends DFBase {
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

    @Element(name = "nCTIni", required = false)
    private String numeroCTInicial;

    @Element(name = "nCTFin", required = false)
    private String numeroCTFinal;

    @Element(name = "dhRecbto", required = false)
    private ZonedDateTime datahoraRecebimento;

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
        return this.numeroCTInicial;
    }

    public void setNumeroNFInicial(final String numeroNFInicial) {
        this.numeroCTInicial = numeroNFInicial;
    }

    public String getNumeroNFFinal() {
        return this.numeroCTFinal;
    }

    public void setNumeroNFFinal(final String numeroNFFinal) {
        this.numeroCTFinal = numeroNFFinal;
    }

    public ZonedDateTime getDatahoraRecebimento() {
        return this.datahoraRecebimento;
    }

    public void setDatahoraRecebimento(final ZonedDateTime datahoraRecebimento) {
        this.datahoraRecebimento = datahoraRecebimento;
    }

    public String getNumeroProtocolo() {
        return this.numeroProtocolo;
    }

    public void setNumeroProtocolo(final String numeroProtocolo) {
        this.numeroProtocolo = numeroProtocolo;
    }
}