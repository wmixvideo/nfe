package com.fincatto.documentofiscal.cte300.classes.nota;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.StringValidador;

/**
 * @author Caio
 * @info Documentos de transporte anterior eletrônicos
 * */

@Root(name = "idDocAntEle")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalDocumentosAnterioresEmissorDocumentosAnterioresIdentificacaoEletronico extends DFBase {

	@Element(name = "chCTe", required = true)
	private String chaveCTe;

	public CTeNotaInfoCTeNormalDocumentosAnterioresEmissorDocumentosAnterioresIdentificacaoEletronico() {
		this.chaveCTe = null;
	}

	public String getChaveCTe() {
		return chaveCTe;
	}

	/**
	 * Chave de acesso do CT-e
	 * */
	public void setChaveCTe(String chaveCTe) {
		StringValidador.exatamente44N(chaveCTe, "Chave de acesso do CT-e");
		this.chaveCTe = chaveCTe;
	}
}
