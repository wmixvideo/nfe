package com.fincatto.documentofiscal.cte400.classes;

import com.fincatto.documentofiscal.cte.CTTipoEmissao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

public class CTTipoEmissaoTest {
	
    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assertions.assertNull(CTTipoEmissao.valueOfCodigo(null));
    	Assertions.assertEquals("1", CTTipoEmissao.EMISSAO_NORMAL.getCodigo());
    	Assertions.assertEquals("2", CTTipoEmissao.CONTINGENCIA_OFFLINE.getCodigo());
    	Assertions.assertEquals("3", CTTipoEmissao.REGIME_ESPECIAL_NFF.getCodigo());
    	Assertions.assertEquals("4", CTTipoEmissao.CONTINGENCIA_EPEC.getCodigo());
    	Assertions.assertEquals("5", CTTipoEmissao.CONTINGENCIA_FSDA.getCodigo());
    	Assertions.assertEquals("7", CTTipoEmissao.CONTINGENCIA_SVCRS.getCodigo());
    	Assertions.assertEquals("8", CTTipoEmissao.CONTINGENCIA_SVCSP.getCodigo());
	}

    @Test
    public void deveListarTiposQuePermitemAssinaturaNoQRCode() {
        Assertions.assertEquals(new HashSet<>(Arrays.asList(CTTipoEmissao.CONTINGENCIA_EPEC, CTTipoEmissao.CONTINGENCIA_OFFLINE)), new HashSet<>(CTTipoEmissao.tiposPermitemSign()));
        Assertions.assertFalse(CTTipoEmissao.tiposPermitemSign().contains(CTTipoEmissao.EMISSAO_NORMAL));
        Assertions.assertFalse(CTTipoEmissao.tiposPermitemSign().contains(CTTipoEmissao.CONTINGENCIA_SVCRS));
        Assertions.assertFalse(CTTipoEmissao.tiposPermitemSign().contains(CTTipoEmissao.CONTINGENCIA_SVCSP));
    }

}
