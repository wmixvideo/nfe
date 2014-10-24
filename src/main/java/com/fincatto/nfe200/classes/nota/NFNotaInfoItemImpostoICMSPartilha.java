package com.fincatto.nfe200.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe200.classes.NFBase;
import com.fincatto.nfe200.classes.NFNotaInfoItemImpostoICMSModalidadeBaseCalulo;
import com.fincatto.nfe200.classes.NFNotaInfoItemModalidadeBCICMSST;
import com.fincatto.nfe200.classes.NFOrigem;
import com.fincatto.nfe200.classes.NFUnidadeFederativa;

public class NFNotaInfoItemImpostoICMSPartilha extends NFBase {
    @Element(name = "orig", required = true)
    private NFOrigem origem;

    @Element(name = "CST", required = true)
    private String codigoSituacaoTributaria;

    @Element(name = "modBC", required = true)
    private NFNotaInfoItemImpostoICMSModalidadeBaseCalulo modalidadeBC;

    @Element(name = "vBC", required = true)
    private BigDecimal valorBC;

    @Element(name = "pRedBC", required = true)
    private BigDecimal percentualReducaoBC;

    @Element(name = "pICMS", required = true)
    private BigDecimal aliquota;

    @Element(name = "vICMS", required = true)
    private BigDecimal valorTributo;

    @Element(name = "modBCST", required = true)
    private NFNotaInfoItemModalidadeBCICMSST modalidadeDeterminacaoBCICMSST;

    @Element(name = "pMVAST", required = false)
    private BigDecimal percentualMargemValorAdicionadoICMSST;

    @Element(name = "pRedBCST", required = false)
    private BigDecimal percentualReducaoBCICMSST;

    @Element(name = "vBCST", required = true)
    private BigDecimal valorBCICMS;

    @Element(name = "pICMSST", required = true)
    private BigDecimal aliquotaImpostoICMSST;

    @Element(name = "vICMSST", required = true)
    private BigDecimal valorICMSST;

    @Element(name = "pBCOp", required = true)
    private BigDecimal percentualBCOperacaoPropria;

    public BigDecimal getValorBCICMS() {
        return this.valorBCICMS;
    }

    public void setValorBCICMS(final BigDecimal valorBCICMS) {
        this.valorBCICMS = valorBCICMS;
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

    public BigDecimal getPercentualBCOperacaoPropria() {
        return this.percentualBCOperacaoPropria;
    }

    public void setPercentualBCOperacaoPropria(final BigDecimal percentualBCOperacaoPropria) {
        this.percentualBCOperacaoPropria = percentualBCOperacaoPropria;
    }

    public NFUnidadeFederativa getUf() {
        return this.uf;
    }

    public void setUf(final NFUnidadeFederativa uf) {
        this.uf = uf;
    }

    @Element(name = "UFST", required = true)
    private NFUnidadeFederativa uf;

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

    public NFNotaInfoItemImpostoICMSModalidadeBaseCalulo getModalidadeBC() {
        return this.modalidadeBC;
    }

    public void setModalidadeBC(final NFNotaInfoItemImpostoICMSModalidadeBaseCalulo modalidadeBC) {
        this.modalidadeBC = modalidadeBC;
    }

    public BigDecimal getValorBC() {
        return this.valorBC;
    }

    public void setValorBC(final BigDecimal valorBC) {
        this.valorBC = valorBC;
    }

    public BigDecimal getPercentualReducaoBC() {
        return this.percentualReducaoBC;
    }

    public void setPercentualReducaoBC(final BigDecimal percentualReducaoBC) {
        this.percentualReducaoBC = percentualReducaoBC;
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

    public NFNotaInfoItemModalidadeBCICMSST getModalidadeDeterminacaoBCICMSST() {
        return this.modalidadeDeterminacaoBCICMSST;
    }

    public void setModalidadeDeterminacaoBCICMSST(final NFNotaInfoItemModalidadeBCICMSST modalidadeDeterminacaoBCICMSST) {
        this.modalidadeDeterminacaoBCICMSST = modalidadeDeterminacaoBCICMSST;
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
}