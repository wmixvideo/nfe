/*
  NfeConsulta2CallbackHandler.java

  This file was auto-generated from WSDL
  by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.fincatto.documentofiscal.nfe310.webservices.nota.consulta;

import com.fincatto.documentofiscal.nfe310.webservices.nota.consulta.NfeConsulta2Stub.NfeConsultaNF2Result;

abstract class NfeConsulta2CallbackHandler {

    protected final Object clientData;
	
	public NfeConsulta2CallbackHandler(final Object clientData) {
		this.clientData = clientData;
	}
	
	public NfeConsulta2CallbackHandler() {
		this.clientData = null;
	}
	
	public Object getClientData() {
		return this.clientData;
	}
	
	public void receiveResultnfeConsultaNF2(final NfeConsultaNF2Result result) {
	}
	
	public void receiveErrornfeConsultaNF2(final Exception e) {
	}
}
