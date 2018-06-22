package com.fincatto.documentofiscal.assinatura;

import javax.xml.crypto.*;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import java.security.cert.X509Certificate;

class X509KeySelector extends KeySelector {

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