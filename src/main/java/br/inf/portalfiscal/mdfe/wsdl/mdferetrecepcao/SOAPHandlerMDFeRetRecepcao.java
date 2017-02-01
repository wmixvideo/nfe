package br.inf.portalfiscal.mdfe.wsdl.mdferetrecepcao;

import com.fincatto.nfe310.utils.SOAPHandlerUtil;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class SOAPHandlerMDFeRetRecepcao implements SOAPHandler<SOAPMessageContext> {

    @Override
    public Set<QName> getHeaders() {
        return null;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        if ((boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY)) {
            try {
                SOAPEnvelope msg = context.getMessage().getSOAPPart().getEnvelope();
                SOAPBody body = msg.getBody();

                SOAPHandlerUtil.addListURIToRemove("http://www.portalfiscal.inf.br/mdfe");
                SOAPHandlerUtil.getNamespaces(body.getFirstChild());
                SOAPHandlerUtil.forEachNode(body.getFirstChild());
            } catch (SOAPException ex) {
                Logger.getLogger(SOAPHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return true;
    }

    @Override
    public void close(MessageContext context) {

    }

    

}
