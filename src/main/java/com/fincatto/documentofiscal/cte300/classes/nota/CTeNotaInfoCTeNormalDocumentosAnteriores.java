package com.fincatto.documentofiscal.cte300.classes.nota;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;

/**
 * @author Caio
 * @info Documentos de Transporte Anterior
 */

@Root(name = "docAnt")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalDocumentosAnteriores extends DFBase {
    private static final long serialVersionUID = 1244791382646017225L;

    @Element(name = "emiDocAnt", required = true)
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
