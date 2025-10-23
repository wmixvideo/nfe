
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;


@Root(name = "EnderObraEvento")
public class NFSeSefinNacionalEnderObraEvento {

    @Element(required = true)
    protected String cEndPost;
    @Element(required = true)
    protected String xLgr;
    @Element(required = true)
    protected String nro;
    protected String xCpl;
    @Element(required = true)
    protected String xBairro;
    @Element(required = true)
    protected String xCidade;
    @Element(required = true)
    protected String xEstProvReg;

    public String getCEndPost() {
        return cEndPost;
    }

    public void setCEndPost(String value) {
        this.cEndPost = value;
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

    public String getXCidade() {
        return xCidade;
    }

    public void setXCidade(String value) {
        this.xCidade = value;
    }

    public String getXEstProvReg() {
        return xEstProvReg;
    }

    public void setXEstProvReg(String value) {
        this.xEstProvReg = value;
    }

}
