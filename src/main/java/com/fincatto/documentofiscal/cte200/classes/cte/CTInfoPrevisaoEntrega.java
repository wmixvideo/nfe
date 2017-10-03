package com.fincatto.documentofiscal.cte200.classes.cte;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;

public class CTInfoPrevisaoEntrega extends DFBase {
    private static final long serialVersionUID = 1573994802260852308L;

    @Element(name = "semData", required = false)
    private CTInfoEntregaSemData semData;

    @Element(name = "comData", required = false)
    private CTInfoEntregaComData comData;

    @Element(name = "noPeriodo", required = false)
    private CTInfoEntregaNoPeriodo noPeriodo;

    @Element(name = "semHora", required = false)
    private CTInfoEntregaSemHora semHora;

    @Element(name = "comHora", required = false)
    private CTInfoEntregaComHora comHora;

    @Element(name = "noInter", required = false)
    private CTInfoEntregaNoInter noIntervalo;

    public CTInfoEntregaSemData getSemData() {
        return this.semData;
    }

    public void setSemData(final CTInfoEntregaSemData semData) {
        this.semData = semData;
    }

    public CTInfoEntregaComData getComData() {
        return this.comData;
    }

    public void setComData(final CTInfoEntregaComData comData) {
        this.comData = comData;
    }

    public CTInfoEntregaNoPeriodo getNoPeriodo() {
        return this.noPeriodo;
    }

    public void setNoPeriodo(final CTInfoEntregaNoPeriodo noPeriodo) {
        this.noPeriodo = noPeriodo;
    }

    public CTInfoEntregaSemHora getSemHora() {
        return this.semHora;
    }

    public void setSemHora(final CTInfoEntregaSemHora semHora) {
        this.semHora = semHora;
    }

    public CTInfoEntregaComHora getComHora() {
        return this.comHora;
    }

    public void setComHora(final CTInfoEntregaComHora comHora) {
        this.comHora = comHora;
    }

    public CTInfoEntregaNoInter getNoIntervalo() {
        return this.noIntervalo;
    }

    public void setNoIntervalo(final CTInfoEntregaNoInter noIntervalo) {
        this.noIntervalo = noIntervalo;
    }

}
