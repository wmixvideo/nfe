package com.fincatto.nfe310.classes.nota.assinatura;

import org.junit.Assert;
import org.junit.Test;

public class NFReferenceTest {

    @Test
    public void deveObterDigestMethodComoFoiSetado() {
        final NFReference reference = new NFReference();
        final String digestMethod = "digest method";
        reference.setDigestMethod(digestMethod);
        Assert.assertEquals(digestMethod, reference.getDigestMethod());
    }
}