package com.fincatto.nfe310.classes.evento.inutilizacao;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import com.fincatto.nfe310.classes.NFAmbiente;
import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.classes.NFUnidadeFederativa;
import com.fincatto.nfe310.validadores.IntegerValidador;
import com.fincatto.nfe310.validadores.StringValidador;

public class NFEventoCancelamentoDados extends NFBase {

    @Attribute(name = "Id", required = true)
    private String identificador;

    @Element(name = "tpAmb", required = true)
    private NFAmbiente ambiente;

    @Element(name = "xServ", required = true)
    private String nomeServico;

    @Element(name = "cUF", required = true)
    private NFUnidadeFederativa uf;

    @Element(name = "ano", required = true)
    private Integer ano;

    @Element(name = "CNPJ", required = true)
    private String cnpj;

    @Element(name = "mod", required = true)
    private String modeloDocumentoFiscal;

    @Element(name = "serie", required = true)
    private String serie;

    @Element(name = "nNFIni", required = true)
    private String numeroNFInicial;

    @Element(name = "nNFFin", required = true)
    private String numeroNFFinal;

    @Element(name = "xJust", required = true)
    private String justificativa;

    public String getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(final String identificador) {
        StringValidador.identificador(identificador);
        this.identificador = identificador;
    }

    public NFAmbiente getAmbiente() {
        return this.ambiente;
    }

    public void setAmbiente(final NFAmbiente ambiente) {
        this.ambiente = ambiente;
    }

    public String getNomeServico() {
        return this.nomeServico;
    }

    public void setNomeServico(final String nomeServico) {
        if (!nomeServico.equals("INUTILIZAR")) {
            throw new IllegalStateException("Nome de servico invalido");
        }
        this.nomeServico = nomeServico;
    }

    public NFUnidadeFederativa getUf() {
        return this.uf;
    }

    public void setUf(final NFUnidadeFederativa uf) {
        this.uf = uf;
    }

    public int getAno() {
        return this.ano;
    }

    public void setAno(final Integer ano) {
        IntegerValidador.exatamente2(ano);
        this.ano = ano;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(final String cnpj) {
        StringValidador.cnpj(cnpj);
        this.cnpj = cnpj;
    }

    public String getModeloDocumentoFiscal() {
        return this.modeloDocumentoFiscal;
    }

    public void setModeloDocumentoFiscal(final String modeloDocumentoFiscal) {
        StringValidador.modeloDocumentoFiscal(modeloDocumentoFiscal);
        this.modeloDocumentoFiscal = modeloDocumentoFiscal;
    }

    public String getSerie() {
        return this.serie;
    }

    public void setSerie(final String serie) {
        StringValidador.tamanho3N(serie);
        this.serie = serie;
    }

    public String getNumeroNFInicial() {
        return this.numeroNFInicial;
    }

    public void setNumeroNFInicial(final String numeroNFInicial) {
        StringValidador.tamanho9N(numeroNFInicial);
        this.numeroNFInicial = numeroNFInicial;
    }

    public String getNumeroNFFinal() {
        return this.numeroNFFinal;
    }

    public void setNumeroNFFinal(final String numeroNFFinal) {
        StringValidador.tamanho9N(numeroNFFinal);
        this.numeroNFFinal = numeroNFFinal;
    }

    public String getJustificativa() {
        return this.justificativa;
    }

    public void setJustificativa(final String justificativa) {
        StringValidador.tamanho15a255(justificativa);
        this.justificativa = justificativa;
    }
}