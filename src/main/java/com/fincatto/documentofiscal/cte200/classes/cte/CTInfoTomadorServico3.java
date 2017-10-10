package com.fincatto.documentofiscal.cte200.classes.cte;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte200.classes.CTTomadorServico;

public class CTInfoTomadorServico3 extends DFBase {
    private static final long serialVersionUID = -8253978359700650423L;

    @Element(name = "toma")
    private CTTomadorServico tomadorServico;

    public CTInfoTomadorServico3(){
        super();
    }

    public CTInfoTomadorServico3(CTTomadorServico tomadorServico) {
        this();
        setTomadorServico(tomadorServico);
    }

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