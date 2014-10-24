package com.fincatto.nfe310.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.validadores.BigDecimalParser;

public class NFNotaInfoRetencoesTributos extends NFBase {
    @Element(name = "vRetPIS", required = false)
    private String valorRetidoPIS;

    @Element(name = "vRetCOFINS", required = false)
    private String valorRetidoCOFINS;

    @Element(name = "vRetCSLL", required = false)
    private String valorRetidoCSLL;

    @Element(name = "vBCIRRF", required = false)
    private String baseCalculoIRRF;

    @Element(name = "vIRRF", required = false)
    private String valorRetidoIRRF;

    @Element(name = "vBCRetPrev", required = false)
    private String baseCalculoRetencaoPrevidenciaSocial;

    @Element(name = "vRetPrev", required = false)
    private String valorRetencaoPrevidenciaSocial;

    public void setValorRetidoPIS(final BigDecimal valorRetidoPIS) {
        this.valorRetidoPIS = BigDecimalParser.tamanho15Com2CasasDecimais(valorRetidoPIS);
    }

    public void setValorRetidoCOFINS(final BigDecimal valorRetidoCOFINS) {
        this.valorRetidoCOFINS = BigDecimalParser.tamanho15Com2CasasDecimais(valorRetidoCOFINS);
    }

    public void setValorRetidoCSLL(final BigDecimal valorRetidoCSLL) {
        this.valorRetidoCSLL = BigDecimalParser.tamanho15Com2CasasDecimais(valorRetidoCSLL);
    }

    public void setBaseCalculoIRRF(final BigDecimal baseCalculoIRRF) {
        this.baseCalculoIRRF = BigDecimalParser.tamanho15Com2CasasDecimais(baseCalculoIRRF);
    }

    public void setValorRetidoIRRF(final BigDecimal valorRetidoIRRF) {
        this.valorRetidoIRRF = BigDecimalParser.tamanho15Com2CasasDecimais(valorRetidoIRRF);
    }

    public void setBaseCalculoRetencaoPrevidenciaSocial(final BigDecimal baseCalculoRetencaoPrevidenciaSocial) {
        this.baseCalculoRetencaoPrevidenciaSocial = BigDecimalParser.tamanho15Com2CasasDecimais(baseCalculoRetencaoPrevidenciaSocial);
    }

    public void setValorRetencaoPrevidenciaSocial(final BigDecimal valorRetencaoPrevidenciaSocial) {
        this.valorRetencaoPrevidenciaSocial = BigDecimalParser.tamanho15Com2CasasDecimais(valorRetencaoPrevidenciaSocial);
    }

    public String getValorRetidoPIS() {
        return this.valorRetidoPIS;
    }

    public String getValorRetidoCOFINS() {
        return this.valorRetidoCOFINS;
    }

    public String getValorRetidoCSLL() {
        return this.valorRetidoCSLL;
    }

    public String getBaseCalculoIRRF() {
        return this.baseCalculoIRRF;
    }

    public String getValorRetidoIRRF() {
        return this.valorRetidoIRRF;
    }

    public String getBaseCalculoRetencaoPrevidenciaSocial() {
        return this.baseCalculoRetencaoPrevidenciaSocial;
    }

    public String getValorRetencaoPrevidenciaSocial() {
        return this.valorRetencaoPrevidenciaSocial;
    }
}