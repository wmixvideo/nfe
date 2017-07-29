package com.fincatto.nfe310.classes.lote.envio;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import com.fincatto.nfe310.classes.NFProtocoloInfo;

public class ProtocoloRecebimentoSincrono {
	
	@Attribute(name = "versao", required = true)
    private String versao;
	
	@Element(name = "infProt", required = true)
    private NFProtocoloInfo protocoloInfo;

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public NFProtocoloInfo getProtocoloInfo() {
		return protocoloInfo;
	}

	public void setProtocoloInfo(NFProtocoloInfo protocoloInfo) {
		this.protocoloInfo = protocoloInfo;
	}
	
}
