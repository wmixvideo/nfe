
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

@Root(name = "EnderecoEmitente")
public class NFSeSefinNacionalEnderecoEmitente {

    @Element(required = true)
    protected String xLgr;
    @Element(required = true)
    protected String nro;
    protected String xCpl;
    @Element(required = true)
    protected String xBairro;
    @Element(required = true)
    protected String cMun;
    @Element(name = "UF", required = false)
    protected NFSeSefinNacionalUF uf;
    @Element(name = "CEP", required = false)
    protected String cep;

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

    public String getCMun() {
        return cMun;
    }

    public void setCMun(String value) {
        this.cMun = value;
    }

    public NFSeSefinNacionalUF getUF() {
        return uf;
    }

    public void setUF(NFSeSefinNacionalUF value) {
        this.uf = value;
    }

    public String getCEP() {
        return cep;
    }

    public void setCEP(String value) {
        this.cep = value;
    }

}
