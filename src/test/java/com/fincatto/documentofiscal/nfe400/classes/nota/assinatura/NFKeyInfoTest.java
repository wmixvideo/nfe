package com.fincatto.documentofiscal.nfe400.classes.nota.assinatura;

import com.fincatto.documentofiscal.nfe310.classes.nota.assinatura.NFKeyInfo;
import com.fincatto.documentofiscal.nfe310.classes.nota.assinatura.NFX509Data;
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