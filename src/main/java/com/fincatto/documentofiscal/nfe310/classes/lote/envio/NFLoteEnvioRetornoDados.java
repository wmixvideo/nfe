package com.fincatto.documentofiscal.nfe310.classes.lote.envio;

public class NFLoteEnvioRetornoDados {

    private final NFLoteEnvioRetorno retorno;
    private final NFLoteEnvio loteAssinado;
	
	public NFLoteEnvioRetornoDados(NFLoteEnvioRetorno retorno, NFLoteEnvio loteAssinado) {
		this.retorno = retorno;
		this.loteAssinado = loteAssinado;
	}

	public NFLoteEnvioRetorno getRetorno() {
		return retorno;
	}

	public NFLoteEnvio getLoteAssinado() {
		return loteAssinado;
	}
	
}
