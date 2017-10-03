package com.fincatto.documentofiscal.cte200.classes.cte;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;

@Root(name = "cteProc")
public class CTProcessado extends DFBase {
    private static final long serialVersionUID = 172533806473031301L;

    @Attribute(name = "versao")
    private String versao;

    @Element(name = "CTe")
    private CTe cte;

    @Element(name = "protCTe")
    private CTProtocolo protocolo;

    public String getVersao() {
        return this.versao;
    }

    public void setVersao(final String versao) {
        this.versao = versao;
    }

    public CTe getCte() {
        return this.cte;
    }

    public void setCte(final CTe cte) {
        this.cte = cte;
    }

    public CTProtocolo getProtocolo() {
        return this.protocolo;
    }

    public void setProtocolo(final CTProtocolo protocolo) {
        this.protocolo = protocolo;
    }

}
