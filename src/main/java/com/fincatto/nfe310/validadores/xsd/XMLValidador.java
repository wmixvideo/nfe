package com.fincatto.nfe310.validadores.xsd;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

public class XMLValidador {
    private static final String SUN_JAXP_SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";
    private static final String SUN_JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
    private static final String W3_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
    private static String CAMINHO_SCHEMA_LOTE;
    private static String CAMINHO_SCHEMA_NOTA;
    private static ErroHandler erroHandler;

    public static void validaLote(final File arquivoXML) throws Exception {
        XMLValidador.criaArquivosTemporarios();
        XMLValidador.valida(arquivoXML, XMLValidador.CAMINHO_SCHEMA_LOTE);
    }

    public static void validaLote(final String arquivoXML) throws Exception {
        XMLValidador.criaArquivosTemporarios();
        XMLValidador.valida(arquivoXML, XMLValidador.CAMINHO_SCHEMA_LOTE);
    }

    public static void validaNota(final String arquivoXML) throws Exception {
        XMLValidador.criaArquivosTemporarios();
        XMLValidador.valida(arquivoXML, XMLValidador.CAMINHO_SCHEMA_NOTA);
    }

    public static void validaNota(final File arquivoXML) throws Exception {
        XMLValidador.criaArquivosTemporarios();
        XMLValidador.valida(arquivoXML, XMLValidador.CAMINHO_SCHEMA_NOTA);
    }

    private static void criaArquivosTemporarios() throws IOException {
        final String diretorioTemporario = System.getProperty("java.io.tmpdir");
        final String[] xsds = {"nfe_v3.10.xsd", "enviNFe_v3.10.xsd", "leiauteNFe_v3.10.xsd", "tiposBasico_v3.10.xsd", "xmldsig-core-schema_v1.01.xsd"};
        for (final String xsd : xsds) {
            try (InputStream inputStream = XMLValidador.class.getResourceAsStream(String.format("schemas/%s", xsd))) {
                final File arquivo = new File(diretorioTemporario + xsd);
                final String arquivoConteudo = IOUtils.toString(inputStream, "UTF-8");
                FileUtils.writeStringToFile(arquivo, arquivoConteudo, false);

                if (arquivo.getName().contains("nfe_v3.10")) {
                    XMLValidador.CAMINHO_SCHEMA_NOTA = arquivo.getAbsolutePath();
                }

                if (arquivo.getName().contains("enviNFe_v3.10")) {
                    XMLValidador.CAMINHO_SCHEMA_LOTE = arquivo.getAbsolutePath();
                }
                arquivo.deleteOnExit();
            }
        }
    }

    private static void valida(final String arquivoXML, final String caminhoSchemaXSD) throws Exception {
        try {
            final DocumentBuilder documentBuilder = XMLValidador.getDocumentBuilder(caminhoSchemaXSD);
            final Document document = documentBuilder.parse(new InputSource(new StringReader(arquivoXML)));
            XMLValidador.getSchema(caminhoSchemaXSD).newValidator().validate(new DOMSource(document));
        } catch (final Exception e) {
            throw new IllegalStateException(XMLValidador.erroHandler.getMensagemComErros());
        }
    }

    private static void valida(final File arquivoXML, final String caminhoSchemaXSD) throws Exception {
        try {
            final DocumentBuilder documentBuilder = XMLValidador.getDocumentBuilder(caminhoSchemaXSD);
            final Document document = documentBuilder.parse(arquivoXML);
            XMLValidador.getSchema(caminhoSchemaXSD).newValidator().validate(new DOMSource(document));
        } catch (final Exception e) {
            throw new IllegalStateException(XMLValidador.erroHandler.getMensagemComErros());
        }
    }

    private static Schema getSchema(final String caminhoSchemaXSD) throws SAXException {
        final SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        return schemaFactory.newSchema(new StreamSource(new File(caminhoSchemaXSD)));
    }

    private static DocumentBuilder getDocumentBuilder(final String caminhoSchemaXSD) throws ParserConfigurationException {
        final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setAttribute(XMLValidador.SUN_JAXP_SCHEMA_LANGUAGE, XMLValidador.W3_XML_SCHEMA);
        documentBuilderFactory.setAttribute(XMLValidador.SUN_JAXP_SCHEMA_SOURCE, caminhoSchemaXSD);
        documentBuilderFactory.setNamespaceAware(true);
        documentBuilderFactory.setValidating(true);

        XMLValidador.erroHandler = new ErroHandler();
        final DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        documentBuilder.setErrorHandler(XMLValidador.erroHandler);
        return documentBuilder;
    }
}