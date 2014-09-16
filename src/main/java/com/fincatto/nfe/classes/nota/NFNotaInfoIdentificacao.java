package com.fincatto.nfe.classes.nota;

import java.util.List;

import org.joda.time.LocalDateTime;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import com.fincatto.nfe.classes.NFAmbiente;
import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.classes.NFFinalidade;
import com.fincatto.nfe.classes.NFFormaPagamentoPrazo;
import com.fincatto.nfe.classes.NFProcessoEmissor;
import com.fincatto.nfe.classes.NFTipo;
import com.fincatto.nfe.classes.NFTipoEmissao;
import com.fincatto.nfe.classes.NFTipoImpressao;
import com.fincatto.nfe.classes.NFUnidadeFederativa;
import com.fincatto.nfe.validadores.IntegerValidador;
import com.fincatto.nfe.validadores.ListValidador;
import com.fincatto.nfe.validadores.StringValidador;

public class NFNotaInfoIdentificacao extends NFBase {

    @Element(name = "cUF", required = true)
    private NFUnidadeFederativa uf;

    @Element(name = "cNF", required = true)
    private String codigoRandomico;

    @Element(name = "natOp", required = true)
    private String naturezaOperacao;

    @Element(name = "indPag", required = true)
    private NFFormaPagamentoPrazo formaPagamento;

    @Element(name = "mod", required = true)
    private String modelo;

    @Element(name = "serie", required = true)
    private String serie;

    @Element(name = "nNF", required = true)
    private String numeroNota;

    @Element(name = "dhEmi", required = true)
    private LocalDateTime dataHoraEmissao;

    @Element(name = "dhSaiEnt", required = false)
    private LocalDateTime dataHoraSaidaEntrada;

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
    private NFAmbiente ambiente;

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
    private LocalDateTime dataHoraContigencia;

    @Element(name = "xJust", required = false)
    private String justificativaEntradaContingencia;

    @ElementList(entry = "NFref", inline = true, required = false)
    private List<NFInfoReferenciada> referenciadas;

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

    public void setFormaPagamento(final NFFormaPagamentoPrazo formaPagamento) {
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

    public void setDataHoraEmissao(final LocalDateTime dataEmissao) {
        this.dataHoraEmissao = dataEmissao;
    }

    public void setDataHoraSaidaEntrada(final LocalDateTime dataHoraSaidaEntrada) {
        this.dataHoraSaidaEntrada = dataHoraSaidaEntrada;
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

    public void setIdentificadorLocalDestinoOperacao(final NFIdentificadorLocalDestinoOperacao identificadorLocalDestinoOperacao) {
        this.identificadorLocalDestinoOperacao = identificadorLocalDestinoOperacao;
    }

    public void setOperacaoConsumidorFinal(final NFOperacaoConsumidorFinal operacaoConsumidorFinal) {
        this.operacaoConsumidorFinal = operacaoConsumidorFinal;
    }

    public void setIndicadorPresencaComprador(final NFIndicadorPresencaComprador indicadorPresencaComprador) {
        this.indicadorPresencaComprador = indicadorPresencaComprador;
    }
}