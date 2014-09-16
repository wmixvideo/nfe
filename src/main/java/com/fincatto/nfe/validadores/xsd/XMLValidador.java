package com.fincatto.nfe.validadores.xsd;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
    private static String CAMINHO_SCHEMA_LOTE;
    private static ErroHandler erroHandler;
    private static String CAMINHO_SCHEMA_NOTA;

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
        final String[] xsds = { "nfe_v3.10.xsd", "enviNFe_v3.10.xsd", "leiauteNFe_v3.10.xsd", "tiposBasico_v3.10.xsd", "xmldsig-core-schema_v1.01.xsd" };
        final String caminhoDiretorioXSD = "../../../../../schemas/v3.1/";

        for (final String xsd : xsds) {
            try (final InputStream inputStream = XMLValidador.class.getResourceAsStream(caminhoDiretorioXSD + xsd)) {
                final File fileXSD = new File(diretorioTemporario + xsd);
                try (final FileOutputStream outputStream = new FileOutputStream(fileXSD)) {
                    int read = 0;
                    final byte[] bytes = new byte[1024];

                    while ((read = inputStream.read(bytes)) != -1) {
                        outputStream.write(bytes, 0, read);
                    }

                    if (fileXSD.getName().equals("nfe_v3.10.xsd")) {
                        XMLValidador.CAMINHO_SCHEMA_NOTA = fileXSD.getAbsolutePath();
                    }

                    if (fileXSD.getName().equals("enviNFe_v3.10.xsd")) {
                        XMLValidador.CAMINHO_SCHEMA_LOTE = fileXSD.getAbsolutePath();
                    }
                    fileXSD.deleteOnExit();
                }
            }
        }
    }

    private static void valida(final String arquivoXML, final String caminhoSchemaXSD) throws Exception {
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

    private static void valida(final File arquivoXML, final String caminhoSchemaXSD) throws Exception {
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