package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFNotaInfoImpostoTributacaoIBSCBSTest {

	@Test
	public void deveRepresentarOCodigoCorretamente() {
		Assertions.assertEquals("000", NFNotaInfoImpostoTributacaoIBSCBS.CST_000.getCodigo());
		Assertions.assertEquals("010", NFNotaInfoImpostoTributacaoIBSCBS.CST_010.getCodigo());
		Assertions.assertEquals("011", NFNotaInfoImpostoTributacaoIBSCBS.CST_011.getCodigo());
		Assertions.assertEquals("200", NFNotaInfoImpostoTributacaoIBSCBS.CST_200.getCodigo());
		Assertions.assertEquals("210", NFNotaInfoImpostoTributacaoIBSCBS.CST_210.getCodigo());
		Assertions.assertEquals("220", NFNotaInfoImpostoTributacaoIBSCBS.CST_220.getCodigo());
		Assertions.assertEquals("221", NFNotaInfoImpostoTributacaoIBSCBS.CST_221.getCodigo());
		Assertions.assertEquals("222", NFNotaInfoImpostoTributacaoIBSCBS.CST_222.getCodigo());
		Assertions.assertEquals("400", NFNotaInfoImpostoTributacaoIBSCBS.CST_400.getCodigo());
		Assertions.assertEquals("410", NFNotaInfoImpostoTributacaoIBSCBS.CST_410.getCodigo());
		Assertions.assertEquals("510", NFNotaInfoImpostoTributacaoIBSCBS.CST_510.getCodigo());
		Assertions.assertEquals("550", NFNotaInfoImpostoTributacaoIBSCBS.CST_550.getCodigo());
		Assertions.assertEquals("620", NFNotaInfoImpostoTributacaoIBSCBS.CST_620.getCodigo());
		Assertions.assertEquals("800", NFNotaInfoImpostoTributacaoIBSCBS.CST_800.getCodigo());
		Assertions.assertEquals("810", NFNotaInfoImpostoTributacaoIBSCBS.CST_810.getCodigo());
		Assertions.assertEquals("820", NFNotaInfoImpostoTributacaoIBSCBS.CST_820.getCodigo());
		Assertions.assertEquals("830", NFNotaInfoImpostoTributacaoIBSCBS.CST_830.getCodigo());
		Assertions.assertEquals("811", NFNotaInfoImpostoTributacaoIBSCBS.CST_811.getCodigo());
		Assertions.assertEquals("515", NFNotaInfoImpostoTributacaoIBSCBS.CST_515.getCodigo());
	}
	
    @Test
    public void deveRepresentarADescricaoCorretamente() {
    	Assertions.assertEquals("Tributação integral", NFNotaInfoImpostoTributacaoIBSCBS.CST_000.getDescricao());
    	Assertions.assertEquals("Tributação com alíquotas uniformes", NFNotaInfoImpostoTributacaoIBSCBS.CST_010.getDescricao());
    	Assertions.assertEquals("Tributação com alíquotas uniformes reduzidas", NFNotaInfoImpostoTributacaoIBSCBS.CST_011.getDescricao());
    	Assertions.assertEquals("Alíquota reduzida", NFNotaInfoImpostoTributacaoIBSCBS.CST_200.getDescricao());
    	Assertions.assertEquals("Redução de alíquota com redutor de base de cálculo", NFNotaInfoImpostoTributacaoIBSCBS.CST_210.getDescricao());
    	Assertions.assertEquals("Alíquota fixa", NFNotaInfoImpostoTributacaoIBSCBS.CST_220.getDescricao());
    	Assertions.assertEquals("Alíquota fixa proporcional", NFNotaInfoImpostoTributacaoIBSCBS.CST_221.getDescricao());
    	Assertions.assertEquals("Redução de base de cálculo", NFNotaInfoImpostoTributacaoIBSCBS.CST_222.getDescricao());
    	Assertions.assertEquals("Isenção", NFNotaInfoImpostoTributacaoIBSCBS.CST_400.getDescricao());
    	Assertions.assertEquals("Imunidade e não incidência", NFNotaInfoImpostoTributacaoIBSCBS.CST_410.getDescricao());
    	Assertions.assertEquals("Diferimento", NFNotaInfoImpostoTributacaoIBSCBS.CST_510.getDescricao());
    	Assertions.assertEquals("Suspensão", NFNotaInfoImpostoTributacaoIBSCBS.CST_550.getDescricao());
    	Assertions.assertEquals("Tributação monofásica", NFNotaInfoImpostoTributacaoIBSCBS.CST_620.getDescricao());
    	Assertions.assertEquals("Transferência de crédito", NFNotaInfoImpostoTributacaoIBSCBS.CST_800.getDescricao());
    	Assertions.assertEquals("Ajuste de IBS na ZFM", NFNotaInfoImpostoTributacaoIBSCBS.CST_810.getDescricao());
    	Assertions.assertEquals("Ajustes", NFNotaInfoImpostoTributacaoIBSCBS.CST_811.getDescricao());
    	Assertions.assertEquals("Tributação em declaração de regime específico", NFNotaInfoImpostoTributacaoIBSCBS.CST_820.getDescricao());
        Assertions.assertEquals("Exclusão de base de cálculo", NFNotaInfoImpostoTributacaoIBSCBS.CST_830.getDescricao());
    }
    
    @Test
    public void deveObterTipoApartirDoSeuCodigo() {
    	Assertions.assertEquals(NFNotaInfoImpostoTributacaoIBSCBS.CST_000, NFNotaInfoImpostoTributacaoIBSCBS.valueOfCodigo("000"));
    	Assertions.assertEquals(NFNotaInfoImpostoTributacaoIBSCBS.CST_010, NFNotaInfoImpostoTributacaoIBSCBS.valueOfCodigo("010"));
    	Assertions.assertEquals(NFNotaInfoImpostoTributacaoIBSCBS.CST_011, NFNotaInfoImpostoTributacaoIBSCBS.valueOfCodigo("011"));
    	Assertions.assertEquals(NFNotaInfoImpostoTributacaoIBSCBS.CST_200, NFNotaInfoImpostoTributacaoIBSCBS.valueOfCodigo("200"));
    	Assertions.assertEquals(NFNotaInfoImpostoTributacaoIBSCBS.CST_210, NFNotaInfoImpostoTributacaoIBSCBS.valueOfCodigo("210"));
    	Assertions.assertEquals(NFNotaInfoImpostoTributacaoIBSCBS.CST_220, NFNotaInfoImpostoTributacaoIBSCBS.valueOfCodigo("220"));
    	Assertions.assertEquals(NFNotaInfoImpostoTributacaoIBSCBS.CST_221, NFNotaInfoImpostoTributacaoIBSCBS.valueOfCodigo("221"));
    	Assertions.assertEquals(NFNotaInfoImpostoTributacaoIBSCBS.CST_222, NFNotaInfoImpostoTributacaoIBSCBS.valueOfCodigo("222"));
    	Assertions.assertEquals(NFNotaInfoImpostoTributacaoIBSCBS.CST_400, NFNotaInfoImpostoTributacaoIBSCBS.valueOfCodigo("400"));
    	Assertions.assertEquals(NFNotaInfoImpostoTributacaoIBSCBS.CST_410, NFNotaInfoImpostoTributacaoIBSCBS.valueOfCodigo("410"));
    	Assertions.assertEquals(NFNotaInfoImpostoTributacaoIBSCBS.CST_510, NFNotaInfoImpostoTributacaoIBSCBS.valueOfCodigo("510"));
    	Assertions.assertEquals(NFNotaInfoImpostoTributacaoIBSCBS.CST_620, NFNotaInfoImpostoTributacaoIBSCBS.valueOfCodigo("620"));
    	Assertions.assertEquals(NFNotaInfoImpostoTributacaoIBSCBS.CST_800, NFNotaInfoImpostoTributacaoIBSCBS.valueOfCodigo("800"));
    	Assertions.assertEquals(NFNotaInfoImpostoTributacaoIBSCBS.CST_810, NFNotaInfoImpostoTributacaoIBSCBS.valueOfCodigo("810"));
    	Assertions.assertEquals(NFNotaInfoImpostoTributacaoIBSCBS.CST_820, NFNotaInfoImpostoTributacaoIBSCBS.valueOfCodigo("820"));
        Assertions.assertEquals(NFNotaInfoImpostoTributacaoIBSCBS.CST_830, NFNotaInfoImpostoTributacaoIBSCBS.valueOfCodigo("830"));
        Assertions.assertEquals(NFNotaInfoImpostoTributacaoIBSCBS.CST_515, NFNotaInfoImpostoTributacaoIBSCBS.valueOfCodigo("515"));
        Assertions.assertEquals(NFNotaInfoImpostoTributacaoIBSCBS.CST_811, NFNotaInfoImpostoTributacaoIBSCBS.valueOfCodigo("811"));
    }
}
