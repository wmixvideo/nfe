package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.simpleframework.xml.ElementList;

import java.util.List;

public class NFNotaInfoItemObservacao {

    @ElementList(entry = "obsCont", inline = true, required = false)
    private List<NFNotaInfoObservacao> observacoesContribuinte;

    @ElementList(entry = "obsFisco", inline = true, required = false)
    private List<NFNotaInfoObservacao> observacoesFisco;

    public List<NFNotaInfoObservacao> getObservacoesContribuinte() {
        return observacoesContribuinte;
    }

    public void setObservacoesContribuinte(
        final List<NFNotaInfoObservacao> observacoesContribuinte) {
        this.observacoesContribuinte = observacoesContribuinte;
    }

    public List<NFNotaInfoObservacao> getObservacoesFisco() {
        return observacoesFisco;
    }

    public void setObservacoesFisco(
        final List<NFNotaInfoObservacao> observacoesFisco) {
        this.observacoesFisco = observacoesFisco;
    }
}