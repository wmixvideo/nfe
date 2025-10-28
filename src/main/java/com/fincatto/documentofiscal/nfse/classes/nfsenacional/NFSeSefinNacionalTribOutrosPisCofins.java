
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

/**
 * Grupo de informações dos tributos PIS/COFINS
 */

@Root(name = "TribOutrosPisCofins")
public class NFSeSefinNacionalTribOutrosPisCofins {

    @Element(name="CST")
    protected NFSeSefinNacionalTribOutrosPisCofinsSituacaoTributaria situacaoTributaria;
    @Element(name="vBCPisCofins", required=false)
    protected String valorBaseCalculoPisCofins;
    @Element(name="pAliqPis", required=false)
    protected String aliquotaPIS;
    @Element(name="pAliqCofins", required=false)
    protected String aliquotaCOFINS;
    @Element(name="vPis", required=false)
    protected String valorPIS;
    @Element(name="vCofins", required=false)
    protected String valorCOFINS;
    @Element(name="tpRetPisCofins", required=false)
    protected NFSeSefinNacionalTribOutrosPisCofinsTipoRetencao tipoRetencao;

    /**
     * @return Situação Tributária do PIS/COFINS
     */
    public NFSeSefinNacionalTribOutrosPisCofinsSituacaoTributaria getSituacaoTributaria() {
        return situacaoTributaria;
    }

    /**
     * @param value Situação Tributária do PIS/COFINS
     */
    public NFSeSefinNacionalTribOutrosPisCofins setCST(NFSeSefinNacionalTribOutrosPisCofinsSituacaoTributaria value) {
        this.situacaoTributaria = value;
        return this;
    }

    public String getValorBaseCalculoPisCofins() {
        return valorBaseCalculoPisCofins;
    }

    public void setValorBaseCalculoPisCofins(String value) {
        this.valorBaseCalculoPisCofins = value;
    }

    public String getAliquotaPIS() {
        return aliquotaPIS;
    }

    public void setAliquotaPIS(String value) {
        this.aliquotaPIS = value;
    }

    public String getAliquotaCOFINS() {
        return aliquotaCOFINS;
    }

    public void setAliquotaCOFINS(String value) {
        this.aliquotaCOFINS = value;
    }

    public String getValorPIS() {
        return valorPIS;
    }

    public void setValorPIS(String value) {
        this.valorPIS = value;
    }

    public String getValorCofins() {
        return valorCOFINS;
    }

    public void setValorCofins(String value) {
        this.valorCOFINS = value;
    }

    public NFSeSefinNacionalTribOutrosPisCofinsTipoRetencao getTipoRetencao() {
        return tipoRetencao;
    }

    public void setTipoRetencao(NFSeSefinNacionalTribOutrosPisCofinsTipoRetencao value) {
        this.tipoRetencao = value;
    }

}
