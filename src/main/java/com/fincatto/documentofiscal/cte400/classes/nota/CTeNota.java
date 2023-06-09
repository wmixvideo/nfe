package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.nota.assinatura.CTeSignature;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Tipo Conhecimento de Transporte Eletrônico (Modelo 57)
 */

@Root(name = "CTe")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNota extends DFBase {
    private static final long serialVersionUID = 1088709291423475533L;

    @Element(name = "infCte")
    private CTeNotaInfo info;

    @Element(name="infCTeSupl", required = false)
    private CTeNotaInfoSuplementares infoSuplementares;

    @Element(name = "Signature", required = false)
    private CTeSignature signature;

    public CTeNotaInfo getCteNotaInfo() {
        return this.info;
    }

    public void setCteNotaInfo(final CTeNotaInfo info) {
        this.info = info;
    }

    public CTeNotaInfoSuplementares getInfoSuplementares() {
        return infoSuplementares;
    }

    public CTeNota setInfoSuplementares(CTeNotaInfoSuplementares infoSuplementares) {
        this.infoSuplementares = infoSuplementares;
        return this;
    }

    public CTeSignature getSignature() {
        return this.signature;
    }

    public void setSignature(final CTeSignature signature) {
        this.signature = signature;
    }
}
