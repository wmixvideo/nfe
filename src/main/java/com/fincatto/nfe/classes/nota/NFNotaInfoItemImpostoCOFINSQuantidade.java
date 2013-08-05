package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;

public class NFNotaInfoItemImpostoCOFINSQuantidade extends NFBase {
	
	@Element(name = "CST", required = true)
	private String codigoSituacaoTributaria;
	
	@Element(name = "qBCProd", required = true)
	private BigDecimal quantidadeVendida;
	
	@Element(name = "vAliqProd", required = true)
	private BigDecimal valorAliquota;
	
	@Element(name = "vCOFINS", required = true)
	private BigDecimal valorTributo;
	
	public NFNotaInfoItemImpostoCOFINSQuantidade() {
		this.codigoSituacaoTributaria = null;
		this.quantidadeVendida = null;
		this.valorAliquota = null;
		this.valorTributo = null;
	}
	
	public String getCodigoSituacaoTributaria() {
		return this.codigoSituacaoTributaria;
	}
	
	public void setCodigoSituacaoTributaria(final String codigoSituacaoTributaria) {
		this.codigoSituacaoTributaria = codigoSituacaoTributaria;
	}
	
	public BigDecimal getQuantidadeVendida() {
		return this.quantidadeVendida;
	}
	
	public void setQuantidadeVendida(final BigDecimal quantidadeVendida) {
		this.quantidadeVendida = quantidadeVendida;
	}
	
	public BigDecimal getValorAliquota() {
		return this.valorAliquota;
	}
	
	public void setValorAliquota(final BigDecimal valorAliquota) {
		this.valorAliquota = valorAliquota;
	}
	
	public BigDecimal getValorTributo() {
		return this.valorTributo;
	}
	
	public void setValorTributo(final BigDecimal valorTributo) {
		this.valorTributo = valorTributo;
	}
}
