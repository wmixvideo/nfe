package com.fincatto.nfe.v200.classes.lote.consulta;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.fincatto.nfe.NFAmbiente;
import com.fincatto.nfe.v200.classes.NFe;

@Root(name = "consReciNFe")
public class TConsReciNFe extends NFe {
	
	@Attribute(name = "versao", required = true)
	private String versao;
	
	@Element(name = "tpAmb", required = true)
	private NFAmbiente ambiente;
	
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
	
	public NFAmbiente getAmbiente() {
		return this.ambiente;
	}
	
	public void setAmbiente(final NFAmbiente ambiente) {
		this.ambiente = ambiente;
	}
	
	public String getRecibo() {
		return this.recibo;
	}
	
	public void setRecibo(final String recibo) {
		this.recibo = recibo;
	}
}