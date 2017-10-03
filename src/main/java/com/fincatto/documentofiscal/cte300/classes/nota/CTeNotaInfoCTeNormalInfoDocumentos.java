package com.fincatto.documentofiscal.cte300.classes.nota;

import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;

/**
 * @author Caio
 * @info Informações dos documentos transportados pelo CT-e Opcional para Redespacho Intermediario e Serviço vinculado a multimodal.<br>
 *       Poderá não ser informado para os CT-e de redespacho intermediário. Nos demais casos deverá sempre ser informado.
 */

@Root(name = "infDoc")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalInfoDocumentos extends DFBase {
    private static final long serialVersionUID = -5777461918618675015L;

    @ElementList(name = "infNF", inline = true, required = false)
    private List<CTeNotaInfoCTeNormalInfoDocumentosInfoNF> infoNF;

    @ElementList(name = "infNFe", inline = true, required = false)
    private List<CTeNotaInfoCTeNormalInfoDocumentosInfoNFe> infoNFe;

    @ElementList(name = "infOutros", inline = true, required = false)
    private List<CTeNotaInfoCTeNormalInfoDocumentosInfoOutros> infoOutros;

    public CTeNotaInfoCTeNormalInfoDocumentos() {
        this.infoNF = null;
        this.infoNFe = null;
        this.infoOutros = null;
    }

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
