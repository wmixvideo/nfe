package com.fincatto.documentofiscal.cte.classes.distribuicao;

import com.fincatto.documentofiscal.DFBase;
import org.simpleframework.xml.Element;

public class CTDistribuicaoNSU extends DFBase {
    private static final long serialVersionUID = -50569062199740836L;

    @Element(name = "ultNSU")
    private String ultimoNSU;

    public java.lang.String getUltimoNSU() {
        return this.ultimoNSU;
    }

    public CTDistribuicaoNSU setUltimoNSU(final java.lang.String ultimoNSU) {
        this.ultimoNSU = ultimoNSU;
        return this;
    }

}
