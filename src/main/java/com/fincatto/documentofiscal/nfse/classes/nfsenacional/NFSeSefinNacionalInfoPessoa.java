
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

/**
 * Informações das pessoas envolvidas na NFS-e. Pode ser o tomador, o intermediário ou o fornecedor (dedução/redução)
 */

@Root(name = "InfoPessoa")
public class NFSeSefinNacionalInfoPessoa {

    @Element(name = "CNPJ", required = false)
    protected String cnpj;
    @Element(name = "CPF", required = false)
    protected String cpf;
    @Element(name = "NIF", required = false)
    protected String nif;
    @Element(name = "cNaoNIF", required = false)
    protected NFSeSefinNacionalInfoPrestadorCodigoNaoNIF codigoNaoNIF;
    @Element(name = "CAEPF", required = false)
    protected String nroCadastroAtividadeEconomicaPessoaFisica;
    @Element(name = "IM", required = false)
    protected String inscricaoMunicipal;
    @Element(name = "xNome")
    protected String nome;
    @Element(name = "end", required = false)
    protected NFSeSefinNacionalEndereco endereco;
    @Element(name = "fone", required = false)
    protected String telefone;
    @Element(name = "email", required = false)
    protected String email;

    /**
     * @return CNPJ da pessoa
     */
    public String getCNPJ() {
        return cnpj;
    }

    /**
     * @param cnpj CNPJ da pessoa
     */
    public void setCNPJ(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return CPF da pessoa
     */
    public String getCPF() {
        return cpf;
    }

    /**
     * @param cpf CPF da pessoa
     */
    public NFSeSefinNacionalInfoPessoa setCPF(String cpf) {
        this.cpf = cpf;
        return this;
    }

    /**
     * Número de Identificação Fiscal fornecido por órgão de administração tributária no exterior
     *
     * @return NIF da pessoa
     */
    public String getNIF() {
        return nif;
    }

    /**
     * Número de Identificação Fiscal fornecido por órgão de administração tributária no exterior
     *
     * @param nif NIF do prestador de serviço
     */
    public void setNIF(String nif) {
        this.nif = nif;
    }

    /**
     * @return Código de motivo para não informação do NIF
     */
    public NFSeSefinNacionalInfoPrestadorCodigoNaoNIF getCodigoNaoNIF() {
        return codigoNaoNIF;
    }

    /**
     * @param codigoNaoNIF motivo para não informação do NIF
     */
    public void setCodigoNaoNIF(NFSeSefinNacionalInfoPrestadorCodigoNaoNIF codigoNaoNIF) {
        this.codigoNaoNIF = codigoNaoNIF;
    }

    /**
     * @return CAEPF - Cadastro de Atividade Econômica da Pessoa Física
     */
    public String getCAEPF() {
        return nroCadastroAtividadeEconomicaPessoaFisica;
    }

    /**
     * @param nroCadastroAtividadeEconomicaPessoaFisica CAEPF - Cadastro de Atividade Econômica da Pessoa Física
     */
    public void setCAEPF(String nroCadastroAtividadeEconomicaPessoaFisica) {
        this.nroCadastroAtividadeEconomicaPessoaFisica = nroCadastroAtividadeEconomicaPessoaFisica;
    }

    /**
     * @return Inscrição Municipal da pessoa
     */
    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    /**
     * @param value Inscrição Municipal da pessoa
     */
    public void setInscricaoMunicipal(String value) {
        this.inscricaoMunicipal = value;
    }

    /**
     * @return Nome da pessoa
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome Nome da pessoa
     */
    public NFSeSefinNacionalInfoPessoa setNome(String nome) {
        this.nome = nome;
        return this;
    }

    /**
     * @return Endereço da pessoa
     */
    public NFSeSefinNacionalEndereco getEndereco() {
        return endereco;
    }

    /**
     * @param endereco Endereço da pessoa
     */
    public void setEndereco(NFSeSefinNacionalEndereco endereco) {
        this.endereco = endereco;
    }

    /**
     * @return Telefone da pessoa
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone Telefone da pessoa
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return Email da pessoa
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email Email da pessoa
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
