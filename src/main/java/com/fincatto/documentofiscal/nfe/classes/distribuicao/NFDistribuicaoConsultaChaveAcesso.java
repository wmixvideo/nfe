package com.fincatto.documentofiscal.nfe.classes.distribuicao;

import com.fincatto.documentofiscal.DFBase;
import org.simpleframework.xml.Element;

public class NFDistribuicaoConsultaChaveAcesso extends DFBase {
    private static final long serialVersionUID = 5822101975600089554L;

    @Element(name = "chNFe")
    private String chaveAcesso;

    public String getChaveAcesso() {
        return this.chaveAcesso;
    }

    public NFDistribuicaoConsultaChaveAcesso setChaveAcesso(final String chaveAcesso) {
        this.chaveAcesso = chaveAcesso;
        return this;
    }

}
