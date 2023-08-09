package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Informações do CT-e Globalizado
 */

@Root(name = "infGlobalizado")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoCTeNormalInfoGlobalizado extends DFBase {
    private static final long serialVersionUID = 2273459701568571788L;

    @Element(name = "xObs")
    private String observacao;

    public String getObservacao() {
        return this.observacao;
    }

    /**
     * Preencher com informações adicionais, legislação do regime especial, etc
     */
    public void setObservacao(final String observacao) {
        DFStringValidador.tamanho15a256(observacao, "Preencher com informações adicionais, legislação do regime especial, etc");
        this.observacao = observacao;
    }
}
