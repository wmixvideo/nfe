/*
  NfeConsultaCallbackHandler.java

  This file was auto-generated from WSDL
  by the Apache Axis2 version: 1.7.4  Built on : Oct 21, 2016 (10:47:34 BST)
 */
package com.fincatto.documentofiscal.nfe310.webservices.nota.consulta;


/**
 *  NfeConsultaCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class NfeConsultaCallbackHandler {
    protected final Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public NfeConsultaCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public NfeConsultaCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for nfeConsultaNF method
     * override this method for handling normal response from nfeConsultaNF operation
     */
    public void receiveResultnfeConsultaNF(
    		com.fincatto.documentofiscal.nfe310.webservices.nota.consulta.NfeConsultaStub.NfeConsultaNFResult result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from nfeConsultaNF operation
     */
    public void receiveErrornfeConsultaNF(java.lang.Exception e) {
    }
}
