package com.fincatto.documentofiscal.nfe400.classes.lote.envio;

import com.fincatto.documentofiscal.DFBase;

public class NFLoteEnvioRetornoDados extends DFBase {

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
