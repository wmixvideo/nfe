package com.fincatto.documentofiscal.cte300.classes.os;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "infCteSub")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeOSInfoCTeNormalInfoCTeSubstituicao extends DFBase {
    private static final long serialVersionUID = 1065211380518853520L;

    @Element(name = "chCte")
    private String chaveCTe;

    @Element(name = "refCteAnu", required = false)
    private String chaveCTeAnulacao;

    @Element(name = "tomaICMS", required = false)
    private CTeOSInfoCTeNormalInfoCTeSubstituicaoTomadorICMS tomadorICMS;

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

    public String getChaveCTeAnulacao() {
        return this.chaveCTeAnulacao;
    }

    /**
     * Chave de acesso do CT-e de Anulação
     */
    public void setChaveCTeAnulacao(final String chaveCTeAnulacao) {
        DFStringValidador.exatamente44N(chaveCTeAnulacao, "Chave de acesso do CT-e de Anulação");
        this.chaveCTeAnulacao = chaveCTeAnulacao;
    }

    public CTeOSInfoCTeNormalInfoCTeSubstituicaoTomadorICMS getTomadorICMS() {
        return this.tomadorICMS;
    }

    /**
     * Tomador é contribuinte do ICMS, mas não é emitente de documento fiscal eletrônico
     */
    public void setTomadorICMS(final CTeOSInfoCTeNormalInfoCTeSubstituicaoTomadorICMS tomadorICMS) {
        this.tomadorICMS = tomadorICMS;
    }
}
