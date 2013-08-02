package com.fincatto.nfe.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;

public class NFNotaInfoItemProdutoArmamento extends NFBase {
	
	@Element(name = "tpArma", required = true)
	private NFNotaInfoItemProdutoArmamentoTipo tipo;
	
	@Element(name = "nSerie", required = true)
	private String numeroSerieArma;
	
	@Element(name = "nCano", required = true)
	private String numeroSerieCano;
	
	@Element(name = "descr", required = true)
	private String descricao;
	
	public NFNotaInfoItemProdutoArmamento() {
		this.tipo = null;
		this.numeroSerieArma = null;
		this.numeroSerieCano = null;
		this.descricao = null;
	}
	
	public NFNotaInfoItemProdutoArmamentoTipo getTipo() {
		return this.tipo;
	}
	
	public void setTipo(final NFNotaInfoItemProdutoArmamentoTipo tipo) {
		this.tipo = tipo;
	}
	
	public String getNumeroSerieArma() {
		return this.numeroSerieArma;
	}
	
	public void setNumeroSerieArma(final String numeroSerieArma) {
		this.numeroSerieArma = numeroSerieArma;
	}
	
	public String getNumeroSerieCano() {
		return this.numeroSerieCano;
	}
	
	public void setNumeroSerieCano(final String numeroSerieCano) {
		this.numeroSerieCano = numeroSerieCano;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}
}
