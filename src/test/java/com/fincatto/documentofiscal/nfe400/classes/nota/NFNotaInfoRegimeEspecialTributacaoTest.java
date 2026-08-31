package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFNotaInfoRegimeEspecialTributacaoTest {

    @Test
    public void deveObterTipoApartirDoSeuCodigo() {
        Assertions.assertEquals(NFNotaInfoRegimeEspecialTributacao.MICROEMPRESA_MUNICIPAL, NFNotaInfoRegimeEspecialTributacao.valueOfCodigo("1"));
        Assertions.assertEquals(NFNotaInfoRegimeEspecialTributacao.ESTIMATIVA, NFNotaInfoRegimeEspecialTributacao.valueOfCodigo("2"));
        Assertions.assertEquals(NFNotaInfoRegimeEspecialTributacao.SOCIEDADE_PROFISSIONAIS, NFNotaInfoRegimeEspecialTributacao.valueOfCodigo("3"));
        Assertions.assertEquals(NFNotaInfoRegimeEspecialTributacao.COOPERATIVA, NFNotaInfoRegimeEspecialTributacao.valueOfCodigo("4"));
        Assertions.assertEquals(NFNotaInfoRegimeEspecialTributacao.MICROEMPRESARIO_INDIVIDUAL_MEI, NFNotaInfoRegimeEspecialTributacao.valueOfCodigo("5"));
        Assertions.assertEquals(NFNotaInfoRegimeEspecialTributacao.MICROEMPRESARIO_E_EMPRESA_PEQUENOPORTE, NFNotaInfoRegimeEspecialTributacao.valueOfCodigo("6"));
        Assertions.assertNull(NFNotaInfoRegimeEspecialTributacao.valueOfCodigo("0"));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("1", NFNotaInfoRegimeEspecialTributacao.MICROEMPRESA_MUNICIPAL.getCodigo());
        Assertions.assertEquals("2", NFNotaInfoRegimeEspecialTributacao.ESTIMATIVA.getCodigo());
        Assertions.assertEquals("3", NFNotaInfoRegimeEspecialTributacao.SOCIEDADE_PROFISSIONAIS.getCodigo());
        Assertions.assertEquals("4", NFNotaInfoRegimeEspecialTributacao.COOPERATIVA.getCodigo());
        Assertions.assertEquals("5", NFNotaInfoRegimeEspecialTributacao.MICROEMPRESARIO_INDIVIDUAL_MEI.getCodigo());
        Assertions.assertEquals("6", NFNotaInfoRegimeEspecialTributacao.MICROEMPRESARIO_E_EMPRESA_PEQUENOPORTE.getCodigo());
    }

    @Test
    public void deveObterStringficadoCorretamente() {
        Assertions.assertEquals("1 - Microempresa municipal", NFNotaInfoRegimeEspecialTributacao.MICROEMPRESA_MUNICIPAL.toString());
    }
}