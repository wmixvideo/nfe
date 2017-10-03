package com.fincatto.documentofiscal.cte.classes.distribuicao;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;

public class CTDistribuicaoConsultaNSU extends DFBase {
    private static final long serialVersionUID = -582191692175285331L;

    @Element(name = "NSU")
    private String nsu;

    public String getNsu() {
        return this.nsu;
    }

    public void setNsu(final String nsu) {
        this.nsu = nsu;
    }

}
