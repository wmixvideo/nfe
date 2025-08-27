package com.fincatto.documentofiscal.mdfe.classes.distribuicao;

import java.util.List;

import org.simpleframework.xml.ElementList;

import com.fincatto.documentofiscal.DFBase;

public class MDFeDistribuicaoDFeLote extends DFBase {
	private static final long serialVersionUID = 5213446895183202408L;

	@ElementList(name = "docZip", inline = true, required = false)
	private List<MDFeDistribuicaoDocumentoZip> docZip;

	public List<MDFeDistribuicaoDocumentoZip> getDocZip() {
		return this.docZip;
	}

	public MDFeDistribuicaoDFeLote setDocZip(final List<MDFeDistribuicaoDocumentoZip> docZip) {
		this.docZip = docZip;
		return this;
	}
}