package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Grupo de informações do CT-e Normal e Substituto
 */

@Root(name = "infCTeNorm")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoCTeNormal extends DFBase {
    private static final long serialVersionUID = 854593078678459136L;

    @Element(name = "infCarga")
    private CTeNotaInfoCTeNormalInfoCarga infoCarga;

    @Element(name = "infDoc", required = false)
    private CTeNotaInfoCTeNormalInfoDocumentos infoDocumentos;

    @Element(name = "docAnt", required = false)
    private CTeNotaInfoCTeNormalDocumentosAnteriores documentosAnteriores;
    
    @Element(name = "infModal")
    private CTeNotaInfoCTeNormalInfoModal infoModal;

    @ElementList(name = "veicNovos", inline = true, required = false)
    private List<CTeNotaInfoCTeNormalVeiculosTransportados> veiculosTransportados;

    @Element(name = "cobr", required = false)
    private CTeNotaInfoCTeNormalCobranca cobranca;

    @Element(name = "infCteSub", required = false)
    private CTeNotaInfoCTeNormalInfoCTeSubstituicao infoCTeSubstituicao;

    @Element(name = "infGlobalizado", required = false)
    private CTeNotaInfoCTeNormalInfoGlobalizado infoGlobalizado;

    @Element(name = "infServVinc", required = false)
    private CTeNotaInfoCTeNormalInfoServicoVinculado infoServicoVinculado;

    public CTeNotaInfoCTeNormalInfoCarga getInfoCarga() {
        return this.infoCarga;
    }

    /**
     * Informações da Carga do CT-e
     */
    public void setInfoCarga(final CTeNotaInfoCTeNormalInfoCarga infoCarga) {
        this.infoCarga = infoCarga;
    }

    public CTeNotaInfoCTeNormalInfoDocumentos getInfoDocumentos() {
        return this.infoDocumentos;
    }

    /**
     * Informações dos documentos transportados pelo CT-e. Opcional para Redespacho Intermediario e Serviço vinculado a multimodal.<br>
     * Poderá não ser informado para os CT-e de redespacho intermediário. Nos demais casos deverá sempre ser informado.
     */
    public void setInfoDocumentos(final CTeNotaInfoCTeNormalInfoDocumentos infoDocumentos) {
        this.infoDocumentos = infoDocumentos;
    }

    public CTeNotaInfoCTeNormalDocumentosAnteriores getDocumentosAnteriores() {
        return this.documentosAnteriores;
    }

    /**
     * Documentos de Transporte Anterior
     */
    public void setDocumentosAnteriores(final CTeNotaInfoCTeNormalDocumentosAnteriores documentosAnteriores) {
        this.documentosAnteriores = documentosAnteriores;
    }

    public CTeNotaInfoCTeNormalInfoModal getInfoModal() {
        return this.infoModal;
    }

    /**
     * Informações do modal
     */
    public void setInfoModal(final CTeNotaInfoCTeNormalInfoModal infoModal) {
        this.infoModal = infoModal;
    }

    public List<CTeNotaInfoCTeNormalVeiculosTransportados> getVeiculosTransportados() {
        return this.veiculosTransportados;
    }

    /**
     * informações dos veículos transportados
     */
    public void setVeiculosTransportados(final List<CTeNotaInfoCTeNormalVeiculosTransportados> veiculosTransportados) {
        this.veiculosTransportados = veiculosTransportados;
    }

    public CTeNotaInfoCTeNormalCobranca getCobranca() {
        return this.cobranca;
    }

    /**
     * Dados da cobrança do CT-e
     */
    public void setCobranca(final CTeNotaInfoCTeNormalCobranca cobranca) {
        this.cobranca = cobranca;
    }

    public CTeNotaInfoCTeNormalInfoCTeSubstituicao getInfoCTeSubstituicao() {
        return this.infoCTeSubstituicao;
    }

    /**
     * Informações do CT-e de substituição
     */
    public void setInfoCTeSubstituicao(final CTeNotaInfoCTeNormalInfoCTeSubstituicao infoCTeSubstituicao) {
        this.infoCTeSubstituicao = infoCTeSubstituicao;
    }

    public CTeNotaInfoCTeNormalInfoGlobalizado getInfoGlobalizado() {
        return this.infoGlobalizado;
    }

    /**
     * Informações do CT-e Globalizado
     */
    public void setInfoGlobalizado(final CTeNotaInfoCTeNormalInfoGlobalizado infoGlobalizado) {
        this.infoGlobalizado = infoGlobalizado;
    }

    public CTeNotaInfoCTeNormalInfoServicoVinculado getInfoServicoVinculado() {
        return this.infoServicoVinculado;
    }

    /**
     * Informações do Serviço Vinculado a Multimodal
     */
    public void setInfoServicoVinculado(final CTeNotaInfoCTeNormalInfoServicoVinculado infoServicoVinculado) {
        this.infoServicoVinculado = infoServicoVinculado;
    }
}
