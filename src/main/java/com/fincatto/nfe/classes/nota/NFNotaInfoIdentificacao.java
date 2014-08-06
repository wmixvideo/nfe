package com.fincatto.nfe.classes.nota;

import java.util.List;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import com.fincatto.nfe.NFAmbiente;
import com.fincatto.nfe.NFUnidadeFederativa;
import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.classes.NFFinalidade;
import com.fincatto.nfe.classes.NFFormaPagamento;
import com.fincatto.nfe.classes.NFProgramaEmissor;
import com.fincatto.nfe.classes.NFTipo;
import com.fincatto.nfe.classes.NFTipoEmissao;
import com.fincatto.nfe.classes.NFTipoImpressao;
import com.fincatto.nfe.validadores.IntegerValidador;
import com.fincatto.nfe.validadores.StringValidador;

public class NFNotaInfoIdentificacao extends NFBase {

    @Element(name = "cUF", required = true)
    private NFUnidadeFederativa uf;

    @Element(name = "cNF", required = true)
    private String codigoRandomico;

    @Element(name = "natOp", required = true)
    private String naturezaOperacao;

    @Element(name = "indPag", required = true)
    private NFFormaPagamento formaPagamento;

    @Element(name = "mod", required = true)
    private String modelo;

    @Element(name = "serie", required = true)
    private Integer serie;

    @Element(name = "nNF", required = true)
    private Integer numeroNota;

    @Element(name = "dEmi", required = true)
    private LocalDate dataEmissao;

    @Element(name = "dSaiEnt", required = false)
    private LocalDate dataSaida;

    @Element(name = "hSaiEnt", required = false)
    private LocalTime horaSaida;

    @Element(name = "tpNF", required = true)
    private NFTipo tipo;

    @Element(name = "cMunFG", required = true)
    private String codigoMunicipio;

    @ElementList(entry = "NFref", inline = true, required = false)
    private List<NFInfoReferenciada> referenciadas;

    @Element(name = "tpImp", required = true)
    private NFTipoImpressao tipoImpressao;

    @Element(name = "tpEmis", required = true)
    private NFTipoEmissao tipoEmissao;

    @Element(name = "cDV", required = true)
    private Integer digitoVerificador;

    @Element(name = "tpAmb", required = true)
    private NFAmbiente ambiente;

    @Element(name = "finNFe", required = true)
    private NFFinalidade finalidade;

    @Element(name = "procEmi", required = true)
    private NFProgramaEmissor programaEmissor;

    @Element(name = "verProc", required = true)
    private String versaoEmissor;

    @Element(name = "dhCont", required = false)
    private LocalDateTime dataHoraContigencia;

    @Element(name = "xJust", required = false)
    private String justificativaEntradaContingencia;

    public void setUf(final NFUnidadeFederativa uf) {
        this.uf = uf;
    }

    public void setCodigoRandomico(final String codigoRandomico) {
        StringValidador.exatamente8(codigoRandomico);
        this.codigoRandomico = codigoRandomico;
    }

    public void setNaturezaOperacao(final String naturezaOperacao) {
        StringValidador.tamanho60(naturezaOperacao);
        this.naturezaOperacao = naturezaOperacao;
    }

    public void setFormaPagamento(final NFFormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public void setModelo(final String modelo) {
        StringValidador.exatamente2(modelo);
        this.modelo = modelo;
    }

    public void setSerie(final Integer serie) {
        IntegerValidador.tamanho3(serie);
        this.serie = serie;
    }

    public void setNumeroNota(final Integer numeroNota) {
        IntegerValidador.tamanho9(numeroNota);
        this.numeroNota = numeroNota;
    }

    public void setDataEmissao(final LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public void setDataSaida(final LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public void setHoraSaida(final LocalTime horaSaida) {
        this.horaSaida = horaSaida;
    }

    public void setTipo(final NFTipo tipo) {
        this.tipo = tipo;
    }

    public void setCodigoMunicipio(final String codigoMunicipio) {
        StringValidador.exatamente7(codigoMunicipio);
        this.codigoMunicipio = codigoMunicipio;
    }

    public void setReferenciadas(final List<NFInfoReferenciada> referenciadas) {
        this.referenciadas = referenciadas;
    }

    public void setTipoImpressao(final NFTipoImpressao tipoImpressao) {
        this.tipoImpressao = tipoImpressao;
    }

    public void setTipoEmissao(final NFTipoEmissao tipoEmissao) {
        this.tipoEmissao = tipoEmissao;
    }

    public void setDigitoVerificador(final Integer digitoVerificador) {
        IntegerValidador.exatamente1(digitoVerificador);
        this.digitoVerificador = digitoVerificador;
    }

    public void setAmbiente(final NFAmbiente ambiente) {
        this.ambiente = ambiente;
    }

    public void setFinalidade(final NFFinalidade finalidade) {
        this.finalidade = finalidade;
    }

    public void setProgramaEmissor(final NFProgramaEmissor programaEmissor) {
        this.programaEmissor = programaEmissor;
    }

    public void setVersaoEmissor(final String versaoEmissor) {
        StringValidador.tamanho20(versaoEmissor);
        this.versaoEmissor = versaoEmissor;
    }

    public void setDataHoraContigencia(final LocalDateTime dataHoraContigencia) {
        this.dataHoraContigencia = dataHoraContigencia;
    }

    public void setJustificativaEntradaContingencia(final String justificativaEntradaContingencia) {
        StringValidador.tamanho15a256(justificativaEntradaContingencia);
        this.justificativaEntradaContingencia = justificativaEntradaContingencia;
    }
}