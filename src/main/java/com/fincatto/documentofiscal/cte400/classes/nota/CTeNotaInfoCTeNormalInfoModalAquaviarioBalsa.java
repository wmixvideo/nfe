package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Grupo de informações das balsas
 */

@Root(name = "balsa")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoCTeNormalInfoModalAquaviarioBalsa extends DFBase {
    private static final long serialVersionUID = 3791338263882670862L;

    @Element(name = "xBalsa")
    private String descricao;

    public String getDescricao() {
        return this.descricao;
    }

    /**
     * Identificador da Balsa
     */
    public void setDescricao(final String descricao) {
        DFStringValidador.tamanho60(descricao, "Identificador da Balsa");
        this.descricao = descricao;
    }
}
