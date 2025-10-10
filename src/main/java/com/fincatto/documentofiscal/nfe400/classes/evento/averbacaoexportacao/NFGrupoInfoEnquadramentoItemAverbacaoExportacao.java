package com.fincatto.documentofiscal.nfe400.classes.evento.averbacaoexportacao;

import java.util.List;

import org.simpleframework.xml.ElementList;

import com.fincatto.documentofiscal.DFBase;

public class NFGrupoInfoEnquadramentoItemAverbacaoExportacao extends DFBase {

	private static final long serialVersionUID = -2108607168234248096L;
	
	@ElementList(entry = "cEnq", inline = true)
	private List<String> codigosEnquadramento;

	public List<String> getCodigosEnquadramento() {
		return codigosEnquadramento;
	}

	public void setCodigosEnquadramento(List<String> codigosEnquadramento) {
		this.codigosEnquadramento = codigosEnquadramento;
	}
	
}
