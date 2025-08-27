package com.fincatto.documentofiscal.nfe400.webservices.consultacadastro;

public class MTCadConsultaCadastro4Stub extends org.apache.axis2.client.Stub {
    private static int counter = 0;
    protected org.apache.axis2.description.AxisOperation[] _operations;

    //hashmaps to keep the fault mapping
    private java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
    private java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
    private java.util.HashMap faultMessageMap = new java.util.HashMap();
    private javax.xml.namespace.QName[] opNameArray = null;

    /**
     * Constructor that takes in a configContext
     */
    public MTCadConsultaCadastro4Stub(org.apache.axis2.context.ConfigurationContext configurationContext, String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(configurationContext, targetEndpoint, false);
    }

    /**
     * Constructor that takes in a configContext  and useseperate listner
     */
    public MTCadConsultaCadastro4Stub(org.apache.axis2.context.ConfigurationContext configurationContext, String targetEndpoint, boolean useSeparateListener) throws org.apache.axis2.AxisFault {
        populateAxisService();
        populateFaults();

        _serviceClient = new org.apache.axis2.client.ServiceClient(configurationContext, _service);
        _serviceClient.getOptions().setTo(new org.apache.axis2.addressing.EndpointReference(targetEndpoint));
        _serviceClient.getOptions().setUseSeparateListener(useSeparateListener);
        //Set the soap version
        _serviceClient.getOptions().setSoapVersionURI(org.apache.axiom.soap.SOAP12Constants.SOAP_ENVELOPE_NAMESPACE_URI);
    }

    /**
     * Constructor taking the target endpoint
     */
    public MTCadConsultaCadastro4Stub(String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(null, targetEndpoint);
    }

    private static synchronized String getUniqueSuffix() {
        // reset the counter if it is greater than 99999
        if (counter > 99999) {
            counter = 0;
        }

        counter = counter + 1;

        return Long.toString(System.currentTimeMillis()) +
                "_" + counter;
    }

    private void populateAxisService() throws org.apache.axis2.AxisFault {
        //creating the Service with a unique name
        this._service = new org.apache.axis2.description.AxisService("CadConsultaCadastro4" + getUniqueSuffix());
        this.addAnonymousOperations();

        //creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        this._operations = new org.apache.axis2.description.AxisOperation[1];

        __operation = new org.apache.axis2.description.OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName("http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4","consultaCadastro"));
        this._service.addOperation(__operation);

        this._operations[0] = __operation;
    }

    //populates the faults
    private void populateFaults() {
    }

    public NfeResultMsg consultaCadastro(ConsultaCadastro consultaCadastro0) throws java.rmi.RemoteException {
        org.apache.axis2.context.MessageContext _messageContext = null;

        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
            _operationClient.getOptions().setAction("http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4/consultaCadastro");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = this.toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),consultaCadastro0,
                    optimizeContent(new javax.xml.namespace.QName("http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4","consultaCadastro")),
                    new javax.xml.namespace.QName("http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4","consultaCadastro"));

            //adding SOAP soap_headers
            this._serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            Object object = fromOM(_returnEnv.getBody()
                            .getFirstElement(),
                    NfeResultMsg.class);

            return (NfeResultMsg) object;
        } catch (org.apache.axis2.AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                        new org.apache.axis2.client.FaultMapKey(
                                faultElt.getQName(), "consultaCadastro"))) {
                    //make the fault by reflection
                    try {
                        String exceptionClassName = (String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(
                                faultElt.getQName(), "consultaCadastro"));
                        Class exceptionClass = Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        Exception ex = (Exception) constructor.newInstance(f.getMessage());

                        //message class
                        String messageClassName = (String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(
                                faultElt.getQName(), "consultaCadastro"));
                        Class messageClass = Class.forName(messageClassName);
                        Object messageObject = fromOM(faultElt,
                                messageClass);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new Class[]{messageClass});
                        m.invoke(ex, new Object[]{messageObject});

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                        .cleanup(_messageContext);
            }
        }
    }


//    public void startconsultaCadastro(
//            ConsultaCadastro consultaCadastro0,
//            final CadConsultaCadastro4CallbackHandler callback)
//            throws java.rmi.RemoteException {
//        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
//        _operationClient.getOptions()
//                .setAction("http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4/consultaCadastro");
//        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);
//
//        addPropertyToOperationClient(_operationClient,
//                org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
//                "&");
//
//        // create SOAP envelope with that payload
//        org.apache.axiom.soap.SOAPEnvelope env = null;
//        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();
//
//        //Style is Doc.
//        env = toEnvelope(getFactory(_operationClient.getOptions()
//                        .getSoapVersionURI()),
//                consultaCadastro0,
//                optimizeContent(
//                        new javax.xml.namespace.QName(
//                                "http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4",
//                                "consultaCadastro")),
//                new javax.xml.namespace.QName(
//                        "http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4",
//                        "consultaCadastro"));
//
//        // adding SOAP soap_headers
//        _serviceClient.addHeadersToEnvelope(env);
//        // create message context with that soap envelope
//        _messageContext.setEnvelope(env);
//
//        // add the message context to the operation client
//        _operationClient.addMessageContext(_messageContext);
//
//        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
//            public void onMessage(
//                    org.apache.axis2.context.MessageContext resultContext) {
//                try {
//                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
//
//                    Object object = fromOM(resultEnv.getBody()
//                                    .getFirstElement(),
//                            NfeResultMsg.class);
//                    callback.receiveResultconsultaCadastro((NfeResultMsg) object);
//                } catch (org.apache.axis2.AxisFault e) {
//                    callback.receiveErrorconsultaCadastro(e);
//                }
//            }
//
//            public void onError(Exception error) {
//                if (error instanceof org.apache.axis2.AxisFault) {
//                    org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
//                    org.apache.axiom.om.OMElement faultElt = f.getDetail();
//
//                    if (faultElt != null) {
//                        if (faultExceptionNameMap.containsKey(
//                                new org.apache.axis2.client.FaultMapKey(
//                                        faultElt.getQName(),
//                                        "consultaCadastro"))) {
//                            //make the fault by reflection
//                            try {
//                                String exceptionClassName = (String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(
//                                        faultElt.getQName(),
//                                        "consultaCadastro"));
//                                Class exceptionClass = Class.forName(exceptionClassName);
//                                java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
//                                Exception ex = (Exception) constructor.newInstance(f.getMessage());
//
//                                //message class
//                                String messageClassName = (String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(
//                                        faultElt.getQName(),
//                                        "consultaCadastro"));
//                                Class messageClass = Class.forName(messageClassName);
//                                Object messageObject = fromOM(faultElt,
//                                        messageClass);
//                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
//                                        new Class[]{messageClass});
//                                m.invoke(ex,
//                                        new Object[]{messageObject});
//
//                                callback.receiveErrorconsultaCadastro(new java.rmi.RemoteException(
//                                        ex.getMessage(), ex));
//                            } catch (ClassCastException e) {
//                                // we cannot intantiate the class - throw the original Axis fault
//                                callback.receiveErrorconsultaCadastro(f);
//                            } catch (ClassNotFoundException e) {
//                                // we cannot intantiate the class - throw the original Axis fault
//                                callback.receiveErrorconsultaCadastro(f);
//                            } catch (NoSuchMethodException e) {
//                                // we cannot intantiate the class - throw the original Axis fault
//                                callback.receiveErrorconsultaCadastro(f);
//                            } catch (java.lang.reflect.InvocationTargetException e) {
//                                // we cannot intantiate the class - throw the original Axis fault
//                                callback.receiveErrorconsultaCadastro(f);
//                            } catch (IllegalAccessException e) {
//                                // we cannot intantiate the class - throw the original Axis fault
//                                callback.receiveErrorconsultaCadastro(f);
//                            } catch (InstantiationException e) {
//                                // we cannot intantiate the class - throw the original Axis fault
//                                callback.receiveErrorconsultaCadastro(f);
//                            } catch (org.apache.axis2.AxisFault e) {
//                                // we cannot intantiate the class - throw the original Axis fault
//                                callback.receiveErrorconsultaCadastro(f);
//                            }
//                        } else {
//                            callback.receiveErrorconsultaCadastro(f);
//                        }
//                    } else {
//                        callback.receiveErrorconsultaCadastro(f);
//                    }
//                } else {
//                    callback.receiveErrorconsultaCadastro(error);
//                }
//            }
//
//            public void onFault(
//                    org.apache.axis2.context.MessageContext faultContext) {
//                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
//                onError(fault);
//            }
//
//            public void onComplete() {
//                try {
//                    _messageContext.getTransportOut().getSender()
//                            .cleanup(_messageContext);
//                } catch (org.apache.axis2.AxisFault axisFault) {
//                    callback.receiveErrorconsultaCadastro(axisFault);
//                }
//            }
//        });
//
//        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
//
//        if ((_operations[0].getMessageReceiver() == null) &&
//                _operationClient.getOptions().isUseSeparateListener()) {
//            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
//            _operations[0].setMessageReceiver(_callbackReceiver);
//        }
//
//        //execute the operation client
//        _operationClient.execute(false);
//    }

    private boolean optimizeContent(javax.xml.namespace.QName opName) {
        if (opNameArray == null) {
            return false;
        }

        for (int i = 0; i < opNameArray.length; i++) {
            if (opName.equals(opNameArray[i])) {
                return true;
            }
        }

        return false;
    }

    private org.apache.axiom.om.OMElement toOM(
            ConsultaCadastro param,
            boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(ConsultaCadastro.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
            NfeResultMsg param,
            boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(NfeResultMsg.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,ConsultaCadastro param,boolean optimizeContent, javax.xml.namespace.QName elementQName)throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild(param.getOMElement(ConsultaCadastro.MY_QNAME,factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    /* methods to provide back word compatibility */

    /**
     * get the default envelope
     */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory) {
        return factory.getDefaultEnvelope();
    }

    private Object fromOM(org.apache.axiom.om.OMElement param,
                          Class type) throws org.apache.axis2.AxisFault {
        try {
            if (ConsultaCadastro.class.equals(
                    type)) {
                return ConsultaCadastro.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (NfeResultMsg.class.equals(
                    type)) {
                return NfeResultMsg.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }
        } catch (Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

        return null;
    }

    public static class ExtensionMapper {
        public static Object getTypeObject(
                String namespaceURI, String typeName,
                javax.xml.stream.XMLStreamReader reader) throws Exception {
            if ("http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4".equals(
                    namespaceURI) && "nfeDadosMsg_type0".equals(typeName)) {
                return NfeDadosMsg_type0.Factory.parse(reader);
            }

            if ("http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4".equals(
                    namespaceURI) &&
                    "consultaCadastroResult_type0".equals(typeName)) {
                return ConsultaCadastroResult_type0.Factory.parse(reader);
            }

            throw new org.apache.axis2.databinding.ADBException(
                    "Unsupported type " + namespaceURI + " " + typeName);
        }
    }

    public static class NfeResultMsg implements org.apache.axis2.databinding.ADBBean {
        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4",
                "nfeResultMsg", "ns1");

        /**
         * field for ConsultaCadastroResult
         */
        protected ConsultaCadastroResult_type0 localConsultaCadastroResult;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localConsultaCadastroResultTracker = false;

        public boolean isConsultaCadastroResultSpecified() {
            return localConsultaCadastroResultTracker;
        }

        /**
         * Auto generated getter method
         *
         * @return ConsultaCadastroResult_type0
         */
        public ConsultaCadastroResult_type0 getConsultaCadastroResult() {
            return localConsultaCadastroResult;
        }

        /**
         * Auto generated setter method
         *
         * @param param ConsultaCadastroResult
         */
        public void setConsultaCadastroResult(
                ConsultaCadastroResult_type0 param) {
            localConsultaCadastroResultTracker = param != null;

            this.localConsultaCadastroResult = param;
        }

        /**
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory)
                throws org.apache.axis2.databinding.ADBException {
            return factory.createOMElement(new org.apache.axis2.databinding.ADBDataSource(
                    this, MY_QNAME));
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            String prefix = null;
            String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(),
                    xmlWriter);

            if (serializeType) {
                String namespacePrefix = registerPrefix(xmlWriter,
                        "http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4");

                if ((namespacePrefix != null) &&
                        (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":nfeResultMsg", xmlWriter);
                } else {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "nfeResultMsg", xmlWriter);
                }
            }

            if (localConsultaCadastroResultTracker) {
                if (localConsultaCadastroResult == null) {
                    throw new org.apache.axis2.databinding.ADBException(
                            "consultaCadastroResult cannot be null!!");
                }

                localConsultaCadastroResult.serialize(new javax.xml.namespace.QName(
                        "http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4",
                        "consultaCadastroResult"), xmlWriter);
            }

            xmlWriter.writeEndElement();
        }

        private static String generatePrefix(
                String namespace) {
            if (namespace.equals(
                    "http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4")) {
                return "ns1";
            }

            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(String prefix,
                                       String namespace, String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(String prefix,
                                    String namespace, String attName,
                                    String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeAttribute(writerPrefix, namespace, attName,
                        attValue);
            } else {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
                xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(String namespace,
                                    String attName, String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                xmlWriter.writeAttribute(registerPrefix(xmlWriter, namespace),
                        namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(String namespace,
                                         String attName, javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }

            String attributeValue;

            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(attributePrefix, namespace, attName,
                        attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();

            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);

                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            qname));
                }
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }

                    namespaceURI = qnames[i].getNamespaceURI();

                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);

                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":")
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                            qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                qnames[i]));
                    }
                }

                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        /**
         * Register a namespace prefix
         */
        private String registerPrefix(
                javax.xml.stream.XMLStreamWriter xmlWriter,
                String namespace)
                throws javax.xml.stream.XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();

                while (true) {
                    String uri = nsContext.getNamespaceURI(prefix);

                    if ((uri == null) || (uri.length() == 0)) {
                        break;
                    }

                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {
            private static org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(Factory.class);

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             * If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             * If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static NfeResultMsg parse(
                    javax.xml.stream.XMLStreamReader reader)
                    throws Exception {
                NfeResultMsg object = new NfeResultMsg();

                int event;
                javax.xml.namespace.QName currentQName = null;
                String nillableValue = null;
                String prefix = "";
                String namespaceuri = "";

                try {
                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    currentQName = reader.getName();

                    if (reader.getAttributeValue(
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type") != null) {
                        String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");

                        if (fullTypeName != null) {
                            String nsPrefix = null;

                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0,
                                        fullTypeName.indexOf(":"));
                            }

                            nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

                            String type = fullTypeName.substring(fullTypeName.indexOf(
                                    ":") + 1);

                            if (!"nfeResultMsg".equals(type)) {
                                //find namespace for the prefix
                                String nsUri = reader.getNamespaceContext()
                                        .getNamespaceURI(nsPrefix);

                                return (NfeResultMsg) ExtensionMapper.getTypeObject(nsUri,
                                        type, reader);
                            }
                        }
                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4",
                                    "consultaCadastroResult").equals(
                                    reader.getName())) ||
                            new javax.xml.namespace.QName("",
                                    "consultaCadastroResult").equals(
                                    reader.getName())) {
                        object.setConsultaCadastroResult(ConsultaCadastroResult_type0.Factory.parse(
                                reader));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()) {
                        // 2 - A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement " + reader.getName());
                    }
                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new Exception(e);
                }

                return object;
            }
        } //end of factory class
    }

    public static class ConsultaCadastroResult_type0 implements org.apache.axis2.databinding.ADBBean {

        /**
         * field for ExtraElement
         */
        protected org.apache.axiom.om.OMElement localExtraElement;

        /**
         * Auto generated getter method
         *
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getExtraElement() {
            return localExtraElement;
        }

        /**
         * Auto generated setter method
         *
         * @param param ExtraElement
         */
        public void setExtraElement(org.apache.axiom.om.OMElement param) {
            this.localExtraElement = param;
        }

        /**
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory)
                throws org.apache.axis2.databinding.ADBException {
            return factory.createOMElement(new org.apache.axis2.databinding.ADBDataSource(
                    this, parentQName));
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            String prefix = null;
            String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(),
                    xmlWriter);

            if (serializeType) {
                String namespacePrefix = registerPrefix(xmlWriter,
                        "http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4");

                if ((namespacePrefix != null) &&
                        (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":consultaCadastroResult_type0",
                            xmlWriter);
                } else {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "consultaCadastroResult_type0", xmlWriter);
                }
            }

            if (localExtraElement != null) {
                localExtraElement.serialize(xmlWriter);
            } else {
                throw new org.apache.axis2.databinding.ADBException(
                        "extraElement cannot be null!!");
            }

            xmlWriter.writeEndElement();
        }

        private static String generatePrefix(String namespace) {
            if (namespace.equals(
                    "http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4")) {
                return "ns1";
            }

            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(String prefix,
                                       String namespace, String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(String prefix,
                                    String namespace, String attName,
                                    String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeAttribute(writerPrefix, namespace, attName,
                        attValue);
            } else {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
                xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(String namespace,
                                    String attName, String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                xmlWriter.writeAttribute(registerPrefix(xmlWriter, namespace),
                        namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(String namespace,
                                         String attName, javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }

            String attributeValue;

            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(attributePrefix, namespace, attName,
                        attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();

            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);

                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            qname));
                }
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }

                    namespaceURI = qnames[i].getNamespaceURI();

                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);

                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":")
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                            qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                qnames[i]));
                    }
                }

                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        /**
         * Register a namespace prefix
         */
        private String registerPrefix(
                javax.xml.stream.XMLStreamWriter xmlWriter,
                String namespace)
                throws javax.xml.stream.XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();

                while (true) {
                    String uri = nsContext.getNamespaceURI(prefix);

                    if ((uri == null) || (uri.length() == 0)) {
                        break;
                    }

                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {
            private static org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(Factory.class);

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             * If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             * If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static ConsultaCadastroResult_type0 parse(
                    javax.xml.stream.XMLStreamReader reader)
                    throws Exception {
                ConsultaCadastroResult_type0 object = new ConsultaCadastroResult_type0();

                int event;
                javax.xml.namespace.QName currentQName = null;
                String nillableValue = null;
                String prefix = "";
                String namespaceuri = "";

                try {
                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    currentQName = reader.getName();

                    if (reader.getAttributeValue(
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type") != null) {
                        String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");

                        if (fullTypeName != null) {
                            String nsPrefix = null;

                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0,
                                        fullTypeName.indexOf(":"));
                            }

                            nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

                            String type = fullTypeName.substring(fullTypeName.indexOf(
                                    ":") + 1);

                            if (!"consultaCadastroResult_type0".equals(type)) {
                                //find namespace for the prefix
                                String nsUri = reader.getNamespaceContext()
                                        .getNamespaceURI(nsPrefix);

                                return (ConsultaCadastroResult_type0) ExtensionMapper.getTypeObject(nsUri,
                                        type, reader);
                            }
                        }
                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()) {
                        //use the QName from the parser as the name for the builder
                        javax.xml.namespace.QName startQname1 = reader.getName();

                        // We need to wrap the reader so that it produces a fake START_DOCUMENT event
                        // this is needed by the builder classes
                        org.apache.axis2.databinding.utils.NamedStaxOMBuilder builder1 =
                                new org.apache.axis2.databinding.utils.NamedStaxOMBuilder(new org.apache.axis2.util.StreamWrapper(
                                        reader), startQname1);
                        object.setExtraElement(builder1.getOMElement());

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // 1 - A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()) {
                        // 2 - A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement " + reader.getName());
                    }
                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new Exception(e);
                }

                return object;
            }
        } //end of factory class
    }

    public static class NfeDadosMsg_type0 implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
           name = nfeDadosMsg_type0
           Namespace URI = http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4
           Namespace Prefix = ns1
         */

        /**
         * field for ExtraElement
         */
        protected org.apache.axiom.om.OMElement localExtraElement;

        /**
         * Auto generated getter method
         *
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getExtraElement() {
            return localExtraElement;
        }

        /**
         * Auto generated setter method
         *
         * @param param ExtraElement
         */
        public void setExtraElement(org.apache.axiom.om.OMElement param) {
            this.localExtraElement = param;
        }

        /**
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory)
                throws org.apache.axis2.databinding.ADBException {
            return factory.createOMElement(new org.apache.axis2.databinding.ADBDataSource(
                    this, parentQName));
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            String prefix = null;
            String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(),
                    xmlWriter);

            if (serializeType) {
                String namespacePrefix = registerPrefix(xmlWriter,
                        "http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4");

                if ((namespacePrefix != null) &&
                        (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":nfeDadosMsg_type0", xmlWriter);
                } else {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "nfeDadosMsg_type0", xmlWriter);
                }
            }

            if (localExtraElement != null) {
                localExtraElement.serialize(xmlWriter);
            } else {
                throw new org.apache.axis2.databinding.ADBException(
                        "extraElement cannot be null!!");
            }

            xmlWriter.writeEndElement();
        }

        private static String generatePrefix(
                String namespace) {
            if (namespace.equals(
                    "http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4")) {
                return "ns1";
            }

            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(String prefix,
                                       String namespace, String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(String prefix,
                                    String namespace, String attName,
                                    String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeAttribute(writerPrefix, namespace, attName,
                        attValue);
            } else {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
                xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(String namespace,
                                    String attName, String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                xmlWriter.writeAttribute(registerPrefix(xmlWriter, namespace),
                        namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(String namespace,
                                         String attName, javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }

            String attributeValue;

            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(attributePrefix, namespace, attName,
                        attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();

            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);

                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            qname));
                }
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }

                    namespaceURI = qnames[i].getNamespaceURI();

                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);

                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":")
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                            qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                qnames[i]));
                    }
                }

                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        /**
         * Register a namespace prefix
         */
        private String registerPrefix(
                javax.xml.stream.XMLStreamWriter xmlWriter,
                String namespace)
                throws javax.xml.stream.XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();

                while (true) {
                    String uri = nsContext.getNamespaceURI(prefix);

                    if ((uri == null) || (uri.length() == 0)) {
                        break;
                    }

                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {
            private static org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(Factory.class);

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             * If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             * If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static NfeDadosMsg_type0 parse(
                    javax.xml.stream.XMLStreamReader reader)
                    throws Exception {
                NfeDadosMsg_type0 object = new NfeDadosMsg_type0();

                int event;
                javax.xml.namespace.QName currentQName = null;
                String nillableValue = null;
                String prefix = "";
                String namespaceuri = "";

                try {
                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    currentQName = reader.getName();

                    if (reader.getAttributeValue(
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type") != null) {
                        String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");

                        if (fullTypeName != null) {
                            String nsPrefix = null;

                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0,
                                        fullTypeName.indexOf(":"));
                            }

                            nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

                            String type = fullTypeName.substring(fullTypeName.indexOf(
                                    ":") + 1);

                            if (!"nfeDadosMsg_type0".equals(type)) {
                                //find namespace for the prefix
                                String nsUri = reader.getNamespaceContext()
                                        .getNamespaceURI(nsPrefix);

                                return (NfeDadosMsg_type0) ExtensionMapper.getTypeObject(nsUri,
                                        type, reader);
                            }
                        }
                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()) {
                        //use the QName from the parser as the name for the builder
                        javax.xml.namespace.QName startQname1 = reader.getName();

                        // We need to wrap the reader so that it produces a fake START_DOCUMENT event
                        // this is needed by the builder classes
                        org.apache.axis2.databinding.utils.NamedStaxOMBuilder builder1 =
                                new org.apache.axis2.databinding.utils.NamedStaxOMBuilder(new org.apache.axis2.util.StreamWrapper(
                                        reader), startQname1);
                        object.setExtraElement(builder1.getOMElement());

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // 1 - A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()) {
                        // 2 - A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement " + reader.getName());
                    }
                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new Exception(e);
                }

                return object;
            }
        } //end of factory class
    }

    public static class ConsultaCadastro implements org.apache.axis2.databinding.ADBBean {
        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4","consultaCadastro", "ns1");

        protected NfeDadosMsg_type0 localNfeDadosMsg;
        protected boolean localNfeDadosMsgTracker = false;

        public boolean isNfeDadosMsgSpecified() {
            return localNfeDadosMsgTracker;
        }

        public NfeDadosMsg_type0 getNfeDadosMsg() {
            return localNfeDadosMsg;
        }

        public void setNfeDadosMsg(NfeDadosMsg_type0 param) {
            localNfeDadosMsgTracker = param != null;
            this.localNfeDadosMsg = param;
        }

        /**
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory)
                throws org.apache.axis2.databinding.ADBException {
            return factory.createOMElement(new org.apache.axis2.databinding.ADBDataSource(
                    this, MY_QNAME));
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            String prefix = null;
            String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(),
                    xmlWriter);

            if (serializeType) {
                String namespacePrefix = registerPrefix(xmlWriter,
                        "http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4");

                if ((namespacePrefix != null) &&
                        (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":consultaCadastro", xmlWriter);
                } else {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "consultaCadastro", xmlWriter);
                }
            }

            if (localNfeDadosMsgTracker) {
                if (localNfeDadosMsg == null) {
                    throw new org.apache.axis2.databinding.ADBException(
                            "nfeDadosMsg cannot be null!!");
                }

                localNfeDadosMsg.serialize(new javax.xml.namespace.QName(
                        "http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4",
                        "nfeDadosMsg"), xmlWriter);
            }

            xmlWriter.writeEndElement();
        }

        private static String generatePrefix(
                String namespace) {
            if (namespace.equals(
                    "http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4")) {
                return "ns1";
            }

            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(String prefix,
                                       String namespace, String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(String prefix,
                                    String namespace, String attName,
                                    String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeAttribute(writerPrefix, namespace, attName,
                        attValue);
            } else {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
                xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(String namespace,
                                    String attName, String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                xmlWriter.writeAttribute(registerPrefix(xmlWriter, namespace),
                        namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(String namespace,
                                         String attName, javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }

            String attributeValue;

            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(attributePrefix, namespace, attName,
                        attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();

            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);

                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            qname));
                }
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }

                    namespaceURI = qnames[i].getNamespaceURI();

                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);

                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":")
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                            qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                qnames[i]));
                    }
                }

                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        /**
         * Register a namespace prefix
         */
        private String registerPrefix(
                javax.xml.stream.XMLStreamWriter xmlWriter,
                String namespace)
                throws javax.xml.stream.XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();

                while (true) {
                    String uri = nsContext.getNamespaceURI(prefix);

                    if ((uri == null) || (uri.length() == 0)) {
                        break;
                    }

                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {
            private static org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(Factory.class);

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             * If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             * If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static ConsultaCadastro parse(
                    javax.xml.stream.XMLStreamReader reader)
                    throws Exception {
                ConsultaCadastro object = new ConsultaCadastro();

                int event;
                javax.xml.namespace.QName currentQName = null;
                String nillableValue = null;
                String prefix = "";
                String namespaceuri = "";

                try {
                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    currentQName = reader.getName();

                    if (reader.getAttributeValue(
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type") != null) {
                        String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");

                        if (fullTypeName != null) {
                            String nsPrefix = null;

                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0,
                                        fullTypeName.indexOf(":"));
                            }

                            nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

                            String type = fullTypeName.substring(fullTypeName.indexOf(
                                    ":") + 1);

                            if (!"consultaCadastro".equals(type)) {
                                //find namespace for the prefix
                                String nsUri = reader.getNamespaceContext()
                                        .getNamespaceURI(nsPrefix);

                                return (ConsultaCadastro) ExtensionMapper.getTypeObject(nsUri,
                                        type, reader);
                            }
                        }
                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4",
                                    "nfeDadosMsg").equals(reader.getName())) ||
                            new javax.xml.namespace.QName("", "nfeDadosMsg").equals(
                                    reader.getName())) {
                        object.setNfeDadosMsg(NfeDadosMsg_type0.Factory.parse(
                                reader));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()) {
                        // 2 - A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement " + reader.getName());
                    }
                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new Exception(e);
                }

                return object;
            }
        } //end of factory class
    }
}