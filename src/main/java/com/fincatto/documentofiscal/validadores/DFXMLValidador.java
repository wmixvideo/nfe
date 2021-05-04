package com.fincatto.documentofiscal.validadores;

import org.xml.sax.SAXException;

import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.IOException;
import java.io.StringReader;
import java.net.URISyntaxException;
import java.net.URL;

public final class DFXMLValidador {

    private static boolean valida(final String xml, final String xsd) throws IOException, SAXException, URISyntaxException {
        final URL xsdPath = DFXMLValidador.class.getClassLoader().getResource(String.format("schemas/PL_008i2/%s", xsd));
        final SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        final Schema schema = schemaFactory.newSchema(new StreamSource(xsdPath.toURI().toString()));
        schema.newValidator().validate(new StreamSource(new StringReader(xml)));
        return true;
    }

    public static boolean validaLote(final String arquivoXML) throws Exception {
        return DFXMLValidador.valida(arquivoXML, "enviNFe_v3.10.xsd");
    }

    public static boolean validaNota(final String arquivoXML) throws Exception {
        return DFXMLValidador.valida(arquivoXML, "nfe_v3.10.xsd");
    }

    public static boolean valida400(final String xml, final String xsd) throws IOException, SAXException, URISyntaxException {
        final URL xsdPath = DFXMLValidador.class.getClassLoader().getResource(String.format("schemas/PL_009_V4_00_NT_2020_006_v1.00/%s", xsd));
        final SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        final Schema schema = schemaFactory.newSchema(new StreamSource(xsdPath.toURI().toString()));
        schema.newValidator().validate(new StreamSource(new StringReader(xml)));
        return true;
    }

    public static boolean validaLote400(final String arquivoXML) throws Exception {
        return DFXMLValidador.valida400(arquivoXML, "enviNFe_v4.00.xsd");
    }

    public static boolean validaNota400(final String arquivoXML) throws Exception {
        return DFXMLValidador.valida400(arquivoXML, "nfe_v4.00.xsd");
    }

    /**
     * Valida MDFe. Para evitar "org.xml.sax.SAXParseException", message:
     * "Current configuration of the parser doesn't allow a maxOccurs attribute
     * value to be set greater than the value 5.000", foi adicionado a linha
     * System.setProperty("jdk.xml.maxOccurLimit", "10000");
     *
     * @param xml
     * @param xsd
     * @return
     * @throws IOException
     * @throws SAXException
     * @throws URISyntaxException
     */
    private static boolean validaMDF(final String xml, final String xsd) throws IOException, SAXException, URISyntaxException {
        System.setProperty("jdk.xml.maxOccurLimit", "10000");
        final URL xsdPath = DFXMLValidador.class.getClassLoader().getResource(String.format("schemas/PL_MDFe_300a_NT02020_NFF/%s", xsd));
        final SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        final Schema schema = schemaFactory.newSchema(new StreamSource(xsdPath.toURI().toString()));
        schema.newValidator().validate(new StreamSource(new StringReader(xml)));
        return true;
    }

    public static boolean validaLoteMDFe(final String arquivoXML) throws Exception {
        return DFXMLValidador.validaMDF(arquivoXML, "enviMDFe_v3.00.xsd");
    }

    public static boolean validaMDFe(final String arquivoXML) throws Exception {
        return DFXMLValidador.validaMDF(arquivoXML, "mdfe_v3.00.xsd");
    }
    
    public static boolean validaMDFeProcessado(final String xml) throws Exception {
        return DFXMLValidador.validaMDF(xml, "procMDFe_v3.00.xsd");
    }

    public static boolean validaEventoMDFe(final String xml) throws Exception {
        return DFXMLValidador.validaMDF(xml, "eventoMDFe_v3.00.xsd");
    }

    public static boolean validaEventoPagamentoOperacaoMDFe(final String xml) throws Exception {
        return DFXMLValidador.validaMDF(xml, "evPagtoOperMDFe_v3.00.xsd");
    }

    private static boolean validaCTe(final String xml, final String xsd) throws IOException, SAXException, URISyntaxException {
        final URL xsdPath = DFXMLValidador.class.getClassLoader().getResource(String.format("schemas/PL_CTe_300a/%s", xsd));
        final SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        final Schema schema = schemaFactory.newSchema(new StreamSource(xsdPath.toURI().toString()));
        schema.newValidator().validate(new StreamSource(new StringReader(xml)));
        return true;
    }

    public static boolean validaLoteCTe(final String arquivoXML) throws Exception {
        return DFXMLValidador.validaCTe(arquivoXML, "enviCTe_v3.00.xsd");
    }

    public static boolean validaNotaCte(final String arquivoXML) throws Exception {
        return DFXMLValidador.validaCTe(arquivoXML, "cte_v3.00.xsd");
    }

    private static boolean validaDfe(final String xml, final String xsd) throws IOException, SAXException, URISyntaxException {
        final URL xsdPath = DFXMLValidador.class.getClassLoader().getResource(String.format("schemas/PL_NFeDistDFe_102/%s", xsd));
        final SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        final Schema schema = schemaFactory.newSchema(new StreamSource(xsdPath.toURI().toString()));
        schema.newValidator().validate(new StreamSource(new StringReader(xml)));
        return true;
    }

    public static boolean validaConsultaDfe(final String arquivoXML) throws Exception {
        return DFXMLValidador.validaDfe(arquivoXML, "distDFeInt_v1.01.xsd");
    }

    private static boolean validaEpec(final String xml, final String xsd) throws IOException, SAXException, URISyntaxException {
        final URL xsdPath = DFXMLValidador.class.getClassLoader().getResource(String.format("schemas/Evento_EPEC_PL_v1.01/%s", xsd));
        final SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        final Schema schema = schemaFactory.newSchema(new StreamSource(xsdPath.toURI().toString()));
        schema.newValidator().validate(new StreamSource(new StringReader(xml)));
        return true;
    }

    public static boolean validaEpec(final String arquivoXML) throws Exception {
        return DFXMLValidador.validaEpec(arquivoXML, "envEPEC_v1.00.xsd");
    }

    public static boolean validaEventoEpec(final String arquivoXML) throws Exception {
        return DFXMLValidador.validaEpec(arquivoXML, "EPEC_v1.00.xsd");
    }
}
