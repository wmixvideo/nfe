package com.fincatto.documentofiscal.cte300.classes.nota;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.StringValidador;


/**
 * @author Caio
 * @info informações do CT-e multimodal vinculado
 * */

@Root(name = "infCTeMultimodal")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalInfoServicoVinculadoInfoCTeMultiModal extends DFBase {

	@Element(name = "chCTeMultimodal", required = true)
	private String chaveCTeMultiModal;

	public CTeNotaInfoCTeNormalInfoServicoVinculadoInfoCTeMultiModal() {
		this.chaveCTeMultiModal = null;
	}

	public String getChaveCTeMultiModal() {
		return chaveCTeMultiModal;
	}

	/**
	 * Chave de acesso do CT-e Multimodal
	 * */
	public void setChaveCTeMultiModal(String chaveCTeMultiModal) {
		StringValidador.exatamente44N(chaveCTeMultiModal, "Chave de acesso do CT-e Multimodal");
		this.chaveCTeMultiModal = chaveCTeMultiModal;
	}
}
