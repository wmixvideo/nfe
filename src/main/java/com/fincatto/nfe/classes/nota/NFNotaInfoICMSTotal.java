package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;

public class NFNotaInfoICMSTotal extends NFBase {

    @Element(name = "vBC", required = true)
    private BigDecimal baseCalculoICMS;

    @Element(name = "vICMS", required = true)
    private BigDecimal valorTotalICMS;

    @Element(name = "vBCST", required = true)
    private BigDecimal valor;

    @Element(name = "vST", required = true)
    private BigDecimal valorTotalICMSST;

    @Element(name = "vProd", required = true)
    private BigDecimal valorTotalDosProdutosServicos;

    @Element(name = "vFrete", required = true)
    private BigDecimal valorTotalFrete;

    @Element(name = "vSeg", required = true)
    private BigDecimal valorTotalSeguro;

    @Element(name = "vDesc", required = true)
    private BigDecimal valorTotalDesconto;

    @Element(name = "vII", required = true)
    private BigDecimal valorTotalII;

    @Element(name = "vIPI", required = true)
    private BigDecimal valorTotalIPI;

    @Element(name = "vPIS", required = true)
    private BigDecimal valorPIS;

    @Element(name = "vCOFINS", required = true)
    private BigDecimal valorCOFINS;

    @Element(name = "vOutro", required = true)
    private BigDecimal outrasDespesasAcessorias;

    @Element(name = "vNF", required = true)
    private BigDecimal valorTotalNFe;

    public BigDecimal getBaseCalculoICMS() {
        return this.baseCalculoICMS;
    }

    public void setBaseCalculoICMS(final BigDecimal baseCalculoICMS) {
        this.baseCalculoICMS = baseCalculoICMS;
    }

    public BigDecimal getValorTotalICMS() {
        return this.valorTotalICMS;
    }

    public void setValorTotalICMS(final BigDecimal valorTotalICMS) {
        this.valorTotalICMS = valorTotalICMS;
    }

    public BigDecimal getValor() {
        return this.valor;
    }

    public void setValor(final BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValorTotalICMSST() {
        return this.valorTotalICMSST;
    }

    public void setValorTotalICMSST(final BigDecimal valorTotalICMSST) {
        this.valorTotalICMSST = valorTotalICMSST;
    }

    public BigDecimal getValorTotalDosProdutosServicos() {
        return this.valorTotalDosProdutosServicos;
    }

    public void setValorTotalDosProdutosServicos(final BigDecimal valorTotalDosProdutosServicos) {
        this.valorTotalDosProdutosServicos = valorTotalDosProdutosServicos;
    }

    public BigDecimal getValorTotalFrete() {
        return this.valorTotalFrete;
    }

    public void setValorTotalFrete(final BigDecimal valorTotalFrete) {
        this.valorTotalFrete = valorTotalFrete;
    }

    public BigDecimal getValorTotalSeguro() {
        return this.valorTotalSeguro;
    }

    public void setValorTotalSeguro(final BigDecimal valorTotalSeguro) {
        this.valorTotalSeguro = valorTotalSeguro;
    }

    public BigDecimal getValorTotalDesconto() {
        return this.valorTotalDesconto;
    }

    public void setValorTotalDesconto(final BigDecimal valorTotalDesconto) {
        this.valorTotalDesconto = valorTotalDesconto;
    }

    public BigDecimal getValorTotalII() {
        return this.valorTotalII;
    }

    public void setValorTotalII(final BigDecimal valorTotalII) {
        this.valorTotalII = valorTotalII;
    }

    public BigDecimal getValorTotalIPI() {
        return this.valorTotalIPI;
    }

    public void setValorTotalIPI(final BigDecimal valorTotalIPI) {
        this.valorTotalIPI = valorTotalIPI;
    }

    public BigDecimal getValorPIS() {
        return this.valorPIS;
    }

    public void setValorPIS(final BigDecimal valorPIS) {
        this.valorPIS = valorPIS;
    }

    public BigDecimal getValorCOFINS() {
        return this.valorCOFINS;
    }

    public void setValorCOFINS(final BigDecimal valorCOFINS) {
        this.valorCOFINS = valorCOFINS;
    }

    public BigDecimal getOutrasDespesasAcessorias() {
        return this.outrasDespesasAcessorias;
    }

    public void setOutrasDespesasAcessorias(final BigDecimal outrasDespesasAcessorias) {
        this.outrasDespesasAcessorias = outrasDespesasAcessorias;
    }

    public BigDecimal getValorTotalNFe() {
        return this.valorTotalNFe;
    }

    public void setValorTotalNFe(final BigDecimal valorTotalNFe) {
        this.valorTotalNFe = valorTotalNFe;
    }
}