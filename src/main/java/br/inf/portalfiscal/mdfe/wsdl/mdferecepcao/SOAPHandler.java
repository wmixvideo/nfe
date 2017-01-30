package br.inf.portalfiscal.mdfe.wsdl.mdferecepcao;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SOAPHandler implements javax.xml.ws.handler.soap.SOAPHandler<SOAPMessageContext> {

    @Override
    public Set<QName> getHeaders() {
        return null;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        if ((boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY)) { //Check here that the message being intercepted is an outbound message from your service, otherwise ignore.
            try {
                SOAPMessage message = context.getMessage();

                SOAPBody body = message.getSOAPBody();
                Document document = body.extractContentAsDocument();
                NodeList nodes = document.getChildNodes();
                for (int i = 0; i < nodes.getLength(); i++) {
                    Node current = nodes.item(i);

                    NodeList childNodes = current.getChildNodes();
                    for (int j = 0; j < childNodes.getLength(); j++) {
                        Node currentChildNode = childNodes.item(j);
                        if ("return".equals(currentChildNode.getLocalName())) {
                            currentChildNode.setTextContent("PutByServerSOAPHandler");
                        }
                    }
                }
                body.addDocument(document);
                message.saveChanges();
            } catch (SOAPException ex) {
                Logger.getLogger(SOAPHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true; //indicates to the context to proceed with (normal)message processing
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return true;
    }

    @Override
    public void close(MessageContext context) {
    }

}
