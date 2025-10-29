
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

/**
 * Regime de tributação do prestador de serviço
 */

@Root(name = "regTrib")
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
