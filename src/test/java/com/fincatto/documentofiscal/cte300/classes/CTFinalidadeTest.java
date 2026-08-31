package com.fincatto.documentofiscal.cte300.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTFinalidadeTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assertions.assertNull(CTFinalidade.valueOfCodigo(null));
    	Assertions.assertEquals("0", CTFinalidade.NORMAL.getCodigo());
    	Assertions.assertEquals("1", CTFinalidade.COMPLEMENTAR_VALORES.getCodigo());
    	Assertions.assertEquals("2", CTFinalidade.ANULACAO.getCodigo());
    	Assertions.assertEquals("3", CTFinalidade.DEVOLUCAO_OU_RETORNO.getCodigo());
    }

}
