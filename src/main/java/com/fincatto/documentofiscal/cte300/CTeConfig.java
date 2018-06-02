package com.fincatto.documentofiscal.cte300;

import com.fincatto.documentofiscal.DFConfig;
import com.fincatto.documentofiscal.cte300.classes.CTTipoEmissao;

/**
 * Configuracao basica CT-e.
 * @author Caio
 */
public abstract class CTeConfig extends DFConfig {

    public static final String VERSAO = "3.00";
    public static final String NAMESPACE = "http://www.portalfiscal.inf.br/cte";

    /**
     * Tipo da emissao das notas (se normal ou em contingencia).
     *
     * @return Tipo da emissao das notas.
     */
    public CTTipoEmissao getTipoEmissao() {
        return CTTipoEmissao.EMISSAO_NORMAL;
    }
}
