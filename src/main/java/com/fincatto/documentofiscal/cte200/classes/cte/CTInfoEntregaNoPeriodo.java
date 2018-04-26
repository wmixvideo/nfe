package com.fincatto.documentofiscal.cte200.classes.cte;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte200.classes.CTTipoEntregaData;
import org.simpleframework.xml.Element;

import java.time.LocalDate;

public class CTInfoEntregaNoPeriodo extends DFBase {
    private static final long serialVersionUID = 6342618887263922740L;

    @Element(name = "tpPer")
    private CTTipoEntregaData tipoPeriodo;

    @Element(name = "dIni")
    private LocalDate dataInicial;

    @Element(name = "dFim")
    private LocalDate dataFinal;

    public void setTipoPeriodo(final CTTipoEntregaData tipoPeriodo) {
        if (!CTTipoEntregaData.NO_PERIODO.equals(tipoPeriodo)) {
            throw new IllegalArgumentException("O tipo de per\u00edodo programado para entrega deve ser no periodo");
        }
        this.tipoPeriodo = tipoPeriodo;
    }

    public LocalDate getDataInicial() {
        return this.dataInicial;
    }

    public void setDataInicial(final LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }

    public LocalDate getDataFinal() {
        return this.dataFinal;
    }

    public void setDataFinal(final LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public CTTipoEntregaData getTipoPeriodo() {
        return this.tipoPeriodo;
    }

}
