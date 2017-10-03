package com.fincatto.documentofiscal.cte200.classes.cte;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;

@Root(name = "compl")
public class CTInfoComplementares extends DFBase {
    private static final long serialVersionUID = 7923086023597656069L;

    @Element(name = "xCaracAd", required = false)
    private String caracteristicaAdicionalTransporte;

    @Element(name = "xCaracSer", required = false)
    private String caracteristicaAdicionalServico;

    @Element(name = "xEmi", required = false)
    private String nomeEmissor;

    @Element(name = "fluxo", required = false)
    private CTInfoPrevisaoFluxo previsaoFluxo;

    @Element(name = "Entrega", required = false)
    private CTInfoPrevisaoEntrega entrega;

    @Element(name = "origCalc", required = false)
    private String descricaoMunicipioOrigemCalculoFrete;

    @Element(name = "destCalc", required = false)
    private String descricaoMunicipioDestinoCalculoFrete;

    @Element(name = "xObs", required = false)
    private String observacao;

    @ElementList(name = "ObsCont", inline = true, required = false)
    private List<CTInfoObservacaoContribuinte> observacoesContribuinte;

    @ElementList(name = "ObsFisco", inline = true, required = false)
    private List<CTInfoObservacaoFisco> observacaoFisco;

    public String getCaracteristicaAdicionalTransporte() {
        return this.caracteristicaAdicionalTransporte;
    }

    public void setCaracteristicaAdicionalTransporte(final String caracteristicaAdicionalTransporte) {
        this.caracteristicaAdicionalTransporte = caracteristicaAdicionalTransporte;
    }

    public String getCaracteristicaAdicionalServico() {
        return this.caracteristicaAdicionalServico;
    }

    public void setCaracteristicaAdicionalServico(final String caracteristicaAdicionalServico) {
        this.caracteristicaAdicionalServico = caracteristicaAdicionalServico;
    }

    public String getNomeEmissor() {
        return this.nomeEmissor;
    }

    public void setNomeEmissor(final String nomeEmissor) {
        this.nomeEmissor = nomeEmissor;
    }

    public CTInfoPrevisaoFluxo getPrevisaoFluxo() {
        return this.previsaoFluxo;
    }

    public void setPrevisaoFluxo(final CTInfoPrevisaoFluxo previsaoFluxo) {
        this.previsaoFluxo = previsaoFluxo;
    }

    public CTInfoPrevisaoEntrega getEntrega() {
        return this.entrega;
    }

    public void setEntrega(final CTInfoPrevisaoEntrega entrega) {
        this.entrega = entrega;
    }

    public String getDescricaoMunicipioOrigemCalculoFrete() {
        return this.descricaoMunicipioOrigemCalculoFrete;
    }

    public void setDescricaoMunicipioOrigemCalculoFrete(final String descricaoMunicipioOrigemCalculoFrete) {
        this.descricaoMunicipioOrigemCalculoFrete = descricaoMunicipioOrigemCalculoFrete;
    }

    public String getDescricaoMunicipioDestinoCalculoFrete() {
        return this.descricaoMunicipioDestinoCalculoFrete;
    }

    public void setDescricaoMunicipioDestinoCalculoFrete(final String descricaoMunicipioDestinoCalculoFrete) {
        this.descricaoMunicipioDestinoCalculoFrete = descricaoMunicipioDestinoCalculoFrete;
    }

    public String getObservacao() {
        return this.observacao;
    }

    public void setObservacao(final String observacao) {
        this.observacao = observacao;
    }

    public List<CTInfoObservacaoContribuinte> getObservacoesContribuinte() {
        return this.observacoesContribuinte;
    }

    public void setObservacoesContribuinte(final List<CTInfoObservacaoContribuinte> observacoesContribuinte) {
        this.observacoesContribuinte = observacoesContribuinte;
    }

    public List<CTInfoObservacaoFisco> getObservacaoFisco() {
        return this.observacaoFisco;
    }

    public void setObservacaoFisco(final List<CTInfoObservacaoFisco> observacaoFisco) {
        this.observacaoFisco = observacaoFisco;
    }

}