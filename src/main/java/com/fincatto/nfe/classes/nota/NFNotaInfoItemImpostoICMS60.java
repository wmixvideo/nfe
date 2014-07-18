package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFOrigem;

public class NFNotaInfoItemImpostoICMS60 {
    @Element(name = "orig", required = true)
    private NFOrigem origem;

    @Element(name = "CST", required = true)
    private String codigoSituacaoTributaria;

    @Element(name = "vBCSTRet", required = false)
    private BigDecimal valorBCICMSSTRetido;

    @Element(name = "vICMSSTRet", required = false)
    private BigDecimal valorICMSSTRetido;

    public NFOrigem getOrigem() {
        return this.origem;
    }

    public void setOrigem(final NFOrigem origem) {
        this.origem = origem;
    }

    public String getCodigoSituacaoTributaria() {
        return this.codigoSituacaoTributaria;
    }

    public void setCodigoSituacaoTributaria(final String codigoSituacaoTributaria) {
        this.codigoSituacaoTributaria = codigoSituacaoTributaria;
    }

    public BigDecimal getValorBCICMSSTRetido() {
        return this.valorBCICMSSTRetido;
    }

    public void setValorBCICMSSTRetido(final BigDecimal valorBCICMSSTRetido) {
        this.valorBCICMSSTRetido = valorBCICMSSTRetido;
    }

    public BigDecimal getValorICMSSTRetido() {
        return this.valorICMSSTRetido;
    }

    public void setValorICMSSTRetido(final BigDecimal valorICMSSTRetido) {
        this.valorICMSSTRetido = valorICMSSTRetido;
    }
}