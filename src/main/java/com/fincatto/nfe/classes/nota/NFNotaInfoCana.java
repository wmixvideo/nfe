package com.fincatto.nfe.classes.nota;

import java.util.List;

import org.joda.time.LocalDate;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import com.fincatto.nfe.classes.NFBase;

public class NFNotaInfoCana extends NFBase {
    @Element(name = "safra", required = true)
    private String safra;

    @Element(name = "ref", required = true)
    private LocalDate referencia;

    @ElementList(entry = "forDia", inline = true, required = true)
    private List<NFNotaInfoCanaFornecimentoDiario> fornecimentosDiario;

    @ElementList(entry = "deduc", inline = true, required = false)
    private List<NFNotaInfoCanaDeducao> deducoes;

    public String getSafra() {
        return this.safra;
    }

    public void setSafra(final String safra) {
        this.safra = safra;
    }

    public LocalDate getReferencia() {
        return this.referencia;
    }

    public void setReferencia(final LocalDate referencia) {
        this.referencia = referencia;
    }

    public List<NFNotaInfoCanaFornecimentoDiario> getFornecimentosDiario() {
        return this.fornecimentosDiario;
    }

    public void setFornecimentosDiario(final List<NFNotaInfoCanaFornecimentoDiario> fornecimentosDiario) {
        this.fornecimentosDiario = fornecimentosDiario;
    }

    public List<NFNotaInfoCanaDeducao> getDeducoes() {
        return this.deducoes;
    }

    public void setDeducoes(final List<NFNotaInfoCanaDeducao> deducoes) {
        this.deducoes = deducoes;
    }
}