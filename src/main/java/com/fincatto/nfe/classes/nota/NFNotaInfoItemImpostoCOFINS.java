package com.fincatto.nfe.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;

public class NFNotaInfoItemImpostoCOFINS extends NFBase {
	
	@Element(name = "COFINSAliq", required = false)
	private NFNotaInfoItemImpostoCOFINSAliquota aliquota;
	
	@Element(name = "COFINSQtde", required = false)
	private NFNotaInfoItemImpostoCOFINSQuantidade quantidade;
	
	@Element(name = "COFINSNT", required = false)
	private NFNotaInfoItemImpostoCOFINSNaoTributavel naoTributavel;
	
	@Element(name = "COFINSOutr", required = false)
	private NFNotaInfoItemImpostoCOFINSOutrasOperacoes outrasOperacoes;
	
	public NFNotaInfoItemImpostoCOFINS() {
		this.aliquota = null;
		this.quantidade = null;
		this.naoTributavel = null;
		this.outrasOperacoes = null;
	}
	
	public NFNotaInfoItemImpostoCOFINSAliquota getAliquota() {
		return this.aliquota;
	}
	
	public void setAliquota(final NFNotaInfoItemImpostoCOFINSAliquota aliquota) {
		this.aliquota = aliquota;
	}
	
	public NFNotaInfoItemImpostoCOFINSQuantidade getQuantidade() {
		return this.quantidade;
	}
	
	public void setQuantidade(final NFNotaInfoItemImpostoCOFINSQuantidade quantidade) {
		this.quantidade = quantidade;
	}
	
	public NFNotaInfoItemImpostoCOFINSNaoTributavel getNaoTributavel() {
		return this.naoTributavel;
	}
	
	public void setNaoTributavel(final NFNotaInfoItemImpostoCOFINSNaoTributavel naoTributavel) {
		this.naoTributavel = naoTributavel;
	}
	
	public NFNotaInfoItemImpostoCOFINSOutrasOperacoes getOutrasOperacoes() {
		return this.outrasOperacoes;
	}
	
	public void setOutrasOperacoes(final NFNotaInfoItemImpostoCOFINSOutrasOperacoes outrasOperacoes) {
		this.outrasOperacoes = outrasOperacoes;
	}
}