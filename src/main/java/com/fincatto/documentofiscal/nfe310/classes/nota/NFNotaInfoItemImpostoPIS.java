package com.fincatto.documentofiscal.nfe310.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;

public class NFNotaInfoItemImpostoPIS extends DFBase {
    private static final long serialVersionUID = -948777317305298911L;

    @Element(name = "PISAliq", required = false)
    private NFNotaInfoItemImpostoPISAliquota aliquota;

    @Element(name = "PISQtde", required = false)
    private NFNotaInfoItemImpostoPISQuantidade quantidade;

    @Element(name = "PISNT", required = false)
    private NFNotaInfoItemImpostoPISNaoTributado naoTributado;

    @Element(name = "PISOutr", required = false)
    private NFNotaInfoItemImpostoPISOutrasOperacoes outrasOperacoes;

    public NFNotaInfoItemImpostoPIS() {
        this.aliquota = null;
        this.quantidade = null;
        this.naoTributado = null;
        this.outrasOperacoes = null;
    }

    public void setAliquota(final NFNotaInfoItemImpostoPISAliquota aliquota) {
        if (this.quantidade != null || this.naoTributado != null || this.outrasOperacoes != null) {
            throw new IllegalStateException("Aliquota, quantidade, nao tributado e outras operacoes sao mutuamente exclusivos");
        }
        this.aliquota = aliquota;
    }

    public void setQuantidade(final NFNotaInfoItemImpostoPISQuantidade quantidade) {
        if (this.aliquota != null || this.naoTributado != null || this.outrasOperacoes != null) {
            throw new IllegalStateException("Aliquota, quantidade, nao tributado e outras operacoes sao mutuamente exclusivos");
        }
        this.quantidade = quantidade;
    }

    public void setNaoTributado(final NFNotaInfoItemImpostoPISNaoTributado naoTributado) {
        if (this.aliquota != null || this.quantidade != null || this.outrasOperacoes != null) {
            throw new IllegalStateException("Aliquota, quantidade, nao tributado e outras operacoes sao mutuamente exclusivos");
        }
        this.naoTributado = naoTributado;
    }

    public void setOutrasOperacoes(final NFNotaInfoItemImpostoPISOutrasOperacoes outrasOperacoes) {
        if (this.aliquota != null || this.quantidade != null || this.naoTributado != null) {
            throw new IllegalStateException("Aliquota, quantidade, nao tributado e outras operacoes sao mutuamente exclusivos");
        }
        this.outrasOperacoes = outrasOperacoes;
    }

    public NFNotaInfoItemImpostoPISAliquota getAliquota() {
        return this.aliquota;
    }

    public NFNotaInfoItemImpostoPISQuantidade getQuantidade() {
        return this.quantidade;
    }

    public NFNotaInfoItemImpostoPISNaoTributado getNaoTributado() {
        return this.naoTributado;
    }

    public NFNotaInfoItemImpostoPISOutrasOperacoes getOutrasOperacoes() {
        return this.outrasOperacoes;
    }
}