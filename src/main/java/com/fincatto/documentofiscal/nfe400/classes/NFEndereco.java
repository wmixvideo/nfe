package com.fincatto.documentofiscal.nfe400.classes;

import com.fincatto.documentofiscal.DFPais;
import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.validadores.StringValidador;

public class NFEndereco extends DFBase {
    private static final long serialVersionUID = 417768837786948754L;

    @Element(name = "xLgr")
    private String logradouro;

    @Element(name = "nro")
    private String numero;

    @Element(name = "xCpl", required = false)
    private String complemento;

    @Element(name = "xBairro")
    private String bairro;

    @Element(name = "cMun")
    private String codigoMunicipio;

    @Element(name = "xMun")
    private String descricaoMunicipio;

    @Element(name = "UF")
    private String uf;

    @Element(name = "CEP", required = false)
    private String cep;

    @Element(name = "cPais", required = false)
    private DFPais codigoPais = DFPais.BRASIL;

    @Element(name = "xPais", required = false)
    private String descricaoPais = DFPais.BRASIL.getDescricao();

    @Element(name = "fone", required = false)
    private String telefone;

    public void setLogradouro(final String logradouro) {
        StringValidador.tamanho60(logradouro, "Logradouro");
        this.logradouro = logradouro;
    }

    public void setNumero(final String numero) {
        StringValidador.tamanho60(numero, "Numero do Endereco");
        this.numero = numero;
    }

    public void setComplemento(final String complemento) {
        StringValidador.tamanho60(complemento, "Complemento");
        this.complemento = complemento;
    }

    public void setBairro(final String bairro) {
        StringValidador.tamanho2ate60(bairro, "Bairro");
        this.bairro = bairro;
    }

    public void setCodigoMunicipio(final String codigoMunicipio) {
        StringValidador.exatamente7(codigoMunicipio, "Codigo do Municipio");
        this.codigoMunicipio = codigoMunicipio;
    }

    public void setDescricaoMunicipio(final String descricaoMunicipio) {
        StringValidador.tamanho60(descricaoMunicipio, "Descricao do Municipio");
        this.descricaoMunicipio = descricaoMunicipio;
    }

    public void setUf(final DFUnidadeFederativa uf) {
        this.uf = uf.getCodigo();
    }

    public void setCep(final String cep) {
        StringValidador.exatamente8(cep, "CEP");
        this.cep = cep;
    }

    public void setCodigoPais(final String codigoPais) {
        StringValidador.tamanho2a4(codigoPais, "Codigo do pais");
        this.codigoPais = DFPais.valueOfCodigo(codigoPais);
    }

    public void setCodigoPais(final DFPais codigoPais) {
        this.codigoPais = codigoPais;
    }

    public void setDescricaoPais(final String descricaoPais) {
        StringValidador.tamanho60(descricaoPais, "Descricao do pais");
        this.descricaoPais = descricaoPais;
    }

    public void setTelefone(final String telefone) {
        StringValidador.telefone(telefone);
        this.telefone = telefone;
    }

    public String getLogradouro() {
        return this.logradouro;
    }

    public String getNumero() {
        return this.numero;
    }

    public String getComplemento() {
        return this.complemento;
    }

    public String getBairro() {
        return this.bairro;
    }

    public String getCodigoMunicipio() {
        return this.codigoMunicipio;
    }

    public String getDescricaoMunicipio() {
        return this.descricaoMunicipio;
    }

    public String getUf() {
        return this.uf;
    }

    public String getCep() {
        return this.cep;
    }

    public DFPais getCodigoPais() {
        return this.codigoPais;
    }

    public String getDescricaoPais() {
        return this.descricaoPais;
    }

    public String getTelefone() {
        return this.telefone;
    }
}