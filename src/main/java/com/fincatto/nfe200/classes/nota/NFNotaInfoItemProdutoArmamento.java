package com.fincatto.nfe200.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.nfe200.classes.NFBase;
import com.fincatto.nfe200.classes.NFNotaInfoItemProdutoArmamentoTipo;
import com.fincatto.nfe200.validadores.StringValidador;

public class NFNotaInfoItemProdutoArmamento extends NFBase {

    @Element(name = "tpArma", required = true)
    private NFNotaInfoItemProdutoArmamentoTipo tipo;

    @Element(name = "nSerie", required = true)
    private String numeroSerieArma;

    @Element(name = "nCano", required = true)
    private String numeroSerieCano;

    @Element(name = "descr", required = true)
    private String descricao;

    public NFNotaInfoItemProdutoArmamento() {
        this.tipo = null;
        this.numeroSerieArma = null;
        this.numeroSerieCano = null;
        this.descricao = null;
    }

    public void setTipo(final NFNotaInfoItemProdutoArmamentoTipo tipo) {
        this.tipo = tipo;
    }

    public void setNumeroSerieArma(final String numeroSerieArma) {
        StringValidador.tamanho9(numeroSerieArma);
        this.numeroSerieArma = numeroSerieArma;
    }

    public void setNumeroSerieCano(final String numeroSerieCano) {
        StringValidador.tamanho9(numeroSerieCano);
        this.numeroSerieCano = numeroSerieCano;
    }

    public void setDescricao(final String descricao) {
        StringValidador.tamanho256(descricao);
        this.descricao = descricao;
    }

    public NFNotaInfoItemProdutoArmamentoTipo getTipo() {
        return this.tipo;
    }

    public String getNumeroSerieArma() {
        return this.numeroSerieArma;
    }

    public String getNumeroSerieCano() {
        return this.numeroSerieCano;
    }

    public String getDescricao() {
        return this.descricao;
    }
}