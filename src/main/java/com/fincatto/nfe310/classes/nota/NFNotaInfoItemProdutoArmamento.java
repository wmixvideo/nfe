package com.fincatto.nfe310.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.classes.NFNotaInfoItemProdutoArmamentoTipo;
import com.fincatto.nfe310.validadores.StringValidador;

public class NFNotaInfoItemProdutoArmamento extends NFBase {

    @Element(name = "tpArma", required = true)
    private NFNotaInfoItemProdutoArmamentoTipo tipo;

    @Element(name = "nSerie", required = true)
    private String numeroSerieArma;

    @Element(name = "nCano", required = true)
    private String numeroSerieCano;

    @Element(name = "descr", required = true)
    private String descricao;

    public void setTipo(final NFNotaInfoItemProdutoArmamentoTipo tipo) {
        this.tipo = tipo;
    }

    public void setNumeroSerieArma(final String numeroSerieArma) {
        StringValidador.tamanho15(numeroSerieArma);
        this.numeroSerieArma = numeroSerieArma;
    }

    public void setNumeroSerieCano(final String numeroSerieCano) {
        StringValidador.tamanho15(numeroSerieCano);
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