package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.validadores.DFIntegerValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;

public class NFInfoModelo1Por1AReferenciada extends DFBase {
    private static final long serialVersionUID = 4441065943167631316L;
    
    @Element(name = "cUF")
    private DFUnidadeFederativa uf;
    
    @Element(name = "AAMM")
    private String anoMesEmissaoNFe;
    
    @Element(name = "CNPJ")
    private String cnpj;
    
    @Element(name = "mod")
    private String modeloDocumentoFiscal;
    
    @Element(name = "serie")
    private Integer serie;

    @Element(name = "nNF", required = false)
    private String numeroDocumentoFiscal;

    public void setUf(final DFUnidadeFederativa uf) {
        this.uf = uf;
    }

    public void setAnoMesEmissaoNFe(final String anoMesEmissaoNFe) {
        DFStringValidador.aamm(anoMesEmissaoNFe);
        this.anoMesEmissaoNFe = anoMesEmissaoNFe;
    }

    public void setCnpj(final String cnpj) {
        DFStringValidador.cnpj(cnpj);
        this.cnpj = cnpj;
    }

    public void setModeloDocumentoFiscal(final String modeloDocumentoFiscal) {
        DFStringValidador.exatamente2(modeloDocumentoFiscal, "Modelo Documento Fiscal");
        this.modeloDocumentoFiscal = modeloDocumentoFiscal;
    }

    public void setSerie(final Integer serie) {
        DFIntegerValidador.tamanho3(serie, "Serie");
        this.serie = serie;
    }

    public void setNumeroDocumentoFiscal(final String numeroDocumentoFiscal) {
        DFStringValidador.tamanho9(numeroDocumentoFiscal, "Numero Documento Fiscal");
        this.numeroDocumentoFiscal = numeroDocumentoFiscal;
    }

    public DFUnidadeFederativa getUf() {
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