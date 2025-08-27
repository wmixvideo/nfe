package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Informações do modal
 */

@Root(name = "infModal")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoCTeNormalInfoModal extends DFBase {
    private static final long serialVersionUID = 1727274545886268852L;

    @Element(name = "rodo", required = false)
    private CTeNotaInfoCTeNormalInfoModalRodoviario rodoviario;

    @Element(name = "aereo", required = false)
    private CTeNotaInfoCTeNormalInfoModalAereo aereo;

    @Element(name = "aquav", required = false)
    private CTeNotaInfoCTeNormalInfoModalAquaviario aquaviario;

    @Element(name = "ferrov", required = false)
    private CTeNotaInfoCTeNormalInfoModalFerroviario ferroviario;

    @Element(name = "duto", required = false)
    private CTeNotaInfoCTeNormalInfoModalDutoviario dutoviario;

    @Element(name = "multimodal", required = false)
    private CTeNotaInfoCTeNormalInfoModalMultiModal multiModal;
    
    @Attribute(name = "versaoModal")
    private String versao;

    public CTeNotaInfoCTeNormalInfoModalRodoviario getRodoviario() {
        return this.rodoviario;
    }

    public void setRodoviario(final CTeNotaInfoCTeNormalInfoModalRodoviario rodoviario) {
        this.rodoviario = rodoviario;
    }

    public CTeNotaInfoCTeNormalInfoModalAereo getAereo() {
        return this.aereo;
    }

    public void setAereo(final CTeNotaInfoCTeNormalInfoModalAereo aereo) {
        this.aereo = aereo;
    }

    public CTeNotaInfoCTeNormalInfoModalAquaviario getAquaviario() {
        return this.aquaviario;
    }

    public void setAquaviario(final CTeNotaInfoCTeNormalInfoModalAquaviario aquaviario) {
        this.aquaviario = aquaviario;
    }

    public CTeNotaInfoCTeNormalInfoModalFerroviario getFerroviario() {
        return this.ferroviario;
    }

    public void setFerroviario(final CTeNotaInfoCTeNormalInfoModalFerroviario ferroviario) {
        this.ferroviario = ferroviario;
    }

    public CTeNotaInfoCTeNormalInfoModalDutoviario getDutoviario() {
        return this.dutoviario;
    }

    public void setDutoviario(final CTeNotaInfoCTeNormalInfoModalDutoviario dutoviario) {
        this.dutoviario = dutoviario;
    }

    public CTeNotaInfoCTeNormalInfoModalMultiModal getMultiModal() {
        return this.multiModal;
    }

    public void setMultiModal(final CTeNotaInfoCTeNormalInfoModalMultiModal multiModal) {
        this.multiModal = multiModal;
    }

    public String getVersao() {
        return this.versao;
    }

    /**
     * Versão do leiaute específico para o Modal
     */
    public void setVersao(final String versaoModal) {
        this.versao = versaoModal;
    }
}
