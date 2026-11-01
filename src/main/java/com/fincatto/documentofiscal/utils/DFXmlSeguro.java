package com.fincatto.documentofiscal.utils;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerFactory;

/**
 * Fabricas JAXP endurecidas contra XXE (entidades externas/DTD) e entity expansion, para uso em
 * todos os pontos da biblioteca que parseiam ou serializam XML - tanto os que processam resposta
 * da SEFAZ quanto os que recebem XML do usuario (assinatura, validacao de assinatura).
 */
public abstract class DFXmlSeguro {

    /**
     * {@link DocumentBuilderFactory} namespace-aware com DTD desabilitado, entidades externas
     * bloqueadas e {@code FEATURE_SECURE_PROCESSING} habilitado.
     */
    public static DocumentBuilderFactory documentBuilderFactory() throws ParserConfigurationException {
        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
        factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        factory.setXIncludeAware(false);
        factory.setExpandEntityReferences(false);
        try {
            factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
        } catch (final IllegalArgumentException e) {
            // provider JAXP nao suporta o atributo - segue com o comportamento padrao dele
        }
        return factory;
    }

    /**
     * {@link TransformerFactory} com resolucao de DTD/stylesheet externos desabilitada. Alguns
     * providers JAXP alternativos (ex.: o Xalan empacotado pelo WildFly/JBoss) nao suportam esses
     * atributos e lancam {@link IllegalArgumentException} - nesse caso, segue sem eles.
     */
    public static TransformerFactory transformerFactory() {
        final TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
            transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
        } catch (final IllegalArgumentException e) {
            // provider JAXP nao suporta o atributo - segue com o comportamento padrao dele
        }
        return transformerFactory;
    }
}
