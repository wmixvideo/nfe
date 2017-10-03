package com.fincatto.documentofiscal.cte200.classes.cte;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte200.classes.CTResponsavelSeguro;

public class CTInfoSeguro extends DFBase {
    private static final long serialVersionUID = 9195752068106292630L;

    @Element(name = "respSeg")
    private CTResponsavelSeguro responsavelSeguro;

    @Element(name = "xSeg", required = false)
    private String nomeSeguradora;

    @Element(name = "nApol", required = false)
    private String numeroApolice;

    @Element(name = "nAver", required = false)
    private String numeroAverbacao;

    @Element(name = "vCarga", required = false)
    private String valorCarga;

    public CTResponsavelSeguro getResponsavelSeguro() {
        return this.responsavelSeguro;
    }

    public void setResponsavelSeguro(final CTResponsavelSeguro responsavelSeguro) {
        this.responsavelSeguro = responsavelSeguro;
    }

    public String getNomeSeguradora() {
        return this.nomeSeguradora;
    }

    public void setNomeSeguradora(final String nomeSeguradora) {
        this.nomeSeguradora = nomeSeguradora;
    }

    public String getNumeroApolice() {
        return this.numeroApolice;
    }

    public void setNumeroApolice(final String numeroApolice) {
        this.numeroApolice = numeroApolice;
    }

    public String getNumeroAverbacao() {
        return this.numeroAverbacao;
    }

    public void setNumeroAverbacao(final String numeroAverbacao) {
        this.numeroAverbacao = numeroAverbacao;
    }

    public String getValorCarga() {
        return this.valorCarga;
    }

    public void setValorCarga(final String valorCarga) {
        this.valorCarga = valorCarga;
    }

}
