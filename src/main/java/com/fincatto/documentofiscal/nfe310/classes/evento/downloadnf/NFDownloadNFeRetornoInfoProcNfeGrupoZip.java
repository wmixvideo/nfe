package com.fincatto.documentofiscal.nfe310.classes.evento.downloadnf;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "procNFeGrupoZip")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFDownloadNFeRetornoInfoProcNfeGrupoZip {

	@Element(name = "NFeZip", required = false)
	private String nfeZip;
	
	@Element(name = "protNFeZip", required = false)
	private String protNfeZip;

	public NFDownloadNFeRetornoInfoProcNfeGrupoZip() {
		this.nfeZip = null;
		this.protNfeZip = null;
	}

	public String getNfeZip() {
		return nfeZip;
	}

	public void setNfeZip(final String nfeZip) {
		this.nfeZip = nfeZip;
	}

	public String getProtNfeZip() {
		return protNfeZip;
	}

	public void setProtNfeZip(final String protNfeZip) {
		this.protNfeZip = protNfeZip;
	}
}
