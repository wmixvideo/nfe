package com.fincatto.nfe.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;

public class NFNotaInfoItemImpostoPISNaoTributado extends NFBase {
	
	@Element(name = "CST", required = true)
	private String codigoSituacaoTributaria;
	
	public NFNotaInfoItemImpostoPISNaoTributado() {
		this.codigoSituacaoTributaria = null;
	}
	
	public String getCodigoSituacaoTributaria() {
		return this.codigoSituacaoTributaria;
	}
	
	public void setCodigoSituacaoTributaria(final String codigoSituacaoTributaria) {
		this.codigoSituacaoTributaria = codigoSituacaoTributaria;
	}
}