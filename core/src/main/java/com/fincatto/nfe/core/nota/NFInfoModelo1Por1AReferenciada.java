package com.fincatto.nfe.core.nota;

import com.fincatto.nfe.core.NFBase;
import com.fincatto.nfe.core.NFUnidadeFederativa;
import com.fincatto.nfe.core.validadores.IntegerValidador;
import com.fincatto.nfe.core.validadores.StringValidador;
import org.simpleframework.xml.Element;

public class NFInfoModelo1Por1AReferenciada extends NFBase {
    @Element(name = "cUF", required = true)
    private NFUnidadeFederativa uf;

    @Element(name = "AAMM", required = true)
    private String anoMesEmissaoNFe;

    @Element(name = "CNPJ", required = true)
    private String cnpj;

    @Element(name = "mod", required = true)
    private String modeloDocumentoFiscal;

    @Element(name = "serie", required = true)
    private Integer serie;

    @Element(name = "nNF", required = false)
    private String numeroDocumentoFiscal;

    public void setUf(final NFUnidadeFederativa uf) {
        this.uf = uf;
    }

    public void setAnoMesEmissaoNFe(final String anoMesEmissaoNFe) {
        StringValidador.aamm(anoMesEmissaoNFe);
        this.anoMesEmissaoNFe = anoMesEmissaoNFe;
    }

    public void setCnpj(final String cnpj) {
        StringValidador.cnpj(cnpj);
        this.cnpj = cnpj;
    }

    public void setModeloDocumentoFiscal(final String modeloDocumentoFiscal) {
        StringValidador.exatamente2(modeloDocumentoFiscal, "Modelo Documento Fiscal");
        this.modeloDocumentoFiscal = modeloDocumentoFiscal;
    }

    public void setSerie(final Integer serie) {
        IntegerValidador.tamanho3(serie, "Serie");
        this.serie = serie;
    }

    public void setNumeroDocumentoFiscal(final String numeroDocumentoFiscal) {
        StringValidador.tamanho9(numeroDocumentoFiscal, "Numero Documento Fiscal");
        this.numeroDocumentoFiscal = numeroDocumentoFiscal;
    }

    public NFUnidadeFederativa getUf() {
        return this.uf;
    }

    public String getAnoMesEmissaoNFe() {
        return this.anoMesEmissaoNFe;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public String getModeloDocumentoFiscal() {
        return this.modeloDocumentoFiscal;
    }

    public Integer getSerie() {
        return this.serie;
    }

    public String getNumeroDocumentoFiscal() {
        return this.numeroDocumentoFiscal;
    }
}