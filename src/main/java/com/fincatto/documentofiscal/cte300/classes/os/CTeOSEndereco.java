package com.fincatto.documentofiscal.cte300.classes.os;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFPais;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;

public class CTeOSEndereco extends DFBase {
    private static final long serialVersionUID = 1357977819965129753L;

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
    private String siglaUF;

    @Element(name = "cPais", required = false)
    private DFPais codigoPais;

    @Element(name = "xPais", required = false)
    private String descricaoPais;

    public String getLogradouro() {
        return this.logradouro;
    }

    /**
     * Logradouro
     */
    public void setLogradouro(final String logradouro) {
        DFStringValidador.tamanho2ate60(logradouro, "Logradouro");
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return this.numero;
    }

    /**
     * Número
     */
    public void setNumero(final String numero) {
        DFStringValidador.tamanho60(numero, "Número");
        this.numero = numero;
    }

    public String getComplemento() {
        return this.complemento;
    }

    /**
     * Complemento
     */
    public void setComplemento(final String complemento) {
        DFStringValidador.tamanho60(complemento, "Complemento");
        this.complemento = complemento;
    }

    public String getBairro() {
        return this.bairro;
    }

    /**
     * Bairro
     */
    public void setBairro(final String bairro) {
        DFStringValidador.tamanho2ate60(bairro, "Bairro");
        this.bairro = bairro;
    }

    public String getCodigoMunicipio() {
        return this.codigoMunicipio;
    }

    /**
     * Código do município (utilizar a tabela do IBGE)<br>
     * Informar 9999999 para operações com o exterior.
     */
    public void setCodigoMunicipio(final String codigoMunicipio) {
        DFStringValidador.exatamente7N(codigoMunicipio, "Código do município");
        this.codigoMunicipio = codigoMunicipio;
    }

    public String getDescricaoMunicipio() {
        return this.descricaoMunicipio;
    }

    /**
     * Nome do município<br>
     * Informar EXTERIOR para operações com o exterior.
     */
    public void setDescricaoMunicipio(final String descricaoMunicipio) {
        DFStringValidador.tamanho2ate60(descricaoMunicipio, "Nome do município");
        this.descricaoMunicipio = descricaoMunicipio;
    }

    public String getCep() {
        return this.cep;
    }

    /**
     * CEP<br>
     * Informar os zeros não significativos
     */
    public void setCep(final String cep) {
        DFStringValidador.exatamente8N(cep, "CEP");
        this.cep = cep;
    }

    public String getSiglaUF() {
        return this.siglaUF;
    }

    /**
     * Sigla da UF<br>
     * Informar EX para operações com o exterior.
     */
    public void setSiglaUF(final String siglaUf) {
        DFStringValidador.exatamente2(siglaUf, "Sigla da UF");
        this.siglaUF = siglaUf;
    }

    public DFPais getCodigoPais() {
        return this.codigoPais;
    }

    /**
     * Código do país<br>
     * Utilizar a tabela do BACEN
     */
    public void setCodigoPais(final String codigoPais) {
        DFStringValidador.tamanho4N(codigoPais, "Código do país");
        this.codigoPais = DFPais.valueOfCodigo(codigoPais);
    }

    public String getDescricaoPais() {
        return this.descricaoPais;
    }

    /**
     * Nome do país
     */
    public void setDescricaoPais(final String descricaoPais) {
        DFStringValidador.tamanho2ate60(descricaoPais, "Nome do país");
        this.descricaoPais = descricaoPais;
    }
}
