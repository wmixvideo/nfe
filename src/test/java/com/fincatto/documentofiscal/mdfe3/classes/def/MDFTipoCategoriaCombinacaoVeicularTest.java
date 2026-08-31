package com.fincatto.documentofiscal.mdfe3.classes.def;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MDFTipoCategoriaCombinacaoVeicularTest {

    @Test
    public void deveRetornarCategoriaCorretaParaCodigoValido() {
        Assertions.assertEquals(MDFTipoCategoriaCombinacaoVeicular.VEICULO_COMERCIAL_2_EIXOS, MDFTipoCategoriaCombinacaoVeicular.valueOfCodigo("02"));
        Assertions.assertEquals(MDFTipoCategoriaCombinacaoVeicular.VEICULO_COMERCIAL_3_EIXOS, MDFTipoCategoriaCombinacaoVeicular.valueOfCodigo("04"));
        Assertions.assertEquals(MDFTipoCategoriaCombinacaoVeicular.VEICULO_COMERCIAL_4_EIXOS, MDFTipoCategoriaCombinacaoVeicular.valueOfCodigo("06"));
        Assertions.assertEquals(MDFTipoCategoriaCombinacaoVeicular.VEICULO_COMERCIAL_5_EIXOS, MDFTipoCategoriaCombinacaoVeicular.valueOfCodigo("07"));
        Assertions.assertEquals(MDFTipoCategoriaCombinacaoVeicular.VEICULO_COMERCIAL_6_EIXOS, MDFTipoCategoriaCombinacaoVeicular.valueOfCodigo("08"));
        Assertions.assertEquals(MDFTipoCategoriaCombinacaoVeicular.VEICULO_COMERCIAL_7_EIXOS, MDFTipoCategoriaCombinacaoVeicular.valueOfCodigo("10"));
        Assertions.assertEquals(MDFTipoCategoriaCombinacaoVeicular.VEICULO_COMERCIAL_8_EIXOS, MDFTipoCategoriaCombinacaoVeicular.valueOfCodigo("11"));
        Assertions.assertEquals(MDFTipoCategoriaCombinacaoVeicular.VEICULO_COMERCIAL_9_EIXOS, MDFTipoCategoriaCombinacaoVeicular.valueOfCodigo("12"));
        Assertions.assertEquals(MDFTipoCategoriaCombinacaoVeicular.VEICULO_COMERCIAL_10_EIXOS, MDFTipoCategoriaCombinacaoVeicular.valueOfCodigo("13"));
        Assertions.assertEquals(MDFTipoCategoriaCombinacaoVeicular.VEICULO_COMERCIAL_ACIMA_10_EIXOS, MDFTipoCategoriaCombinacaoVeicular.valueOfCodigo("14"));
    }

    @Test
    public void deveRetornarNullParaCodigoInvalido() {
        Assertions.assertNull(MDFTipoCategoriaCombinacaoVeicular.valueOfCodigo("99"));
        Assertions.assertNull(MDFTipoCategoriaCombinacaoVeicular.valueOfCodigo("INVALIDO"));
        Assertions.assertNull(MDFTipoCategoriaCombinacaoVeicular.valueOfCodigo(null));
    }

    @Test
    public void deveRetornarCodigoCorreto() {
        Assertions.assertEquals("02", MDFTipoCategoriaCombinacaoVeicular.VEICULO_COMERCIAL_2_EIXOS.getCodigo());
        Assertions.assertEquals("13", MDFTipoCategoriaCombinacaoVeicular.VEICULO_COMERCIAL_10_EIXOS.getCodigo());
        Assertions.assertEquals("14", MDFTipoCategoriaCombinacaoVeicular.VEICULO_COMERCIAL_ACIMA_10_EIXOS.getCodigo());
    }

    @Test
    public void deveRetornarDescricaoCorretaNoToString() {
        Assertions.assertEquals("02 - Veículo Comercial 2 eixos", MDFTipoCategoriaCombinacaoVeicular.VEICULO_COMERCIAL_2_EIXOS.toString());
        Assertions.assertEquals("13 - Veículo Comercial 10 eixos", MDFTipoCategoriaCombinacaoVeicular.VEICULO_COMERCIAL_10_EIXOS.toString());
        Assertions.assertEquals("14 - Veículo Comercial Acima de 10 eixos", MDFTipoCategoriaCombinacaoVeicular.VEICULO_COMERCIAL_ACIMA_10_EIXOS.toString());
    }


}