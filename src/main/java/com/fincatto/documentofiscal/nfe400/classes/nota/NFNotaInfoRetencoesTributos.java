package com.fincatto.documentofiscal.nfe400.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;

public class NFNotaInfoRetencoesTributos extends DFBase {
    private static final long serialVersionUID = 8153484835418045075L;

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
        this.valorRetidoPIS = BigDecimalParser.tamanho15Com2CasasDecimais(valorRetidoPIS, "Valor Retido PIS");
    }

    public void setValorRetidoCOFINS(final BigDecimal valorRetidoCOFINS) {
        this.valorRetidoCOFINS = BigDecimalParser.tamanho15Com2CasasDecimais(valorRetidoCOFINS, "Valor Retido COFINS");
    }

    public void setValorRetidoCSLL(final BigDecimal valorRetidoCSLL) {
        this.valorRetidoCSLL = BigDecimalParser.tamanho15Com2CasasDecimais(valorRetidoCSLL, "Valor Retido CSLL");
    }

    public void setBaseCalculoIRRF(final BigDecimal baseCalculoIRRF) {
        this.baseCalculoIRRF = BigDecimalParser.tamanho15Com2CasasDecimais(baseCalculoIRRF, "BC IRRF Retencao Tributos");
    }

    public void setValorRetidoIRRF(final BigDecimal valorRetidoIRRF) {
        this.valorRetidoIRRF = BigDecimalParser.tamanho15Com2CasasDecimais(valorRetidoIRRF, "Valor Retido IRRF");
    }

    public void setBaseCalculoRetencaoPrevidenciaSocial(final BigDecimal baseCalculoRetencaoPrevidenciaSocial) {
        this.baseCalculoRetencaoPrevidenciaSocial = BigDecimalParser.tamanho15Com2CasasDecimais(baseCalculoRetencaoPrevidenciaSocial, "BC Retencao Previdencia Social");
    }

    public void setValorRetencaoPrevidenciaSocial(final BigDecimal valorRetencaoPrevidenciaSocial) {
        this.valorRetencaoPrevidenciaSocial = BigDecimalParser.tamanho15Com2CasasDecimais(valorRetencaoPrevidenciaSocial, "Valor Retencao Previdencia Social");
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