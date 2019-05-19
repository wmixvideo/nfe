package com.fincatto.documentofiscal.nfe400.classes.lote.envio;

import com.fincatto.documentofiscal.DFBase;
import org.simpleframework.xml.Element;

public class NFLoteEnvioRetornoRecebimentoInfo extends DFBase {
    private static final long serialVersionUID = -7792241080891283618L;
    
    @Element(name = "nRec")
    private String recibo;
    
    @Element(name = "tMed")
    private String tempoMedio;

    public NFLoteEnvioRetornoRecebimentoInfo() {
        this.recibo = null;
        this.tempoMedio = null;
    }

    public String getRecibo() {
        return this.recibo;
    }

    public void setRecibo(final String recibo) {
        this.recibo = recibo;
    }

    public String getTempoMedio() {
        return this.tempoMedio;
    }

    public void setTempoMedio(final String tempoMedio) {
        this.tempoMedio = tempoMedio;
    }
}