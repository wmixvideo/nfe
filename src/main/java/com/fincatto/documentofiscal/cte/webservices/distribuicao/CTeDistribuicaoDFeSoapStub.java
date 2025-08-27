package com.fincatto.documentofiscal.cte.webservices.distribuicao;

import javax.xml.namespace.QName;

import org.apache.axis2.client.Stub;

import com.fincatto.documentofiscal.DFConfig;
import com.fincatto.documentofiscal.utils.MessageContextFactory;

/*
 * CTeDistribuicaoDFeCTeDistribuicaoDFeSoapStub java implementation
 */
@SuppressWarnings({"rawtypes", "unchecked", "deprecation", "unused"})
public class CTeDistribuicaoDFeSoapStub extends org.apache.axis2.client.Stub {
    protected org.apache.axis2.description.AxisOperation[] _operations;

    // hashmaps to keep the fault mapping
    private final java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
    private final java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
    private final java.util.HashMap faultMessageMap = new java.util.HashMap();

    private final javax.xml.namespace.QName[] opNameArray = null;
    private final DFConfig config;

    private static int counter = 0;

    private static synchronized java.lang.String getUniqueSuffix() {
        // reset the counter if it is greater than 99999
        if (CTeDistribuicaoDFeSoapStub.counter > 99999) {
            CTeDistribuicaoDFeSoapStub.counter = 0;
        }
        CTeDistribuicaoDFeSoapStub.counter = CTeDistribuicaoDFeSoapStub.counter + 1;
        return System.currentTimeMillis() + "_" + CTeDistribuicaoDFeSoapStub.counter;
    }

    private void populateAxisService() {
        // creating the Service with a unique name
        this._service = new org.apache.axis2.description.AxisService("CTeDistribuicaoDFe" + CTeDistribuicaoDFeSoapStub.getUniqueSuffix());
        this.addAnonymousOperations();
        // creating the operations
        org.apache.axis2.description.AxisOperation __operation;
        this._operations = new org.apache.axis2.description.AxisOperation[1];
        __operation = new org.apache.axis2.description.OutInAxisOperation();
        __operation.setName(new javax.xml.namespace.QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeDistribuicaoDFe", "cteDistDFeInteresse"));
        this._service.addOperation(__operation);
        this._operations[0] = __operation;
    }

    // populates the faults
    private void populateFaults() {
    }

    /**
     * Constructor that takes in a configContext
     */

    public CTeDistribuicaoDFeSoapStub(final org.apache.axis2.context.ConfigurationContext configurationContext, final java.lang.String targetEndpoint, DFConfig config) throws org.apache.axis2.AxisFault {
        this(configurationContext, targetEndpoint, false, config);
    }

    /**
     * Constructor that takes in a configContext and useseperate listner
     */
    public CTeDistribuicaoDFeSoapStub(final org.apache.axis2.context.ConfigurationContext configurationContext, final java.lang.String targetEndpoint, final boolean useSeparateListener, DFConfig config) throws org.apache.axis2.AxisFault {
        // To populate AxisService
        this.populateAxisService();
        this.populateFaults();
        this._serviceClient = new org.apache.axis2.client.ServiceClient(configurationContext, this._service);
        this._serviceClient.getOptions().setTo(new org.apache.axis2.addressing.EndpointReference(targetEndpoint));
        this._serviceClient.getOptions().setUseSeparateListener(useSeparateListener);
        this.config = config;
    }

    /**
     * Constructor taking the target endpoint
     */
    public CTeDistribuicaoDFeSoapStub(final java.lang.String targetEndpoint, DFConfig config) throws org.apache.axis2.AxisFault {
        this(null, targetEndpoint, config);
    }

    /**
     * Auto generated method signature
     *
     * @param cteDistDFeInteresse
     */

    public com.fincatto.documentofiscal.cte.webservices.distribuicao.CTeDistribuicaoDFeSoapStub.CteDistDFeInteresseResponse cteDistDFeInteresse(final com.fincatto.documentofiscal.cte.webservices.distribuicao.CTeDistribuicaoDFeSoapStub.CteDistDFeInteresse cteDistDFeInteresse) throws java.rmi.RemoteException {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try {
            final org.apache.axis2.client.OperationClient _operationClient = this._serviceClient.createClient(this._operations[0].getName());
            _operationClient.getOptions().setAction("http://www.portalfiscal.inf.br/cte/wsdl/CTeDistribuicaoDFe/cteDistDFeInteresse");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);
            this.addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");
            // create a message context
            _messageContext = MessageContextFactory.INSTANCE.create(config);
            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env;
            env = this.toEnvelope(Stub.getFactory(_operationClient.getOptions().getSoapVersionURI()), cteDistDFeInteresse, this.optimizeContent(new javax.xml.namespace.QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeDistribuicaoDFe", "cteDistDFeInteresse")));
            // adding SOAP soap_headers
            this._serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);
            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);
            // execute the operation client
            _operationClient.execute(true);
            final org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            final org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
            final java.lang.Object object = this.fromOM(_returnEnv.getBody().getFirstElement(), com.fincatto.documentofiscal.cte.webservices.distribuicao.CTeDistribuicaoDFeSoapStub.CteDistDFeInteresseResponse.class, this.getEnvelopeNamespaces(_returnEnv));
            return (com.fincatto.documentofiscal.cte.webservices.distribuicao.CTeDistribuicaoDFeSoapStub.CteDistDFeInteresseResponse) object;
        } catch (final org.apache.axis2.AxisFault f) {
            final org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null) {
                if (this.faultExceptionNameMap.containsKey(faultElt.getQName())) {
                    // make the fault by reflection
                    try {
                        final java.lang.String exceptionClassName = (java.lang.String) this.faultExceptionClassNameMap.get(faultElt.getQName());
                        final java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        final java.lang.Exception ex = (java.lang.Exception) exceptionClass.newInstance();
                        // message class
                        final java.lang.String messageClassName = (java.lang.String) this.faultMessageMap.get(faultElt.getQName());
                        final java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        final java.lang.Object messageObject = this.fromOM(faultElt, messageClass, null);
                        final java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage", messageClass);
                        m.invoke(ex, messageObject);
                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (final ClassCastException | InstantiationException | IllegalAccessException | java.lang.reflect.InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
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
     * A utility method that copies the namepaces from the SOAPEnvelope
     */
    private java.util.Map getEnvelopeNamespaces(final org.apache.axiom.soap.SOAPEnvelope env) {
        final java.util.Map returnMap = new java.util.HashMap();
        final java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
            final org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
            returnMap.put(ns.getPrefix(), ns.getNamespaceURI());
        }
        return returnMap;
    }

    private boolean optimizeContent(final javax.xml.namespace.QName opName) {
        if (this.opNameArray == null) {
            return false;
        }
        for (final QName element : this.opNameArray) {
            if (opName.equals(element)) {
                return true;
            }
        }
        return false;
    }

    // https://www1.cte.fazenda.gov.br/CTeDistribuicaoDFe/CTeDistribuicaoDFe.asmx
    public static class CteDistDFeInteresse implements org.apache.axis2.databinding.ADBBean {
        private static final long serialVersionUID = 2957376822838111021L;

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeDistribuicaoDFe", "cteDistDFeInteresse", "ns1");

        private static java.lang.String generatePrefix(final java.lang.String namespace) {
            if (namespace.equals("http://www.portalfiscal.inf.br/cte/wsdl/CTeDistribuicaoDFe")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * field for CteDadosMsg
         */

        protected CteDadosMsg_type0 localCteDadosMsg;

        /*
         * This tracker boolean wil be used to detect whether the user called the set method for this attribute. It will be used to determine whether to include this field in the serialized XML
         */
        protected boolean localCteDadosMsgTracker = false;

        /**
         * Auto generated getter method
         *
         * @return CteDadosMsg_type0
         */
        public CteDadosMsg_type0 getCteDadosMsg() {
            return this.localCteDadosMsg;
        }

        /**
         * Auto generated setter method
         *
         * @param param CteDadosMsg
         */
        public void setCteDadosMsg(final CteDadosMsg_type0 param) {
            // update the setting tracker
            this.localCteDadosMsgTracker = param != null;
            this.localCteDadosMsg = param;
        }

        /**
         * isReaderMTOMAware
         *
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(final javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware;
            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (final java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory) {
            final org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, CteDistDFeInteresse.MY_QNAME) {

                @Override
                public void serialize(final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                    CteDistDFeInteresse.this.serialize(CteDistDFeInteresse.MY_QNAME, factory, xmlWriter);
                }
            };
            // return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(CteDistDFeInteresse.MY_QNAME, factory, dataSource);
            return factory.createOMElement(dataSource, CteDistDFeInteresse.MY_QNAME);
        }

        @Override
        public void serialize(final javax.xml.namespace.QName parentQName, final javax.xml.stream.XMLStreamWriter xmlWriter, final boolean serializeType) {
            this.serialize(parentQName, xmlWriter, serializeType);
        }

        @Override
        public void serialize(final javax.xml.namespace.QName parentQName, final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            this.serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory, final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            this.serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory, final javax.xml.stream.XMLStreamWriter xmlWriter, final boolean serializeType) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix;
            java.lang.String namespace;
            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            if ((namespace != null) && (namespace.trim().length() > 0)) {
                final java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = CteDistDFeInteresse.generatePrefix(namespace);
                    }
                    xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }
            if (serializeType) {
                final java.lang.String namespacePrefix = this.registerPrefix(xmlWriter, "http://www.portalfiscal.inf.br/cte/wsdl/CTeDistribuicaoDFe");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    this.writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix + ":cteDistDFeInteresse", xmlWriter);
                } else {
                    this.writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "cteDistDFeInteresse", xmlWriter);
                }
            }
            if (this.localCteDadosMsgTracker) {
                if (this.localCteDadosMsg == null) {
                    throw new org.apache.axis2.databinding.ADBException("cteDadosMsg cannot be null!!");
                }
                this.localCteDadosMsg.serialize(new javax.xml.namespace.QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeDistribuicaoDFe", "cteDadosMsg"), factory, xmlWriter);
            }
            xmlWriter.writeEndElement();
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

        private void writeQName(final javax.xml.namespace.QName qname, final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            final java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = CteDistDFeInteresse.generatePrefix(namespaceURI);
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
                            prefix = CteDistDFeInteresse.generatePrefix(namespaceURI);
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
                prefix = CteDistDFeInteresse.generatePrefix(namespace);
                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
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
            public static CteDistDFeInteresse parse(final javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                final CteDistDFeInteresse object = new CteDistDFeInteresse();
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
                            if (!"cteDistDFeInteresse".equals(type)) {
                                // find namespace for the prefix
                                final java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (CteDistDFeInteresse) ExtensionMapper.getTypeObject(nsUri, type, reader);
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
                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeDistribuicaoDFe", "cteDadosMsg").equals(reader.getName())) {
                        object.setCteDadosMsg(CteDadosMsg_type0.Factory.parse(reader));
                        reader.next();
                    } // End of if for expected property start element
                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }
                    if (reader.isStartElement()) {
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                    }
                } catch (final javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }
                return object;
            }
        }// end of factory class
    }

    public static class CteDadosMsg_type0 implements org.apache.axis2.databinding.ADBBean {
        private static final long serialVersionUID = -979080383028520937L;
        /*
         * This type was generated from the piece of schema that had name = cteDadosMsg_type0 Namespace URI = http://www.portalfiscal.inf.br/cte/wsdl/CTeDistribuicaoDFe Namespace Prefix = ns1
         */

        private static java.lang.String generatePrefix(final java.lang.String namespace) {
            if (namespace.equals("http://www.portalfiscal.inf.br/cte/wsdl/CTeDistribuicaoDFe")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

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
            return this.localExtraElement;
        }

        /**
         * Auto generated setter method
         *
         * @param param ExtraElement
         */
        public void setExtraElement(final org.apache.axiom.om.OMElement param) {
            this.localExtraElement = param;
        }

        /**
         * isReaderMTOMAware
         *
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(final javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware;
            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (final java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory) {
            final org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, parentQName) {

                @Override
                public void serialize(final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                    CteDadosMsg_type0.this.serialize(this.parentQName, factory, xmlWriter);
                }
            };
            // return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(parentQName, factory, dataSource);
            return factory.createOMElement(dataSource, parentQName);
        }

        @Override
        public void serialize(final javax.xml.namespace.QName parentQName, final javax.xml.stream.XMLStreamWriter xmlWriter, final boolean serializeType) {
            this.serialize(parentQName, xmlWriter, serializeType);
        }

        @Override
        public void serialize(final javax.xml.namespace.QName parentQName, final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            this.serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory, final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            this.serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory, final javax.xml.stream.XMLStreamWriter xmlWriter, final boolean serializeType) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix;
            java.lang.String namespace;
            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            if ((namespace != null) && (namespace.trim().length() > 0)) {
                final java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = CteDadosMsg_type0.generatePrefix(namespace);
                    }
                    xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }
            if (serializeType) {
                final java.lang.String namespacePrefix = this.registerPrefix(xmlWriter, "http://www.portalfiscal.inf.br/cte/wsdl/CTeDistribuicaoDFe");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    this.writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix + ":cteDadosMsg_type0", xmlWriter);
                } else {
                    this.writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "cteDadosMsg_type0", xmlWriter);
                }
            }
            if (this.localExtraElement != null) {
                this.localExtraElement.serialize(xmlWriter);
            } else {
                throw new org.apache.axis2.databinding.ADBException("extraElement cannot be null!!");
            }
            xmlWriter.writeEndElement();
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

        private void writeQName(final javax.xml.namespace.QName qname, final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            final java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = CteDadosMsg_type0.generatePrefix(namespaceURI);
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
                            prefix = CteDadosMsg_type0.generatePrefix(namespaceURI);
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
                prefix = CteDadosMsg_type0.generatePrefix(namespace);
                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
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
            public static CteDadosMsg_type0 parse(final javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                final CteDadosMsg_type0 object = new CteDadosMsg_type0();
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
                            if (!"cteDadosMsg_type0".equals(type)) {
                                // find namespace for the prefix
                                final java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (CteDadosMsg_type0) ExtensionMapper.getTypeObject(nsUri, type, reader);
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
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                    }
                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }
                    if (reader.isStartElement()) {
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                    }
                } catch (final javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }
                return object;
            }
        }// end of factory class
    }

    public static class CteDistDFeInteresseResponse implements org.apache.axis2.databinding.ADBBean {
        private static final long serialVersionUID = -7734346985786228491L;

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeDistribuicaoDFe", "cteDistDFeInteresseResponse", "ns1");

        private static java.lang.String generatePrefix(final java.lang.String namespace) {
            if (namespace.equals("http://www.portalfiscal.inf.br/cte/wsdl/CTeDistribuicaoDFe")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * field for CteDistDFeInteresseResult
         */

        protected CteDistDFeInteresseResult_type0 localCteDistDFeInteresseResult;

        /*
         * This tracker boolean wil be used to detect whether the user called the set method for this attribute. It will be used to determine whether to include this field in the serialized XML
         */
        protected boolean localCteDistDFeInteresseResultTracker = false;

        /**
         * Auto generated getter method
         *
         * @return CteDistDFeInteresseResult_type0
         */
        public CteDistDFeInteresseResult_type0 getCteDistDFeInteresseResult() {
            return this.localCteDistDFeInteresseResult;
        }

        /**
         * Auto generated setter method
         *
         * @param param CteDistDFeInteresseResult
         */
        public void setCteDistDFeInteresseResult(final CteDistDFeInteresseResult_type0 param) {
            // update the setting tracker
            this.localCteDistDFeInteresseResultTracker = param != null;
            this.localCteDistDFeInteresseResult = param;
        }

        /**
         * isReaderMTOMAware
         *
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(final javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware;
            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (final java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory) {
            final org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, CteDistDFeInteresseResponse.MY_QNAME) {

                @Override
                public void serialize(final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                    CteDistDFeInteresseResponse.this.serialize(CteDistDFeInteresseResponse.MY_QNAME, factory, xmlWriter);
                }
            };
            // return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(CteDistDFeInteresseResponse.MY_QNAME, factory, dataSource);
            return factory.createOMElement(dataSource, CteDistDFeInteresseResponse.MY_QNAME);
        }

        @Override
        public void serialize(final javax.xml.namespace.QName parentQName, final javax.xml.stream.XMLStreamWriter xmlWriter, final boolean serializeType) {
            this.serialize(parentQName, xmlWriter, serializeType);
        }

        @Override
        public void serialize(final javax.xml.namespace.QName parentQName, final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            this.serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory, final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            this.serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory, final javax.xml.stream.XMLStreamWriter xmlWriter, final boolean serializeType) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix;
            java.lang.String namespace;
            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            if ((namespace != null) && (namespace.trim().length() > 0)) {
                final java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = CteDistDFeInteresseResponse.generatePrefix(namespace);
                    }
                    xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }
            if (serializeType) {
                final java.lang.String namespacePrefix = this.registerPrefix(xmlWriter, "http://www.portalfiscal.inf.br/cte/wsdl/CTeDistribuicaoDFe");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    this.writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix + ":cteDistDFeInteresseResponse", xmlWriter);
                } else {
                    this.writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "cteDistDFeInteresseResponse", xmlWriter);
                }
            }
            if (this.localCteDistDFeInteresseResultTracker) {
                if (this.localCteDistDFeInteresseResult == null) {
                    throw new org.apache.axis2.databinding.ADBException("cteDistDFeInteresseResult cannot be null!!");
                }
                this.localCteDistDFeInteresseResult.serialize(new javax.xml.namespace.QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeDistribuicaoDFe", "cteDistDFeInteresseResult"), factory, xmlWriter);
            }
            xmlWriter.writeEndElement();
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

        private void writeQName(final javax.xml.namespace.QName qname, final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            final java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = CteDistDFeInteresseResponse.generatePrefix(namespaceURI);
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
                            prefix = CteDistDFeInteresseResponse.generatePrefix(namespaceURI);
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
                prefix = CteDistDFeInteresseResponse.generatePrefix(namespace);
                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
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
            public static CteDistDFeInteresseResponse parse(final javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                final CteDistDFeInteresseResponse object = new CteDistDFeInteresseResponse();
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
                            if (!"cteDistDFeInteresseResponse".equals(type)) {
                                // find namespace for the prefix
                                final java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (CteDistDFeInteresseResponse) ExtensionMapper.getTypeObject(nsUri, type, reader);
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
                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.portalfiscal.inf.br/cte/wsdl/CTeDistribuicaoDFe", "cteDistDFeInteresseResult").equals(reader.getName())) {
                        object.setCteDistDFeInteresseResult(CteDistDFeInteresseResult_type0.Factory.parse(reader));
                        reader.next();
                    } // End of if for expected property start element
                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }
                    if (reader.isStartElement()) {
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                    }
                } catch (final javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }
                return object;
            }
        }// end of factory class
    }

    public static class ExtensionMapper {

        public static java.lang.Object getTypeObject(final java.lang.String namespaceURI, final java.lang.String typeName, final javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
            if ("http://www.portalfiscal.inf.br/cte/wsdl/CTeDistribuicaoDFe".equals(namespaceURI) && "cteDistDFeInteresseResult_type0".equals(typeName)) {
                return CteDistDFeInteresseResult_type0.Factory.parse(reader);
            }
            if ("http://www.portalfiscal.inf.br/cte/wsdl/CTeDistribuicaoDFe".equals(namespaceURI) && "cteDadosMsg_type0".equals(typeName)) {
                return CteDadosMsg_type0.Factory.parse(reader);
            }
            throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
        }
    }

    public static class CteDistDFeInteresseResult_type0 implements org.apache.axis2.databinding.ADBBean {
        private static final long serialVersionUID = -3193367638280166354L;

        /*
         * This type was generated from the piece of schema that had name = cteDistDFeInteresseResult_type0 Namespace URI = http://www.portalfiscal.inf.br/cte/wsdl/CTeDistribuicaoDFe Namespace Prefix = ns1
         */
        private static java.lang.String generatePrefix(final java.lang.String namespace) {
            if (namespace.equals("http://www.portalfiscal.inf.br/cte/wsdl/CTeDistribuicaoDFe")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

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
            return this.localExtraElement;
        }

        /**
         * Auto generated setter method
         *
         * @param param ExtraElement
         */
        public void setExtraElement(final org.apache.axiom.om.OMElement param) {
            this.localExtraElement = param;
        }

        /**
         * isReaderMTOMAware
         *
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(final javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware;
            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (final java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory) {
            final org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, parentQName) {

                @Override
                public void serialize(final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                    CteDistDFeInteresseResult_type0.this.serialize(this.parentQName, factory, xmlWriter);
                }
            };
            // return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(parentQName, factory, dataSource);
            return factory.createOMElement(dataSource, parentQName);
        }

        @Override
        public void serialize(final javax.xml.namespace.QName parentQName, final javax.xml.stream.XMLStreamWriter xmlWriter, final boolean serializeType) {
            this.serialize(parentQName, xmlWriter, serializeType);
        }

        @Override
        public void serialize(final javax.xml.namespace.QName parentQName, final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            this.serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory, final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            this.serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory, final javax.xml.stream.XMLStreamWriter xmlWriter, final boolean serializeType) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix;
            java.lang.String namespace;
            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            if ((namespace != null) && (namespace.trim().length() > 0)) {
                final java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = CteDistDFeInteresseResult_type0.generatePrefix(namespace);
                    }
                    xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }
            if (serializeType) {
                final java.lang.String namespacePrefix = this.registerPrefix(xmlWriter, "http://www.portalfiscal.inf.br/cte/wsdl/CTeDistribuicaoDFe");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    this.writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix + ":cteDistDFeInteresseResult_type0", xmlWriter);
                } else {
                    this.writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "cteDistDFeInteresseResult_type0", xmlWriter);
                }
            }
            if (this.localExtraElement != null) {
                this.localExtraElement.serialize(xmlWriter);
            } else {
                throw new org.apache.axis2.databinding.ADBException("extraElement cannot be null!!");
            }
            xmlWriter.writeEndElement();
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

        private void writeQName(final javax.xml.namespace.QName qname, final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            final java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = CteDistDFeInteresseResult_type0.generatePrefix(namespaceURI);
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
                            prefix = CteDistDFeInteresseResult_type0.generatePrefix(namespaceURI);
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
                prefix = CteDistDFeInteresseResult_type0.generatePrefix(namespace);
                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
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
            public static CteDistDFeInteresseResult_type0 parse(final javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                final CteDistDFeInteresseResult_type0 object = new CteDistDFeInteresseResult_type0();
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
                            if (!"cteDistDFeInteresseResult_type0".equals(type)) {
                                // find namespace for the prefix
                                final java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (CteDistDFeInteresseResult_type0) ExtensionMapper.getTypeObject(nsUri, type, reader);
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
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                    }
                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }
                    if (reader.isStartElement()) {
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                    }
                } catch (final javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }
                return object;
            }
        }// end of factory class
    }

    private org.apache.axiom.om.OMElement toOM(final com.fincatto.documentofiscal.cte.webservices.distribuicao.CTeDistribuicaoDFeSoapStub.CteDistDFeInteresse param, final boolean optimizeContent) {
        //        try {
        return param.getOMElement(com.fincatto.documentofiscal.cte.webservices.distribuicao.CTeDistribuicaoDFeSoapStub.CteDistDFeInteresse.MY_QNAME, org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        //        } catch (final org.apache.axis2.databinding.ADBException e) {
        //            throw org.apache.axis2.AxisFault.makeFault(e);
        //        }
    }

    private org.apache.axiom.om.OMElement toOM(final com.fincatto.documentofiscal.cte.webservices.distribuicao.CTeDistribuicaoDFeSoapStub.CteDistDFeInteresseResponse param, final boolean optimizeContent) {
        //        try {
        return param.getOMElement(com.fincatto.documentofiscal.cte.webservices.distribuicao.CTeDistribuicaoDFeSoapStub.CteDistDFeInteresseResponse.MY_QNAME, org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        //        } catch (final org.apache.axis2.databinding.ADBException e) {
        //            throw org.apache.axis2.AxisFault.makeFault(e);
        //        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(final org.apache.axiom.soap.SOAPFactory factory, final com.fincatto.documentofiscal.cte.webservices.distribuicao.CTeDistribuicaoDFeSoapStub.CteDistDFeInteresse param, final boolean optimizeContent) {
        //        try {
        final org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
        emptyEnvelope.getBody().addChild(param.getOMElement(com.fincatto.documentofiscal.cte.webservices.distribuicao.CTeDistribuicaoDFeSoapStub.CteDistDFeInteresse.MY_QNAME, factory));
        return emptyEnvelope;
        //        } catch (final org.apache.axis2.databinding.ADBException e) {
        //            throw org.apache.axis2.AxisFault.makeFault(e);
        //        }
    }

    /* methods to provide back word compatibility */

    /**
     * get the default envelope
     */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(final org.apache.axiom.soap.SOAPFactory factory) {
        return factory.getDefaultEnvelope();
    }

    private java.lang.Object fromOM(final org.apache.axiom.om.OMElement param, final java.lang.Class type, final java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault {
        try {
            if (com.fincatto.documentofiscal.cte.webservices.distribuicao.CTeDistribuicaoDFeSoapStub.CteDistDFeInteresse.class.equals(type)) {
                return com.fincatto.documentofiscal.cte.webservices.distribuicao.CTeDistribuicaoDFeSoapStub.CteDistDFeInteresse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }
            if (com.fincatto.documentofiscal.cte.webservices.distribuicao.CTeDistribuicaoDFeSoapStub.CteDistDFeInteresseResponse.class.equals(type)) {
                return com.fincatto.documentofiscal.cte.webservices.distribuicao.CTeDistribuicaoDFeSoapStub.CteDistDFeInteresseResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }
        } catch (final java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
        return null;
    }
}
