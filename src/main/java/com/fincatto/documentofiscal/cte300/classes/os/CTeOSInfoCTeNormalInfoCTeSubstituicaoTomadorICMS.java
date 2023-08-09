package com.fincatto.documentofiscal.cte300.classes.os;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "tomaICMS")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeOSInfoCTeNormalInfoCTeSubstituicaoTomadorICMS extends DFBase {
    private static final long serialVersionUID = -1982924377131065804L;

    @Element(name = "refNFe", required = false)
    private String referenciaNFe;

    @Element(name = "refNF", required = false)
    private CTeOSInfoCTeNormalInfoCTeSubstituicaoTomadorICMSReferenciaNF referenciaNF;

    @Element(name = "refCte", required = false)
    private String referenciaCte;

    public CTeOSInfoCTeNormalInfoCTeSubstituicaoTomadorICMS() {
        this.referenciaNFe = null;
        this.referenciaNF = null;
        this.referenciaCte = null;
    }

    public String getReferenciaNFe() {
        return this.referenciaNFe;
    }

    /**
     * Chave de acesso da NF-e emitida pelo Tomador
     */
    public void setReferenciaNFe(final String referenciaNFe) {
        DFStringValidador.exatamente44N(referenciaNFe, "Chave de acesso da NF-e emitida pelo Tomador");
        this.referenciaNFe = referenciaNFe;
    }

    public CTeOSInfoCTeNormalInfoCTeSubstituicaoTomadorICMSReferenciaNF getReferenciaNF() {
        return this.referenciaNF;
    }

    /**
     * Informação da NF ou CT emitido pelo Tomador
     */
    public void setReferenciaNF(final CTeOSInfoCTeNormalInfoCTeSubstituicaoTomadorICMSReferenciaNF referenciaNF) {
        this.referenciaNF = referenciaNF;
    }

    public String getReferenciaCte() {
        return this.referenciaCte;
    }

    /**
     * Chave de acesso do CT-e emitido pelo Tomador
     */
    public void setReferenciaCte(final String referenciaCte) {
        DFStringValidador.exatamente44N(referenciaCte, "Chave de acesso do CT-e emitido pelo Tomador");
        this.referenciaCte = referenciaCte;
    }
}
