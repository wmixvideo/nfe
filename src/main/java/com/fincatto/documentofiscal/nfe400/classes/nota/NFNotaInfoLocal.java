package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFPais;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe400.converters.NFStringNullToEmptyConverter;
import com.fincatto.documentofiscal.validadores.StringValidador;
import org.apache.commons.lang3.StringUtils;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.convert.Convert;

public class NFNotaInfoLocal extends DFBase {
    private static final long serialVersionUID = -6618642990785758823L;

    @Element(name = "CNPJ", required = false)
    @Convert(NFStringNullToEmptyConverter.class)
    private String cnpj;

    @Element(name = "CPF", required = false)
    private String cpf;
    
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
    private String nomeMunicipio;
    
    @Element(name = "UF")
    private String uf;
    
    /**
     * Razão Social ou Nome do Expedidor/Recebedor.
     */
    @Element(name = "xNome", required = false)
    private String nome;
    
    @Element(name = "CEP", required = false)
    private String cep;
    
    @Element(name = "cPais", required = false)
    private DFPais codigoPais;
    
    @Element(name = "xPais", required = false)
    private String descricaoPais;
    
    /**
     * Telefone, preencher com Código DDD + número do telefone ,
     * nas operações com exterior é permtido informar o código do país + código da localidade + número do telefone
     */
    @Element(name = "fone", required = false)
    private String telefone;
    
    /**
     * Informar o e-mail do expedidor/Recebedor.
     * O campo pode ser utilizado para informar o e-mail de recepção da NF-e indicada pelo expedidor
     */
    @Element(name = "email", required = false)
    private String email;
    
    @Element(name = "IE", required = false)
    private String inscricaoEstadual;

    public void setCnpj(final String cnpj) {
        if (this.cpf != null) {
            throw new IllegalStateException("Nao pode setar CNPJ por que o CPF foi setado");
        }
    
        if (!StringUtils.isBlank(cnpj)) {
            StringValidador.cnpj(cnpj);
        }

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
    
    public void setNome(final String nome) {
        StringValidador.tamanho2ate60(nome, "Nome do Expedidor/Recebedor");
        this.nome = nome;
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
    
    /**
     * Endereço de email
     */
    public void setEmail(final String email) {
        StringValidador.tamanho60(email, "Endereço de email");
        StringValidador.email(email);
        this.email = email;
    }
    
    public void setInscricaoEstadual(String inscricaoEstadual) {
        StringValidador.inscricaoEstadual(inscricaoEstadual);
        this.inscricaoEstadual = inscricaoEstadual;
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
    
    public String getNome() {
        return this.nome;
    }
    
    public String getCep() {
        return cep;
    }
    
    public DFPais getCodigoPais() {
        return codigoPais;
    }
    
    public String getDescricaoPais() {
        return descricaoPais;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }
}
