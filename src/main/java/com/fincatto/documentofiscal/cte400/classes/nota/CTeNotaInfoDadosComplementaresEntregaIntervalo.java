package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte400.classes.CTTipoPrazoHoraEntrega;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.time.LocalTime;

/**
 * Entrega no intervalo de horário definido
 */

@Root(name = "noInter")
public class CTeNotaInfoDadosComplementaresEntregaIntervalo extends DFBase {
    private static final long serialVersionUID = 1050853066408862626L;

    @Element(name = "tpHor")
    private CTTipoPrazoHoraEntrega tipoPrazoHoraEntrega;
    
    @Element(name = "hIni")
    private LocalTime horaInicio;
    
    @Element(name = "hFim")
    private LocalTime horaFim;

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
