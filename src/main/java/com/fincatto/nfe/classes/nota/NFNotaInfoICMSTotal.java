package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.validadores.BigDecimalParser;

public class NFNotaInfoICMSTotal extends NFBase {

    @Element(name = "vBC", required = true)
    private String baseCalculoICMS;

    @Element(name = "vICMS", required = true)
    private String valorTotalICMS;

    @Element(name = "vBCST", required = true)
    private String valor;

    @Element(name = "vST", required = true)
    private String valorTotalICMSST;

    @Element(name = "vProd", required = true)
    private String valorTotalDosProdutosServicos;

    @Element(name = "vFrete", required = true)
    private String valorTotalFrete;

    @Element(name = "vSeg", required = true)
    private String valorTotalSeguro;

    @Element(name = "vDesc", required = true)
    private String valorTotalDesconto;

    @Element(name = "vII", required = true)
    private String valorTotalII;

    @Element(name = "vIPI", required = true)
    private String valorTotalIPI;

    @Element(name = "vPIS", required = true)
    private String valorPIS;

    @Element(name = "vCOFINS", required = true)
    private String valorCOFINS;

    @Element(name = "vOutro", required = true)
    private String outrasDespesasAcessorias;

    @Element(name = "vNF", required = true)
    private String valorTotalNFe;

    public BigDecimal getBaseCalculoICMS() {
        return new BigDecimal(this.baseCalculoICMS);
    }

    public void setBaseCalculoICMS(final BigDecimal baseCalculoICMS) {
        this.baseCalculoICMS = BigDecimalParser.tamanho15Com2CasasDecimais(baseCalculoICMS);
    }

    public BigDecimal getValorTotalICMS() {
        return new BigDecimal(this.valorTotalICMS);
    }

    public void setValorTotalICMS(final BigDecimal valorTotalICMS) {
        this.valorTotalICMS = BigDecimalParser.tamanho15Com2CasasDecimais(valorTotalICMS);
    }

    public BigDecimal getValor() {
        return new BigDecimal(this.valor);
    }

    public void setValor(final BigDecimal valor) {
        this.valor = BigDecimalParser.tamanho15Com2CasasDecimais(valor);
    }

    public BigDecimal getValorTotalICMSST() {
        return new BigDecimal(this.valorTotalICMSST);
    }

    public void setValorTotalICMSST(final BigDecimal valorTotalICMSST) {
        this.valorTotalICMSST = BigDecimalParser.tamanho15Com2CasasDecimais(valorTotalICMSST);
    }

    public BigDecimal getValorTotalDosProdutosServicos() {
        return new BigDecimal(this.valorTotalDosProdutosServicos);
    }

    public void setValorTotalDosProdutosServicos(final BigDecimal valorTotalDosProdutosServicos) {
        this.valorTotalDosProdutosServicos = BigDecimalParser.tamanho15Com2CasasDecimais(valorTotalDosProdutosServicos);
    }

    public BigDecimal getValorTotalFrete() {
        return new BigDecimal(this.valorTotalFrete);
    }

    public void setValorTotalFrete(final BigDecimal valorTotalFrete) {
        this.valorTotalFrete = BigDecimalParser.tamanho15Com2CasasDecimais(valorTotalFrete);
    }

    public BigDecimal getValorTotalSeguro() {
        return new BigDecimal(this.valorTotalSeguro);
    }

    public void setValorTotalSeguro(final BigDecimal valorTotalSeguro) {
        this.valorTotalSeguro = BigDecimalParser.tamanho15Com2CasasDecimais(valorTotalSeguro);
    }

    public BigDecimal getValorTotalDesconto() {
        return new BigDecimal(this.valorTotalDesconto);
    }

    public void setValorTotalDesconto(final BigDecimal valorTotalDesconto) {
        this.valorTotalDesconto = BigDecimalParser.tamanho15Com2CasasDecimais(valorTotalDesconto);
    }

    public BigDecimal getValorTotalII() {
        return new BigDecimal(this.valorTotalII);
    }

    public void setValorTotalII(final BigDecimal valorTotalII) {
        this.valorTotalII = BigDecimalParser.tamanho15Com2CasasDecimais(valorTotalII);
    }

    public BigDecimal getValorTotalIPI() {
        return new BigDecimal(this.valorTotalIPI);
    }

    public void setValorTotalIPI(final BigDecimal valorTotalIPI) {
        this.valorTotalIPI = BigDecimalParser.tamanho15Com2CasasDecimais(valorTotalIPI);
    }

    public BigDecimal getValorPIS() {
        return new BigDecimal(this.valorPIS);
    }

    public void setValorPIS(final BigDecimal valorPIS) {
        this.valorPIS = BigDecimalParser.tamanho15Com2CasasDecimais(valorPIS);
    }

    public BigDecimal getValorCOFINS() {
        return new BigDecimal(this.valorCOFINS);
    }

    public void setValorCOFINS(final BigDecimal valorCOFINS) {
        this.valorCOFINS = BigDecimalParser.tamanho15Com2CasasDecimais(valorCOFINS);
    }

    public BigDecimal getOutrasDespesasAcessorias() {
        return new BigDecimal(this.outrasDespesasAcessorias);
    }

    public void setOutrasDespesasAcessorias(final BigDecimal outrasDespesasAcessorias) {
        this.outrasDespesasAcessorias = BigDecimalParser.tamanho15Com2CasasDecimais(outrasDespesasAcessorias);
    }

    public BigDecimal getValorTotalNFe() {
        return new BigDecimal(this.valorTotalNFe);
    }

    public void setValorTotalNFe(final BigDecimal valorTotalNFe) {
        this.valorTotalNFe = BigDecimalParser.tamanho15Com2CasasDecimais(valorTotalNFe);
    }
}