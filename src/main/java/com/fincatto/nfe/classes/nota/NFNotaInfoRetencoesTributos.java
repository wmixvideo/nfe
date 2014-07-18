package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;

public class NFNotaInfoRetencoesTributos extends NFBase {
    @Element(name = "vRetPIS", required = false)
    private BigDecimal valorRetidoPIS;

    @Element(name = "vRetCOFINS", required = false)
    private BigDecimal valorRetidoCOFINS;

    @Element(name = "vRetCSLL", required = false)
    private BigDecimal valorRetidoCSLL;

    @Element(name = "vBCIRRF", required = false)
    private BigDecimal baseCalculoIRRF;

    @Element(name = "vIRRF", required = false)
    private BigDecimal valorRetidoIRRF;

    @Element(name = "vBCRetPrev", required = false)
    private BigDecimal baseCalculoRetencaoPrevidenciaSocial;

    @Element(name = "vRetPrev", required = false)
    private BigDecimal valorRetencaoPrevidenciaSocial;

    public BigDecimal getValorRetidoPIS() {
        return this.valorRetidoPIS;
    }

    public void setValorRetidoPIS(final BigDecimal valorRetidoPIS) {
        this.valorRetidoPIS = valorRetidoPIS;
    }

    public BigDecimal getValorRetidoCOFINS() {
        return this.valorRetidoCOFINS;
    }

    public void setValorRetidoCOFINS(final BigDecimal valorRetidoCOFINS) {
        this.valorRetidoCOFINS = valorRetidoCOFINS;
    }

    public BigDecimal getValorRetidoCSLL() {
        return this.valorRetidoCSLL;
    }

    public void setValorRetidoCSLL(final BigDecimal valorRetidoCSLL) {
        this.valorRetidoCSLL = valorRetidoCSLL;
    }

    public BigDecimal getBaseCalculoIRRF() {
        return this.baseCalculoIRRF;
    }

    public void setBaseCalculoIRRF(final BigDecimal baseCalculoIRRF) {
        this.baseCalculoIRRF = baseCalculoIRRF;
    }

    public BigDecimal getValorRetidoIRRF() {
        return this.valorRetidoIRRF;
    }

    public void setValorRetidoIRRF(final BigDecimal valorRetidoIRRF) {
        this.valorRetidoIRRF = valorRetidoIRRF;
    }

    public BigDecimal getBaseCalculoRetencaoPrevidenciaSocial() {
        return this.baseCalculoRetencaoPrevidenciaSocial;
    }

    public void setBaseCalculoRetencaoPrevidenciaSocial(final BigDecimal baseCalculoRetencaoPrevidenciaSocial) {
        this.baseCalculoRetencaoPrevidenciaSocial = baseCalculoRetencaoPrevidenciaSocial;
    }

    public BigDecimal getValorRetencaoPrevidenciaSocial() {
        return this.valorRetencaoPrevidenciaSocial;
    }

    public void setValorRetencaoPrevidenciaSocial(final BigDecimal valorRetencaoPrevidenciaSocial) {
        this.valorRetencaoPrevidenciaSocial = valorRetencaoPrevidenciaSocial;
    }
}