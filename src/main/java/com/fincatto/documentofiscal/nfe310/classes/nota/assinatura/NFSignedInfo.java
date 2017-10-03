package com.fincatto.documentofiscal.nfe310.classes.nota.assinatura;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;

public class NFSignedInfo extends DFBase {
    private static final long serialVersionUID = -5878065134465400530L;

    @Element(name = "CanonicalizationMethod", required = false)
    private NFCanonicalizationMethod canonicalizationMethod;

    @Element(name = "SignatureMethod", required = false)
    private NFSignatureMethod signatureMethod;

    @Element(name = "Reference", required = false)
    private NFReference reference;

    public NFCanonicalizationMethod getCanonicalizationMethod() {
        return this.canonicalizationMethod;
    }

    public void setCanonicalizationMethod(final NFCanonicalizationMethod canonicalizationMethod) {
        this.canonicalizationMethod = canonicalizationMethod;
    }

    public NFSignatureMethod getSignatureMethod() {
        return this.signatureMethod;
    }

    public void setSignatureMethod(final NFSignatureMethod signatureMethod) {
        this.signatureMethod = signatureMethod;
    }

    public NFReference getReference() {
        return this.reference;
    }

    public void setReference(final NFReference reference) {
        this.reference = reference;
    }
}