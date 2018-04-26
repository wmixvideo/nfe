package com.fincatto.documentofiscal.cte300.classes.nota;

import java.time.LocalDate;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte300.classes.CTTipoPrazoDataEntrega;

/**
 * @author Caio
 * @info Entrega com data definida
 */

@Root(name = "comData")
public class CTeNotaInfoDadosComplementaresEntregaComDataDefinida extends DFBase {
    private static final long serialVersionUID = -2993904878236899549L;

    @Element(name = "tpPer", required = true)
    private CTTipoPrazoDataEntrega tipoPrazoDataEntrega;

    @Element(name = "dProg", required = true)
    private LocalDate dataProgramada;

    public CTeNotaInfoDadosComplementaresEntregaComDataDefinida() {
        this.tipoPrazoDataEntrega = null;
        this.dataProgramada = null;
    }

    public CTTipoPrazoDataEntrega getTipoPrazoDataEntrega() {
        return this.tipoPrazoDataEntrega;
    }

    /**
     * Tipo de data/período programado para entrega<br>
     * Preencher com:<br>
     * 1-Na data;<br>
     * 2-Até a data;<br>
     * 3-A partir da data
     */
    public void setTipoPrazoDataEntrega(final CTTipoPrazoDataEntrega tipoPrazoDataEntrega) {
        this.tipoPrazoDataEntrega = tipoPrazoDataEntrega;
    }

    public LocalDate getDataProgramada() {
        return this.dataProgramada;
    }

    /**
     * Data programada<br>
     * Formato AAAA-MM-DD
     */
    public void setDataProgramada(final LocalDate dataProgramada) {
        this.dataProgramada = dataProgramada;
    }
}
