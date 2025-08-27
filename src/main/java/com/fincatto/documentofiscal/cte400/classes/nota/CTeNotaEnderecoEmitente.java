package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;

/**
 * Dados do endereço
 */

public class CTeNotaEnderecoEmitente extends DFBase {
    private static final long serialVersionUID = -7015077250817923772L;

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

    @Element(name = "fone", required = false)
    private String telefone;

    public String getLogradouro() {
        return this.logradouro;
    }

    /**
     * Logradouro
     */
    public void setLogradouro(final String logradouro) {
        DFStringValidador.tamanho2ate60(logradouro, "Logradouro no endereço do Emitente");
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return this.numero;
    }

    /**
     * Número
     */
    public void setNumero(final String numero) {
        DFStringValidador.tamanho60(numero, "Número no endereço do Emitente");
        this.numero = numero;
    }

    public String getComplemento() {
        return this.complemento;
    }

    /**
     * Complemento
     */
    public void setComplemento(final String complemento) {
        DFStringValidador.tamanho60(complemento, "Complemento no endereço do Emitente");
        this.complemento = complemento;
    }

    public String getBairro() {
        return this.bairro;
    }

    /**
     * Bairro
     */
    public void setBairro(final String bairro) {
        DFStringValidador.tamanho2ate60(bairro, "Bairro no endereço do Emitente");
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
        DFStringValidador.exatamente7N(codigoMunicipio, "Código do município no endereço do Emitente");
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
        DFStringValidador.tamanho2ate60(descricaoMunicipio, "Nome do município no endereço do Emitente");
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
        DFStringValidador.exatamente8N(cep, "CEP no endereço do Emitente");
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
        DFStringValidador.exatamente2(siglaUF, "Sigla da UF no endereço do Emitente");
        this.siglaUF = siglaUF;
    }

    public String getTelefone() {
        return this.telefone;
    }

    /**
     * Telefone
     */
    public void setTelefone(final String telefone) {
        DFStringValidador.telefone(telefone);
        this.telefone = telefone;
    }
}
