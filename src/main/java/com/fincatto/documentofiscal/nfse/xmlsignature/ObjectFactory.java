//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2025.10.07 às 11:09:41 PM BRT 
//


package com.fincatto.documentofiscal.nfse.xmlsignature;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.fincatto.documentofiscal.nfse.xmlsignature package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SPKIData_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "SPKIData");
    private final static QName _KeyInfo_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "KeyInfo");
    private final static QName _SignatureValue_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "SignatureValue");
    private final static QName _Evento_QNAME = new QName("http://www.sped.fazenda.gov.br/nfse", "evento");
    private final static QName _KeyValue_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "KeyValue");
    private final static QName _PedRegEvento_QNAME = new QName("http://www.sped.fazenda.gov.br/nfse", "pedRegEvento");
    private final static QName _NFSe_QNAME = new QName("http://www.sped.fazenda.gov.br/nfse", "NFSe");
    private final static QName _Transforms_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "Transforms");
    private final static QName _DigestMethod_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "DigestMethod");
    private final static QName _DPS_QNAME = new QName("http://www.sped.fazenda.gov.br/nfse", "DPS");
    private final static QName _X509Data_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "X509Data");
    private final static QName _SignatureProperty_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "SignatureProperty");
    private final static QName _CNC_QNAME = new QName("http://www.sped.fazenda.gov.br/nfse", "CNC");
    private final static QName _KeyName_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "KeyName");
    private final static QName _RSAKeyValue_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "RSAKeyValue");
    private final static QName _Signature_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "Signature");
    private final static QName _MgmtData_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "MgmtData");
    private final static QName _SignatureMethod_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "SignatureMethod");
    private final static QName _Object_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "Object");
    private final static QName _SignatureProperties_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "SignatureProperties");
    private final static QName _Transform_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "Transform");
    private final static QName _PGPData_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "PGPData");
    private final static QName _Reference_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "Reference");
    private final static QName _RetrievalMethod_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "RetrievalMethod");
    private final static QName _DSAKeyValue_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "DSAKeyValue");
    private final static QName _DigestValue_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "DigestValue");
    private final static QName _CanonicalizationMethod_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "CanonicalizationMethod");
    private final static QName _SignedInfo_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "SignedInfo");
    private final static QName _Manifest_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "Manifest");
    private final static QName _PGPDataTypePGPKeyID_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "PGPKeyID");
    private final static QName _PGPDataTypePGPKeyPacket_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "PGPKeyPacket");
    private final static QName _SPKIDataTypeSPKISexp_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "SPKISexp");
    private final static QName _SignatureMethodTypeHMACOutputLength_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "HMACOutputLength");
    private final static QName _TransformTypeXPath_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "XPath");
    private final static QName _X509DataTypeX509IssuerSerial_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "X509IssuerSerial");
    private final static QName _X509DataTypeX509CRL_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "X509CRL");
    private final static QName _X509DataTypeX509SubjectName_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "X509SubjectName");
    private final static QName _X509DataTypeX509SKI_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "X509SKI");
    private final static QName _X509DataTypeX509Certificate_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "X509Certificate");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.fincatto.documentofiscal.nfse.xmlsignature
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TCInfCNC }
     * 
     */
    public TCInfCNC createTCInfCNC() {
        return new TCInfCNC();
    }

    /**
     * Create an instance of {@link TCEvento }
     * 
     */
    public TCEvento createTCEvento() {
        return new TCEvento();
    }

    /**
     * Create an instance of {@link TCDPS }
     * 
     */
    public TCDPS createTCDPS() {
        return new TCDPS();
    }

    /**
     * Create an instance of {@link TCNC }
     * 
     */
    public TCNC createTCNC() {
        return new TCNC();
    }

    /**
     * Create an instance of {@link TCPedRegEvt }
     * 
     */
    public TCPedRegEvt createTCPedRegEvt() {
        return new TCPedRegEvt();
    }

    /**
     * Create an instance of {@link TCNFSe }
     * 
     */
    public TCNFSe createTCNFSe() {
        return new TCNFSe();
    }

    /**
     * Create an instance of {@link TCExploracaoRodoviaria }
     * 
     */
    public TCExploracaoRodoviaria createTCExploracaoRodoviaria() {
        return new TCExploracaoRodoviaria();
    }

    /**
     * Create an instance of {@link TCServ }
     * 
     */
    public TCServ createTCServ() {
        return new TCServ();
    }

    /**
     * Create an instance of {@link TE204207 }
     * 
     */
    public TE204207 createTE204207() {
        return new TE204207();
    }

    /**
     * Create an instance of {@link TE204203 }
     * 
     */
    public TE204203 createTE204203() {
        return new TE204203();
    }

    /**
     * Create an instance of {@link TCListaEventos }
     * 
     */
    public TCListaEventos createTCListaEventos() {
        return new TCListaEventos();
    }

    /**
     * Create an instance of {@link TCLocacaoSublocacao }
     * 
     */
    public TCLocacaoSublocacao createTCLocacaoSublocacao() {
        return new TCLocacaoSublocacao();
    }

    /**
     * Create an instance of {@link TCInfoCompl }
     * 
     */
    public TCInfoCompl createTCInfoCompl() {
        return new TCInfoCompl();
    }

    /**
     * Create an instance of {@link TCInfPedReg }
     * 
     */
    public TCInfPedReg createTCInfPedReg() {
        return new TCInfPedReg();
    }

    /**
     * Create an instance of {@link TCEnderContribuinteCNC }
     * 
     */
    public TCEnderContribuinteCNC createTCEnderContribuinteCNC() {
        return new TCEnderContribuinteCNC();
    }

    /**
     * Create an instance of {@link TCInfEvento }
     * 
     */
    public TCInfEvento createTCInfEvento() {
        return new TCInfEvento();
    }

    /**
     * Create an instance of {@link TCEnderecoSimples }
     * 
     */
    public TCEnderecoSimples createTCEnderecoSimples() {
        return new TCEnderecoSimples();
    }

    /**
     * Create an instance of {@link TCEnderObraEvento }
     * 
     */
    public TCEnderObraEvento createTCEnderObraEvento() {
        return new TCEnderObraEvento();
    }

    /**
     * Create an instance of {@link TE101101 }
     * 
     */
    public TE101101 createTE101101() {
        return new TE101101();
    }

    /**
     * Create an instance of {@link TE101103 }
     * 
     */
    public TE101103 createTE101103() {
        return new TE101103();
    }

    /**
     * Create an instance of {@link TCLocPrest }
     * 
     */
    public TCLocPrest createTCLocPrest() {
        return new TCLocPrest();
    }

    /**
     * Create an instance of {@link TE205204 }
     * 
     */
    public TE205204 createTE205204() {
        return new TE205204();
    }

    /**
     * Create an instance of {@link TCEndereco }
     * 
     */
    public TCEndereco createTCEndereco() {
        return new TCEndereco();
    }

    /**
     * Create an instance of {@link TCValoresNFSe }
     * 
     */
    public TCValoresNFSe createTCValoresNFSe() {
        return new TCValoresNFSe();
    }

    /**
     * Create an instance of {@link TE205208 }
     * 
     */
    public TE205208 createTE205208() {
        return new TE205208();
    }

    /**
     * Create an instance of {@link TCCServ }
     * 
     */
    public TCCServ createTCCServ() {
        return new TCCServ();
    }

    /**
     * Create an instance of {@link TE203206 }
     * 
     */
    public TE203206 createTE203206() {
        return new TE203206();
    }

    /**
     * Create an instance of {@link TCInfoTributacao }
     * 
     */
    public TCInfoTributacao createTCInfoTributacao() {
        return new TCInfoTributacao();
    }

    /**
     * Create an instance of {@link TE203202 }
     * 
     */
    public TE203202 createTE203202() {
        return new TE203202();
    }

    /**
     * Create an instance of {@link TCInfoDedRed }
     * 
     */
    public TCInfoDedRed createTCInfoDedRed() {
        return new TCInfoDedRed();
    }

    /**
     * Create an instance of {@link TCEnderExtSimples }
     * 
     */
    public TCEnderExtSimples createTCEnderExtSimples() {
        return new TCEnderExtSimples();
    }

    /**
     * Create an instance of {@link TCVDescCondIncond }
     * 
     */
    public TCVDescCondIncond createTCVDescCondIncond() {
        return new TCVDescCondIncond();
    }

    /**
     * Create an instance of {@link TCEnderecoEmitente }
     * 
     */
    public TCEnderecoEmitente createTCEnderecoEmitente() {
        return new TCEnderecoEmitente();
    }

    /**
     * Create an instance of {@link TCVServPrest }
     * 
     */
    public TCVServPrest createTCVServPrest() {
        return new TCVServPrest();
    }

    /**
     * Create an instance of {@link TE305103 }
     * 
     */
    public TE305103 createTE305103() {
        return new TE305103();
    }

    /**
     * Create an instance of {@link TE305102 }
     * 
     */
    public TE305102 createTE305102() {
        return new TE305102();
    }

    /**
     * Create an instance of {@link TE305101 }
     * 
     */
    public TE305101 createTE305101() {
        return new TE305101();
    }

    /**
     * Create an instance of {@link TCInfoPrestador }
     * 
     */
    public TCInfoPrestador createTCInfoPrestador() {
        return new TCInfoPrestador();
    }

    /**
     * Create an instance of {@link TCEnderExt }
     * 
     */
    public TCEnderExt createTCEnderExt() {
        return new TCEnderExt();
    }

    /**
     * Create an instance of {@link TCTribTotal }
     * 
     */
    public TCTribTotal createTCTribTotal() {
        return new TCTribTotal();
    }

    /**
     * Create an instance of {@link TCTribTotalPercent }
     * 
     */
    public TCTribTotalPercent createTCTribTotalPercent() {
        return new TCTribTotalPercent();
    }

    /**
     * Create an instance of {@link TE202205 }
     * 
     */
    public TE202205 createTE202205() {
        return new TE202205();
    }

    /**
     * Create an instance of {@link TE202201 }
     * 
     */
    public TE202201 createTE202201() {
        return new TE202201();
    }

    /**
     * Create an instance of {@link TCDocDedRed }
     * 
     */
    public TCDocDedRed createTCDocDedRed() {
        return new TCDocDedRed();
    }

    /**
     * Create an instance of {@link TCSubstituicao }
     * 
     */
    public TCSubstituicao createTCSubstituicao() {
        return new TCSubstituicao();
    }

    /**
     * Create an instance of {@link TCInfoObra }
     * 
     */
    public TCInfoObra createTCInfoObra() {
        return new TCInfoObra();
    }

    /**
     * Create an instance of {@link TCTribTotalMonet }
     * 
     */
    public TCTribTotalMonet createTCTribTotalMonet() {
        return new TCTribTotalMonet();
    }

    /**
     * Create an instance of {@link TCRegTrib }
     * 
     */
    public TCRegTrib createTCRegTrib() {
        return new TCRegTrib();
    }

    /**
     * Create an instance of {@link TCExigSuspensa }
     * 
     */
    public TCExigSuspensa createTCExigSuspensa() {
        return new TCExigSuspensa();
    }

    /**
     * Create an instance of {@link TCTribMunicipal }
     * 
     */
    public TCTribMunicipal createTCTribMunicipal() {
        return new TCTribMunicipal();
    }

    /**
     * Create an instance of {@link TCListaDocDedRed }
     * 
     */
    public TCListaDocDedRed createTCListaDocDedRed() {
        return new TCListaDocDedRed();
    }

    /**
     * Create an instance of {@link TCDocNFNFS }
     * 
     */
    public TCDocNFNFS createTCDocNFNFS() {
        return new TCDocNFNFS();
    }

    /**
     * Create an instance of {@link TCDocOutNFSe }
     * 
     */
    public TCDocOutNFSe createTCDocOutNFSe() {
        return new TCDocOutNFSe();
    }

    /**
     * Create an instance of {@link TCInfoEventoRejeicao }
     * 
     */
    public TCInfoEventoRejeicao createTCInfoEventoRejeicao() {
        return new TCInfoEventoRejeicao();
    }

    /**
     * Create an instance of {@link TCInfoPessoa }
     * 
     */
    public TCInfoPessoa createTCInfoPessoa() {
        return new TCInfoPessoa();
    }

    /**
     * Create an instance of {@link TCInfNFSe }
     * 
     */
    public TCInfNFSe createTCInfNFSe() {
        return new TCInfNFSe();
    }

    /**
     * Create an instance of {@link TE105102 }
     * 
     */
    public TE105102 createTE105102() {
        return new TE105102();
    }

    /**
     * Create an instance of {@link TCBeneficioMunicipal }
     * 
     */
    public TCBeneficioMunicipal createTCBeneficioMunicipal() {
        return new TCBeneficioMunicipal();
    }

    /**
     * Create an instance of {@link TE105105 }
     * 
     */
    public TE105105 createTE105105() {
        return new TE105105();
    }

    /**
     * Create an instance of {@link TE105104 }
     * 
     */
    public TE105104 createTE105104() {
        return new TE105104();
    }

    /**
     * Create an instance of {@link TCEnderNac }
     * 
     */
    public TCEnderNac createTCEnderNac() {
        return new TCEnderNac();
    }

    /**
     * Create an instance of {@link TCInfoContribuinteCNC }
     * 
     */
    public TCInfoContribuinteCNC createTCInfoContribuinteCNC() {
        return new TCInfoContribuinteCNC();
    }

    /**
     * Create an instance of {@link TCEmitente }
     * 
     */
    public TCEmitente createTCEmitente() {
        return new TCEmitente();
    }

    /**
     * Create an instance of {@link TCComExterior }
     * 
     */
    public TCComExterior createTCComExterior() {
        return new TCComExterior();
    }

    /**
     * Create an instance of {@link TCInfoValores }
     * 
     */
    public TCInfoValores createTCInfoValores() {
        return new TCInfoValores();
    }

    /**
     * Create an instance of {@link TCAtvEvento }
     * 
     */
    public TCAtvEvento createTCAtvEvento() {
        return new TCAtvEvento();
    }

    /**
     * Create an instance of {@link TCInfDPS }
     * 
     */
    public TCInfDPS createTCInfDPS() {
        return new TCInfDPS();
    }

    /**
     * Create an instance of {@link TCTribFederal }
     * 
     */
    public TCTribFederal createTCTribFederal() {
        return new TCTribFederal();
    }

    /**
     * Create an instance of {@link TCTribOutrosPisCofins }
     * 
     */
    public TCTribOutrosPisCofins createTCTribOutrosPisCofins() {
        return new TCTribOutrosPisCofins();
    }

    /**
     * Create an instance of {@link TCInfoEventoAnulacaoRejeicao }
     * 
     */
    public TCInfoEventoAnulacaoRejeicao createTCInfoEventoAnulacaoRejeicao() {
        return new TCInfoEventoAnulacaoRejeicao();
    }

    /**
     * Create an instance of {@link PGPDataType }
     * 
     */
    public PGPDataType createPGPDataType() {
        return new PGPDataType();
    }

    /**
     * Create an instance of {@link KeyValueType }
     * 
     */
    public KeyValueType createKeyValueType() {
        return new KeyValueType();
    }

    /**
     * Create an instance of {@link DSAKeyValueType }
     * 
     */
    public DSAKeyValueType createDSAKeyValueType() {
        return new DSAKeyValueType();
    }

    /**
     * Create an instance of {@link ReferenceType }
     * 
     */
    public ReferenceType createReferenceType() {
        return new ReferenceType();
    }

    /**
     * Create an instance of {@link RetrievalMethodType }
     * 
     */
    public RetrievalMethodType createRetrievalMethodType() {
        return new RetrievalMethodType();
    }

    /**
     * Create an instance of {@link TransformsType }
     * 
     */
    public TransformsType createTransformsType() {
        return new TransformsType();
    }

    /**
     * Create an instance of {@link CanonicalizationMethodType }
     * 
     */
    public CanonicalizationMethodType createCanonicalizationMethodType() {
        return new CanonicalizationMethodType();
    }

    /**
     * Create an instance of {@link DigestMethodType }
     * 
     */
    public DigestMethodType createDigestMethodType() {
        return new DigestMethodType();
    }

    /**
     * Create an instance of {@link ManifestType }
     * 
     */
    public ManifestType createManifestType() {
        return new ManifestType();
    }

    /**
     * Create an instance of {@link SignaturePropertyType }
     * 
     */
    public SignaturePropertyType createSignaturePropertyType() {
        return new SignaturePropertyType();
    }

    /**
     * Create an instance of {@link X509DataType }
     * 
     */
    public X509DataType createX509DataType() {
        return new X509DataType();
    }

    /**
     * Create an instance of {@link SignedInfoType }
     * 
     */
    public SignedInfoType createSignedInfoType() {
        return new SignedInfoType();
    }

    /**
     * Create an instance of {@link RSAKeyValueType }
     * 
     */
    public RSAKeyValueType createRSAKeyValueType() {
        return new RSAKeyValueType();
    }

    /**
     * Create an instance of {@link SPKIDataType }
     * 
     */
    public SPKIDataType createSPKIDataType() {
        return new SPKIDataType();
    }

    /**
     * Create an instance of {@link SignatureValueType }
     * 
     */
    public SignatureValueType createSignatureValueType() {
        return new SignatureValueType();
    }

    /**
     * Create an instance of {@link KeyInfoType }
     * 
     */
    public KeyInfoType createKeyInfoType() {
        return new KeyInfoType();
    }

    /**
     * Create an instance of {@link SignatureType }
     * 
     */
    public SignatureType createSignatureType() {
        return new SignatureType();
    }

    /**
     * Create an instance of {@link SignaturePropertiesType }
     * 
     */
    public SignaturePropertiesType createSignaturePropertiesType() {
        return new SignaturePropertiesType();
    }

    /**
     * Create an instance of {@link SignatureMethodType }
     * 
     */
    public SignatureMethodType createSignatureMethodType() {
        return new SignatureMethodType();
    }

    /**
     * Create an instance of {@link ObjectType }
     * 
     */
    public ObjectType createObjectType() {
        return new ObjectType();
    }

    /**
     * Create an instance of {@link TransformType }
     * 
     */
    public TransformType createTransformType() {
        return new TransformType();
    }

    /**
     * Create an instance of {@link X509IssuerSerialType }
     * 
     */
    public X509IssuerSerialType createX509IssuerSerialType() {
        return new X509IssuerSerialType();
    }

    /**
     * Create an instance of {@link TCInfCNC.ContribuintesCnc }
     * 
     */
    public TCInfCNC.ContribuintesCnc createTCInfCNCContribuintesCnc() {
        return new TCInfCNC.ContribuintesCnc();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SPKIDataType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "SPKIData")
    public JAXBElement<SPKIDataType> createSPKIData(SPKIDataType value) {
        return new JAXBElement<SPKIDataType>(_SPKIData_QNAME, SPKIDataType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KeyInfoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "KeyInfo")
    public JAXBElement<KeyInfoType> createKeyInfo(KeyInfoType value) {
        return new JAXBElement<KeyInfoType>(_KeyInfo_QNAME, KeyInfoType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SignatureValueType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "SignatureValue")
    public JAXBElement<SignatureValueType> createSignatureValue(SignatureValueType value) {
        return new JAXBElement<SignatureValueType>(_SignatureValue_QNAME, SignatureValueType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TCEvento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.sped.fazenda.gov.br/nfse", name = "evento")
    public JAXBElement<TCEvento> createEvento(TCEvento value) {
        return new JAXBElement<TCEvento>(_Evento_QNAME, TCEvento.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KeyValueType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "KeyValue")
    public JAXBElement<KeyValueType> createKeyValue(KeyValueType value) {
        return new JAXBElement<KeyValueType>(_KeyValue_QNAME, KeyValueType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TCPedRegEvt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.sped.fazenda.gov.br/nfse", name = "pedRegEvento")
    public JAXBElement<TCPedRegEvt> createPedRegEvento(TCPedRegEvt value) {
        return new JAXBElement<TCPedRegEvt>(_PedRegEvento_QNAME, TCPedRegEvt.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TCNFSe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.sped.fazenda.gov.br/nfse", name = "NFSe")
    public JAXBElement<TCNFSe> createNFSe(TCNFSe value) {
        return new JAXBElement<TCNFSe>(_NFSe_QNAME, TCNFSe.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransformsType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "Transforms")
    public JAXBElement<TransformsType> createTransforms(TransformsType value) {
        return new JAXBElement<TransformsType>(_Transforms_QNAME, TransformsType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DigestMethodType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "DigestMethod")
    public JAXBElement<DigestMethodType> createDigestMethod(DigestMethodType value) {
        return new JAXBElement<DigestMethodType>(_DigestMethod_QNAME, DigestMethodType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TCDPS }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.sped.fazenda.gov.br/nfse", name = "DPS")
    public JAXBElement<TCDPS> createDPS(TCDPS value) {
        return new JAXBElement<TCDPS>(_DPS_QNAME, TCDPS.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link X509DataType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "X509Data")
    public JAXBElement<X509DataType> createX509Data(X509DataType value) {
        return new JAXBElement<X509DataType>(_X509Data_QNAME, X509DataType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SignaturePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "SignatureProperty")
    public JAXBElement<SignaturePropertyType> createSignatureProperty(SignaturePropertyType value) {
        return new JAXBElement<SignaturePropertyType>(_SignatureProperty_QNAME, SignaturePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TCNC }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.sped.fazenda.gov.br/nfse", name = "CNC")
    public JAXBElement<TCNC> createCNC(TCNC value) {
        return new JAXBElement<TCNC>(_CNC_QNAME, TCNC.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "KeyName")
    public JAXBElement<String> createKeyName(String value) {
        return new JAXBElement<String>(_KeyName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RSAKeyValueType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "RSAKeyValue")
    public JAXBElement<RSAKeyValueType> createRSAKeyValue(RSAKeyValueType value) {
        return new JAXBElement<RSAKeyValueType>(_RSAKeyValue_QNAME, RSAKeyValueType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SignatureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "Signature")
    public JAXBElement<SignatureType> createSignature(SignatureType value) {
        return new JAXBElement<SignatureType>(_Signature_QNAME, SignatureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "MgmtData")
    public JAXBElement<String> createMgmtData(String value) {
        return new JAXBElement<String>(_MgmtData_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SignatureMethodType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "SignatureMethod")
    public JAXBElement<SignatureMethodType> createSignatureMethod(SignatureMethodType value) {
        return new JAXBElement<SignatureMethodType>(_SignatureMethod_QNAME, SignatureMethodType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObjectType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "Object")
    public JAXBElement<ObjectType> createObject(ObjectType value) {
        return new JAXBElement<ObjectType>(_Object_QNAME, ObjectType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SignaturePropertiesType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "SignatureProperties")
    public JAXBElement<SignaturePropertiesType> createSignatureProperties(SignaturePropertiesType value) {
        return new JAXBElement<SignaturePropertiesType>(_SignatureProperties_QNAME, SignaturePropertiesType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransformType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "Transform")
    public JAXBElement<TransformType> createTransform(TransformType value) {
        return new JAXBElement<TransformType>(_Transform_QNAME, TransformType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PGPDataType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "PGPData")
    public JAXBElement<PGPDataType> createPGPData(PGPDataType value) {
        return new JAXBElement<PGPDataType>(_PGPData_QNAME, PGPDataType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "Reference")
    public JAXBElement<ReferenceType> createReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_Reference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrievalMethodType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "RetrievalMethod")
    public JAXBElement<RetrievalMethodType> createRetrievalMethod(RetrievalMethodType value) {
        return new JAXBElement<RetrievalMethodType>(_RetrievalMethod_QNAME, RetrievalMethodType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DSAKeyValueType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "DSAKeyValue")
    public JAXBElement<DSAKeyValueType> createDSAKeyValue(DSAKeyValueType value) {
        return new JAXBElement<DSAKeyValueType>(_DSAKeyValue_QNAME, DSAKeyValueType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "DigestValue")
    public JAXBElement<byte[]> createDigestValue(byte[] value) {
        return new JAXBElement<byte[]>(_DigestValue_QNAME, byte[].class, null, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CanonicalizationMethodType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "CanonicalizationMethod")
    public JAXBElement<CanonicalizationMethodType> createCanonicalizationMethod(CanonicalizationMethodType value) {
        return new JAXBElement<CanonicalizationMethodType>(_CanonicalizationMethod_QNAME, CanonicalizationMethodType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SignedInfoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "SignedInfo")
    public JAXBElement<SignedInfoType> createSignedInfo(SignedInfoType value) {
        return new JAXBElement<SignedInfoType>(_SignedInfo_QNAME, SignedInfoType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ManifestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "Manifest")
    public JAXBElement<ManifestType> createManifest(ManifestType value) {
        return new JAXBElement<ManifestType>(_Manifest_QNAME, ManifestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "PGPKeyID", scope = PGPDataType.class)
    public JAXBElement<byte[]> createPGPDataTypePGPKeyID(byte[] value) {
        return new JAXBElement<byte[]>(_PGPDataTypePGPKeyID_QNAME, byte[].class, PGPDataType.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "PGPKeyPacket", scope = PGPDataType.class)
    public JAXBElement<byte[]> createPGPDataTypePGPKeyPacket(byte[] value) {
        return new JAXBElement<byte[]>(_PGPDataTypePGPKeyPacket_QNAME, byte[].class, PGPDataType.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "SPKISexp", scope = SPKIDataType.class)
    public JAXBElement<byte[]> createSPKIDataTypeSPKISexp(byte[] value) {
        return new JAXBElement<byte[]>(_SPKIDataTypeSPKISexp_QNAME, byte[].class, SPKIDataType.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "HMACOutputLength", scope = SignatureMethodType.class)
    public JAXBElement<BigInteger> createSignatureMethodTypeHMACOutputLength(BigInteger value) {
        return new JAXBElement<BigInteger>(_SignatureMethodTypeHMACOutputLength_QNAME, BigInteger.class, SignatureMethodType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "XPath", scope = TransformType.class)
    public JAXBElement<String> createTransformTypeXPath(String value) {
        return new JAXBElement<String>(_TransformTypeXPath_QNAME, String.class, TransformType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link X509IssuerSerialType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "X509IssuerSerial", scope = X509DataType.class)
    public JAXBElement<X509IssuerSerialType> createX509DataTypeX509IssuerSerial(X509IssuerSerialType value) {
        return new JAXBElement<X509IssuerSerialType>(_X509DataTypeX509IssuerSerial_QNAME, X509IssuerSerialType.class, X509DataType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "X509CRL", scope = X509DataType.class)
    public JAXBElement<byte[]> createX509DataTypeX509CRL(byte[] value) {
        return new JAXBElement<byte[]>(_X509DataTypeX509CRL_QNAME, byte[].class, X509DataType.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "X509SubjectName", scope = X509DataType.class)
    public JAXBElement<String> createX509DataTypeX509SubjectName(String value) {
        return new JAXBElement<String>(_X509DataTypeX509SubjectName_QNAME, String.class, X509DataType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "X509SKI", scope = X509DataType.class)
    public JAXBElement<byte[]> createX509DataTypeX509SKI(byte[] value) {
        return new JAXBElement<byte[]>(_X509DataTypeX509SKI_QNAME, byte[].class, X509DataType.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "X509Certificate", scope = X509DataType.class)
    public JAXBElement<byte[]> createX509DataTypeX509Certificate(byte[] value) {
        return new JAXBElement<byte[]>(_X509DataTypeX509Certificate_QNAME, byte[].class, X509DataType.class, ((byte[]) value));
    }

}
