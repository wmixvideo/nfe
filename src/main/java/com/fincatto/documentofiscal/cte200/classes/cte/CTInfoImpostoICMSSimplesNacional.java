package com.fincatto.documentofiscal.cte200.classes.cte;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;

public class CTInfoImpostoICMSSimplesNacional extends DFBase {
    private static final long serialVersionUID = -8159126354158753736L;

    @Element(name = "indSN")
    private String indicadorSimplesNacional;

    public String getIndicadorSimplesNacional() {
        return this.indicadorSimplesNacional;
    }

    public void setIndicadorSimplesNacional(final String indicadorSimplesNacional) {
        this.indicadorSimplesNacional = indicadorSimplesNacional;
    }

}
