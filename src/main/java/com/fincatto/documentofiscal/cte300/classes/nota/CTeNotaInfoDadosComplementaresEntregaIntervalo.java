package com.fincatto.documentofiscal.cte300.classes.nota;

import org.joda.time.LocalTime;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.classes.CTTipoPrazoHoraEntrega;

/**
 * @author Caio
 * @info Entrega no intervalo de horário definido
 */

@Root(name = "noInter")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoDadosComplementaresEntregaIntervalo extends DFBase {
    private static final long serialVersionUID = 733372678080043594L;

    @Element(name = "tpHor", required = true)
    private CTTipoPrazoHoraEntrega tipoPrazoHoraEntrega;

    @Element(name = "hIni", required = true)
    private LocalTime horaInicio;

    @Element(name = "hFim", required = true)
    private LocalTime horaFim;

    public CTeNotaInfoDadosComplementaresEntregaIntervalo() {
        this.tipoPrazoHoraEntrega = null;
        this.horaInicio = null;
        this.horaFim = null;
    }

    public CTTipoPrazoHoraEntrega getTipoPrazoHoraEntrega() {
        return this.tipoPrazoHoraEntrega;
    }

    /**
     * Tipo de hora<br>
     * 4 - No intervalo de tempo
     */
    public void setTipoPrazoHoraEntrega(final CTTipoPrazoHoraEntrega tipoPrazoHoraEntrega) {
        this.tipoPrazoHoraEntrega = tipoPrazoHoraEntrega;
    }

    public LocalTime getHoraInicio() {
        return this.horaInicio;
    }

    /**
     * Hora inicial<br>
     * Formato HH:MM:SS
     */
    public void setHoraInicio(final LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFim() {
        return this.horaFim;
    }

    /**
     * Hora final<br>
     * Formato HH:MM:SS
     */
    public void setHoraFim(final LocalTime horaFim) {
        this.horaFim = horaFim;
    }
}
