package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.classes.NFOrigem;

public class NFNotaInfoItemImpostoICMSSN101 extends NFBase {
    @Element(name = "orig", required = true)
    private NFOrigem origem;

    @Element(name = "CSOSN", required = true)
    private NFNotaSituacaoOperacionalSimplesNacional situacaoOperacaoSN;

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

    public NFNotaSituacaoOperacionalSimplesNacional getCodigoSituacaoOperacaoSN() {
        return this.situacaoOperacaoSN;
    }

    public void setCodigoSituacaoOperacaoSN(final NFNotaSituacaoOperacionalSimplesNacional codigoSituacaoOperacaoSN) {
        this.situacaoOperacaoSN = codigoSituacaoOperacaoSN;
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