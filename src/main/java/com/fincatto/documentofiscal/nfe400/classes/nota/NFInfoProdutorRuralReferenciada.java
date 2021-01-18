package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.validadores.DFIntegerValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;

public class NFInfoProdutorRuralReferenciada extends DFBase {
    private static final long serialVersionUID = -2718285687811273188L;
    
    @Element(name = "cUF")
    private DFUnidadeFederativa ufEmitente;
    
    @Element(name = "AAMM")
    private String anoMesEmissao;

    @Element(name = "CNPJ", required = false)
    private String cnpjEmitente;

    @Element(name = "CPF", required = false)
    private String cpfEmitente;
    
    @Element(name = "IE")
    private String ieEmitente;
    
    @Element(name = "mod")
    private String modeloDocumentoFiscal;
    
    @Element(name = "serie")
    private Integer serieDocumentoFiscal;
    
    @Element(name = "nNF")
    private Integer numeroDocumentoFiscal;

    public void setUfEmitente(final DFUnidadeFederativa ufEmitente) {
        this.ufEmitente = ufEmitente;
    }

    public void setAnoMesEmissao(final String anoMesEmissao) {
        DFStringValidador.aamm(anoMesEmissao);
        this.anoMesEmissao = anoMesEmissao;
    }

    public void setCnpjEmitente(final String cnpjEmitente) {
        if (this.cpfEmitente != null) {
            throw new IllegalStateException("Nao pode setar CNPJ pois CPF ja esta setado");
        }
        DFStringValidador.cnpj(cnpjEmitente);
        this.cnpjEmitente = cnpjEmitente;
    }

    public void setCpfEmitente(final String cpfEmitente) {
        if (this.cnpjEmitente != null) {
            throw new IllegalStateException("Nao pode setar CPF pois CNPJ ja esta setado");
        }
        DFStringValidador.cpf(cpfEmitente);
        this.cpfEmitente = cpfEmitente;
    }

    public void setIeEmitente(final String ieEmitente) {
        DFStringValidador.inscricaoEstadual(ieEmitente);
        this.ieEmitente = ieEmitente;
    }

    public void setModeloDocumentoFiscal(final String modeloDocumentoFiscal) {
        DFStringValidador.exatamente2(modeloDocumentoFiscal, "Modelo Documento Fiscal");
        this.modeloDocumentoFiscal = modeloDocumentoFiscal;
    }

    public void setSerieDocumentoFiscal(final Integer serieDocumentoFiscal) {
        DFIntegerValidador.tamanho3(serieDocumentoFiscal, "Serie Documento Fiscal");
        this.serieDocumentoFiscal = serieDocumentoFiscal;
    }

    /**
     * Número do Documento Fiscal - 1 – 999999999
     * @param numeroDocumentoFiscal
     */
    public void setNumeroDocumentoFiscal(final Integer numeroDocumentoFiscal) {
        DFIntegerValidador.tamanho9(numeroDocumentoFiscal, "Numero Documento Fiscal");
        this.numeroDocumentoFiscal = numeroDocumentoFiscal;
    }

    public DFUnidadeFederativa getUfEmitente() {
        return this.ufEmitente;
    }

    public String getAnoMesEmissao() {
        return this.anoMesEmissao;
    }

    public String getCnpjEmitente() {
        return this.cnpjEmitente;
    }

    public String getCpfEmitente() {
        return this.cpfEmitente;
    }

    public String getIeEmitente() {
        return this.ieEmitente;
    }

    public String getModeloDocumentoFiscal() {
        return this.modeloDocumentoFiscal;
    }

    public Integer getSerieDocumentoFiscal() {
        return this.serieDocumentoFiscal;
    }

    public Integer getNumeroDocumentoFiscal() {
        return this.numeroDocumentoFiscal;
    }
}