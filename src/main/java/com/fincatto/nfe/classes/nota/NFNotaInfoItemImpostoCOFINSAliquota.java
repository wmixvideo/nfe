package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;

public class NFNotaInfoItemImpostoCOFINSAliquota extends NFBase {

    @Element(name = "CST", required = true)
    private NFNotaInfoSituacaoTributariaCOFINS situacaoTributaria;

    @Element(name = "vBC", required = true)
    private BigDecimal valorBaseCalulo;

    @Element(name = "pCOFINS", required = true)
    private BigDecimal aliquota;

    @Element(name = "vCOFINS", required = true)
    private BigDecimal valor;

    public NFNotaInfoItemImpostoCOFINSAliquota() {
        this.situacaoTributaria = null;
        this.valorBaseCalulo = null;
        this.aliquota = null;
        this.valor = null;
    }

    public NFNotaInfoSituacaoTributariaCOFINS getSituacaoTributaria() {
        return this.situacaoTributaria;
    }

    public void setSituacaoTributaria(final NFNotaInfoSituacaoTributariaCOFINS situacaoTributaria) {
        this.situacaoTributaria = situacaoTributaria;
    }

    public BigDecimal getValorBaseCalulo() {
        return this.valorBaseCalulo;
    }

    public void setValorBaseCalulo(final BigDecimal valorBaseCalulo) {
        this.valorBaseCalulo = valorBaseCalulo;
    }

    public BigDecimal getAliquota() {
        return this.aliquota;
    }

    public void setAliquota(final BigDecimal aliquota) {
        this.aliquota = aliquota;
    }

    public BigDecimal getValor() {
        return this.valor;
    }

    public void setValor(final BigDecimal valor) {
        this.valor = valor;
    }
}