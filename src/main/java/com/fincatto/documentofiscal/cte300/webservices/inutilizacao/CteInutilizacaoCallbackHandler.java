package com.fincatto.documentofiscal.cte300.webservices.inutilizacao;

    /**
     *  CteInutilizacaoCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class CteInutilizacaoCallbackHandler{

        protected final Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public CteInutilizacaoCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public CteInutilizacaoCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for cteInutilizacaoCT method
            * override this method for handling normal response from cteInutilizacaoCT operation
            */
           public void receiveResultcteInutilizacaoCT(
                    com.fincatto.documentofiscal.cte300.webservices.inutilizacao.CteInutilizacaoStub.CteInutilizacaoCTResult result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from cteInutilizacaoCT operation
           */
            public void receiveErrorcteInutilizacaoCT(java.lang.Exception e) {
            }
                


    }
    