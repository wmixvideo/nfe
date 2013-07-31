package com.fincatto.nfe.v200.classes.lote.consulta;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.fincatto.nfe.Ambiente;
import com.fincatto.nfe.v200.classes.NFe;

@Root(name = "consReciNFe")
public class TConsReciNFe extends NFe {
	
	@Attribute(name = "versao", required = true)
	private String versao;
	
	@Element(name = "tpAmb", required = true)
	private Ambiente ambiente;
	
	@Element(name = "nRec", required = true)
	private String recibo;
	
	public TConsReciNFe() {
		this.versao = null;
		this.ambiente = null;
		this.recibo = null;
	}
	
	public String getVersao() {
		return this.versao;
	}
	
	public void setVersao(final String versao) {
		this.versao = versao;
	}
	
	public Ambiente getAmbiente() {
		return this.ambiente;
	}
	
	public void setAmbiente(final Ambiente ambiente) {
		this.ambiente = ambiente;
	}
	
	public String getRecibo() {
		return this.recibo;
	}
	
	public void setRecibo(final String recibo) {
		this.recibo = recibo;
	}
}