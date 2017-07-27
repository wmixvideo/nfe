package com.fincatto.nfe310.classes.lote.envio;

import com.fincatto.nfe310.classes.NFBase;

public class NFLoteEnvioRetornoDados extends NFBase {

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
