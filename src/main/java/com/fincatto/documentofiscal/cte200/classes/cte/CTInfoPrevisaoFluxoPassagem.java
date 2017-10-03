package com.fincatto.documentofiscal.cte200.classes.cte;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;

@Root(name = "pass")
public class CTInfoPrevisaoFluxoPassagem extends DFBase {
    private static final long serialVersionUID = -5069909939885596855L;

    @Element(name = "xPass")
    private String codigoPassagem;

    public String getCodigoPassagem() {
        return this.codigoPassagem;
    }

    public void setCodigoPassagem(final String codigoPassagem) {
        this.codigoPassagem = codigoPassagem;
    }

}
