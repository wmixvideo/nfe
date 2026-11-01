package com.fincatto.documentofiscal.nfe310.classes.nota.assinatura;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class NFReferenceTest {

    @Test
    public void deveObterDigestValueComoFoiSetado() {
        final NFReference reference = new NFReference();
        final String digestValue = "digest value";
        reference.setDigestValue(digestValue);
        Assertions.assertEquals(digestValue, reference.getDigestValue());
    }

    @Test
    public void deveObterTransformComoFoiSetado() {
        final NFReference reference = new NFReference();
        final List<NFTransform> transform = new ArrayList<>();
        reference.setTransform(transform);
        Assertions.assertEquals(transform, reference.getTransform());
    }

    @Test
    public void deveObterUriComoFoiSetado() {
        final NFReference reference = new NFReference();
        final String uri = "uri";
        reference.setUri(uri);
        Assertions.assertEquals(uri, reference.getUri());
    }

    @Test
    public void deveObterDigestMethodComoFoiSetado() {
        final NFReference reference = new NFReference();
        final NFDigestMethod digestMethod = new NFDigestMethod();
        digestMethod.setAlgorithm("digest method");
        reference.setDigestMethod(digestMethod);
        Assertions.assertEquals(digestMethod, reference.getDigestMethod());
    }
}