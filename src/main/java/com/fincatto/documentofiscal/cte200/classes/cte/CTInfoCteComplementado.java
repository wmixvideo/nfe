package com.fincatto.documentofiscal.cte200.classes.cte;

import com.fincatto.documentofiscal.DFBase;
import org.simpleframework.xml.Element;

public class CTInfoCteComplementado extends DFBase {
    private static final long serialVersionUID = 594149684514913854L;

    @Element(name = "chave")
    private String chaveAcessoCteComplementado;

    public String getChaveAcessoCteComplementado() {
        return this.chaveAcessoCteComplementado;
    }

    public void setChaveAcessoCteComplementado(final String chaveAcessoCteComplementado) {
        this.chaveAcessoCteComplementado = chaveAcessoCteComplementado;
    }

}
