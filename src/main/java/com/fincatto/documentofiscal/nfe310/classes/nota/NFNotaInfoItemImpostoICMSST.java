package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe310.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe310.classes.NFOrigem;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoICMSST extends DFBase {
    private static final long serialVersionUID = -2354449482492846488L;
    
    @Element(name = "orig")
    private NFOrigem origem;
    
    @Element(name = "CST")
    private NFNotaInfoImpostoTributacaoICMS situacaoTributaria;
    
    @Element(name = "vBCSTRet")
    private String valorBCICMSSTRetidoUFRemetente;
    
    @Element(name = "vICMSSTRet")
    private String valorICMSSTRetidoUFRemetente;
    
    @Element(name = "vBCSTDest")
    private String valorBCICMSSTUFDestino;
    
    @Element(name = "vICMSSTDest")
    private String valorICMSSTUFDestino;

    public void setOrigem(final NFOrigem origem) {
        this.origem = origem;
    }

    public void setSituacaoTributaria(final NFNotaInfoImpostoTributacaoICMS situacaoTributaria) {
        this.situacaoTributaria = situacaoTributaria;
    }

    public void setValorBCICMSSTRetidoUFRemetente(final BigDecimal valorBCICMSSTRetidoUFRemetente) {
        this.valorBCICMSSTRetidoUFRemetente = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorBCICMSSTRetidoUFRemetente, "Valor BC ICMS ST Retido UF Remetente");
    }

    public void setValorICMSSTRetidoUFRemetente(final BigDecimal valorICMSSTRetidoUFRemetente) {
        this.valorICMSSTRetidoUFRemetente = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorICMSSTRetidoUFRemetente, "Valor ICMS ST Retido UF Remetente");
    }

    public void setValorBCICMSSTUFDestino(final BigDecimal valorBCICMSSTUFDestino) {
        this.valorBCICMSSTUFDestino = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorBCICMSSTUFDestino, "Valor BC ICMS ST UF Destino");
    }

    public void setValorICMSSTUFDestino(final BigDecimal valorICMSSTUFDestino) {
        this.valorICMSSTUFDestino = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorICMSSTUFDestino, "Valor ICMS ST UF Destino");
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