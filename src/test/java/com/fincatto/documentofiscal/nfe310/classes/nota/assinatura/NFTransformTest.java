package com.fincatto.documentofiscal.nfe310.classes.nota.assinatura;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFTransformTest {

    @Test
    public void deveObterAlgorithmComoFoiSetado() {
        final NFTransform transform = new NFTransform();
        final String algorithm = "Algorithm";
        transform.setAlgorithm(algorithm);
        Assertions.assertEquals(algorithm, transform.getAlgorithm());
    }
}