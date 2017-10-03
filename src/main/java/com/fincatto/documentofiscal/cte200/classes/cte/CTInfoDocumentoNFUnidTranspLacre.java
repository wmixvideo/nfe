package com.fincatto.documentofiscal.cte200.classes.cte;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;

@Root(name = "lacUnidTransp")
public class CTInfoDocumentoNFUnidTranspLacre extends DFBase {
    private static final long serialVersionUID = -7312811578255936535L;

    @Element(name = "nLacre")
    private String numeroLacre;

    public String getNumeroLacre() {
        return this.numeroLacre;
    }

    public void setNumeroLacre(final String numeroLacre) {
        this.numeroLacre = numeroLacre;
    }

}
