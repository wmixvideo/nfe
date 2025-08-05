package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.Assert;
import org.junit.Test;

public class NFNotaInfoImpostoTributacaoIBSCBSTest {

	@Test
	public void deveRepresentarOCodigoCorretamente() {
		Assert.assertEquals("000", NFNotaInfoImpostoTributacaoIBSCBS.CST_000.getCodigo());
		Assert.assertEquals("010", NFNotaInfoImpostoTributacaoIBSCBS.CST_010.getCodigo());
		Assert.assertEquals("011", NFNotaInfoImpostoTributacaoIBSCBS.CST_011.getCodigo());
		Assert.assertEquals("200", NFNotaInfoImpostoTributacaoIBSCBS.CST_200.getCodigo());
		Assert.assertEquals("210", NFNotaInfoImpostoTributacaoIBSCBS.CST_210.getCodigo());
		Assert.assertEquals("220", NFNotaInfoImpostoTributacaoIBSCBS.CST_220.getCodigo());
		Assert.assertEquals("221", NFNotaInfoImpostoTributacaoIBSCBS.CST_221.getCodigo());
		Assert.assertEquals("222", NFNotaInfoImpostoTributacaoIBSCBS.CST_222.getCodigo());
		Assert.assertEquals("400", NFNotaInfoImpostoTributacaoIBSCBS.CST_400.getCodigo());
		Assert.assertEquals("410", NFNotaInfoImpostoTributacaoIBSCBS.CST_410.getCodigo());
		Assert.assertEquals("510", NFNotaInfoImpostoTributacaoIBSCBS.CST_510.getCodigo());
		Assert.assertEquals("550", NFNotaInfoImpostoTributacaoIBSCBS.CST_550.getCodigo());
		Assert.assertEquals("620", NFNotaInfoImpostoTributacaoIBSCBS.CST_620.getCodigo());
		Assert.assertEquals("800", NFNotaInfoImpostoTributacaoIBSCBS.CST_800.getCodigo());
		Assert.assertEquals("810", NFNotaInfoImpostoTributacaoIBSCBS.CST_810.getCodigo());
		Assert.assertEquals("820", NFNotaInfoImpostoTributacaoIBSCBS.CST_820.getCodigo());
		Assert.assertEquals("830", NFNotaInfoImpostoTributacaoIBSCBS.CST_830.getCodigo());
	}
	
    @Test
    public void deveRepresentarADescricaoCorretamente() {
    	Assert.assertEquals("Tributação integral", NFNotaInfoImpostoTributacaoIBSCBS.CST_000.getDescricao());
    	Assert.assertEquals("Tributação com alíquotas uniformes", NFNotaInfoImpostoTributacaoIBSCBS.CST_010.getDescricao());
    	Assert.assertEquals("Tributação com alíquotas uniformes reduzidas", NFNotaInfoImpostoTributacaoIBSCBS.CST_011.getDescricao());
    	Assert.assertEquals("Alíquota reduzida", NFNotaInfoImpostoTributacaoIBSCBS.CST_200.getDescricao());
    	Assert.assertEquals("Redução de alíquota com redutor de base de cálculo", NFNotaInfoImpostoTributacaoIBSCBS.CST_210.getDescricao());
    	Assert.assertEquals("Alíquota fixa", NFNotaInfoImpostoTributacaoIBSCBS.CST_220.getDescricao());
    	Assert.assertEquals("Alíquota fixa proporcional", NFNotaInfoImpostoTributacaoIBSCBS.CST_221.getDescricao());
    	Assert.assertEquals("Redução de base de cálculo", NFNotaInfoImpostoTributacaoIBSCBS.CST_222.getDescricao());
    	Assert.assertEquals("Isenção", NFNotaInfoImpostoTributacaoIBSCBS.CST_400.getDescricao());
    	Assert.assertEquals("Imunidade e não incidência", NFNotaInfoImpostoTributacaoIBSCBS.CST_410.getDescricao());
    	Assert.assertEquals("Diferimento", NFNotaInfoImpostoTributacaoIBSCBS.CST_510.getDescricao());
    	Assert.assertEquals("Suspensão", NFNotaInfoImpostoTributacaoIBSCBS.CST_550.getDescricao());
    	Assert.assertEquals("Tributação monofásica", NFNotaInfoImpostoTributacaoIBSCBS.CST_620.getDescricao());
    	Assert.assertEquals("Transferência de crédito", NFNotaInfoImpostoTributacaoIBSCBS.CST_800.getDescricao());
    	Assert.assertEquals("Ajustes", NFNotaInfoImpostoTributacaoIBSCBS.CST_810.getDescricao());
    	Assert.assertEquals("Tributação em declaração de regime específico", NFNotaInfoImpostoTributacaoIBSCBS.CST_820.getDescricao());
        Assert.assertEquals("Exclusão de base de cálculo", NFNotaInfoImpostoTributacaoIBSCBS.CST_830.getDescricao());
    }
    
    @Test
    public void deveObterTipoApartirDoSeuCodigo() {
    	Assert.assertEquals(NFNotaInfoImpostoTributacaoIBSCBS.CST_000, NFNotaInfoImpostoTributacaoIBSCBS.valueOfCodigo("000"));
    	Assert.assertEquals(NFNotaInfoImpostoTributacaoIBSCBS.CST_010, NFNotaInfoImpostoTributacaoIBSCBS.valueOfCodigo("010"));
    	Assert.assertEquals(NFNotaInfoImpostoTributacaoIBSCBS.CST_011, NFNotaInfoImpostoTributacaoIBSCBS.valueOfCodigo("011"));
    	Assert.assertEquals(NFNotaInfoImpostoTributacaoIBSCBS.CST_200, NFNotaInfoImpostoTributacaoIBSCBS.valueOfCodigo("200"));
    	Assert.assertEquals(NFNotaInfoImpostoTributacaoIBSCBS.CST_210, NFNotaInfoImpostoTributacaoIBSCBS.valueOfCodigo("210"));
    	Assert.assertEquals(NFNotaInfoImpostoTributacaoIBSCBS.CST_220, NFNotaInfoImpostoTributacaoIBSCBS.valueOfCodigo("220"));
    	Assert.assertEquals(NFNotaInfoImpostoTributacaoIBSCBS.CST_221, NFNotaInfoImpostoTributacaoIBSCBS.valueOfCodigo("221"));
    	Assert.assertEquals(NFNotaInfoImpostoTributacaoIBSCBS.CST_222, NFNotaInfoImpostoTributacaoIBSCBS.valueOfCodigo("222"));
    	Assert.assertEquals(NFNotaInfoImpostoTributacaoIBSCBS.CST_400, NFNotaInfoImpostoTributacaoIBSCBS.valueOfCodigo("400"));
    	Assert.assertEquals(NFNotaInfoImpostoTributacaoIBSCBS.CST_410, NFNotaInfoImpostoTributacaoIBSCBS.valueOfCodigo("410"));
    	Assert.assertEquals(NFNotaInfoImpostoTributacaoIBSCBS.CST_510, NFNotaInfoImpostoTributacaoIBSCBS.valueOfCodigo("510"));
    	Assert.assertEquals(NFNotaInfoImpostoTributacaoIBSCBS.CST_620, NFNotaInfoImpostoTributacaoIBSCBS.valueOfCodigo("620"));
    	Assert.assertEquals(NFNotaInfoImpostoTributacaoIBSCBS.CST_800, NFNotaInfoImpostoTributacaoIBSCBS.valueOfCodigo("800"));
    	Assert.assertEquals(NFNotaInfoImpostoTributacaoIBSCBS.CST_810, NFNotaInfoImpostoTributacaoIBSCBS.valueOfCodigo("810"));
    	Assert.assertEquals(NFNotaInfoImpostoTributacaoIBSCBS.CST_820, NFNotaInfoImpostoTributacaoIBSCBS.valueOfCodigo("820"));
        Assert.assertEquals(NFNotaInfoImpostoTributacaoIBSCBS.CST_830, NFNotaInfoImpostoTributacaoIBSCBS.valueOfCodigo("830"));
    }
}
