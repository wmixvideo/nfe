package com.fincatto.documentofiscal.cte300.classes.nota.assinatura;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;

public class CTeSignedInfo extends DFBase {
    private static final long serialVersionUID = 1072808318641459095L;

    @Element(name = "CanonicalizationMethod", required = false)
    private CTeCanonicalizationMethod canonicalizationMethod;

    @Element(name = "SignatureMethod", required = false)
    private CTeSignatureMethod signatureMethod;

    @Element(name = "Reference", required = false)
    private CTeReference reference;

    public CTeCanonicalizationMethod getCanonicalizationMethod() {
        return this.canonicalizationMethod;
    }

    public void setCanonicalizationMethod(final CTeCanonicalizationMethod canonicalizationMethod) {
        this.canonicalizationMethod = canonicalizationMethod;
    }

    public CTeSignatureMethod getSignatureMethod() {
        return this.signatureMethod;
    }

    public void setSignatureMethod(final CTeSignatureMethod signatureMethod) {
        this.signatureMethod = signatureMethod;
    }

    public CTeReference getReference() {
        return this.reference;
    }

    public void setReference(final CTeReference reference) {
        this.reference = reference;
    }
}