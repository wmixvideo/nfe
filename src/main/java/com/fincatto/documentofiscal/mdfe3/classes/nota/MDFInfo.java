package com.fincatto.documentofiscal.mdfe3.classes.nota;

import java.util.List;

import org.simpleframework.xml.*;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFListValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;

/**
 * Created by Eldevan Nery Junior on 03/11/17. Informações do MDF-e.
 */
@Root(name = "infMDFe")
@Namespace(reference = "http://www.portalfiscal.inf.br/mdfe")
public class MDFInfo extends DFBase {

    private static final long serialVersionUID = 5215463851140624452L;

    public static final String IDENT = "MDFe";

    @Attribute(name = "Id")
    private String identificador;
    /**
     * Tipo Versão do MDF-e - 3.00.
     */
    @Attribute(name = "versao")
    private String versao = MDFe.VERSAO;

    @Element(name = "ide")
    private MDFInfoIdentificacao identificacao;

    @Element(name = "emit")
    private MDFInfoEmitente emitente;

    @Element(name = "infModal")
    private MDFInfoModal mdfInfoModal;

    /**
     * Informações dos Documentos fiscais vinculados ao manifesto.
     */
    @Element(name = "infDoc")
    private MDFInfoInformacoesDocumentos informacoesDocumentos;

    @ElementList(name = "seg", inline = true, required = false)
    private List<MDFInfoSeguro> seguro;
    
    @ElementList(name = "prodPred", inline = true, required = false)
    private List<MDFInfoProdutoPredominante> prodPred;

    @Element(name = "tot")
    private MDFInfoTotal infoTotal;

    @ElementList(entry = "lacres", inline = true, required = false)
    private List<MDFInfoLacre1A60> lacres;

    @ElementList(name = "autXML", inline = true, required = false)
    private List<MDFInfoAutorizacaoDownload> autorizacaoDownload;

    @Element(name = "infAdic", required = false)
    private MDFInfoInformacoesAdicionais informacoesAdicionais;

    @Element(name = "infRespTec", required = false)
    private MDFRespTec infRespTec;
    
    /**
     * Grupo de informações do pedido de emissão da NFF
     */
    @Element(name = "infSolicNFF", required = false)
    private MDFInfSolicNFF infSolicNFF;

    public String getIdentificador() {
        return this.identificador;
    }

    /**
     * Identificador da tag a ser assinada<br>
     * Informar a chave de acesso do MDF-e e precedida do literal "MDFe"
     */
    public void setIdentificador(final String identificador) {
        DFStringValidador.exatamente44N(identificador, "Identificador");
        this.identificador = MDFInfo.IDENT + identificador;
    }

    /**
     * Retorna a chave de acesso a partir do identificador.
     *
     * @return Chave de acesso.
     */
    public String getChaveAcesso() {
        return this.identificador.replace(MDFInfo.IDENT, "");
    }

    public MDFInfoIdentificacao getIdentificacao() {
        return this.identificacao;
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

    public List<MDFInfoAutorizacaoDownload> getAutorizacaoDownload() {
        return this.autorizacaoDownload;
    }

    /**
     * Autorizados para download do XML do DF-e<br>
     * Informar CNPJ ou CPF. Preencher os zeros não significativos.
     */
    public void setAutorizacaoDownload(final List<MDFInfoAutorizacaoDownload> autorizacaoDownload) {
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
        DFStringValidador.equals(MDFe.VERSAO, versao);
        this.versao = versao;
    }

    public void setIdentificacao(final MDFInfoIdentificacao identificacao) {
        this.identificacao = identificacao;
    }

    public MDFInfoModal getMdfInfoModal() {
        return this.mdfInfoModal;
    }

    public void setMdfInfoModal(final MDFInfoModal mdfInfoModal) {
        this.mdfInfoModal = mdfInfoModal;
    }

    public MDFInfoInformacoesDocumentos getInformacoesDocumentos() {
        return this.informacoesDocumentos;
    }

    public void setInformacoesDocumentos(final MDFInfoInformacoesDocumentos informacoesDocumentos) {
        this.informacoesDocumentos = informacoesDocumentos;
    }

    public MDFInfoTotal getInfoTotal() {
        return this.infoTotal;
    }

    public void setInfoTotal(final MDFInfoTotal infoTotal) {
        this.infoTotal = infoTotal;
    }

    public List<MDFInfoLacre1A60> getLacres() {
        return this.lacres;
    }

    public void setLacres(final List<MDFInfoLacre1A60> lacres) {
        this.lacres = lacres;
    }

    public MDFInfoInformacoesAdicionais getInformacoesAdicionais() {
        return this.informacoesAdicionais;
    }

    public void setInformacoesAdicionais(final MDFInfoInformacoesAdicionais informacoesAdicionais) {
        this.informacoesAdicionais = informacoesAdicionais;
    }

    public MDFRespTec getInfRespTec() {
        return infRespTec;
    }

    public void setInfRespTec(final MDFRespTec infRespTec) {
        this.infRespTec = infRespTec;
    }

    public List<MDFInfoSeguro> getSeguro() {
        return this.seguro;
    }

    public void setSeguro(final List<MDFInfoSeguro> seguro) {
        this.seguro = seguro;
    }

    public List<MDFInfoProdutoPredominante> getProdPred() {
        return prodPred;
    }

    public void setProdPred(List<MDFInfoProdutoPredominante> prodPred) {
        this.prodPred = prodPred;
    }

    public MDFInfSolicNFF getInfSolicNFF() {
        return infSolicNFF;
    }

    public void setInfSolicNFF(MDFInfSolicNFF infSolicNFF) {
        this.infSolicNFF = infSolicNFF;
    }

}
