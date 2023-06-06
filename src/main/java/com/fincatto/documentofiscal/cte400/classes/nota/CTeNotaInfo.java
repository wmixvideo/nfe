package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFListValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.*;

import java.util.List;

/**
 * Informações do CT-e
 */

@Root(name = "infCte")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfo extends DFBase {
    public static final String IDENT = "CTe";
    private static final long serialVersionUID = 8699373848001059117L;

    @Attribute(name = "Id")
    private String identificador;

    @Attribute(name = "versao")
    private String versao;

    @Element(name = "ide")
    private CTeNotaInfoIdentificacao identificacao;

    @Element(name = "compl", required = false)
    private CTeNotaInfoDadosComplementares dadosComplementares;

    @Element(name = "emit")
    private CTeNotaInfoEmitente emitente;

    @Element(name = "rem", required = false)
    private CTeNotaInfoRemetente remetente;

    @Element(name = "exped", required = false)
    private CTeNotaInfoExpedidorCarga expedidorCarga;

    @Element(name = "receb", required = false)
    private CTeNotaInfoRecebedorCarga recebedorCarga;

    @Element(name = "dest", required = false)
    private CTeNotaInfoDestinatario destinatario;

    @Element(name = "vPrest")
    private CTeNotaInfoValorPrestacaoServico valorPrestacaoServico;

    @Element(name = "imp")
    private CTeNotaInfoInformacoesRelativasImpostos informacoesRelativasImpostos;

    @Element(name = "infCTeNorm", required = false)
    private CTeNotaInfoCTeNormal cteNormal;

    @ElementList(inline = true, required = false)
    private List<CTeNotaInfoCTeComplementar> cteComplementar;

    @ElementList(name = "autXML", inline = true, required = false)
    private List<CTeNotaInfoAutorizacaoDownload> autorizacaoDownload;

    @Element(name="infRespTec", required = false)
    private CTeNotaInfoResponsavelTecnico informacaoResposavelTecnico;

    /**
     * Informações da Nota Fiscal Facil de preenchimento exclusivo pelo app NFF
     */
    @Element(name = "infSolicNFF", required = false)
    private CTeInformacoesNotaFiscalFacil informacoesNotaFiscalFacil;

    /**
     * Informações de preenchimento exclusivo do Provedor de Assinatura e Autorização
     */
    @Element(name = "infPAA", required = false)
    private CTeInformacoesPAA informacoesPAA;

    public String getIdentificador() {
        return this.identificador;
    }

    /**
     * Identificador da tag a ser assinada<br>
     * Informar a chave de acesso do CT-e e precedida do literal "CTe"
     */
    public void setIdentificador(final String identificador) {
        DFStringValidador.exatamente44N(identificador, "Identificador");
        this.identificador = CTeNotaInfo.IDENT + identificador;
    }

    /**
     * Pega a chave de acesso a partir do identificador.
     * @return Chave de acesso.
     */
    public String getChaveAcesso() {
        return this.identificador.replace(CTeNotaInfo.IDENT, "");
    }

    public CTeNotaInfoIdentificacao getIdentificacao() {
        return this.identificacao;
    }

    /**
     * Identificação do CT-e
     */
    public void setIdentificacao(final CTeNotaInfoIdentificacao identificacao) {
        this.identificacao = identificacao;
    }

    public CTeNotaInfoDadosComplementares getDadosComplementares() {
        return this.dadosComplementares;
    }

    /**
     * Dados complementares do CT-e para fins operacionais ou comerciais
     */
    public void setDadosComplementares(final CTeNotaInfoDadosComplementares dadosComplementares) {
        this.dadosComplementares = dadosComplementares;
    }

    public CTeNotaInfoEmitente getEmitente() {
        return this.emitente;
    }

    /**
     * Identificação do Emitente do CT-e
     */
    public void setEmitente(final CTeNotaInfoEmitente emitente) {
        this.emitente = emitente;
    }

    public CTeNotaInfoRemetente getRemetente() {
        return this.remetente;
    }

    /**
     * Informações do Remetente das mercadorias transportadas pelo CT-e<br>
     * Poderá não ser informado para os CT-e de redespacho intermediário e serviço vinculado a multimodal. Nos demais casos deverá sempre ser informado.
     */
    public void setRemetente(final CTeNotaInfoRemetente remetente) {
        this.remetente = remetente;
    }

    public CTeNotaInfoExpedidorCarga getExpedidorCarga() {
        return this.expedidorCarga;
    }

    /**
     * Informações do Expedidor da Carga
     */
    public void setExpedidorCarga(final CTeNotaInfoExpedidorCarga expedidorCarga) {
        this.expedidorCarga = expedidorCarga;
    }

    public CTeNotaInfoRecebedorCarga getRecebedorCarga() {
        return this.recebedorCarga;
    }

    /**
     * Informações do Recebedor da Carga
     */
    public void setRecebedorCarga(final CTeNotaInfoRecebedorCarga recebedorCarga) {
        this.recebedorCarga = recebedorCarga;
    }

    public CTeNotaInfoDestinatario getDestinatario() {
        return this.destinatario;
    }

    /**
     * Informações do Destinatário do CT-e<br>
     * Só pode ser omitido em caso de redespacho intermediário
     */
    public void setDestinatario(final CTeNotaInfoDestinatario destinatario) {
        this.destinatario = destinatario;
    }

    public CTeNotaInfoValorPrestacaoServico getValorPrestacaoServico() {
        return this.valorPrestacaoServico;
    }

    /**
     * Valores da Prestação de Serviço
     */
    public void setValorPrestacaoServico(final CTeNotaInfoValorPrestacaoServico valorPrestacaoServico) {
        this.valorPrestacaoServico = valorPrestacaoServico;
    }

    public CTeNotaInfoInformacoesRelativasImpostos getInformacoesRelativasImpostos() {
        return this.informacoesRelativasImpostos;
    }

    /**
     * Informações relativas aos Impostos
     */
    public void setInformacoesRelativasImpostos(final CTeNotaInfoInformacoesRelativasImpostos informacoesRelativasImpostos) {
        this.informacoesRelativasImpostos = informacoesRelativasImpostos;
    }

    public CTeNotaInfoCTeNormal getCteNormal() {
        return this.cteNormal;
    }

    /**
     * Grupo de informações do CT-e Normal e Substituto
     */
    public void setCteNormal(final CTeNotaInfoCTeNormal cteNormal) {
        this.cteNormal = cteNormal;
    }

    public List<CTeNotaInfoCTeComplementar> getCteComplementar() {
        return this.cteComplementar;
    }

    /**
     * Detalhamento do CT-e complementado
     */
    public void setCteComplementar(final List<CTeNotaInfoCTeComplementar> cteComplementar) {
        this.cteComplementar = cteComplementar;
    }

    public List<CTeNotaInfoAutorizacaoDownload> getAutorizacaoDownload() {
        return this.autorizacaoDownload;
    }

    /**
     * Autorizados para download do XML do DF-e<br>
     * Informar CNPJ ou CPF. Preencher os zeros não significativos.
     */
    public void setAutorizacaoDownload(final List<CTeNotaInfoAutorizacaoDownload> autorizacaoDownload) {
        DFListValidador.tamanho10(autorizacaoDownload, "Autorizados para download do XML do DF-e");
        this.autorizacaoDownload = autorizacaoDownload;
    }

    public String getVersao() {
        return this.versao;
    }

    /**
     * Versão do leiaute
     */
    public void setVersao(final String versao) {
        this.versao = versao;
    }

    public CTeNotaInfoResponsavelTecnico getInformacaoResposavelTecnico() {
        return informacaoResposavelTecnico;
    }

    public CTeNotaInfo setInformacaoResposavelTecnico(CTeNotaInfoResponsavelTecnico informacaoResposavelTecnico) {
        this.informacaoResposavelTecnico = informacaoResposavelTecnico;
        return this;
    }

    public CTeInformacoesNotaFiscalFacil getInformacoesNotaFiscalFacil() {
        return informacoesNotaFiscalFacil;
    }

    public void setInformacoesNotaFiscalFacil(CTeInformacoesNotaFiscalFacil informacoesNotaFiscalFacil) {
        this.informacoesNotaFiscalFacil = informacoesNotaFiscalFacil;
    }

    public CTeInformacoesPAA getInformacoesPAA() {
        return informacoesPAA;
    }

    public void setInformacoesPAA(CTeInformacoesPAA informacoesPAA) {
        this.informacoesPAA = informacoesPAA;
    }
}
