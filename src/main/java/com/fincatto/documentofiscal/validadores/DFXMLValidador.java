package com.fincatto.documentofiscal.validadores;

import java.io.IOException;
import java.io.StringReader;
import java.net.URISyntaxException;
import java.net.URL;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;

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
        final URL xsdPath = DFXMLValidador.class.getClassLoader().getResource(String.format("schemas/PL_010b_NT2025_002_v1.00/%s", xsd));
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
        System.setProperty("jdk.xml.maxOccurLimit", "20000");
        final URL xsdPath = DFXMLValidador.class.getClassLoader().getResource(String.format("schemas/PL_MDFe_300b_NT022024/%s", xsd));
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
        final URL xsdPath = DFXMLValidador.class.getClassLoader().getResource(String.format("schemas/PL_CTe_300a_NT2022.001/%s", xsd));
        final SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        final Schema schema = schemaFactory.newSchema(new StreamSource(xsdPath.toURI().toString()));
        schema.newValidator().validate(new StreamSource(new StringReader(xml)));
        return true;
    }

    public static boolean validaLoteCTe300(final String arquivoXML) throws Exception {
        return DFXMLValidador.validaCTe(arquivoXML, "enviCTe_v3.00.xsd");
    }

    public static boolean validaCTeOS300(final String arquivoXML) throws Exception {
        return DFXMLValidador.validaCTe(arquivoXML, "cteOS_v3.00.xsd");
    }

    public static boolean validaNotaCte(final String arquivoXML) throws Exception {
        return DFXMLValidador.validaCTe(arquivoXML, "cte_v3.00.xsd");
    }

    public static boolean validaEventoCTe300(final String arquivoXML) throws Exception {
        return DFXMLValidador.validaCTe(arquivoXML, "eventoCTe_v3.00.xsd");
    }

    public static boolean validaEventoCancelamentoCTe300(final String arquivoXML) throws Exception {
        return DFXMLValidador.validaCTe(arquivoXML, "evCancCTe_v3.00.xsd");
    }

    public static boolean validaEventoCancelamentoComprovanteEntregaCTe300(final String arquivoXML) throws Exception {
        return DFXMLValidador.validaCTe(arquivoXML, "evCancCECTe_v3.00.xsd");
    }

    public static boolean validaEventoCartaCorrecaoCTe300(final String arquivoXML) throws Exception {
        return DFXMLValidador.validaCTe(arquivoXML, "evCCeCTe_v3.00.xsd");
    }

    public static boolean validaEventoComprovanteEntregaCTe300(final String arquivoXML) throws Exception {
        return DFXMLValidador.validaCTe(arquivoXML, "evCECTe_v3.00.xsd");
    }

    public static boolean validaEventoEpecCTe300(final String arquivoXML) throws Exception {
        return DFXMLValidador.validaCTe(arquivoXML, "evEPECCTe_v3.00.xsd");
    }

    public static boolean validaEventoGtvCTe300(final String arquivoXML) throws Exception {
        return DFXMLValidador.validaCTe(arquivoXML, "evGTV_v3.00.xsd");
    }

    public static boolean validaEventoPrestacaoEmDesacordoCTe300(final String arquivoXML) throws Exception {
        return DFXMLValidador.validaCTe(arquivoXML, "evPrestDesacordo_v3.00.xsd");
    }

    public static boolean validaEventoRegistroMultimodalCTe300(final String arquivoXML) throws Exception {
        return DFXMLValidador.validaCTe(arquivoXML, "evRegMultimodal_v3.00.xsd");
    }

    private static boolean validaCTe400(final String xml, final String xsd) throws IOException, SAXException, URISyntaxException {
        final URL xsdPath = DFXMLValidador.class.getClassLoader().getResource(String.format("schemas/PL_CTe_400_NT2025.001_RTC_1.05/%s", xsd));
        final SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        final Schema schema = schemaFactory.newSchema(new StreamSource(xsdPath.toURI().toString()));
        schema.newValidator().validate(new StreamSource(new StringReader(xml)));
        return true;
    }

    public static boolean validaNotaCte400(final String arquivoXML) throws Exception {
        return DFXMLValidador.validaCTe400(arquivoXML, "cte_v4.00.xsd");
    }

    public static boolean validaNotaCTeOS400(final String arquivoXML) throws Exception {
        return DFXMLValidador.validaCTe400(arquivoXML, "cteOS_v4.00.xsd");
    }

    public static boolean validaEventoCTe400(final String arquivoXML) throws Exception {
        return DFXMLValidador.validaCTe400(arquivoXML, "eventoCTe_v4.00.xsd");
    }

    public static boolean validaEventoCancelamentoCTe400(final String arquivoXML) throws Exception {
        return DFXMLValidador.validaCTe400(arquivoXML, "evCancCTe_v4.00.xsd");
    }

    public static boolean validaEventoCancelamentoComprovanteEntregaCTe400(final String arquivoXML) throws Exception {
        return DFXMLValidador.validaCTe400(arquivoXML, "evCancCECTe_v4.00.xsd");
    }

    public static boolean validaEventoCartaCorrecaoCTe400(final String arquivoXML) throws Exception {
        return DFXMLValidador.validaCTe400(arquivoXML, "evCCeCTe_v4.00.xsd");
    }

    public static boolean validaEventoComprovanteEntregaCTe400(final String arquivoXML) throws Exception {
        return DFXMLValidador.validaCTe400(arquivoXML, "evCECTe_v4.00.xsd");
    }

    public static boolean validaEventoEpecCTe400(final String arquivoXML) throws Exception {
        return DFXMLValidador.validaCTe400(arquivoXML, "evEPECCTe_v4.00.xsd");
    }

    public static boolean validaEventoGtvCTe400(final String arquivoXML) throws Exception {
        return DFXMLValidador.validaCTe400(arquivoXML, "evGTV_v4.00.xsd");
    }

    public static boolean validaEventoPrestacaoEmDesacordoCTe400(final String arquivoXML) throws Exception {
        return DFXMLValidador.validaCTe400(arquivoXML, "evPrestDesacordo_v4.00.xsd");
    }

    public static boolean validaEventoRegistroMultimodalCTe400(final String arquivoXML) throws Exception {
        return DFXMLValidador.validaCTe400(arquivoXML, "evRegMultimodal_v4.00.xsd");
    }

    public static boolean validaEventoCancelamentoPrestacaoEmDesacordoCTe400(final String arquivoXML) throws Exception {
        return DFXMLValidador.validaCTe400(arquivoXML, "evCancPrestDesacordo_v4.00.xsd");
    }

    public static boolean validaEventoCancelamentoInsucessoEntregaCTe400(final String arquivoXML) throws Exception {
        return DFXMLValidador.validaCTe400(arquivoXML, "evCancIECTe_v4.00.xsd");
    }

    public static boolean validaEventoInsucessoEntregaCTe400(final String arquivoXML) throws Exception {
        return DFXMLValidador.validaCTe400(arquivoXML, "evIECTe_v4.00.xsd");
    }

    private static boolean validaDfe(final String xml, final String xsd) throws IOException, SAXException, URISyntaxException {
        final URL xsdPath = DFXMLValidador.class.getClassLoader().getResource(String.format("schemas/PL_NFeDistDFe_102/%s", xsd));
        final SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        final Schema schema = schemaFactory.newSchema(new StreamSource(xsdPath.toURI().toString()));
        schema.newValidator().validate(new StreamSource(new StringReader(xml)));
        return true;
    }
    private static boolean validaDistribuicaoCTe(final String xml, final String xsd) throws IOException, SAXException, URISyntaxException {
        final URL xsdPath = DFXMLValidador.class.getClassLoader().getResource(String.format("schemas/PL_CTeDistDFe_100/%s", xsd));
        final SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        final Schema schema = schemaFactory.newSchema(new StreamSource(xsdPath.toURI().toString()));
        schema.newValidator().validate(new StreamSource(new StringReader(xml)));
        return true;
    }
    public static boolean validaDistribuicaoCTe(final String arquivoXML) throws IOException, SAXException, URISyntaxException {
        return DFXMLValidador.validaDistribuicaoCTe(arquivoXML, "distDFeInt_v1.00.xsd");
    }

    private static boolean validaDistribuicaoMDFe(final String xml, final String xsd) throws IOException, SAXException, URISyntaxException {
        final URL xsdPath = DFXMLValidador.class.getClassLoader().getResource(String.format("schemas/PL_MDFeDistDFe_100/%s", xsd));
        final SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        final Schema schema = schemaFactory.newSchema(new StreamSource(xsdPath.toURI().toString()));
        schema.newValidator().validate(new StreamSource(new StringReader(xml)));
        return true;
    }
    public static boolean validaDistribuicaoMDFe(final String arquivoXML) throws IOException, SAXException, URISyntaxException {
        return DFXMLValidador.validaDistribuicaoMDFe(arquivoXML, "distDFeInt_v1.00.xsd");
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
