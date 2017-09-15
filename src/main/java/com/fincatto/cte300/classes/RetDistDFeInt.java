package com.fincatto.cte300.classes;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import wmix.processosweb.cte.LoteDistDFeInt;

public class RetDistDFeInt {

    @Attribute(name = "versao")
    private String versao;

    @Element(name = "tpAmb")
    private String ambiente;

    @Element(name = "verAplic")
    private String versaoAplicativo;

    @Element(name = "cStat")
    private String codigoStatusReposta;

    @Element(name = "xMotivo")
    private String motivo;

    @Element(name = "dhResp")
    private String dataHoraResposta;

    @Element(name = "ultNSU")
    private String ultNSU;

    @Element(name = "maxNSU")
    private String maxNSU;

    @Element(name = "loteDistDFeInt")
    private LoteDistDFeInt loteDistDFeInt;

    public String getVersao() {
        return this.versao;
    }

    public void setVersao(final String versao) {
        this.versao = versao;
    }

    public String getAmbiente() {
        return this.ambiente;
    }

    public void setAmbiente(final String ambiente) {
        this.ambiente = ambiente;
    }

    public String getVersaoAplicativo() {
        return this.versaoAplicativo;
    }

    public void setVersaoAplicativo(final String versaoAplicativo) {
        this.versaoAplicativo = versaoAplicativo;
    }

    public String getCodigoStatusReposta() {
        return this.codigoStatusReposta;
    }

    public void setCodigoStatusReposta(final String codigoStatusReposta) {
        this.codigoStatusReposta = codigoStatusReposta;
    }

    public String getMotivo() {
        return this.motivo;
    }

    public void setMotivo(final String motivo) {
        this.motivo = motivo;
    }

    public String getDataHoraResposta() {
        return this.dataHoraResposta;
    }

    public void setDataHoraResposta(final String dataHoraResposta) {
        this.dataHoraResposta = dataHoraResposta;
    }

    public String getUltNSU() {
        return this.ultNSU;
    }

    public void setUltNSU(final String ultNSU) {
        this.ultNSU = ultNSU;
    }

    public String getMaxNSU() {
        return this.maxNSU;
    }

    public void setMaxNSU(final String maxNSU) {
        this.maxNSU = maxNSU;
    }

    public LoteDistDFeInt getLoteDistDFeInt() {
        return this.loteDistDFeInt;
    }

    public void setLoteDistDFeInt(final LoteDistDFeInt loteDistDFeInt) {
        this.loteDistDFeInt = loteDistDFeInt;
    }

    @Override
    public String toString() {
        return "RetDistDFeInt [versao=" + this.versao + ", ambiente=" + this.ambiente + ", versaoAplicativo=" + this.versaoAplicativo + ", codigoStatusReposta=" + this.codigoStatusReposta + ", motivo=" + this.motivo + ", dataHoraResposta=" + this.dataHoraResposta + ", ultNSU=" + this.ultNSU + ", maxNSU=" + this.maxNSU + ", loteDistDFeInt=" + this.loteDistDFeInt + "]";
    }

}
