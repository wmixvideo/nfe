package com.fincatto.nfe.v200.classes.lote.consulta.recibo;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import com.fincatto.nfe.v200.classes.NFe;

public class TProtNFe extends NFe {
	
	@Attribute(name = "versao", required = true)
	private String versao;
	
	@Element(name = "infProt", required = true)
	private InfProt protocolo;
	
	public TProtNFe() {
		this.versao = null;
		this.protocolo = null;
	}
	
	public String getVersao() {
		return this.versao;
	}
	
	public InfProt getProtocolo() {
		return this.protocolo;
	}
	
	public void setVersao(final String versao) {
		this.versao = versao;
	}
	
	public void setProtocolo(final InfProt protocolo) {
		this.protocolo = protocolo;
	}
}