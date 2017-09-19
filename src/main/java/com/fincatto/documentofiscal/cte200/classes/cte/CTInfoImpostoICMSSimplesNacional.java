package com.fincatto.documentofiscal.cte200.classes.cte;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;

public class CTInfoImpostoICMSSimplesNacional extends DFBase {

    @Element(name = "indSN")
    private String indicadorSimplesNacional;

    public String getIndicadorSimplesNacional() {
        return this.indicadorSimplesNacional;
    }

    public void setIndicadorSimplesNacional(final String indicadorSimplesNacional) {
        this.indicadorSimplesNacional = indicadorSimplesNacional;
    }

}
