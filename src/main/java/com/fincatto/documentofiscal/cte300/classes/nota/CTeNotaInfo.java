package com.fincatto.documentofiscal.cte300.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.ListValidador;
import com.fincatto.documentofiscal.validadores.StringValidador;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * @author Caio
 * @info Informações do CT-e
 */

@Root(name = "infCte")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTeNotaInfo extends DFBase {
    private static final long serialVersionUID = 7580534488249283958L;

    public static final String IDENT = "CTe";

    @Attribute(name = "Id", required = true)
    private String identificador;

    @Element(name = "ide", required = true)
    private CTeNotaInfoIdentificacao identificacao;

    @Element(name = "compl", required = false)
    private CTeNotaInfoDadosComplementares dadosComplementares;

    @Element(name = "emit", required = true)
    private CTeNotaInfoEmitente emitente;

    @Element(name = "rem", required = false)
    private CTeNotaInfoRemetente remetente;

    @Element(name = "exped", required = false)
    private CTeNotaInfoExpedidorCarga expedidorCarga;

    @Element(name = "receb", required = false)
    private CTeNotaInfoRecebedorCarga recebedorCarga;

    @Element(name = "dest", required = false)
    private CTeNotaInfoDestinatario destinatario;

    @Element(name = "vPrest", required = true)
    private CTeNotaInfoValorPrestacaoServico valorPrestacaoServico;

    @Element(name = "imp", required = true)
    private CTeNotaInfoInformacoesRelativasImpostos informacoesRelativasImpostos;

    @Element(name = "infCTeNorm", required = false)
    private CTeNotaInfoCTeNormal cteNormal;

    @Element(name = "infCteComp", required = false)
    private CTeNotaInfoCTeComplementar cteComplementar;

    @Element(name = "infCteAnu", required = false)
    private CTeNotaInfoCTeAnulacao cteAnulacao;

    @ElementList(name = "autXML", inline = true, required = false)
    private List<CTeNotaInfoAutorizacaoDownload> autorizacaoDownload;

    @Attribute(name = "versao", required = true)
    private String versao;

    public CTeNotaInfo() {
        this.identificacao = null;
        this.dadosComplementares = null;
        this.emitente = null;
        this.remetente = null;
        this.expedidorCarga = null;
        this.recebedorCarga = null;
        this.destinatario = null;
        this.valorPrestacaoServico = null;
        this.informacoesRelativasImpostos = null;
        this.cteNormal = null;
        this.cteComplementar = null;
        this.cteAnulacao = null;
        this.autorizacaoDownload = null;
        this.versao = null;
        this.identificador = null;
    }

    public String getIdentificador() {
        return this.identificador;
    }

    /**
     * Identificador da tag a ser assinada<br>
     * Informar a chave de acesso do CT-e e precedida do literal "CTe"
     */
    public void setIdentificador(final String identificador) {
        StringValidador.exatamente44N(identificador, "Identificador");
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

    public CTeNotaInfoCTeComplementar getCteComplementar() {
        return this.cteComplementar;
    }

    /**
     * Detalhamento do CT-e complementado
     */
    public void setCteComplementar(final CTeNotaInfoCTeComplementar cteComplementar) {
        this.cteComplementar = cteComplementar;
    }

    public CTeNotaInfoCTeAnulacao getCteAnulacao() {
        return this.cteAnulacao;
    }

    /**
     * Detalhamento do CT-e do tipo Anulação
     */
    public void setCteAnulacao(final CTeNotaInfoCTeAnulacao cteAnulacao) {
        this.cteAnulacao = cteAnulacao;
    }

    public List<CTeNotaInfoAutorizacaoDownload> getAutorizacaoDownload() {
        return this.autorizacaoDownload;
    }

    /**
     * Autorizados para download do XML do DF-e<br>
     * Informar CNPJ ou CPF. Preencher os zeros não significativos.
     */
    public void setAutorizacaoDownload(final List<CTeNotaInfoAutorizacaoDownload> autorizacaoDownload) {
        ListValidador.tamanho10(autorizacaoDownload, "Autorizados para download do XML do DF-e");
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

}
