package com.fincatto.documentofiscal.cte300.classes.evento.inutilizacao;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.validadores.DFIntegerValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;

@Root(name = "infInut")
public class CTEventoInutilizacaoDados extends DFBase {
    private static final long serialVersionUID = -5481681546706524562L;

    @Attribute(name = "Id", required = true)
    private String identificador;

    @Element(name = "tpAmb", required = true)
    private DFAmbiente ambiente;

    @Element(name = "xServ", required = true)
    private String nomeServico;

    @Element(name = "cUF", required = true)
    private DFUnidadeFederativa uf;

    @Element(name = "ano", required = true)
    private Integer ano;

    @Element(name = "CNPJ", required = true)
    private String cnpj;

    @Element(name = "mod", required = true)
    private String modeloDocumentoFiscal;

    @Element(name = "serie", required = true)
    private String serie;

    @Element(name = "nCTIni", required = true)
    private String numeroCTInicial;

    @Element(name = "nCTFin", required = true)
    private String numeroCTFinal;

    @Element(name = "xJust", required = true)
    private String justificativa;

    public String getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(final String identificador) {
    	DFStringValidador.identificadorCTe(identificador);
        this.identificador = identificador;
    }

    public DFAmbiente getAmbiente() {
        return this.ambiente;
    }

    public void setAmbiente(final DFAmbiente ambiente) {
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

    public DFUnidadeFederativa getUf() {
        return this.uf;
    }

    public void setUf(final DFUnidadeFederativa uf) {
        this.uf = uf;
    }

    public int getAno() {
        return this.ano;
    }

    public void setAno(final Integer ano) {
        DFIntegerValidador.exatamente2(ano, "Ano");
        this.ano = ano;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(final String cnpj) {
    	DFStringValidador.cnpj(cnpj);
        this.cnpj = cnpj;
    }

    public String getModeloDocumentoFiscal() {
        return this.modeloDocumentoFiscal;
    }

    public void setModeloDocumentoFiscal(final String modeloDocumentoFiscal) {
        this.modeloDocumentoFiscal = modeloDocumentoFiscal;
    }

    public String getSerie() {
        return this.serie;
    }

    public void setSerie(final String serie) {
        DFStringValidador.tamanho3N(serie, "Serie");
        this.serie = serie;
    }

    public String getNumeroCTInicial() {
        return this.numeroCTInicial;
    }

    public void setNumeroCTInicial(final String numeroCTInicial) {
    	DFStringValidador.tamanho9N(numeroCTInicial, "Numero CT Inicial");
        this.numeroCTInicial = numeroCTInicial;
    }

    public String getNumeroCTFinal() {
        return this.numeroCTFinal;
    }

    public void setNumeroCTFinal(final String numeroCTFinal) {
    	DFStringValidador.tamanho9N(numeroCTFinal, "Numero CT Final");
        this.numeroCTFinal = numeroCTFinal;
    }

    public String getJustificativa() {
        return this.justificativa;
    }

    public void setJustificativa(final String justificativa) {
    	DFStringValidador.tamanho15a255(justificativa, "Justificativa");
        this.justificativa = justificativa;
    }
}