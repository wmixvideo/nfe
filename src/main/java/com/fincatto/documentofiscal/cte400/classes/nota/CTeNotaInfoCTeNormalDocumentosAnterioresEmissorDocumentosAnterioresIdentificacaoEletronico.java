package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Documentos de transporte anterior eletrônicos
 */

@Root(name = "idDocAntEle")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoCTeNormalDocumentosAnterioresEmissorDocumentosAnterioresIdentificacaoEletronico extends DFBase {
    private static final long serialVersionUID = 2838717287487385755L;

    @Element(name = "chCTe")
    private String chaveCTe;

    public String getChaveCTe() {
        return this.chaveCTe;
    }

    /**
     * Chave de acesso do CT-e
     */
    public void setChaveCTe(final String chaveCTe) {
        DFStringValidador.exatamente44N(chaveCTe, "Chave de acesso do CT-e");
        this.chaveCTe = chaveCTe;
    }
}
