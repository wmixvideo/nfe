package com.fincatto.nfe310.classes.nota;

import java.math.BigDecimal;

import org.joda.time.LocalDate;
import org.simpleframework.xml.Element;

import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.validadores.BigDecimalParser;

public class NFNotaInfoISSQNTotal extends NFBase {
    @Element(name = "vServ", required = false)
    private String valorTotalServicosSobNaoIncidenciaNaoTributadosICMS;

    @Element(name = "vBC", required = false)
    private String baseCalculoISS;

    @Element(name = "vISS", required = false)
    private String valorTotalISS;

    @Element(name = "vPIS", required = false)
    private String valorPISsobreServicos;

    @Element(name = "vCOFINS", required = false)
    private String valorCOFINSsobreServicos;

    @Element(name = "dCompet", required = true)
    private LocalDate dataPrestacaoServico;

    @Element(name = "vDeducao", required = false)
    private String valorDeducao;

    @Element(name = "vOutro", required = false)
    private String valorOutros;

    @Element(name = "vDescIncond", required = false)
    private String valorTotalDescontoIncondicionado;

    @Element(name = "vDescCond", required = false)
    private String valorTotalDescontoCondicionado;

    @Element(name = "vISSRet", required = false)
    private String valorTotalRetencaoISS;

    @Element(name = "cRegTrib", required = false)
    private NFNotaInfoRegimeEspecialTributacao tributacao;

    public void setValorTotalServicosSobNaoIncidenciaNaoTributadosICMS(final BigDecimal valorTotalServicosSobNaoIncidenciaNaoTributadosICMS) {
        this.valorTotalServicosSobNaoIncidenciaNaoTributadosICMS = BigDecimalParser.tamanho15Com2CasasDecimais(valorTotalServicosSobNaoIncidenciaNaoTributadosICMS);
    }

    public void setBaseCalculoISS(final BigDecimal baseCalculoISS) {
        this.baseCalculoISS = BigDecimalParser.tamanho15Com2CasasDecimais(baseCalculoISS);
    }

    public void setValorTotalISS(final BigDecimal valorTotalISS) {
        this.valorTotalISS = BigDecimalParser.tamanho15Com2CasasDecimais(valorTotalISS);
    }

    public void setValorPISsobreServicos(final BigDecimal valorPISsobreServicos) {
        this.valorPISsobreServicos = BigDecimalParser.tamanho15Com2CasasDecimais(valorPISsobreServicos);
    }

    public void setValorCOFINSsobreServicos(final BigDecimal valorCOFINSsobreServicos) {
        this.valorCOFINSsobreServicos = BigDecimalParser.tamanho15Com2CasasDecimais(valorCOFINSsobreServicos);
    }

    public void setDataPrestacaoServico(final LocalDate dataPrestacaoServico) {
        this.dataPrestacaoServico = dataPrestacaoServico;
    }

    public void setValorDeducao(final BigDecimal valorDeducao) {
        this.valorDeducao = BigDecimalParser.tamanho15Com2CasasDecimais(valorDeducao);
    }

    public void setTributacao(final NFNotaInfoRegimeEspecialTributacao tributacao) {
        this.tributacao = tributacao;
    }

    public void setValorOutros(final BigDecimal valorOutros) {
        this.valorOutros = BigDecimalParser.tamanho15Com2CasasDecimais(valorOutros);
    }

    public void setValorTotalDescontoCondicionado(final BigDecimal valorTotalDescontoCondicionado) {
        this.valorTotalDescontoCondicionado = BigDecimalParser.tamanho15Com2CasasDecimais(valorTotalDescontoCondicionado);
    }

    public void setValorTotalDescontoIncondicionado(final BigDecimal valorTotalDescontoIncondicionado) {
        this.valorTotalDescontoIncondicionado = BigDecimalParser.tamanho15Com2CasasDecimais(valorTotalDescontoIncondicionado);
    }

    public void setValorTotalRetencaoISS(final BigDecimal valorTotalRetencaoISS) {
        this.valorTotalRetencaoISS = BigDecimalParser.tamanho15Com2CasasDecimais(valorTotalRetencaoISS);
    }

    public String getValorTotalServicosSobNaoIncidenciaNaoTributadosICMS() {
        return this.valorTotalServicosSobNaoIncidenciaNaoTributadosICMS;
    }

    public String getBaseCalculoISS() {
        return this.baseCalculoISS;
    }

    public String getValorTotalISS() {
        return this.valorTotalISS;
    }

    public String getValorPISsobreServicos() {
        return this.valorPISsobreServicos;
    }

    public String getValorCOFINSsobreServicos() {
        return this.valorCOFINSsobreServicos;
    }

    public LocalDate getDataPrestacaoServico() {
        return this.dataPrestacaoServico;
    }

    public String getValorDeducao() {
        return this.valorDeducao;
    }

    public String getValorOutros() {
        return this.valorOutros;
    }

    public String getValorTotalDescontoIncondicionado() {
        return this.valorTotalDescontoIncondicionado;
    }

    public String getValorTotalDescontoCondicionado() {
        return this.valorTotalDescontoCondicionado;
    }

    public String getValorTotalRetencaoISS() {
        return this.valorTotalRetencaoISS;
    }

    public NFNotaInfoRegimeEspecialTributacao getTributacao() {
        return this.tributacao;
    }
}