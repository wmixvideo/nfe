package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.Assert;
import org.junit.Test;

public class NFTipoDeducaoIcmsTest {
    
    @Test
    public void deveObterTipoApartirDoSeuCodigo() {
        Assert.assertEquals(NFTipoDeducaoIcms.NAO_DEDUZ_VALOR_ITEM, NFTipoDeducaoIcms.valueOfCodigo("0"));
        Assert.assertEquals(NFTipoDeducaoIcms.DEDUZ_VALOR_ITEM, NFTipoDeducaoIcms.valueOfCodigo("1"));
        Assert.assertNull(NFTipo.valueOfCodigo("2"));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("0", NFTipoDeducaoIcms.NAO_DEDUZ_VALOR_ITEM.getCodigo());
        Assert.assertEquals("1", NFTipoDeducaoIcms.DEDUZ_VALOR_ITEM.getCodigo());
    }

    @Test
    public void deveRepresentarToStringCorretamente() {
        Assert.assertEquals("0 - Sem Dedu\u00e7\u00e3o do Valor do Item", NFTipoDeducaoIcms.NAO_DEDUZ_VALOR_ITEM.toString());
        Assert.assertEquals("1 - Deduz do Valor do Item", NFTipoDeducaoIcms.DEDUZ_VALOR_ITEM.toString());
    }

}
