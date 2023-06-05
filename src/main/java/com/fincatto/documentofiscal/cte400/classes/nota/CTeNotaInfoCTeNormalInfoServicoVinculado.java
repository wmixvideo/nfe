package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Informações do Serviço Vinculado a Multimodal
 */

@Root(name = "infServVinc")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfoCTeNormalInfoServicoVinculado extends DFBase {
    private static final long serialVersionUID = 7320091030783182354L;

    @ElementList(name = "infCTeMultimodal", inline = true)
    private List<CTeNotaInfoCTeNormalInfoServicoVinculadoInfoCTeMultiModal> infoCTeMultiModal;

    public List<CTeNotaInfoCTeNormalInfoServicoVinculadoInfoCTeMultiModal> getInfoCTeMultiModal() {
        return this.infoCTeMultiModal;
    }

    /**
     * informações do CT-e multimodal vinculado
     */
    public void setInfoCTeMultiModal(final List<CTeNotaInfoCTeNormalInfoServicoVinculadoInfoCTeMultiModal> infoCTeMultiModal) {
        this.infoCTeMultiModal = infoCTeMultiModal;
    }
}
