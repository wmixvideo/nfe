package com.fincatto.nfe.classes.lote.envio.recibo;

import org.simpleframework.xml.Element;

public class TRetEnviNFeInfRec {

	@Element(name = "nRec", required = true)
	private String recibo;

	@Element(name = "tMed", required = true)
	private String tempoMedio;

	public TRetEnviNFeInfRec() {
		this.recibo = null;
		this.tempoMedio = null;
	}

	public String getRecibo() {
		return recibo;
	}

	public void setRecibo(String recibo) {
		this.recibo = recibo;
	}

	public String getTempoMedio() {
		return tempoMedio;
	}

	public void setTempoMedio(String tempoMedio) {
		this.tempoMedio = tempoMedio;
	}
}