package com.fincatto.documentofiscal.nfe400.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;

public class NFNotaInfoItemImpostoICMS60 extends DFBase {
    private static final long serialVersionUID = 1325261415800285939L;

    @Element(name = "orig", required = true)
    private NFOrigem origem;

    @Element(name = "CST", required = true)
    private NFNotaInfoImpostoTributacaoICMS situacaoTributaria;

    @Element(name = "vBCSTRet", required = true)
    private String valorBCICMSSTRetido;

    @Element(name = "pST", required = true)
    private String percentualAliquotaICMSST;

    @Element(name = "vICMSSTRet", required = true)
    private String valorICMSSTRetido;

    @Element(name = "vBCFCPSTRet", required = false)
    private String valorBCFundoCombatePobrezaRetidoST;

    @Element(name = "pFCPSTRet", required = false)
    private String percentualFundoCombatePobrezaRetidoST;

    @Element(name = "vFCPSTRet", required = false)
    private String valorFundoCombatePobrezaRetidoST;

    public void setOrigem(final NFOrigem origem) {
        this.origem = origem;
    }

    public void setSituacaoTributaria(final NFNotaInfoImpostoTributacaoICMS situacaoTributaria) {
        this.situacaoTributaria = situacaoTributaria;
    }

    public void setValorBCICMSSTRetido(final BigDecimal valorBCICMSSTRetido) {
        this.valorBCICMSSTRetido = BigDecimalParser.tamanho15Com2CasasDecimais(valorBCICMSSTRetido, "Valor BC ICMS ST Retido ICMS60 Item");
    }

    public void setValorICMSSTRetido(final BigDecimal valorICMSSTRetido) {
        this.valorICMSSTRetido = BigDecimalParser.tamanho15Com2CasasDecimais(valorICMSSTRetido, "Valor ICMS ST Retido ICMS60 Item");
    }

    public void setPercentualAliquotaICMSST(final BigDecimal percentualAliquotaICMSST) {
        this.percentualAliquotaICMSST = BigDecimalParser.tamanho7ComAte4CasasDecimais(percentualAliquotaICMSST, "Valor ICMS ST Retido ICMS60 Item");
    }

    public void setValorBCFundoCombatePobrezaRetidoST(final BigDecimal valorBCFundoCombatePobrezaRetidoST) {
        this.valorBCFundoCombatePobrezaRetidoST = BigDecimalParser.tamanho15Com2CasasDecimais(valorBCFundoCombatePobrezaRetidoST, "Valor base calculo fundo combate pobreza retido ST");
    }

    public void setPercentualFundoCombatePobrezaRetidoST(final BigDecimal percentualFundoCombatePobrezaRetidoST) {
        if (percentualFundoCombatePobrezaRetidoST.signum() < 0) {
            throw new IllegalStateException("Percentual fundo de combate a pobreza precisa ser maior que zero!");
        }
        this.percentualFundoCombatePobrezaRetidoST = BigDecimalParser.tamanho7ComAte4CasasDecimais(percentualFundoCombatePobrezaRetidoST, "Percentual fundo combate pobreza retido ST");;
    }

    public void setValorFundoCombatePobrezaRetidoST(final BigDecimal valorFundoCombatePobrezaRetidoST) {
        this.valorFundoCombatePobrezaRetidoST = BigDecimalParser.tamanho15Com2CasasDecimais(valorFundoCombatePobrezaRetidoST, "Valor fundo combate pobreza retido ST");;
    }

    public NFOrigem getOrigem() {
        return this.origem;
    }

    public NFNotaInfoImpostoTributacaoICMS getSituacaoTributaria() {
        return this.situacaoTributaria;
    }

    public String getValorBCICMSSTRetido() {
        return this.valorBCICMSSTRetido;
    }

    public String getValorICMSSTRetido() {
        return this.valorICMSSTRetido;
    }

    public String getPercentualAliquotaICMSST() {
        return this.percentualAliquotaICMSST;
    }

    public String getValorBCFundoCombatePobrezaRetidoST() {
        return this.valorBCFundoCombatePobrezaRetidoST;
    }

    public String getPercentualFundoCombatePobrezaRetidoST() {
        return this.percentualFundoCombatePobrezaRetidoST;
    }

    public String getValorFundoCombatePobrezaRetidoST() {
        return this.valorFundoCombatePobrezaRetidoST;
    }
}