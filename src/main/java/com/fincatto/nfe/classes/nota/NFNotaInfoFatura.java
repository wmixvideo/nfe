package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.validadores.StringValidador;

public class NFNotaInfoFatura extends NFBase {
    @Element(name = "nFat", required = false)
    private String numeroFatura;

    @Element(name = "vOrig", required = false)
    private BigDecimal valorOriginalFatura;

    @Element(name = "vDesc", required = false)
    private BigDecimal valorDesconto;

    @Element(name = "vLiq", required = false)
    private BigDecimal valorLiquidoFatura;

    public String getNumeroFatura() {
        return this.numeroFatura;
    }

    public void setNumeroFatura(final String numeroFatura) {
        StringValidador.tamanho60(numeroFatura);
        this.numeroFatura = numeroFatura;
    }

    public BigDecimal getValorOriginalFatura() {
        return this.valorOriginalFatura;
    }

    public void setValorOriginalFatura(final BigDecimal valorOriginalFatura) {
        this.valorOriginalFatura = valorOriginalFatura;
    }

    public BigDecimal getValorDesconto() {
        return this.valorDesconto;
    }

    public void setValorDesconto(final BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public BigDecimal getValorLiquidoFatura() {
        return this.valorLiquidoFatura;
    }

    public void setValorLiquidoFatura(final BigDecimal valorLiquidoFatura) {
        this.valorLiquidoFatura = valorLiquidoFatura;
    }
}