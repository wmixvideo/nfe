package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.junit.Assert;
import org.junit.Test;

public class NFIndicadorIntermediadorTest {

    @Test
    public void deveObterTipoApartirDoSeuCodigo() {
        Assert.assertEquals(NFIndicadorIntermediador.OPERACAO_SEM_INTERMEDIADOR, NFIndicadorIntermediador.valueOfCodigo("0"));
        Assert.assertEquals(NFIndicadorIntermediador.OPERACAO_COM_INTERMEDIADOR, NFIndicadorIntermediador.valueOfCodigo("1"));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("0", NFIndicadorIntermediador.OPERACAO_SEM_INTERMEDIADOR.getCodigo());
        Assert.assertEquals("1", NFIndicadorIntermediador.OPERACAO_COM_INTERMEDIADOR.getCodigo());
    }
    
}
