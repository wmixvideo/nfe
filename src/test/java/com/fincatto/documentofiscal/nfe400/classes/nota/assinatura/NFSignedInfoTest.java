package com.fincatto.documentofiscal.nfe400.classes.nota.assinatura;

import com.fincatto.documentofiscal.nfe310.classes.nota.assinatura.NFCanonicalizationMethod;
import com.fincatto.documentofiscal.nfe310.classes.nota.assinatura.NFReference;
import com.fincatto.documentofiscal.nfe310.classes.nota.assinatura.NFSignatureMethod;
import com.fincatto.documentofiscal.nfe310.classes.nota.assinatura.NFSignedInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFSignedInfoTest {

    @Test
    public void deveObterCanonicalizationMethodComoFoiSetado() {
        final NFSignedInfo info = new NFSignedInfo();
        final NFCanonicalizationMethod canonicalizationMethod = new NFCanonicalizationMethod();
        canonicalizationMethod.setAlgorithm("canonicalization method");
        info.setCanonicalizationMethod(canonicalizationMethod);
        Assertions.assertEquals(canonicalizationMethod, info.getCanonicalizationMethod());
    }

    @Test
    public void deveObterReferenceComoFoiSetado() {
        final NFSignedInfo info = new NFSignedInfo();
        final NFReference reference = new NFReference();
        info.setReference(reference);
        Assertions.assertEquals(reference, info.getReference());
    }

    @Test
    public void deveObterSignatureMethodComoFoiSetado() {
        final NFSignedInfo info = new NFSignedInfo();
        final NFSignatureMethod signatureMethod = new NFSignatureMethod();
        signatureMethod.setAlgorithm("signature method");
        info.setSignatureMethod(signatureMethod);
        Assertions.assertEquals(signatureMethod, info.getSignatureMethod());
    }
}