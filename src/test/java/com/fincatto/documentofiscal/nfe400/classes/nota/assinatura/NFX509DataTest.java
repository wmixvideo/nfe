package com.fincatto.documentofiscal.nfe400.classes.nota.assinatura;

import com.fincatto.documentofiscal.nfe310.classes.nota.assinatura.NFX509Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFX509DataTest {

    @Test
    public void deveObterx509certificateComoFoiSetado() {
        final NFX509Data data = new NFX509Data();
        final String x509certificate = "x509Certificate";
        data.setX509certificate(x509certificate);
        Assertions.assertEquals(x509certificate, data.getX509certificate());
    }
}