package com.fincatto.documentofiscal.cte300.classes;

import org.junit.Assert;
import org.junit.Test;

public class CTFinalidadeTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assert.assertNull(CTFinalidade.valueOfCodigo(null));
    	Assert.assertEquals("0", CTFinalidade.NORMAL.getCodigo());
    	Assert.assertEquals("1", CTFinalidade.COMPLEMENTAR_VALORES.getCodigo());
    	Assert.assertEquals("2", CTFinalidade.ANULACAO.getCodigo());
    	Assert.assertEquals("3", CTFinalidade.DEVOLUCAO_OU_RETORNO.getCodigo());
    }

}
