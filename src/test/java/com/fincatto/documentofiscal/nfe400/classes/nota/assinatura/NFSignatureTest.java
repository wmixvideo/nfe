package com.fincatto.documentofiscal.nfe400.classes.nota.assinatura;

import com.fincatto.documentofiscal.nfe310.classes.nota.assinatura.NFKeyInfo;
import com.fincatto.documentofiscal.nfe310.classes.nota.assinatura.NFSignature;
import com.fincatto.documentofiscal.nfe310.classes.nota.assinatura.NFSignedInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFSignatureTest {

    @Test
    public void deveObterKeyInfoComoFoiSetado() {
        final NFSignature assinatura = new NFSignature();
        final NFKeyInfo keyInfo = new NFKeyInfo();
        assinatura.setKeyInfo(keyInfo);
        Assertions.assertEquals(keyInfo, assinatura.getKeyInfo());
    }

    @Test
    public void deveObterSignatureValueComoFoiSetado() {
        final NFSignature assinatura = new NFSignature();
        final String signatureValue = "signature";
        assinatura.setSignatureValue(signatureValue);
        Assertions.assertEquals(signatureValue, assinatura.getSignatureValue());
    }

    @Test
    public void deveObterSignedInfoComoFoiSetado() {
        final NFSignature assinatura = new NFSignature();
        final NFSignedInfo signedInfo = new NFSignedInfo();
        assinatura.setSignedInfo(signedInfo);
        Assertions.assertEquals(signedInfo, assinatura.getSignedInfo());
    }
}