package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFTipoEmissao;
import com.fincatto.documentofiscal.nfe310.classes.NFFinalidade;
import com.fincatto.documentofiscal.nfe310.classes.NFFormaPagamentoPrazo;
import com.fincatto.documentofiscal.nfe310.classes.NFProcessoEmissor;
import com.fincatto.documentofiscal.nfe310.classes.NFTipo;
import com.fincatto.documentofiscal.nfe310.classes.NFTipoImpressao;
import com.fincatto.documentofiscal.validadores.IntegerValidador;
import com.fincatto.documentofiscal.validadores.ListValidador;
import com.fincatto.documentofiscal.validadores.StringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.time.ZonedDateTime;
import java.util.List;

public class NFNotaInfoIdentificacao extends DFBase {
    private static final long serialVersionUID = -2568396066960865875L;

    @Element(name = "cUF", required = true)
    private DFUnidadeFederativa uf;

    @Element(name = "cNF", required = true)
    private String codigoRandomico;

    @Element(name = "natOp", required = true)
    private String naturezaOperacao;

    @Element(name = "indPag", required = true)
    private NFFormaPagamentoPrazo formaPagamento;

    @Element(name = "mod", required = true)
    private DFModelo modelo;

    @Element(name = "serie", required = true)
    private String serie;

    @Element(name = "nNF", required = true)
    private String numeroNota;

    @Element(name = "dhEmi", required = true)
    private ZonedDateTime dataHoraEmissao;

    @Element(name = "dhSaiEnt", required = false)
    private ZonedDateTime dataHoraSaidaOuEntrada;

    @Element(name = "tpNF", required = true)
    private NFTipo tipo;

    @Element(name = "idDest", required = true)
    private NFIdentificadorLocalDestinoOperacao identificadorLocalDestinoOperacao;

    @Element(name = "cMunFG", required = true)
    private String codigoMunicipio;

    @Element(name = "tpImp", required = true)
    private NFTipoImpressao tipoImpressao;

    @Element(name = "tpEmis", required = true)
    private NFTipoEmissao tipoEmissao;

    @Element(name = "cDV", required = true)
    private Integer digitoVerificador;

    @Element(name = "tpAmb", required = true)
    private DFAmbiente ambiente;

    @Element(name = "finNFe", required = true)
    private NFFinalidade finalidade;

    @Element(name = "indFinal", required = true)
    private NFOperacaoConsumidorFinal operacaoConsumidorFinal;

    @Element(name = "indPres", required = true)
    private NFIndicadorPresencaComprador indicadorPresencaComprador;

    @Element(name = "procEmi", required = true)
    private NFProcessoEmissor programaEmissor;

    @Element(name = "verProc", required = true)
    private String versaoEmissor;

    @Element(name = "dhCont", required = false)
    private ZonedDateTime dataHoraContigencia;

    @Element(name = "xJust", required = false)
    private String justificativaEntradaContingencia;

    @ElementList(entry = "NFref", inline = true, required = false)
    private List<NFInfoReferenciada> referenciadas;

    public void setUf(final DFUnidadeFederativa uf) {
        this.uf = uf;
    }

    public void setCodigoRandomico(final String codigoRandomico) {
        StringValidador.exatamente8(codigoRandomico, "Codigo Randomico");
        this.codigoRandomico = codigoRandomico;
    }

    public void setNaturezaOperacao(final String naturezaOperacao) {
        StringValidador.tamanho60(naturezaOperacao, "Natureza da Operacao");
        this.naturezaOperacao = naturezaOperacao;
    }

    public void setFormaPagamento(final NFFormaPagamentoPrazo formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public void setModelo(final DFModelo modelo) {
        this.modelo = modelo;
    }

    public void setSerie(final String serie) {
        StringValidador.tamanho3(serie, "Serie");
        this.serie = serie;
    }

    public void setNumeroNota(final String numeroNota) {
        StringValidador.tamanho9(numeroNota, "Numero da Nota");
        this.numeroNota = numeroNota;
    }

    public void setDataHoraEmissao(final ZonedDateTime dataEmissao) {
        this.dataHoraEmissao = dataEmissao;
    }

    public void setDataHoraSaidaOuEntrada(final ZonedDateTime dataHoraSaidaOuEntrada) {
        this.dataHoraSaidaOuEntrada = dataHoraSaidaOuEntrada;
    }

    public void setTipo(final NFTipo tipo) {
        this.tipo = tipo;
    }

    public void setCodigoMunicipio(final String codigoMunicipio) {
        StringValidador.exatamente7N(codigoMunicipio, "Codigo Municipio");
        this.codigoMunicipio = codigoMunicipio;
    }

    public void setReferenciadas(final List<NFInfoReferenciada> referenciadas) {
        ListValidador.tamanho500(referenciadas, "Referenciadas");
        this.referenciadas = referenciadas;
    }

    public void setTipoImpressao(final NFTipoImpressao tipoImpressao) {
        this.tipoImpressao = tipoImpressao;
    }

    public void setTipoEmissao(final NFTipoEmissao tipoEmissao) {
        this.tipoEmissao = tipoEmissao;
    }

    public void setDigitoVerificador(final Integer digitoVerificador) {
        IntegerValidador.exatamente1(digitoVerificador, "DV");
        this.digitoVerificador = digitoVerificador;
    }

    public void setAmbiente(final DFAmbiente ambiente) {
        this.ambiente = ambiente;
    }

    public void setFinalidade(final NFFinalidade finalidade) {
        this.finalidade = finalidade;
    }

    public void setProgramaEmissor(final NFProcessoEmissor programaEmissor) {
        this.programaEmissor = programaEmissor;
    }

    public void setVersaoEmissor(final String versaoEmissor) {
        StringValidador.tamanho20(versaoEmissor, "Versao Emissor");
        this.versaoEmissor = versaoEmissor;
    }

    public void setDataHoraContigencia(final ZonedDateTime dataHoraContigencia) {
        this.dataHoraContigencia = dataHoraContigencia;
    }

    public void setJustificativaEntradaContingencia(final String justificativaEntradaContingencia) {
        StringValidador.tamanho15a256(justificativaEntradaContingencia, "Justificativa Entrada Contingencia");
        this.justificativaEntradaContingencia = justificativaEntradaContingencia;
    }

    public void setIdentificadorLocalDestinoOperacao(final NFIdentificadorLocalDestinoOperacao identificadorLocalDestinoOperacao) {
        this.identificadorLocalDestinoOperacao = identificadorLocalDestinoOperacao;
    }

    public void setOperacaoConsumidorFinal(final NFOperacaoConsumidorFinal operacaoConsumidorFinal) {
        this.operacaoConsumidorFinal = operacaoConsumidorFinal;
    }

    public void setIndicadorPresencaComprador(final NFIndicadorPresencaComprador indicadorPresencaComprador) {
        this.indicadorPresencaComprador = indicadorPresencaComprador;
    }

    public DFUnidadeFederativa getUf() {
        return this.uf;
    }

    public String getCodigoRandomico() {
        return this.codigoRandomico;
    }

    public String getNaturezaOperacao() {
        return this.naturezaOperacao;
    }

    public NFFormaPagamentoPrazo getFormaPagamento() {
        return this.formaPagamento;
    }

    public DFModelo getModelo() {
        return this.modelo;
    }

    public String getSerie() {
        return this.serie;
    }

    public String getNumeroNota() {
        return this.numeroNota;
    }

    public ZonedDateTime getDataHoraEmissao() {
        return this.dataHoraEmissao;
    }

    public ZonedDateTime getDataHoraSaidaOuEntrada() {
        return this.dataHoraSaidaOuEntrada;
    }

    public NFTipo getTipo() {
        return this.tipo;
    }

    public NFIdentificadorLocalDestinoOperacao getIdentificadorLocalDestinoOperacao() {
        return this.identificadorLocalDestinoOperacao;
    }

    public String getCodigoMunicipio() {
        return this.codigoMunicipio;
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

    public DFAmbiente getAmbiente() {
        return this.ambiente;
    }

    public NFFinalidade getFinalidade() {
        return this.finalidade;
    }

    public NFOperacaoConsumidorFinal getOperacaoConsumidorFinal() {
        return this.operacaoConsumidorFinal;
    }

    public NFIndicadorPresencaComprador getIndicadorPresencaComprador() {
        return this.indicadorPresencaComprador;
    }

    public NFProcessoEmissor getProgramaEmissor() {
        return this.programaEmissor;
    }

    public String getVersaoEmissor() {
        return this.versaoEmissor;
    }

    public ZonedDateTime getDataHoraContigencia() {
        return this.dataHoraContigencia;
    }

    public String getJustificativaEntradaContingencia() {
        return this.justificativaEntradaContingencia;
    }

    public List<NFInfoReferenciada> getReferenciadas() {
        return this.referenciadas;
    }
}