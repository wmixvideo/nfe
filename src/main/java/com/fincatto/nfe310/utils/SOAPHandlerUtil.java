package com.fincatto.nfe310.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SOAPHandlerUtil {

    private static final List<Node> namespaces = new ArrayList<>();
    private static final List<String> listURIToRemove = new ArrayList<>();
    private static final Map<String, String> listNamespacetoAdd = new HashMap<>();

    /**
     * Percorre todos os nós do XML
     * @param node
     */
    public static void forEachNode(Node node) {
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
    public static void getNamespaces(Node node) {
        //Análise do nó atual
        NamedNodeMap attributes = node.getAttributes();
        verificaNamespaces(attributes);
        //Lógica para percorrer todos os filhos
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            attributes = nodeList.item(i).getAttributes();
            verificaNamespaces(attributes); //Analisa se o atributo atual pertence a lista para ser removido
            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                forEachNode(nodeList.item(i));
            }
        }
    }

    /**
     * Método que verifica se os atributos de um nó pertencem a lista para ser removido
     * @param attributes
     * @throws DOMException
     */
    private static void verificaNamespaces(NamedNodeMap attributes) throws DOMException {
        if (attributes != null) {
            for (int j = 0; j < attributes.getLength(); j++) {
                Node _node = attributes.item(j);
                //Analisa se o atributo atual pertence a lista para ser removido
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
    public static void removePrefix(Node node) {
        if (node.getPrefix() != null && !node.getPrefix().isEmpty() && verifyNeedRemove(node)) {
            node.setPrefix("");
        }
    }

    /**
     * Analisa se um nó precisa ter o prefixo removido
     * @param node
     * @return
     */
    public static Boolean verifyNeedRemove(Node node) {
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
    public static void addNamespace(Node node) {
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
    public static void addListURIToRemove(String uri) {
        listURIToRemove.add(uri);
    }

    /**
     * Adiciona Namespaces para inclusão no XML
     * @param nodeName
     * @param uri
     */
    public static void addListNamespacetoAdd(String nodeName, String uri) {
        listNamespacetoAdd.put(nodeName, uri);
    }

}
