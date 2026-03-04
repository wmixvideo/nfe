package com.fincatto.documentofiscal.mdfe3.classes.def;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MDFTipoCategoriaCombinacaoVeicularTest {

    @Test
    public void deveRetornarCategoriaCorretaParaCodigoValido() {
        assertEquals(MDFTipoCategoriaCombinacaoVeicular.VEICULO_COMERCIAL_2_EIXOS, MDFTipoCategoriaCombinacaoVeicular.valueOfCodigo("02"));
        assertEquals(MDFTipoCategoriaCombinacaoVeicular.VEICULO_COMERCIAL_3_EIXOS, MDFTipoCategoriaCombinacaoVeicular.valueOfCodigo("04"));
        assertEquals(MDFTipoCategoriaCombinacaoVeicular.VEICULO_COMERCIAL_4_EIXOS, MDFTipoCategoriaCombinacaoVeicular.valueOfCodigo("06"));
        assertEquals(MDFTipoCategoriaCombinacaoVeicular.VEICULO_COMERCIAL_5_EIXOS, MDFTipoCategoriaCombinacaoVeicular.valueOfCodigo("07"));
        assertEquals(MDFTipoCategoriaCombinacaoVeicular.VEICULO_COMERCIAL_6_EIXOS, MDFTipoCategoriaCombinacaoVeicular.valueOfCodigo("08"));
        assertEquals(MDFTipoCategoriaCombinacaoVeicular.VEICULO_COMERCIAL_7_EIXOS, MDFTipoCategoriaCombinacaoVeicular.valueOfCodigo("10"));
        assertEquals(MDFTipoCategoriaCombinacaoVeicular.VEICULO_COMERCIAL_8_EIXOS, MDFTipoCategoriaCombinacaoVeicular.valueOfCodigo("11"));
        assertEquals(MDFTipoCategoriaCombinacaoVeicular.VEICULO_COMERCIAL_9_EIXOS, MDFTipoCategoriaCombinacaoVeicular.valueOfCodigo("12"));
        assertEquals(MDFTipoCategoriaCombinacaoVeicular.VEICULO_COMERCIAL_10_EIXOS, MDFTipoCategoriaCombinacaoVeicular.valueOfCodigo("13"));
        assertEquals(MDFTipoCategoriaCombinacaoVeicular.VEICULO_COMERCIAL_ACIMA_10_EIXOS, MDFTipoCategoriaCombinacaoVeicular.valueOfCodigo("14"));
    }

    @Test
    public void deveRetornarNullParaCodigoInvalido() {
        assertNull(MDFTipoCategoriaCombinacaoVeicular.valueOfCodigo("99"));
        assertNull(MDFTipoCategoriaCombinacaoVeicular.valueOfCodigo("INVALIDO"));
        assertNull(MDFTipoCategoriaCombinacaoVeicular.valueOfCodigo(null));
    }

    @Test
    public void deveRetornarCodigoCorreto() {
        assertEquals("02", MDFTipoCategoriaCombinacaoVeicular.VEICULO_COMERCIAL_2_EIXOS.getCodigo());
        assertEquals("13", MDFTipoCategoriaCombinacaoVeicular.VEICULO_COMERCIAL_10_EIXOS.getCodigo());
        assertEquals("14", MDFTipoCategoriaCombinacaoVeicular.VEICULO_COMERCIAL_ACIMA_10_EIXOS.getCodigo());
    }

    @Test
    public void deveRetornarDescricaoCorretaNoToString() {
        assertEquals("02 - Veículo Comercial 2 eixos", MDFTipoCategoriaCombinacaoVeicular.VEICULO_COMERCIAL_2_EIXOS.toString());
        assertEquals("13 - Veículo Comercial 10 eixos", MDFTipoCategoriaCombinacaoVeicular.VEICULO_COMERCIAL_10_EIXOS.toString());
        assertEquals("14 - Veículo Comercial Acima de 10 eixos", MDFTipoCategoriaCombinacaoVeicular.VEICULO_COMERCIAL_ACIMA_10_EIXOS.toString());
    }


}