package com.fincatto.nfe310.classes.lote.envio;

public class NFLoteEnvioRetornoAssinado {

	private NFLoteEnvioRetorno retorno;
	private NFLoteEnvio loteAssinado;
	
	public NFLoteEnvioRetornoAssinado(NFLoteEnvioRetorno retorno, NFLoteEnvio loteAssinado) {
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
