package com.fincatto.documentofiscal.cte200.classes.cte;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import com.fincatto.documentofiscal.DFBase;

public class CTInfoNormal extends DFBase {
    private static final long serialVersionUID = -3910233186856567020L;

    @Element(name = "infCarga")
    private CTInfoCarga carga;

    @Element(name = "infDoc")
    private CTInfoDocumento documento;

    @Element(name = "docAnt", required = false)
    private CTInfoDocumentoAnterior documentoAnterior;

    @Element(name = "seg", required = false)
    private CTInfoSeguro seguro;

    @Element(name = "infModal")
    private CTInfoModal informacoesModal;

    @Element(name = "peri", required = false)
    private CTInfoCargaPerigosa cargaPerigosa;

    @ElementList(name = "veicNovos", inline = true, required = false)
    private List<CTInfoVeiculosNovos> veiculosNovos;

    @Element(name = "cobr", required = false)
    private CTInfoCobranca cobr;

    @Element(name = "infCteSub", required = false)
    private CTInfoSubstituicao substituicao;

    public CTInfoCarga getCarga() {
        return this.carga;
    }

    public void setCarga(final CTInfoCarga carga) {
        this.carga = carga;
    }

    public CTInfoDocumento getDocumento() {
        return this.documento;
    }

    public void setDocumento(final CTInfoDocumento documento) {
        this.documento = documento;
    }

    public CTInfoDocumentoAnterior getDocumentoAnterior() {
        return this.documentoAnterior;
    }

    public void setDocumentoAnterior(final CTInfoDocumentoAnterior documentoAnterior) {
        this.documentoAnterior = documentoAnterior;
    }

    public CTInfoSeguro getSeguro() {
        return this.seguro;
    }

    public void setSeguro(final CTInfoSeguro seguro) {
        this.seguro = seguro;
    }

    public CTInfoModal getInformacoesModal() {
        return this.informacoesModal;
    }

    public void setInformacoesModal(final CTInfoModal informacoesModal) {
        this.informacoesModal = informacoesModal;
    }

    public CTInfoCargaPerigosa getCargaPerigosa() {
        return this.cargaPerigosa;
    }

    public void setCargaPerigosa(final CTInfoCargaPerigosa cargaPerigosa) {
        this.cargaPerigosa = cargaPerigosa;
    }

    public List<CTInfoVeiculosNovos> getVeiculosNovos() {
        return this.veiculosNovos;
    }

    public void setVeiculosNovos(final List<CTInfoVeiculosNovos> veiculosNovos) {
        this.veiculosNovos = veiculosNovos;
    }

    public CTInfoCobranca getCobr() {
        return this.cobr;
    }

    public void setCobr(final CTInfoCobranca cobr) {
        this.cobr = cobr;
    }

    public CTInfoSubstituicao getSubstituicao() {
        return this.substituicao;
    }

    public void setSubstituicao(final CTInfoSubstituicao substituicao) {
        this.substituicao = substituicao;
    }

}
