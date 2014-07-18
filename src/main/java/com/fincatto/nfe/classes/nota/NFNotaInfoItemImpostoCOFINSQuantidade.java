package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;

public class NFNotaInfoItemImpostoCOFINSQuantidade extends NFBase {

    @Element(name = "CST", required = true)
    private NFNotaInfoSituacaoTributariaCOFINS situacaoTributaria;

    @Element(name = "qBCProd", required = true)
    private BigDecimal quantidadeVendida;

    @Element(name = "vAliqProd", required = true)
    private BigDecimal valorAliquota;

    @Element(name = "vCOFINS", required = true)
    private BigDecimal valorTributo;

    public NFNotaInfoItemImpostoCOFINSQuantidade() {
        this.situacaoTributaria = null;
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
