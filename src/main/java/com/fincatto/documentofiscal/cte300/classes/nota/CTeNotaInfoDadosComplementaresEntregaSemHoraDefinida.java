package com.fincatto.documentofiscal.cte300.classes.nota;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.classes.CTTipoPrazoHoraEntrega;

/**
 * @author Caio
 * @info Entrega sem hora definida
 */

@Root(name = "semHora")
public class CTeNotaInfoDadosComplementaresEntregaSemHoraDefinida extends DFBase {
    private static final long serialVersionUID = 8715534516011562469L;

    @Element(name = "tpHor", required = true)
    private CTTipoPrazoHoraEntrega tipoPrazoHoraEntrega;

    public CTeNotaInfoDadosComplementaresEntregaSemHoraDefinida() {
        this.tipoPrazoHoraEntrega = null;
    }

    public CTTipoPrazoHoraEntrega getTipoPrazoHoraEntrega() {
        return this.tipoPrazoHoraEntrega;
    }

    /**
     * Tipo de hora<br>
     * 0 - Sem hora definida
     */
    public void setTipoPrazoHoraEntrega(final CTTipoPrazoHoraEntrega tipoPrazoHoraEntrega) {
        this.tipoPrazoHoraEntrega = tipoPrazoHoraEntrega;
    }
}
