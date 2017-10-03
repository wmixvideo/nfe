package com.fincatto.documentofiscal.cte300.classes.nota;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;

/**
 * @author Caio
 * @info Informações ref. a previsão de entrega
 */

@Root(name = "Entrega")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoDadosComplementaresEntrega extends DFBase {
    private static final long serialVersionUID = 725664528185844572L;

    @Element(name = "semData", required = false)
    private CTeNotaInfoDadosComplementaresEntregaSemDataDefinida entregaSemDataDefinida;

    @Element(name = "comData", required = false)
    private CTeNotaInfoDadosComplementaresEntregaComDataDefinida entregaComDataDefinida;

    @Element(name = "noPeriodo", required = false)
    private CTeNotaInfoDadosComplementaresEntregaPeriodo entregaComPeriodoDefinido;

    @Element(name = "semHora", required = false)
    private CTeNotaInfoDadosComplementaresEntregaSemHoraDefinida entregaSemHoraDefinida;

    @Element(name = "comHora", required = false)
    private CTeNotaInfoDadosComplementaresEntregaComHoraDefinida entregaComHoraDefinida;

    @Element(name = "noInter", required = false)
    private CTeNotaInfoDadosComplementaresEntregaIntervalo entregaIntervalo;

    public CTeNotaInfoDadosComplementaresEntrega() {
        this.entregaSemDataDefinida = null;
        this.entregaComDataDefinida = null;
        this.entregaComPeriodoDefinido = null;
        this.entregaSemHoraDefinida = null;
        this.entregaComHoraDefinida = null;
        this.entregaIntervalo = null;
    }

    public CTeNotaInfoDadosComplementaresEntregaSemDataDefinida getEntregaSemDataDefinida() {
        return this.entregaSemDataDefinida;
    }

    /**
     * Entrega sem data definida<br>
     * Esta opção é proibida para o modal aéreo.
     */
    public void setEntregaSemDataDefinida(final CTeNotaInfoDadosComplementaresEntregaSemDataDefinida entregaSemDataDefinida) {
        this.entregaSemDataDefinida = entregaSemDataDefinida;
    }

    public CTeNotaInfoDadosComplementaresEntregaComDataDefinida getEntregaComDataDefinida() {
        return this.entregaComDataDefinida;
    }

    /**
     * Entrega com data definida
     */
    public void setEntregaComDataDefinida(final CTeNotaInfoDadosComplementaresEntregaComDataDefinida entregaComDataDefinida) {
        this.entregaComDataDefinida = entregaComDataDefinida;
    }

    public CTeNotaInfoDadosComplementaresEntregaPeriodo getEntregaComPeriodoDefinido() {
        return this.entregaComPeriodoDefinido;
    }

    /**
     * Entrega no período definido
     */
    public void setEntregaComPeriodoDefinido(final CTeNotaInfoDadosComplementaresEntregaPeriodo entregaComPeriodoDefinido) {
        this.entregaComPeriodoDefinido = entregaComPeriodoDefinido;
    }

    public CTeNotaInfoDadosComplementaresEntregaSemHoraDefinida getEntregaSemHoraDefinida() {
        return this.entregaSemHoraDefinida;
    }

    /**
     * Entrega sem hora definida
     */
    public void setEntregaSemHoraDefinida(final CTeNotaInfoDadosComplementaresEntregaSemHoraDefinida entregaSemHoraDefinida) {
        this.entregaSemHoraDefinida = entregaSemHoraDefinida;
    }

    public CTeNotaInfoDadosComplementaresEntregaComHoraDefinida getEntregaComHoraDefinida() {
        return this.entregaComHoraDefinida;
    }

    /**
     * Entrega com hora definida
     */
    public void setEntregaComHoraDefinida(final CTeNotaInfoDadosComplementaresEntregaComHoraDefinida entregaComHoraDefinida) {
        this.entregaComHoraDefinida = entregaComHoraDefinida;
    }

    public CTeNotaInfoDadosComplementaresEntregaIntervalo getEntregaIntervalo() {
        return this.entregaIntervalo;
    }

    /**
     * Entrega no intervalo de horário definido
     */
    public void setEntregaIntervalo(final CTeNotaInfoDadosComplementaresEntregaIntervalo entregaIntervalo) {
        this.entregaIntervalo = entregaIntervalo;
    }
}
