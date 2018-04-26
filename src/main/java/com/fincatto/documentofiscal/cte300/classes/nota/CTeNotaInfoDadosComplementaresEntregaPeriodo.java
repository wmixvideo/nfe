package com.fincatto.documentofiscal.cte300.classes.nota;

import java.time.LocalDate;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.classes.CTTipoPrazoDataEntrega;

/**
 * @author Caio
 * @info Entrega no período definido
 */

@Root(name = "noPeriodo")
public class CTeNotaInfoDadosComplementaresEntregaPeriodo extends DFBase {
    private static final long serialVersionUID = 6194788171489727124L;

    @Element(name = "tpPer", required = true)
    private CTTipoPrazoDataEntrega tipoPrazoDataEntrega;

    @Element(name = "dIni", required = true)
    private LocalDate dataInicio;

    @Element(name = "dFim", required = true)
    private LocalDate dataFim;

    public CTeNotaInfoDadosComplementaresEntregaPeriodo() {
        this.tipoPrazoDataEntrega = null;
        this.dataInicio = null;
        this.dataFim = null;
    }

    public CTTipoPrazoDataEntrega getTipoPrazoDataEntrega() {
        return this.tipoPrazoDataEntrega;
    }

    /**
     * Tipo período<br>
     * 4 - no período
     */
    public void setTipoPrazoDataEntrega(final CTTipoPrazoDataEntrega tipoPrazoDataEntrega) {
        this.tipoPrazoDataEntrega = tipoPrazoDataEntrega;
    }

    public LocalDate getDataInicio() {
        return this.dataInicio;
    }

    /**
     * Data inicial<br>
     * Formato AAAA-MM-DD
     */
    public void setDataInicio(final LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return this.dataFim;
    }

    /**
     * Data inicial<br>
     * Formato AAAA-MM-DD
     */
    public void setDataFim(final LocalDate dataFim) {
        this.dataFim = dataFim;
    }
}
