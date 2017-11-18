package com.fincatto.documentofiscal.mdfe3;

import com.fincatto.documentofiscal.DFConfig;
import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoEmissao;

/**
 * Created by Eldevan Nery Junior on 10/11/17.
 *
 * Configuracão padrão do MDF-e.
 *
 */
public abstract class MDFeConfig extends DFConfig{

    public static final String VERSAO = "3.00";
    public static final String NAMESPACE = "http://www.portalfiscal.inf.br/mdfe";
    

    public MDFTipoEmissao getTipoEmissao() {
        return MDFTipoEmissao.NORMAL;
    }

    @Override
    public DFModelo getModelo () {
        return DFModelo.MDFE;
    }

}
