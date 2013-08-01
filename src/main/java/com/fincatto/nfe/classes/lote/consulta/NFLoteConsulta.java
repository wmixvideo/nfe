package com.fincatto.nfe.classes.lote.consulta;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.nfe.NFAmbiente;
import com.fincatto.nfe.classes.NFe;

@Root(name = "consReciNFe")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFLoteConsulta extends NFe {
	
	@Attribute(name = "versao", required = true)
	private String versao;
	
	@Element(name = "tpAmb", required = true)
	private NFAmbiente ambiente;
	
	@Element(name = "nRec", required = true)
	private String recibo;
	
	public NFLoteConsulta() {
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