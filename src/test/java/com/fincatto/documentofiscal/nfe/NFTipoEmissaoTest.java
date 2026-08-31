package com.fincatto.documentofiscal.nfe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFTipoEmissaoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("1", NFTipoEmissao.EMISSAO_NORMAL.getCodigo());
        Assertions.assertEquals("2", NFTipoEmissao.CONTINGENCIA_FS_IA.getCodigo());
        Assertions.assertEquals("3", NFTipoEmissao.REGIME_ESPECIAL_NFF.getCodigo());
        Assertions.assertEquals("4", NFTipoEmissao.CONTINGENCIA_EPEC.getCodigo());
        Assertions.assertEquals("5", NFTipoEmissao.CONTINGENCIA_FSDA.getCodigo());
        Assertions.assertEquals("6", NFTipoEmissao.CONTINGENCIA_SVCAN.getCodigo());
        Assertions.assertEquals("7", NFTipoEmissao.CONTINGENCIA_SVCRS.getCodigo());
        Assertions.assertEquals("9", NFTipoEmissao.CONTIGENCIA_OFFLINE.getCodigo());
    }

    @Test
    public void deveObterPeloCodigoCorretamente() {
        Assertions.assertEquals(NFTipoEmissao.EMISSAO_NORMAL, NFTipoEmissao.valueOfCodigo("1"));
        Assertions.assertEquals(NFTipoEmissao.CONTINGENCIA_FS_IA, NFTipoEmissao.valueOfCodigo("2"));
        Assertions.assertEquals(NFTipoEmissao.REGIME_ESPECIAL_NFF, NFTipoEmissao.valueOfCodigo("3"));
        Assertions.assertEquals(NFTipoEmissao.CONTINGENCIA_EPEC, NFTipoEmissao.valueOfCodigo("4"));
        Assertions.assertEquals(NFTipoEmissao.CONTINGENCIA_FSDA, NFTipoEmissao.valueOfCodigo("5"));
        Assertions.assertEquals(NFTipoEmissao.CONTINGENCIA_SVCAN, NFTipoEmissao.valueOfCodigo("6"));
        Assertions.assertEquals(NFTipoEmissao.CONTINGENCIA_SVCRS, NFTipoEmissao.valueOfCodigo("7"));
        Assertions.assertEquals(NFTipoEmissao.CONTIGENCIA_OFFLINE, NFTipoEmissao.valueOfCodigo("9"));
    }

    @Test
    public void deveRetornarNuloCasoNaoExistaCodigo() {
        Assertions.assertNull(NFTipoEmissao.valueOfCodigo("8"));
    }

    @Test
    public void deveRetornarStringficadoCorretamente() {
        Assertions.assertEquals("1 - Normal", NFTipoEmissao.EMISSAO_NORMAL.toString());
    }
}