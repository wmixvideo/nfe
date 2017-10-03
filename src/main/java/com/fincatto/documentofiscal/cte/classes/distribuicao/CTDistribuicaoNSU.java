package com.fincatto.documentofiscal.cte.classes.distribuicao;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;

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
