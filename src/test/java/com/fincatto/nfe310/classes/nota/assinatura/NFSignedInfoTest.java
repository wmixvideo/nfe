package com.fincatto.nfe310.classes.nota.assinatura;

import org.junit.Assert;
import org.junit.Test;

public class NFSignedInfoTest {

    @Test
    public void deveObterCanonicalizationMethodComoFoiSetado() {
        final NFSignedInfo info = new NFSignedInfo();
        final String canonicalizationMethod = "canonicalization method";
        info.setCanonicalizationMethod(canonicalizationMethod);
        Assert.assertEquals(canonicalizationMethod, info.getCanonicalizationMethod());
    }

    @Test
    public void deveObterReferenceComoFoiSetado() {
        final NFSignedInfo info = new NFSignedInfo();
        final NFReference reference = new NFReference();
        info.setReference(reference);
        Assert.assertEquals(reference, info.getReference());
    }

    @Test
    public void deveObterSignatureMethodComoFoiSetado() {
        final NFSignedInfo info = new NFSignedInfo();
        final String signatureMethod = "signature method";
        info.setSignatureMethod(signatureMethod);
        Assert.assertEquals(signatureMethod, info.getSignatureMethod());
    }
}