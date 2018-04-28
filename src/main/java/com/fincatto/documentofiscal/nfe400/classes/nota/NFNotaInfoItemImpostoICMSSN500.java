package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaSituacaoOperacionalSimplesNacional;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoICMSSN500 extends DFBase {
    private static final long serialVersionUID = 83636755742035633L;

    @Element(name = "orig", required = true)
    private NFOrigem origem;

    @Element(name = "CSOSN", required = true)
    private NFNotaSituacaoOperacionalSimplesNacional situacaoOperacaoSN;

    @Element(name = "vBCSTRet", required = false)
    private String valorBCICMSSTRetido;

    @Element(name = "pST", required = false)
    private String percentualICMSSTRetido;

    @Element(name = "vICMSSTRet", required = false)
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

    public void setSituacaoOperacaoSN(final NFNotaSituacaoOperacionalSimplesNacional situacaoOperacaoSN) {
        this.situacaoOperacaoSN = situacaoOperacaoSN;
    }

    public void setValorBCICMSSTRetido(final BigDecimal valorBCICMSSTRetido) {
        this.valorBCICMSSTRetido = BigDecimalParser.tamanho15Com2CasasDecimais(valorBCICMSSTRetido, "Valor BC ICMS ST Retido ICMSSN500");
    }

    public void setPercentualICMSSTRetido(final BigDecimal percentualICMSSTRetido) {
        this.percentualICMSSTRetido = BigDecimalParser.tamanho15Com2CasasDecimais(percentualICMSSTRetido, "Percentual ICMS ST Retido ICMSSN500");
    }

    public void setValorICMSSTRetido(final BigDecimal valorICMSSTRetido) {
        this.valorICMSSTRetido = BigDecimalParser.tamanho15Com2CasasDecimais(valorICMSSTRetido, "Valor ICMS ST Retido ICMSSN500");
    }

    public void setValorBCFundoCombatePobrezaRetidoST(final BigDecimal valorBCFundoCombatePobrezaRetidoST) {
        this.valorBCFundoCombatePobrezaRetidoST = BigDecimalParser.tamanho15Com2CasasDecimais(valorBCFundoCombatePobrezaRetidoST, "Valor base calculo fundo combate pobreza retido ST");
    }

    public void setPercentualFundoCombatePobrezaRetidoST(final BigDecimal percentualFundoCombatePobrezaRetidoST) {
        if (percentualFundoCombatePobrezaRetidoST.signum() <= 0) {
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

    public NFNotaSituacaoOperacionalSimplesNacional getSituacaoOperacaoSN() {
        return this.situacaoOperacaoSN;
    }

    public String getValorBCICMSSTRetido() {
        return this.valorBCICMSSTRetido;
    }

    public String getPercentualICMSSTRetido() {
        return this.percentualICMSSTRetido;
    }

    public String getValorICMSSTRetido() {
        return this.valorICMSSTRetido;
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