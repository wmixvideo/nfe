package com.fincatto.nfe310.classes.nota.assinatura;

import org.simpleframework.xml.Element;

import com.fincatto.nfe310.classes.NFBase;

public class NFSignature extends NFBase {
    @Element(name = "SignedInfo", required = false)
    private NFSignedInfo signedInfo;
    @Element(name = "SignatureValue", required = false)
    private String signatureValue;
    @Element(name = "KeyInfo", required = false)
    private NFKeyInfo keyInfo;
}