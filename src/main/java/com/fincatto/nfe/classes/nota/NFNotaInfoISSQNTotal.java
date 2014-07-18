package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;

public class NFNotaInfoISSQNTotal extends NFBase {
    @Element(name = "vServ", required = false)
    private BigDecimal valorTotalServicosSobNaoIncidenciaNaoTributadosICMS;

    @Element(name = "vBC", required = false)
    private BigDecimal baseCalculoISS;

    @Element(name = "vISS", required = false)
    private BigDecimal valorTotalISS;

    @Element(name = "vPIS", required = false)
    private BigDecimal valorPISsobreServicos;

    @Element(name = "vCOFINS")
    private BigDecimal valorCOFINSsobreServicos;

    public BigDecimal getValorTotalServicosSobNaoIncidenciaNaoTributadosICMS() {
        return this.valorTotalServicosSobNaoIncidenciaNaoTributadosICMS;
    }

    public void setValorTotalServicosSobNaoIncidenciaNaoTributadosICMS(final BigDecimal valorTotalServicosSobNaoIncidenciaNaoTributadosICMS) {
        this.valorTotalServicosSobNaoIncidenciaNaoTributadosICMS = valorTotalServicosSobNaoIncidenciaNaoTributadosICMS;
    }

    public BigDecimal getBaseCalculoISS() {
        return this.baseCalculoISS;
    }

    public void setBaseCalculoISS(final BigDecimal baseCalculoISS) {
        this.baseCalculoISS = baseCalculoISS;
    }

    public BigDecimal getValorTotalISS() {
        return this.valorTotalISS;
    }

    public void setValorTotalISS(final BigDecimal valorTotalISS) {
        this.valorTotalISS = valorTotalISS;
    }

    public BigDecimal getValorPISsobreServicos() {
        return this.valorPISsobreServicos;
    }

    public void setValorPISsobreServicos(final BigDecimal valorPISsobreServicos) {
        this.valorPISsobreServicos = valorPISsobreServicos;
    }

    public BigDecimal getValorCOFINSsobreServicos() {
        return this.valorCOFINSsobreServicos;
    }

    public void setValorCOFINSsobreServicos(final BigDecimal valorCOFINSsobreServicos) {
        this.valorCOFINSsobreServicos = valorCOFINSsobreServicos;
    }
}