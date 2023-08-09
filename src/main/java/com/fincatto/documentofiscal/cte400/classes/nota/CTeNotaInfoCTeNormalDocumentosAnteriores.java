package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Documentos de Transporte Anterior
 */

@Root(name = "docAnt")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoCTeNormalDocumentosAnteriores extends DFBase {
    private static final long serialVersionUID = 1616927051046190659L;

    @ElementList(name = "emiDocAnt", inline = true)
    private List<CTeNotaInfoCTeNormalDocumentosAnterioresEmissorDocumentosAnteriores> emissorDocumentosAnteriores;

    public List<CTeNotaInfoCTeNormalDocumentosAnterioresEmissorDocumentosAnteriores> getEmissorDocumentosAnteriores() {
        return this.emissorDocumentosAnteriores;
    }

    /**
     * Emissor do documento anterior
     */
    public void setEmissorDocumentosAnteriores(final List<CTeNotaInfoCTeNormalDocumentosAnterioresEmissorDocumentosAnteriores> emissorDocumentosAnteriores) {
        this.emissorDocumentosAnteriores = emissorDocumentosAnteriores;
    }
}
