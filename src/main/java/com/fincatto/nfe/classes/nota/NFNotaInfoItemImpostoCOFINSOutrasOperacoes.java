package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;

public class NFNotaInfoItemImpostoCOFINSOutrasOperacoes extends NFBase {

    @Element(name = "CST", required = true)
    private NFNotaInfoSituacaoTributariaCOFINS situacaoTributaria;

    @Element(name = "vBC", required = false)
    private BigDecimal valorBaseCalculo;

    @Element(name = "pCOFINS", required = false)
    private BigDecimal aliquota;

    @Element(name = "qBCProd", required = false)
    private BigDecimal quantidadeVendida;

    @Element(name = "vAliqProd", required = false)
    private BigDecimal valorAliquota;

    @Element(name = "vCOFINS", required = true)
    private BigDecimal valorTributo;

    public NFNotaInfoItemImpostoCOFINSOutrasOperacoes() {
        this.situacaoTributaria = null;
        this.valorBaseCalculo = null;
        this.aliquota = null;
        this.quantidadeVendida = null;
        this.valorAliquota = null;
        this.valorTributo = null;
    }

    public NFNotaInfoSituacaoTributariaCOFINS getSituacaoTributaria() {
        return this.situacaoTributaria;
    }

    public void setSituacaoTributaria(final NFNotaInfoSituacaoTributariaCOFINS situacaoTributaria) {
        this.situacaoTributaria = situacaoTributaria;
    }

    public BigDecimal getValorBaseCalculo() {
        return this.valorBaseCalculo;
    }

    public void setValorBaseCalculo(final BigDecimal valorBaseCalculo) {
        this.valorBaseCalculo = valorBaseCalculo;
    }

    public BigDecimal getAliquota() {
        return this.aliquota;
    }

    public void setAliquota(final BigDecimal aliquota) {
        this.aliquota = aliquota;
    }

    public BigDecimal getQuantidadeVendida() {
        return this.quantidadeVendida;
    }

    public void setQuantidadeVendida(final BigDecimal quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

    public BigDecimal getValorAliquota() {
        return this.valorAliquota;
    }

    public void setValorAliquota(final BigDecimal valorAliquota) {
        this.valorAliquota = valorAliquota;
    }

    public BigDecimal getValorTributo() {
        return this.valorTributo;
    }

    public void setValorTributo(final BigDecimal valorTributo) {
        this.valorTributo = valorTributo;
    }
}