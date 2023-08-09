package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Detalhamento do CT-e complementado
 */

@Root(name = "infCteComp")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoCTeComplementar extends DFBase {
    private static final long serialVersionUID = 2354656887092410693L;

    @Element(name = "chCTe")
    private String chave;

    public String getChave() {
        return this.chave;
    }

    /**
     * Chave do CT-e complementado
     */
    public void setChave(final String chave) {
        DFStringValidador.exatamente44N(chave, "Chave do CT-e complementado");
        this.chave = chave;
    }
}
