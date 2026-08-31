package com.fincatto.documentofiscal.validadores;

import java.io.IOException;
import java.io.StringReader;
import java.net.URISyntaxException;
import java.net.URL;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;

public final class DFXMLValidador {

    private static final String PACOTE_NFE310 = "schemas/PL_008i2";
    private static final String PACOTE_NFE400 = "schemas/PL_010e_NT2025.002_v1.01";
    private static final String PACOTE_MDFE300 = "schemas/PL_MDFe_300b_NT012025_1.03";
    private static final String PACOTE_CTE300 = "schemas/PL_CTe_300a_NT2022.001";
    private static final String PACOTE_CTE400 = "schemas/PL_CTe_400_NT2026.002 RTC_1.00";
    private static final String PACOTE_NFE_DIST_DFE = "schemas/PL_NFeDistDFe_102";
    private static final String PACOTE_CTE_DIST_DFE = "schemas/PL_CTeDistDFe_100";
    private static final String PACOTE_MDFE_DIST_DFE = "schemas/PL_MDFeDistDFe_100";
    private static final String PACOTE_EPEC = "schemas/Evento_EPEC_PL_v1.01";

    /**
     * Limite de maxOccurs aceito na compilacao dos schemas (o padrao do JDK e 5000 e alguns
     * schemas da SEFAZ, como o do MDF-e, declaram valores maiores). Configurado por instancia de
     * {@link SchemaFactory} - e nao mais via {@code System.setProperty("jdk.xml.maxOccurLimit")},
     * que mutava uma propriedade global do processo e afetava todo parsing XML da aplicacao
     * hospedeira.
     */
    private static final String MAX_OCCUR_LIMIT = "20000";

    /**
     * Valida o XML contra o XSD do pacote indicado, com o parser endurecido: DTD externo da
     * instancia bloqueado ({@code ACCESS_EXTERNAL_DTD}) e schema resolvido apenas do classpath.
     */
    private static boolean valida(final String xml, final String pacote, final String xsd) throws IOException, SAXException {
        final String caminho = pacote + "/" + xsd;
        final URL xsdPath = DFXMLValidador.class.getClassLoader().getResource(caminho);
        if (xsdPath == null) {
            throw new IllegalStateException("Schema nao encontrado no classpath: " + caminho + " (verifique o empacotamento dos resources)");
        }

        final SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        setPropertyOpcional(schemaFactory, XMLConstants.ACCESS_EXTERNAL_DTD, "");
        // limite de maxOccurs local a esta factory; nomes variam por versao do JDK
        if (!setPropertyOpcional(schemaFactory, "jdk.xml.maxOccurLimit", DFXMLValidador.MAX_OCCUR_LIMIT)) {
            setPropertyOpcional(schemaFactory, "http://www.oracle.com/xml/jaxp/properties/maxOccurLimit", DFXMLValidador.MAX_OCCUR_LIMIT);
        }

        final Schema schema = schemaFactory.newSchema(new StreamSource(xsdPath.toString()));
        final Validator validator = schema.newValidator();
        setPropertyOpcional(validator, XMLConstants.ACCESS_EXTERNAL_DTD, "");
        setPropertyOpcional(validator, XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
        validator.validate(new StreamSource(new StringReader(xml)));
        return true;
    }

    private static boolean setPropertyOpcional(final SchemaFactory factory, final String nome, final String valor) {
        try {
            factory.setProperty(nome, valor);
            return true;
        } catch (final SAXException e) {
            // provider JAXP nao suporta a propriedade - segue com o comportamento padrao dele
            return false;
        }
    }

    private static void setPropertyOpcional(final Validator validator, final String nome, final String valor) {
        try {
            validator.setProperty(nome, valor);
        } catch (final SAXException e) {
            // provider JAXP nao suporta a propriedade - segue com o comportamento padrao dele
        }
    }

    public static boolean validaLote(final String arquivoXML) throws Exception {
        return DFXMLValidador.valida(arquivoXML, DFXMLValidador.PACOTE_NFE310, "enviNFe_v3.10.xsd");
    }

    public static boolean validaNota(final String arquivoXML) throws Exception {
        return DFXMLValidador.valida(arquivoXML, DFXMLValidador.PACOTE_NFE310, "nfe_v3.10.xsd");
    }

    public static boolean valida400(final String xml, final String xsd) throws IOException, SAXException, URISyntaxException {
        return DFXMLValidador.valida(xml, DFXMLValidador.PACOTE_NFE400, xsd);
    }

    public static boolean validaLote400(final String arquivoXML) throws Exception {
        return DFXMLValidador.valida400(arquivoXML, "enviNFe_v4.00.xsd");
    }

    public static boolean validaNota400(final String arquivoXML) throws Exception {
        return DFXMLValidador.valida400(arquivoXML, "nfe_v4.00.xsd");
    }

    /**
     * Valida MDFe.
     * <br>
     * Schema PL_MDFe_300b_NT012025_1.03: adota CNPJ alfanumerico (NT 2026.004) no tipo TCnpj e
     * chave de acesso alfanumerica no tipo TChMDFe/TChCTe/TChNFe. Comparado ao pacote anterior
     * (PL_MDFe_300b_NT022024), as demais diferencas sao apenas relaxamentos de schema (campos que
     * passam a ser opcionais, novos valores de enumeracao, aumento de maxLength) - nenhum XML
     * valido antes deixa de validar apos a troca.
     * <br>
     * Limitacao conhecida do pacote oficial (arquivo .xsd fornecido pelo governo, nao alterado
     * neste projeto): o atributo Id de infMDFe usa um tipo anonimo proprio ainda com o padrao
     * numerico "MDFe[0-9]{44}", nao atualizado junto com TChMDFe. Uma chave de acesso realmente
     * alfanumerica (letras nas posicoes 6-19) portanto ainda e rejeitada nesse atributo especifico
     * ate a SEFAZ/ENCAT corrigir o pacote. Ver MDFProcessadoTest.schemaOficialAindaRejeitaAtributoIdComChaveDeAcessoAlfanumerica.
     */
    private static boolean validaMDF(final String xml, final String xsd) throws IOException, SAXException {
        return DFXMLValidador.valida(xml, DFXMLValidador.PACOTE_MDFE300, xsd);
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

    private static boolean validaCTe(final String xml, final String xsd) throws IOException, SAXException {
        return DFXMLValidador.valida(xml, DFXMLValidador.PACOTE_CTE300, xsd);
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

    private static boolean validaCTe400(final String xml, final String xsd) throws IOException, SAXException {
        return DFXMLValidador.valida(xml, DFXMLValidador.PACOTE_CTE400, xsd);
    }

    public static boolean validaNotaCte400(final String arquivoXML) throws Exception {
        return DFXMLValidador.validaCTe400(arquivoXML, "cte_v4.00.xsd");
    }

    public static boolean validaNotaCTeOS400(final String arquivoXML) throws Exception {
        return DFXMLValidador.validaCTe400(arquivoXML, "cteOS_v4.00.xsd");
    }

    public static boolean validaNotaCteSimp400(final String arquivoXML) throws Exception {
        return DFXMLValidador.validaCTe400(arquivoXML, "cteSimp_v4.00.xsd");
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

    public static boolean validaDistribuicaoCTe(final String arquivoXML) throws IOException, SAXException, URISyntaxException {
        return DFXMLValidador.valida(arquivoXML, DFXMLValidador.PACOTE_CTE_DIST_DFE, "distDFeInt_v1.00.xsd");
    }

    public static boolean validaDistribuicaoMDFe(final String arquivoXML) throws IOException, SAXException, URISyntaxException {
        return DFXMLValidador.valida(arquivoXML, DFXMLValidador.PACOTE_MDFE_DIST_DFE, "distDFeInt_v1.00.xsd");
    }

    public static boolean validaConsultaDfe(final String arquivoXML) throws Exception {
        return DFXMLValidador.valida(arquivoXML, DFXMLValidador.PACOTE_NFE_DIST_DFE, "distDFeInt_v1.01.xsd");
    }

    public static boolean validaEpec(final String arquivoXML) throws Exception {
        return DFXMLValidador.valida(arquivoXML, DFXMLValidador.PACOTE_EPEC, "envEPEC_v1.00.xsd");
    }

    public static boolean validaEventoEpec(final String arquivoXML) throws Exception {
        return DFXMLValidador.valida(arquivoXML, DFXMLValidador.PACOTE_EPEC, "EPEC_v1.00.xsd");
    }
}
