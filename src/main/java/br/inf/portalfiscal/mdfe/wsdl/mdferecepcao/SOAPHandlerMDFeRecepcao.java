package br.inf.portalfiscal.mdfe.wsdl.mdferecepcao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SOAPHandlerMDFeRecepcao implements SOAPHandler<SOAPMessageContext> {

    private final List<Node> namespaces = new ArrayList<>();
    private final List<String> listURIToRemove = new ArrayList<>();
    private final Map<String, String> listNamespacetoAdd = new HashMap<>();

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

                addListURIToRemove("http://www.w3.org/2000/09/xmldsig#");
                addListNamespacetoAdd("MDFe", "http://www.portalfiscal.inf.br/mdfe");
                addListNamespacetoAdd("Signature", "http://www.w3.org/2000/09/xmldsig#");

                getNamespaces(body.getFirstChild());
                forEachNode(body.getFirstChild());
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

    /**
     * Percorre todos os nós do XML
     * @param node
     */
    private void forEachNode(Node node) {
        removePrefix(node);
        addNamespace(node);
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node currentNode = nodeList.item(i);
            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                forEachNode(currentNode);
            }
        }
    }

    /**
     * Identifica os prefixos que serão removidos com base na URI
     * @param node
     */
    private void getNamespaces(Node node) {
        NamedNodeMap attributes = node.getAttributes();
        if (attributes != null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                Node _node = attributes.item(i);
                if (_node.getNodeType() == Node.ATTRIBUTE_NODE && listURIToRemove.contains(_node.getNodeValue())) {
                    namespaces.add(_node);
                }
            }
        }
    }

    /**
     * Remove o prefixo de um nó
     * @param node
     */
    private void removePrefix(Node node) {
        if (node.getPrefix() != null && !node.getPrefix().isEmpty() && verifyNeedRemove(node)) {
            node.setPrefix("");
        }
    }

    /**
     * Analisa se um nó precisa ter o prefixo removido
     * @param node
     * @return
     */
    private Boolean verifyNeedRemove(Node node) {
        for (Node n : namespaces) {
            if (n.getLocalName().equals(node.getPrefix())) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    /**
     * Adiciona um namespace ao nó
     * @param node
     */
    private void addNamespace(Node node) {
        if (listNamespacetoAdd.containsKey(node.getNodeName())) {
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                element.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns", listNamespacetoAdd.get(node.getNodeName()));
                node = (Node) element;
            }
        }
    }

    /**
     * Adiciona URIs onde o prefixo será removido do XML
     * @param uri
     */
    private void addListURIToRemove(String uri) {
        listURIToRemove.add(uri);
    }

    /**
     * Adiciona Namespaces para inclusão no XML
     * @param nodeName
     * @param uri
     */
    private void addListNamespacetoAdd(String nodeName, String uri) {
        listNamespacetoAdd.put(nodeName, uri);
    }


}
