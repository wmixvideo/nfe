
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

@Root(name = "EnderecoSimples")
public class NFSeSefinNacionalEnderecoSimples {

    @Element(name = "CEP", required = false)
    protected String cep;
    protected NFSeSefinNacionalEnderExtSimples endExt;
    @Element(required = true)
    protected String xLgr;
    @Element(required = true)
    protected String nro;
    protected String xCpl;
    @Element(required = true)
    protected String xBairro;

    public String getCEP() {
        return cep;
    }

    public void setCEP(String value) {
        this.cep = value;
    }

    public NFSeSefinNacionalEnderExtSimples getEndExt() {
        return endExt;
    }

    public void setEndExt(NFSeSefinNacionalEnderExtSimples value) {
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
