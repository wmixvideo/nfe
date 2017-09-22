package com.fincatto.documentofiscal.nfe310.classes.nota.assinatura;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe310.classes.nota.assinatura.NFKeyInfo;
import com.fincatto.documentofiscal.nfe310.classes.nota.assinatura.NFSignature;
import com.fincatto.documentofiscal.nfe310.classes.nota.assinatura.NFSignedInfo;

public class NFSignatureTest {

    @Test
    public void deveObterKeyInfoComoFoiSetado() {
        final NFSignature assinatura = new NFSignature();
        final NFKeyInfo keyInfo = new NFKeyInfo();
        assinatura.setKeyInfo(keyInfo);
        Assert.assertEquals(keyInfo, assinatura.getKeyInfo());
    }

    @Test
    public void deveObterSignatureValueComoFoiSetado() {
        final NFSignature assinatura = new NFSignature();
        final String signatureValue = "signature";
        assinatura.setSignatureValue(signatureValue);
        Assert.assertEquals(signatureValue, assinatura.getSignatureValue());
    }

    @Test
    public void deveObterSignedInfoComoFoiSetado() {
        final NFSignature assinatura = new NFSignature();
        final NFSignedInfo signedInfo = new NFSignedInfo();
        assinatura.setSignedInfo(signedInfo);
        Assert.assertEquals(signedInfo, assinatura.getSignedInfo());
    }
}