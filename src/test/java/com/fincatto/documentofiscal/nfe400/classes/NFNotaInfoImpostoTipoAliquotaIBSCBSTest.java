package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Marcos Lombardi de Andrade
 */
public class NFNotaInfoImpostoTipoAliquotaIBSCBSTest {

    @Test
    public void deveRepresentarADescricaoCorretamente() {
    	Assert.assertEquals("Padrão", NFNotaInfoImpostoTipoAliquotaIBSCBS.PADRAO.getTipoAliquota());
    	Assert.assertEquals("Fixa", NFNotaInfoImpostoTipoAliquotaIBSCBS.FIXA.getTipoAliquota());
    	Assert.assertEquals("Uniforme setorial", NFNotaInfoImpostoTipoAliquotaIBSCBS.UNIFORME_SETORIAL.getTipoAliquota());
    	Assert.assertEquals("Uniforme nacional (referência)", NFNotaInfoImpostoTipoAliquotaIBSCBS.UNIFORME_NACIONAL.getTipoAliquota());
    	Assert.assertEquals("Sem alíquota", NFNotaInfoImpostoTipoAliquotaIBSCBS.SEM_ALIQUOTA.getTipoAliquota());
    }
    
}
