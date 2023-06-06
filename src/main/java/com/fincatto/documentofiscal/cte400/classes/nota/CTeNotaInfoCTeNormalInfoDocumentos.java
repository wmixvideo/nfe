package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Informações dos documentos transportados pelo CT-e Opcional para Redespacho Intermediario e Serviço vinculado a multimodal.<br>
 *       Poderá não ser informado para os CT-e de redespacho intermediário. Nos demais casos deverá sempre ser informado.
 */

@Root(name = "infDoc")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoCTeNormalInfoDocumentos extends DFBase {
    private static final long serialVersionUID = 4889470849533887680L;

    @ElementList(name = "infNF", inline = true, required = false)
    private List<CTeNotaInfoCTeNormalInfoDocumentosInfoNF> infoNF;

    @ElementList(name = "infNFe", inline = true, required = false)
    private List<CTeNotaInfoCTeNormalInfoDocumentosInfoNFe> infoNFe;

    @ElementList(name = "infOutros", inline = true, required = false)
    private List<CTeNotaInfoCTeNormalInfoDocumentosInfoOutros> infoOutros;

    public List<CTeNotaInfoCTeNormalInfoDocumentosInfoNF> getInfoNF() {
        return this.infoNF;
    }

    /**
     * Informações das NF<br>
     * Este grupo deve ser informado quando o documento originário for NF
     */
    public void setInfoNF(final List<CTeNotaInfoCTeNormalInfoDocumentosInfoNF> infoNF) {
        this.infoNF = infoNF;
    }

    public List<CTeNotaInfoCTeNormalInfoDocumentosInfoNFe> getInfoNFe() {
        return this.infoNFe;
    }

    /**
     * Informações das NF-e
     */
    public void setInfoNFe(final List<CTeNotaInfoCTeNormalInfoDocumentosInfoNFe> infoNFe) {
        this.infoNFe = infoNFe;
    }

    public List<CTeNotaInfoCTeNormalInfoDocumentosInfoOutros> getInfoOutros() {
        return this.infoOutros;
    }

    /**
     * Informações dos demais documentos
     */
    public void setInfoOutros(final List<CTeNotaInfoCTeNormalInfoDocumentosInfoOutros> infoOutros) {
        this.infoOutros = infoOutros;
    }
}
