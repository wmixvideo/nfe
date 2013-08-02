package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;

public class NFNotaInfoItemProdutoCombustivelCIDE extends NFBase {
	
	@Element(name = "qBCProd", required = true)
	private BigDecimal quantidade;
	
	@Element(name = "vAliqProd", required = true)
	private BigDecimal valorAliquota;
	
	@Element(name = "vCIDE", required = true)
	private BigDecimal valor;
	
	public NFNotaInfoItemProdutoCombustivelCIDE() {
		this.quantidade = null;
		this.valorAliquota = null;
		this.valor = null;
	}
	
	public BigDecimal getQuantidade() {
		return this.quantidade;
	}
	
	public void setQuantidade(final BigDecimal quantidade) {
		this.quantidade = quantidade;
	}
	
	public BigDecimal getValorAliquota() {
		return this.valorAliquota;
	}
	
	public void setValorAliquota(final BigDecimal valorAliquota) {
		this.valorAliquota = valorAliquota;
	}
	
	public BigDecimal getValor() {
		return this.valor;
	}
	
	public void setValor(final BigDecimal valor) {
		this.valor = valor;
	}
}