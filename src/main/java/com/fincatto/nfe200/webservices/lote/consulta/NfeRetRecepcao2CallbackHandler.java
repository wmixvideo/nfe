package com.fincatto.nfe200.webservices.lote.consulta;

abstract class NfeRetRecepcao2CallbackHandler {
	
	protected Object clientData;
	
	public NfeRetRecepcao2CallbackHandler(final Object clientData) {
		this.clientData = clientData;
	}
	
	public NfeRetRecepcao2CallbackHandler() {
		this.clientData = null;
	}
	
	public Object getClientData() {
		return this.clientData;
	}
	
	public void receiveResultnfeRetRecepcao2(final NfeRetRecepcao2Stub.NfeRetRecepcao2Result result) {
	}
	
	public void receiveErrornfeRetRecepcao2(final Exception e) {
	}
}
