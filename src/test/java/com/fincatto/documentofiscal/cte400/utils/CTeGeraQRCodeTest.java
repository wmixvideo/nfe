package com.fincatto.documentofiscal.cte400.utils;

import com.fincatto.documentofiscal.cte400.CTeConfigFake;
import com.fincatto.documentofiscal.cte400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.cte400.classes.nota.CTeNota;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTeGeraQRCodeTest {

    @Test
    public void naoDeveAssinarEmEmissaoNormal() throws Exception {
        final CTeConfigFake config = new CTeConfigFake();
        final CTeNota nota = new CTeNota();
        nota.setCteNotaInfo(FabricaDeObjetosFake.getCTeNotaInfo());
        final String qrCode = new CTeGeraQRCode(config).getQRCode(nota);
        Assertions.assertTrue(qrCode.endsWith("?chCTe=" + nota.getCteNotaInfo().getChaveAcesso() + "&tpAmb=" + config.getAmbiente().getCodigo()));
        Assertions.assertFalse(qrCode.contains("&sign="));
    }
}
