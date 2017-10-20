package com.fincatto.documentofiscal.cte200.classes.cte;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;

public class CTInfoRemetente extends DFBase {
    private static final long serialVersionUID = -8268406666230150174L;

    @Element(name = "CNPJ", required = false)
    private String cnpj;

    @Element(name = "CPF", required = false)
    private String cpf;

    @Element(name = "IE", required = false)
    private String inscricaoEstadual;

    @Element(name = "xNome")
    private String razaoSocial;

    @Element(name = "xFant", required = false)
    private String nomeFantasia;

    @Element(name = "fone", required = false)
    private String fone;

    @Element(name = "enderReme")
    private CTInfoEndereco endereco;

    @Element(name = "email", required = false)
    private String email;

    @Element(name = "locColeta", required = false)
    private CTInfoLocalColetaEntrega localColeta;

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

    public String getInscricaoEstadual() {
        return this.inscricaoEstadual;
    }

    public void setInscricaoEstadual(final String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    public void setRazaoSocial(final String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return this.nomeFantasia;
    }

    public void setNomeFantasia(final String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getFone() {
        return this.fone;
    }

    public void setFone(final String fone) {
        this.fone = fone;
    }

    public CTInfoEndereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(final CTInfoEndereco endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public CTInfoLocalColetaEntrega getLocalColeta() {
        return this.localColeta;
    }

    public void setLocalColeta(final CTInfoLocalColetaEntrega localColeta) {
        this.localColeta = localColeta;
    }

}
