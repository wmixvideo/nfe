package com.fincatto.documentofiscal.cte300.classes.nota;

import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;

/**
 * @author Caio
 * @info Informações dos documentos dos conteiners
 */

@Root(name = "infDoc")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalInfoModalAquaviarioConteinerInfoDocumentos extends DFBase {
    private static final long serialVersionUID = 8869859558328512575L;

    @ElementList(name = "infNF", inline = true, required = true)
    private List<CTeNotaInfoCTeNormalInfoModalAquaviarioConteinerInfoDocumentosNF> infoDocumentosNF;

    @ElementList(name = "infNFe", inline = true, required = true)
    private List<CTeNotaInfoCTeNormalInfoModalAquaviarioConteinerInfoDocumentosNFe> infoDocumentosNFe;

    public CTeNotaInfoCTeNormalInfoModalAquaviarioConteinerInfoDocumentos() {
        this.infoDocumentosNF = null;
        this.infoDocumentosNFe = null;
    }

    public List<CTeNotaInfoCTeNormalInfoModalAquaviarioConteinerInfoDocumentosNF> getInfoDocumentosNF() {
        return this.infoDocumentosNF;
    }

    /**
     * Informações das NF
     */
    public void setInfoDocumentosNF(final List<CTeNotaInfoCTeNormalInfoModalAquaviarioConteinerInfoDocumentosNF> infoDocumentosNF) {
        this.infoDocumentosNF = infoDocumentosNF;
    }

    public List<CTeNotaInfoCTeNormalInfoModalAquaviarioConteinerInfoDocumentosNFe> getInfoDocumentosNFe() {
        return this.infoDocumentosNFe;
    }

    /**
     * Informações das NFe
     */
    public void setInfoDocumentosNFe(final List<CTeNotaInfoCTeNormalInfoModalAquaviarioConteinerInfoDocumentosNFe> infoDocumentosNFe) {
        this.infoDocumentosNFe = infoDocumentosNFe;
    }
}
