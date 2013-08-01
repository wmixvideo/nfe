package com.fincatto.nfe.classes.lote.consulta;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFe;

public class NFLoteConsultaRetornoProtocolo extends NFe {
	
	@Attribute(name = "versao", required = true)
	private String versao;
	
	@Element(name = "infProt", required = true)
	private NFLoteConsultaRetornoProtocoloInfo protocolo;
	
	public NFLoteConsultaRetornoProtocolo() {
		this.versao = null;
		this.protocolo = null;
	}
	
	public String getVersao() {
		return this.versao;
	}
	
	public NFLoteConsultaRetornoProtocoloInfo getProtocolo() {
		return this.protocolo;
	}
	
	public void setVersao(final String versao) {
		this.versao = versao;
	}
	
	public void setProtocolo(final NFLoteConsultaRetornoProtocoloInfo protocolo) {
		this.protocolo = protocolo;
	}
}