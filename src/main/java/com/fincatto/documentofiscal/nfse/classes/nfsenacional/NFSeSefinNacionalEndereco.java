
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

@Root(name = "Endereco")
public class NFSeSefinNacionalEndereco {

    protected NFSeSefinNacionalEnderNac endNac;
    protected NFSeSefinNacionalEnderExt endExt;
    @Element(required = true)
    protected String xLgr;
    @Element(required = true)
    protected String nro;
    protected String xCpl;
    @Element(required = true)
    protected String xBairro;

    public NFSeSefinNacionalEnderNac getEndNac() {
        return endNac;
    }

    public void setEndNac(NFSeSefinNacionalEnderNac value) {
        this.endNac = value;
    }

    public NFSeSefinNacionalEnderExt getEndExt() {
        return endExt;
    }

    public void setEndExt(NFSeSefinNacionalEnderExt value) {
        this.endExt = value;
    }

    public String getXLgr() {
        return xLgr;
    }

    public void setXLgr(String value) {
        this.xLgr = value;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String value) {
        this.nro = value;
    }

    public String getXCpl() {
        return xCpl;
    }

    public void setXCpl(String value) {
        this.xCpl = value;
    }

    public String getXBairro() {
        return xBairro;
    }

    public void setXBairro(String value) {
        this.xBairro = value;
    }

}
