package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import org.simpleframework.xml.Element;

public class CTeInformacoesNotaFiscalFacil extends DFBase {
    private static final long serialVersionUID = -4464233300961975702L;

    @Element(name = "xSolic")
    private String solicitacao;

    public String getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(String solicitacao) {
        this.solicitacao = solicitacao;
    }
}
