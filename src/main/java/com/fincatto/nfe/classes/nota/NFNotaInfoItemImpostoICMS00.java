package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.classes.NFOrigem;

public class NFNotaInfoItemImpostoICMS00 extends NFBase {
	
	@Element(name = "orig", required = true)
	private NFOrigem origem;
	
	@Element(name = "CST", required = true)
	private String codigoSituacaoTributaria;
	
	@Element(name = "modBC", required = true)
	private NFNotaInfoItemImpostoICMSModalidadeBaseCalulo modalidadeBaseCalculo;
	
	@Element(name = "vBC", required = true)
	private BigDecimal valorBaseCalculo;
	
	@Element(name = "pICMS", required = true)
	private BigDecimal aliquota;
	
	@Element(name = "vICMS", required = true)
	private BigDecimal valorTributo;
	
	public NFNotaInfoItemImpostoICMS00() {
		this.origem = null;
		this.codigoSituacaoTributaria = null;
		this.modalidadeBaseCalculo = null;
		this.valorBaseCalculo = null;
		this.aliquota = null;
		this.valorTributo = null;
	}
	
	public NFOrigem getOrigem() {
		return this.origem;
	}
	
	public void setOrigem(final NFOrigem origem) {
		this.origem = origem;
	}
	
	public String getCodigoSituacaoTributaria() {
		return this.codigoSituacaoTributaria;
	}
	
	public void setCodigoSituacaoTributaria(final String codigoSituacaoTributaria) {
		this.codigoSituacaoTributaria = codigoSituacaoTributaria;
	}
	
	public NFNotaInfoItemImpostoICMSModalidadeBaseCalulo getModalidadeBaseCalculo() {
		return this.modalidadeBaseCalculo;
	}
	
	public void setModalidadeBaseCalculo(final NFNotaInfoItemImpostoICMSModalidadeBaseCalulo modalidadeBaseCalculo) {
		this.modalidadeBaseCalculo = modalidadeBaseCalculo;
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
	
	public BigDecimal getValorTributo() {
		return this.valorTributo;
	}
	
	public void setValorTributo(final BigDecimal valorTributo) {
		this.valorTributo = valorTributo;
	}
}
