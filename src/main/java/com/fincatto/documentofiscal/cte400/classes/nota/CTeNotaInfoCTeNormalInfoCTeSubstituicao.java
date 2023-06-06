package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Informações do CT-e de substituição
 */

@Root(name = "infCteSub")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoCTeNormalInfoCTeSubstituicao extends DFBase {
    private static final long serialVersionUID = 2147753040704965413L;

    @Element(name = "chCte")
    private String chaveCTe;

    @Element(name = "indAlteraToma", required = false)
    private String indicadorAlteracaoTomador;

    public String getChaveCTe() {
        return this.chaveCTe;
    }

    /**
     * Chave de acesso do CT-e a ser substituído (original)
     */
    public void setChaveCTe(final String chaveCTe) {
        DFStringValidador.exatamente44N(chaveCTe, "Chave de acesso do CT-e a ser substituído (original)");
        this.chaveCTe = chaveCTe;
    }

    public String getIndicadorAlteracaoTomador() {
        return this.indicadorAlteracaoTomador;
    }

    /**
     * Indicador de CT-e Alteração de Tomador<br>
     * Tag com efeito e utilização aguardando legislação, não utilizar antes de NT específica tratar desse procedimento
     */
    public void setIndicadorAlteracaoTomador(final String indicadorAlteracaoTomador) {
        DFStringValidador.exatamente1(indicadorAlteracaoTomador, "Indicador de CT-e Alteração de Tomador");
        this.indicadorAlteracaoTomador = indicadorAlteracaoTomador;
    }
}
