package com.fincatto.documentofiscal.cte200.classes.cte;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte200.classes.CTTipoEntregaData;

public class CTInfoEntregaSemData extends DFBase {

    @Element(name = "tpPer")
    private CTTipoEntregaData tipoPeriodo;

    public void setTipoPeriodo(final CTTipoEntregaData tipoPeriodo) {
        if (!CTTipoEntregaData.SEM_DATA.equals(tipoPeriodo)) {
            throw new IllegalArgumentException("O tipo de per\u00edodo programado para entrega deve ser sem data");
        }
        this.tipoPeriodo = tipoPeriodo;
    }

    public CTTipoEntregaData getTipoPeriodo() {
        return this.tipoPeriodo;
    }
}
