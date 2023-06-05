package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Informações dos documentos dos conteiners
 */

@Root(name = "infDoc")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalInfoModalAquaviarioConteinerInfoDocumentos extends DFBase {
    private static final long serialVersionUID = 2746254923817166298L;

    @ElementList(name = "infNF", inline = true)
    private List<CTeNotaInfoCTeNormalInfoModalAquaviarioConteinerInfoDocumentosNF> infoDocumentosNF;
    
    @ElementList(name = "infNFe", inline = true)
    private List<CTeNotaInfoCTeNormalInfoModalAquaviarioConteinerInfoDocumentosNFe> infoDocumentosNFe;

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
