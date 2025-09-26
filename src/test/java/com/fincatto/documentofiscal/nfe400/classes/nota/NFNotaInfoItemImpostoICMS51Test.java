package com.fincatto.documentofiscal.nfe400.classes.nota;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoItemModalidadeBCICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;

public class NFNotaInfoItemImpostoICMS51Test {

	@Test(expected = NumberFormatException.class)
	public void naoDevePermitirPercentualICMSComTamanhoDiferente() {
		new NFNotaInfoItemImpostoICMS51().setPercentualICMS(new BigDecimal("10000"));
	}

	@Test(expected = NumberFormatException.class)
	public void naoDevePermitirPercentualReducaoBCComTamanhoDiferente() {
		new NFNotaInfoItemImpostoICMS51().setPercentualReducaoBC(new BigDecimal("1000"));
	}

	@Test(expected = NumberFormatException.class)
	public void naoDevePermitirValorBCICMSComTamanhoDiferente() {
		new NFNotaInfoItemImpostoICMS51().setValorBCICMS(new BigDecimal("10000000000000"));
	}

	@Test(expected = NumberFormatException.class)
	public void naoDevePermitirValorICMSComTamanhoDiferente() {
		new NFNotaInfoItemImpostoICMS51().setValorICMS(new BigDecimal("10000000000000"));
	}

	@Test
	public void naoDevePermitirValorICMSDiferimentoNulo() {
		final NFNotaInfoItemImpostoICMS51 icms51 = new NFNotaInfoItemImpostoICMS51();
		icms51.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO);
		icms51.setOrigem(NFOrigem.NACIONAL);
		icms51.setPercentualICMS(new BigDecimal("99.99"));
		icms51.setPercentualReducaoBC(new BigDecimal("99.99"));
		icms51.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_51);
		icms51.setValorBCICMS(new BigDecimal("999999999999.99"));
		icms51.setValorICMS(new BigDecimal("999999999999.99"));
		icms51.setPercentualDiferimento(new BigDecimal("99.9999"));
		icms51.setValorICMSOperacao(new BigDecimal("999999999999.99"));
		icms51.setValorBCFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.setPercentualFundoCombatePobreza(new BigDecimal("99.99"));
		icms51.setValorFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.setPercentualDiferimentoFundoCombatePobreza(new BigDecimal("99.99"));
		icms51.setValorDiferimentoFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.setValorEfetivoFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.toString();
	}

	@Test
	public void naoDevePermitirPercentualDiferimentoNulo() {
		final NFNotaInfoItemImpostoICMS51 icms51 = new NFNotaInfoItemImpostoICMS51();
		icms51.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO);
		icms51.setOrigem(NFOrigem.NACIONAL);
		icms51.setPercentualICMS(new BigDecimal("99.99"));
		icms51.setPercentualReducaoBC(new BigDecimal("99.99"));
		icms51.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_51);
		icms51.setValorBCICMS(new BigDecimal("999999999999.99"));
		icms51.setValorICMS(new BigDecimal("999999999999.99"));
		icms51.setValorICMSDiferimento(new BigDecimal("999999999999.99"));
		icms51.setValorICMSOperacao(new BigDecimal("999999999999.99"));
		icms51.setValorBCFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.setPercentualFundoCombatePobreza(new BigDecimal("99.99"));
		icms51.setValorFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.setPercentualDiferimentoFundoCombatePobreza(new BigDecimal("99.99"));
		icms51.setValorDiferimentoFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.setValorEfetivoFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.toString();
	}

	@Test
	public void naoDevePermitirValorICMSOperacaoNulo() {
		final NFNotaInfoItemImpostoICMS51 icms51 = new NFNotaInfoItemImpostoICMS51();
		icms51.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO);
		icms51.setOrigem(NFOrigem.NACIONAL);
		icms51.setPercentualICMS(new BigDecimal("99.99"));
		icms51.setPercentualReducaoBC(new BigDecimal("99.99"));
		icms51.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_51);
		icms51.setValorBCICMS(new BigDecimal("999999999999.99"));
		icms51.setValorICMS(new BigDecimal("999999999999.99"));
		icms51.setPercentualDiferimento(new BigDecimal("99.9999"));
		icms51.setValorICMSDiferimento(new BigDecimal("999999999999.99"));
		icms51.setValorBCFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.setPercentualFundoCombatePobreza(new BigDecimal("99.99"));
		icms51.setValorFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.setPercentualDiferimentoFundoCombatePobreza(new BigDecimal("99.99"));
		icms51.setValorDiferimentoFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.setValorEfetivoFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.toString();
	}

	@Test
	public void naoDevePermitirModalidadeBCNulo() {
		final NFNotaInfoItemImpostoICMS51 icms51 = new NFNotaInfoItemImpostoICMS51();
		icms51.setOrigem(NFOrigem.NACIONAL);
		icms51.setPercentualICMS(new BigDecimal("99.99"));
		icms51.setPercentualReducaoBC(new BigDecimal("99.99"));
		icms51.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_51);
		icms51.setValorBCICMS(new BigDecimal("999999999999.99"));
		icms51.setValorICMS(new BigDecimal("999999999999.99"));
		icms51.setPercentualDiferimento(new BigDecimal("99.9999"));
		icms51.setValorICMSDiferimento(new BigDecimal("999999999999.99"));
		icms51.setValorICMSOperacao(new BigDecimal("999999999999.99"));
		icms51.setValorBCFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.setPercentualFundoCombatePobreza(new BigDecimal("99.99"));
		icms51.setValorFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.setPercentualDiferimentoFundoCombatePobreza(new BigDecimal("99.99"));
		icms51.setValorDiferimentoFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.setValorEfetivoFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.toString();
	}

	@Test(expected = IllegalStateException.class)
	public void naoDevePermitirOrigemNulo() {
		final NFNotaInfoItemImpostoICMS51 icms51 = new NFNotaInfoItemImpostoICMS51();
		icms51.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO);
		icms51.setPercentualICMS(new BigDecimal("99.99"));
		icms51.setPercentualReducaoBC(new BigDecimal("99.99"));
		icms51.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_51);
		icms51.setValorBCICMS(new BigDecimal("999999999999.99"));
		icms51.setValorICMS(new BigDecimal("999999999999.99"));
		icms51.setPercentualDiferimento(new BigDecimal("99.9999"));
		icms51.setValorICMSDiferimento(new BigDecimal("999999999999.99"));
		icms51.setValorICMSOperacao(new BigDecimal("999999999999.99"));
		icms51.setValorBCFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.setPercentualFundoCombatePobreza(new BigDecimal("99.99"));
		icms51.setValorFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.setPercentualDiferimentoFundoCombatePobreza(new BigDecimal("99.99"));
		icms51.setValorDiferimentoFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.setValorEfetivoFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.toString();
	}

	@Test
	public void devePermitirPercentualICMSBCNulo() {
		final NFNotaInfoItemImpostoICMS51 icms51 = new NFNotaInfoItemImpostoICMS51();
		icms51.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO);
		icms51.setOrigem(NFOrigem.NACIONAL);
		icms51.setPercentualReducaoBC(new BigDecimal("99.99"));
		icms51.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_51);
		icms51.setValorBCICMS(new BigDecimal("999999999999.99"));
		icms51.setValorICMS(new BigDecimal("999999999999.99"));
		icms51.setPercentualDiferimento(new BigDecimal("99.9999"));
		icms51.setValorICMSDiferimento(new BigDecimal("999999999999.99"));
		icms51.setValorICMSOperacao(new BigDecimal("999999999999.99"));
		icms51.setValorBCFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.setPercentualFundoCombatePobreza(new BigDecimal("99.99"));
		icms51.setValorFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.setPercentualDiferimentoFundoCombatePobreza(new BigDecimal("99.99"));
		icms51.setValorDiferimentoFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.setValorEfetivoFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.toString();
	}

	@Test
	public void devePermitirPercentualReducaoBCNulo() {
		final NFNotaInfoItemImpostoICMS51 icms51 = new NFNotaInfoItemImpostoICMS51();
		icms51.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO);
		icms51.setOrigem(NFOrigem.NACIONAL);
		icms51.setPercentualICMS(new BigDecimal("99.99"));
		icms51.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_51);
		icms51.setValorBCICMS(new BigDecimal("999999999999.99"));
		icms51.setValorICMS(new BigDecimal("999999999999.99"));
		icms51.setPercentualDiferimento(new BigDecimal("99.9999"));
		icms51.setValorICMSDiferimento(new BigDecimal("999999999999.99"));
		icms51.setValorICMSOperacao(new BigDecimal("999999999999.99"));
		icms51.setValorBCFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.setPercentualFundoCombatePobreza(new BigDecimal("99.99"));
		icms51.setValorFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.setPercentualDiferimentoFundoCombatePobreza(new BigDecimal("99.99"));
		icms51.setValorDiferimentoFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.setValorEfetivoFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.toString();
	}

	@Test(expected = IllegalStateException.class)
	public void naoDevePermitirSituacaoTributariaNulo() {
		final NFNotaInfoItemImpostoICMS51 icms51 = new NFNotaInfoItemImpostoICMS51();
		icms51.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO);
		icms51.setOrigem(NFOrigem.NACIONAL);
		icms51.setPercentualICMS(new BigDecimal("99.99"));
		icms51.setPercentualReducaoBC(new BigDecimal("99.99"));
		icms51.setValorBCICMS(new BigDecimal("999999999999.99"));
		icms51.setValorICMS(new BigDecimal("999999999999.99"));
		icms51.setPercentualDiferimento(new BigDecimal("99.9999"));
		icms51.setValorICMSDiferimento(new BigDecimal("999999999999.99"));
		icms51.setValorICMSOperacao(new BigDecimal("999999999999.99"));
		icms51.setValorBCFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.setPercentualFundoCombatePobreza(new BigDecimal("99.99"));
		icms51.setValorFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.setPercentualDiferimentoFundoCombatePobreza(new BigDecimal("99.99"));
		icms51.setValorDiferimentoFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.setValorEfetivoFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.toString();
	}

	@Test
	public void devePermitirValorBCICMSNulo() {
		final NFNotaInfoItemImpostoICMS51 icms51 = new NFNotaInfoItemImpostoICMS51();
		icms51.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO);
		icms51.setOrigem(NFOrigem.NACIONAL);
		icms51.setPercentualICMS(new BigDecimal("99.99"));
		icms51.setPercentualReducaoBC(new BigDecimal("99.99"));
		icms51.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_51);
		icms51.setValorICMS(new BigDecimal("999999999999.99"));
		icms51.setPercentualDiferimento(new BigDecimal("99.9999"));
		icms51.setValorICMSDiferimento(new BigDecimal("999999999999.99"));
		icms51.setValorICMSOperacao(new BigDecimal("999999999999.99"));
		icms51.setValorBCFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.setPercentualFundoCombatePobreza(new BigDecimal("99.99"));
		icms51.setValorFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.setPercentualDiferimentoFundoCombatePobreza(new BigDecimal("99.99"));
		icms51.setValorDiferimentoFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.setValorEfetivoFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.toString();
	}

	@Test
	public void devePermitirValorICMSNulo() {
		final NFNotaInfoItemImpostoICMS51 icms51 = new NFNotaInfoItemImpostoICMS51();
		icms51.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO);
		icms51.setOrigem(NFOrigem.NACIONAL);
		icms51.setPercentualICMS(new BigDecimal("99.99"));
		icms51.setPercentualReducaoBC(new BigDecimal("99.99"));
		icms51.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_51);
		icms51.setValorBCICMS(new BigDecimal("999999999999.99"));
		icms51.setPercentualDiferimento(new BigDecimal("99.9999"));
		icms51.setValorICMSDiferimento(new BigDecimal("999999999999.99"));
		icms51.setValorICMSOperacao(new BigDecimal("999999999999.99"));
		icms51.setValorBCFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.setPercentualFundoCombatePobreza(new BigDecimal("99.99"));
		icms51.setValorFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.setPercentualDiferimentoFundoCombatePobreza(new BigDecimal("99.99"));
		icms51.setValorDiferimentoFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.setValorEfetivoFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.toString();
	}

	@Test
	public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
		final NFNotaInfoItemImpostoICMS51 icms51 = new NFNotaInfoItemImpostoICMS51();
		icms51.setModalidadeBCICMS(NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO);
		icms51.setOrigem(NFOrigem.NACIONAL);
		icms51.setPercentualICMS(new BigDecimal("99.99"));
		icms51.setPercentualReducaoBC(new BigDecimal("99.99"));
		icms51.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_51);
		icms51.setValorBCICMS(new BigDecimal("999999999999.99"));
		icms51.setValorICMS(new BigDecimal("999999999999.99"));
		icms51.setPercentualDiferimento(new BigDecimal("99.9999"));
		icms51.setValorICMSDiferimento(new BigDecimal("999999999999.99"));
		icms51.setValorICMSOperacao(new BigDecimal("999999999999.99"));
		icms51.setValorBCFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.setPercentualFundoCombatePobreza(new BigDecimal("99.99"));
		icms51.setValorFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.setPercentualDiferimentoFundoCombatePobreza(new BigDecimal("99.99"));
		icms51.setValorDiferimentoFundoCombatePobreza(new BigDecimal("999999999999.99"));
		icms51.setValorEfetivoFundoCombatePobreza(new BigDecimal("999999999999.99"));

		final String xmlEsperado = "<NFNotaInfoItemImpostoICMS51><orig>0</orig><CST>51</CST><modBC>3</modBC><pRedBC>99.99</pRedBC><vBC>999999999999.99</vBC><pICMS>99.99</pICMS><vICMSOp>999999999999.99</vICMSOp><pDif>99.9999</pDif><vICMSDif>999999999999.99</vICMSDif><vICMS>999999999999.99</vICMS><vBCFCP>999999999999.99</vBCFCP><pFCP>99.99</pFCP><vFCP>999999999999.99</vFCP><pFCPDif>99.99</pFCPDif><vFCPDif>999999999999.99</vFCPDif><vFCPEfet>999999999999.99</vFCPEfet></NFNotaInfoItemImpostoICMS51>";
		Assert.assertEquals(xmlEsperado, icms51.toString());
	}
}