package com.fincatto.documentofiscal.cte300;

import com.fincatto.documentofiscal.DFConfig;
import com.fincatto.documentofiscal.cte300.classes.CTTipoEmissao;

/**
 * @author Caio
 * 
 * Configura��o basica CT-e.
 */
public abstract class CTeConfig extends DFConfig{

    public static final String VERSAO = "3.00";
    public static final String NAMESPACE = "http://www.portalfiscal.inf.br/cte";
    
    /**
     * Tipo da emiss�o das notas (se normal ou em conting�ncia).
     *
     * @return Tipo da emiss�o das notas.
     */
    public CTTipoEmissao getTipoEmissao() {
        return CTTipoEmissao.EMISSAO_NORMAL;
    }
}
