package com.fincatto.documentofiscal.nfe310;

import java.security.KeyStore;
import java.security.KeyStoreException;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFConfig;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe310.classes.NFTipoEmissao;

/**
 * Configuração basica do sistema de notas fiscais.
 */
public abstract class NFeConfig extends DFConfig {

    public static final String VERSAO = "3.00";
    public static final String NAMESPACE = "http://www.portalfiscal.inf.br/nfe";
    
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
     * @return Codigo de seguran�a do contribuinte.
     */
    public String getCodigoSegurancaContribuinte() {
        return null;
    }
    
    /**
     * Tipo da emiss�o das notas (se normal ou em conting�ncia).
     *
     * @return Tipo da emiss�o das notas.
     */
    public NFTipoEmissao getTipoEmissao() {
        return NFTipoEmissao.EMISSAO_NORMAL;
    }
}