package com.fincatto.nfe310.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.validadores.StringValidador;

public class NFInfoCupomFiscalReferenciado extends NFBase {
    @Element(name = "mod", required = true)
    private String modeloDocumentoFiscal;

    @Element(name = "nECF", required = true)
    private String numeroOrdemSequencialECF;

    @Element(name = "nCOO", required = true)
    private String numeroContadorOrdemOperacao;

    public void setModeloDocumentoFiscal(final String modeloDocumentoFiscal) {
        StringValidador.exatamente2(modeloDocumentoFiscal);
        this.modeloDocumentoFiscal = modeloDocumentoFiscal;
    }

    public void setNumeroOrdemSequencialECF(final String numeroOrdemSequencialECF) {
        StringValidador.exatamente3(numeroOrdemSequencialECF);
        this.numeroOrdemSequencialECF = numeroOrdemSequencialECF;
    }

    public void setNumeroContadorOrdemOperacao(final String numeroContadorOrdemOperacao) {
        StringValidador.exatamente6(numeroContadorOrdemOperacao);
        this.numeroContadorOrdemOperacao = numeroContadorOrdemOperacao;
    }

    public String getModeloDocumentoFiscal() {
        return this.modeloDocumentoFiscal;
    }

    public String getNumeroContadorOrdemOperacao() {
        return this.numeroContadorOrdemOperacao;
    }

    public String getNumeroOrdemSequencialECF() {
        return this.numeroOrdemSequencialECF;
    }
}