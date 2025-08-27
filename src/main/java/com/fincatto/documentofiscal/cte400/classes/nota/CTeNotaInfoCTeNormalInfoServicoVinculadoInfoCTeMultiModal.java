package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * informações do CT-e multimodal vinculado
 */

@Root(name = "infCTeMultimodal")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoCTeNormalInfoServicoVinculadoInfoCTeMultiModal extends DFBase {
    private static final long serialVersionUID = -874331419832396929L;

    @Element(name = "chCTeMultimodal")
    private String chaveCTeMultiModal;

    public String getChaveCTeMultiModal() {
        return this.chaveCTeMultiModal;
    }

    /**
     * Chave de acesso do CT-e Multimodal
     */
    public void setChaveCTeMultiModal(final String chaveCTeMultiModal) {
        DFStringValidador.exatamente44N(chaveCTeMultiModal, "Chave de acesso do CT-e Multimodal");
        this.chaveCTeMultiModal = chaveCTeMultiModal;
    }
}
