
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

@Root(name = "CServ")
public class NFSeSefinNacionalCServ {

    @Element(required = true)
    protected String cTribNac;
    protected String cTribMun;
    @Element(required = true)
    protected String xDescServ;
    @Element(name = "cNBS", required = false)
    protected String cnbs;
    protected String cIntContrib;

    public String getCTribNac() {
        return cTribNac;
    }

    public void setCTribNac(String value) {
        this.cTribNac = value;
    }

    public String getCTribMun() {
        return cTribMun;
    }

    public void setCTribMun(String value) {
        this.cTribMun = value;
    }

    public String getXDescServ() {
        return xDescServ;
    }

    public void setXDescServ(String value) {
        this.xDescServ = value;
    }

    public String getCNBS() {
        return cnbs;
    }

    public void setCNBS(String value) {
        this.cnbs = value;
    }

    public String getCIntContrib() {
        return cIntContrib;
    }

    public void setCIntContrib(String value) {
        this.cIntContrib = value;
    }

}
