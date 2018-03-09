package com.fincatto.documentofiscal.nfe400.classes.nota.assinatura;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe310.classes.nota.assinatura.NFTransform;

public class NFTransformTest {

    @Test
    public void deveObterAlgorithmComoFoiSetado() {
        final NFTransform transform = new NFTransform();
        final String algorithm = "Algorithm";
        transform.setAlgorithm(algorithm);
        Assert.assertEquals(algorithm, transform.getAlgorithm());
    }
}