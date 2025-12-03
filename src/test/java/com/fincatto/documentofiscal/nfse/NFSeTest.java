package com.fincatto.documentofiscal.nfse;

import com.fincatto.documentofiscal.nfse.classes.nfsenacional.*;
import com.fincatto.documentofiscal.nfse.webservices.WSDANFSe;
import com.fincatto.documentofiscal.nfse.webservices.WSParametrosMunicipais;
import com.fincatto.documentofiscal.nfse.webservices.WSSefinNFSe;
import com.fincatto.documentofiscal.utils.DFCadeiaCertificadosTest;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import javax.xml.crypto.dsig.*;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.zip.GZIPInputStream;

/**
 * Classe que realiza os testes das NFSe.
 * Serve como uma documentação de como utilizar a biblioteca para NFSe.
 * Para gerar a cadeia de certificados, use o metodo {@link DFCadeiaCertificadosTest#geraCadeiaCertificadoHomologacao()}
 */
public class NFSeTest {

    private NFSEConfigFake config;

    @Before
    public void prepara() {
        this.config = new NFSEConfigFake(
                System.getenv("CERTIFICADO_PATH"),
                System.getenv("CERTIFICADO_SENHA"),
                System.getenv("CADEIA_CERTIFICADOS_PATH"),
                System.getenv("CADEIA_CERTIFICADOS_SENHA"));
    }

    @Ignore
    @Test
    public void consultaConvenioMunicipioTest() throws Exception {
        System.out.println("Teste de consulta de convênio do município na API de Parâmetros Municipais do Governo Federal");
        final var codigoDoMunicipio = "4216602"; // SC - São José
        final var consulta = new WSParametrosMunicipais(config).consultaConvenioMunicipio(codigoDoMunicipio);
        Assert.assertNotNull(consulta);
        System.out.println(consulta);
    }

    @Ignore
    @Test
    public void consultaAliquotaMunicipioServicoCompetenciaTest() throws Exception {
        System.out.println("Teste de consulta de alíquota do município para um serviço e competência na API de Parâmetros Municipais do Governo Federal");
        final var codigoDoMunicipio = "4216602";
        final var codigoDoServico = "31.01.04.000";
        final var dataCompetencia = LocalDate.now();
        final var consulta = new WSParametrosMunicipais(config).consultaAliquotaMunicipioServicoCompetencia(codigoDoMunicipio, codigoDoServico, dataCompetencia);
        System.out.println(consulta);
    }

    @Ignore
    @Test
    public void consultaHistoricoAliquotaMunicipioServicoTest() throws Exception {
        final var codigoDoMunicipio = "4216602";
        final var codigoDoServico = "01.01.01.000";
        final var consulta = new WSParametrosMunicipais(config).consultaHistoricoAliquotaMunicipioServico(codigoDoMunicipio, codigoDoServico);
        System.out.println(consulta);
    }

    @Ignore
    @Test
    public void consultaBeneficioMunicipioBeneficioCompetencia() {
        // Esse método está desativado por enquanto, pois não foi possível localizar o formato de código de benefício aceito pela API.
        // Assim que essa informação estiver disponível, o teste poderá ser reativado e ajustado
        //final var codigoDoMunicipio = "4216602";
        //final var codigoDoBeneficio = "00.00.00.000";
        //final var consulta = new WSParametrosMunicipais(config).consultaBeneficioMunicipioBeneficioCompetencia(codigoDoMunicipio, codigoDoBeneficio, LocalDate.now());;
        //System.out.println(consulta);
    }

    @Ignore
    @Test
    public void consultaRegimesEspeciaisMunicipioServicoCompetenciaTest() throws Exception {
        final var codigoDoMunicipio = "4216602";
        final var codigoDoServico = "17.01.01.000";
        final var consulta = new WSParametrosMunicipais(config).consultaRegimesEspeciaisMunicipioServicoCompetencia(codigoDoMunicipio, codigoDoServico, LocalDate.now());
        System.out.println(consulta);
    }

    @Ignore
    @Test
    public void consultaRetencoesMunicipioCompetenciaTest() throws Exception {
        final var codigoDoMunicipio = "4216602";
        final var consulta = new WSParametrosMunicipais(config).consultaRetencoesMunicipioCompetencia(codigoDoMunicipio, LocalDate.now().minusMonths(12));
        System.out.println(consulta);
    }

    @Ignore
    @Test
    public void downloadDANFSePdfChaveAcessoTest() throws Exception {
        System.out.println("Teste de download do DANFSe em PDF utilizando a chave de acesso da NFSe");
        final var nfseChaveAcesso = "";
        final var pathToSave = "";
        final var danfsePDF = new WSDANFSe(config).downloadDANFSePdfByChaveAcesso(nfseChaveAcesso);
        FileUtils.writeByteArrayToFile(new File(String.format("%s/%s.pdf", pathToSave, nfseChaveAcesso)), danfsePDF);
    }

    @Ignore
    @Test
    public void downloadXmlNFSeViaChaveAcessoTest() throws Exception {
        System.out.println("Teste de download do xml da NFSe");
        final var nfseChaveAcesso = "";
        final var pathToSave = "";
        final var responseXml = new WSSefinNFSe(config).getNFSeByChaveAcesso(nfseChaveAcesso);

        final byte[] conteudo = Base64.getDecoder().decode(responseXml.getNfseXmlGZipB64());//java 8
        try (GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(conteudo))) {
            try (BufferedReader bf = new BufferedReader(new InputStreamReader(gis, StandardCharsets.UTF_8))) {
                StringBuilder outStr = new StringBuilder();
                String line;
                while ((line = bf.readLine()) != null) {
                    outStr.append(line);
                }
                final var xml = config.getPersister().read(NFSeSefinNacionalNFSe.class, outStr.toString());
                FileUtils.writeStringToFile(new File(String.format("%s/%s.xml", pathToSave, nfseChaveAcesso)), xml.toXml());
            }
        }
    }

    @Ignore
    @Test
    public void testeAssinaturaXMLCompleto() throws Exception {
        String xmlString = "<p1:PedidoConsultaCNPJ xmlns:p1=\"http://www.prefeitura.sp.gov.br/nfe\"><Cabecalho Versao=\"1\"><CPFCNPJRemetente><CNPJ></CNPJ></CPFCNPJRemetente></Cabecalho><CNPJContribuinte><CNPJ></CNPJ></CNPJContribuinte></p1:PedidoConsultaCNPJ>";
    }

    public String assinarXml(String xmlString) throws Exception {
        final var keyStore = this.config.getCertificadoKeyStore();

        // Obter alias do certificado
        String alias = keyStore.aliases().nextElement();

        // Obter chave privada e certificado
        PrivateKey privateKey = (PrivateKey) keyStore.getKey(alias, this.config.getCertificadoSenha().toCharArray());
        X509Certificate certificate = (X509Certificate) keyStore.getCertificate(alias);

        // 2. Parsear o XML
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new StringReader(xmlString)));

        // 3. Criar a assinatura digital
        XMLSignatureFactory signatureFactory = XMLSignatureFactory.getInstance("DOM");
        List<Transform> transforms = new ArrayList<>();
        transforms.add(signatureFactory.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null));
        transforms.add(signatureFactory.newTransform(CanonicalizationMethod.INCLUSIVE, (TransformParameterSpec) null));

        // Criar Reference com SHA-1
        Reference reference = signatureFactory.newReference("", signatureFactory.newDigestMethod(DigestMethod.SHA1, null), transforms, null, null);

        // Criar SignedInfo com C14N e RSA-SHA1
        SignedInfo signedInfo = signatureFactory.newSignedInfo(signatureFactory.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE, (C14NMethodParameterSpec) null), signatureFactory.newSignatureMethod("http://www.w3.org/2000/09/xmldsig#rsa-sha1", null), Collections.singletonList(reference));

        // Criar KeyInfo com dados do certificado X.509
        KeyInfoFactory keyInfoFactory = signatureFactory.getKeyInfoFactory();
        List<Object> x509Content = new ArrayList<>();
        x509Content.add(certificate);

        X509Data x509Data = keyInfoFactory.newX509Data(x509Content);
        KeyInfo keyInfo = keyInfoFactory.newKeyInfo(Collections.singletonList(x509Data));

        // Criar a assinatura XML
        XMLSignature signature = signatureFactory.newXMLSignature(signedInfo, keyInfo);

        // 4. Assinar o documento
        Element rootElement = doc.getDocumentElement();
        DOMSignContext signContext = new DOMSignContext(privateKey, rootElement);
        signature.sign(signContext);

        // 5. Converter o documento assinado de volta para String
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(doc), new StreamResult(writer));
        return writer.getBuffer().toString();
    }

    @Ignore
    @Test
    public void testeEmitirNFSe() throws Exception {
        final var dps = new NFSeSefinNacionalDPS().setInfDPS(new NFSeSefinNacionalInfDPS()
                .setTipoAmbiente(NFSeSefinNacionalTipoAmbiente.HOMOLOGACAO)
                .setDataHoraEmissao(ZonedDateTime.of(2025, 10, 23, 10, 33, 19, 0, ZoneId.of("-03:00")))
                .setVersaoApp("NFSe Fake Teste 1.0")
                .setSerie("901")
                .setNumeroDPS("6")
                .setDataInicioPrestacaoServico(LocalDate.of(2025, 10, 23))
                .setTipoEmitente(NFSeSefinNacionalInfDPSTipoEmitente.PRESTADOR)
                .setCodigoMunicipioEmissao("4205407")
                .setPrestador(new NFSeSefinNacionalInfoPrestador().setCPF("").setRegimeTributario(new NFSeSefinNacionalRegTrib().setOpSimplesNacional(NFSeSefinNacionalRegimeTributarioSituacaoSimplesNacional.NAO_OPTANTE).setRegimeEspecialTributacao(NFSeSefinNacionalRegimeTributarioRegimeEspecialTributacao.NENHUM)))
                .setTomador(new NFSeSefinNacionalInfoPessoa().setCPF("").setNome(""))
                .setServicoPrestado(new NFSeSefinNacionalServ().setLocalPrestacao(new NFSeSefinNacionalLocPrest().setCodigoMunicipio("4205407")).setCServ(new NFSeSefinNacionalCServ().setCodigoNacionalTributacaoISSQN("170601").setDescricaoServico("Teste").setCodigoNBS("114061100")))
                .setValores(new NFSeSefinNacionalInfoValores().setValoresServicoPrestado(new NFSeSefinNacionalVServPrest().setValorServicos("10.00")).setTributos(new NFSeSefinNacionalInfoTributacao().setTributosMunicipais(new NFSeSefinNacionalTribMunicipal().setTributacaoISSQN(NFSeSefinNacionalTribMunicipalTributacaoISSQN.OPERACAO_TRIBUTAVEL).setTipoRetencaoISSQN(NFSeSefinNacionalTribMunicipalTipoRetencaoISSQN.NAO_RETIDO)).setTributosNacionais(new NFSeSefinNacionalTribFederal().setPiscofins(new NFSeSefinNacionalTribOutrosPisCofins().setCST(NFSeSefinNacionalTribOutrosPisCofinsSituacaoTributaria.CONTRIBUICAO_SEM_INCIDENCIA))).setTotalTributos(new NFSeSefinNacionalTribTotal().setIndicadorValorTotalTributos("0")))));

        new WSSefinNFSe(config).emitirNFSeByDPS(dps);
    }

    @Ignore
    @Test
    public void testeCancelamentoNFSeByChaveAcesso() throws Exception {
        final var evento = new NFSeSefinNacionalPedRegEvt().setInfPedReg(
                new NFSeSefinNacionalInfPedReg()
                        .setTpAmb(NFSeSefinNacionalTipoAmbiente.HOMOLOGACAO)
                        .setVerAplic("")
                        .setDhEvento(ZonedDateTime.of(2025, 10, 30, 15, 59, 19, 0, ZoneId.of("-03:00")))
                        .setCNPJAutor("")
                        .setChaveAcessoNFSE("")
                        .setNPedRegEvento("1")
                        .setEvento(new NFSeSefinNacionalInfPedRegTE101101()
                                .setcMotivo(NFSeSefinNacionalTSCodJustCanc.OUTROS)
                                .setxMotivo("Cancelamento de NFSe para testes"))
        );

        new WSSefinNFSe(config).enviarPedidoRegistroEvento(evento);
    }
}
