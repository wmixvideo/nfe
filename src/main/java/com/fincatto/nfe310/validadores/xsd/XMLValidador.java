package com.fincatto.nfe310.validadores.xsd;

import java.io.StringReader;
import java.net.URL;

import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

public final class XMLValidador {

    private static boolean validaXml(final String xml, final String xsd) throws Exception {
        final URL xsdPath = XMLValidador.class.getClassLoader().getResource(String.format("schemas/%s", xsd));
        final SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        final Schema schema = schemaFactory.newSchema(new StreamSource(xsdPath.toURI().toString()));
        schema.newValidator().validate(new StreamSource(new StringReader(xml)));
        return true;
    }

    public static boolean validaLote(final String arquivoXML) throws Exception {
        return XMLValidador.validaXml(arquivoXML, "enviNFe_v3.10.xsd");
    }

    public static boolean validaNota(final String arquivoXML) throws Exception {
        return XMLValidador.validaXml(arquivoXML, "nfe_v3.10.xsd");
    }
}