package com.fincatto.nfe310.classes.cadastro;

import org.simpleframework.xml.Element;

import com.fincatto.nfe310.classes.NFBase;

public class NFInfoConsultaCadastro extends NFBase {

    @Element(name = "xServ", required = true)
    private String servico;

    @Element(name = "UF", required = true)
    private String uf;

    @Element(name = "IE", required = false)
    private String inscricaoEstadual;

    @Element(name = "CNPJ", required = false)
    private String cnpj;

    @Element(name = "CPF", required = false)
    private String cpf;

    public String getServico() {
        return this.servico;
    }

    public void setServico(final String servico) {
        this.servico = servico;
    }

    public String getUf() {
        return this.uf;
    }

    public void setUf(final String uf) {
        this.uf = uf;
    }

    public String getInscricaoEstadual() {
        return this.inscricaoEstadual;
    }

    public void setInscricaoEstadual(final String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
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
}