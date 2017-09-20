package com.fincatto.documentofiscal.cte200.classes.cte;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;

public class CTInfoCteComplementado extends DFBase {

    @Element(name = "chave")
    private String chaveAcessoCteComplementado;

    public String getChaveAcessoCteComplementado() {
        return this.chaveAcessoCteComplementado;
    }

    public void setChaveAcessoCteComplementado(final String chaveAcessoCteComplementado) {
        this.chaveAcessoCteComplementado = chaveAcessoCteComplementado;
    }

}
