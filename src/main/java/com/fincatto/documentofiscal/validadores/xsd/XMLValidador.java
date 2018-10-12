package com.fincatto.documentofiscal.validadores.xsd;

import java.io.IOException;
import java.io.StringReader;
import java.net.URISyntaxException;
import java.net.URL;

import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

public final class XMLValidador {

    private static boolean valida(final String xml, final String xsd) throws IOException, SAXException, URISyntaxException {
        final URL xsdPath = XMLValidador.class.getClassLoader().getResource(String.format("schemas/PL_008i2/%s", xsd));
        final SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        final Schema schema = schemaFactory.newSchema(new StreamSource(xsdPath.toURI().toString()));
        schema.newValidator().validate(new StreamSource(new StringReader(xml)));
        return true;
    }

    public static boolean validaLote(final String arquivoXML) throws Exception {
        return XMLValidador.valida(arquivoXML, "enviNFe_v3.10.xsd");
    }

    public static boolean validaNota(final String arquivoXML) throws Exception {
        return XMLValidador.valida(arquivoXML, "nfe_v3.10.xsd");
    }

    private static boolean valida400(final String xml, final String xsd) throws IOException, SAXException, URISyntaxException {
        final URL xsdPath = XMLValidador.class.getClassLoader().getResource(String.format("schemas/PL_009_V4_2016_002_v160b/%s", xsd));
        final SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        final Schema schema = schemaFactory.newSchema(new StreamSource(xsdPath.toURI().toString()));
        schema.newValidator().validate(new StreamSource(new StringReader(xml)));
        return true;
    }

    public static boolean validaLote400(final String arquivoXML) throws Exception {
        return XMLValidador.valida400(arquivoXML, "enviNFe_v4.00.xsd");
    }

    private static boolean validaMDF(final String xml, final String xsd) throws IOException, SAXException, URISyntaxException {
        final URL xsdPath = XMLValidador.class.getClassLoader().getResource(String.format("schemas/PL_MDFe_300_NT022018/%s", xsd));
        final SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        final Schema schema = schemaFactory.newSchema(new StreamSource(xsdPath.toURI().toString()));
        schema.newValidator().validate(new StreamSource(new StringReader(xml)));
        return true;
    }

    public static boolean validaLoteMDFe(final String arquivoXML) throws Exception {
        return XMLValidador.validaMDF(arquivoXML, "enviMDFe_v3.00.xsd");
    }

    public static boolean validaMDFe(final String arquivoXML) throws Exception {
        return XMLValidador.validaMDF(arquivoXML, "mdfe_v3.00.xsd");
    }

    private static boolean validaCTe(final String xml, final String xsd) throws IOException, SAXException, URISyntaxException {
        final URL xsdPath = XMLValidador.class.getClassLoader().getResource(String.format("schemas/PL_CTe_300_NT2017.003/%s", xsd));
        final SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        final Schema schema = schemaFactory.newSchema(new StreamSource(xsdPath.toURI().toString()));
        schema.newValidator().validate(new StreamSource(new StringReader(xml)));
        return true;
    }

    public static boolean validaLoteCTe(final String arquivoXML) throws Exception {
        return XMLValidador.validaCTe(arquivoXML, "enviCTe_v3.00.xsd");
    }

    public static boolean validaNotaCte(final String arquivoXML) throws Exception {
        return XMLValidador.validaCTe(arquivoXML, "cte_v3.00.xsd");
    }

    private static boolean validaDfe(final String xml, final String xsd) throws IOException, SAXException, URISyntaxException {
        final URL xsdPath = XMLValidador.class.getClassLoader().getResource(String.format("schemas/PL_NFeDistDFe_102/%s", xsd));
        final SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        final Schema schema = schemaFactory.newSchema(new StreamSource(xsdPath.toURI().toString()));
        schema.newValidator().validate(new StreamSource(new StringReader(xml)));
        return true;
    }

    public static boolean validaConsultaDfe(final String arquivoXML) throws Exception {
        return XMLValidador.validaDfe(arquivoXML, "distDFeInt_v1.01.xsd");
    }
}