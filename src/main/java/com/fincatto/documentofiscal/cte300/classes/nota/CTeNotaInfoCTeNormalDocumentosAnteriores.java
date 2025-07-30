package com.fincatto.documentofiscal.cte300.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * @author Caio
 * @info Documentos de Transporte Anterior
 */

@Root(name = "docAnt")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalDocumentosAnteriores extends DFBase {
    private static final long serialVersionUID = 1244791382646017225L;

    @ElementList(name = "emiDocAnt", inline = true)
    private List<CTeNotaInfoCTeNormalDocumentosAnterioresEmissorDocumentosAnteriores> emissorDocumentosAnteriores;

    public CTeNotaInfoCTeNormalDocumentosAnteriores() {
        this.emissorDocumentosAnteriores = null;
    }

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
