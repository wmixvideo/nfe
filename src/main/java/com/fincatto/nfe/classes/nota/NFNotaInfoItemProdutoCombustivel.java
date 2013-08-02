package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.NFUnidadeFederativa;
import com.fincatto.nfe.classes.NFBase;

public class NFNotaInfoItemProdutoCombustivel extends NFBase {
	
	@Element(name = "cProdANP", required = true)
	private String codigoProdutoANP;
	
	@Element(name = "CODIF", required = false)
	private String codigoAutorizacaoCOFIF;
	
	@Element(name = "qTemp", required = false)
	private BigDecimal quantidade;
	
	@Element(name = "UFCons", required = true)
	private NFUnidadeFederativa uf;
	
	@Element(name = "CIDE", required = false)
	private NFNotaInfoItemProdutoCombustivelCIDE cide;
	
	public NFNotaInfoItemProdutoCombustivel() {
		this.codigoProdutoANP = null;
		this.codigoAutorizacaoCOFIF = null;
		this.quantidade = null;
		this.uf = null;
		this.cide = null;
	}
	
	public String getCodigoProdutoANP() {
		return this.codigoProdutoANP;
	}
	
	public void setCodigoProdutoANP(final String codigoProdutoANP) {
		this.codigoProdutoANP = codigoProdutoANP;
	}
	
	public String getCodigoAutorizacaoCOFIF() {
		return this.codigoAutorizacaoCOFIF;
	}
	
	public void setCodigoAutorizacaoCOFIF(final String codigoAutorizacaoCOFIF) {
		this.codigoAutorizacaoCOFIF = codigoAutorizacaoCOFIF;
	}
	
	public BigDecimal getQuantidade() {
		return this.quantidade;
	}
	
	public void setQuantidade(final BigDecimal quantidade) {
		this.quantidade = quantidade;
	}
	
	public NFUnidadeFederativa getUf() {
		return this.uf;
	}
	
	public void setUf(final NFUnidadeFederativa uf) {
		this.uf = uf;
	}
	
	public NFNotaInfoItemProdutoCombustivelCIDE getCide() {
		return this.cide;
	}
	
	public void setCide(final NFNotaInfoItemProdutoCombustivelCIDE cide) {
		this.cide = cide;
	}
}