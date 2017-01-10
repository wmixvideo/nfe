package com.fincatto.cte200.webservices.statusservico.consulta;

abstract class CteStatusServico2CallbackHandler {

	protected Object clientData;

	public CteStatusServico2CallbackHandler(final Object clientData) {
		this.clientData = clientData;
	}

	public CteStatusServico2CallbackHandler() {
		this.clientData = null;
	}

	public Object getClientData() {
		return this.clientData;
	}

	public void receiveResultcteStatusServicoCT2(final CteStatusServico2Stub.CteStatusServicoCT2Result result) {
	}

	public void receiveErrorcteStatusServicoCT2(final Exception e) {
	}
}