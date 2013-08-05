package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;

public class NFNotaInfoItemImpostoISSQN extends NFBase {
	
	@Element(name = "vBC", required = true)
	private BigDecimal valorBaseCalculo;
	
	@Element(name = "vAliq", required = true)
	private BigDecimal valorAliquota;
	
	@Element(name = "vISSQN", required = true)
	private BigDecimal valor;
	
	@Element(name = "cMunFG", required = true)
	private String codigoMunicipio;
	
	@Element(name = "cListServ", required = true)
	private String itemListaServicos;
	
	@Element(name = "cSitTrib", required = true)
	private String codigoTributacao;
	
	public NFNotaInfoItemImpostoISSQN() {
		this.valorBaseCalculo = null;
		this.valorAliquota = null;
		this.valor = null;
		this.codigoMunicipio = null;
		this.itemListaServicos = null;
		this.codigoTributacao = null;
	}
	
	public BigDecimal getValorBaseCalculo() {
		return this.valorBaseCalculo;
	}
	
	public void setValorBaseCalculo(final BigDecimal valorBaseCalculo) {
		this.valorBaseCalculo = valorBaseCalculo;
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
	
	public String getCodigoMunicipio() {
		return this.codigoMunicipio;
	}
	
	public void setCodigoMunicipio(final String codigoMunicipio) {
		this.codigoMunicipio = codigoMunicipio;
	}
	
	public String getItemListaServicos() {
		return this.itemListaServicos;
	}
	
	public void setItemListaServicos(final String itemListaServicos) {
		this.itemListaServicos = itemListaServicos;
	}
	
	public String getCodigoTributacao() {
		return this.codigoTributacao;
	}
	
	public void setCodigoTributacao(final String codigoTributacao) {
		this.codigoTributacao = codigoTributacao;
	}
}