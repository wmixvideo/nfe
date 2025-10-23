
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

@Root(name = "EnderExtSimples")
public class NFSeSefinNacionalEnderExtSimples {

    @Element(required = true)
    protected String cEndPost;
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
