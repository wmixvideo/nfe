package com.fincatto.documentofiscal.nfe310.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.validadores.StringValidador;

public class NFNotaInfoLocal extends DFBase {
    private static final long serialVersionUID = -6618642990785758823L;

    @Element(name = "CNPJ", required = false)
    private String cnpj;

    @Element(name = "CPF", required = false)
    private String cpf;

    @Element(name = "xLgr", required = true)
    private String logradouro;

    @Element(name = "nro", required = true)
    private String numero;

    @Element(name = "xCpl", required = false)
    private String complemento;

    @Element(name = "xBairro", required = true)
    private String bairro;

    @Element(name = "cMun", required = true)
    private String codigoMunicipio;

    @Element(name = "xMun", required = true)
    private String nomeMunicipio;

    @Element(name = "UF", required = true)
    private String uf;

    public void setCnpj(final String cnpj) {
        if (this.cpf != null) {
            throw new IllegalStateException("Nao pode setar CNPJ por que o CPF foi setado");
        }
        StringValidador.cnpj(cnpj);
        this.cnpj = cnpj;
    }

    public void setCpf(final String cpf) {
        if (this.cnpj != null) {
            throw new IllegalStateException("Nao pode setar CPF por que o CNPJ foi setado");
        }
        StringValidador.cpf(cpf);
        this.cpf = cpf;
    }

    public void setLogradouro(final String logradouro) {
        StringValidador.tamanho60(logradouro, "Logradouro Local");
        this.logradouro = logradouro;
    }

    public void setNumero(final String numero) {
        StringValidador.tamanho60(numero, "Numero Local");
        this.numero = numero;
    }

    public void setComplemento(final String complemento) {
        StringValidador.tamanho60(complemento, "Complemento Local");
        this.complemento = complemento;
    }

    public void setBairro(final String bairro) {
        StringValidador.tamanho2ate60(bairro, "Bairro Local");
        this.bairro = bairro;
    }

    public void setCodigoMunicipio(final String codigoMunicipio) {
        StringValidador.exatamente7(codigoMunicipio, "Codigo Municipio Local");
        this.codigoMunicipio = codigoMunicipio;
    }

    public void setNomeMunicipio(final String nomeMunicipio) {
        StringValidador.tamanho60(nomeMunicipio, "Nome Municipio Local");
        this.nomeMunicipio = nomeMunicipio;
    }

    public void setUf(final DFUnidadeFederativa uf) {
        this.uf = uf.getCodigo();
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public String getCpf() {
        return this.cpf;
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

    public String getNomeMunicipio() {
        return this.nomeMunicipio;
    }

    public String getUf() {
        return this.uf;
    }
}