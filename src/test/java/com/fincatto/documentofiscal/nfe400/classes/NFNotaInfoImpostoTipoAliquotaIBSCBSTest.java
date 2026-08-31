package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Marcos Lombardi de Andrade
 */
public class NFNotaInfoImpostoTipoAliquotaIBSCBSTest {

    @Test
    public void deveRepresentarADescricaoCorretamente() {
    	Assertions.assertEquals("Padrão", NFNotaInfoImpostoTipoAliquotaIBSCBS.PADRAO.getTipoAliquota());
    	Assertions.assertEquals("Fixa", NFNotaInfoImpostoTipoAliquotaIBSCBS.FIXA.getTipoAliquota());
    	Assertions.assertEquals("Uniforme setorial", NFNotaInfoImpostoTipoAliquotaIBSCBS.UNIFORME_SETORIAL.getTipoAliquota());
    	Assertions.assertEquals("Uniforme nacional (referência)", NFNotaInfoImpostoTipoAliquotaIBSCBS.UNIFORME_NACIONAL.getTipoAliquota());
    	Assertions.assertEquals("Sem alíquota", NFNotaInfoImpostoTipoAliquotaIBSCBS.SEM_ALIQUOTA.getTipoAliquota());
    }
    
}
