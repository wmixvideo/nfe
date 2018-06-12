package com.fincatto.documentofiscal.cte300.classes.enviolote;

public class CTeEnvioLoteRetornoDados {

    private final CTeEnvioLoteRetorno retorno;
    private final CTeEnvioLote loteAssinado;
	
	public CTeEnvioLoteRetornoDados(CTeEnvioLoteRetorno retorno, CTeEnvioLote loteAssinado) {
		this.retorno = retorno;
		this.loteAssinado = loteAssinado;
	}

	public CTeEnvioLoteRetorno getRetorno() {
		return retorno;
	}

	public CTeEnvioLote getLoteAssinado() {
		return loteAssinado;
	}
}
