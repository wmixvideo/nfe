package com.fincatto.documentofiscal.cte300.classes.nota;

import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;

/**
 * @author Caio
 * @info Informações do Serviço Vinculado a Multimodal
 * */

@Root(name = "infServVinc")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalInfoServicoVinculado extends DFBase{

	@ElementList(name = "infCTeMultimodal", inline = true, required = true)
    private List<CTeNotaInfoCTeNormalInfoServicoVinculadoInfoCTeMultiModal> infoCTeMultiModal;

	public CTeNotaInfoCTeNormalInfoServicoVinculado() {
		this.infoCTeMultiModal = null;
	}

	public List<CTeNotaInfoCTeNormalInfoServicoVinculadoInfoCTeMultiModal> getInfoCTeMultiModal() {
		return infoCTeMultiModal;
	}

	/**
	 * informações do CT-e multimodal vinculado
	 * */
	public void setInfoCTeMultiModal(List<CTeNotaInfoCTeNormalInfoServicoVinculadoInfoCTeMultiModal> infoCTeMultiModal) {
		this.infoCTeMultiModal = infoCTeMultiModal;
	}
}
