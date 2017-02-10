
package br.inf.portalfiscal.cte.wsdl.ctestatusservico.mt;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.inf.portalfiscal.cte.wsdl.ctestatusservico package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CteCabecMsg_QNAME = new QName("http://www.portalfiscal.inf.br/cte/wsdl/CteStatusServico", "cteCabecMsg");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.inf.portalfiscal.cte.wsdl.ctestatusservico
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CteDadosMsg }
     * 
     */
    public CteDadosMsg createCteDadosMsg() {
        return new CteDadosMsg();
    }

    /**
     * Create an instance of {@link CteStatusServicoCTResult }
     * 
     */
    public CteStatusServicoCTResult createCteStatusServicoCTResult() {
        return new CteStatusServicoCTResult();
    }

    /**
     * Create an instance of {@link CteCabecMsg }
     * 
     */
    public CteCabecMsg createCteCabecMsg() {
        return new CteCabecMsg();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CteCabecMsg }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteStatusServico", name = "cteCabecMsg")
    public JAXBElement<CteCabecMsg> createCteCabecMsg(CteCabecMsg value) {
        return new JAXBElement<CteCabecMsg>(_CteCabecMsg_QNAME, CteCabecMsg.class, null, value);
    }

}
