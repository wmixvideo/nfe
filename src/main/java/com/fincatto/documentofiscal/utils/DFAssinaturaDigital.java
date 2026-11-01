package com.fincatto.documentofiscal.utils;

import com.fincatto.documentofiscal.DFConfig;
import com.fincatto.documentofiscal.DFLog;
import org.apache.commons.lang3.StringUtils;
import org.apache.jcp.xml.dsig.internal.dom.XMLDSigRI;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.naming.ldap.LdapName;
import javax.xml.crypto.*;
import javax.xml.crypto.dsig.*;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.dom.DOMValidateContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.security.*;
import java.security.cert.X509Certificate;
import java.util.*;

public class DFAssinaturaDigital implements DFLog {

    private static final String C14N_TRANSFORM_METHOD = "http://www.w3.org/TR/2001/REC-xml-c14n-20010315";
    private static final String[] ELEMENTOS_ASSINAVEIS = new String[]{"infEvento", "infCanc", "infNFe", "infInut", "infMDFe", "infCte"};
    private final DFConfig config;

    public DFAssinaturaDigital(final DFConfig config) {
        this.config = config;
    }

    public static boolean isValida(final InputStream xmlStream) throws Exception {
        // parser endurecido: o XML validado aqui e, por definicao, de origem externa
        final Document document = DFXmlSeguro.documentBuilderFactory().newDocumentBuilder().parse(xmlStream);
        final NodeList nodeList = document.getElementsByTagNameNS(XMLSignature.XMLNS, "Signature");
        if (nodeList.getLength() == 0) {
            throw new IllegalStateException("Nao foi encontrada a assinatura do XML.");
        }

        final DOMValidateContext validateContext = new DOMValidateContext(new DFKeySelector(), nodeList.item(0));
        for (final String tag : DFAssinaturaDigital.ELEMENTOS_ASSINAVEIS) {
            final NodeList elements = document.getElementsByTagName(tag);
            // registra o atributo Id de todos os elementos (um lote pode ter varios infNFe, por
            // exemplo) para que as referencias #Id de qualquer assinatura do documento resolvam
            for (int i = 0; i < elements.getLength(); i++) {
                validateContext.setIdAttributeNS((Element) elements.item(i), null, "Id");
            }
        }

//        final String providerName = System.getProperty("jsr105Provider", "org.jcp.xml.dsig.internal.dom.XMLDSigRI");
//        final XMLSignatureFactory signatureFactory = XMLSignatureFactory.getInstance("DOM", (Provider) Class.forName(providerName).getDeclaredConstructor().newInstance());

        final XMLSignatureFactory signatureFactory = XMLSignatureFactory.getInstance("DOM", new XMLDSigRI());
        return signatureFactory.unmarshalXMLSignature(validateContext).validate(validateContext);
    }

    public String assinarDocumento(final String conteudoXml) throws Exception {
        return this.assinarDocumento(conteudoXml, DFAssinaturaDigital.ELEMENTOS_ASSINAVEIS);
    }

    public String assinarDocumento(final String conteudoXml, final String... elementosAssinaveis) throws Exception {
        try (StringReader reader = new StringReader(conteudoXml)) {
            try (StringWriter writer = new StringWriter()) {
                this.assinarDocumento(reader, writer, elementosAssinaveis);
                return writer.toString();
            }
        }
    }

    public void assinarDocumento(final Reader xmlReader, final Writer xmlAssinado, final String... elementosAssinaveis) throws Exception {
        final KeyStore.PrivateKeyEntry keyEntry = getPrivateKeyEntry();

        final String dn = ((X509Certificate) keyEntry.getCertificate()).getSubjectX500Principal().getName();
        this.getLogger().debug("DN: {}", dn);

        final String cn = new LdapName(dn).getRdns().stream()
                .filter(rdn -> StringUtils.equalsIgnoreCase(rdn.getType(), "CN"))
                .map(val -> String.valueOf(val.getValue()))
                .findFirst()
                .orElse("");
        this.getLogger().debug("CN: {}", cn);


        final XMLSignatureFactory signatureFactory = XMLSignatureFactory.getInstance("DOM");
        final List<Transform> transforms = new ArrayList<>(2);
        transforms.add(signatureFactory.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null));
        transforms.add(signatureFactory.newTransform(DFAssinaturaDigital.C14N_TRANSFORM_METHOD, (TransformParameterSpec) null));

        final KeyInfoFactory keyInfoFactory = signatureFactory.getKeyInfoFactory();
        final X509Data x509Data = keyInfoFactory.newX509Data(Collections.singletonList((X509Certificate) keyEntry.getCertificate()));
        final KeyInfo keyInfo = keyInfoFactory.newKeyInfo(Collections.singletonList(x509Data));
        final Document document = DFXmlSeguro.documentBuilderFactory().newDocumentBuilder().parse(new InputSource(xmlReader));
        for (final String elementoAssinavel : elementosAssinaveis) {
            final NodeList elements = document.getElementsByTagName(elementoAssinavel);
            for (int i = 0; i < elements.getLength(); i++) {
                final Element element = (Element) elements.item(i);
                final String id = element.getAttribute("Id");
                if (StringUtils.isBlank(id)) {
                    // sem o atributo Id a referencia viraria "#" (o documento inteiro), gerando
                    // assinatura invalida rejeitada pela SEFAZ sem indicacao da causa
                    throw new IllegalStateException("Elemento <" + elementoAssinavel + "> sem o atributo Id preenchido - impossivel assinar.");
                }
                element.setIdAttribute("Id", true);

                final Reference reference = signatureFactory.newReference("#" + id, signatureFactory.newDigestMethod(DigestMethod.SHA1, null), transforms, null, null);
                final SignedInfo signedInfo = signatureFactory.newSignedInfo(signatureFactory.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE, (C14NMethodParameterSpec) null), signatureFactory.newSignatureMethod(SignatureMethod.RSA_SHA1, null), Collections.singletonList(reference));
                final XMLSignature signature = signatureFactory.newXMLSignature(signedInfo, keyInfo);
                signature.sign(new DOMSignContext(keyEntry.getPrivateKey(), element.getParentNode()));
            }
        }

        final Transformer transformer = DFXmlSeguro.transformerFactory().newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.transform(new DOMSource(document), new StreamResult(xmlAssinado));
    }

    private KeyStore.PrivateKeyEntry getPrivateKeyEntry() throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableEntryException {
        final KeyStore.PasswordProtection passwordProtection = new KeyStore.PasswordProtection(this.config.getCertificadoSenha().toCharArray());
        try {
            if (StringUtils.isNotBlank(config.getCertificadoAlias())) {
                this.getLogger().debug("Usando alias informado: '{}'", config.getCertificadoAlias());
                return getPrivateKeyEntry(config.getCertificadoKeyStore(), config.getCertificadoAlias(), passwordProtection);
            } else {
                final KeyStore ks = config.getCertificadoKeyStore();
                for (Enumeration<String> e = ks.aliases(); e.hasMoreElements(); ) {
                    final String alias = e.nextElement();
                    if (ks.isKeyEntry(alias)) {
                        this.getLogger().debug("Usando alias descoberto: '{}'", alias);
                        return getPrivateKeyEntry(ks, alias, passwordProtection);
                    }
                }
                throw new KeyStoreException("N\u00E3o foi poss\u00EDvel encontrar a chave privada do certificado!");
            }
        } finally {
            try {
                // zera o char[] da senha copiado para a PasswordProtection (Destroyable)
                passwordProtection.destroy();
            } catch (final Exception e) {
                // destroy() da PasswordProtection nao lanca na pratica - ignora por seguranca
            }
        }
    }

    private static KeyStore.PrivateKeyEntry getPrivateKeyEntry(final KeyStore keyStore, final String alias, final KeyStore.PasswordProtection passwordProtection) throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableEntryException {
        final KeyStore.Entry entry = keyStore.getEntry(alias, passwordProtection);
        if (!(entry instanceof KeyStore.PrivateKeyEntry)) {
            throw new KeyStoreException("Alias '" + alias + "' nao encontrado no KeyStore ou nao contem chave privada!");
        }
        return (KeyStore.PrivateKeyEntry) entry;
    }

    public String assinarString(final String string) throws Exception {
        final byte[] buffer = string.getBytes(java.nio.charset.StandardCharsets.UTF_8);
        final Signature signatureProvider = Signature.getInstance("SHA1withRSA");
        signatureProvider.initSign(getPrivateKeyEntry().getPrivateKey());
        signatureProvider.update(buffer, 0, buffer.length);
        return Base64.getEncoder().encodeToString(signatureProvider.sign());
    }

    static class DFKeySelector extends KeySelector {
        @Override
        public KeySelectorResult select(final KeyInfo keyInfo, final KeySelector.Purpose purpose, final AlgorithmMethod method, final XMLCryptoContext context) throws KeySelectorException {
            for (final Object object : keyInfo.getContent()) {
                final XMLStructure info = (XMLStructure) object;
                if (info instanceof X509Data) {
                    final X509Data x509Data = (X509Data) info;
                    for (final Object certificado : x509Data.getContent()) {
                        if (certificado instanceof X509Certificate) {
                            final X509Certificate x509Certificate = (X509Certificate) certificado;
                            if (this.algEquals(method.getAlgorithm(), x509Certificate.getPublicKey().getAlgorithm())) {
                                return x509Certificate::getPublicKey;
                            }
                        }
                    }
                }
            }
            throw new KeySelectorException("Nao foi localizada a chave do certificado.");
        }

        private boolean algEquals(final String algURI, final String algName) {
            return ((algName.equalsIgnoreCase("DSA") && algURI.equalsIgnoreCase(SignatureMethod.DSA_SHA1)) || (algName.equalsIgnoreCase("RSA") && algURI.equalsIgnoreCase(SignatureMethod.RSA_SHA1)));
        }
    }
}