package com.fincatto.nfe.classes.nota;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;

public class NFNotaInfoItem extends NFBase {
	
	@Attribute(name = "nItem", required = true)
	private String numeroItem;
	
	@Element(name = "infAdProd", required = false)
	private String informacoesAdicionais;
	
	@Element(name = "prod", required = true)
	private NFNotaInfoItemProduto produto;
	
	@Element(name = "imposto", required = true)
	private NFNotaInfoItemImposto imposto;
	
	public NFNotaInfoItem() {
		this.numeroItem = null;
		this.informacoesAdicionais = null;
		this.produto = null;
		this.imposto = null;
	}
	
	public String getNumeroItem() {
		return this.numeroItem;
	}
	
	public void setNumeroItem(final String numeroItem) {
		this.numeroItem = numeroItem;
	}
	
	public String getInformacoesAdicionais() {
		return this.informacoesAdicionais;
	}
	
	public void setInformacoesAdicionais(final String informacoesAdicionais) {
		this.informacoesAdicionais = informacoesAdicionais;
	}
	
	public NFNotaInfoItemProduto getProduto() {
		return this.produto;
	}
	
	public void setProduto(final NFNotaInfoItemProduto produto) {
		this.produto = produto;
	}
	
	public NFNotaInfoItemImposto getImposto() {
		return this.imposto;
	}
	
	public void setImposto(final NFNotaInfoItemImposto imposto) {
		this.imposto = imposto;
	}
}