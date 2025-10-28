
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

/**
 * 
 */

@Root(name = "TribMunicipal")
public class NFSeSefinNacionalTribMunicipal {

    @Element(name = "tribISSQN")
    protected NFSeSefinNacionalTribMunicipalTributacaoISSQN tributacaoISSQN;
    @Element(name = "cPaisResult", required = false)
    protected String codigoPais;
    @Element(name = "BM", required = false)
    protected NFSeSefinNacionalBeneficioMunicipal beneficioMunicipal;
    @Element(name = "exigSusp", required = false)
    protected NFSeSefinNacionalExigSuspensa exigibilidadeSuspensa;
    @Element(name = "tpImunidade", required = false)
    protected NFSeSefinNacionalTribMunicipalTipoImunidade tipoImunidade;
    @Element(name = "pAliq", required = false)
    protected String percentualAliquota;
    @Element(name = "tpRetISSQN")
    protected NFSeSefinNacionalTribMunicipalTipoRetencaoISSQN tipoRetencaoISSQN;

    /**
     * @return tributação do ISSQN sobre o serviço prestado
     */
    public NFSeSefinNacionalTribMunicipalTributacaoISSQN getTributacaoISSQN() {
        return tributacaoISSQN;
    }

    /**
     * @param tributacaoISSQN tributação do ISSQN sobre o serviço prestado
     */
    public NFSeSefinNacionalTribMunicipal setTributacaoISSQN(NFSeSefinNacionalTribMunicipalTributacaoISSQN tributacaoISSQN) {
        this.tributacaoISSQN = tributacaoISSQN;
        return this;
    }

    /**
     * @return Código do país onde se verficou o resultado da prestação do serviço para o caso de Exportação de Serviço.(Tabela de Países ISO)
     */
    public String getCodigoPais() {
        return codigoPais;
    }

    /**
     * @param codigoPais Código do país onde se verficou o resultado da prestação do serviço para o caso de Exportação de Serviço.(Tabela de Países ISO)
     */
    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    /**
     * @return Benefício Municipal concedido ao prestador do serviço
     */
    public NFSeSefinNacionalBeneficioMunicipal getBeneficioMunicipal() {
        return beneficioMunicipal;
    }

    /**
     * @param beneficioMunicipal Benefício Municipal concedido ao prestador do serviço
     */
    public void setBeneficioMunicipal(NFSeSefinNacionalBeneficioMunicipal beneficioMunicipal) {
        this.beneficioMunicipal = beneficioMunicipal;
    }

    /**
     * @return Exigibilidade Suspensa do ISSQN sobre o serviço prestado
     */
    public NFSeSefinNacionalExigSuspensa getExigibilidadeSuspensa() {
        return exigibilidadeSuspensa;
    }

    /**
     * @param exigibilidadeSuspensa Exigibilidade Suspensa do ISSQN sobre o serviço prestado
     */
    public void setExigibilidadeSuspensa(NFSeSefinNacionalExigSuspensa exigibilidadeSuspensa) {
        this.exigibilidadeSuspensa = exigibilidadeSuspensa;
    }

    /**
     * @return Tipo de imunidade do ISSQN sobre o serviço prestado
     */
    public NFSeSefinNacionalTribMunicipalTipoImunidade getTipoImunidade() {
        return tipoImunidade;
    }

    /**
     * @param tipoImunidade Tipo de imunidade do ISSQN sobre o serviço prestado
     */
    public void setTipoImunidade(NFSeSefinNacionalTribMunicipalTipoImunidade tipoImunidade) {
        this.tipoImunidade = tipoImunidade;
    }

    /**
     * @return Percentual da alíquota do ISSQN sobre o serviço prestado
     */
    public String getPercentualAliquota() {
        return percentualAliquota;
    }

    /**
     * @param percentualAliquota Percentual da alíquota do ISSQN sobre o serviço prestado
     */
    public void setPercentualAliquota(String percentualAliquota) {
        this.percentualAliquota = percentualAliquota;
    }

    /**
     * @return Tipo de retenção do ISSQN sobre o serviço prestado
     */
    public NFSeSefinNacionalTribMunicipalTipoRetencaoISSQN getTipoRetencaoISSQN() {
        return tipoRetencaoISSQN;
    }

    /**
     * @param tipoRetencaoISSQN Tipo de retenção do ISSQN sobre o serviço prestado
     */
    public NFSeSefinNacionalTribMunicipal setTipoRetencaoISSQN(NFSeSefinNacionalTribMunicipalTipoRetencaoISSQN tipoRetencaoISSQN) {
        this.tipoRetencaoISSQN = tipoRetencaoISSQN;
        return this;
    }

}
