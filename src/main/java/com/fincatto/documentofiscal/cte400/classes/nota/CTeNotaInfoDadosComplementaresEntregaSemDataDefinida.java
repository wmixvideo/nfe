package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte400.classes.CTTipoPrazoDataEntrega;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Entrega sem data definida<br>
 *       Esta opção é proibida para o modal aéreo.
 */

@Root(name = "semData")
public class CTeNotaInfoDadosComplementaresEntregaSemDataDefinida extends DFBase {
    private static final long serialVersionUID = 1360672619291000662L;

    @Element(name = "tpPer")
    private CTTipoPrazoDataEntrega tipoPrazoDataEntrega;

    public CTTipoPrazoDataEntrega getTipoPrazoDataEntrega() {
        return this.tipoPrazoDataEntrega;
    }

    /**
     * Tipo de data/período programado para entrega<br>
     * 0 - Sem data definida
     */
    public void setTipoPrazoDataEntrega(final CTTipoPrazoDataEntrega tipoPrazoDataEntrega) {
        this.tipoPrazoDataEntrega = tipoPrazoDataEntrega;
    }
}
