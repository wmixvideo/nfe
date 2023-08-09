package com.fincatto.documentofiscal.cte300.classes.os;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "infCTeNorm")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeOSInfoCTeNormal extends DFBase {
    private static final long serialVersionUID = -1176357232990148386L;

    @Element(name = "infServico")
    private CTeOSInfoCTeNormalInfoServico infoCarga;

    @ElementList(name = "infDocRef", inline = true, required = false)
    private List<CTeOSInfoCTeNormalInfoDocumentos> infoDocumentos;

    @ElementList(name = "seg", inline = true, required = false)
    private List<CTeOSInfoCTeNormalSeguro> seguros;

    @Element(name = "infModal")
    private CTeOSInfoCTeNormalInfoModal infoModal;

    @Element(name = "infCteSub", required = false)
    private CTeOSInfoCTeNormalInfoCTeSubstituicao infoCTeSubstituicao;

    @Element(name = "cobr", required = false)
    private CTeOSInfoCTeNormalInfoCobranca cobranca;

    @ElementList(name = "infGTVe", inline = true, required = false)
    private List<CTeOSInfoCTeNormalInfoGTVe> infoGTVe;

    public CTeOSInfoCTeNormalInfoServico getInfoCarga() {
        return infoCarga;
    }

    public void setInfoCarga(final CTeOSInfoCTeNormalInfoServico infoCarga) {
        this.infoCarga = infoCarga;
    }

    public List<CTeOSInfoCTeNormalInfoDocumentos> getInfoDocumentos() {
        return infoDocumentos;
    }

    public void setInfoDocumentos(List<CTeOSInfoCTeNormalInfoDocumentos> infoDocumentos) {
        this.infoDocumentos = infoDocumentos;
    }

    public List<CTeOSInfoCTeNormalSeguro> getSeguros() {
        return seguros;
    }

    public void setSeguros(List<CTeOSInfoCTeNormalSeguro> seguros) {
        this.seguros = seguros;
    }

    public CTeOSInfoCTeNormalInfoModal getInfoModal() {
        return infoModal;
    }

    public void setInfoModal(final CTeOSInfoCTeNormalInfoModal infoModal) {
        this.infoModal = infoModal;
    }

    public CTeOSInfoCTeNormalInfoCTeSubstituicao getInfoCTeSubstituicao() {
        return infoCTeSubstituicao;
    }

    public void setInfoCTeSubstituicao(final CTeOSInfoCTeNormalInfoCTeSubstituicao infoCTeSubstituicao) {
        this.infoCTeSubstituicao = infoCTeSubstituicao;
    }

    public CTeOSInfoCTeNormalInfoCobranca getCobranca() {
        return cobranca;
    }

    public void setCobranca(final CTeOSInfoCTeNormalInfoCobranca cobranca) {
        this.cobranca = cobranca;
    }

    public List<CTeOSInfoCTeNormalInfoGTVe> getInfoGTVe() {
        return infoGTVe;
    }

    public void setInfoGTVe(final List<CTeOSInfoCTeNormalInfoGTVe> infoGTVe) {
        this.infoGTVe = infoGTVe;
    }
}
