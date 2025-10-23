
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

@Root(name = "EnderNac")
public class NFSeSefinNacionalEnderNac {

    @Element(required = true)
    protected String cMun;
    @Element(name = "CEP", required = false)
    protected String cep;

    public String getCMun() {
        return cMun;
    }

    public void setCMun(String value) {
        this.cMun = value;
    }

    public String getCEP() {
        return cep;
    }

    public void setCEP(String value) {
        this.cep = value;
    }

}
