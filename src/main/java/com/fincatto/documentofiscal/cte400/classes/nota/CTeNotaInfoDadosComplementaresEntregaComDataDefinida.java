package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte400.classes.CTTipoPrazoDataEntrega;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.time.LocalDate;

/**
 * Entrega com data definida
 */

@Root(name = "comData")
public class CTeNotaInfoDadosComplementaresEntregaComDataDefinida extends DFBase {
    private static final long serialVersionUID = -8805354006967261717L;

    @Element(name = "tpPer")
    private CTTipoPrazoDataEntrega tipoPrazoDataEntrega;
    
    @Element(name = "dProg")
    private LocalDate dataProgramada;

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
