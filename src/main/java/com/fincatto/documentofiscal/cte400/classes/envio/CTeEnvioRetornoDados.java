package com.fincatto.documentofiscal.cte400.classes.envio;

import com.fincatto.documentofiscal.cte400.classes.nota.CTeNota;

public class CTeEnvioRetornoDados {

    private final CTeEnvioRetorno retorno;
    private final CTeNota loteAssinado;
	
	public CTeEnvioRetornoDados(CTeEnvioRetorno retorno, CTeNota loteAssinado) {
		this.retorno = retorno;
		this.loteAssinado = loteAssinado;
	}

	public CTeEnvioRetorno getRetorno() {
		return retorno;
	}

	public CTeNota getLoteAssinado() {
		return loteAssinado;
	}
}
