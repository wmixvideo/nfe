package com.fincatto.nfe200.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe200.classes.NFBase;
import com.fincatto.nfe200.classes.NFNotaInfoItemModalidadeBCICMSST;
import com.fincatto.nfe200.classes.NFNotaSituacaoOperacionalSimplesNacional;
import com.fincatto.nfe200.classes.NFOrigem;
import com.fincatto.nfe200.validadores.BigDecimalParser;

public class NFNotaInfoItemImpostoICMSSN201 extends NFBase {
    @Element(name = "orig", required = true)
    private NFOrigem origem;

    @Element(name = "CSOSN", required = true)
    private NFNotaSituacaoOperacionalSimplesNacional situacaoOperacaoSN;

    @Element(name = "modBCST", required = true)
    private NFNotaInfoItemModalidadeBCICMSST modalidadeDeterminacaoBCICMSST;

    @Element(name = "pMVAST", required = false)
    private String percentualMargemValorAdicionadoICMSST;

    @Element(name = "pRedBCST", required = false)
    private String percentualReducaoBCICMSST;

    @Element(name = "vBCST", required = true)
    private String valorBCICMSST;

    @Element(name = "pICMSST", required = true)
    private String percentualAliquotaImpostoICMSST;

    @Element(name = "vICMSST", required = true)
    private String valorICMSST;

    @Element(name = "pCredSN", required = true)
    private String percentualAliquotaAplicavelCalculoCreditoSN;

    @Element(name = "vCredICMSSN", required = true)
    private String valorCreditoICMSSN;

    public void setOrigem(final NFOrigem origem) {
        this.origem = origem;
    }

    public void setSituacaoOperacaoSN(final NFNotaSituacaoOperacionalSimplesNacional situacaoOperacaoSN) {
        this.situacaoOperacaoSN = situacaoOperacaoSN;
    }

    public void setModalidadeDeterminacaoBCICMSST(final NFNotaInfoItemModalidadeBCICMSST modalidadeDeterminacaoBCICMSST) {
        this.modalidadeDeterminacaoBCICMSST = modalidadeDeterminacaoBCICMSST;
    }

    public void setPercentualMargemValorAdicionadoICMSST(final BigDecimal percentualMargemValorAdicionadoICMSST) {
        this.percentualMargemValorAdicionadoICMSST = BigDecimalParser.tamanho5Com2CasasDecimais(percentualMargemValorAdicionadoICMSST);
    }

    public void setPercentualReducaoBCICMSST(final BigDecimal percentualReducaoBCICMSST) {
        this.percentualReducaoBCICMSST = BigDecimalParser.tamanho5Com2CasasDecimais(percentualReducaoBCICMSST);
    }

    public void setValorBCICMSST(final BigDecimal valorBCICMSST) {
        this.valorBCICMSST = BigDecimalParser.tamanho15Com2CasasDecimais(valorBCICMSST);
    }

    public void setPercentualAliquotaImpostoICMSST(final BigDecimal aliquotaImpostoICMSST) {
        this.percentualAliquotaImpostoICMSST = BigDecimalParser.tamanho5Com2CasasDecimais(aliquotaImpostoICMSST);
    }

    public void setValorICMSST(final BigDecimal valorICMSST) {
        this.valorICMSST = BigDecimalParser.tamanho15Com2CasasDecimais(valorICMSST);
    }

    public void setPercentualAliquotaAplicavelCalculoCreditoSN(final BigDecimal aliquotaAplicavelCalculoCreditoSN) {
        this.percentualAliquotaAplicavelCalculoCreditoSN = BigDecimalParser.tamanho5Com2CasasDecimais(aliquotaAplicavelCalculoCreditoSN);
    }

    public void setValorCreditoICMSSN(final BigDecimal valorCreditoICMSSN) {
        this.valorCreditoICMSSN = BigDecimalParser.tamanho15Com2CasasDecimais(valorCreditoICMSSN);
    }

    public NFOrigem getOrigem() {
        return this.origem;
    }

    public NFNotaSituacaoOperacionalSimplesNacional getSituacaoOperacaoSN() {
        return this.situacaoOperacaoSN;
    }

    public NFNotaInfoItemModalidadeBCICMSST getModalidadeDeterminacaoBCICMSST() {
        return this.modalidadeDeterminacaoBCICMSST;
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

    public String getPercentualAliquotaAplicavelCalculoCreditoSN() {
        return this.percentualAliquotaAplicavelCalculoCreditoSN;
    }

    public String getValorCreditoICMSSN() {
        return this.valorCreditoICMSSN;
    }
}