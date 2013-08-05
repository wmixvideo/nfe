package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;

public class NFNotaInfoItemImpostoIPITributado extends NFBase {
	
	@Element(name = "CST", required = true)
	private String codigoSituacaoTributaria;
	
	@Element(name = "vBC", required = false)
	private BigDecimal valorBaseCalculo;
	
	@Element(name = "pIPI", required = false)
	private BigDecimal aliquota;
	
	@Element(name = "qUnid", required = false)
	private BigDecimal quantidade;
	
	@Element(name = "vUnid", required = false)
	private BigDecimal valorUnitario;
	
	@Element(name = "vIPI", required = true)
	private BigDecimal valorTributo;
	
	public NFNotaInfoItemImpostoIPITributado() {
		this.codigoSituacaoTributaria = null;
		this.valorBaseCalculo = null;
		this.aliquota = null;
		this.quantidade = null;
		this.valorUnitario = null;
		this.valorTributo = null;
	}
	
	public String getCodigoSituacaoTributaria() {
		return this.codigoSituacaoTributaria;
	}
	
	public void setCodigoSituacaoTributaria(final String codigoSituacaoTributaria) {
		this.codigoSituacaoTributaria = codigoSituacaoTributaria;
	}
	
	public BigDecimal getValorBaseCalculo() {
		return this.valorBaseCalculo;
	}
	
	public void setValorBaseCalculo(final BigDecimal valorBaseCalculo) {
		this.valorBaseCalculo = valorBaseCalculo;
	}
	
	public BigDecimal getAliquota() {
		return this.aliquota;
	}
	
	public void setAliquota(final BigDecimal aliquota) {
		this.aliquota = aliquota;
	}
	
	public BigDecimal getQuantidade() {
		return this.quantidade;
	}
	
	public void setQuantidade(final BigDecimal quantidade) {
		this.quantidade = quantidade;
	}
	
	public BigDecimal getValorUnitario() {
		return this.valorUnitario;
	}
	
	public void setValorUnitario(final BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	public BigDecimal getValorTributo() {
		return this.valorTributo;
	}
	
	public void setValorTributo(final BigDecimal valorTributo) {
		this.valorTributo = valorTributo;
	}
}