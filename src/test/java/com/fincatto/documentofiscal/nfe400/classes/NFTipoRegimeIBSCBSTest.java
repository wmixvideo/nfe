package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFTipoRegimeIBSCBSTest {

    @Test
    public void deveObterPeloCodigoCorretamente() {
        Assertions.assertEquals(NFTipoRegimeIBSCBS.SIMPLES_NACIONAL_REGIME_REGULAR, NFTipoRegimeIBSCBS.valueOfCodigo("1"));
        Assertions.assertEquals(NFTipoRegimeIBSCBS.NORMAL_OPCAO_PENDENTE_SIMPLES_NACIONAL, NFTipoRegimeIBSCBS.valueOfCodigo("2"));
        Assertions.assertEquals(NFTipoRegimeIBSCBS.NORMAL_OPCAO_PENDENTE_SIMPLES_NACIONAL_EXCESSO_SUBLIMITE, NFTipoRegimeIBSCBS.valueOfCodigo("3"));
        Assertions.assertEquals(NFTipoRegimeIBSCBS.NORMAL_OPCAO_PENDENTE_SIMPLES_NACIONAL_REGIME_REGULAR, NFTipoRegimeIBSCBS.valueOfCodigo("4"));
    }

    @Test
    public void deveObterNuloCasoNaoExistaCodigo() {
        Assertions.assertNull(NFTipoRegimeIBSCBS.valueOfCodigo("5"));
    }

    @Test
    public void deveRetornarStringficadoCorretamente() {
        Assertions.assertEquals("1 - Contribuinte do Simples Nacional (CRT=1 ou 2) com opção pelo regime regular do IBS e da CBS", NFTipoRegimeIBSCBS.SIMPLES_NACIONAL_REGIME_REGULAR.toString());
    }
}
