package com.fincatto.documentofiscal.cte200.classes.cte;

import java.util.List;

import org.simpleframework.xml.*;

import com.fincatto.documentofiscal.DFBase;

@Root(name = "infCte")
@Namespace(reference = "http://www.portalfiscal.inf.br/cte")
public class CTInfo extends DFBase {
    private static final long serialVersionUID = -6897300761081884794L;

    @Attribute(name = "versao")
    private String versao;

    @Attribute(name = "Id")
    private String id;

    @Element(name = "ide")
    private CTInfoIdentificador identificador;

    @Element(name = "compl", required = false)
    private CTInfoComplementares dadosComplementares;

    @Element(name = "emit")
    private CTInfoEmitente emitente;

    @Element(name = "rem", required = false)
    private CTInfoRemetente remetente;

    @Element(name = "exped", required = false)
    private CTInfoExpedidor expedidor;

    @Element(name = "receb", required = false)
    private CTInfoRecebedor recebedor;

    @Element(name = "dest", required = false)
    private CTInfoDestinatario destinatario;

    @Element(name = "vPrest")
    private CTInfoValoresPrestacaoServico totalPrestacaoServico;

    @Element(name = "imp")
    private CTInfoImposto imposto;

    @Element(name = "infCTeNorm", required = false)
    private CTInfoNormal informacaoCte;

    @Element(name = "infCteComp", required = false)
    private CTInfoCteComplementado detalhamentoComplemento;

    @Element(name = "infCteAnu", required = false)
    private CTInfoAnulacao detalhamentoAnulacao;

    @ElementList(name = "autXML", inline = true, required = false)
    private List<CTInfoAutorizadoXML> autorizadosDownload;

    public String getVersao() {
        return this.versao;
    }

    public void setVersao(final String versao) {
        this.versao = versao;
    }

    public String getId() {
        return this.id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public CTInfoIdentificador getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(final CTInfoIdentificador identificador) {
        this.identificador = identificador;
    }

    public CTInfoComplementares getDadosComplementares() {
        return this.dadosComplementares;
    }

    public void setDadosComplementares(final CTInfoComplementares dadosComplementares) {
        this.dadosComplementares = dadosComplementares;
    }

    public CTInfoEmitente getEmitente() {
        return this.emitente;
    }

    public void setEmitente(final CTInfoEmitente emitente) {
        this.emitente = emitente;
    }

    public CTInfoRemetente getRemetente() {
        return this.remetente;
    }

    public void setRemetente(final CTInfoRemetente remetente) {
        this.remetente = remetente;
    }

    public CTInfoExpedidor getExpedidor() {
        return this.expedidor;
    }

    public void setExpedidor(final CTInfoExpedidor expedidor) {
        this.expedidor = expedidor;
    }

    public CTInfoRecebedor getRecebedor() {
        return this.recebedor;
    }

    public void setRecebedor(final CTInfoRecebedor recebedor) {
        this.recebedor = recebedor;
    }

    public CTInfoDestinatario getDestinatario() {
        return this.destinatario;
    }

    public void setDestinatario(final CTInfoDestinatario destinatario) {
        this.destinatario = destinatario;
    }

    public CTInfoValoresPrestacaoServico getTotalPrestacaoServico() {
        return this.totalPrestacaoServico;
    }

    public void setTotalPrestacaoServico(final CTInfoValoresPrestacaoServico totalPrestacaoServico) {
        this.totalPrestacaoServico = totalPrestacaoServico;
    }

    public CTInfoImposto getImposto() {
        return this.imposto;
    }

    public void setImposto(final CTInfoImposto imposto) {
        this.imposto = imposto;
    }

    public CTInfoNormal getInformacaoCte() {
        return this.informacaoCte;
    }

    public void setInformacaoCte(final CTInfoNormal informacaoCte) {
        this.informacaoCte = informacaoCte;
    }

    public CTInfoCteComplementado getDetalhamentoComplemento() {
        return this.detalhamentoComplemento;
    }

    public void setDetalhamentoComplemento(final CTInfoCteComplementado detalhamentoComplemento) {
        this.detalhamentoComplemento = detalhamentoComplemento;
    }

    public CTInfoAnulacao getDetalhamentoAnulacao() {
        return this.detalhamentoAnulacao;
    }

    public void setDetalhamentoAnulacao(final CTInfoAnulacao detalhamentoAnulacao) {
        this.detalhamentoAnulacao = detalhamentoAnulacao;
    }

    public List<CTInfoAutorizadoXML> getAutorizadosDownload() {
        return this.autorizadosDownload;
    }

    public void setAutorizadosDownload(final List<CTInfoAutorizadoXML> autorizadosDownload) {
        this.autorizadosDownload = autorizadosDownload;
    }

}
