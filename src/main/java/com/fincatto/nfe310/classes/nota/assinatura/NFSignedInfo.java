package com.fincatto.nfe310.classes.nota.assinatura;

import org.simpleframework.xml.Element;

import com.fincatto.nfe310.classes.NFBase;

public class NFSignedInfo extends NFBase {

    @Element(name = "CanonicalizationMethod", required = false)
    private String canonicalizationMethod;

    @Element(name = "SignatureMethod", required = false)
    private String signatureMethod;

    @Element(name = "Reference", required = false)
    private NFReference reference;

    public String getCanonicalizationMethod() {
        return this.canonicalizationMethod;
    }

    public void setCanonicalizationMethod(final String canonicalizationMethod) {
        this.canonicalizationMethod = canonicalizationMethod;
    }

    public String getSignatureMethod() {
        return this.signatureMethod;
    }

    public void setSignatureMethod(final String signatureMethod) {
        this.signatureMethod = signatureMethod;
    }

    public NFReference getReference() {
        return this.reference;
    }

    public void setReference(final NFReference reference) {
        this.reference = reference;
    }
}