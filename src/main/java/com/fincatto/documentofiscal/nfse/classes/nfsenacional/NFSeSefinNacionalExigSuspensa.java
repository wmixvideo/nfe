
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

@Root(name = "ExigSuspensa")
public class NFSeSefinNacionalExigSuspensa {

    @Element(required = true)
    protected String tpSusp;
    @Element(required = true)
    protected String nProcesso;

    public String getTpSusp() {
        return tpSusp;
    }

    public void setTpSusp(String value) {
        this.tpSusp = value;
    }

    public String getNProcesso() {
        return nProcesso;
    }

    public void setNProcesso(String value) {
        this.nProcesso = value;
    }

}
