package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.joda.time.LocalDate;
import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;

public class NFNotaInfoItemProdutoMedicamento extends NFBase {
	
	@Element(name = "nLote", required = true)
	private String lote;
	
	@Element(name = "qLote", required = true)
	private BigDecimal quantidade;
	
	@Element(name = "dFab", required = true)
	private LocalDate dataFabricacao;
	
	@Element(name = "dVal", required = true)
	private LocalDate dataValidade;
	
	@Element(name = "vPMC", required = true)
	private BigDecimal precoMaximoConsumidor;
	
	public NFNotaInfoItemProdutoMedicamento() {
		this.lote = null;
		this.quantidade = null;
		this.dataFabricacao = null;
		this.dataValidade = null;
		this.precoMaximoConsumidor = null;
	}
	
	public String getLote() {
		return this.lote;
	}
	
	public void setLote(final String lote) {
		this.lote = lote;
	}
	
	public BigDecimal getQuantidade() {
		return this.quantidade;
	}
	
	public void setQuantidade(final BigDecimal quantidade) {
		this.quantidade = quantidade;
	}
	
	public LocalDate getDataFabricacao() {
		return this.dataFabricacao;
	}
	
	public void setDataFabricacao(final LocalDate dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}
	
	public LocalDate getDataValidade() {
		return this.dataValidade;
	}
	
	public void setDataValidade(final LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}
	
	public BigDecimal getPrecoMaximoConsumidor() {
		return this.precoMaximoConsumidor;
	}
	
	public void setPrecoMaximoConsumidor(final BigDecimal precoMaximoConsumidor) {
		this.precoMaximoConsumidor = precoMaximoConsumidor;
	}
}
