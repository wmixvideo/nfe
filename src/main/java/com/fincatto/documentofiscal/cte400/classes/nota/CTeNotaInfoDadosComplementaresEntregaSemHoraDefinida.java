package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte400.classes.CTTipoPrazoHoraEntrega;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Entrega sem hora definida
 */

@Root(name = "semHora")
public class CTeNotaInfoDadosComplementaresEntregaSemHoraDefinida extends DFBase {
    private static final long serialVersionUID = -3108290836019992950L;

    @Element(name = "tpHor")
    private CTTipoPrazoHoraEntrega tipoPrazoHoraEntrega;

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
