/*
 * MDFeRecepcaoSincStub.java <p> This file was auto-generated from WSDL by the Apache Axis2 version: 1.6.2 Built on : Apr 17, 2012 (05:33:49 IST)
 */
package com.fincatto.documentofiscal.mdfe3.webservices.recepcao;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAttribute;
import org.apache.axis2.client.Stub;

import com.fincatto.documentofiscal.DFConfig;
import com.fincatto.documentofiscal.utils.MessageContextFactory;

/*
 * MDFeRecepcaoSincStub java implementation
 */

public class MDFeRecepcaoSincStub1 extends org.apache.axis2.client.Stub {
    protected org.apache.axis2.description.AxisOperation[] _operations;

    // hashmaps to keep the fault mapping
    @SuppressWarnings("rawtypes")
    private final java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
    @SuppressWarnings("rawtypes")
    private final java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
    @SuppressWarnings("rawtypes")
    private final java.util.HashMap faultMessageMap = new java.util.HashMap();

    private static int counter = 0;

    private static synchronized java.lang.String getUniqueSuffix() {
        // reset the counter if it is greater than 99999
        if (MDFeRecepcaoSincStub1.counter > 99999) {
            MDFeRecepcaoSincStub1.counter = 0;
        }
        MDFeRecepcaoSincStub1.counter = MDFeRecepcaoSincStub1.counter + 1;
        return System.currentTimeMillis() + "_" + MDFeRecepcaoSincStub1.counter;
    }

    private void populateAxisService() {
        // creating the Service with a unique name
        this._service = new org.apache.axis2.description.AxisService("MDFeRecepcaoSinc" + MDFeRecepcaoSincStub1.getUniqueSuffix());
        this.addAnonymousOperations();
        // creating the operations
        org.apache.axis2.description.AxisOperation __operation;
        this._operations = new org.apache.axis2.description.AxisOperation[1];
        __operation = new org.apache.axis2.description.OutInAxisOperation();
        __operation.setName(new javax.xml.namespace.QName("http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcaoSinc", "mdfeRecepcaoResult"));
        this._service.addOperation(__operation);
        this._operations[0] = __operation;
    }

    // populates the faults
    private void populateFaults() {
    }

    /**
     * Constructor that takes in a configContext
     */

    public MDFeRecepcaoSincStub1(final org.apache.axis2.context.ConfigurationContext configurationContext, final java.lang.String targetEndpoint, DFConfig config) throws org.apache.axis2.AxisFault {
        this(configurationContext, targetEndpoint, false, config);
    }

    /**
     * Constructor that takes in a configContext and useseperate listner
     */
    public MDFeRecepcaoSincStub1(final org.apache.axis2.context.ConfigurationContext configurationContext, final java.lang.String targetEndpoint, final boolean useSeparateListener, DFConfig config) throws org.apache.axis2.AxisFault {
        // To populate AxisService
        this.populateAxisService();
        this.populateFaults();
        this._serviceClient = new org.apache.axis2.client.ServiceClient(configurationContext, this._service);
        this._serviceClient.getOptions().setTo(new org.apache.axis2.addressing.EndpointReference(targetEndpoint));
        this._serviceClient.getOptions().setUseSeparateListener(useSeparateListener);
        // Set the soap version
        this._serviceClient.getOptions().setSoapVersionURI(org.apache.axiom.soap.SOAP12Constants.SOAP_ENVELOPE_NAMESPACE_URI);
        this.config = config;
    }

    /**
     * Constructor taking the target endpoint
     */
    public MDFeRecepcaoSincStub1(final java.lang.String targetEndpoint, DFConfig config) throws org.apache.axis2.AxisFault {
        this(null, targetEndpoint, config);
    }

    /**
     * Auto generated method signature
     * @param mdfeDadosMsg0
     * @param mdfeCabecMsg1
     */

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public com.fincatto.documentofiscal.mdfe3.webservices.recepcao.MDFeRecepcaoSincStub1.MdfeRecepcaoSincResult mdfeRecepcaoSinc(final com.fincatto.documentofiscal.mdfe3.webservices.recepcao.MDFeRecepcaoSincStub1.MdfeDadosMsg mdfeDadosMsg0) throws java.rmi.RemoteException {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try {
            final org.apache.axis2.client.OperationClient _operationClient = this._serviceClient.createClient(this._operations[0].getName());
            _operationClient.getOptions().setAction("http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcaoSinc/mdfeRecepcao");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);
            this.addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");
            // create a message context
            _messageContext = MessageContextFactory.INSTANCE.create(config);
            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env;
            env = this.toEnvelope(Stub.getFactory(_operationClient.getOptions().getSoapVersionURI()), mdfeDadosMsg0, this.optimizeContent(new javax.xml.namespace.QName("http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcaoSinc", "mdfeRecepcaoResult")), new javax.xml.namespace.QName("http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcaoSinc", "mdfeRecepcaoResult"));
            env.build();
//            // add the children only if the parameter is not null
//            if (mdfeCabecMsg1 != null) {
//                final org.apache.axiom.om.OMElement omElementmdfeCabecMsg1 = this.toOM(mdfeCabecMsg1, this.optimizeContent(new javax.xml.namespace.QName("http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcaoSinc", "mdfeRecepcaoResult")));
//                this.addHeader(omElementmdfeCabecMsg1, env);
//            }
//            // adding SOAP soap_headers
//            this._serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);
            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);
            // execute the operation client
            _operationClient.execute(true);
            final org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            final org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
            final java.lang.Object object = this.fromOM(_returnEnv.getBody().getFirstElement(), com.fincatto.documentofiscal.mdfe3.webservices.recepcao.MDFeRecepcaoSincStub1.MdfeRecepcaoSincResult.class, this.getEnvelopeNamespaces(_returnEnv));
            return (com.fincatto.documentofiscal.mdfe3.webservices.recepcao.MDFeRecepcaoSincStub1.MdfeRecepcaoSincResult) object;
        } catch (final org.apache.axis2.AxisFault f) {
            final org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null) {
                if (this.faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "mdfeRecepcaoResult"))) {
                    // make the fault by reflection
                    try {
                        final java.lang.String exceptionClassName = (java.lang.String) this.faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "mdfeRecepcaoResult"));
                        final java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        final java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        final java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        // message class
                        final java.lang.String messageClassName = (java.lang.String) this.faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "mdfeRecepcaoResult"));
                        final java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        final java.lang.Object messageObject = this.fromOM(faultElt, messageClass, null);
                        final java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage", messageClass);
                        m.invoke(ex, messageObject);
                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException | InstantiationException | IllegalAccessException | java.lang.reflect.InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
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
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     * @param mdfeDadosMsg0
     * @param mdfeCabecMsg1
     */
    public void startmdfeRecepcaoSinc(final com.fincatto.documentofiscal.mdfe3.webservices.recepcao.MDFeRecepcaoSincStub1.MdfeDadosMsg mdfeDadosMsg0, final com.fincatto.documentofiscal.mdfe3.webservices.recepcao.MDFeRecepcaoSincStub1.MdfeCabecMsgE mdfeCabecMsg1, final com.fincatto.documentofiscal.mdfe3.webservices.recepcao.MDFeRecepcaoSincCallbackHandler callback) throws java.rmi.RemoteException {
        final org.apache.axis2.client.OperationClient _operationClient = this._serviceClient.createClient(this._operations[0].getName());
        _operationClient.getOptions().setAction("http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcaoSinc/mdfeRecepcao");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);
        this.addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");
        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env;
        final org.apache.axis2.context.MessageContext _messageContext = MessageContextFactory.INSTANCE.create(config);
        // Style is Doc.
        env = this.toEnvelope(Stub.getFactory(_operationClient.getOptions().getSoapVersionURI()), mdfeDadosMsg0, this.optimizeContent(new javax.xml.namespace.QName("http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcaoSinc", "mdfeRecepcaoResult")), new javax.xml.namespace.QName("http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcaoSinc", "mdfeRecepcaoResult"));
        // add the soap_headers only if they are not null
        if (mdfeCabecMsg1 != null) {
            final org.apache.axiom.om.OMElement omElementmdfeCabecMsg1 = this.toOM(mdfeCabecMsg1, this.optimizeContent(new javax.xml.namespace.QName("http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcaoSinc", "mdfeRecepcaoResult")));
            this.addHeader(omElementmdfeCabecMsg1, env);
        }
        // adding SOAP soap_headers
        this._serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);
        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);
        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            @Override
            public void onMessage(final org.apache.axis2.context.MessageContext resultContext) {
                try {
                    final org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                    final java.lang.Object object = MDFeRecepcaoSincStub1.this.fromOM(resultEnv.getBody().getFirstElement(), com.fincatto.documentofiscal.mdfe3.webservices.recepcao.MDFeRecepcaoSincStub1.MdfeRecepcaoSincResult.class, MDFeRecepcaoSincStub1.this.getEnvelopeNamespaces(resultEnv));
                    ////callback.receiveResultmdfeRecepcaoSinc((com.fincatto.documentofiscal.mdfe3.webservices.recepcao.MDFeRecepcaoSincStub1.MdfeRecepcaoSincResult) object);
                } catch (final org.apache.axis2.AxisFault e) {
                    callback.receiveErrormdfeRecepcaoSinc(e);
                }
            }

            @SuppressWarnings({ "rawtypes", "unchecked" })
            @Override
            public void onError(final java.lang.Exception error) {
                if (error instanceof org.apache.axis2.AxisFault) {
                    final org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
                    final org.apache.axiom.om.OMElement faultElt = f.getDetail();
                    if (faultElt != null) {
                        if (MDFeRecepcaoSincStub1.this.faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "mdfeRecepcaoResult"))) {
                            // make the fault by reflection
                            try {
                                final java.lang.String exceptionClassName = (java.lang.String) MDFeRecepcaoSincStub1.this.faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "mdfeRecepcaoResult"));
                                final java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                                final java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                final java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                                // message class
                                final java.lang.String messageClassName = (java.lang.String) MDFeRecepcaoSincStub1.this.faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "mdfeRecepcaoResult"));
                                final java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                                final java.lang.Object messageObject = MDFeRecepcaoSincStub1.this.fromOM(faultElt, messageClass, null);
                                final java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage", messageClass);
                                m.invoke(ex, messageObject);
                                callback.receiveErrormdfeRecepcaoSinc(new java.rmi.RemoteException(ex.getMessage(), ex));
                            } catch (ClassCastException | org.apache.axis2.AxisFault | InstantiationException | IllegalAccessException | java.lang.reflect.InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrormdfeRecepcaoSinc(f);
                            }
                        } else {
                            callback.receiveErrormdfeRecepcaoSinc(f);
                        }
                    } else {
                        callback.receiveErrormdfeRecepcaoSinc(f);
                    }
                } else {
                    callback.receiveErrormdfeRecepcaoSinc(error);
                }
            }

            @Override
            public void onFault(final org.apache.axis2.context.MessageContext faultContext) {
                final org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                this.onError(fault);
            }

            @Override
            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                } catch (final org.apache.axis2.AxisFault axisFault) {
                    callback.receiveErrormdfeRecepcaoSinc(axisFault);
                }
            }
        });
        org.apache.axis2.util.CallbackReceiver _callbackReceiver;
        if (this._operations[0].getMessageReceiver() == null && _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            this._operations[0].setMessageReceiver(_callbackReceiver);
        }
        // execute the operation client
        _operationClient.execute(false);
    }

    /**
     * A utility method that copies the namepaces from the SOAPEnvelope
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private java.util.Map getEnvelopeNamespaces(final org.apache.axiom.soap.SOAPEnvelope env) {
        final java.util.Map returnMap = new java.util.HashMap();
        final java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
            final org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
            returnMap.put(ns.getPrefix(), ns.getNamespaceURI());
        }
        return returnMap;
    }

    private final javax.xml.namespace.QName[] opNameArray = null;
    private final DFConfig config;

    private boolean optimizeContent(final javax.xml.namespace.QName opName) {
        if (this.opNameArray == null) {
            return false;
        }
        for (final QName anOpNameArray : this.opNameArray) {
            if (opName.equals(anOpNameArray)) {
                return true;
            }
        }
        return false;
    }

    // https://mdfe.sefaz.rs.gov.br/ws/MDFerecepcao/MDFeRecepcaoSinc.asmx
    public static class ExtensionMapper {

        public static java.lang.Object getTypeObject(final java.lang.String namespaceURI, final java.lang.String typeName, final javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
            if ("http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcaoSinc".equals(namespaceURI) && "mdfeCabecMsg".equals(typeName)) {
                return MdfeCabecMsg.Factory.parse(reader);
            }
            throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
        }
    }

    @SuppressWarnings("serial")
    public static class MdfeCabecMsg implements org.apache.axis2.databinding.ADBBean {
        /*
         * This type was generated from the piece of schema that had name = mdfeCabecMsg Namespace URI = http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcaoSinc Namespace Prefix = ns2
         */

        /**
         * field for CUF
         */

        protected java.lang.String localCUF;

        /*
         * This tracker boolean wil be used to detect whether the user called the set method for this attribute. It will be used to determine whether to include this field in the serialized XML
         */
        protected boolean localCUFTracker = false;

        public boolean isCUFSpecified() {
            return this.localCUFTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getCUF() {
            return this.localCUF;
        }

        /**
         * Auto generated setter method
         * @param param CUF
         */
        public void setCUF(final java.lang.String param) {
            this.localCUFTracker = param != null;
            this.localCUF = param;
        }

        /**
         * field for VersaoDados
         */

        protected java.lang.String localVersaoDados;

        /*
         * This tracker boolean wil be used to detect whether the user called the set method for this attribute. It will be used to determine whether to include this field in the serialized XML
         */
        protected boolean localVersaoDadosTracker = false;

        public boolean isVersaoDadosSpecified() {
            return this.localVersaoDadosTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getVersaoDados() {
            return this.localVersaoDados;
        }

        /**
         * Auto generated setter method
         * @param param VersaoDados
         */
        public void setVersaoDados(final java.lang.String param) {
            this.localVersaoDadosTracker = param != null;
            this.localVersaoDados = param;
        }

        /**
         * field for ExtraAttributes This was an Attribute! This was an Array!
         */

        protected org.apache.axiom.om.OMAttribute[] localExtraAttributes;

        /**
         * Auto generated getter method
         * @return org.apache.axiom.om.OMAttribute[]
         */
        public org.apache.axiom.om.OMAttribute[] getExtraAttributes() {
            return this.localExtraAttributes;
        }

        /**
         * validate the array for ExtraAttributes
         */
        protected void validateExtraAttributes(final org.apache.axiom.om.OMAttribute[] param) {
            if ((param != null) && (param.length > 1)) {
                throw new java.lang.RuntimeException();
            }
            if ((param != null) && (param.length < 1)) {
                throw new java.lang.RuntimeException();
            }
        }

        /**
         * Auto generated setter method
         * @param param ExtraAttributes
         */
        public void setExtraAttributes(final org.apache.axiom.om.OMAttribute[] param) {
            this.validateExtraAttributes(param);
            this.localExtraAttributes = param;
        }

        /**
         * Auto generated add method for the array for convenience
         * @param param org.apache.axiom.om.OMAttribute
         */
        @SuppressWarnings({ "rawtypes", "unchecked" })
        public void addExtraAttributes(final org.apache.axiom.om.OMAttribute param) {
            if (this.localExtraAttributes == null) {
                this.localExtraAttributes = new org.apache.axiom.om.OMAttribute[] {};
            }
            final java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(this.localExtraAttributes);
            list.add(param);
            this.localExtraAttributes = (org.apache.axiom.om.OMAttribute[]) list.toArray(new org.apache.axiom.om.OMAttribute[0]);
        }

        /**
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory) {
            final org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, parentQName);
            return factory.createOMElement(dataSource, parentQName);
        }

        @Override
        public void serialize(final javax.xml.namespace.QName parentQName, final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            this.serialize(parentQName, xmlWriter, false);
        }

        @SuppressWarnings("deprecation")
        @Override
        public void serialize(final javax.xml.namespace.QName parentQName, final javax.xml.stream.XMLStreamWriter xmlWriter, final boolean serializeType) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix;
            java.lang.String namespace;
            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            this.writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);
            if (serializeType) {
                final java.lang.String namespacePrefix = this.registerPrefix(xmlWriter, "http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcaoSinc");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    this.writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix + ":mdfeCabecMsg", xmlWriter);
                } else {
                    this.writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "mdfeCabecMsg", xmlWriter);
                }
            }
            if (this.localExtraAttributes != null) {
                for (final OMAttribute localExtraAttribute : this.localExtraAttributes) {
                    this.writeAttribute(localExtraAttribute.getNamespace().getName(), localExtraAttribute.getLocalName(), localExtraAttribute.getAttributeValue(), xmlWriter);
                }
            }
            if (this.localCUFTracker) {
                namespace = "http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcaoSinc";
                this.writeStartElement(null, namespace, "cUF", xmlWriter);
                if (this.localCUF == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException("cUF cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(this.localCUF);
                }
                xmlWriter.writeEndElement();
            }
            if (this.localVersaoDadosTracker) {
                namespace = "http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcaoSinc";
                this.writeStartElement(null, namespace, "versaoDados", xmlWriter);
                if (this.localVersaoDados == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException("versaoDados cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(this.localVersaoDados);
                }
                xmlWriter.writeEndElement();
            }
            xmlWriter.writeEndElement();
        }

        private static java.lang.String generatePrefix(final java.lang.String namespace) {
            if (namespace.equals("http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcaoSinc")) {
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, final java.lang.String namespace, final java.lang.String localPart, final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            final java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = MdfeCabecMsg.generatePrefix(namespace);
                }
                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(final java.lang.String prefix, final java.lang.String namespace, final java.lang.String attName, final java.lang.String attValue, final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(final java.lang.String namespace, final java.lang.String attName, final java.lang.String attValue, final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                this.registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        @SuppressWarnings("unused")
        private void writeQNameAttribute(final java.lang.String namespace, final java.lang.String attName, final javax.xml.namespace.QName qname, final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            final java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = this.registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                this.registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        @SuppressWarnings("unused")
        private void writeQName(final javax.xml.namespace.QName qname, final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            final java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = MdfeCabecMsg.generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }
                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        @SuppressWarnings("unused")
        private void writeQNames(final javax.xml.namespace.QName[] qnames, final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                final StringBuilder stringToWrite = new StringBuilder();
                java.lang.String namespaceURI;
                java.lang.String prefix;
                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = MdfeCabecMsg.generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }
                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(final javax.xml.stream.XMLStreamWriter xmlWriter, final java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = MdfeCabecMsg.generatePrefix(namespace);
                final javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    final java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
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

            /**
             * static method to create the object Precondition: If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable If this object is not an element, it is a complex type and the reader is at the event just after the outer start element Postcondition: If this object is an element, the reader is positioned at its end element If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            @SuppressWarnings({ "unused", "rawtypes" })
            public static MdfeCabecMsg parse(final javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                final MdfeCabecMsg object = new MdfeCabecMsg();
                final int event;
                java.lang.String nillableValue;
                final java.lang.String prefix = "";
                final java.lang.String namespaceuri = "";
                try {
                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }
                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        final java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.contains(":")) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;
                            final java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);
                            if (!"mdfeCabecMsg".equals(type)) {
                                // find namespace for the prefix
                                final java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (MdfeCabecMsg) ExtensionMapper.getTypeObject(nsUri, type, reader);
                            }
                        }
                    }
                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    final java.util.Vector handledAttributes = new java.util.Vector();
                    // now run through all any or extra attributes
                    // which were not reflected until now
                    for (int i = 0; i < reader.getAttributeCount(); i++) {
                        if (!handledAttributes.contains(reader.getAttributeLocalName(i))) {
                            // this is an anyAttribute and we create
                            // an OMAttribute for this
                            final org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();
                            final org.apache.axiom.om.OMAttribute attr = factory.createOMAttribute(reader.getAttributeLocalName(i), factory.createOMNamespace(reader.getAttributeNamespace(i), reader.getAttributePrefix(i)), reader.getAttributeValue(i));
                            // and add it to the extra attributes
                            object.addExtraAttributes(attr);
                        }
                    }
                    reader.next();
                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }
                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcaoSinc", "cUF").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "cUF" + "  cannot be null");
                        }
                        final java.lang.String content = reader.getElementText();
                        object.setCUF(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                        reader.next();
                    } // End of if for expected property start element
                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }
                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcaoSinc", "versaoDados").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "versaoDados" + "  cannot be null");
                        }
                        final java.lang.String content = reader.getElementText();
                        object.setVersaoDados(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                        reader.next();
                    } // End of if for expected property start element
                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }
                    if (reader.isStartElement()) {
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                    }
                } catch (final javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }
                return object;
            }
        }// end of factory class
    }

    @SuppressWarnings("serial")
    public static class MdfeRecepcaoSincResult implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcaoSinc", "mdfeRecepcaoResult", "ns2");

        /**
         * field for ExtraElement
         */

        protected org.apache.axiom.om.OMElement localExtraElement;

        /**
         * Auto generated getter method
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getExtraElement() {
            return this.localExtraElement;
        }

        /**
         * Auto generated setter method
         * @param param ExtraElement
         */
        public void setExtraElement(final org.apache.axiom.om.OMElement param) {
            this.localExtraElement = param;
        }

        /**
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory) {
            final org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MdfeRecepcaoSincResult.MY_QNAME);
            return factory.createOMElement(dataSource, MdfeRecepcaoSincResult.MY_QNAME);
        }

        @Override
        public void serialize(final javax.xml.namespace.QName parentQName, final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            this.serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize(final javax.xml.namespace.QName parentQName, final javax.xml.stream.XMLStreamWriter xmlWriter, final boolean serializeType) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix;
            java.lang.String namespace;
            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            this.writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);
            if (serializeType) {
                final java.lang.String namespacePrefix = this.registerPrefix(xmlWriter, "http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcaoSinc");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    this.writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix + ":mdfeRecepcaoResult", xmlWriter);
                } else {
                    this.writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "mdfeRecepcaoResult", xmlWriter);
                }
            }
            if (this.localExtraElement != null) {
                this.localExtraElement.serialize(xmlWriter);
            } else {
                throw new org.apache.axis2.databinding.ADBException("extraElement cannot be null!!");
            }
            xmlWriter.writeEndElement();
        }

        private static java.lang.String generatePrefix(final java.lang.String namespace) {
            if (namespace.equals("http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcaoSinc")) {
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, final java.lang.String namespace, final java.lang.String localPart, final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            final java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = MdfeRecepcaoSincResult.generatePrefix(namespace);
                }
                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(final java.lang.String prefix, final java.lang.String namespace, final java.lang.String attName, final java.lang.String attValue, final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        @SuppressWarnings("unused")
        private void writeAttribute(final java.lang.String namespace, final java.lang.String attName, final java.lang.String attValue, final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                this.registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        @SuppressWarnings("unused")
        private void writeQNameAttribute(final java.lang.String namespace, final java.lang.String attName, final javax.xml.namespace.QName qname, final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            final java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = this.registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                this.registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        @SuppressWarnings("unused")
        private void writeQName(final javax.xml.namespace.QName qname, final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            final java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = MdfeRecepcaoSincResult.generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }
                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        @SuppressWarnings("unused")
        private void writeQNames(final javax.xml.namespace.QName[] qnames, final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                final StringBuilder stringToWrite = new StringBuilder();
                java.lang.String namespaceURI;
                java.lang.String prefix;
                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = MdfeRecepcaoSincResult.generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }
                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(final javax.xml.stream.XMLStreamWriter xmlWriter, final java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = MdfeRecepcaoSincResult.generatePrefix(namespace);
                final javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    final java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
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

            /**
             * static method to create the object Precondition: If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable If this object is not an element, it is a complex type and the reader is at the event just after the outer start element Postcondition: If this object is an element, the reader is positioned at its end element If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            @SuppressWarnings({ "unused", "rawtypes" })
            public static MdfeRecepcaoSincResult parse(final javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                final MdfeRecepcaoSincResult object = new MdfeRecepcaoSincResult();
                final int event;
                final java.lang.String nillableValue = null;
                final java.lang.String prefix = "";
                final java.lang.String namespaceuri = "";
                try {
                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }
                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        final java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.contains(":")) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;
                            final java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);
                            if (!"mdfeRecepcaoSincResult".equals(type)) {
                                // find namespace for the prefix
                                final java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (MdfeRecepcaoSincResult) ExtensionMapper.getTypeObject(nsUri, type, reader);
                            }
                        }
                    }
                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    final java.util.Vector handledAttributes = new java.util.Vector();
                    reader.next();
                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }
                    if (reader.isStartElement()) {
                        // use the QName from the parser as the name for the builder
                        final javax.xml.namespace.QName startQname1 = reader.getName();
                        // We need to wrap the reader so that it produces a fake START_DOCUMENT event
                        // this is needed by the builder classes
                        final org.apache.axis2.databinding.utils.NamedStaxOMBuilder builder1 = new org.apache.axis2.databinding.utils.NamedStaxOMBuilder(new org.apache.axis2.util.StreamWrapper(reader), startQname1);
                        object.setExtraElement(builder1.getOMElement());
                        reader.next();
                    } // End of if for expected property start element
                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                    }
                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }
                    if (reader.isStartElement()) {
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                    }
                } catch (final javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }
                return object;
            }
        }// end of factory class
    }

    @SuppressWarnings("serial")
    public static class MdfeCabecMsgE implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcaoSinc", "mdfeCabecMsg", "ns2");

        /**
         * field for MdfeCabecMsg
         */

        protected MdfeCabecMsg localMdfeCabecMsg;

        /**
         * Auto generated getter method
         * @return MdfeCabecMsg
         */
        public MdfeCabecMsg getMdfeCabecMsg() {
            return this.localMdfeCabecMsg;
        }

        /**
         * Auto generated setter method
         * @param param MdfeCabecMsg
         */
        public void setMdfeCabecMsg(final MdfeCabecMsg param) {
            this.localMdfeCabecMsg = param;
        }

        /**
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory) {
            final org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MdfeCabecMsgE.MY_QNAME);
            return factory.createOMElement(dataSource, MdfeCabecMsgE.MY_QNAME);
        }

        @Override
        public void serialize(final javax.xml.namespace.QName parentQName, final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            this.serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize(final javax.xml.namespace.QName parentQName, final javax.xml.stream.XMLStreamWriter xmlWriter, final boolean serializeType) throws javax.xml.stream.XMLStreamException {
            // We can safely assume an element has only one type associated with it
            if (this.localMdfeCabecMsg == null) {
                throw new org.apache.axis2.databinding.ADBException("mdfeCabecMsg cannot be null!");
            }
            this.localMdfeCabecMsg.serialize(MdfeCabecMsgE.MY_QNAME, xmlWriter);
        }

        private static java.lang.String generatePrefix(final java.lang.String namespace) {
            if (namespace.equals("http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcaoSinc")) {
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        @SuppressWarnings("unused")
        private void writeStartElement(java.lang.String prefix, final java.lang.String namespace, final java.lang.String localPart, final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            final java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = MdfeCabecMsgE.generatePrefix(namespace);
                }
                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        @SuppressWarnings("unused")
        private void writeAttribute(final java.lang.String prefix, final java.lang.String namespace, final java.lang.String attName, final java.lang.String attValue, final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        @SuppressWarnings("unused")
        private void writeAttribute(final java.lang.String namespace, final java.lang.String attName, final java.lang.String attValue, final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                this.registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        @SuppressWarnings("unused")
        private void writeQNameAttribute(final java.lang.String namespace, final java.lang.String attName, final javax.xml.namespace.QName qname, final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            final java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = this.registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                this.registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        @SuppressWarnings("unused")
        private void writeQName(final javax.xml.namespace.QName qname, final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            final java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = MdfeCabecMsgE.generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }
                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        @SuppressWarnings("unused")
        private void writeQNames(final javax.xml.namespace.QName[] qnames, final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                final StringBuilder stringToWrite = new StringBuilder();
                java.lang.String namespaceURI;
                java.lang.String prefix;
                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = MdfeCabecMsgE.generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }
                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(final javax.xml.stream.XMLStreamWriter xmlWriter, final java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = MdfeCabecMsgE.generatePrefix(namespace);
                final javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    final java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
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

            /**
             * static method to create the object Precondition: If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable If this object is not an element, it is a complex type and the reader is at the event just after the outer start element Postcondition: If this object is an element, the reader is positioned at its end element If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            @SuppressWarnings({ "unused", "rawtypes" })
            public static MdfeCabecMsgE parse(final javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                final MdfeCabecMsgE object = new MdfeCabecMsgE();
                final int event;
                final java.lang.String nillableValue = null;
                final java.lang.String prefix = "";
                final java.lang.String namespaceuri = "";
                try {
                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }
                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    final java.util.Vector handledAttributes = new java.util.Vector();
                    while (!reader.isEndElement()) {
                        if (reader.isStartElement()) {
                            if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcaoSinc", "mdfeCabecMsg").equals(reader.getName())) {
                                object.setMdfeCabecMsg(MdfeCabecMsg.Factory.parse(reader));
                            } // End of if for expected property start element
                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                            }
                        } else {
                            reader.next();
                        }
                    } // end of while loop
                } catch (final javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }
                return object;
            }
        }// end of factory class
    }

    @SuppressWarnings("serial")
    public static class MdfeDadosMsg implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcaoSinc", "mdfeDadosMsg", "ns2");

        /**
         * field for ExtraElement
         */

        protected org.apache.axiom.om.OMElement localExtraElement;

        /**
         * Auto generated getter method
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getExtraElement() {
            return this.localExtraElement;
        }

        /**
         * Auto generated setter method
         * @param param ExtraElement
         */
        public void setExtraElement(final org.apache.axiom.om.OMElement param) {
            this.localExtraElement = param;
        }

        /**
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory) {
            final org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MdfeDadosMsg.MY_QNAME);
            return factory.createOMElement(dataSource, MdfeDadosMsg.MY_QNAME);
        }

        @Override
        public void serialize(final javax.xml.namespace.QName parentQName, final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            this.serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize(final javax.xml.namespace.QName parentQName, final javax.xml.stream.XMLStreamWriter xmlWriter, final boolean serializeType) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix;
            java.lang.String namespace;
            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            this.writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);
            if (serializeType) {
                final java.lang.String namespacePrefix = this.registerPrefix(xmlWriter, "http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcaoSinc");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    this.writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix + ":mdfeDadosMsg", xmlWriter);
                } else {
                    this.writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "mdfeDadosMsg", xmlWriter);
                }
            }
            if (this.localExtraElement != null) {
                this.localExtraElement.serialize(xmlWriter);
            } else {
                throw new org.apache.axis2.databinding.ADBException("extraElement cannot be null!!");
            }
            xmlWriter.writeEndElement();
        }

        private static java.lang.String generatePrefix(final java.lang.String namespace) {
            if (namespace.equals("http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcaoSinc")) {
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, final java.lang.String namespace, final java.lang.String localPart, final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            final java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = MdfeDadosMsg.generatePrefix(namespace);
                }
                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(final java.lang.String prefix, final java.lang.String namespace, final java.lang.String attName, final java.lang.String attValue, final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        @SuppressWarnings("unused")
        private void writeAttribute(final java.lang.String namespace, final java.lang.String attName, final java.lang.String attValue, final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                this.registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        @SuppressWarnings("unused")
        private void writeQNameAttribute(final java.lang.String namespace, final java.lang.String attName, final javax.xml.namespace.QName qname, final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            final java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = this.registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                this.registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        @SuppressWarnings("unused")
        private void writeQName(final javax.xml.namespace.QName qname, final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            final java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = MdfeDadosMsg.generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }
                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        @SuppressWarnings("unused")
        private void writeQNames(final javax.xml.namespace.QName[] qnames, final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                final StringBuilder stringToWrite = new StringBuilder();
                java.lang.String namespaceURI;
                java.lang.String prefix;
                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = MdfeDadosMsg.generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }
                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(final javax.xml.stream.XMLStreamWriter xmlWriter, final java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = MdfeDadosMsg.generatePrefix(namespace);
                final javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    final java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
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

            /**
             * static method to create the object Precondition: If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable If this object is not an element, it is a complex type and the reader is at the event just after the outer start element Postcondition: If this object is an element, the reader is positioned at its end element If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            @SuppressWarnings({ "unused", "rawtypes" })
            public static MdfeDadosMsg parse(final javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                final MdfeDadosMsg object = new MdfeDadosMsg();
                final int event;
                final java.lang.String nillableValue = null;
                final java.lang.String prefix = "";
                final java.lang.String namespaceuri = "";
                try {
                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }
                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        final java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.contains(":")) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;
                            final java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);
                            if (!"mdfeDadosMsg".equals(type)) {
                                // find namespace for the prefix
                                final java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (MdfeDadosMsg) ExtensionMapper.getTypeObject(nsUri, type, reader);
                            }
                        }
                    }
                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    final java.util.Vector handledAttributes = new java.util.Vector();
                    reader.next();
                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }
                    if (reader.isStartElement()) {
                        // use the QName from the parser as the name for the builder
                        final javax.xml.namespace.QName startQname1 = reader.getName();
                        // We need to wrap the reader so that it produces a fake START_DOCUMENT event
                        // this is needed by the builder classes
                        final org.apache.axis2.databinding.utils.NamedStaxOMBuilder builder1 = new org.apache.axis2.databinding.utils.NamedStaxOMBuilder(new org.apache.axis2.util.StreamWrapper(reader), startQname1);
                        object.setExtraElement(builder1.getOMElement());
                        reader.next();
                    } // End of if for expected property start element
                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                    }
                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }
                    if (reader.isStartElement()) {
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                    }
                } catch (final javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }
                return object;
            }
        }// end of factory class
    }

    private org.apache.axiom.om.OMElement toOM(final com.fincatto.documentofiscal.mdfe3.webservices.recepcao.MDFeRecepcaoSincStub1.MdfeCabecMsgE param, final boolean optimizeContent) {
        // try {
        return param.getOMElement(com.fincatto.documentofiscal.mdfe3.webservices.recepcao.MDFeRecepcaoSincStub1.MdfeCabecMsgE.MY_QNAME, org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        // } catch (org.apache.axis2.databinding.ADBException e) {
        // throw org.apache.axis2.AxisFault.makeFault(e);
        // }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(final org.apache.axiom.soap.SOAPFactory factory, final com.fincatto.documentofiscal.mdfe3.webservices.recepcao.MDFeRecepcaoSincStub1.MdfeDadosMsg param, final boolean optimizeContent, final javax.xml.namespace.QName methodQName) {
        // try {
        final org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
        emptyEnvelope.getBody().addChild(param.getOMElement(com.fincatto.documentofiscal.mdfe3.webservices.recepcao.MDFeRecepcaoSincStub1.MdfeDadosMsg.MY_QNAME, factory));
        return emptyEnvelope;
        // } catch (org.apache.axis2.databinding.ADBException e) {
        // throw org.apache.axis2.AxisFault.makeFault(e);
        // }
    }

    /* methods to provide back word compatibility */

    /**
     * get the default envelope
     */
    @SuppressWarnings("unused")
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(final org.apache.axiom.soap.SOAPFactory factory) {
        return factory.getDefaultEnvelope();
    }

    @SuppressWarnings("rawtypes")
    private java.lang.Object fromOM(final org.apache.axiom.om.OMElement param, final java.lang.Class type, final java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault {
        try {
            if (com.fincatto.documentofiscal.mdfe3.webservices.recepcao.MDFeRecepcaoSincStub1.MdfeDadosMsg.class.equals(type)) {
                return com.fincatto.documentofiscal.mdfe3.webservices.recepcao.MDFeRecepcaoSincStub1.MdfeDadosMsg.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }
            if (com.fincatto.documentofiscal.mdfe3.webservices.recepcao.MDFeRecepcaoSincStub1.MdfeRecepcaoSincResult.class.equals(type)) {
                return com.fincatto.documentofiscal.mdfe3.webservices.recepcao.MDFeRecepcaoSincStub1.MdfeRecepcaoSincResult.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }
            if (com.fincatto.documentofiscal.mdfe3.webservices.recepcao.MDFeRecepcaoSincStub1.MdfeCabecMsgE.class.equals(type)) {
                return com.fincatto.documentofiscal.mdfe3.webservices.recepcao.MDFeRecepcaoSincStub1.MdfeCabecMsgE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }
        } catch (final java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
        return null;
    }
}
