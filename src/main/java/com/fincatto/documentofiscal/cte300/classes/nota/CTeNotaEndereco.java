package com.fincatto.documentofiscal.cte300.classes.nota;

import com.fincatto.documentofiscal.DFPais;
import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.StringValidador;

/**
 * @author Caio
 * @info Dados do endereço
 */

public class CTeNotaEndereco extends DFBase {
    private static final long serialVersionUID = 1528514404620728196L;

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
    private String descricaoMunicipio;

    @Element(name = "CEP", required = false)
    private String cep;

    @Element(name = "UF", required = true)
    private String siglaUF;

    @Element(name = "cPais", required = false)
    private DFPais codigoPais;

    @Element(name = "xPais", required = false)
    private String descricaoPais;

    public CTeNotaEndereco() {
        this.logradouro = null;
        this.numero = null;
        this.complemento = null;
        this.bairro = null;
        this.codigoMunicipio = null;
        this.descricaoMunicipio = null;
        this.cep = null;
        this.siglaUF = null;
        this.codigoPais = null;
        this.descricaoPais = null;
    }

    public String getLogradouro() {
        return this.logradouro;
    }

    /**
     * Logradouro
     */
    public void setLogradouro(final String logradouro) {
        StringValidador.tamanho2ate60(logradouro, "Logradouro");
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return this.numero;
    }

    /**
     * Número
     */
    public void setNumero(final String numero) {
        StringValidador.tamanho60(numero, "Número");
        this.numero = numero;
    }

    public String getComplemento() {
        return this.complemento;
    }

    /**
     * Complemento
     */
    public void setComplemento(final String complemento) {
        StringValidador.tamanho60(complemento, "Complemento");
        this.complemento = complemento;
    }

    public String getBairro() {
        return this.bairro;
    }

    /**
     * Bairro
     */
    public void setBairro(final String bairro) {
        StringValidador.tamanho2ate60(bairro, "Bairro");
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
        StringValidador.exatamente7N(codigoMunicipio, "Código do município");
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
        StringValidador.tamanho2ate60(descricaoMunicipio, "Nome do município");
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
        StringValidador.exatamente8N(cep, "CEP");
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
        StringValidador.exatamente2(siglaUf, "Sigla da UF");
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
        StringValidador.tamanho4N(codigoPais, "Código do país");
        this.codigoPais = DFPais.valueOfCodigo(codigoPais);
    }

    public String getDescricaoPais() {
        return this.descricaoPais;
    }

    /**
     * Nome do país
     */
    public void setDescricaoPais(final String descricaoPais) {
        StringValidador.tamanho2ate60(descricaoPais, "Nome do país");
        this.descricaoPais = descricaoPais;
    }
}
