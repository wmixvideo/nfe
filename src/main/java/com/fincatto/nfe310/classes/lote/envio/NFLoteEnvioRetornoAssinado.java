package com.fincatto.nfe310.classes.lote.envio;

public class NFLoteEnvioRetornoAssinado {

	private NFLoteEnvioRetorno retorno;
	private String xmlAssinado;
	
	public NFLoteEnvioRetornoAssinado(NFLoteEnvioRetorno retorno, String xmlAssinado) {
		this.retorno = retorno;
		this.xmlAssinado = xmlAssinado;
	}

	public NFLoteEnvioRetorno getRetorno() {
		return retorno;
	}

	public String getXmlAssinado() {
		return xmlAssinado;
	}
	
}
