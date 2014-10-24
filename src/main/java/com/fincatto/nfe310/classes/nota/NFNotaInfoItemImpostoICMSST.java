package com.fincatto.nfe310.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.nfe310.classes.NFOrigem;
import com.fincatto.nfe310.validadores.BigDecimalParser;

public class NFNotaInfoItemImpostoICMSST extends NFBase {

    @Element(name = "orig", required = true)
    private NFOrigem origem;

    @Element(name = "CST", required = true)
    private NFNotaInfoImpostoTributacaoICMS situacaoTributaria;

    @Element(name = "vBCSTRet", required = true)
    private String valorBCICMSSTRetidoUFRemetente;

    @Element(name = "vICMSSTRet", required = true)
    private String valorICMSSTRetidoUFRemetente;

    @Element(name = "vBCSTDest", required = true)
    private String valorBCICMSSTUFDestino;

    @Element(name = "vICMSSTDest", required = true)
    private String valorICMSSTUFDestino;

    public void setOrigem(final NFOrigem origem) {
        this.origem = origem;
    }

    public void setSituacaoTributaria(final NFNotaInfoImpostoTributacaoICMS situacaoTributaria) {
        this.situacaoTributaria = situacaoTributaria;
    }

    public void setValorBCICMSSTRetidoUFRemetente(final BigDecimal valorBCICMSSTRetidoUFRemetente) {
        this.valorBCICMSSTRetidoUFRemetente = BigDecimalParser.tamanho15Com2CasasDecimais(valorBCICMSSTRetidoUFRemetente);
    }

    public void setValorICMSSTRetidoUFRemetente(final BigDecimal valorICMSSTRetidoUFRemetente) {
        this.valorICMSSTRetidoUFRemetente = BigDecimalParser.tamanho15Com2CasasDecimais(valorICMSSTRetidoUFRemetente);
    }

    public void setValorBCICMSSTUFDestino(final BigDecimal valorBCICMSSTUFDestino) {
        this.valorBCICMSSTUFDestino = BigDecimalParser.tamanho15Com2CasasDecimais(valorBCICMSSTUFDestino);
    }

    public void setValorICMSSTUFDestino(final BigDecimal valorICMSSTUFDestino) {
        this.valorICMSSTUFDestino = BigDecimalParser.tamanho15Com2CasasDecimais(valorICMSSTUFDestino);
    }

    public NFOrigem getOrigem() {
        return this.origem;
    }

    public NFNotaInfoImpostoTributacaoICMS getSituacaoTributaria() {
        return this.situacaoTributaria;
    }

    public String getValorBCICMSSTRetidoUFRemetente() {
        return this.valorBCICMSSTRetidoUFRemetente;
    }

    public String getValorICMSSTRetidoUFRemetente() {
        return this.valorICMSSTRetidoUFRemetente;
    }

    public String getValorBCICMSSTUFDestino() {
        return this.valorBCICMSSTUFDestino;
    }

    public String getValorICMSSTUFDestino() {
        return this.valorICMSSTUFDestino;
    }
}