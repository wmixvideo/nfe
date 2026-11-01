package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFTipoDeducaoIcmsTest {
    
    @Test
    public void deveObterTipoApartirDoSeuCodigo() {
        Assertions.assertEquals(NFTipoDeducaoIcms.NAO_DEDUZ_VALOR_ITEM, NFTipoDeducaoIcms.valueOfCodigo("0"));
        Assertions.assertEquals(NFTipoDeducaoIcms.DEDUZ_VALOR_ITEM, NFTipoDeducaoIcms.valueOfCodigo("1"));
        Assertions.assertNull(NFTipo.valueOfCodigo("2"));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("0", NFTipoDeducaoIcms.NAO_DEDUZ_VALOR_ITEM.getCodigo());
        Assertions.assertEquals("1", NFTipoDeducaoIcms.DEDUZ_VALOR_ITEM.getCodigo());
    }

    @Test
    public void deveRepresentarToStringCorretamente() {
        Assertions.assertEquals("0 - Sem Dedu\u00e7\u00e3o do Valor do Item", NFTipoDeducaoIcms.NAO_DEDUZ_VALOR_ITEM.toString());
        Assertions.assertEquals("1 - Deduz do Valor do Item", NFTipoDeducaoIcms.DEDUZ_VALOR_ITEM.toString());
    }

}
