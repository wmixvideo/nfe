package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.Assert;
import org.junit.Test;

public class NFTipoImpressaoTest {

    @Test
    public void deveObterImpressaoApartirDoSeuCodigo() {
    	Assert.assertEquals(NFTipoImpressao.SEM_GERACAO_DANFE, NFTipoImpressao.valueOfCodigo("0"));
        Assert.assertEquals(NFTipoImpressao.DANFE_NORMAL_RETRATO, NFTipoImpressao.valueOfCodigo("1"));
        Assert.assertEquals(NFTipoImpressao.DANFE_NORMAL_PAISAGEM, NFTipoImpressao.valueOfCodigo("2"));
        Assert.assertEquals(NFTipoImpressao.DANFE_SIMPLIFICADO, NFTipoImpressao.valueOfCodigo("3"));
        Assert.assertEquals(NFTipoImpressao.DANFE_NFCE, NFTipoImpressao.valueOfCodigo("4"));
        Assert.assertEquals(NFTipoImpressao.DANFE_NFCE_MENSAGEM_ELETRONICA, NFTipoImpressao.valueOfCodigo("5"));
        Assert.assertNull(NFTipoImpressao.valueOfCodigo("6"));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assert.assertEquals("0", NFTipoImpressao.SEM_GERACAO_DANFE.getCodigo());
        Assert.assertEquals("1", NFTipoImpressao.DANFE_NORMAL_RETRATO.getCodigo());
        Assert.assertEquals("2", NFTipoImpressao.DANFE_NORMAL_PAISAGEM.getCodigo());
        Assert.assertEquals("3", NFTipoImpressao.DANFE_SIMPLIFICADO.getCodigo());
        Assert.assertEquals("4", NFTipoImpressao.DANFE_NFCE.getCodigo());
        Assert.assertEquals("5", NFTipoImpressao.DANFE_NFCE_MENSAGEM_ELETRONICA.getCodigo());
    }

    @Test
    public void deveRepresentarToStringCorretamente() {
        Assert.assertEquals("0 - Sem geração de DANFe", NFTipoImpressao.SEM_GERACAO_DANFE.toString());
        Assert.assertEquals("1 - DANFe normal retrato", NFTipoImpressao.DANFE_NORMAL_RETRATO.toString());
        Assert.assertEquals("2 - DANFe normal paisagem", NFTipoImpressao.DANFE_NORMAL_PAISAGEM.toString());
        Assert.assertEquals("3 - DANFe simplificado", NFTipoImpressao.DANFE_SIMPLIFICADO.toString());
        Assert.assertEquals("4 - DANFe NFCe", NFTipoImpressao.DANFE_NFCE.toString());
        Assert.assertEquals("5 - DANFe NFCe mensagem eletrônica", NFTipoImpressao.DANFE_NFCE_MENSAGEM_ELETRONICA.toString());
    }
}