package com.fincatto.documentofiscal.cte200.classes.cte;

import com.fincatto.documentofiscal.DFBase;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "lacUnidCarga")
public class CTInfoDocumentoNFUnidadeCargaLacre extends DFBase {
    private static final long serialVersionUID = -5337777492540262449L;

    @Element(name = "nrLacre")
    private String numeroLacre;

    public String getNumeroLacre() {
        return this.numeroLacre;
    }

    public void setNumeroLacre(final String numeroLacre) {
        this.numeroLacre = numeroLacre;
    }

}
