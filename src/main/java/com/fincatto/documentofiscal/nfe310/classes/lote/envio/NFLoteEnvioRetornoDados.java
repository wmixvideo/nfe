package com.fincatto.documentofiscal.nfe310.classes.lote.envio;

public class NFLoteEnvioRetornoDados {

	private NFLoteEnvioRetorno retorno;
	private NFLoteEnvio loteAssinado;
	
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
