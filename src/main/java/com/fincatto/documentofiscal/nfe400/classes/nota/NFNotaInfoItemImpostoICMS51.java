package com.fincatto.documentofiscal.nfe400.classes.nota;

import java.math.BigDecimal;

import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoItemModalidadeBCICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;

public class NFNotaInfoItemImpostoICMS51 extends DFBase {
	private static final long serialVersionUID = -5575047808092974601L;

	@Element(name = "orig")
	private NFOrigem origem;

	@Element(name = "CST")
	private NFNotaInfoImpostoTributacaoICMS situacaoTributaria;

	@Element(name = "modBC", required = false)
	private NFNotaInfoItemModalidadeBCICMS modalidadeBCICMS;

	@Element(name = "pRedBC", required = false)
	private String percentualReducaoBC;

	@Element(name = "cBenefRBC", required = false)
	private String codigoBeneficioFiscalRBC;
	@Element(name = "vBC", required = false)
	private String valorBCICMS;

	@Element(name = "pICMS", required = false)
	private String percentualICMS;

	@Element(name = "vICMSOp", required = false)
	private String valorICMSOperacao;

	@Element(name = "pDif", required = false)
	private String percentualDiferimento;

	@Element(name = "vICMSDif", required = false)
	private String valorICMSDiferimento;

	@Element(name = "vICMS", required = false)
	private String valorICMS;

	@Element(name = "vBCFCP", required = false)
	private String valorBCFundoCombatePobreza;

	@Element(name = "pFCP", required = false)
	private String percentualFundoCombatePobreza;

	@Element(name = "vFCP", required = false)
	private String valorFundoCombatePobreza;

	@Element(name = "pFCPDif", required = false)
	private String percentualDiferimentoFundoCombatePobreza;

	@Element(name = "vFCPDif", required = false)
	private String valorDiferimentoFundoCombatePobreza;

	@Element(name = "vFCPEfet", required = false)
	private String valorEfetivoFundoCombatePobreza;





	public String getPercentualDiferimentoFundoCombatePobreza() {
		return percentualDiferimentoFundoCombatePobreza;
	}

	public void setPercentualDiferimentoFundoCombatePobreza(BigDecimal percentualDiferimentoFundoCombatePobreza) {

		if (percentualDiferimentoFundoCombatePobreza.signum() < 0) {
			throw new IllegalStateException("Percentual diferimento fundo de combate a pobreza precisa ser maior que zero!");
		}
		this.percentualDiferimentoFundoCombatePobreza = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(percentualDiferimentoFundoCombatePobreza,
																										   "Percentual diferimento fundo combate pobreza");
	}

	public String getValorDiferimentoFundoCombatePobreza() {
		return valorDiferimentoFundoCombatePobreza;
	}

	public void setValorDiferimentoFundoCombatePobreza(BigDecimal valorDiferimentoFundoCombatePobreza) {
		this.valorDiferimentoFundoCombatePobreza = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorDiferimentoFundoCombatePobreza,
																									"Valor diferimento fundo combate pobreza");
	}

	public String getValorEfetivoFundoCombatePobreza() {
		return valorEfetivoFundoCombatePobreza;
	}

	public void setValorEfetivoFundoCombatePobreza(BigDecimal valorEfetivoFundoCombatePobreza) {
		this.valorEfetivoFundoCombatePobreza = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorEfetivoFundoCombatePobreza,
																								"Valor efetivo fundo combate pobreza");
	}

	public void setOrigem(final NFOrigem origem) {
		this.origem = origem;
	}

	public void setSituacaoTributaria(final NFNotaInfoImpostoTributacaoICMS situacaoTributaria) {
		this.situacaoTributaria = situacaoTributaria;
	}

	public void setModalidadeBCICMS(final NFNotaInfoItemModalidadeBCICMS modalidadeBCICMS) {
		this.modalidadeBCICMS = modalidadeBCICMS;
	}

	public void setPercentualReducaoBC(final BigDecimal percentualReducaoBC) {
		this.percentualReducaoBC = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(percentualReducaoBC,
																					  "Percentual Reducao BC ICMS51 Item");
	}

	public void setValorBCICMS(final BigDecimal valorBCICMS) {
		this.valorBCICMS = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorBCICMS, "Valor BC ICMS ICMS51 Item");
	}

	public void setPercentualICMS(final BigDecimal percentualICMS) {
		this.percentualICMS = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(percentualICMS,
																				 "Percentual ICMS ICMS51 Item");
	}

	public void setValorICMS(final BigDecimal valorICMS) {
		this.valorICMS = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorICMS, "Valor ICMS ICMS51 Item");
	}

	public void setPercentualDiferimento(final BigDecimal percentualDiferimento) {
		this.percentualDiferimento = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(percentualDiferimento,
																						"Percentual Diferimento ICMS51 Item");
	}

	public void setValorICMSDiferimento(final BigDecimal valorICMSDiferimento) {
		this.valorICMSDiferimento = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorICMSDiferimento,
																					 "Valor ICMS Diferimento ICMS51 Item");
	}

	public void setValorICMSOperacao(final BigDecimal valorICMSOperacao) {
		this.valorICMSOperacao = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorICMSOperacao,
																				  "Valor ICMS Operacao ICMS51 Item");
	}

	public void setValorBCFundoCombatePobreza(final BigDecimal valorBCFundoCombatePobreza) {
		this.valorBCFundoCombatePobreza = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorBCFundoCombatePobreza,
																						   "Valor base calculo fundo combate pobreza");
	}

	public void setPercentualFundoCombatePobreza(final BigDecimal percentualFundoCombatePobreza) {
		if (percentualFundoCombatePobreza.signum() < 0) {
			throw new IllegalStateException("Percentual fundo de combate a pobreza precisa ser maior que zero!");
		}
		this.percentualFundoCombatePobreza = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(percentualFundoCombatePobreza,
																								"Percentual fundo combate pobreza");
	}

	public void setValorFundoCombatePobreza(final BigDecimal valorFundoCombatePobreza) {
		this.valorFundoCombatePobreza = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorFundoCombatePobreza,
																						 "Valor fundo combate pobreza");
	}

	public void setCodigoBeneficioFiscalRBC(final String codigoBeneficioFiscalRBC) {
		this.codigoBeneficioFiscalRBC = DFStringValidador.validador(codigoBeneficioFiscalRBC, "Codigo Beneficio Fiscal RBC", 10, false, false);
	}

	public NFOrigem getOrigem() {
		return this.origem;
	}

	public NFNotaInfoImpostoTributacaoICMS getSituacaoTributaria() {
		return this.situacaoTributaria;
	}

	public NFNotaInfoItemModalidadeBCICMS getModalidadeBCICMS() {
		return this.modalidadeBCICMS;
	}

	public String getPercentualReducaoBC() {
		return this.percentualReducaoBC;
	}

	public String getValorBCICMS() {
		return this.valorBCICMS;
	}

	public String getPercentualICMS() {
		return this.percentualICMS;
	}

	public String getValorICMSOperacao() {
		return this.valorICMSOperacao;
	}

	public String getPercentualDiferimento() {
		return this.percentualDiferimento;
	}

	public String getValorICMSDiferimento() {
		return this.valorICMSDiferimento;
	}

	public String getValorICMS() {
		return this.valorICMS;
	}

	public String getValorBCFundoCombatePobreza() {
		return this.valorBCFundoCombatePobreza;
	}

	public String getPercentualFundoCombatePobreza() {
		return this.percentualFundoCombatePobreza;
	}

	public String getValorFundoCombatePobreza() {
		return this.valorFundoCombatePobreza;
	}

	public String getCodigoBeneficioFiscalRBC() { return this.codigoBeneficioFiscalRBC;	}
}