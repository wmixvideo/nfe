package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;

public class NFNotaInfoItemImpostoCOFINSAliquota extends NFBase {
	
	@Element(name = "CST", required = true)
	private String codigoSituacaoTributaria;
	
	@Element(name = "vBC", required = true)
	private BigDecimal valorBaseCalulo;
	
	@Element(name = "pCOFINS", required = true)
	private BigDecimal aliquota;
	
	@Element(name = "vCOFINS", required = true)
	private BigDecimal valor;
	
	public NFNotaInfoItemImpostoCOFINSAliquota() {
		this.codigoSituacaoTributaria = null;
		this.valorBaseCalulo = null;
		this.aliquota = null;
		this.valor = null;
	}
	
	public String getCodigoSituacaoTributaria() {
		return this.codigoSituacaoTributaria;
	}
	
	public void setCodigoSituacaoTributaria(final String codigoSituacaoTributaria) {
		this.codigoSituacaoTributaria = codigoSituacaoTributaria;
	}
	
	public BigDecimal getValorBaseCalulo() {
		return this.valorBaseCalulo;
	}
	
	public void setValorBaseCalulo(final BigDecimal valorBaseCalulo) {
		this.valorBaseCalulo = valorBaseCalulo;
	}
	
	public BigDecimal getAliquota() {
		return this.aliquota;
	}
	
	public void setAliquota(final BigDecimal aliquota) {
		this.aliquota = aliquota;
	}
	
	public BigDecimal getValor() {
		return this.valor;
	}
	
	public void setValor(final BigDecimal valor) {
		this.valor = valor;
	}
}