
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "TribTotal")
public class NFSeSefinNacionalTribTotal {

    @Element(name = "vTotTrib", required = false)
    protected NFSeSefinNacionalTribTotalMonet valorTotalTributos;
    @Element(name = "pTotTrib", required = false)
    protected NFSeSefinNacionalTribTotalPercent percentualTotalTributos;
    @Element(name = "indTotTrib", required = false)
    protected String indicadorValorTotalTributos = "0";
    @Element(name = "pTotTribSN", required = false)
    protected String percentualTotalSimplesNacional;

    /**
     * @return Valor total dos tributos
     */
    public NFSeSefinNacionalTribTotalMonet getValorTotalTributos() {
        return valorTotalTributos;
    }

    /**
     * @param valorTotalTributos Valor total dos tributos
     */
    public void setValorTotalTributos(NFSeSefinNacionalTribTotalMonet valorTotalTributos) {
        this.valorTotalTributos = valorTotalTributos;
    }

    /**
     * @return Percentual total dos tributos
     */
    public NFSeSefinNacionalTribTotalPercent getPercentualTotalTributos() {
        return percentualTotalTributos;
    }

    /**
     * @param percentualTotalTributos Percentual total dos tributos
     */
    public void setPercentualTotalTributos(NFSeSefinNacionalTribTotalPercent percentualTotalTributos) {
        this.percentualTotalTributos = percentualTotalTributos;
    }

    /**
     *  Indicador de informação de valor total de tributos. Possui valor fixo igual a zero (indTotTrib=0).
     *  Não informar nenhum valor estimado para os Tributos (Decreto 8.264/2014).
        0 - Não
     * @return Indicador de valor total dos tributos
     */
    public String getIndicadorValorTotalTributos() {
        return indicadorValorTotalTributos;
    }

    /**
     *  Indicador de informação de valor total de tributos. Possui valor fixo igual a zero (indTotTrib=0).
     *  Não informar nenhum valor estimado para os Tributos (Decreto 8.264/2014).
        0 - Não
     * @param indicadorValorTotalTributos Indicador de valor total dos tributos
     */
    public NFSeSefinNacionalTribTotal setIndicadorValorTotalTributos(String indicadorValorTotalTributos) {
        this.indicadorValorTotalTributos = indicadorValorTotalTributos;
        return this;
    }

    /**
     * @return Percentual total do Simples Nacional
     */
    public String getPercentualTotalSimplesNacional() {
        return percentualTotalSimplesNacional;
    }

    /**
     * @param percentualTotalSimplesNacional Percentual total do Simples Nacional
     */
    public void setPercentualTotalSimplesNacional(String percentualTotalSimplesNacional) {
        this.percentualTotalSimplesNacional = percentualTotalSimplesNacional;
    }

}
