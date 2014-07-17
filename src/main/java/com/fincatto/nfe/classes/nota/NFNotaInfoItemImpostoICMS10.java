package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.classes.NFOrigem;

public class NFNotaInfoItemImpostoICMS10 extends NFBase {
    @Element(name = "orig", required = true)
    private NFOrigem origem;

    @Element(name = "CST", required = true)
    private String codigoSituacaoTributaria;

    @Element(name = "modBC", required = true)
    private NFNotaInfoItemImpostoICMSModalidadeBaseCalulo modalidadeBaseCalculo;

    @Element(name = "vBC", required = true)
    private BigDecimal valorBaseCalculo;

    @Element(name = "pICMS", required = true)
    private BigDecimal aliquota;

    @Element(name = "vICMS", required = true)
    private BigDecimal valorTributo;

    @Element(name = "modBCST", required = true)
    private NFnotaInfoItemModalidadeBCICMSST modalidadeDeterminacaoBCICMS;

    @Element(name = "pMVAST", required = false)
    private BigDecimal percentualMargemValorICMSST;

    @Element(name = "pRedBCST", required = false)
    private BigDecimal percentualReducaoBCICMSST;

    @Element(name = "vBCST", required = true)
    private BigDecimal valorBCICMSST;

    @Element(name = "pICMSST", required = true)
    private BigDecimal aliquotaImpostoICMSST;

    @Element(name = "vICMSST", required = true)
    private BigDecimal valorICMSST;

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

    public NFNotaInfoItemImpostoICMSModalidadeBaseCalulo getModalidadeBaseCalculo() {
        return this.modalidadeBaseCalculo;
    }

    public void setModalidadeBaseCalculo(final NFNotaInfoItemImpostoICMSModalidadeBaseCalulo modalidadeBaseCalculo) {
        this.modalidadeBaseCalculo = modalidadeBaseCalculo;
    }

    public BigDecimal getValorBaseCalculo() {
        return this.valorBaseCalculo;
    }

    public void setValorBaseCalculo(final BigDecimal valorBaseCalculo) {
        this.valorBaseCalculo = valorBaseCalculo;
    }

    public BigDecimal getAliquota() {
        return this.aliquota;
    }

    public void setAliquota(final BigDecimal aliquota) {
        this.aliquota = aliquota;
    }

    public BigDecimal getValorTributo() {
        return this.valorTributo;
    }

    public void setValorTributo(final BigDecimal valorTributo) {
        this.valorTributo = valorTributo;
    }

    public NFnotaInfoItemModalidadeBCICMSST getModalidadeDeterminacaoBCICMS() {
        return this.modalidadeDeterminacaoBCICMS;
    }

    public void setModalidadeDeterminacaoBCICMS(final NFnotaInfoItemModalidadeBCICMSST modalidadeDeterminacaoBCICMS) {
        this.modalidadeDeterminacaoBCICMS = modalidadeDeterminacaoBCICMS;
    }

    public BigDecimal getPercentualMargemValorICMSST() {
        return this.percentualMargemValorICMSST;
    }

    public void setPercentualMargemValorICMSST(final BigDecimal percentualMargemValorICMSST) {
        this.percentualMargemValorICMSST = percentualMargemValorICMSST;
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
}
