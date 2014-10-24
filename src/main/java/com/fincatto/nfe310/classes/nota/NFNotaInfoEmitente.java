package com.fincatto.nfe310.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.classes.NFEndereco;
import com.fincatto.nfe310.classes.NFRegimeTributario;
import com.fincatto.nfe310.validadores.StringValidador;

public class NFNotaInfoEmitente extends NFBase {

    @Element(name = "CNPJ", required = false)
    private String cnpj;

    @Element(name = "CPF", required = false)
    private String cpf;

    @Element(name = "xNome", required = true)
    private String razaoSocial;

    @Element(name = "xFant", required = false)
    private String nomeFantasia;

    @Element(name = "enderEmit", required = true)
    private NFEndereco endereco;

    @Element(name = "IE", required = true)
    private String inscricaoEstadual;

    @Element(name = "IEST", required = false)
    private String inscricaoEstadualSubstituicaoTributaria;

    @Element(name = "IM", required = false)
    private String inscricaoMunicipal;

    @Element(name = "CNAE", required = false)
    private String classificacaoNacionalAtividadesEconomicas;

    @Element(name = "CRT", required = true)
    private NFRegimeTributario regimeTributario;

    public void setCnpj(final String cnpj) {
        if (this.cpf != null) {
            throw new IllegalStateException("Nao pode setar CNPJ caso CPF esteja setado");
        }
        StringValidador.cnpj(cnpj);
        this.cnpj = cnpj;
    }

    public void setCpf(final String cpf) {
        if (this.cnpj != null) {
            throw new IllegalStateException("Nao pode setar CPF caso CNPJ esteja setado");
        }
        StringValidador.cpf(cpf);
        this.cpf = cpf;
    }

    public void setRazaoSocial(final String razaoSocial) {
        StringValidador.tamanho60(razaoSocial);
        this.razaoSocial = razaoSocial;
    }

    public void setNomeFantasia(final String nomeFantasia) {
        StringValidador.tamanho60(nomeFantasia);
        this.nomeFantasia = nomeFantasia;
    }

    public void setEndereco(final NFEndereco endereco) {
        this.endereco = endereco;
    }

    public void setInscricaoEstadual(final String inscricaoEstadual) {
        StringValidador.inscricaoEstadual(inscricaoEstadual);
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public void setInscricaoEstadualSubstituicaoTributaria(final String inscricaoEstadualSubstituicaoTributaria) {
        StringValidador.inscricaoEstadualSemIsencao(inscricaoEstadualSubstituicaoTributaria);
        this.inscricaoEstadualSubstituicaoTributaria = inscricaoEstadualSubstituicaoTributaria;
    }

    public void setInscricaoMunicipal(final String inscricaoMunicipal) {
        StringValidador.tamanho15(inscricaoMunicipal);
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public void setClassificacaoNacionalAtividadesEconomicas(final String classificacaoNacionalAtividadesEconomicas) {
        StringValidador.exatamente7N(classificacaoNacionalAtividadesEconomicas);
        this.classificacaoNacionalAtividadesEconomicas = classificacaoNacionalAtividadesEconomicas;
    }

    public void setRegimeTributario(final NFRegimeTributario regimeTributario) {
        this.regimeTributario = regimeTributario;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    public String getNomeFantasia() {
        return this.nomeFantasia;
    }

    public NFEndereco getEndereco() {
        return this.endereco;
    }

    public String getInscricaoEstadual() {
        return this.inscricaoEstadual;
    }

    public String getInscricaoEstadualSubstituicaoTributaria() {
        return this.inscricaoEstadualSubstituicaoTributaria;
    }

    public String getInscricaoMunicipal() {
        return this.inscricaoMunicipal;
    }

    public String getClassificacaoNacionalAtividadesEconomicas() {
        return this.classificacaoNacionalAtividadesEconomicas;
    }

    public NFRegimeTributario getRegimeTributario() {
        return this.regimeTributario;
    }
}