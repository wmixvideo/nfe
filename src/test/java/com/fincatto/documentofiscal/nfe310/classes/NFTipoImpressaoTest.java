package com.fincatto.documentofiscal.nfe310.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFTipoImpressaoTest {

    @Test
    public void deveObterImpressaoApartirDoSeuCodigo() {
        Assertions.assertEquals(NFTipoImpressao.DANFE_NORMAL_RETRATO, NFTipoImpressao.valueOfCodigo("1"));
        Assertions.assertEquals(NFTipoImpressao.DANFE_NORMAL_PAISAGEM, NFTipoImpressao.valueOfCodigo("2"));
        Assertions.assertEquals(NFTipoImpressao.DANFE_SIMPLIFICADO, NFTipoImpressao.valueOfCodigo("3"));
        Assertions.assertEquals(NFTipoImpressao.DANFE_NFCE, NFTipoImpressao.valueOfCodigo("4"));
        Assertions.assertEquals(NFTipoImpressao.DANFE_NFCE_MENSAGEM_ELETRONICA, NFTipoImpressao.valueOfCodigo("5"));
        Assertions.assertNull(NFTipoImpressao.valueOfCodigo("6"));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("1", NFTipoImpressao.DANFE_NORMAL_RETRATO.getCodigo());
        Assertions.assertEquals("2", NFTipoImpressao.DANFE_NORMAL_PAISAGEM.getCodigo());
        Assertions.assertEquals("3", NFTipoImpressao.DANFE_SIMPLIFICADO.getCodigo());
        Assertions.assertEquals("4", NFTipoImpressao.DANFE_NFCE.getCodigo());
        Assertions.assertEquals("5", NFTipoImpressao.DANFE_NFCE_MENSAGEM_ELETRONICA.getCodigo());
    }

    @Test
    public void deveObterStringficadoCorretamente() {
        Assertions.assertEquals("4 - DANFe NFCe", NFTipoImpressao.DANFE_NFCE.toString());
    }
}