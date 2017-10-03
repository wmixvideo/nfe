package com.fincatto.documentofiscal.cte200.classes.cte;

import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;

@Root(name = "idDocAnt")
public class CTInfoDocumentoAnteriorIndentificacao extends DFBase {
    private static final long serialVersionUID = 1619816713594438278L;

    @ElementList(name = "idDocAntPap", inline = true)
    private List<CTInfoDocumentoAnteriorPapel> documentosAnterioresPapel;

    @ElementList(name = "idDocAntEle", inline = true)
    private List<CTInfoDocumentoAnteriorEletronico> documentosAnterioresEletronicos;

    public List<CTInfoDocumentoAnteriorPapel> getDocumentosAnterioresPapel() {
        return this.documentosAnterioresPapel;
    }

    public void setDocumentosAnterioresPapel(final List<CTInfoDocumentoAnteriorPapel> documentosAnterioresPapel) {
        this.documentosAnterioresPapel = documentosAnterioresPapel;
    }

    public List<CTInfoDocumentoAnteriorEletronico> getDocumentosAnterioresEletronicos() {
        return this.documentosAnterioresEletronicos;
    }

    public void setDocumentosAnterioresEletronicos(final List<CTInfoDocumentoAnteriorEletronico> documentosAnterioresEletronicos) {
        this.documentosAnterioresEletronicos = documentosAnterioresEletronicos;
    }

}