package com.fincatto.documentofiscal.cte200.classes.cte;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte200.classes.CTTomadorServico;

public class CTInfoTomadorServico3 extends DFBase {

    @Element(name = "toma")
    private CTTomadorServico tomadorServico;

    public void setTomadorServico(final CTTomadorServico tomadorServico) {
        if (!CTTomadorServico.TOMADOR_3.contains(tomadorServico)) {
            throw new IllegalArgumentException("O tomador do servico n\u00e3o \u00e9 v\u00e1lido para este papel");
        }
        this.tomadorServico = tomadorServico;
    }

    public CTTomadorServico getTomadorServico() {
        return this.tomadorServico;
    }

}