package com.fincatto.nfe310.classes.nota;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.validadores.StringValidador;

@Root(name = "infNFeSupl")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFNotaInfoSuplementar extends NFBase {

	@Element(data = true, name = "qrCode", required = true)
	private String qrCode;

	public void setQrCode(final String qrCode) {
		StringValidador.tamanho100a600(qrCode);
		this.qrCode = qrCode;
	}

	public String getQrCode() {
		return this.qrCode;
	}
}