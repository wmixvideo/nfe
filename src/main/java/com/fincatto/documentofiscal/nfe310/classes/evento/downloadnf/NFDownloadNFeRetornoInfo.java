package com.fincatto.documentofiscal.nfe310.classes.evento.downloadnf;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "retNFe")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFDownloadNFeRetornoInfo {

	@Element(name = "chNFe", required = true)
	private String chave;
	
	@Element(name = "cStat", required = true)
	private String status;
	
	@Element(name = "xMotivo", required = true)
	private String motivo;
	
	@Element(name = "procNFeZip", required = false)
	private String procNfeZip;
	
	@Element(name = "procNFe", required = false)
	private NFDownloadNFeRetornoInfoProcNfe procNfe;

	public NFDownloadNFeRetornoInfo() {
		this.chave = null;
		this.status = null;
		this.motivo = null;
		this.procNfeZip = null;
		this.procNfe = null;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(final String chave) {
		this.chave = chave;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(final String status) {
		this.status = status;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(final String motivo) {
		this.motivo = motivo;
	}

	public String getProcNfeZip() {
		return procNfeZip;
	}

	public void setProcNfeZip(final String procNfeZip) {
		this.procNfeZip = procNfeZip;
	}

	public NFDownloadNFeRetornoInfoProcNfe getProcNfe() {
		return procNfe;
	}

	public void setProcNfe(final NFDownloadNFeRetornoInfoProcNfe procNfe) {
		this.procNfe = procNfe;
	}
	
}
