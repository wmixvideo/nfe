package com.fincatto.documentofiscal.cte200.classes.cte;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;

public class CTInfoCargaPerigosa extends DFBase {
    private static final long serialVersionUID = 5328235036325178938L;

    @Element(name = "nOnu")
    private String numeroOnu;

    @Element(name = "xNomeAE", required = false)
    private String nomeApropriadoEmbarque;

    @Element(name = "xClaRisco", required = false)
    private String classeRisco;

    @Element(name = "grEmb", required = false)
    private String grupoEmbalagem;

    @Element(name = "qTotProd")
    private String quantidadeTotalProduto;

    @Element(name = "qVolTipo", required = false)
    private String quantidadeTipoVolume;

    @Element(name = "pontoFulgor", required = false)
    private String pontoFulgor;

    public String getNumeroOnu() {
        return this.numeroOnu;
    }

    public void setNumeroOnu(final String numeroOnu) {
        this.numeroOnu = numeroOnu;
    }

    public String getNomeApropriadoEmbarque() {
        return this.nomeApropriadoEmbarque;
    }

    public void setNomeApropriadoEmbarque(final String nomeApropriadoEmbarque) {
        this.nomeApropriadoEmbarque = nomeApropriadoEmbarque;
    }

    public String getClasseRisco() {
        return this.classeRisco;
    }

    public void setClasseRisco(final String classeRisco) {
        this.classeRisco = classeRisco;
    }

    public String getGrupoEmbalagem() {
        return this.grupoEmbalagem;
    }

    public void setGrupoEmbalagem(final String grupoEmbalagem) {
        this.grupoEmbalagem = grupoEmbalagem;
    }

    public String getQuantidadeTotalProduto() {
        return this.quantidadeTotalProduto;
    }

    public void setQuantidadeTotalProduto(final String quantidadeTotalProduto) {
        this.quantidadeTotalProduto = quantidadeTotalProduto;
    }

    public String getQuantidadeTipoVolume() {
        return this.quantidadeTipoVolume;
    }

    public void setQuantidadeTipoVolume(final String quantidadeTipoVolume) {
        this.quantidadeTipoVolume = quantidadeTipoVolume;
    }

    public String getPontoFulgor() {
        return this.pontoFulgor;
    }

    public void setPontoFulgor(final String pontoFulgor) {
        this.pontoFulgor = pontoFulgor;
    }

}
