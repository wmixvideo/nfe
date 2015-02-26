package com.fincatto.nfe310.classes.cadastro;

import org.simpleframework.xml.Element;

import com.fincatto.nfe310.classes.NFBase;

public class NFRetornoConsultaCadastroEndereco extends NFBase {
    @Element(name = "xLgr", required = false)
    private String logradouro;

    @Element(name = "nro", required = false)
    private String numero;

    @Element(name = "xCpl", required = false)
    private String complemento;

    @Element(name = "xBairro", required = false)
    private String bairro;

    @Element(name = "cMun", required = false)
    private String codigoMunicipio;

    @Element(name = "xMun", required = false)
    private String descricaoMunicipio;

    @Element(name = "CEP", required = false)
    private String cep;

    public String getLogradouro() {
        return this.logradouro;
    }

    public void setLogradouro(final String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(final String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return this.complemento;
    }

    public void setComplemento(final String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(final String bairro) {
        this.bairro = bairro;
    }

    public String getCodigoMunicipio() {
        return this.codigoMunicipio;
    }

    public void setCodigoMunicipio(final String codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public String getDescricaoMunicipio() {
        return this.descricaoMunicipio;
    }

    public void setDescricaoMunicipio(final String descricaoMunicipio) {
        this.descricaoMunicipio = descricaoMunicipio;
    }

    public String getCep() {
        return this.cep;
    }

    public void setCep(final String cep) {
        this.cep = cep;
    }
}