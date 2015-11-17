package com.fincatto.nfe310.classes.nota.assinatura;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class NFReferenceTest {

    @Test
    public void deveObterDigestValueComoFoiSetado() {
        final NFReference reference = new NFReference();
        final String digestValue = "digest value";
        reference.setDigestValue(digestValue);
        Assert.assertEquals(digestValue, reference.getDigestValue());
    }

    @Test
    public void deveObterTransformComoFoiSetado() {
        final NFReference reference = new NFReference();
        final List<NFTransform> transform = new ArrayList<NFTransform>();
        reference.setTransform(transform);
        Assert.assertEquals(transform, reference.getTransform());
    }

    @Test
    public void deveObterUriComoFoiSetado() {
        final NFReference reference = new NFReference();
        final String uri = "uri";
        reference.setUri(uri);
        Assert.assertEquals(uri, reference.getUri());
    }

    @Test
    public void deveObterDigestMethodComoFoiSetado() {
        final NFReference reference = new NFReference();
        final String digestMethod = "digest method";
        reference.setDigestMethod(digestMethod);
        Assert.assertEquals(digestMethod, reference.getDigestMethod());
    }
}