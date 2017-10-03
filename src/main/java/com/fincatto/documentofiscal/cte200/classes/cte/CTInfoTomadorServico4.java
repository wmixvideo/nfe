package com.fincatto.documentofiscal.cte200.classes.cte;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte200.classes.CTTomadorServico;

public class CTInfoTomadorServico4 extends DFBase {
    private static final long serialVersionUID = 4381954093814405296L;

    @Element(name = "toma")
    private CTTomadorServico tomadorServico;

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
    private String telefone;

    @Element(name = "enderToma")
    private CTInfoEndereco endereco;

    @Element(name = "email", required = false)
    private String email;

    public void setTomadorServico(final CTTomadorServico tomadorServico) {
        if (!CTTomadorServico.TOMADOR_4.contains(tomadorServico)) {
            throw new IllegalArgumentException("O tomador do servico n\u00e3o \u00e9 v\u00e1lido para este papel");
        }
        this.tomadorServico = tomadorServico;
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

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(final String telefone) {
        this.telefone = telefone;
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

    public CTTomadorServico getTomadorServico() {
        return this.tomadorServico;
    }

}