package com.fincatto.cte300.classes;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "cteProc")
public class CteProc {

    @Attribute(name = "versao", required = true)
    private String versao;

    @Element(name = "CTe", required = true)
    private Cte cTe;

    @Element(required = true)
    private ProtCTe protCTe;

    public String getVersao() {
        return this.versao;
    }

    public void setVersao(final String versao) {
        this.versao = versao;
    }

    public Cte getcTe() {
        return this.cTe;
    }

    public void setcTe(final Cte cTe) {
        this.cTe = cTe;
    }

    public ProtCTe getProtCTe() {
        return this.protCTe;
    }

    public void setProtCTe(final ProtCTe protCTe) {
        this.protCTe = protCTe;
    }

}
