package com.fincatto.nfe310;

import com.fincatto.dfe.DFeConfig;

/**
 * Configuração basica do sistema de notas fiscais.
 */
public abstract class NFeConfig extends DFeConfig {

    public static final String VERSAO_NFE = "3.10";
    public static final String NFE_NAMESPACE = "http://www.portalfiscal.inf.br/nfe";

    /**
     * ID de contribuinte, somente para NFCe.
     *
     * @return ID do contribuinte.
     */
    public Integer getCodigoSegurancaContribuinteID() {
        return null;
    }

    /**
     * Codigo de seguranca do contribuinte, com 36 caracteres, somente para NFCe.
     *
     * @return Codigo de segurança do contribuinte.
     */
    public String getCodigoSegurancaContribuinte() {
        return null;
    }
}