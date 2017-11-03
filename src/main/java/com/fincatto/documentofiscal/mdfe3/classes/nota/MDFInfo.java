package com.fincatto.documentofiscal.mdfe3.classes.nota;

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
 * Created by Eldevan Nery Junior on 03/11/17.
 *
 */
@Root(name = "infMdfe")
@Namespace(reference = "http://www.portalfiscal.inf.br/mdfe")
public class MDFInfo extends DFBase {

    public static final String IDENT = "MDF";

    @Attribute(name = "versao", required = true)
    private String versao;
    
    @Attribute(name = "Id", required = true)
    private String identificador;

    @Element(name = "ide", required = true)
    private MDFInfoIdentificacao identificacao;

    @Element(name = "compl", required = false)
    private MDFInfoDadosComplementares dadosComplementares;

    @Element(name = "emit", required = true)
    private MDFInfoEmitente emitente;

    @Element(name = "rem", required = false)
    private MDFInfoRemetente remetente;

    @Element(name = "exped", required = false)
    private MDFInfoExpedidorCarga expedidorCarga;

    @Element(name = "receb", required = false)
    private MDFInfoRecebedorCarga recebedorCarga;

    @Element(name = "dest", required = false)
    private MDFInfoDestinatario destinatario;

    @Element(name = "vPrest", required = true)
    private MDFInfoValorPrestacaoServico valorPrestacaoServico;

    @Element(name = "imp", required = true)
    private MDFInfoInformacoesRelativasImpostos informacoesRelativasImpostos;

    @Element(name = "infMDFNorm", required = false)
    private MDFInfoMDFNormal cteNormal;

    @Element(name = "infMdfeComp", required = false)
    private MDFInfoMDFComplementar cteComplementar;

    @Element(name = "infMdfeAnu", required = false)
    private MDFInfoMDFAnulacao cteAnulacao;

    @ElementList(name = "autXML", inline = true, required = false)
    private List<MDFInfoAutorizacaoDownload> autorizacaoDownload;

    public String getIdentificador() {
        return this.identificador;
    }

    /**
     * Identificador da tag a ser assinada<br>
     * Informar a chave de acesso do MDF-e e precedida do literal "MDF"
     */
    public void setIdentificador(final String identificador) {
        StringValidador.exatamente44N(identificador, "Identificador");
        this.identificador = MDFInfo.IDENT + identificador;
    }

    /**
     * Retorna a chave de acesso a partir do identificador.
     * @return Chave de acesso.
     */
    public String getChaveAcesso() {
        return this.identificador.replace(MDFInfo.IDENT, "");
    }

    public MDFInfoIdentificacao getIdentificacao() {
        return this.identificacao;
    }

    /**
     * Identificação do MDF-e
     */
    public void setIdentificacao(final MDFInfoIdentificacao identificacao) {
        this.identificacao = identificacao;
    }

    public MDFInfoDadosComplementares getDadosComplementares() {
        return this.dadosComplementares;
    }

    /**
     * Dados complementares do MDF-e para fins operacionais ou comerciais
     */
    public void setDadosComplementares(final MDFInfoDadosComplementares dadosComplementares) {
        this.dadosComplementares = dadosComplementares;
    }

    public MDFInfoEmitente getEmitente() {
        return this.emitente;
    }

    /**
     * Identificação do Emitente do MDF-e
     */
    public void setEmitente(final MDFInfoEmitente emitente) {
        this.emitente = emitente;
    }

    public MDFInfoRemetente getRemetente() {
        return this.remetente;
    }

    /**
     * Informações do Remetente das mercadorias transportadas pelo MDF-e<br>
     * Poderá não ser informado para os MDF-e de redespacho intermediário e serviço vinculado a multimodal. Nos demais casos deverá sempre ser informado.
     */
    public void setRemetente(final MDFInfoRemetente remetente) {
        this.remetente = remetente;
    }

    public MDFInfoExpedidorCarga getExpedidorCarga() {
        return this.expedidorCarga;
    }

    /**
     * Informações do Expedidor da Carga
     */
    public void setExpedidorCarga(final MDFInfoExpedidorCarga expedidorCarga) {
        this.expedidorCarga = expedidorCarga;
    }

    public MDFInfoRecebedorCarga getRecebedorCarga() {
        return this.recebedorCarga;
    }

    /**
     * Informações do Recebedor da Carga
     */
    public void setRecebedorCarga(final MDFInfoRecebedorCarga recebedorCarga) {
        this.recebedorCarga = recebedorCarga;
    }

    public MDFInfoDestinatario getDestinatario() {
        return this.destinatario;
    }

    /**
     * Informações do Destinatário do MDF-e<br>
     * Só pode ser omitido em caso de redespacho intermediário
     */
    public void setDestinatario(final MDFInfoDestinatario destinatario) {
        this.destinatario = destinatario;
    }

    public MDFInfoValorPrestacaoServico getValorPrestacaoServico() {
        return this.valorPrestacaoServico;
    }

    /**
     * Valores da Prestação de Serviço
     */
    public void setValorPrestacaoServico(final MDFInfoValorPrestacaoServico valorPrestacaoServico) {
        this.valorPrestacaoServico = valorPrestacaoServico;
    }

    public MDFInfoInformacoesRelativasImpostos getInformacoesRelativasImpostos() {
        return this.informacoesRelativasImpostos;
    }

    /**
     * Informações relativas aos Impostos
     */
    public void setInformacoesRelativasImpostos(final MDFInfoInformacoesRelativasImpostos informacoesRelativasImpostos) {
        this.informacoesRelativasImpostos = informacoesRelativasImpostos;
    }

    public MDFInfoMDFNormal getMdfeNormal() {
        return this.cteNormal;
    }

    /**
     * Grupo de informações do MDF-e Normal e Substituto
     */
    public void setMdfeNormal(final MDFInfoMDFNormal cteNormal) {
        this.cteNormal = cteNormal;
    }

    public MDFInfoMDFComplementar getMdfeComplementar() {
        return this.cteComplementar;
    }

    /**
     * Detalhamento do MDF-e complementado
     */
    public void setMdfeComplementar(final MDFInfoMDFComplementar cteComplementar) {
        this.cteComplementar = cteComplementar;
    }

    public MDFInfoMDFAnulacao getMdfeAnulacao() {
        return this.cteAnulacao;
    }

    /**
     * Detalhamento do MDF-e do tipo Anulação
     */
    public void setMdfeAnulacao(final MDFInfoMDFAnulacao cteAnulacao) {
        this.cteAnulacao = cteAnulacao;
    }

    public List<MDFInfoAutorizacaoDownload> getAutorizacaoDownload() {
        return this.autorizacaoDownload;
    }

    /**
     * Autorizados para download do XML do DF-e<br>
     * Informar CNPJ ou CPF. Preencher os zeros não significativos.
     */
    public void setAutorizacaoDownload(final List<MDFInfoAutorizacaoDownload> autorizacaoDownload) {
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
