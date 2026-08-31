package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFTipoImpressaoTest {

    @Test
    public void deveObterImpressaoApartirDoSeuCodigo() {
    	Assertions.assertEquals(NFTipoImpressao.SEM_GERACAO_DANFE, NFTipoImpressao.valueOfCodigo("0"));
        Assertions.assertEquals(NFTipoImpressao.DANFE_NORMAL_RETRATO, NFTipoImpressao.valueOfCodigo("1"));
        Assertions.assertEquals(NFTipoImpressao.DANFE_NORMAL_PAISAGEM, NFTipoImpressao.valueOfCodigo("2"));
        Assertions.assertEquals(NFTipoImpressao.DANFE_SIMPLIFICADO, NFTipoImpressao.valueOfCodigo("3"));
        Assertions.assertEquals(NFTipoImpressao.DANFE_NFCE, NFTipoImpressao.valueOfCodigo("4"));
        Assertions.assertEquals(NFTipoImpressao.DANFE_NFCE_MENSAGEM_ELETRONICA, NFTipoImpressao.valueOfCodigo("5"));
        Assertions.assertEquals(NFTipoImpressao.DANFE_SIMPLIFICADO_TIPO_2, NFTipoImpressao.valueOfCodigo("6"));
        Assertions.assertNull(NFTipoImpressao.valueOfCodigo("7"));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assertions.assertEquals("0", NFTipoImpressao.SEM_GERACAO_DANFE.getCodigo());
        Assertions.assertEquals("1", NFTipoImpressao.DANFE_NORMAL_RETRATO.getCodigo());
        Assertions.assertEquals("2", NFTipoImpressao.DANFE_NORMAL_PAISAGEM.getCodigo());
        Assertions.assertEquals("3", NFTipoImpressao.DANFE_SIMPLIFICADO.getCodigo());
        Assertions.assertEquals("4", NFTipoImpressao.DANFE_NFCE.getCodigo());
        Assertions.assertEquals("5", NFTipoImpressao.DANFE_NFCE_MENSAGEM_ELETRONICA.getCodigo());
    }

    @Test
    public void deveRepresentarToStringCorretamente() {
        Assertions.assertEquals("0 - Sem geração de DANFe", NFTipoImpressao.SEM_GERACAO_DANFE.toString());
        Assertions.assertEquals("1 - DANFe normal retrato", NFTipoImpressao.DANFE_NORMAL_RETRATO.toString());
        Assertions.assertEquals("2 - DANFe normal paisagem", NFTipoImpressao.DANFE_NORMAL_PAISAGEM.toString());
        Assertions.assertEquals("3 - DANFe simplificado", NFTipoImpressao.DANFE_SIMPLIFICADO.toString());
        Assertions.assertEquals("4 - DANFe NFCe", NFTipoImpressao.DANFE_NFCE.toString());
        Assertions.assertEquals("5 - DANFe NFCe mensagem eletrônica", NFTipoImpressao.DANFE_NFCE_MENSAGEM_ELETRONICA.toString());
    }
}