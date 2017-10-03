package com.fincatto.documentofiscal.cte200.classes.cte;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;

public class CTInfoSubstituicao extends DFBase {
    private static final long serialVersionUID = -5556727730775695778L;

    @Element(name = "chCte")
    private String chaveAcesso;

    @Element(name = "tomaICMS")
    private CTInfoTomadorICMS tomadorICMS;

    @Element(name = "tomaNaoICMS")
    private CTInfoTomadorNaoICMS tomadorNaoICMS;

    public String getChaveAcesso() {
        return this.chaveAcesso;
    }

    public void setChaveAcesso(final String chaveAcesso) {
        this.chaveAcesso = chaveAcesso;
    }

    public CTInfoTomadorICMS getTomadorICMS() {
        return this.tomadorICMS;
    }

    public void setTomadorICMS(final CTInfoTomadorICMS tomadorICMS) {
        this.tomadorICMS = tomadorICMS;
    }

    public CTInfoTomadorNaoICMS getTomadorNaoICMS() {
        return this.tomadorNaoICMS;
    }

    public void setTomadorNaoICMS(final CTInfoTomadorNaoICMS tomadorNaoICMS) {
        this.tomadorNaoICMS = tomadorNaoICMS;
    }

}
