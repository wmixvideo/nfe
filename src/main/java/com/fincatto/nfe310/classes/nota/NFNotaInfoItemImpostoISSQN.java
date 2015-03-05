package com.fincatto.nfe310.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.validadores.BigDecimalParser;
import com.fincatto.nfe310.validadores.IntegerValidador;
import com.fincatto.nfe310.validadores.StringValidador;

public class NFNotaInfoItemImpostoISSQN extends NFBase {

    @Element(name = "vBC", required = true)
    private String valorBaseCalculo;

    @Element(name = "vAliq", required = true)
    private String valorAliquota;

    @Element(name = "vISSQN", required = true)
    private String valor;

    @Element(name = "cMunFG", required = true)
    private Integer codigoMunicipio;

    @Element(name = "cListServ", required = true)
    private String itemListaServicos;

    @Element(name = "vDeducao", required = false)
    private String valorDeducao;

    @Element(name = "vOutro", required = false)
    private String valorOutro;

    @Element(name = "vDescIncond", required = false)
    private String valorDescontoIncondicionado;

    @Element(name = "vDescCond", required = false)
    private String valorDescontoCondicionado;

    @Element(name = "vISSRet", required = false)
    private String valorRetencaoISS;

    @Element(name = "indISS", required = true)
    private NFNotaInfoItemIndicadorExigibilidadeISS indicadorExigibilidadeISS;

    @Element(name = "cServico", required = false)
    private String codigoServico;

    @Element(name = "cMun", required = false)
    private String codigoMunicipioIncidenciaImposto;

    @Element(name = "cPais", required = false)
    private String codigoPais;

    @Element(name = "nProcesso", required = false)
    private String numeroProcesso;

    @Element(name = "indIncentivo", required = true)
    private NFNotaInfoItemIndicadorIncentivoFiscal indicadorIncentivoFiscal;

    public void setValorBaseCalculo(final BigDecimal valorBaseCalculo) {
        this.valorBaseCalculo = BigDecimalParser.tamanho15Com2CasasDecimais(valorBaseCalculo);
    }

    public void setValorAliquota(final BigDecimal valorAliquota) {
        this.valorAliquota = BigDecimalParser.tamanho7ComAte4CasasDecimais(valorAliquota);
    }

    public void setValor(final BigDecimal valor) {
        this.valor = BigDecimalParser.tamanho15Com2CasasDecimais(valor);
    }

    public void setCodigoMunicipio(final Integer codigoMunicipio) {
        IntegerValidador.exatamente7(codigoMunicipio);
        this.codigoMunicipio = codigoMunicipio;
    }

    public void setItemListaServicos(final String itemListaServicos) {
        StringValidador.itemListaServico(itemListaServicos);
        this.itemListaServicos = itemListaServicos;
    }

    public void setCodigoMunicipioIncidenciaImposto(final String codigoMunicipioIncidenciaImposto) {
        StringValidador.exatamente7N(codigoMunicipioIncidenciaImposto);
        this.codigoMunicipioIncidenciaImposto = codigoMunicipioIncidenciaImposto;
    }

    public void setCodigoPais(final String codigoPais) {
        StringValidador.exatamente4N(codigoPais);
        this.codigoPais = codigoPais;
    }

    public void setCodigoServico(final String codigoServico) {
        StringValidador.tamanho20(codigoServico);
        this.codigoServico = codigoServico;
    }

    public void setIndicadorExigibilidadeISS(final NFNotaInfoItemIndicadorExigibilidadeISS indicadorExigibilidadeISS) {
        this.indicadorExigibilidadeISS = indicadorExigibilidadeISS;
    }

    public void setIndicadorIncentivoFiscal(final NFNotaInfoItemIndicadorIncentivoFiscal indicadorIncentivoFiscal) {
        this.indicadorIncentivoFiscal = indicadorIncentivoFiscal;
    }

    public void setNumeroProcesso(final String numeroProcesso) {
        StringValidador.tamanho30(numeroProcesso);
        this.numeroProcesso = numeroProcesso;
    }

    public void setValorDeducao(final BigDecimal valorDeducao) {
        this.valorDeducao = BigDecimalParser.tamanho15Com2CasasDecimais(valorDeducao);
    }

    public void setValorDescontoCondicionado(final BigDecimal valorDescontoCondicionado) {
        this.valorDescontoCondicionado = BigDecimalParser.tamanho15Com2CasasDecimais(valorDescontoCondicionado);
    }

    public void setValorDescontoIncondicionado(final BigDecimal valorDescontoIncondicionado) {
        this.valorDescontoIncondicionado = BigDecimalParser.tamanho15Com2CasasDecimais(valorDescontoIncondicionado);
    }

    public void setValorOutro(final BigDecimal valorOutro) {
        this.valorOutro = BigDecimalParser.tamanho15Com2CasasDecimais(valorOutro);
    }

    public void setValorRetencaoISS(final BigDecimal valorRetencaoISS) {
        this.valorRetencaoISS = BigDecimalParser.tamanho15Com2CasasDecimais(valorRetencaoISS);
    }

    public String getValorBaseCalculo() {
        return this.valorBaseCalculo;
    }

    public String getValorAliquota() {
        return this.valorAliquota;
    }

    public String getValor() {
        return this.valor;
    }

    public Integer getCodigoMunicipio() {
        return this.codigoMunicipio;
    }

    public String getItemListaServicos() {
        return this.itemListaServicos;
    }

    public String getValorDeducao() {
        return this.valorDeducao;
    }

    public String getValorOutro() {
        return this.valorOutro;
    }

    public String getValorDescontoIncondicionado() {
        return this.valorDescontoIncondicionado;
    }

    public String getValorDescontoCondicionado() {
        return this.valorDescontoCondicionado;
    }

    public String getValorRetencaoISS() {
        return this.valorRetencaoISS;
    }

    public NFNotaInfoItemIndicadorExigibilidadeISS getIndicadorExigibilidadeISS() {
        return this.indicadorExigibilidadeISS;
    }

    public String getCodigoServico() {
        return this.codigoServico;
    }

    public String getCodigoMunicipioIncidenciaImposto() {
        return this.codigoMunicipioIncidenciaImposto;
    }

    public String getCodigoPais() {
        return this.codigoPais;
    }

    public String getNumeroProcesso() {
        return this.numeroProcesso;
    }

    public NFNotaInfoItemIndicadorIncentivoFiscal getIndicadorIncentivoFiscal() {
        return this.indicadorIncentivoFiscal;
    }
}