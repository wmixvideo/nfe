package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;

public class NFNotaInfoItemImpostoImportacao extends NFBase {
	
	@Element(name = "vBC", required = true)
	private BigDecimal valorBaseCalculo;
	
	@Element(name = "vDespAdu", required = true)
	private BigDecimal valorDespesaAduaneira;
	
	@Element(name = "vII", required = true)
	private BigDecimal valorImpostoImportacao;
	
	@Element(name = "vIOF", required = true)
	private BigDecimal valorIOF;
	
	public NFNotaInfoItemImpostoImportacao() {
		this.valorBaseCalculo = null;
		this.valorDespesaAduaneira = null;
		this.valorImpostoImportacao = null;
		this.valorIOF = null;
	}
	
	public BigDecimal getValorBaseCalculo() {
		return this.valorBaseCalculo;
	}
	
	public void setValorBaseCalculo(final BigDecimal valorBaseCalculo) {
		this.valorBaseCalculo = valorBaseCalculo;
	}
	
	public BigDecimal getValorDespesaAduaneira() {
		return this.valorDespesaAduaneira;
	}
	
	public void setValorDespesaAduaneira(final BigDecimal valorDespesaAduaneira) {
		this.valorDespesaAduaneira = valorDespesaAduaneira;
	}
	
	public BigDecimal getValorImpostoImportacao() {
		return this.valorImpostoImportacao;
	}
	
	public void setValorImpostoImportacao(final BigDecimal valorImpostoImportacao) {
		this.valorImpostoImportacao = valorImpostoImportacao;
	}
	
	public BigDecimal getValorIOF() {
		return this.valorIOF;
	}
	
	public void setValorIOF(final BigDecimal valorIOF) {
		this.valorIOF = valorIOF;
	}
}