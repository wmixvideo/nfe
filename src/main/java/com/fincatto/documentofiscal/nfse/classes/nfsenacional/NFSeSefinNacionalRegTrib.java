
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

/**
 * <p>Java class for TCRegTrib complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TCRegTrib"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="opSimpNac" type="{http://www.sped.fazenda.gov.br/nfse}TSOpSimpNac"/&gt;
 *         &lt;element name="regApTribSN" type="{http://www.sped.fazenda.gov.br/nfse}TSRegimeApuracaoSimpNac" minOccurs="0"/&gt;
 *         &lt;element name="regEspTrib" type="{http://www.sped.fazenda.gov.br/nfse}TSRegEspTrib"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

@Root(name = "RegTrib")
public class NFSeSefinNacionalRegTrib {

    @Element(name = "opSimpNac")
    protected NFSeSefinNacionalRegimeTributarioSituacaoSimplesNacional opSimplesNacional;
    @Element(name = "regApTribSN", required = false)
    protected NFSeSefinNacionalRegimeTributarioApuracaoAposLimiteSimples regimeApuracaoAposLimiteSimplesNacional;
    @Element(name = "regEspTrib")
    protected NFSeSefinNacionalRegimeTributarioRegimeEspecialTributacao regimeEspecialTributacao;

    /**
     * @return Opção no Simples Nacional
     */
    public NFSeSefinNacionalRegimeTributarioSituacaoSimplesNacional getOpSimplesNacional() {
        return opSimplesNacional;
    }

    /**
     * @param opSimplesNacional Opção no Simples Nacional
     */
    public NFSeSefinNacionalRegTrib setOpSimplesNacional(NFSeSefinNacionalRegimeTributarioSituacaoSimplesNacional opSimplesNacional) {
        this.opSimplesNacional = opSimplesNacional;
        return this;
    }

    /**
     * @return Regime de apuração após limite do Simples Nacional
     */
    public NFSeSefinNacionalRegimeTributarioApuracaoAposLimiteSimples getRegimeApuracaoAposLimiteSimplesNacional() {
        return regimeApuracaoAposLimiteSimplesNacional;
    }

    /**
     * @param regimeApuracaoAposLimiteSimplesNacional Regime de apuração após limite do Simples Nacional
     */
    public NFSeSefinNacionalRegTrib setRegimeApuracaoAposLimiteSimplesNacional(NFSeSefinNacionalRegimeTributarioApuracaoAposLimiteSimples regimeApuracaoAposLimiteSimplesNacional) {
        this.regimeApuracaoAposLimiteSimplesNacional = regimeApuracaoAposLimiteSimplesNacional;
        return this;
    }

    /**
     * @return Regime especial de tributação
     */
    public NFSeSefinNacionalRegimeTributarioRegimeEspecialTributacao getRegimeEspecialTributacao() {
        return regimeEspecialTributacao;
    }

    /**
     * @param regimeEspecialTributacao Regime especial de tributação
     */
    public NFSeSefinNacionalRegTrib setRegimeEspecialTributacao(NFSeSefinNacionalRegimeTributarioRegimeEspecialTributacao regimeEspecialTributacao) {
        this.regimeEspecialTributacao = regimeEspecialTributacao;
        return this;
    }

}
