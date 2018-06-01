package com.fincatto.documentofiscal.nfe.classes.distribuicao;

import com.fincatto.documentofiscal.DFBase;
import org.simpleframework.xml.ElementList;

import java.util.List;

public class NFDistribuicaoDFeLote extends DFBase {
    private static final long serialVersionUID = -4707748830153224762L;

    @ElementList(name = "docZip", inline = true, required = false)
    private List<NFDistribuicaoDocumentoZip> docZip;

    public List<NFDistribuicaoDocumentoZip> getDocZip() {
        return this.docZip;
    }

    public NFDistribuicaoDFeLote setDocZip(final List<NFDistribuicaoDocumentoZip> docZip) {
        this.docZip = docZip;
        return this;
    }
}