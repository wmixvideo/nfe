package com.fincatto.documentofiscal.cte300.classes.nota.assinatura;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;

import com.fincatto.documentofiscal.DFBase;

@Namespace(reference = "http://www.w3.org/2000/09/xmldsig#")
public class CTeSignature extends DFBase {

    @Element(name = "SignedInfo", required = false)
    private CTeSignedInfo signedInfo;

    @Element(name = "SignatureValue", required = false)
    private String signatureValue;

    @Element(name = "KeyInfo", required = false)
    private CTeKeyInfo keyInfo;

    public CTeSignedInfo getSignedInfo() {
        return this.signedInfo;
    }

    public void setSignedInfo(final CTeSignedInfo signedInfo) {
        this.signedInfo = signedInfo;
    }

    public String getSignatureValue() {
        return this.signatureValue;
    }

    public void setSignatureValue(final String signatureValue) {
        this.signatureValue = signatureValue;
    }

    public CTeKeyInfo getKeyInfo() {
        return this.keyInfo;
    }

    public void setKeyInfo(final CTeKeyInfo keyInfo) {
        this.keyInfo = keyInfo;
    }
}