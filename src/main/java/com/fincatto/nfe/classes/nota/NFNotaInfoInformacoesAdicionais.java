package com.fincatto.nfe.classes.nota;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import com.fincatto.nfe.classes.NFBase;

public class NFNotaInfoInformacoesAdicionais extends NFBase {
    @Element(name = "infAdFisco", required = true)
    private String informacoesAdicionaisInteresseFisco;

    @Element(name = "infCpl", required = true)
    private String informacoesComplementaresInteresseContribuinte;

    @ElementList(entry = "obsCont", inline = true, required = false)
    private List<NFNotaInfoObservacaoContribuinte> observacoesContribuinte;

    @ElementList(entry = "obsFisco", inline = true, required = false)
    private List<NFNotaInfoObservacaoFisco> observacoesFisco;

    @ElementList(entry = "procRef", inline = true, required = false)
    private List<NFNotaInfoProcessoReferenciado> processosRefenciado;

    public String getInformacoesAdicionaisInteresseFisco() {
        return this.informacoesAdicionaisInteresseFisco;
    }

    public void setInformacoesAdicionaisInteresseFisco(final String informacoesAdicionaisInteresseFisco) {
        this.informacoesAdicionaisInteresseFisco = informacoesAdicionaisInteresseFisco;
    }

    public String getInformacoesComplementaresInteresseContribuinte() {
        return this.informacoesComplementaresInteresseContribuinte;
    }

    public void setInformacoesComplementaresInteresseContribuinte(final String informacoesComplementaresInteresseContribuinte) {
        this.informacoesComplementaresInteresseContribuinte = informacoesComplementaresInteresseContribuinte;
    }

    public List<NFNotaInfoObservacaoContribuinte> getObservacoesContribuinte() {
        return this.observacoesContribuinte;
    }

    public void setObservacoesContribuinte(final List<NFNotaInfoObservacaoContribuinte> observacoesContribuinte) {
        this.observacoesContribuinte = observacoesContribuinte;
    }

    public List<NFNotaInfoObservacaoFisco> getObservacoesFisco() {
        return this.observacoesFisco;
    }

    public void setObservacoesFisco(final List<NFNotaInfoObservacaoFisco> observacoesFisco) {
        this.observacoesFisco = observacoesFisco;
    }

    public List<NFNotaInfoProcessoReferenciado> getProcessosRefenciado() {
        return this.processosRefenciado;
    }

    public void setProcessosRefenciado(final List<NFNotaInfoProcessoReferenciado> processosRefenciado) {
        this.processosRefenciado = processosRefenciado;
    }
}