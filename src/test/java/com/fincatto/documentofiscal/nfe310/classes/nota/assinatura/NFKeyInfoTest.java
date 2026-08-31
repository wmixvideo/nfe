package com.fincatto.documentofiscal.nfe310.classes.nota.assinatura;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFKeyInfoTest {

    @Test
    public void deveObterComoFoiSetado() {
        final NFKeyInfo keyInfo = new NFKeyInfo();
        final NFX509Data data = new NFX509Data();
        keyInfo.setData(data);
        Assertions.assertEquals(data, keyInfo.getData());
    }
}