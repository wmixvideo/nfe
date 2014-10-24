package com.fincatto.nfe200.classes.nota;

import java.util.List;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import com.fincatto.nfe200.classes.NFAmbiente;
import com.fincatto.nfe200.classes.NFBase;
import com.fincatto.nfe200.classes.NFFinalidade;
import com.fincatto.nfe200.classes.NFFormaPagamento;
import com.fincatto.nfe200.classes.NFProcessoEmissor;
import com.fincatto.nfe200.classes.NFTipo;
import com.fincatto.nfe200.classes.NFTipoEmissao;
import com.fincatto.nfe200.classes.NFTipoImpressao;
import com.fincatto.nfe200.classes.NFUnidadeFederativa;
import com.fincatto.nfe200.validadores.IntegerValidador;
import com.fincatto.nfe200.validadores.ListValidador;
import com.fincatto.nfe200.validadores.StringValidador;

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
    private String serie;

    @Element(name = "nNF", required = true)
    private String numeroNota;

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
    private NFProcessoEmissor programaEmissor;

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

    public void setSerie(final String serie) {
        StringValidador.tamanho3(serie);
        this.serie = serie;
    }

    public void setNumeroNota(final String numeroNota) {
        StringValidador.tamanho9(numeroNota);
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
        StringValidador.exatamente7N(codigoMunicipio);
        this.codigoMunicipio = codigoMunicipio;
    }

    public void setReferenciadas(final List<NFInfoReferenciada> referenciadas) {
        ListValidador.tamanho500(referenciadas);
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

    public void setProgramaEmissor(final NFProcessoEmissor programaEmissor) {
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

    public NFUnidadeFederativa getUf() {
        return this.uf;
    }

    public String getCodigoRandomico() {
        return this.codigoRandomico;
    }

    public String getNaturezaOperacao() {
        return this.naturezaOperacao;
    }

    public NFFormaPagamento getFormaPagamento() {
        return this.formaPagamento;
    }

    public String getModelo() {
        return this.modelo;
    }

    public String getSerie() {
        return this.serie;
    }

    public String getNumeroNota() {
        return this.numeroNota;
    }

    public LocalDate getDataEmissao() {
        return this.dataEmissao;
    }

    public LocalDate getDataSaida() {
        return this.dataSaida;
    }

    public LocalTime getHoraSaida() {
        return this.horaSaida;
    }

    public NFTipo getTipo() {
        return this.tipo;
    }

    public String getCodigoMunicipio() {
        return this.codigoMunicipio;
    }

    public List<NFInfoReferenciada> getReferenciadas() {
        return this.referenciadas;
    }

    public NFTipoImpressao getTipoImpressao() {
        return this.tipoImpressao;
    }

    public NFTipoEmissao getTipoEmissao() {
        return this.tipoEmissao;
    }

    public Integer getDigitoVerificador() {
        return this.digitoVerificador;
    }

    public NFAmbiente getAmbiente() {
        return this.ambiente;
    }

    public NFFinalidade getFinalidade() {
        return this.finalidade;
    }

    public NFProcessoEmissor getProgramaEmissor() {
        return this.programaEmissor;
    }

    public String getVersaoEmissor() {
        return this.versaoEmissor;
    }

    public LocalDateTime getDataHoraContigencia() {
        return this.dataHoraContigencia;
    }

    public String getJustificativaEntradaContingencia() {
        return this.justificativaEntradaContingencia;
    }
}