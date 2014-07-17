package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.classes.NFOrigem;

public class NFNotaInfoItemImpostoICMSST extends NFBase {

    @Element(name = "orig", required = true)
    private NFOrigem origem;

    @Element(name = "CST", required = true)
    private String codigoSituacaoTributaria;

    @Element(name = "vBCSTRet", required = true)
    private BigDecimal valorBCICMSSTRetidoUFRemetente;

    @Element(name = "vICMSSTRet", required = true)
    private BigDecimal valorICMSSTRetidoUFRemetente;

    @Element(name = "vBCSTDest", required = true)
    private BigDecimal valorBCICMSSTUFDestino;

    @Element(name = "vICMSSTDest", required = true)
    private BigDecimal valorICMSSTUFDestino;

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

    public BigDecimal getValorBCICMSSTRetidoUFRemetente() {
        return this.valorBCICMSSTRetidoUFRemetente;
    }

    public void setValorBCICMSSTRetidoUFRemetente(final BigDecimal valorBCICMSSTRetidoUFRemetente) {
        this.valorBCICMSSTRetidoUFRemetente = valorBCICMSSTRetidoUFRemetente;
    }

    public BigDecimal getValorICMSSTRetidoUFRemetente() {
        return this.valorICMSSTRetidoUFRemetente;
    }

    public void setValorICMSSTRetidoUFRemetente(final BigDecimal valorICMSSTRetidoUFRemetente) {
        this.valorICMSSTRetidoUFRemetente = valorICMSSTRetidoUFRemetente;
    }

    public BigDecimal getValorBCICMSSTUFDestino() {
        return this.valorBCICMSSTUFDestino;
    }

    public void setValorBCICMSSTUFDestino(final BigDecimal valorBCICMSSTUFDestino) {
        this.valorBCICMSSTUFDestino = valorBCICMSSTUFDestino;
    }

    public BigDecimal getValorICMSSTUFDestino() {
        return this.valorICMSSTUFDestino;
    }

    public void setValorICMSSTUFDestino(final BigDecimal valorICMSSTUFDestino) {
        this.valorICMSSTUFDestino = valorICMSSTUFDestino;
    }
}