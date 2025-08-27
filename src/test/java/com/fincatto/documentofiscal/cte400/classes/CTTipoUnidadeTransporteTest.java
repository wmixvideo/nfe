package com.fincatto.documentofiscal.cte400.classes;

import com.fincatto.documentofiscal.cte200.classes.CTTipoUnidadeTransporte;
import org.junit.Assert;
import org.junit.Test;

public class CTTipoUnidadeTransporteTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assert.assertNull(CTTipoUnidadeTransporte.valueOfCodigo(null));
    	Assert.assertEquals("1", CTTipoUnidadeTransporte.RODOVIARIO_TRACAO.getCodigo());
    	Assert.assertEquals("2", CTTipoUnidadeTransporte.RODOVIARIO_REBOQUE.getCodigo());
    	Assert.assertEquals("3", CTTipoUnidadeTransporte.NAVIO.getCodigo());
    	Assert.assertEquals("4", CTTipoUnidadeTransporte.BALSA.getCodigo());
    	Assert.assertEquals("5", CTTipoUnidadeTransporte.AERONAVE.getCodigo());
    	Assert.assertEquals("6", CTTipoUnidadeTransporte.VAGAO.getCodigo());
    	Assert.assertEquals("7", CTTipoUnidadeTransporte.OUTROS.getCodigo());
	}

}
