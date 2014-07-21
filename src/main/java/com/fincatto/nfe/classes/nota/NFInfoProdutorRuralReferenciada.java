package com.fincatto.nfe.classes.nota;

import org.joda.time.LocalDate;
import org.simpleframework.xml.Element;

import com.fincatto.nfe.NFUnidadeFederativa;
import com.fincatto.nfe.classes.NFBase;

public class NFInfoProdutorRuralReferenciada extends NFBase {
    @Element(name = "cUF", required = true)
    private NFUnidadeFederativa ufEmitente;

    @Element(name = "AAMM", required = true)
    private LocalDate anoMesEmissao;

    @Element(name = "CNPJ", required = false)
    private String cnpjEmitente;

    @Element(name = "CPF", required = false)
    private String cpfEmitente;

    @Element(name = "IE", required = true)
    private String ieEmitente;

    @Element(name = "mod", required = true)
    private String modeloDocumentoFiscal;

    @Element(name = "serie", required = true)
    private int serieDocumentoFiscal;

    @Element(name = "nNF", required = false)
    private String numeroDocumentoFiscal;

    @Element(name = "refCTe", required = false)
    private String chaveAcessoCTReferenciada;

    public NFUnidadeFederativa getUfEmitente() {
        return this.ufEmitente;
    }

    public void setUfEmitente(final NFUnidadeFederativa ufEmitente) {
        this.ufEmitente = ufEmitente;
    }

    public LocalDate getAnoMesEmissao() {
        return this.anoMesEmissao;
    }

    public void setAnoMesEmissao(final LocalDate anoMesEmissao) {
        this.anoMesEmissao = anoMesEmissao;
    }

    public String getCnpjEmitente() {
        return this.cnpjEmitente;
    }

    public void setCnpjEmitente(final String cnpjEmitente) {
        this.cnpjEmitente = cnpjEmitente;
    }

    public String getCpfEmitente() {
        return this.cpfEmitente;
    }

    public void setCpfEmitente(final String cpfEmitente) {
        this.cpfEmitente = cpfEmitente;
    }

    public String getIeEmitente() {
        return this.ieEmitente;
    }

    public void setIeEmitente(final String ieEmitente) {
        this.ieEmitente = ieEmitente;
    }

    public String getModeloDocumentoFiscal() {
        return this.modeloDocumentoFiscal;
    }

    public void setModeloDocumentoFiscal(final String modeloDocumentoFiscal) {
        this.modeloDocumentoFiscal = modeloDocumentoFiscal;
    }

    public int getSerieDocumentoFiscal() {
        return this.serieDocumentoFiscal;
    }

    public void setSerieDocumentoFiscal(final int serieDocumentoFiscal) {
        this.serieDocumentoFiscal = serieDocumentoFiscal;
    }

    public String getNumeroDocumentoFiscal() {
        return this.numeroDocumentoFiscal;
    }

    public void setNumeroDocumentoFiscal(final String numeroDocumentoFiscal) {
        this.numeroDocumentoFiscal = numeroDocumentoFiscal;
    }

    public String getChaveAcessoCTReferenciada() {
        return this.chaveAcessoCTReferenciada;
    }

    public void setChaveAcessoCTReferenciada(final String chaveAcessoCTReferenciada) {
        this.chaveAcessoCTReferenciada = chaveAcessoCTReferenciada;
    }
}