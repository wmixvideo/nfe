package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoItemModalidadeBCICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoItemModalidadeBCICMSST;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaSituacaoOperacionalSimplesNacional;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoICMSSN900 extends DFBase {
    private static final long serialVersionUID = 4771007345613617306L;

    @Element(name = "orig", required = true)
    private NFOrigem origem;

    @Element(name = "CSOSN", required = true)
    private NFNotaSituacaoOperacionalSimplesNacional situacaoOperacaoSN;

    @Element(name = "modBC", required = false)
    private NFNotaInfoItemModalidadeBCICMS modalidadeBCICMS;

    @Element(name = "vBC", required = false)
    private String valorBCICMS;

    @Element(name = "pRedBC", required = false)
    private String percentualReducaoBC;

    @Element(name = "pICMS", required = false)
    private String percentualAliquotaImposto;

    @Element(name = "vICMS", required = false)
    private String valorICMS;

    @Element(name = "modBCST", required = false)
    private NFNotaInfoItemModalidadeBCICMSST modalidadeBCICMSST;

    @Element(name = "pMVAST", required = false)
    private String percentualMargemValorAdicionadoICMSST;

    @Element(name = "pRedBCST", required = false)
    private String percentualReducaoBCICMSST;

    @Element(name = "vBCST", required = false)
    private String valorBCICMSST;

    @Element(name = "pICMSST", required = false)
    private String percentualAliquotaImpostoICMSST;

    @Element(name = "vICMSST", required = false)
    private String valorICMSST;

    @Element(name = "vBCFCPST", required = false)
    private String valorBCFundoCombatePobrezaST;

    @Element(name = "pFCPST", required = false)
    private String percentualFundoCombatePobrezaST;

    @Element(name = "vFCPST", required = false)
    private String valorFundoCombatePobrezaST;

    @Element(name = "pCredSN", required = false)
    private String percentualAliquotaAplicavelCalculoCreditoSN;

    @Element(name = "vCredICMSSN", required = false)
    private String valorCreditoICMSSN;

    public void setOrigem(final NFOrigem origem) {
        this.origem = origem;
    }

    public void setSituacaoOperacaoSN(final NFNotaSituacaoOperacionalSimplesNacional situacaoOperacaoSN) {
        this.situacaoOperacaoSN = situacaoOperacaoSN;
    }

    public void setModalidadeBCICMS(final NFNotaInfoItemModalidadeBCICMS modalidadeBCICMS) {
        this.modalidadeBCICMS = modalidadeBCICMS;
    }

    public void setValorBCICMS(final BigDecimal valorBCICMS) {
        this.valorBCICMS = BigDecimalParser.tamanho15Com2CasasDecimais(valorBCICMS, "Valor BC ICMSSN900");
    }

    public void setPercentualReducaoBC(final BigDecimal percentualReducaoBC) {
        this.percentualReducaoBC = BigDecimalParser.tamanho7ComAte4CasasDecimais(percentualReducaoBC, "Percentual Reducao BC ICMSSN900");
    }

    public void setPercentualAliquotaImposto(final BigDecimal aliquotaImposto) {
        this.percentualAliquotaImposto = BigDecimalParser.tamanho7ComAte4CasasDecimais(aliquotaImposto, "Aliquota Imposto ICMSSN900");
    }

    public void setValorICMS(final BigDecimal valorICMS) {
        this.valorICMS = BigDecimalParser.tamanho15Com2CasasDecimais(valorICMS, "Valor ICMSSN900");
    }

    public void setModalidadeBCICMSST(final NFNotaInfoItemModalidadeBCICMSST modalidadeBCICMSST) {
        this.modalidadeBCICMSST = modalidadeBCICMSST;
    }

    public void setPercentualMargemValorAdicionadoICMSST(final BigDecimal percentualMargemValorAdicionadoICMSST) {
        this.percentualMargemValorAdicionadoICMSST = BigDecimalParser.tamanho7ComAte4CasasDecimais(percentualMargemValorAdicionadoICMSST, "Percentual Margel Valor Adicionado ICMS ST ICMSSN900");
    }

    public void setPercentualReducaoBCICMSST(final BigDecimal percentualReducaoBCICMSST) {
        this.percentualReducaoBCICMSST = BigDecimalParser.tamanho7ComAte4CasasDecimais(percentualReducaoBCICMSST, "Percentual Reducao BC ICMS ST ICMSSN900");
    }

    public void setValorBCICMSST(final BigDecimal valorBCICMSST) {
        this.valorBCICMSST = BigDecimalParser.tamanho15Com2CasasDecimais(valorBCICMSST, "Valor BC ICMS ST ICMSSN900");
    }

    public void setPercentualAliquotaImpostoICMSST(final BigDecimal aliquotaImpostoICMSST) {
        this.percentualAliquotaImpostoICMSST = BigDecimalParser.tamanho7ComAte4CasasDecimais(aliquotaImpostoICMSST, "Aliquota Imposto ICMS ST ICMSSN900");
    }

    public void setValorICMSST(final BigDecimal valorICMSST) {
        this.valorICMSST = BigDecimalParser.tamanho15Com2CasasDecimais(valorICMSST, "Valor ICMS ST ICMSSN900");
    }

    public void setValorBCFundoCombatePobrezaST(final BigDecimal valorBCFundoCombatePobrezaST) {
        this.valorBCFundoCombatePobrezaST = BigDecimalParser.tamanho15Com2CasasDecimais(valorBCFundoCombatePobrezaST, "Base calculo fundo combate pobreza ST");
    }

    public void setPercentualFundoCombatePobrezaST(final BigDecimal percentualFundoCombatePobrezaST) {
        if (percentualFundoCombatePobrezaST == null || percentualFundoCombatePobrezaST.signum() <= 0) {
            throw new IllegalStateException("Percentual fundo de combate a pobreza precisa ser maior que zero!");
        }
        this.percentualFundoCombatePobrezaST = BigDecimalParser.tamanho7ComAte4CasasDecimais(percentualFundoCombatePobrezaST, "Percentual fundo combate pobreza ST");
    }

    public void setValorFundoCombatePobrezaST(final BigDecimal valorFundoCombatePobrezaST) {
        this.valorFundoCombatePobrezaST = BigDecimalParser.tamanho15Com2CasasDecimais(valorFundoCombatePobrezaST, "Valor fundo combate pobreza ST");
    }

    public void setPercentualAliquotaAplicavelCalculoCreditoSN(final BigDecimal percentualAliquotaAplicavelCalculoCreditoSN) {
        this.percentualAliquotaAplicavelCalculoCreditoSN = BigDecimalParser.tamanho7ComAte4CasasDecimais(percentualAliquotaAplicavelCalculoCreditoSN, "Aliquota Aplicavel Calculo Credito SN ICMSSN900");
    }

    public void setValorCreditoICMSSN(final BigDecimal valorCreditoICMSSN) {
        this.valorCreditoICMSSN = BigDecimalParser.tamanho15Com2CasasDecimais(valorCreditoICMSSN, "Valor Credito ICMSSN900");
    }

    public NFOrigem getOrigem() {
        return this.origem;
    }

    public NFNotaSituacaoOperacionalSimplesNacional getSituacaoOperacaoSN() {
        return this.situacaoOperacaoSN;
    }

    public NFNotaInfoItemModalidadeBCICMS getModalidadeBCICMS() {
        return this.modalidadeBCICMS;
    }

    public String getValorBCICMS() {
        return this.valorBCICMS;
    }

    public String getPercentualReducaoBC() {
        return this.percentualReducaoBC;
    }

    public String getPercentualAliquotaImposto() {
        return this.percentualAliquotaImposto;
    }

    public String getValorICMS() {
        return this.valorICMS;
    }

    public NFNotaInfoItemModalidadeBCICMSST getModalidadeBCICMSST() {
        return this.modalidadeBCICMSST;
    }

    public String getPercentualMargemValorAdicionadoICMSST() {
        return this.percentualMargemValorAdicionadoICMSST;
    }

    public String getPercentualReducaoBCICMSST() {
        return this.percentualReducaoBCICMSST;
    }

    public String getValorBCICMSST() {
        return this.valorBCICMSST;
    }

    public String getPercentualAliquotaImpostoICMSST() {
        return this.percentualAliquotaImpostoICMSST;
    }

    public String getValorICMSST() {
        return this.valorICMSST;
    }

    public String getValorBCFundoCombatePobrezaST() {
        return this.valorBCFundoCombatePobrezaST;
    }

    public String getPercentualFundoCombatePobrezaST() {
        return this.percentualFundoCombatePobrezaST;
    }

    public String getValorFundoCombatePobrezaST() {
        return this.valorFundoCombatePobrezaST;
    }

    public String getPercentualAliquotaAplicavelCalculoCreditoSN() {
        return this.percentualAliquotaAplicavelCalculoCreditoSN;
    }

    public String getValorCreditoICMSSN() {
        return this.valorCreditoICMSSN;
    }
}