package com.fincatto.nfe.classes.nota;

import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.validadores.ListValidador;
import com.fincatto.nfe.validadores.StringValidador;

public class NFNotaInfoCana extends NFBase {
    @Element(name = "safra", required = true)
    private String safra;

    @Element(name = "ref", required = true)
    private String referencia;

    @ElementList(entry = "forDia", inline = true, required = true)
    private List<NFNotaInfoCanaFornecimentoDiario> fornecimentosDiario;

    @ElementList(entry = "deduc", inline = true, required = false)
    private List<NFNotaInfoCanaDeducao> deducoes;

    public String getSafra() {
        return this.safra;
    }

    public void setSafra(final String safra) {
        if (safra.length() != 4 && safra.length() != 9) {
            throw new IllegalStateException("Tamanho invalido");
        }

        final Pattern pattern = safra.length() == 4 ? Pattern.compile("[0-9]{4}") : Pattern.compile("[0-9]{4}/[0-9]{4}");
        final Matcher matcher = pattern.matcher(safra);
        if (!matcher.find()) {
            throw new IllegalStateException("Padrao invalido");
        }

        this.safra = safra;
    }

    public String getReferencia() {
        return this.referencia;
    }

    public void setReferencia(final String referencia) {
        StringValidador.mmaaaa(referencia);
        this.referencia = referencia;
    }

    public List<NFNotaInfoCanaFornecimentoDiario> getFornecimentosDiario() {
        return Collections.unmodifiableList(this.fornecimentosDiario);
    }

    public void setFornecimentosDiario(final List<NFNotaInfoCanaFornecimentoDiario> fornecimentosDiario) {
        ListValidador.tamanho31Obrigatorio(fornecimentosDiario);
        this.fornecimentosDiario = fornecimentosDiario;
    }

    public List<NFNotaInfoCanaDeducao> getDeducoes() {
        return Collections.unmodifiableList(this.deducoes);
    }

    public void setDeducoes(final List<NFNotaInfoCanaDeducao> deducoes) {
        ListValidador.tamanho10(deducoes);
        this.deducoes = deducoes;
    }
}