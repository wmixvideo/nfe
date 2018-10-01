package com.fincatto.documentofiscal.nfe400.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaSituacaoOperacionalSimplesNacional;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;

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

    @Element(name = "pRedBCEfet", required = false)
    private String percentualReducaoBCEfetiva;

    @Element(name = "vBCEfet", required = false)
    private String valorBCEfetiva;

    @Element(name = "pICMSEfet", required = false)
    private String percentualAliquotaICMSEfetiva;

    @Element(name = "vICMSEfet", required = false)
    private String valorICMSEfetivo;

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
        this.percentualICMSSTRetido = BigDecimalParser.tamanho7ComAte4CasasDecimais(percentualICMSSTRetido, "Percentual ICMS ST Retido ICMSSN500");
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
        this.percentualFundoCombatePobrezaRetidoST = BigDecimalParser.tamanho7ComAte4CasasDecimais(percentualFundoCombatePobrezaRetidoST, "Percentual fundo combate pobreza retido ST");
    }

    public void setValorFundoCombatePobrezaRetidoST(final BigDecimal valorFundoCombatePobrezaRetidoST) {
        this.valorFundoCombatePobrezaRetidoST = BigDecimalParser.tamanho15Com2CasasDecimais(valorFundoCombatePobrezaRetidoST, "Valor fundo combate pobreza retido ST");
    }

    public void setPercentualReducaoBCEfetiva(final BigDecimal percentualReducaoBCEfetiva) {
        this.percentualReducaoBCEfetiva = BigDecimalParser.tamanho7ComAte4CasasDecimais(percentualReducaoBCEfetiva, "Percentual reducao BC efetiva");
    }

    public void setValorBCEfetiva(final BigDecimal valorBCEfetiva) {
        this.valorBCEfetiva = BigDecimalParser.tamanho15Com2CasasDecimais(valorBCEfetiva, "Valor BC efetiva");
    }

    public void setPercentualAliquotaICMSEfetiva(final BigDecimal percentualAliquotaICMSEfetiva) {
        this.percentualAliquotaICMSEfetiva = BigDecimalParser.tamanho7ComAte4CasasDecimais(percentualAliquotaICMSEfetiva, "Percentual aliquota ICMS efetiva");
    }

    public void setValorICMSEfetivo(final BigDecimal valorICMSEfetivo) {
        this.valorICMSEfetivo = BigDecimalParser.tamanho15Com2CasasDecimais(valorICMSEfetivo, "Valor ICMS efetivo");
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

    public String getPercentualReducaoBCEfetiva() {
        return this.percentualReducaoBCEfetiva;
    }

    public String getValorBCEfetiva() {
        return this.valorBCEfetiva;
    }

    public String getPercentualAliquotaICMSEfetiva() {
        return this.percentualAliquotaICMSEfetiva;
    }

    public String getValorICMSEfetivo() {
        return this.valorICMSEfetivo;
    }
}