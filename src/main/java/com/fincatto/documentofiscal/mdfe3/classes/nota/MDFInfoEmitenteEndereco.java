package com.fincatto.documentofiscal.mdfe3.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.StringValidador;

/**
 * Created by Eldevan Nery Junior on 03/11/17.
 * <h1>Identificação do Emitente do Manifesto</h1>
 */
public class MDFInfoEmitenteEndereco extends DFBase {
    private static final long serialVersionUID = 6621163221326345587L;

    private static final String INFO = "endereço do Emitente";

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

    @Element(name = "fone", required = false)
    private String telefone;

    @Element(name = "email", required = false)
    private String email;

    public String getLogradouro() {
        return this.logradouro;
    }

    /**
     * Logradouro
     */
    public void setLogradouro(final String logradouro) {
        StringValidador.tamanho2ate60(logradouro, "Logradouro no " + MDFInfoEmitenteEndereco.INFO);
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return this.numero;
    }

    /**
     * Número
     */
    public void setNumero(final String numero) {
        StringValidador.tamanho60(numero, "Número no " + MDFInfoEmitenteEndereco.INFO);
        this.numero = numero;
    }

    public String getComplemento() {
        return this.complemento;
    }

    /**
     * Complemento
     */
    public void setComplemento(final String complemento) {
        StringValidador.tamanho60(complemento, "Complemento no " + MDFInfoEmitenteEndereco.INFO);
        this.complemento = complemento;
    }

    public String getBairro() {
        return this.bairro;
    }

    /**
     * Bairro
     */
    public void setBairro(final String bairro) {
        StringValidador.tamanho2ate60(bairro, "Bairro no " + MDFInfoEmitenteEndereco.INFO);
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
        StringValidador.exatamente7N(codigoMunicipio, "Código do município no " + MDFInfoEmitenteEndereco.INFO);
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
        StringValidador.tamanho2ate60(descricaoMunicipio, "Nome do município no " + MDFInfoEmitenteEndereco.INFO);
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
        StringValidador.exatamente8N(cep, "CEP no " + MDFInfoEmitenteEndereco.INFO);
        this.cep = cep;
    }

    public String getSiglaUF() {
        return this.siglaUF;
    }

    /**
     * Sigla da UF<br>
     * Informar EX para operações com o exterior.
     */
    public void setSiglaUF(final String siglaUF) {
        StringValidador.exatamente2(siglaUF, "Sigla da UF no " + MDFInfoEmitenteEndereco.INFO);
        this.siglaUF = siglaUF;
    }

    public String getTelefone() {
        return this.telefone;
    }

    /**
     * Telefone
     */
    public void setTelefone(final String telefone) {
        this.telefone = StringValidador.telefone(telefone, MDFInfoEmitenteEndereco.INFO);
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = StringValidador.email(email, MDFInfoEmitenteEndereco.INFO);
    }
}
