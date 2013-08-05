package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;

public class NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao extends NFBase {
	
	@Element(name = "nAdicao", required = true)
	private String numero;
	
	@Element(name = "nSeqAdic", required = true)
	private String sequencial;
	
	@Element(name = "cFabricante", required = true)
	private String codigoFabricante;
	
	@Element(name = "vDescDI", required = false)
	private BigDecimal desconto;
	
	public NFNotaInfoItemProdutoDeclaracaoImportacaoAdicao() {
		this.numero = null;
		this.sequencial = null;
		this.codigoFabricante = null;
		this.desconto = null;
	}
	
	public String getNumero() {
		return this.numero;
	}
	
	public void setNumero(final String numero) {
		this.numero = numero;
	}
	
	public String getSequencial() {
		return this.sequencial;
	}
	
	public void setSequencial(final String sequencial) {
		this.sequencial = sequencial;
	}
	
	public String getCodigoFabricante() {
		return this.codigoFabricante;
	}
	
	public void setCodigoFabricante(final String codigoFabricante) {
		this.codigoFabricante = codigoFabricante;
	}
	
	public BigDecimal getDesconto() {
		return this.desconto;
	}
	
	public void setDesconto(final BigDecimal desconto) {
		this.desconto = desconto;
	}
}
