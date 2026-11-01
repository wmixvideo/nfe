package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFIndicadorIntermediadorTest {

    @Test
    public void deveObterTipoApartirDoSeuCodigo() {
        Assertions.assertEquals(NFIndicadorIntermediador.OPERACAO_SEM_INTERMEDIADOR, NFIndicadorIntermediador.valueOfCodigo("0"));
        Assertions.assertEquals(NFIndicadorIntermediador.OPERACAO_COM_INTERMEDIADOR, NFIndicadorIntermediador.valueOfCodigo("1"));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("0", NFIndicadorIntermediador.OPERACAO_SEM_INTERMEDIADOR.getCodigo());
        Assertions.assertEquals("1", NFIndicadorIntermediador.OPERACAO_COM_INTERMEDIADOR.getCodigo());
    }
    
}
