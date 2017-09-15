package com.fincatto.cte300.classes.distribuicao;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "distDFeInt")
public class DistDFeInt {

    @Attribute(name = "versao", required = false)
    private String versao;

    @Element(required = true)
    protected String tpAmb;

    @Element(name = "cUFAutor", required = true)
    protected String cUFAutor;

    @Element(name = "CNPJ")
    protected String cnpj;

    @Element(name = "CPF")
    protected String cpf;

    @Element
    protected DistNSU distNSU;

    @Element
    protected ConsNSU consNSU;

    public String getVersao() {
        return this.versao;
    }

    public void setVersao(final String versao) {
        this.versao = versao;
    }

    public String getTpAmb() {
        return this.tpAmb;
    }

    public void setTpAmb(final String tpAmb) {
        this.tpAmb = tpAmb;
    }

    public String getCUFAutor() {
        return this.cUFAutor;
    }

    public void setCUFAutor(final String cUFAutor) {
        this.cUFAutor = cUFAutor;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(final String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(final String cpf) {
        this.cpf = cpf;
    }

    public DistNSU getDistNSU() {
        return this.distNSU;
    }

    public void setDistNSU(final DistNSU distNSU) {
        this.distNSU = distNSU;
    }

    public ConsNSU getConsNSU() {
        return this.consNSU;
    }

    public void setConsNSU(final ConsNSU consNSU) {
        this.consNSU = consNSU;
    }
}