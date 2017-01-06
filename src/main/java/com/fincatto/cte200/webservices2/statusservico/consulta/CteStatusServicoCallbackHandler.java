package com.fincatto.cte200.webservices2.statusservico.consulta;

abstract class CteStatusServicoCallbackHandler {

	protected Object clientData;

	public CteStatusServicoCallbackHandler(final Object clientData) {
		this.clientData = clientData;
	}

	public CteStatusServicoCallbackHandler() {
		this.clientData = null;
	}

	public Object getClientData() {
		return this.clientData;
	}

	public void receiveResultcteStatusServicoCT2(final CteStatusServicoStub.CteStatusServicoCT2Result result) {
	}

	public void receiveErrorcteStatusServicoCT2(final Exception e) {
	}
}