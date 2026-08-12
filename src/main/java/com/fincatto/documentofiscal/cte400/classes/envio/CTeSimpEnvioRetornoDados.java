package com.fincatto.documentofiscal.cte400.classes.envio;

import com.fincatto.documentofiscal.cte400.classes.simp.CTeNotaSimp;

public class CTeSimpEnvioRetornoDados {

    private final CTeSimpEnvioRetorno retorno;
    private final CTeNotaSimp loteAssinado;

    public CTeSimpEnvioRetornoDados(CTeSimpEnvioRetorno retorno, CTeNotaSimp loteAssinado) {
        this.retorno = retorno;
        this.loteAssinado = loteAssinado;
    }

    public CTeSimpEnvioRetorno getRetorno() {
        return retorno;
    }

    public CTeNotaSimp getLoteAssinado() {
        return loteAssinado;
    }
}
