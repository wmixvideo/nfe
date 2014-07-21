package com.fincatto.nfe.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;

public class NFInfoCupomFiscalReferenciado extends NFBase {
    @Element(name = "mod", required = true)
    private String modeloDocumentoFiscal;

    @Element(name = "nECF", required = true)
    private String numeroOrdemSequencialECF;

    @Element(name = "nCOO", required = true)
    private String numeroContadorOrdemOperacao;

    public String getModeloDocumentoFiscal() {
        return this.modeloDocumentoFiscal;
    }

    public void setModeloDocumentoFiscal(final String modeloDocumentoFiscal) {
        this.modeloDocumentoFiscal = modeloDocumentoFiscal;
    }

    public String getNumeroOrdemSequencialECF() {
        return this.numeroOrdemSequencialECF;
    }

    public void setNumeroOrdemSequencialECF(final String numeroOrdemSequencialECF) {
        this.numeroOrdemSequencialECF = numeroOrdemSequencialECF;
    }

    public String getNumeroContadorOrdemOperacao() {
        return this.numeroContadorOrdemOperacao;
    }

    public void setNumeroContadorOrdemOperacao(final String numeroContadorOrdemOperacao) {
        this.numeroContadorOrdemOperacao = numeroContadorOrdemOperacao;
    }
}