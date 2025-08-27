package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte400.classes.CTTipoPrazoDataEntrega;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.time.LocalDate;

/**
 * Entrega no período definido
 */

@Root(name = "noPeriodo")
public class CTeNotaInfoDadosComplementaresEntregaPeriodo extends DFBase {
    private static final long serialVersionUID = 3083720713843691244L;

    @Element(name = "tpPer")
    private CTTipoPrazoDataEntrega tipoPrazoDataEntrega;
    
    @Element(name = "dIni")
    private LocalDate dataInicio;
    
    @Element(name = "dFim")
    private LocalDate dataFim;

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
