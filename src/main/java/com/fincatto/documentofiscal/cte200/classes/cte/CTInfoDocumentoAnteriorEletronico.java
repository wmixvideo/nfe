package com.fincatto.documentofiscal.cte200.classes.cte;

import com.fincatto.documentofiscal.DFBase;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "idDocAntEle")
public class CTInfoDocumentoAnteriorEletronico extends DFBase {
    private static final long serialVersionUID = -4502364224640143614L;

    @Element(name = "chave")
    private String chaveCte;

    public String getChaveCte() {
        return this.chaveCte;
    }

    public void setChaveCte(final String chaveCte) {
        this.chaveCte = chaveCte;
    }

}
