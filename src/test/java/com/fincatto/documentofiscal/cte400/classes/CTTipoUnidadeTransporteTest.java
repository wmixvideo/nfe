package com.fincatto.documentofiscal.cte400.classes;

import com.fincatto.documentofiscal.cte200.classes.CTTipoUnidadeTransporte;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTTipoUnidadeTransporteTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assertions.assertNull(CTTipoUnidadeTransporte.valueOfCodigo(null));
    	Assertions.assertEquals("1", CTTipoUnidadeTransporte.RODOVIARIO_TRACAO.getCodigo());
    	Assertions.assertEquals("2", CTTipoUnidadeTransporte.RODOVIARIO_REBOQUE.getCodigo());
    	Assertions.assertEquals("3", CTTipoUnidadeTransporte.NAVIO.getCodigo());
    	Assertions.assertEquals("4", CTTipoUnidadeTransporte.BALSA.getCodigo());
    	Assertions.assertEquals("5", CTTipoUnidadeTransporte.AERONAVE.getCodigo());
    	Assertions.assertEquals("6", CTTipoUnidadeTransporte.VAGAO.getCodigo());
    	Assertions.assertEquals("7", CTTipoUnidadeTransporte.OUTROS.getCodigo());
	}

}
