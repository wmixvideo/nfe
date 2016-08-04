package com.fincatto.nfe.core.nota;

import com.fincatto.nfe.core.NFBase;
import com.fincatto.nfe.core.validadores.ListValidador;
import com.fincatto.nfe.core.validadores.StringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.List;

public class NFNotaInfoInformacoesAdicionais extends NFBase {
    @Element(name = "infAdFisco", required = false)
    private String informacoesAdicionaisInteresseFisco;

    @Element(name = "infCpl", required = false)
    private String informacoesComplementaresInteresseContribuinte;

    @ElementList(entry = "obsCont", inline = true, required = false)
    private List<NFNotaInfoObservacao> observacoesContribuinte;

    @ElementList(entry = "obsFisco", inline = true, required = false)
    private List<NFNotaInfoObservacao> observacoesFisco;

    @ElementList(entry = "procRef", inline = true, required = false)
    private List<NFNotaInfoProcessoReferenciado> processosRefenciado;

    public void setInformacoesAdicionaisInteresseFisco(final String informacoesAdicionaisInteresseFisco) {
        StringValidador.tamanho2000(informacoesAdicionaisInteresseFisco, "Informacoes Adicionais Interesse Fisco");
        this.informacoesAdicionaisInteresseFisco = informacoesAdicionaisInteresseFisco;
    }

    public void setInformacoesComplementaresInteresseContribuinte(final String informacoesComplementaresInteresseContribuinte) {
        StringValidador.tamanho5000(informacoesComplementaresInteresseContribuinte, "Informacoes Adicionais Interesse Contribuinte");
        this.informacoesComplementaresInteresseContribuinte = informacoesComplementaresInteresseContribuinte;
    }

    public void setObservacoesContribuinte(final List<NFNotaInfoObservacao> observacoesContribuinte) {
        ListValidador.tamanho10(observacoesContribuinte, "Observacoes Contribuinte");
        this.observacoesContribuinte = observacoesContribuinte;
    }

    public void setObservacoesFisco(final List<NFNotaInfoObservacao> observacoesFisco) {
        ListValidador.tamanho10(observacoesFisco, "Observacoes Fisco");
        this.observacoesFisco = observacoesFisco;
    }

    public void setProcessosRefenciado(final List<NFNotaInfoProcessoReferenciado> processosRefenciado) {
        ListValidador.tamanho100(processosRefenciado, "Processos Referenciados");
        this.processosRefenciado = processosRefenciado;
    }

    public String getInformacoesAdicionaisInteresseFisco() {
        return this.informacoesAdicionaisInteresseFisco;
    }

    public String getInformacoesComplementaresInteresseContribuinte() {
        return this.informacoesComplementaresInteresseContribuinte;
    }

    public List<NFNotaInfoObservacao> getObservacoesContribuinte() {
        return this.observacoesContribuinte;
    }

    public List<NFNotaInfoObservacao> getObservacoesFisco() {
        return this.observacoesFisco;
    }

    public List<NFNotaInfoProcessoReferenciado> getProcessosRefenciado() {
        return this.processosRefenciado;
    }
}