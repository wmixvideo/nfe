package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.classes.NFOrigem;

public class NFNotaInfoItemImpostoICMS30 extends NFBase {
    @Element(name = "orig", required = true)
    private NFOrigem origem;

    @Element(name = "CST", required = true)
    private String codigoSituacaoTributaria;

    @Element(name = "modBCST", required = true)
    private NFnotaInfoItemModalidadeBCICMSST modalidadeDeterminacaoBC;

    @Element(name = "pMVAST", required = false)
    private BigDecimal percentualMargemValorAdicionadoICMSST;

    @Element(name = "pRedBCST", required = false)
    private BigDecimal percentualReducaoBCICMSST;

    @Element(name = "vBCST", required = true)
    private BigDecimal valorBCICMSST;

    @Element(name = "pICMSST", required = true)
    private BigDecimal aliquotaImpostoICMSST;

    @Element(name = "vICMSST", required = true)
    private BigDecimal valorImpostoICMSST;

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

    public NFnotaInfoItemModalidadeBCICMSST getModalidadeDeterminacaoBC() {
        return this.modalidadeDeterminacaoBC;
    }

    public void setModalidadeDeterminacaoBC(final NFnotaInfoItemModalidadeBCICMSST modalidadeDeterminacaoBC) {
        this.modalidadeDeterminacaoBC = modalidadeDeterminacaoBC;
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

    public BigDecimal getValorImpostoICMSST() {
        return this.valorImpostoICMSST;
    }

    public void setValorImpostoICMSST(final BigDecimal valorImpostoICMSST) {
        this.valorImpostoICMSST = valorImpostoICMSST;
    }
}