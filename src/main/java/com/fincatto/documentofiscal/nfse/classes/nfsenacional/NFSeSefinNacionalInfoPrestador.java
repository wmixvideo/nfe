
package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

import org.simpleframework.xml.*;

/**
 * Informações do prestador da NFS-e. Difere das demais pessoas por causa das informações de regimes de tributação
 */

@Root(name = "prest")
public class NFSeSefinNacionalInfoPrestador {

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
    @Element(name = "xNome", required = false)
    protected String nome;
    @Element(name = "end", required = false)
    protected NFSeSefinNacionalEndereco endereco;
    @Element(name = "fone", required = false)
    protected String telefone;
    @Element(name = "email", required = false)
    protected String email;
    @Element(name = "regTrib")
    protected NFSeSefinNacionalRegTrib regimeTributario;

    /**
     * @return CNPJ do prestador de serviço
     */
    public String getCNPJ() {
        return cnpj;
    }

    /**
     * @param cnpj do prestador de serviço
     */
    public NFSeSefinNacionalInfoPrestador setCNPJ(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    /**
     * @return CPF do prestador de serviço
     */
    public String getCPF() {
        return cpf;
    }

    /**
     * @param cpf CPF do prestador de serviço
     */
    public NFSeSefinNacionalInfoPrestador setCPF(String cpf) {
        this.cpf = cpf;
        return this;
    }

    /**
     * Número de Identificação Fiscal fornecido por órgão de administração tributária no exterior
     *
     * @return NIF do prestador de serviço
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
     * @return Inscrição Municipal do prestador de serviço
     */
    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    /**
     * @param inscricaoMunicipal Inscrição Municipal do prestador de serviço
     */
    public void setIM(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    /**
     * @return Nome do prestador de serviço
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome Nome do prestador de serviço
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return Endereço do prestador de serviço
     */
    public NFSeSefinNacionalEndereco getEndereco() {
        return endereco;
    }

    /**
     * @param endereco Endereço do prestador de serviço
     */
    public void setEndereco(NFSeSefinNacionalEndereco endereco) {
        this.endereco = endereco;
    }

    /**
     * @return Telefone do prestador de serviço
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone Telefone do prestador de serviço
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return E-mail do prestador de serviço
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email E-mail do prestador de serviço
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return Regime Tributário do prestador de serviço
     */
    public NFSeSefinNacionalRegTrib getRegimeTributario() {
        return regimeTributario;
    }

    /**
     * @param regimeTributario Regime Tributário do prestador de serviço
     */
    public NFSeSefinNacionalInfoPrestador setRegimeTributario(NFSeSefinNacionalRegTrib regimeTributario) {
        this.regimeTributario = regimeTributario;
        return this;
    }
}
