
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

@Root(name = "Emitente")
public class NFSeSefinNacionalEmitente {

    @Element(name = "CNPJ", required = false)
    protected String cnpj;
    @Element(name = "CPF", required = false)
    protected String cpf;
    @Element(name = "IM", required = false)
    protected String im;
    @Element(required = true)
    protected String xNome;
    protected String xFant;
    @Element(required = true)
    protected NFSeSefinNacionalEnderecoEmitente enderNac;
    protected String fone;
    protected String email;

    public String getCNPJ() {
        return cnpj;
    }

    public void setCNPJ(String value) {
        this.cnpj = value;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String value) {
        this.cpf = value;
    }

    public String getIM() {
        return im;
    }

    public void setIM(String value) {
        this.im = value;
    }

    public String getXNome() {
        return xNome;
    }

    public void setXNome(String value) {
        this.xNome = value;
    }

    public String getXFant() {
        return xFant;
    }

    public void setXFant(String value) {
        this.xFant = value;
    }

    public NFSeSefinNacionalEnderecoEmitente getEnderNac() {
        return enderNac;
    }

    public void setEnderNac(NFSeSefinNacionalEnderecoEmitente value) {
        this.enderNac = value;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String value) {
        this.fone = value;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String value) {
        this.email = value;
    }

}
