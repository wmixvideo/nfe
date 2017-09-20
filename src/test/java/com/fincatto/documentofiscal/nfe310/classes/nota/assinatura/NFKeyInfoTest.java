package com.fincatto.documentofiscal.nfe310.classes.nota.assinatura;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe310.classes.nota.assinatura.NFKeyInfo;
import com.fincatto.documentofiscal.nfe310.classes.nota.assinatura.NFX509Data;

public class NFKeyInfoTest {

    @Test
    public void deveObterComoFoiSetado() {
        final NFKeyInfo keyInfo = new NFKeyInfo();
        final NFX509Data data = new NFX509Data();
        keyInfo.setData(data);
        Assert.assertEquals(data, keyInfo.getData());
    }
}