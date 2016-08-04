package com.fincatto.nfe.core.nota;

import com.fincatto.nfe.core.NFBase;
import com.fincatto.nfe.core.validadores.StringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "infNFeSupl")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFNotaInfoSuplementar extends NFBase {

	@Element(data = true, name = "qrCode", required = true)
	private String qrCode;

	public void setQrCode(final String qrCode) {
		StringValidador.tamanho100a600(qrCode, "QR Code");
		this.qrCode = qrCode;
	}

	public String getQrCode() {
		return this.qrCode;
	}
}