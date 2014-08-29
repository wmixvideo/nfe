package com.fincatto.nfe.validadores.xsd;

import java.io.File;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLValidador {
    private static final String SUN_JAXP_SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";
    private static final String SUN_JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
    private static final String W3_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
    private static ErroHandler erroHandler;

    public static void valida(final File arquivoXML, final String caminhoSchemaXSD) throws Throwable {
        final DocumentBuilder documentBuilder = XMLValidador.getDocumentBuilder(caminhoSchemaXSD);
        final Document document = documentBuilder.parse(arquivoXML);

        final Schema schema = XMLValidador.getSchema(caminhoSchemaXSD);
        final Validator validator = schema.newValidator();

        try {
            validator.validate(new DOMSource(document));
        } catch (final Exception e) {
            throw new IllegalStateException(XMLValidador.erroHandler.getMensagemComErros());
        }
    }

    public static void valida(final String arquivoXML, final String caminhoSchemaXSD) throws Throwable {
        final DocumentBuilder documentBuilder = XMLValidador.getDocumentBuilder(caminhoSchemaXSD);

        final InputSource inputSource = new InputSource();
        inputSource.setCharacterStream(new StringReader(arquivoXML));
        final Document document = documentBuilder.parse(inputSource);

        final Schema schema = XMLValidador.getSchema(caminhoSchemaXSD);
        final Validator validator = schema.newValidator();

        try {
            validator.validate(new DOMSource(document));
        } catch (final Exception e) {
            throw new IllegalStateException(XMLValidador.erroHandler.getMensagemComErros());
        }
    }

    private static Schema getSchema(final String caminhoSchemaXSD) throws SAXException {
        final SchemaFactory schemaFactory = SchemaFactory.newInstance(javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI);
        final Schema schema = schemaFactory.newSchema(new StreamSource(new File(caminhoSchemaXSD)));
        return schema;
    }

    private static DocumentBuilder getDocumentBuilder(final String caminhoSchemaXSD) throws ParserConfigurationException {
        XMLValidador.erroHandler = new ErroHandler();
        final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setNamespaceAware(true);
        documentBuilderFactory.setValidating(true);
        documentBuilderFactory.setAttribute(XMLValidador.SUN_JAXP_SCHEMA_LANGUAGE, XMLValidador.W3_XML_SCHEMA);
        documentBuilderFactory.setAttribute(XMLValidador.SUN_JAXP_SCHEMA_SOURCE, caminhoSchemaXSD);

        final DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        documentBuilder.setErrorHandler(XMLValidador.erroHandler);
        return documentBuilder;
    }
}
