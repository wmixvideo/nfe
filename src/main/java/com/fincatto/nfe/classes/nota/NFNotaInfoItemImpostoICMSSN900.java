package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.classes.NFOrigem;

public class NFNotaInfoItemImpostoICMSSN900 extends NFBase {
    @Element(name = "orig", required = true)
    private NFOrigem origem;

    @Element(name = "CSOSN", required = true)
    private NFNotaSituacaoOperacionalSimplesNacional situacaoOperacaoSN;

    @Element(name = "modBC", required = true)
    private NFNotaInfoItemImpostoICMSModalidadeBaseCalulo modalidadeDeterminacaoBCICMS;

    @Element(name = "vBC", required = true)
    private BigDecimal valorBCICMS;

    @Element(name = "pRedBC", required = false)
    private BigDecimal percentualReducaoBC;

    @Element(name = "pICMS", required = true)
    private BigDecimal aliquotaImposto;

    @Element(name = "vICMS", required = true)
    private BigDecimal valorICMS;

    @Element(name = "modBCST", required = true)
    private NFnotaInfoItemModalidadeBCICMSST modalidadeBCICMSST;

    @Element(name = "pMVAST", required = false)
    private BigDecimal percentualMargemValorAdicionadoICMSST;

    @Element(name = "pRedBCST", required = false)
    private BigDecimal percentualReducaoBCICMSST;

    @Element(name = "vBCST", required = true)
    private BigDecimal valorBCICMSST;

    @Element(name = "pICMSST", required = true)
    private BigDecimal aliquotaImpostoICMSST;

    @Element(name = "vICMSST", required = true)
    private BigDecimal valorICMSST;

    @Element(name = "pCredSN", required = true)
    private BigDecimal aliquotaAplicavelCalculoCreditoSN;

    @Element(name = "vCredICMSSN", required = true)
    private BigDecimal valorCreditoICMSSN;

    public NFOrigem getOrigem() {
        return this.origem;
    }

    public void setOrigem(final NFOrigem origem) {
        this.origem = origem;
    }

    public NFNotaSituacaoOperacionalSimplesNacional getSituacaoOperacaoSN() {
        return this.situacaoOperacaoSN;
    }

    public void setSituacaoOperacaoSN(final NFNotaSituacaoOperacionalSimplesNacional situacaoOperacaoSN) {
        this.situacaoOperacaoSN = situacaoOperacaoSN;
    }

    public NFNotaInfoItemImpostoICMSModalidadeBaseCalulo getModalidadeDeterminacaoBCICMS() {
        return this.modalidadeDeterminacaoBCICMS;
    }

    public void setModalidadeDeterminacaoBCICMS(final NFNotaInfoItemImpostoICMSModalidadeBaseCalulo modalidadeDeterminacaoBCICMS) {
        this.modalidadeDeterminacaoBCICMS = modalidadeDeterminacaoBCICMS;
    }

    public BigDecimal getValorBCICMS() {
        return this.valorBCICMS;
    }

    public void setValorBCICMS(final BigDecimal valorBCICMS) {
        this.valorBCICMS = valorBCICMS;
    }

    public BigDecimal getPercentualReducaoBC() {
        return this.percentualReducaoBC;
    }

    public void setPercentualReducaoBC(final BigDecimal percentualReducaoBC) {
        this.percentualReducaoBC = percentualReducaoBC;
    }

    public BigDecimal getAliquotaImposto() {
        return this.aliquotaImposto;
    }

    public void setAliquotaImposto(final BigDecimal aliquotaImposto) {
        this.aliquotaImposto = aliquotaImposto;
    }

    public BigDecimal getValorICMS() {
        return this.valorICMS;
    }

    public void setValorICMS(final BigDecimal valorICMS) {
        this.valorICMS = valorICMS;
    }

    public NFnotaInfoItemModalidadeBCICMSST getModalidadeBCICMSST() {
        return this.modalidadeBCICMSST;
    }

    public void setModalidadeBCICMSST(final NFnotaInfoItemModalidadeBCICMSST modalidadeBCICMSST) {
        this.modalidadeBCICMSST = modalidadeBCICMSST;
    }

    public BigDecimal getPercentualMargemValorAdicionadoICMSST() {
        return this.percentualMargemValorAdicionadoICMSST;
    }

    public void setPercentualMargemValorAdicionadoICMSST(final BigDecimal percentualMargemValorAdicionadoICMSST) {
        this.percentualMargemValorAdicionadoICMSST = percentualMargemValorAdicionadoICMSST;
    }

    public BigDecimal getPercentualReducaoBCICMSST() {
        return this.percentualReducaoBCICMSST;
    }

    public void setPercentualReducaoBCICMSST(final BigDecimal percentualReducaoBCICMSST) {
        this.percentualReducaoBCICMSST = percentualReducaoBCICMSST;
    }

    public BigDecimal getValorBCICMSST() {
        return this.valorBCICMSST;
    }

    public void setValorBCICMSST(final BigDecimal valorBCICMSST) {
        this.valorBCICMSST = valorBCICMSST;
    }

    public BigDecimal getAliquotaImpostoICMSST() {
        return this.aliquotaImpostoICMSST;
    }

    public void setAliquotaImpostoICMSST(final BigDecimal aliquotaImpostoICMSST) {
        this.aliquotaImpostoICMSST = aliquotaImpostoICMSST;
    }

    public BigDecimal getValorICMSST() {
        return this.valorICMSST;
    }

    public void setValorICMSST(final BigDecimal valorICMSST) {
        this.valorICMSST = valorICMSST;
    }

    public BigDecimal getAliquotaAplicavelCalculoCreditoSN() {
        return this.aliquotaAplicavelCalculoCreditoSN;
    }

    public void setAliquotaAplicavelCalculoCreditoSN(final BigDecimal aliquotaAplicavelCalculoCreditoSN) {
        this.aliquotaAplicavelCalculoCreditoSN = aliquotaAplicavelCalculoCreditoSN;
    }

    public BigDecimal getValorCreditoICMSSN() {
        return this.valorCreditoICMSSN;
    }

    public void setValorCreditoICMSSN(final BigDecimal valorCreditoICMSSN) {
        this.valorCreditoICMSSN = valorCreditoICMSSN;
    }
}