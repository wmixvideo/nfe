package com.fincatto.nfe.classes.nota;

import org.joda.time.LocalDate;
import org.simpleframework.xml.Element;

import com.fincatto.nfe.NFUnidadeFederativa;
import com.fincatto.nfe.classes.NFBase;

public class NFInfoModelo1Por1AReferenciada extends NFBase {

    @Element(name = "cUF", required = true)
    private NFUnidadeFederativa uf;

    @Element(name = "AAMM", required = true)
    private LocalDate anoMesEmissaoNFe;

    @Element(name = "CNPJ", required = true)
    private String cnpj;

    @Element(name = "mod", required = true)
    private String modeloDocumentoFiscal;

    @Element(name = "serie", required = true)
    private int serie;

    @Element(name = "nNF", required = false)
    private String numeroDocumentoFiscal;

    @Element(name = "refNFP", required = false)
    private NFInfoProdutorRuralReferenciada infoNFProdutorRuralReferenciada;

    @Element(name = "refECF", required = false)
    private NFInfoCupomFiscalReferenciado cupomFiscalReferenciado;

    public NFUnidadeFederativa getUf() {
        return this.uf;
    }

    public void setUf(final NFUnidadeFederativa uf) {
        this.uf = uf;
    }

    public LocalDate getAnoMesEmissaoNFe() {
        return this.anoMesEmissaoNFe;
    }

    public void setAnoMesEmissaoNFe(final LocalDate anoMesEmissaoNFe) {
        this.anoMesEmissaoNFe = anoMesEmissaoNFe;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(final String cnpj) {
        this.cnpj = cnpj;
    }

    public String getModeloDocumentoFiscal() {
        return this.modeloDocumentoFiscal;
    }

    public void setModeloDocumentoFiscal(final String modeloDocumentoFiscal) {
        this.modeloDocumentoFiscal = modeloDocumentoFiscal;
    }

    public int getSerie() {
        return this.serie;
    }

    public void setSerie(final int serie) {
        this.serie = serie;
    }

    public String getNumeroDocumentoFiscal() {
        return this.numeroDocumentoFiscal;
    }

    public void setNumeroDocumentoFiscal(final String numeroDocumentoFiscal) {
        this.numeroDocumentoFiscal = numeroDocumentoFiscal;
    }

    public NFInfoProdutorRuralReferenciada getInfoNFProdutorRuralReferenciada() {
        return this.infoNFProdutorRuralReferenciada;
    }

    public void setInfoNFProdutorRuralReferenciada(final NFInfoProdutorRuralReferenciada infoNFProdutorRuralReferenciada) {
        this.infoNFProdutorRuralReferenciada = infoNFProdutorRuralReferenciada;
    }

    public NFInfoCupomFiscalReferenciado getCupomFiscalReferenciado() {
        return this.cupomFiscalReferenciado;
    }

    public void setCupomFiscalReferenciado(final NFInfoCupomFiscalReferenciado cupomFiscalReferenciado) {
        this.cupomFiscalReferenciado = cupomFiscalReferenciado;
    }
}