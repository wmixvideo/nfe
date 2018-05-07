package com.fincatto.documentofiscal.cte200.classes.cte;

import com.fincatto.documentofiscal.DFPais;
import com.fincatto.documentofiscal.validadores.StringValidador;
import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;

public class CTInfoEndereco extends DFBase {
    private static final long serialVersionUID = -3018557372923308651L;

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

    @Element(name = "CEP", required = false)
    private String cep;

    @Element(name = "UF")
    private DFUnidadeFederativa unidadeFederativa;

    @Element(name = "cPais", required = false)
    private DFPais codigoPais;

    @Element(name = "xPais", required = false)
    private String descricaoPais;

    // Emitente
    @Element(name = "fone", required = false)
    private String telefone;

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

    public DFUnidadeFederativa getUnidadeFederativa() {
        return this.unidadeFederativa;
    }

    public void setUnidadeFederativa(final DFUnidadeFederativa unidadeFederativa) {
        this.unidadeFederativa = unidadeFederativa;
    }

    public void setCodigoPais(final String codigoPais) {
        StringValidador.tamanho2a4(codigoPais, "Codigo do pais");
        this.codigoPais = DFPais.valueOfCodigo(codigoPais);
    }

    public void setCodigoPais(final DFPais codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getDescricaoPais() {
        return this.descricaoPais;
    }

    public void setDescricaoPais(final String descricaoPais) {
        this.descricaoPais = descricaoPais;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(final String telefone) {
        this.telefone = telefone;
    }

}